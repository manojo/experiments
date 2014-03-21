package lms.parsing

import lms._
import lms.util._
import examples._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait HttpParserProg extends HttpParser {

  //decimal number
  def decimalParse(in: Rep[Array[Char]]): Rep[Option[(Int, Int)]] = {
    val parser = decimalNumber
    phrase(parser, StringReader(in))
  }

  //wildRegex
  def wildRegexParse(in: Rep[Array[Char]]): Rep[Option[String]] = {
    val parser = wildRegex ^^ { x => x.mkString}
    phrase(parser, StringReader(in))
  }

  //crlf
  def crlfParse(in: Rep[Array[Char]]): Rep[Option[Char]] = {
    val parser = crlf
    phrase(parser, StringReader(in))
  }

  //wildRegexCrlf
  def wildRegexCrlfParse(in: Rep[Array[Char]]): Rep[Option[String]] = {
    val parser = (wildRegex <~ crlf) ^^ { x => x.mkString }
    phrase(parser, StringReader(in))
  }

  //url
  def urlCharParse(in: Rep[Array[Char]]): Rep[Option[Char]] = {
    val parser = urlChar
    phrase(parser, StringReader(in))
  }

  //
  def httpNumParse(in: Rep[Array[Char]]): Rep[Option[(Int, Int)]] = {
    val parser = accept("HTTP/") ~> decimalNumber
    phrase(parser, StringReader(in))
  }

  def httpNumStatusParse(in: Rep[Array[Char]]): Rep[Option[Int]] = {
    val parser = (accept("HTTP/") ~ decimalNumber ~ whitespaces) ~> wholeNumber
    phrase(parser, StringReader(in))
  }

  //status parse temp
  def statusParseTemp(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser: Parser[(Int, StringStruct)] =
      (accept("HTTP/") ~ decimalNumber ~ whitespaces) ~> wholeNumber ~ (wildRegex <~ crlf)

    val res = parser(StringReader(in))
    val tmp = res.get
    println(unit("(") + tmp._1 + unit(",") + tmp._2.mkString + unit(")"))
  }

  //status parse
  def statusParse(in: Rep[Array[Char]]): Rep[Option[Int]] = {
    val parser = status
    phrase(parser, StringReader(in))
  }

  //headerName parse
  def headerNameParse(in: Rep[Array[Char]]): Rep[Option[(Int, Int)]] = {
    val parser = headerName ^^ { x => make_tuple2(x.start, x.length) }
    phrase(parser, StringReader(in))
  }

  //header parse
  def headerParse(in: Rep[Array[Char]]): Rep[Option[((Int, Int), (Int, Int))]] = {
    val parser = header ^^ { x =>
      make_tuple2(
        make_tuple2(x._1.start, x._1.length),
        make_tuple2(x._2.start, x._2.length)
      )
    }
    phrase(parser, StringReader(in))
  }

  //headers parse
  def headersParse(in: Rep[Array[Char]]): Rep[Option[Response]] = {
    val parser = headers
    phrase(parser, StringReader(in))
  }

  //status and message
  def responseParse(in: Rep[Array[Char]]): Rep[Option[Response]] = {
    val parser = response
    phrase(parser, StringReader(in))
  }

  //body parse
  def bodyParse(in: Rep[Array[Char]]): Rep[Option[String]] = {
    //parsing "make it funky!"
    val parser = body(unit(0))
    phrase(parser, StringReader(in))
  }

  //response
  def respAndMessageParse(in: Rep[Array[Char]]): Rep[Option[(Response, String)]] = {
    val parser = respAndMessage
    phrase(parser, StringReader(in))
  }

  //request Type
  def reqTypeParse(in: Rep[Array[Char]]): Rep[Option[String]] = {
    val parser = requestType
    phrase(parser, StringReader(in))
  }

  //host
  def hostParse(in: Rep[Array[Char]]): Rep[Option[Url]] = {
    val parser = host(Url())
    phrase(parser, StringReader(in))
  }

  //request fragment
  def reqFragmentParse(in: Rep[Array[Char]]): Rep[Option[Url]] = {
    val parser = reqFragment(Url())
    phrase(parser, StringReader(in))
  }

  //queryString
  def qStringParse(in: Rep[Array[Char]]): Rep[Option[Url]] = {
    val parser = queryString(Url())
    phrase(parser, StringReader(in))
  }

  //reqPath
  def reqPathParse(in: Rep[Array[Char]]): Rep[Option[Url]] = {
    val parser = reqPath(Url())
    phrase(parser, StringReader(in))
  }

  //url
  def urlParse(in: Rep[Array[Char]]): Rep[Option[Url]] = {
    val parser = url(Url())
    phrase(parser, StringReader(in))
  }
}

class TestHttpParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testHttpParser = {
    withOutFile(prefix + "http-parser") {
      new HttpParserProg with MyScalaOpsPkgExp with CharOpsExp with MyIfThenElseExpOpt
        with StructOpsFatExpOptCommon with ParseResultOpsExp with OptionOpsExp
        with StringStructOpsExp with StringReaderOpsExp with BarrierOpsExp with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps with ScalaGenParseResultOps
          with ScalaGenFatStructOps with ScalaGenOptionOps with ScalaGenStringStructOps
          with ScalaGenReaderOps with ScalaGenBarrierOps with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        codegen.emitSource(decimalParse _, "decimalParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc1 = compile(decimalParse)
        scala.Console.println(testc1("12.34".toArray))
        codegen.reset

        codegen.emitSource(wildRegexParse _, "wildRegexParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(wildRegexParse)
        scala.Console.println(testc2("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray))
        codegen.reset

        codegen.emitSource(crlfParse _, "crlfParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcCrlf = compile(crlfParse)
        scala.Console.println(testcCrlf("\n".toArray))
        codegen.reset

        codegen.emitSource(wildRegexCrlfParse _, "wildRegexCrlfParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcWrc = compile(wildRegexCrlfParse)
        scala.Console.println(testcWrc("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray))
        codegen.reset

        codegen.emitSource(urlCharParse _, "urlCharParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcUrlCharParse = compile(urlCharParse)
        scala.Console.println(testcUrlCharParse("\n".toArray))
        codegen.reset

        codegen.emitSource(httpNumParse _, "httpNumParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc3 = compile(httpNumParse)
        scala.Console.println(testc3("HTTP/1.1 200".toArray))
        codegen.reset

        codegen.emitSource(httpNumStatusParse _, "httpNumStatusParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(httpNumStatusParse)
        scala.Console.println(testc4("HTTP/1.1 200".toArray))
        codegen.reset

        codegen.emitSource(statusParseTemp _, "statusParseTemp", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcstpTemp = compile(statusParseTemp)
        testcstpTemp("HTTP/1.1 200 ok \n".toArray)
        codegen.reset

      }
    }

    assertFileEqualsCheck(prefix + "http-parser")
  }

  def testRespParser = {
    withOutFile(prefix + "resp-parser") {
      new HttpParserProg with MyScalaOpsPkgExp with CharOpsExp with MyIfThenElseExpOpt
        with StructOpsFatExpOptCommon with ParseResultOpsExp with OptionOpsExp
        with StringStructOpsExp with StringReaderOpsExp with BarrierOpsExp
        with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps with ScalaGenParseResultOps
          with ScalaGenFatStructOps with ScalaGenOptionOps with ScalaGenStringStructOps
          with ScalaGenReaderOps with ScalaGenBarrierOps with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        codegen.emitSource(statusParse _, "statusParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStatus = compile(statusParse)

        val statusMessages = scala.List(
          """HTTP/1.1 200 OK
          |""".stripMargin,

          """HTTP/1.1 418 I'm a teapot
          |""".stripMargin
        )

        statusMessages.foreach { sm =>
          scala.Console.println(testcStatus(sm.toArray))
        }
        codegen.reset

        codegen.emitSource(headerNameParse _, "headerNameParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHeaderName = compile(headerNameParse)
        scala.Console.println(testcHeaderName("Date \n".toArray))
        codegen.reset

        codegen.emitSource(headerParse _, "headerParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHeader = compile(headerParse)

        val hdrs = scala.List(
          """|Date: Mon, 23 May 2005 22:38:34 GMT
           |""".stripMargin,

          """|Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
           |""".stripMargin,

          """|Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
           |""".stripMargin,

          """|Etag: \"3f80f-1b6-3e1cb03b\"
           |""".stripMargin,

          """|Content-Type: text/html; charset=UTF-8
           |""".stripMargin,

          """|Content-Length: 131
           |""".stripMargin
        )

        hdrs.foreach { h =>
          scala.Console.println(testcHeader(h.toArray))
        }

        //an invalid header
        scala.Console.println(testcHeader("Date: Mon, 23 May 2005 22:38:34 GMT".toArray))
        codegen.reset

        val allHeaders = hdrs.mkString
        codegen.emitSource(headersParse _, "headersParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHeaders = compile(headersParse)
        scala.Console.println(testcHeaders(allHeaders.toArray))
        codegen.reset

        //a status and some headers
        val httpMessage =
          """|HTTP/1.1 418 I'm a teapot
           |Date: Mon, 23 May 2005 22:38:34 GMT
           |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
           |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
           |Etag: "3f80f-1b6-3e1cb03b"
           |Content-Type: text/html; charset=UTF-8
           |Content-Length: 131
           |Connection: close
           |
           |""".stripMargin

        codegen.emitSource(responseParse _, "responseParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcResponse = compile(responseParse)
        scala.Console.println(testcResponse(httpMessage.toArray))
        codegen.reset

        codegen.emitSource(bodyParse _, "bodyParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcBody = compile(bodyParse)
        scala.Console.println(testcBody("Make it funky! -Maceo.".toArray))
        codegen.reset

        codegen.emitSource(respAndMessageParse _, "respAndMessageParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcRespAndMessage = compile(respAndMessageParse)

        val messages = scala.List(
          """|HTTP/1.1 200 OK
             |Date: Mon, 23 May 2005 22:38:34 GMT
             |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
             |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
             |Etag: "3f80f-1b6-3e1cb03b"
             |Content-Type: text/html; charset=UTF-8
             |Content-Length: 2
             |Connection: close
             |
             |AA
             |""".stripMargin,

          """|HTTP/1.1 200 OK
             |Date: Mon, 23 May 2005 22:38:34 GMT
             |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
             |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
             |Etag: "3f80f-1b6-3e1cb03b"
             |Content-Type: text/html; charset=UTF-8
             |Content-Length: 0
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
             |""".stripMargin,

          """HTTP/1.1 200 OK
            |Date: Mon, 23 May 2005 22:38:34 GMT
            |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
            |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
            |Etag: "3f80f-1b6-3e1cb03b"
            |Content-Type: text/html; charset=UTF-8
            |Content-Length: 129
            |Connection: close
            |
            |<html>
            |<head>
            |  <title>An Example Page</title>
            |</head>
            |<body>
            |  Hello World, this is a very simple HTML document.
            |</body>
            |</html>
            |""".stripMargin
        )

        messages.foreach { msg =>
          scala.Console.println(testcRespAndMessage(msg.toArray))
        }
        codegen.reset
      }
    }

    assertFileEqualsCheck(prefix + "resp-parser")
  }
}

/*
class TestReqParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testReqParser = {

    withOutFile(prefix+"req-parser"){
      new HttpParserProg with MyScalaOpsPkgExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with SetOpsExp with OptionOpsExp with StringStructOpsExp
        with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg
         with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
         with ScalaGenSetOps with ScalaGenOptionOps with ScalaGenStringStructOps{
          val IR: self.type = self
        }

        codegen.emitSource(reqTypeParse _ , "reqTypeParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcReqParse = compile(reqTypeParse)
        requestTypesUnRepped.foreach{rType =>
          testcReqParse(rType.toArray)
        }
        testcReqParse("What".toArray) //failure case
        codegen.reset

        codegen.emitSource(hostParse _ , "hostParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHostParse = compile(hostParse)
        testcHostParse("123..asdf3.adf:90".toArray)
        testcHostParse("123..asdf3.adf".toArray)
        testcHostParse(" asd2".toArray) //failure case
        testcHostParse("123..asdf3.adf:a0".toArray) //failure case
        codegen.reset

        codegen.emitSource(reqFragmentParse _ , "reqFragmentParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcReqFragmentParse = compile(reqFragmentParse)
        testcReqFragmentParse("##3adsfd.html".toArray)
        testcReqFragmentParse("##3asfd#adf".toArray)
        testcReqFragmentParse("asdf".toArray)
        codegen.reset

        codegen.emitSource(qStringParse _ , "qStringParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcQStringParse = compile(qStringParse)
        testcQStringParse("???asdf#sadf".toArray)
        testcQStringParse("???asdf?adsf#asdf".toArray)
        testcQStringParse("???asdf?adsf".toArray)
        testcQStringParse("asd".toArray)
        codegen.reset

        codegen.emitSource(reqPathParse _ , "reqPathParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcReqPathParse = compile(reqPathParse)
        testcReqPathParse("???asdf#sadf".toArray)
        testcReqPathParse("##asdfadsf".toArray)
        testcReqPathParse("adsfasd.html???asdf#adsf".toArray)
        testcReqPathParse("asd".toArray)
        codegen.reset

        codegen.emitSource(urlParse _ , "urlParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcUrlParse = compile(urlParse)

        val urls = scala.List(
          "http://en.wikipedia.org/wiki/URI_scheme",
          "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions?redirectlocale=en-US&redirectslug=JavaScript%2FGuide%2FRegular_Expressions",
          "http://en.wikipedia.org/wiki/List_of_HTTP_headers#Responses",
          "ldap://ldap1.example.net:6666/o=University%20of%20Michigan, c=US??sub?(cn=Babs%20Jensen)"
        )

        urls.foreach{url =>
          testcUrlParse(url.toArray)
        }
        codegen.reset

      }

    }
    assertFileEqualsCheck(prefix+"req-parser")
  }
}*/