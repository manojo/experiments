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
//  def message: Parser[Any] = /*request | */ response

//  def response: Parser[Any] = (status~Endl)~>rep(headers)

  val wildRegex = """.*""".r
  val headerName = """[A-Z][\w-]*""".r

  def status: Parser[Any] =
    "HTTP/"~decimalNumber~wholeNumber~wildRegex

  def header: Parser[Any] =  headerName~":"~wildRegex


}


object HttpParser extends HTTP{

  val headers = List(
    "Date: Mon, 23 May 2005 22:38:34 GMT",
    "Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)",
    "Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT",
    "Etag: \"3f80f-1b6-3e1cb03b\"",
    "Content-Type: text/html; charset=UTF-8",
    "Content-Length: 131",
    "Connection: close"
  )

  val statusMessages = List(
    "HTTP/1.1 200 OK",
    "HTTP/1.1 418 I'm a teapot"
  )



  def main(args:Array[String]){
    println("Greetings from a Http Parser!")

    println("parsing some response headers")
    headers.foreach{h =>
      println(parseAll(header, new CharSequenceReader(h, 0)))
    }

    println("parsing some status messages")
    statusMessages.foreach{sm =>
      println(parseAll(status, new CharSequenceReader(sm, 0)))
    }
  }
}