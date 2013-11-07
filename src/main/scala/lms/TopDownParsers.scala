/**
 * An implementation of basic parser combinators using simple generators
 *
 */
package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects


trait TopDownParsers extends MyScalaOpsPkg with GeneratorOps with LiftVariables
  with StructOps with ParseResultOps with OptionOps with Functions {
  type Input = Array[Char]
  type Pos = Int

  abstract class Parser[+T:Manifest] extends (Rep[Int] => Generator[ParseResult[T]]){self =>

    private def flatMap[U:Manifest](f: Rep[T] => Parser[U]) = Parser[U]{ pos =>
      self(pos).flatMap{x: Rep[ParseResult[T]] =>{
        if(x.isEmpty) elGen(Failure[U](pos))
        else f(x.get).apply(x.next).map{x => if(x.isEmpty) Failure[U](pos) else x}
      }
      }
    }

    def >>[U:Manifest](f: Rep[T] => Parser[U]) = flatMap(f)

    def ~[U: Manifest](that: Parser[U]) = Parser[(T,U)]{pos =>
      self(pos).flatMap{x: Rep[ParseResult[T]] =>
        if(x.isEmpty) elGen(Failure[(T,U)](pos))
        else that(x.next).map{y: Rep[ParseResult[U]] =>
          if(y.isEmpty) Failure[(T,U)](pos)
          else Success(make_tuple2(x.get, y.get), y.next)
        }
      }
    }

    def ~> [U:Manifest](that: => Parser[U]) = Parser[U]{pos =>
      self(pos).flatMap{x: Rep[ParseResult[T]] =>
        if(x.isEmpty) elGen(Failure[U](pos)) else that(x.next)
      }
    }

    def <~ [U:Manifest](that: => Parser[U]) = Parser[T]{pos =>
      self(pos).flatMap{ x:Rep[ParseResult[T]] =>
        if(x.isEmpty) elGen(x) else that(x.next).map{
          y: Rep[ParseResult[U]] =>
            if(y.isEmpty) Failure[T](pos) else Success(x.get,y.next)
        }
      }
    }


    private def map[U:Manifest](f : Rep[T] => Rep[U]) = Parser[U]{ pos =>
      self(pos).map{x => x map f}
    }

    def ^^[U:Manifest](f: Rep[T] => Rep[U]) = self.map(f)
    def ^^^[U:Manifest](u: Rep[U]) = self.map(x => u)

    def | [U>:T:Manifest](that: Parser[U]) = {
      val p = Parser[U]{ pos =>
        val tmpSelf = toplevel(self)

        tmpSelf(pos).flatMap{x =>
          if(x.isEmpty) that(pos) else elGen(x.asInstanceOf[Rep[ParseResult[U]]])
        }
      }
      toplevel(p)
    }

    def filter(p: Rep[T] => Rep[Boolean]) = Parser[T]{pos =>
      self(pos).map{ x =>
        if(x.isEmpty) x
        else if (p(x.get)) x
        else Failure[T](x.next)
      }
    }
  }

  /*def failure = Parser{pos => None}
  def debuggable[T](p : => Parser[T]) = Parser{pos =>
    println("we be as position : " + pos)
    p(pos)
  }*/

  def repFold[T:Manifest, U:Manifest](p : => Parser[T])(z: Rep[U], f: (Rep[U], Rep[T]) => Rep[U]) = Parser[U]{ pos =>
    /** This is tremendously tricky: the code that goes into the generator
     cannot be taken outside if it is to be bound properly */
    Generator{ g =>
      var s = Success[U](z, pos)

      var old = unit(-1)
      var continue = unit(true)
      var cur = pos

      while(continue && old != cur){
        old = cur
        p(cur).apply{ x: Rep[ParseResult[T]] =>
          if(x.isEmpty) continue = unit(false)
          else{s = Success(f(readVar(s).get, x.get), x.next); cur = x.next}
        }
      }

      g(readVar(s))
    }
  }

  //repN fold. TODO: make sure we do not cross the input length
  def repNFold[T:Manifest, U:Manifest](p : => Parser[T], n:Rep[Int])(z: Rep[U], f: (Rep[U], Rep[T]) => Rep[U]) = Parser[U]{ pos =>
    Generator{ g =>
      var s = Success[U](z, pos)

      var old = unit(-1)
      var continue = unit(true)
      var cur = pos
      var count = unit(0)

      while(count < n && old != cur && continue){
        old = cur
        p(cur).apply{ x: Rep[ParseResult[T]] =>
          if(x.isEmpty) continue = unit(false)
          else{s = Success(f(readVar(s).get, x.get), x.next); cur = x.next; count = count+unit(1)}
        }
      }

      g(readVar(s))
    }
  }

  //rep can be expressed as a fold
  def rep[T:Manifest](p : => Parser[T]) =
    repFold(p)(List[T]().asInstanceOf[Rep[List[T]]],
      {(ls : Rep[List[T]], t: Rep[T]) => ls ++ List(t) }
    )

  def repsep[T:Manifest,U:Manifest](p: => Parser[T], q: =>Parser[U]): Parser[List[T]] =
    (p ~ rep(q ~>  p)) ^^ {x => x._1 :: x._2 } | success(List[T]())

  //a 'conditional' parser
  def __ifThenElse[A: Manifest](cond: Rep[Boolean], thenp: => Parser[A], elsep: => Parser[A]): Parser[A] = Parser[A]{
    i => if(cond) thenp(i) else elsep(i)
  }

  def opt[T:Manifest](p: Parser[T]) = Parser[Option[T]]{pos =>
    p(pos).map{x =>
      if(x.isEmpty) Success(none[T](), x.next)
      else Success(Some(x.get), x.next)
    }
  }

  def Parser[T:Manifest](f: Rep[Int] => Generator[ParseResult[T]]) = new Parser[T]{
    def apply(i: Rep[Int]) = f(i)
  }

  //making a function of a non-recursive parser
  def toplevel[T:Manifest](p: Parser[T]) : Parser[T] = {

    val f  = doLambda{ (i:Rep[Int]) => {
        var init = Failure[T](i)
        p(i){x => init = x}
        readVar(init)
      }
    }

    val res = Parser[T]{ i => elGen(f(i))}
    res
  }

  /**
   * a Success combinator
   */
  def success[T:Manifest](v:Rep[T]) = Parser[T]{i => elGen(Success(v, i))}
}

trait CharParsers extends TopDownParsers with CharOps with StringStructOps {
  type Elem = Char

  def isLetter(c: Rep[Char]) : Rep[Boolean] =
    (c >= unit('a') && c <= unit('z')) ||
    (c >= unit('A') && c <= unit('Z'))

  def isDigit(c: Rep[Char]) : Rep[Boolean] =
    c >= unit('0') && c <= unit('9')

  def letter(in:Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isLetter(c))
  def letterIdx(in:Rep[Input]) = acceptIfIdx(in, (c: Rep[Char]) => isLetter(c))


  def digit(in: Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isDigit(c))
  def digit2Int(in: Rep[Input]): Parser[Int] = digit(in) ^^ {c: Rep[Char] => (c - unit('0')).toInt}
  def digitIdx(in: Rep[Input]) = acceptIfIdx(in, (c: Rep[Char]) => isDigit(c))

  def accept(in:Rep[Input], e: Rep[Elem]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => c == e)

  def acceptIf(in:Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char]{ i =>
    if(i >= in.length) elGen(Failure[Char](i))
    else if(p(in(i))) elGen(Success(in(i), i+unit(1)))
    else elGen(Failure[Char](i))
  }

  def acceptAll(in: Rep[Input]) = Parser[Char]{i =>
    if(i >= in.length) elGen(Failure[Char](i))
    else elGen(Success[Char](in(i), i+unit(1)))
  }

  //acceptIf, returning the index of the element found
  def acceptIdx(in:Rep[Input], e: Rep[Elem]): Parser[Int] = acceptIfIdx(in, (c: Rep[Char]) => c == e)

  def acceptIfIdx(in:Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Int]{ i =>
    if(i >= in.length) elGen(Failure[Int](i))
    else if(p(in(i))) elGen(Success(i, i+unit(1)))
    else elGen(Failure[Int](i))
  }

  def acceptAllIdx(in: Rep[Input]) = Parser[Int]{i =>
    if(i >= in.length) elGen(Failure[Int](i))
    else elGen(Success[Int](i, i+unit(1)))
  }

  // Non empty sequence of characters matching predicate 'p'
  def str(in:Rep[Input],p:Rep[Elem]=>Rep[Boolean], empty:Boolean=false) = Parser[StringStruct] { pos:Rep[Int] =>
    Generator{ g =>
      val l = in.length
      val e = __newVar(pos)
      while (e<l && p(in(e))) { e += 1 }
      if (empty) g(Success[StringStruct](String(in,pos,e-pos),e))
      else {
        if (pos==e) g(Failure[StringStruct](pos))
        else g(Success[StringStruct](String(in,pos,e-pos),e))
      }
    }
  }
}

trait TokenParsers extends TopDownParsers with CharParsers with StringStructOps{

  def processIdent(s: Rep[String]) = if(s == unit("true") || s == unit("null") || s == unit("false")) unit("Keyword(") + s + unit(")")
                                     else unit("NoToken")

  def keyword(in:Rep[Input]) : Parser[String] = letter(in) ~ repToS( letter(in) /*| digit(in)*/ ) ^^ {
    x : Rep[(Char, String)] => processIdent(x._1 + x._2)
  }

  def numeric(in:Rep[Input]) : Parser[String] = digit(in) ~ repToS(digit(in)) ^^ {
    x : Rep[(Char, String)] => unit("NumericLit(") + (x._1 + x._2) + unit(")")
  }

  def wholeNumber(in: Rep[Input]): Parser[Int] =
    digit2Int(in) >> {x =>
      repFold(digit2Int(in))(x, (res:Rep[Int], y: Rep[Int]) => (res * unit(10) + y))
  }

  // the syntax for parsing double is too lousy, everything becomes double
  def chr(in:Rep[Input],c:Char) = accept(in, unit(c))
  def intLit(in:Rep[Input]) : Parser[Int] = opt(chr(in,'-')) ~ str(in,c=>c>=unit('0')&&c<=unit('9')) ^^ { case x => val v=x._2.toStr.toInt; if (x._1.isDefined) v*unit(-1) else v  }
  def doubleLit(in:Rep[Input]) : Parser[Double] = str(in,c=>c>=unit('0')&&c<=unit('9') || c==unit('-') || c==unit('.') || c==unit('e') || c==unit('E')) ^^ { _.toStr.toDouble }
  def stringLit(in:Rep[Input]) : Parser[String] = chr(in,'"') ~> str(in,_ != unit('"') ,true) <~ chr(in,'"') ^^ { _.toStr }
    /*
    accept(in, unit('\"')) ~> repToS( acceptIf(in, (x:Rep[Char]) => x != unit('\"'))) <~ accept(in, unit('\"')) ^^ {
      xs: Rep[String] => unit("StringLit(") + xs + unit(")")
    }
    */

  def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS(acceptIf(in, {x:Rep[Char] => x == unit(' ') || x == unit('\n')})) ^^^ {unit("")}

  def repToS(p: Parser[Char]) : Parser[String] =
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res + x)

  def repToS_f(p: Parser[Char]) : Parser[String] = {
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res)
  }

  //TODO: ensure that we have an Idx parser here, and not any
  //Int parser
//  def repToSStruct(p: Parser[Int]) : Parser[StringStruct] =
//    repFold(p)(String(, (res: Rep[String], x: Rep[Char]) => res + x)

  def word(in:Rep[Input]) : Parser[String] = repToS(letter(in))

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
    case Nil => Parser{i => elGen(Success(unit(""), i))}
    case x::xs => accept(in, x) ~ accept(in, xs) ^^ {
      y: Rep[(Char, String)] => y._1 + y._2
    }
  }

  def accept(in: Rep[Input], s: String): Parser[String] = accept(in, s.toList.map{c => unit(c)})

  /* specialized rep for retrieving a stringstruct
   * cannot be implemented using a rep because the zero element
   * does not have any notion of the start position
   */
  def stringStruct(in: Rep[Input], p : Parser[Int]) = Parser[StringStruct]{ pos =>
    Generator{ g =>
      var s = Success[Int](unit(0), pos)

      var old = unit(-1)
      var continue = unit(true)
      var cur = pos

      while(continue && old != cur){
        old = cur
        p(cur).apply{ x: Rep[ParseResult[Int]] =>
          if(x.isEmpty) continue = unit(false)
          else{
            s = Success(readVar(s).get + unit(1), x.next)
            cur = x.next
          }
        }
      }

      g(Success[StringStruct](String(in, pos, readVar(s).get), readVar(s).next))
    }
  }
}

trait RecParsers extends TopDownParsers{
  def rec[T:Manifest](name: String, p: => Parser[T]): Parser[T]
}

trait RecParsersExp extends RecParsers with MyScalaOpsPkgExp with GeneratorOpsExp
  with StructOpsExp with ParseResultOpsExp with OptionOpsExp with FunctionsExp{

  import scala.collection.mutable.HashSet
  val store = new scala.collection.mutable.HashMap[String, Sym[_]]
  var counter:Int = 0
  def rec[T: Manifest](name: String, p: => Parser[T]): Parser[T] = {
    store.get(name) match {
      case Some(f) =>
        scala.Console.println("contains")
        val realf = f.asInstanceOf[Exp[Int => ParseResult[T]]]
        Parser[T]{i => elGen(realf(i))}

      case None =>
        scala.Console.println("not contains")

        val funSym = fresh[Int => ParseResult[T]]

        store += (name -> funSym)
        val f = (i: Rep[Int]) => {
          var init = Failure[T](i)
          p(i){x => init = x}
          readVar(init)
        }

        val g = createDefinition(funSym,doLambdaDef(f))
        store -= name
        Parser[T]{i => elGen(funSym(i))}
    }
  }
}
