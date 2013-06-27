package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

/**
 * Borrowing the signature vocabulary from Algebraic Dynamic Programming (ADP)
 * This could be used for implementing event-based parser combinators
 */

trait Sig{

}

class HTTP extends JavaTokenParsers {

  //removing cr-lf from whiteSpace
  override val whiteSpace = """[ \t\f\x0B\f]""".r

  //on linux the \r does not seem necessary, hence it is optional
  val crlf = """\r?\n""".r

  val wildRegex = """[^\r\n]*""".r
  val headerName = """[A-Z][\w-]*""".r

  def message: Parser[Any] = /*request | */ response

  def response: Parser[Any] = status~rep(header)~crlf

  def status: Parser[Any] =
    "HTTP/"~decimalNumber~wholeNumber~wildRegex~crlf

  def header: Parser[Any] =  headerName~":"~wildRegex~crlf

}


object HttpParser extends HTTP{
  def main(args:Array[String]){
    println("a wa do dem!")
  }
}