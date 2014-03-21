/**
 * An implementation of basic parser combinators using simple generators
 *
 */

package lms.parsing

import lms._
import lms.util._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

trait ReaderParsers extends MyScalaOpsPkg with LiftVariables with StructOps
  with OptionOps with Functions with ReaderParseResultOps
  with BarrierOps with ReaderOps {

  abstract class Parser[+T: Manifest] extends (Rep[Input] => Rep[ParseResult[T]]) { self =>

    private def flatMap[U: Manifest](f: Rep[T] => Parser[U]) = Parser[U] { input: Rep[Input] =>
      val tmp = self(input)
      if (tmp.isEmpty) Failure[U](input)
      else {
        val x = f(tmp.get).apply(tmp.next)
        if (x.isEmpty) Failure[U](input) else x
      }
    }

    def >>[U: Manifest](f: Rep[T] => Parser[U]) = flatMap(f)

    def ~[U: Manifest](that: Parser[U]) = Parser[(T, U)] { input =>
      val x = self(input)
      if (x.isEmpty) Failure[(T, U)](input)
      else {
        val y = that(x.next)
        if (y.isEmpty) Failure[(T, U)](input)
        else Success(make_tuple2(x.get, y.get), y.next)
      }
    }

    def ~>[U: Manifest](that: => Parser[U]) = Parser[U] { input =>
      val x = self(input)
      if (x.isEmpty) Failure[U](input) else that(x.next)
    }

    def <~[U: Manifest](that: => Parser[U]) = Parser[T] { input =>
      val x = self(input)
      if (x.isEmpty) x else {
        val y = that(x.next)
        if (y.isEmpty) Failure[T](input) else Success(x.get, y.next)
      }
    }

    private def map[U: Manifest](f: Rep[T] => Rep[U]) = Parser[U] { pos =>
      self(pos) map f
    }

    def ^^[U: Manifest](f: Rep[T] => Rep[U]) = self.map(f)
    def ^^^[U: Manifest](u: Rep[U]) = self.map(x => u)

    def |[U >: T: Manifest](that: Parser[U]) = {
      val p = Parser[U] { pos =>
        val tmpSelf = toplevel(self)
        val x = tmpSelf(pos)
        if (x.isEmpty) that(pos) else x.asInstanceOf[Rep[ParseResult[U]]]
      }
      toplevel(p)
    }

    def filter(p: Rep[T] => Rep[Boolean]) = Parser[T] { pos =>
      val x = self(pos)
      if (x.isEmpty) x
      else if (p(x.get)) x
      else Failure[T](x.next)
    }

  }

  def Parser[T: Manifest](f: Rep[Input] => Rep[ParseResult[T]]) = new Parser[T] {
    def apply(in: Rep[Input]) = f(in)
  }

  //making a function of a non-recursive parser
  def toplevel[T: Manifest](p: Parser[T]): Parser[T] = {
    val f = doLambda { (i: Rep[Input]) => p(i) }
    val res = Parser[T] { i => f(i) }
    res
  }

  def rep1Fold[T: Manifest, U: Manifest](p: => Parser[U], q: => Parser[T])(f: (Rep[U], Rep[T]) => Rep[U]) = p >> {
    pres =>

    Parser[U] { in =>
      var current = pres
      var continue = unit(true)
      var curInput = in

      while(continue) {
        val progress = q(curInput)
        if(!progress.isEmpty){
          current = f(current, progress.get)
          curInput = progress.next
        } else {
          continue = unit(false)
        }
      }

      Success(current, curInput)

    }
  }

  def repFold[T: Manifest, U: Manifest](p: => Parser[T])(z: Rep[U], f: (Rep[U], Rep[T]) => Rep[U]) = Parser[U] { in =>
    val prep = rep1Fold(p ^^ {x => f(z, x)}, p)(f)
    val atLeastOne = prep(in)

    atLeastOne orElse Success(z, in)
  }


  //rep can be expressed as a fold
  def rep[T: Manifest](p: => Parser[T]) =
    repFold(p)(List[T]().asInstanceOf[Rep[List[T]]],
      { (ls: Rep[List[T]], t: Rep[T]) => ls ++ List(t) }
    )
  /*
  def repsep[T: Manifest, U: Manifest](p: => Parser[T], q: => Parser[U]): Parser[List[T]] =
    (p ~ rep(q ~> p)) ^^ { x => x._1 :: x._2 } | success(List[T]())

  //a 'conditional' parser
  def __ifThenElse[A: Manifest](cond: Rep[Boolean], thenp: => Parser[A], elsep: => Parser[A]): Parser[A] = Parser[A] {
    i => if (cond) thenp(i) else elsep(i)
  }

  def opt[T: Manifest](p: Parser[T]) = Parser[Option[T]] { pos =>
    val x = p(pos)
    if (x.isEmpty) Success(none[T](), x.next)
    else Success(Some(x.get), x.next)
  }

  /**
   * a Success combinator
   */
  def success[T: Manifest](v: Rep[T]) = Parser[T] { i => Success(v, i) }

  // A terminal that return the current reading position
  def pos(in: Rep[Input]) = Parser[Int] { i => Success[Int](i, i) }

 */
}


trait CharReaderParsers extends ReaderParsers with CharOps with StringStructOps
  with StringReaderOps {

  def isLetter(c: Rep[Char]): Rep[Boolean] =
    (c >= unit('a') && c <= unit('z')) ||
      (c >= unit('A') && c <= unit('Z'))

  def isDigit(c: Rep[Char]): Rep[Boolean] =
    c >= unit('0') && c <= unit('9')

  def letter: Parser[Char] = acceptIf((c: Rep[Char]) => isLetter(c))
  def letterIdx = acceptIfIdx((c: Rep[Char]) => isLetter(c))

  def digit: Parser[Char] = acceptIf((c: Rep[Char]) => isDigit(c))
  def digit2Int: Parser[Int] = digit ^^ { c: Rep[Char] => (c - unit('0')).toInt }
  def digitIdx = acceptIfIdx((c: Rep[Char]) => isDigit(c))

  def accept(e: Rep[Elem]): Parser[Char] = acceptIf((c: Rep[Char]) => c == e)

  def acceptIf(p: Rep[Elem] => Rep[Boolean]) = Parser[Char] { in =>
    if (in.atEnd) Failure[Char](in)
    else if (p(in.first)) Success(in.first, in.rest)
    else Failure[Char](in)
  }

  def acceptAll = Parser[Char] { in =>
    if (in.atEnd) Failure[Char](in)
    else Success[Char](in.first, in.rest)
  }

  //acceptIf, returning the index of the element found
  def acceptIdx(e: Rep[Elem]): Parser[Int] = acceptIfIdx((c: Rep[Char]) => c == e)

  def acceptIfIdx(p: Rep[Elem] => Rep[Boolean]) = Parser[Int] { in =>
    if (in.atEnd) Failure[Int](in)
    else if (p(in.first)) Success(in.offset, in.rest)
    else Failure[Int](in)
  }

  def acceptAllIdx = Parser[Int] { in =>
    if (in.atEnd) Failure[Int](in)
    else Success[Int](in.offset, in.rest)
  }

  /*
  // Non empty sequence of characters matching predicate 'p'
  def str(in: Rep[Input], p: Rep[Elem] => Rep[Boolean], empty: Boolean = false) = Parser[StringStruct] { pos: Rep[Int] =>

    val l = in.length
    val e = __newVar(pos)

    while (e < l && p(in(e))) { e += 1 }

    if (empty) Success[StringStruct](String(in, pos, e - pos), e)
    else {
      if (pos == e) Failure[StringStruct](pos)
      else Success[StringStruct](String(in, pos, e - pos), e)
    }
  }
  */
}

/*
trait TokenParsers extends TopDownParsers with CharParsers with StringStructOps {

  def processIdent(s: Rep[String]) =
    if (s == unit("true") || s == unit("null") || s == unit("false")) unit("Keyword(") + s + unit(")")
    else unit("NoToken")

  def keyword(in: Rep[Input]): Parser[String] = letter(in) ~ repToS(letter(in) /*| digit(in)*/ ) ^^ {
    x: Rep[(Char, String)] => processIdent(x._1 + x._2)
  }

  def numeric(in: Rep[Input]): Parser[String] = digit(in) ~ repToS(digit(in)) ^^ {
    x: Rep[(Char, String)] => (x._1 + x._2)
  }

  def wholeNumber(in: Rep[Input]): Parser[Int] =
    digit2Int(in) >> { x =>
      repFold(digit2Int(in))(x, (res: Rep[Int], y: Rep[Int]) => (res * unit(10) + y))
    }

  def intLit(in: Rep[Input]): Parser[Int] =
    opt(chr(in, '-')) ~ wholeNumber(in) ^^ { x =>
      if (x._1.isDefined) unit(-1) * x._2 else x._2
    }

  // the syntax for parsing double is too lousy, everything becomes double
  def chr(in: Rep[Input], c: Char) = accept(in, unit(c))

  def stringLit(in: Rep[Input]): Parser[String] = (
    accept(in, unit('"')) ~>
    repToS(acceptIf(in, (x: Rep[Char]) => x != unit('"')))
    <~ accept(in, unit('"'))
  )

  /*
  def stringLit(in: Rep[Input]): Parser[String] =
    chr(in, '"') ~> str(in, _ != unit('"') ,true) <~ chr(in,'"') ^^ { _.mkString }
  */

  def whitespaces(in: Rep[Input]): Parser[String] =
    repToS(acceptIf(in, { x: Rep[Char] => x == unit(' ') || x == unit('\n') })) ^^^ { unit("") }

  def repToS(p: Parser[Char]): Parser[String] =
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res + x)

  def repToS_f(p: Parser[Char]): Parser[String] = {
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res)
  }

  //TODO: ensure that we have an Idx parser here, and not any
  //Int parser
  //  def repToSStruct(p: Parser[Int]) : Parser[StringStruct] =
  //    repFold(p)(String(, (res: Rep[String], x: Rep[Char]) => res + x)

  def word(in: Rep[Input]): Parser[String] = repToS(letter(in))

  /*def token: Parser[Token] =
    ( identChar ~ rep( identChar | digit ) ^^ { case first ~ rest => processIdent(first :: rest mkString "") }
    | digit ~ rep( digit ) ^^ { case first ~ rest => NumericLit(first :: rest mkString "") }
    | '\'' ~ rep( chrExcept('\'', '\n', EofCh) ) ~ '\'' ^^ { case '\'' ~ chars ~ '\'' => StringLit(chars mkString "") }
    | '\"' ~ rep( chrExcept('\"', '\n', EofCh) ) ~ '\"' ^^ { case '\"' ~ chars ~ '\"' => StringLit(chars mkString "") }
    | EofCh ^^^ EOF
    | '\'' ~> failure ^^^ NoToken
    | '\"' ~> failure ^^^ NoToken
    | delim
    | failure("illegal character")
    )
  def word : Parser[String] =
  def stringLit
  */

  def accept(in: Rep[Input], cs: List[Rep[Char]]): Parser[String] = cs match {
    case Nil => Parser { i => Success(unit(""), i) }
    case x :: xs => accept(in, x) ~ accept(in, xs) ^^ {
      y: Rep[(Char, String)] => y._1 + y._2
    }
  }

  def accept(in: Rep[Input], s: String): Parser[String] =
    accept(in, s.toList.map { c => unit(c) })

  //we can also accept a string and return a boolean value. We only care that
  //the string can be parsed
  // TODO: LMS should understand this pattern and replace calls to p ^^^ f
  // with p_bool ^^^ f
  def acceptB(in: Rep[Input], s: String): Parser[Boolean] = {
    val len = staticData(s.length)
    val arr = staticData(s.toArray)
    Parser[Boolean] { i =>
      if (i + len > in.length) Failure[Boolean](i)
      else {
        var count = unit(0); var matches = unit(true)
        while (matches && count < len) {
          if (in(i + readVar(count)) != arr(readVar(count))) matches = unit(false)
          count = readVar(count) + unit(1)
        }

        if (matches) Success(unit(true), i + len)
        else Failure[Boolean](i)
      }

    }
  }

  def doubleLit(in: Rep[Input]): Parser[Double] = (
    ((opt(chr(in, '-')) ~ numeric(in)) ^^ {
      x: Rep[(Option[Char], String)] =>
        if (x._1.isDefined) x._1.get + x._2 else x._2
    })
    ~ (chr(in, '.') ~> numeric(in))
  ) ^^ { x => (x._1 + unit(".") + x._2).toDouble }

  /* specialized rep for retrieving a stringstruct
   * cannot be implemented using a rep because the zero element
   * does not have any notion of the start position
   */
  def stringStruct(in: Rep[Input], p: Parser[Int]) = Parser[StringStruct] { pos =>
    //println(unit("enter stringStruct {"))
    //barrierSync("TODO: Hack!")
    var old = unit(-1)
    var continue = unit(true)
    var cur = pos

    while (continue && old != cur) {
      old = cur
      val x = p(cur)
      if (x.isEmpty) continue = unit(false)
      else cur = x.next
    }

    // println(unit("} exit stringStruct: '") + String(in, pos, cur - pos).mkString +
    //  unit(" = ") + String(in, pos, readVar(s).get).mkString + unit("'"))
    Success[StringStruct](String(in, pos, cur - pos), cur)
  }

}

trait RecParsers extends TopDownParsers {
  def rec[T: Manifest](name: String, p: => Parser[T]): Parser[T]
}

trait RecParsersExp extends RecParsers with MyScalaOpsPkgExp with StructOpsExp
    with ParseResultOpsExp with OptionOpsExp with FunctionsExp {

  import scala.collection.mutable.HashSet
  val store = new scala.collection.mutable.HashMap[String, Sym[_]]
  var counter: Int = 0
  def rec[T: Manifest](name: String, p: => Parser[T]): Parser[T] = {
    store.get(name) match {
      case Some(f) =>
        scala.Console.println("contains")
        val realf = f.asInstanceOf[Exp[Int => ParseResult[T]]]
        Parser[T] { i => realf(i) }

      case None =>
        scala.Console.println("not contains")

        val funSym = fresh[Int => ParseResult[T]]

        store += (name -> funSym)
        val f = (i: Rep[Int]) => p(i)
        val g = createDefinition(funSym, doLambdaDef(f))
        store -= name
        Parser[T] { i => funSym(i) }
    }
  }
}
*/