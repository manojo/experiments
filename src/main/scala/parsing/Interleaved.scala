package parsing

import scala.util.continuations._

trait SimpleParsers {

  type Elem
  type Input = Reader[Elem]

  abstract class ParseResult[+T]
  case class Success[+T](t: T, rest: Input) extends ParseResult[T]
  case class Failure(rest: Input) extends ParseResult[Nothing]

  abstract class Parser[+T] extends (Input => ParseResult[T]) {
    def ~[U](that: Parser[U]) = Parser[(T, U)] { in =>
      this(in) match {
        case Success(t, rest) => that(rest) match {
          case Success(u, rest2) => Success((t, u), rest2)
          case f @ Failure(_) => f
        }
        case f @ Failure(_) => f
      }
    }

    def |[U >: T](that: Parser[U]) = Parser[U] { in =>
      this(in) match {
        case s @ Success(_, _) => s
        case f @ Failure(_) => that(in)
      }
    }

    def ~>[U](that: => Parser[U]) = Parser[U] { in =>
      this(in) match {
        case Success(t, rest) => that(rest)
        case f @ Failure(_) => f
      }
    }

    def <~[U](that: => Parser[U]) = Parser[T] { in =>
      this(in) match {
        case Success(t, rest) => that(rest) match {
          case Success(u, rest2) => Success(t, rest2)
          case f @ Failure(_) => f
        }

        case f @ Failure(_) => f
      }
    }

    def map[U](f: T => U) = Parser[U] { in =>
      this(in) match {
        case Success(t, rest) => Success(f(t), rest)
        case f @ Failure(_) => f
      }
    }

    def ^^[U](f: T => U) = map(f)

    def flatMap[U](f: T => Parser[U]) = Parser[U] { in =>
      this(in) match {
        case Success(t, rest) => f(t)(rest)
        case f @ Failure(_) => f
      }
    }

    def >>[U](f: T => Parser[U]) = flatMap(f)
  }

  def Parser[T](f: Input => ParseResult[T]): Parser[T] = new Parser[T] {
    def apply(in: Input) = f(in)
  }

  def accept(p: Elem => Boolean): Parser[Elem] = Parser[Elem] { in =>
    if (!in.atEnd && p(in.first)) Success(in.first, in.rest)
    else Failure(in)
  }

  def accept(e: Elem): Parser[Elem] = accept(x => x == e)
  def accept(es: List[Elem]): Parser[List[Elem]] = es match {
    case Nil => success(Nil)
    case x :: xs => accept(x) ~ accept(xs) ^^ { case (y, ys) => y :: ys }
  }

  def repFold[T, U](p: => Parser[T])(z: U, f: (U, T) => U): Parser[U] = Parser { in =>
    p(in) match {
      case Failure(rest) => Success(z, rest)
      case Success(t, rest) => repFold(p)(f(z, t), f)(rest)
    }
  }

  def rep[T](p: => Parser[T]): Parser[List[T]] = repFold(p)(Nil, (xs: List[T], x: T) => x :: xs) ^^ (_.reverse)

  def success[T](t: T) = Parser[T] { in => Success(t, in) }
/*
  implicit class Bla(rdr: Reader[Elem]) {
    //def readChunked(p: Parser[Int]) = Reader[Elem]
    def readChunked(p: Parser[Int], chunkEnd: Int): Reader[Elem] = new Reader[Elem] {
      def input = rdr.input
      def first = rdr.first
      def offset = rdr.offset
      def atEnd = rdr.atEnd

      def rest = if(offset == chunkEnd -1) {
        val next = rdr.rest
        p(next) match {
          case Success(chunkSize2, rest2) => readChunked(p, rest2.offset + chunkSize2)
          case Failure(rest) => rest
        }
      } else readChunked(p, chunkEnd)
    }
  }
*/


}

abstract class Reader[+T] { self =>
  def first: T
  def rest: Reader[T]
  def offset: Int
  //def skip: Int
  def atEnd: Boolean

  //hack!
  def input: Any

  /**
   * Returns an abstract reader consisting of all elements except the first `n` elements.
   */
  def drop(n: Int): Reader[T] = {
    var r: Reader[T] = this
    var cnt = n
    while (cnt > 0) {
      r = r.rest; cnt -= 1
    }
    r
  }
}

class StringReader(s: String, override val offset: Int = 0) extends Reader[Char] {
  def first = s.charAt(offset)
  def rest = new StringReader(s, offset + 1)
  def atEnd = offset >= s.length

  def input = s

}

case class ChunkReader(s: String, chunks: List[(Int, Int)]) extends Reader[Char] {

  def input = s
  def offset = chunks.head._1
  def atEnd = chunks.isEmpty

  def isCurrentChunkOver = chunks match {
    case Nil => throw new Exception("no chunks on empty reader")
    case (chunkStart, chunkEnd) :: _ => chunkStart == chunkEnd - 1
  }

  def first = s.charAt(chunks.head._1)
  def rest = chunks match {
    case Nil => throw new Exception("no rest to empty reader")
    case (chunkStart, chunkEnd) :: xs =>
      new ChunkReader(s,
        if (chunkStart == chunkEnd - 1) xs
        else (chunkStart + 1, chunkEnd) :: xs
      )
  }

  def ++(that: ChunkReader): ChunkReader = {
    assert(s == that.s)
    new ChunkReader(s, chunks ++ that.chunks)
  }
}

trait CharParsers extends SimpleParsers {
  type Elem = Char

  def isLetter(c: Char) = c >= 'a' && c <= 'z'
  def isDigit(c: Char) = c >= '0' && c <= '9'

  def letter = accept(isLetter(_))
  def letters: Parser[String] = repFold(letter)("", { (str: String, c) => str + c.toString })

  def digit: Parser[Int] = accept(isDigit(_)) ^^ { c => (c - '0').toInt }
  def number: Parser[Int] = digit >> { x =>
    repFold(digit)(x, (res: Int, y: Int) => res * 10 + y)
  }

  def accept(s: String): Parser[String] =
    accept(s.toList) ^^ { xs => xs.mkString }
}

object Interleaved extends CharParsers {

  class ChunkReader2(rdr: Reader[Char]) extends Reader[Char] {

    def input = rdr.input
    private val (chunkSize, trueReader) = number(rdr) match {
      case Success(i, rd) => (i, rd)
      case _ => (-1, rdr)
    }

    def first = trueReader.first
    def offset = trueReader.offset

    def rest = {
      new CReader(trueReader.rest, offset + chunkSize)
    }

    def atEnd = chunkSize == -1 || rdr.atEnd
  }

  /*private*/ class CReader(rdr: Reader[Char], chunkEnd: Int) extends Reader[Char] {

    def input = rdr.input

    def first = rdr.first
    def offset = rdr.offset

    def rest = {
      if (offset == chunkEnd - 1) {
        val next = rdr.rest
        number(next) match {
          case Success(chunkSize, rest) => new CReader(rest, rest.offset + chunkSize)
          case Failure(rest) => rest
        }
      } else new CReader(rdr.rest, chunkEnd)
    }

    def atEnd = rdr.atEnd
  }


  def hewords = accept("hello") | accept("helicopter")

  def body(x: Int): Parser[ChunkReader] = Parser { in: Reader[Char] =>
    //hack!!
    val s = in.input.asInstanceOf[String]
    Success(
      new ChunkReader(s, (in.offset, in.offset + x) :: Nil),
      in.drop(x)
    )
  }

  def digitAndBody: Parser[ChunkReader] = digit >> { x => body(x) }

  def wikiParseReader: Parser[ChunkReader] = digitAndBody >> { rdr =>
    repFold(digitAndBody)(rdr, { (acc: ChunkReader, rdr) => acc ++ rdr })
  }

  def wikiParser: Parser[String] = wikiParseReader ^^ { rdr: Reader[Char] =>
    hewords(rdr) match {
      case Success(s, _) => s
      case _ => ""
    }
  }



  def main(args: Array[String]) = {
    println("Interleaving is the form of the day!")

    println(wikiParser(new StringReader("2he3llo")))
    println(wikiParser(new StringReader("2he3lic3opt2er")))

    println("nesting readers")

    println(hewords(new CReader(new StringReader("he3llo"), 2)))
    println(hewords(new CReader(new StringReader("he3lic3opt2er"), 2)) match {
      case Success(str, _) => str
      case Failure(in) => in.offset
    })

//    println(hewords(readChunked(new StringReader("he3llo"), number, 2)))
//    println(hewords(readChunked(new StringReader("he3lic3opt2er"), number, 2)) match {
//      case Success(str, _) => str
//      case Failure(in) => in.offset
//    })
  }
}

