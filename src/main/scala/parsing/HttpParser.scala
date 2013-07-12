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
 */

case class Response(
  status: Int,
  contentLength: Int,
  connection: String,
  chunked: Boolean = false,
  upgrade: Boolean = false
  // keep alive is kept in the connection var keepAlive: Boolean
)

class HTTP extends JavaTokenParsers {

  //removing cr-lf from whiteSpace
  override val whiteSpace = """[ \t\f\x0B\f]""".r

  //the \r is optional
  val crlf = """\r?\n""".r

  val wildRegex = """[^\r\n]*""".r
  val headerName = """[A-Z][\w-]*""".r

  //def message: Parser[Any] = /*request | */ response

  //TODO: the as instance of here in a bit ugly, the types are already known
  // when parsing
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
    case "transfer-encoding" if (prop == "chunked") => Some((hName, true))
    case "upgrade" => Some((hName, true))
    case _ => None
  }
}

object HttpParser extends HTTP{

  def main(args:Array[String]){
    println("a wa do dem!")
    val in =    """|Content-Length: 131
      |""".stripMargin
    println(parseAll(response,in))
  }
}