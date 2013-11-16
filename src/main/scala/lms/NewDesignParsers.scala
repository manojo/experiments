/**
 * An implementation of basic parser combinators using simple generators
 *
 */
package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

trait LMS extends MyScalaOpsPkg with GeneratorOps with LiftVariables
  with StructOps with ParseResultOps with OptionOps with Functions
  with CharOps with StringStructOps

trait LMSExp extends RecParsersExp with CharOpsExp with StaticDataExp
  with StringStructOpsExp with MyIfThenElseExpOpt

object ParserWorld extends LMS with LMSExp with MyScalaCompile{ self =>
  def publicUnit[T:Manifest](x: T): Rep[T] = unit(x)

  val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
    with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
    with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps{
    val IR: self.type = self
  }
}

trait NewDesignParsers{
  import ParserWorld._

  type Input = Array[Char]
  type Pos = Int
  type Elem = Char

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

  //a 'conditional' parser
  //def __ifThenElse[A: Manifest](cond: Rep[Boolean], thenp: => Parser[A], elsep: => Parser[A]): Parser[A] = Parser[A]{
  //  i => if(cond) thenp(i) else elsep(i)
  //}

  def repFold[T:Manifest, U:Manifest](p : => Parser[T])(z: Rep[U], f: (Rep[U], Rep[T]) => Rep[U]) = Parser[U]{ pos =>
    /** This is tremendously tricky: the code that goes into the generator
     cannot be taken outside if it is to be bound properly */
    Generator{ g =>
      var s = Success[U](z, pos)

      var old = publicUnit(-1)
      var continue = publicUnit(true)
      var cur = pos

      while(continue && old != cur){
        old = cur
        p(cur).apply{ x: Rep[ParseResult[T]] =>
          if(x.isEmpty) continue = publicUnit(false)
          else{s = Success(f(readVar(s).get, x.get), x.next); cur = x.next}
        }
      }

      g(readVar(s))
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

  /**
   * a Failure combinator
   */
  def failure[T: Manifest] = Parser[T] { i => elGen(Failure[T](i)) }

  // A terminal that return the current reading position
  def pos(in: Rep[Input]) = Parser[Int]{i => elGen(Success[Int](i, i)) }

  //rep can be expressed as a fold
  def rep[T:Manifest](p : => Parser[T]) =
    repFold(p)(List[T]().asInstanceOf[Rep[List[T]]],
      {(ls : Rep[List[T]], t: Rep[T]) => t :: ls }
    ) ^^ { x => x.reverse }

  /***CHAR PARSERS ***/
  def isInRange(c: Rep[Char], start: Char, end: Char) : Rep[Boolean] =
    c >= publicUnit(start) && c <= publicUnit(end)

  def isDigit(c: Rep[Char]) : Rep[Boolean] = isInRange(c, '0', '9')

  def isLetter(c: Rep[Char]) : Rep[Boolean] =
    isInRange(c, 'A', 'Z') || isInRange(c, 'a', 'z')

  def isHexDigit(c: Rep[Char]) : Rep[Boolean] =
    isDigit(c) || isInRange(c, 'A', 'F') || isInRange(c, 'a', 'f')

  def accept(in:Rep[Input], e: Rep[Elem]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => c == e)

  def acceptIf(in:Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char]{ i =>
    if (i >= in.length) elGen(Failure[Char](i))
    else if (p(in(i))) elGen(Success(in(i), i + publicUnit(1)))
    else elGen(Failure[Char](i))
  }

  def letter(in:Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isLetter(c))
  def digit(in: Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isDigit(c))
  def digit2Int(in: Rep[Input]): Parser[Int] = digit(in) ^^ {c: Rep[Char] => (c - publicUnit('0')).toInt}
  def hexDigit(in: Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isHexDigit(c))
  def hexDigit2Int(in: Rep[Input]): Parser[Int] = hexDigit(in) ^^ { c: Rep[Char] =>
    if (isDigit(c)) (c - publicUnit('0')).toInt
    else if (isInRange(c, 'A', 'F')) (c - publicUnit('A')).toInt + publicUnit(10)
    else (c - publicUnit('a')).toInt + publicUnit(10)
  }

  /*** TOKEN PARSERS ***/
  //def keyword(in:Rep[Input]) : Parser[String] = letter(in) ~ repToS( letter(in) /*| digit(in)*/ ) ^^ {
  //  x : Rep[(Char, String)] => processIdent(x._1 + x._2)
  //}

  def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS(acceptIf(in, {x:Rep[Char] => x == publicUnit(' ') || x == publicUnit('\n')})) ^^^ {publicUnit("")}

  def repToS(p: Parser[Char]) : Parser[String] =
    repFold(p)(publicUnit(""), (res: Rep[String], x: Rep[Char]) => res + x)

  def repToS_f(p: Parser[Char]) : Parser[String] = {
    repFold(p)(publicUnit(""), (res: Rep[String], x: Rep[Char]) => res)
  }

  def word(in:Rep[Input]) : Parser[String] = repToS(letter(in))

  def wholeNumber(in: Rep[Input]): Parser[Int] =
    digit2Int(in) >> {x =>
      repFold(digit2Int(in))(x, (res:Rep[Int], y: Rep[Int])
        => (res * publicUnit(10) + y)
      )
  }

  def hexNumber(in: Rep[Input]): Parser[Int] =
    hexDigit2Int(in) >> { x =>
      repFold(hexDigit2Int(in))(x, (res:Rep[Int], y: Rep[Int])
        => (res * publicUnit(16) + y)
      )
  }

  //just keep the major and minor disctinction
  def decimalNumber(in: Rep[Input]): Parser[(Int,Int)] =
    wholeNumber(in)~(accept(in, publicUnit('.'))~>wholeNumber(in))

  def numeric(in:Rep[Input]) : Parser[String] = /*digit(in) ~*/
   repToS(digit(in))
  /* ^^ {
    x : Rep[(Char, String)] => (x._1 + x._2)
  }*/


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
