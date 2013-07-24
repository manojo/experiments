package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait HttpComponents extends Structs{

  type Response = Record {
    val status: Int
    val contentLength: Int
    val connection: String
    val chunked: Boolean
    val upgrade: Boolean

  }

  def Response(st: Rep[Int] = unit(200), cL: Rep[Int] = unit(0),
               conn: Rep[String] = unit("close"), ch: Rep[Boolean] = unit(false),
               up: Rep[Boolean] = unit(false)) : Rep[Response] = new Record{
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

  def Url( sch: Rep[String] = unit(""), hName: Rep[String] = unit(""),
           pth: Rep[String] = unit(""), qString: Rep[String] = unit(""),
           frag: Rep[String] = unit(""), prt: Rep[Int] = unit(80)
  ) : Rep[Url] = new Record{
    val schema = sch
    val hostName = hName
    val path = pth
    val queryString = qString
    val fragment = frag
    val port = prt
  }

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
    ch: Rep[Boolean] = unit(false), up: Rep[Boolean] = unit(false)
  ) : Rep[Request] = new Record{
   val requestType = rType
   val uri = url
   val contentLength = cL
   val connection = conn
   val chunked = ch
   val upgrade = up

  }

}


trait HttpParser extends TokenParsers with HttpComponents {

  val crlf = """\r?\n""".r

  val wildRegex = """[^\r\n]*""".r
  val headerName = """[A-Z][\w-]*""".r
  val hexNumber = """[0-9A-F]+""".r
  // 0x23 == '#', 0x74 == 'del'
  val urlChar = """[^\x00-\x20#\?\x7F]""".r

  def capitalLetter(in:Rep[Input]) = {
    acceptIf(in, {
      c: Rep[Char] => c >= unit('A') && c <= unit('Z')
    })
  }

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    rep(accept(in, unit(' '))) ^^^ {unit("")}

  //just keep the major and minor disctinction
  def decimalNumber(in: Rep[Input]): Parser[(Int,Int)] =
    wholeNumber(in)~(accept(in, unit('.'))~>wholeNumber(in))

  def wildChar(in:Rep[Input]) = acceptIf(in, {
    x: Rep[Char] => x != unit('\n')
  })

  def wildRegex(in: Rep[Input]) = repToS(wildChar(in))

  //TODO: ignoring \r for now
  def crlf(in:Rep[Input]) = accept(in, unit('\n'))

  def status(in: Rep[Input]): Parser[Int] =
    (accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)<~(wildRegex(in)~crlf(in))

  def headerName(in: Rep[Input]): Parser[String] =
    capitalLetter(in)~repToS(letter(in) | accept(in, unit('-'))) ^^ {
      x: Rep[(Char, String)] => x._1 + x._2
    }

  //TODO: do filtering based on input. Option[(String,String)]
  def header(in: Rep[Input]): Parser[(String, String)] =
    (headerName(in)<~(whitespaces(in)~accept(in,":")))~(whitespaces(in)~>wildRegex(in)<~crlf(in))

  def headers(in: Rep[Input]) = repFold(header(in))(Response(),
    (res: Rep[Response], hds: Rep[(String,String)]) => collect(res, hds._1, hds._2)
  )

  def response(in: Rep[Input]) = status(in)~headers(in)<~crlf(in) ^^{
    x: Rep[(Int, Response)] => Response(st = x._1, cL = x._2.contentLength, conn = x._2.connection,
        ch = x._2.chunked, up = x._2.upgrade)
  }

  //def body(i:Int) : Parser[String] = ("(?s:.{"+i+"})").r <~ crlf
  def body(in:Rep[Input], n:Rep[Int]) =
    repNFold(acceptAll(in), n)(unit(""), (res: Rep[String], c: Rep[Char]) => res + c)

  def collect(res: Rep[Response], hName: Rep[String], prop: Rep[String]) : Rep[Response] =
    if((hName == unit("connection") || hName == unit("proxy-connection"))
      && (prop == unit("keep-alive") || prop == unit("close"))
    ){
      Response(st = res.status, cL = res.contentLength, conn = prop,
        ch = res.chunked, up = res.upgrade)
    }else if(hName == unit("Content-Length")){
      Response(st = res.status, cL = prop.toInt, conn = res.connection,
        ch = res.chunked, up = res.upgrade)
    }else if(hName == unit("Transfer-Encoding") && prop == unit("chunked")){
      Response(st = res.status, cL = res.contentLength, conn = res.connection,
        ch = unit(true), up = res.upgrade)
    }else if(hName == unit("upgrade")){
      Response(st = res.status, cL = res.contentLength, conn = res.connection,
        ch = res.chunked, up = unit(true))
      ///*res.upgrade = unit(true);*/ res
    }else {
      res
    }

  /*def collect(res: Rep[Response], hName: Rep[String], prop: Rep[String]) : Rep[Response] = hName match {
    case "connection" | "proxy-connection"
      if (prop == "keep-alive" || prop == "close") => res.connection = prop; res
    case "content-length" => res.contentLength = prop.toInt; res //TODO: deal with numformatexception
    case "transfer-encoding" if (prop == unit("chunked")) => res.chunked = true; res
    case "upgrade" => res.upgrade = true; res
    case _ => res
  }*/

  def respAndMessage(in: Rep[Input]): Parser[(Response,String)] = response(in) >> { rsp =>
    body(in, rsp.contentLength) ^^ {txt: Rep[String] => make_tuple2(rsp, txt)}
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

}