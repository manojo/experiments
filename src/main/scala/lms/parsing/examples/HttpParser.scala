package lms.parsing.examples

import lms._
import lms.parsing._
import lms.util._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait HttpComponents extends lms.StructOps with SetOps {

  type Response = Record {
    val status: Int
    val contentLength: Int
    val connection: String
    val chunked: Boolean
    val upgrade: Boolean

  }

  def Response(st: Rep[Int] = unit(200), cL: Rep[Int] = unit(0),
    conn: Rep[String] = unit("close"), ch: Rep[Boolean] = unit(false),
    up: Rep[Boolean] = unit(false)): Rep[Response] = new Record {
    val status = st
    val contentLength = cL
    val connection = conn
    val chunked = ch
    val upgrade = up
  }

  type Url = Record {
    val schema: String
    val hostName: String
    val path: String
    val queryString: String
    val fragment: String
    val port: Int
  }

  def Url(sch: Rep[String] = unit(""), hName: Rep[String] = unit(""),
    pth: Rep[String] = unit(""), qString: Rep[String] = unit(""),
    frag: Rep[String] = unit(""), prt: Rep[Int] = unit(80)): Rep[Url] = new Record {
    val schema = sch
    val hostName = hName
    val path = pth
    val queryString = qString
    val fragment = frag
    val port = prt
  }

  def copyUrl(url: Rep[Url])(sch: Rep[String] = url.schema, hName: Rep[String] = url.hostName,
    pth: Rep[String] = url.path, qString: Rep[String] = url.queryString,
    frag: Rep[String] = url.fragment, prt: Rep[Int] = url.port) = Url(sch, hName, pth, qString, frag, prt)

  //  def copy(resp: Rep[Response],)

  type Request = Record {
    val requestType: String
    val uri: Url
    val contentLength: Int
    val connection: String
    val chunked: Boolean
    val upgrade: Boolean
  }

  def Request(rType: Rep[String] = unit("get"), url: Rep[Url] = Url(),
    cL: Rep[Int] = unit(0), conn: Rep[String] = unit("close"),
    ch: Rep[Boolean] = unit(false), up: Rep[Boolean] = unit(false)): Rep[Request] = new Record {
    val requestType = rType
    val uri = url
    val contentLength = cL
    val connection = conn
    val chunked = ch
    val upgrade = up
  }

  def copyRequest(req: Rep[Request])(rType: Rep[String] = req.requestType, url: Rep[Url] = req.uri,
    cL: Rep[Int] = req.contentLength, conn: Rep[String] = req.connection,
    ch: Rep[Boolean] = req.chunked, up: Rep[Boolean] = req.upgrade) = Request(rType, url, cL, conn, ch, up)

  //a def because we want to create the node only when required
  def requestTypes = Set(
    unit("connect"),
    unit("copy"),
    unit("checkout"),
    unit("delete"),
    unit("get"),
    unit("head"),
    unit("lock"),
    unit("merge"),
    unit("mkactivity"),
    unit("mkcol"),
    unit("move"),
    unit("msearch"),
    unit("notify"),
    unit("options"),
    unit("post"),
    unit("propfind"),
    unit("proppatch"),
    unit("put"),
    unit("report"),
    unit("subscribe"),
    unit("trace"),
    unit("unlock"),
    unit("unsubscribe")
  )

  //code duplication oO
  val requestTypesUnRepped = scala.List(
    "connect",
    "copy",
    "checkout",
    "delete",
    "get",
    "head",
    "lock",
    "merge",
    "mkactivity",
    "mkcol",
    "move",
    "msearch",
    "notify",
    "options",
    "post",
    "propfind",
    "proppatch",
    "put",
    "report",
    "subscribe",
    "trace",
    "unlock",
    "unsubscribe"
  )

}

trait HttpParser extends TokenParsers with HttpComponents with StringStructOps with MiscOps {

  def capitalLetter = acceptIf {
    c: Rep[Char] => c >= unit('A') && c <= unit('Z')
  }

  //local whitespaces
  override def whitespaces: Parser[String] =
    repToS_f(accept(unit(' '))) // ^^^ {unit("")}

  //just keep the major and minor disctinction
  def decimalNumber: Parser[(Int, Int)] =
    wholeNumber ~ (accept(unit('.')) ~> wholeNumber)

  def wildChar = acceptIfIdx {
    x: Rep[Char] => x != unit('\n')
  }

  def wildRegex = stringStruct(wildChar)

  //TODO: ignoring \r for now
  def crlf = accept(unit('\n'))

  def status: Parser[Int] =
    (accept("HTTP/") ~ decimalNumber ~ whitespaces) ~> wholeNumber <~ (wildRegex ~ crlf)

  def repToSLower(p: Parser[Char]): Parser[String] =
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res + toLower(x))

  def headerName: Parser[StringStruct] = {
    letterIdx ~
      stringStruct(acceptIfIdx((x: Rep[Char]) => isLetter(x) || x == unit('-'))) ^^ {
        x: Rep[(Int, StringStruct)] => String(x._2.input, st = x._1, len = x._2.length + unit(1))
      }
  }

  //TODO: do filtering based on input. Option[(String,String)]
  def header: Parser[(StringStruct, StringStruct)] =
    (headerName <~ (whitespaces ~ accept(":"))) ~ (whitespaces ~> wildRegex <~ crlf)

  def headers: Parser[Response] = repFold(header)(Response(),
    (res: Rep[Response], hds: Rep[(StringStruct, StringStruct)]) => collect(res, hds._1, hds._2)
  )

  def response = status ~ headers <~ crlf ^^ {
    x =>
      Response(st = x._1, cL = x._2.contentLength, conn = x._2.connection,
        ch = x._2.chunked, up = x._2.upgrade)
  }

  //def body(i:Int) : Parser[String] = ("(?s:.{"+i+"})").r <~ crlf
  //def body(in:Rep[Input], n:Rep[Int]) =
  //  repNFold(acceptAll(in), n)(unit(""), (res: Rep[String], c: Rep[Char]) => res + c)
  def body(n: Rep[Int]) = Parser[String] { in =>
    if (in.offset + n < in.input.length) Success[String](
      String(in.input, in.offset, n).toStr,
      StringReader(in.input, in.offset + n)
    )
    else Failure[String](in)
  }

  def collect(res: Rep[Response], hName: Rep[StringStruct], prop: Rep[StringStruct]): Rep[Response] = {
    if ((hName == "connection" || hName == "proxy-connection")
      && (prop == "keep-alive" || prop == "close")) {
      Response(st = res.status, cL = res.contentLength, conn = prop.mkString,
        ch = res.chunked, up = res.upgrade)
    } else if (hName == "content-length") {
      Response(st = res.status, cL = prop.mkString.toInt, conn = res.connection,
        ch = res.chunked, up = res.upgrade)
    } else if (hName == "transfer-encoding" && prop == "chunked") {
      Response(st = res.status, cL = res.contentLength, conn = res.connection,
        ch = unit(true), up = res.upgrade)
    } else if (hName == "upgrade") {
      Response(st = res.status, cL = res.contentLength, conn = res.connection,
        ch = res.chunked, up = unit(true))
    } else {
      res
    }
  }

  def respAndMessage: Parser[(Response, String)] = response >> { rsp =>
    body(rsp.contentLength) ^^ { txt: Rep[String] => make_tuple2(rsp, txt) }
  }

  //TODO: chunked parser

  /*
    if(rsp.contentLength == 0)  <~ crlf(in)
      {
        if(rsp.chunked) chunkedParser
        else if(rsp.contentLength == 0) ""<~crlf
        else body(rsp.contentLength)
        //TODO: other cases to be dealt with
      } ^^ {(rsp, _)}
  }
*/
  //TODO: make case insensitive
  def requestType: Parser[String] =
    word.filter { s => requestTypes.contains(s) }

  //"[a-z]+".r
  def schema: Parser[String] = letter ~ repToS(letter) ^^ {
    x: Rep[(Char, String)] => x._1 + x._2
  }

  //"[a-z0-9-.]+".r
  def hostChar = acceptIf({ c: Rep[Char] =>
    isDigit(c) || isLetter(c) || c == unit('-') || c == unit('.')
  })

  def hostName: Parser[String] = hostChar ~ repToS(hostChar) ^^ {
    x: Rep[(Char, String)] => x._1 + x._2
  }

  def host(url: Rep[Url]): Parser[Url] =
    hostName ~ opt(accept(unit(':')) ~> wholeNumber) ^^ { x: Rep[(String, Option[Int])] =>
      if (x._2.isDefined) copyUrl(url)(hName = x._1, prt = x._2.get)
      else copyUrl(url)(hName = x._1)
    }

  //======predicates ===========//
  // defining them here because it helps in generating better code
  // than using the "or" combinator for parsers
  // in the vanilla version we are using regexes, so it's equivalent

  def isUrlChar(c: Rep[Char]) =
    c > unit(32.toChar) && c != unit('#') && c != unit('?') && c != unit(127.toChar)

  def isFragmentChar(c: Rep[Char]) =
    c > unit(32.toChar) && c != unit(127.toChar)

  def isQChar(c: Rep[Char]) =
    c > unit(32.toChar) && c != unit('#') && c != unit(127.toChar)

  //the toChar is a bit of a hack
  def urlChar: Parser[Char] = acceptIf(c => isUrlChar(c))

  def reqFragment(url: Rep[Url]): Parser[Url] =
    //the greediness of the first regex prevents ambiguity
    repToS(accept(unit('#'))) ~> repToS(acceptIf(c => isFragmentChar(c))) ^^ {
      x: Rep[String] => copyUrl(url)(frag = x)
    }

  //opt("HTTP/"~decimalNumber)
  def httpInfo = opt(accept("HTTP/") ~> decimalNumber)

  def queryString(url: Rep[Url]) =
    ((repToS(accept(unit('?'))) ~> repToS(acceptIf(c => isQChar(c))))
      ~ opt(accept(unit('#')) ~> reqFragment(url))) ^^ { x =>
        if (x._2.isDefined) copyUrl(x._2.get)(qString = x._1)
        else copyUrl(url)(qString = x._1)
      }

  def reqPath(url: Rep[Url]) =
    (repToS(urlChar) ~ opt(
      (accept(unit('?')) ~> queryString(url)) |
        (accept(unit('#')) ~> reqFragment(url))
    ) <~ httpInfo) ^^ { x =>
        if (x._2.isDefined) copyUrl(x._2.get)(pth = unit("/") + x._1)
        else copyUrl(url)(pth = unit("/") + x._1)
      }

  def url(init: Rep[Url]): Parser[Url] =
    ((schema <~ (accept("://")) | acceptIf(c => isDigit(c) || c == unit('.')) ^^ { x => unit("") + x })
      ~ opt(host(init))
      ~ ((accept(unit('/')) ~> reqPath(init)) |
        (accept(unit('?')) ~> queryString(init)) //|
      //("/|*".r ~> reqPath)
      )
    ) ^^
        { x =>
          //long live lifted pattern matching! hopefully happening soon
          //in a compiler near you.
          if (x._1._2.isDefined)
            copyUrl(x._2)(sch = x._1._1, hName = x._1._2.get.hostName)
          else copyUrl(x._2)(sch = x._1._1)
        }

  def requestStatus =
    requestType ~ (url(Url()) <~ crlf)

  def request =
    requestStatus ~ (headers <~ crlf)
}