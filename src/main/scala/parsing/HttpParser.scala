package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

/**
 * Borrowing the signature vocabulary from Algebraic Dynamic Programming (ADP)
 * This could be used for implementing event-based parser combinators
 */

trait Sig{

}

/**
 * What the http parser ll does:
 * A stateful parser which tries to parse either a request or a response
 *
 *
    Header fields and values
    Content-Length
    Request method
    Response status code
    Transfer-Encoding
    HTTP version
    Request URL
    Message body
 *
 * TODO: make the parser "wait" if the connection is keep-alive
 */

case class Response(
  status: Int,
  contentLength: Int,
  connection: String,
  chunked: Boolean = false,
  upgrade: Boolean = false
  // keep alive is kept in the connection field
)

class HTTP extends JavaTokenParsers {

  //removing cr-lf from whiteSpace
  override val whiteSpace = """[ \t\f\x0B\f]""".r

  //the \r is optional
  val crlf = """\r?\n""".r

  val wildRegex = """[^\r\n]*""".r
  val headerName = """[A-Z][\w-]*""".r
  val hexNumber = """[0-9A-F]+""".r

  def hexToInt(s: String) = Integer.parseInt(s, 16)

  //def message: Parser[Any] = /*request | */ response

  //using the amazing bind operator!
  def respAndMessage: Parser[(Response,String)] = response >> {
    case rsp =>
      {
        if(rsp.chunked) chunkedParser
        else if(rsp.contentLength == 0) ""<~crlf
        else body(rsp.contentLength)
        //TODO: other cases to be dealt with
      } ^^ {(rsp, _)}
  }


  /**
   * to match line terminators with ".", suggestion by
   * http://stackoverflow.com/questions/3222649/any-character-including-newline-java-regex
   *
   * TODO: if the rest of the input is smaller than i, deal with it.
   */
  def body(i:Int) : Parser[String] = ("(?s:.{"+i+"})").r <~ crlf

  // this one would need tail recursion
  def chunkedParser: Parser[String] = chunkSize >> {
    case 0 => ""<~crlf
    //TODO: whitespaces are skipped before parsing body(i), needs to be changed
    case i => (body(i) ~ chunkedParser) ^^ {case x~y => x + y}
  }

  def chunkSize: Parser[Int] = hexNumber<~(wildRegex~crlf) ^^ hexToInt

  //TODO: the asInstanceOf here in a bit ugly, the types are already known
  // when the result has been parsed
  def response: Parser[Response] = status~headers<~crlf ^^ {
    case st~hds => Response(
      status = st,
      contentLength = hds("content-length").asInstanceOf[Int],
      connection = hds.getOrElse("connection", "").asInstanceOf[String],
      chunked = hds.getOrElse("chunked", false).asInstanceOf[Boolean],
      upgrade = hds.getOrElse("upgrade", false).asInstanceOf[Boolean]
    )
  }

  def status: Parser[Int] =
    ("HTTP/"~decimalNumber)~>wholeNumber<~(wildRegex~crlf) ^^ (_.toInt)

  /*
   * Headers to deal with specially:
   *  - connection: keep-alive, close
   *  - content-length
   *  - transfer-encoding: chunked
   *  - upgrade
   *  - proxy-connection
   */
  def headers: Parser[Map[String,Any]] = rep(header) ^^ {
    case xs => xs.foldLeft(Map[String,Any]()){
      case (map, None) => map
      case (map, Some((hName, hValue))) => map + (hName -> hValue)
    }
  }

  def header: Parser[Option[(String,Any)]] =  (headerName<~":")~(wildRegex<~crlf) ^^ {
    case hName~prop => collect(hName.toLowerCase, prop)
  }

  def collect(hName: String, prop: String) : Option[(String,Any)] = hName match {
    case "connection" | "proxy-connection"
      if (prop == "keep-alive" || prop == "close") => Some((hName, prop))
    case "content-length" => Some((hName, prop.toInt)) //TODO: deal with numformatexception
    case "transfer-encoding" if (prop == "chunked") => Some(("chunked", true))
    case "upgrade" => Some((hName, true))
    case _ => None
  }
}

object HttpParser extends HTTP{

  def main(args:Array[String]){
    println("a wa do dem!")

     val httpMessage =
    """|HTTP/1.1 200 OK
       |Date: Mon, 23 May 2005 22:38:34 GMT
       |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
       |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
       |Etag: "3f80f-1b6-3e1cb03b"
       |Content-Type: text/html; charset=UTF-8
       |Content-Length: 131
       |Connection: close
       |Transfer-Encoding: chunked
       |
       |4
       |Wiki
       |4
       |pedi
       |D
       |a in
       |
       |chunks.
       |0
       |
       |""".stripMargin

    println(parseAll(respAndMessage, httpMessage))

  }
}