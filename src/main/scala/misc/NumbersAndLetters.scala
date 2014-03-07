package misc

import scala.util.continuations._

/**
 * Two versions of letters and numbers parsing
 */
object NumbersAndLetters {

  def main(args: Array[String]){
    println(ol1("2he3llo"))
    println("ol2")
    println(ol2("2he3llo"))
  }

  def isLetter(c:Char) = c >= 'a' && c <= 'z'
  def isDigit(c:Char) = c >= '0' && c <= '9'

  /**
   * A dumbed down version, just to understand
   */
  def ol1(s:String): Option[String] = {

    def digit(offset:Int): Option[Int] = {
      if(offset >= s.length) None
      else if(isDigit(s.charAt(offset))) Some((s.charAt(offset) - '0').toInt)
      else None
    }

    def letters(offset: Int, chunkEnd:Int, acc:Option[String]): Option[String] = {
      if(offset >= s.length) acc
      else if(offset >= chunkEnd) makeProgress(offset, acc)
      else if(isLetter(s.charAt(offset))) {
        val newacc = acc match {
          case None => Some("" + s.charAt(offset))
          case Some(str) => Some(str + s.charAt(offset))
        }
        letters(offset+1, chunkEnd, newacc)
      }else None
    }

    def makeProgress(idx: Int, temp:Option[String]): Option[String] = {
      digit(idx) match {
        case None => temp
        case Some(chunkSize) => letters(idx+1, idx+1+chunkSize, temp)
      }
    }

    makeProgress(0, None)
  }


  /**
   * using continuations
   */

  def ol2(s:String): Option[String] = {

    sealed abstract class LettersResult
    case class Done(s: String) extends LettersResult
    case class Cont(f: ((Int, Int)) => LettersResult) extends LettersResult

    def digit(offset:Int): Option[Int] = {
      if(offset >= s.length) None
      else if(isDigit(s.charAt(offset))) Some((s.charAt(offset) - '0').toInt)
      else None
    }

    def letters(offset: Int, chunkEnd: Int, acc: String): String @cps[LettersResult] = {
      if(offset >= s.length) acc
      else if (offset >= chunkEnd) {
        val res = shift { k: (((Int, Int)) => LettersResult) =>
          Cont(k)
        }
        letters(res._1, res._2, acc)

      } else if (isLetter(s.charAt(offset))) {
        letters(offset + 1, chunkEnd, acc + s.charAt(offset))
      } else acc
    }

    def doItAll(idx: Int): Option[String] = {

      def makeProgress(idx: Int, k: Cont): Option[String] = {
        digit(idx) match {
          //c'est un hack
          case None => k.f((s.length, s.length)) match {
            case Done(str) => Some(str)
            case _ => throw new Error("maman")
          }

          case Some(chunkSize) => k.f((idx + 1, chunkSize + idx + 1)) match {
            case c: Cont => makeProgress(chunkSize + idx + 1, c)
            case Done(str) => Some(str)
          }
        }
      }

      digit(idx) match {
        case None => None
        case Some(chunkSize) =>
          val letterRes = reset {
            val x: String @cps[LettersResult] = letters(idx + 1, chunkSize + idx + 1, "")
            Done(x)
          }

          letterRes match {
            case c: Cont => makeProgress(chunkSize + idx + 1, c)
            case Done(str) => Some(str)
          }

      }
    }

    doItAll(0)
  }
}