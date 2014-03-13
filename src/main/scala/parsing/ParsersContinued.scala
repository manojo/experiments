package parsing

import scala.util.continuations._

/**
 * Introduce parser combinators now.
 * Later: Keep history of the reader
 */

sealed abstract class LettersResult
case class Done(s: String) extends LettersResult
case class Cont(f: ChunkReader => LettersResult) extends LettersResult

object ParsersContinued extends CharParsers {

  def main(args: Array[String]) {
    println(doItAll(new StringReader("2he3llo")))
  }

  /**
   * if the reader is done, return the string
   * if the reader is almost done (aka a chunk exists but is reaching the end),
   * pass control, and continue later
   */
  def letters(rdr: ChunkReader, acc: String): String @cps[LettersResult] = {
    val str = rdr.input.asInstanceOf[String]
    if (rdr.atEnd) acc
    else if (rdr.isCurrentChunkOver) {
      //expecting a new ChunkReader back from the continuation
      val res = shift { k: (ChunkReader => LettersResult) =>
        Cont(k)
      }

      //a bit of a hack again, we can take care of indices later
      letters(res, acc + str.charAt(rdr.chunks.head._1))
    } else if (isLetter(str.charAt(rdr.chunks.head._1))) {
      letters(rdr.rest.asInstanceOf[ChunkReader], acc + str.charAt(rdr.chunks.head._1))
    } else acc
  }

  def doItAll: Parser[String] = Parser { in =>

    def makeProgress(k: Cont): Parser[String] = Parser { in =>
      digit(in) match {
        //if fail, send an "empty reader" to the continuation, to tell it to finish
        case Failure(_) => k.f(ChunkReader(in.input.asInstanceOf[String], Nil)) match {
          //should return a reader that is the end of the successful parse
          //is it the same as in? First hunch: yes it should
          case Done(str) => Success(str, in)
          case _ => throw new Error("maman")
        }

        case Success(chunkSize, rest) =>
          k.f(ChunkReader(rest.input.asInstanceOf[String], (rest.offset, chunkSize + rest.offset) :: Nil)) match {
            case c: Cont => makeProgress(c)(rest.drop(chunkSize))

            //this time, the reader that is returned is more tricky.. what if the underlying
            //parser has failed?
            case Done(str) => Success(str, in)
          }
      }
    }

    digit(in) match {
      case f @ Failure(_) => f
      case Success(chunkSize, rest) =>
        val letterRes = reset {
          val x: String @cps[LettersResult] =
            letters(
              ChunkReader(rest.input.asInstanceOf[String],
                (rest.offset, chunkSize + rest.offset) :: Nil
              ),
              ""
            )

          Done(x)
        }

        letterRes match {
          case c: Cont => makeProgress(c)(rest.drop(chunkSize))
          //all readers are hacks
          case Done(str) => Success(str, rest.drop(chunkSize))
        }
    }
  }
}