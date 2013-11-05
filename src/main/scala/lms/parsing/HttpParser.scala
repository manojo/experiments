package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait HttpComponents extends lms.StructOps with SetOps{

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

  def copyUrl(url: Rep[Url])(sch: Rep[String] = url.schema, hName: Rep[String] = url.hostName,
           pth: Rep[String] = url.path, qString: Rep[String] = url.queryString,
           frag: Rep[String] = url.fragment, prt: Rep[Int] = url.port
  ) = Url(sch, hName, pth, qString, frag, prt)

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
    ch: Rep[Boolean] = unit(false), up: Rep[Boolean] = unit(false)
  ) : Rep[Request] = new Record{
   val requestType = rType
   val uri = url
   val contentLength = cL
   val connection = conn
   val chunked = ch
   val upgrade = up
  }

  def copyRequest(req: Rep[Request])(rType: Rep[String] = req.requestType, url: Rep[Url] = req.uri,
           cL: Rep[Int] = req.contentLength, conn: Rep[String] = req.connection,
           ch: Rep[Boolean] = req.chunked, up: Rep[Boolean] = req.upgrade
  ) = Request(rType, url, cL, conn, ch, up)

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


trait HttpParser extends TokenParsers with HttpComponents with StringStructOps{

  def toLower(c: Rep[Char]): Rep[Char] =
    (c.toInt | unit(0x20)).toChar

  def capitalLetter(in:Rep[Input]) = {
    acceptIf(in, {
      c: Rep[Char] => c >= unit('A') && c <= unit('Z')
    })
  }

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS_f(accept(in, unit(' ')))// ^^^ {unit("")}

  //just keep the major and minor disctinction
  def decimalNumber(in: Rep[Input]): Parser[(Int,Int)] =
    wholeNumber(in)~(accept(in, unit('.'))~>wholeNumber(in))

  def wildChar(in:Rep[Input]) = acceptIfIdx(in, {
    x: Rep[Char] => x != unit('\n')
  })

  def wildRegex(in: Rep[Input]) = stringStruct(in,wildChar(in))

  //TODO: ignoring \r for now
  def crlf(in:Rep[Input]) = accept(in, unit('\n'))

  def status(in: Rep[Input]): Parser[Int] =
    (accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)<~(wildRegex(in)~crlf(in))

  def repToSLower(p: Parser[Char]) : Parser[String] =
    repFold(p)(unit(""), (res: Rep[String], x: Rep[Char]) => res + toLower(x))

  def headerName(in: Rep[Input]): Parser[StringStruct] =
    letterIdx(in)~stringStruct(in, letterIdx(in) | acceptIdx(in, unit('-'))) ^^ {
      x: Rep[(Int, StringStruct)] => String(in, st = x._1, len = x._2.length + unit(1))
    }

  //TODO: do filtering based on input. Option[(String,String)]
  def header(in: Rep[Input]): Parser[(StringStruct, StringStruct)] =
    (headerName(in)<~(whitespaces(in)~accept(in,":")))~(whitespaces(in)~>wildRegex(in)<~crlf(in))

  def headers(in: Rep[Input]): Parser[Response] = repFold(header(in))(Response(),
    (res: Rep[Response], hds: Rep[(StringStruct,StringStruct)]) => collect(res, hds._1, hds._2)
  )

  def response(in: Rep[Input]) = status(in)~headers(in)<~crlf(in) ^^{
    x => Response(st = x._1, cL = x._2.contentLength, conn = x._2.connection,
        ch = x._2.chunked, up = x._2.upgrade)
  }

  //def body(i:Int) : Parser[String] = ("(?s:.{"+i+"})").r <~ crlf
  //def body(in:Rep[Input], n:Rep[Int]) =
  //  repNFold(acceptAll(in), n)(unit(""), (res: Rep[String], c: Rep[Char]) => res + c)
  def body(in:Rep[Input], n:Rep[Int]) = Parser[StringStruct] { i =>
    if (i+n<in.length) elGen(Success[StringStruct](String(in,i,i+n),n))
    else elGen(Failure[StringStruct](i))
  }

  def collect(res: Rep[Response], hName: Rep[StringStruct], prop: Rep[StringStruct]) : Rep[Response] =
    if((hName == "connection" || hName == "proxy-connection")
      && (prop == "keep-alive" || prop == "close")
    ){
      Response(st = res.status, cL = res.contentLength, conn = prop.mkString,
        ch = res.chunked, up = res.upgrade)
    }else if(hName == "content-length"){
      Response(st = res.status, cL = prop.mkString.toInt, conn = res.connection,
        ch = res.chunked, up = res.upgrade)
    }else if(hName == "transfer-encoding" && prop == "chunked"){
      Response(st = res.status, cL = res.contentLength, conn = res.connection,
        ch = unit(true), up = res.upgrade)
    }else if(hName == "upgrade"){
      Response(st = res.status, cL = res.contentLength, conn = res.connection,
        ch = res.chunked, up = unit(true))
    }else {
      res
    }

  def respAndMessage(in: Rep[Input]): Parser[(Response,StringStruct)] = response(in) >> { rsp =>
    body(in, rsp.contentLength) ^^ {txt: Rep[StringStruct] => make_tuple2(rsp, txt)}
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
  def requestType(in: Rep[Input]): Parser[String] =
    word(in).filter{s => requestTypes.contains(s)}

  //"[a-z]+".r
  def schema(in: Rep[Input]): Parser[String] = letter(in)~repToS(letter(in)) ^^ {
    x:Rep[(Char,String)] => x._1 + x._2
  }

  //"[a-z0-9-.]+".r
  def hostChar(in: Rep[Input]) = acceptIf(in, {c: Rep[Char] =>
    isDigit(c) || isLetter(c) || c == unit('-') || c == unit('.')
  })

  def hostName(in: Rep[Input]): Parser[String] = hostChar(in)~repToS(hostChar(in)) ^^ {
    x:Rep[(Char,String)] => x._1 + x._2
  }

  def host(in: Rep[Input], url: Rep[Url]): Parser[Url] =
    hostName(in) ~ opt(accept(in,unit(':')) ~> wholeNumber(in)) ^^ { x: Rep[(String, Option[Int])] =>
      if(x._2.isDefined) copyUrl(url)(hName = x._1, prt = x._2.get)
      else copyUrl(url)(hName = x._1)
    }

  //======predicates ===========//
  // defining them here because it helps in generating better code
  // than using the "or" combinator for parsers
  // in the vanilla version we are using regexes, so it's equivalent

  def isUrlChar(c:Rep[Char]) =
    c > unit(32.toChar) && c !=unit('#') && c != unit('?') && c != unit(127.toChar)

  def isFragmentChar(c: Rep[Char]) =
    c > unit(32.toChar) && c != unit(127.toChar)

  def isQChar(c : Rep[Char]) =
    c > unit(32.toChar) && c !=unit('#') && c != unit(127.toChar)


  //the toChar is a bit of a hack
  def urlChar(in: Rep[Input]): Parser[Char] = acceptIf(in, c => isUrlChar(c))

  def reqFragment(in: Rep[Input], url: Rep[Url]) : Parser[Url] =
    //the greediness of the first regex prevents ambiguity
    repToS(accept(in, unit('#'))) ~> repToS(acceptIf(in, c => isFragmentChar(c))) ^^{
      x: Rep[String] => copyUrl(url)(frag = x)
    }

  //opt("HTTP/"~decimalNumber)
  def httpInfo(in: Rep[Input]) = opt(accept(in, "HTTP/") ~> decimalNumber(in))

  def queryString(in: Rep[Input], url: Rep[Url]) =
    ((repToS(accept(in, unit('?'))) ~> repToS(acceptIf(in, c => isQChar(c))))
    ~ opt(accept(in,unit('#')) ~> reqFragment(in, url))) ^^ { x =>
      if(x._2.isDefined) copyUrl(x._2.get)(qString = x._1)
      else copyUrl(url)(qString = x._1)
    }

  def reqPath(in: Rep[Input], url: Rep[Url]) =
    (repToS(urlChar(in)) ~ opt(
      (accept(in, unit('?')) ~> queryString(in, url)) |
      (accept(in, unit('#')) ~> reqFragment(in, url))
    ) <~ httpInfo(in)) ^^ { x =>
      if(x._2.isDefined) copyUrl(x._2.get)(pth = unit("/")+x._1)
      else copyUrl(url)(pth = unit("/") + x._1)
    }

  def url(in: Rep[Input], init: Rep[Url]) : Parser[Url] =
    ((schema(in) <~ (accept(in,"://")) | acceptIf(in, c => isDigit(c) || c == unit('.')) ^^{x => unit("")+x})
      ~ opt(host(in, init))
      ~ ((accept(in,unit('/')) ~> reqPath(in,init)) |
         (accept(in,unit('?')) ~> queryString(in, init)) //|
          //("/|*".r ~> reqPath)
        )
    ) ^^
    { x =>
      //long live lifted pattern matching! hopefully happening soon
      //in a compiler near you.
      if(x._1._2.isDefined)
        copyUrl(x._2)(sch = x._1._1, hName = x._1._2.get.hostName)
      else copyUrl(x._2)(sch = x._1._1)
    }

  def requestStatus(in: Rep[Input]) =
    requestType(in) ~ (url(in, Url()) <~ crlf(in))

  def request(in: Rep[Input]) =
    requestStatus(in) ~ (headers(in) <~ crlf(in))
}
