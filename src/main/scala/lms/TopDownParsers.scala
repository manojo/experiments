/**
 * An implementation of basic parser combinators using simple generators
 *
 */
package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

/*
//only contains success and position for now
type ParseResult = Record {
  val success: Boolean
  val position : Int
}

def ParseResult(sc: Rep[Boolean], pos: Rep[Int]) : Rep[ParseResult] = new Record{
  val success = sc
  val position = pos
}
*/

trait TopDownParsers extends ScalaOpsPkg with GeneratorOps with LiftVariables{
  type Input = Array[Char]
  type Pos = Int

  abstract class Parser[T:Manifest] extends (Rep[Int] => Generator[(T, Int)]){self =>
    def ~ [U:Manifest](that: Parser[U]) = Parser[(T,U)]{ pos =>
      self(pos).flatMap{ x:Rep[(T,Int)] =>
        that(x._2).map{ y:Rep[(U,Int)] =>
          (make_tuple2(x._1, y._1), y._2)
        }
      }
    }

    def ~> [U:Manifest](that: => Parser[U]) = Parser[U]{pos =>
      self(pos).flatMap{x: Rep[(T,Int)] => that(x._2)}
    }

    def <~ [U:Manifest](that: => Parser[U]) = Parser[T]{pos =>
      self(pos).flatMap{ x:Rep[(T,Int)] =>
        that(x._2).map{ y:Rep[(U,Int)] =>
          make_tuple2(x._1, y._2)
        }
      }
    }

    private def map[U:Manifest](f : Rep[T] => Rep[U]) = Parser[U]{ pos =>
      self(pos).map{x:Rep[(T,Int)] => (f(x._1), x._2)}
    }

    def ^^[U:Manifest](f: Rep[T] => Rep[U]) = self.map(f)
    def ^^^[U:Manifest](u: Rep[U]) = self.map(x => u)

    //TODO: this or is neither backtracking, nor an actual or
    def | (that: Parser[T]) = Parser[T]{ pos =>
      self(pos) ++ that(pos)
    }

    private def flatMap[U:Manifest](f: Rep[T] => Parser[U]) = Parser[U]{ pos =>
      self(pos).flatMap{x: Rep[(T, Int)] =>
        val p2: Parser[U] = f(x._1)
        p2.apply(x._2)
      }
    }

    def >>[U:Manifest](f: Rep[T] => Parser[U]) = flatMap(f)

  }

  /*def failure = Parser{pos => None}
  def debuggable[T](p : => Parser[T]) = Parser{pos =>
    println("we be as position : " + pos)
    p(pos)
  }*/

  def repFold[T:Manifest, U:Manifest](p : Parser[T])(z: Rep[U], f: (Rep[U], Rep[T]) => Rep[U]) = Parser[U]{ pos =>
    var s = z
    var old = unit(-1)
    var cur = pos

    while(old != cur){
      old = cur
      p(cur).apply{ x: Rep[(T, Int)] =>
        s = f(s, x._1)
        cur = x._2
      }
    }

    elGen(make_tuple2(readVar(s), cur))
  }

  //repN fold. TODO: make sure we do not cross the input length
  def repNFold[T:Manifest, U:Manifest](p : Parser[T], n:Rep[Int])(z: Rep[U], f: (Rep[U], Rep[T]) => Rep[U]) = Parser[U]{ pos =>
    var s = z
    var old = unit(-1)
    var cur = pos
    var count = 0

    while(count < n && old != cur){
      old = cur
      count = count + 1

      p(cur).apply{ x: Rep[(T, Int)] =>
        s = f(s, x._1)
        cur = x._2
      }
    }

    elGen(make_tuple2(readVar(s), cur))
  }

  //rep can be expressed as a fold
  def rep[T:Manifest](p : Parser[T]) =
    repFold(p)(List[T]().asInstanceOf[Rep[List[T]]],
      {(ls : Rep[List[T]], t: Rep[T]) => ls ++ List(t)}
    )

  def repsep[T:Manifest,U:Manifest](p: => Parser[T], q: =>Parser[U]): Parser[List[T]] =
    rep(p <~  q)

  //a 'conditional' parser
  def condP[A: Manifest](c: Rep[Boolean], a: Parser[A], b: Parser[A]) = Parser[A]{
    i => cond(c, a(i), b(i))
  }

/*  def opt[T:Manifest](p: Parser[T]) = Parser[(T, Boolean)]{ i =>
    var passed = unit(false)
    p(i).apply{ x: Rep[(T, Int)] =>
      if(x._2 > i) passed =
    }
  }
*/
  def Parser[T:Manifest](f: Rep[Int] => Generator[(T, Int)]) = new Parser[T]{
    def apply(i: Rep[Int]) = f(i)
  }
}

trait CharParsers extends TopDownParsers with CharOps{
  type Elem = Char

  def isLetter(c: Rep[Char]) : Rep[Boolean] =
    (c >= unit('a') && c <= unit('z')) ||
    (c >= unit('A') && c <= unit('Z'))

  def isDigit(c: Rep[Char]) : Rep[Boolean] =
    c >= unit('0') && c <= unit('9')

  def letter(in:Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isLetter(c))
  def digit(in: Rep[Input]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => isDigit(c))
  def digitI(in: Rep[Input]): Parser[Int] = digit(in) ^^ {c: Rep[Char] => (c - unit('0')).toInt}

  def accept(in:Rep[Input], e: Rep[Elem]): Parser[Char] = acceptIf(in, (c: Rep[Char]) => c == e)

  def acceptIf(in:Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char]{ i =>
    cond(i >= in.length,
      emptyGen[(Char,Int)](),
      cond(p(in(i)),
        elGen((in(i), i+unit(1))),
        emptyGen[(Char,Int)]()
      )
    )
  }

  def acceptAll(in: Rep[Input]) = Parser[Char]{i =>
    cond(i >= in.length,
      emptyGen[(Char,Int)](),
      elGen((in(i)), i+unit(1))
    )
  }
}

trait TokenParsers extends TopDownParsers with CharParsers{

  def processIdent(s: Rep[String]) = if(s == "true" || s == "null" || s == "false") unit("Keyword(") + s + unit(")") else unit("NoToken")

  def keyword(in:Rep[Input]) : Parser[String] = letter(in) ~ rep( letter(in) /*| digit(in)*/ ) ^^ {
    x : Rep[(Char, List[Char])] => processIdent((x._1 :: x._2).mkString)
  }

  def numeric(in:Rep[Input]) : Parser[String] =
    digit(in) ~ repToS(digit(in)) ^^ {
      x : Rep[(Char, String)] => (x._1 + x._2)
    }

  def wholeNumber(in: Rep[Input]): Parser[Int] =
    repFold(digitI(in))(unit(0), (res:Rep[Int], y: Rep[Int]) => res * unit(10) + y)

  def stringLit(in:Rep[Input]) : Parser[String] =
    accept(in, unit('\"')) ~> rep( acceptIf(in, (x:Rep[Char]) => x != unit('\"'))) <~ accept(in, unit('\"')) ^^ {
      xs: Rep[List[Char]] => unit("StringLit(") + xs.mkString + unit(")")
    }

  def whitespaces(in: Rep[Input]) : Parser[String] =
    (rep(accept(in, unit(' ')) | accept(in, unit('\n')))) ^^^ {unit("")}

  def repToS(p: Parser[Char]) : Parser[String] =
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res + x)

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

  /* The string itself is static, it's not a Rep[String] */

  /*val i = 0
  while(i <- s.length){
    if(in(j) == s(i)){
      //good
    }else{
      //break
    }
  }*/

  def accept(in: Rep[Input], cs: List[Rep[Char]]): Parser[String] = cs match {
    case Nil => Parser{i => elGen(make_tuple2(unit(""),i))}
    case x::xs => accept(in, x) ~ accept(in, xs) ^^ {
      y: Rep[(Char, String)] => y._1 + y._2
    }
  }

  def accept(in: Rep[Input], s: String): Parser[String] = accept(in, s.toList.map{c => unit(c)})
}