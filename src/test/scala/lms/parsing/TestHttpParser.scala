package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait HttpParserProg extends HttpParser{

  //decimal number
  def decimalParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (decimalNumber(in))
    val res = parser(unit(0))
    println(res)
  }

  //wildRegex
  def wildRegexParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (wildRegex(in))
    val res = parser(unit(0))
    println(res.get.mkString)
  }

  //crlf
  def crlfParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = crlf(in)
    val res = parser(unit(0))
    println(res)
  }

  //wildRegexCrlf
  def wildRegexCrlfParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (wildRegex(in)<~crlf(in))
    val res = parser(unit(0))
    println(res.get.mkString)
  }

  //url
  def urlCharParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = urlChar(in)
    val res = parser(unit(0))
    println(res)
  }

  //
  def httpNumParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (accept(in, "HTTP/")~>decimalNumber(in))
    val res = parser(unit(0))
    println(res)
  }

  def httpNumStatusParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser =
      ((accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in))
    val res = parser(unit(0))
    println(res)
  }

  //status parse temp
  def statusParseTemp(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser: Parser[(Int,StringStruct)] =
      (accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)~(wildRegex(in)<~crlf(in))
    val res = parser(unit(0))
    val tmp = res.get
    println(unit("(") + tmp._1 + unit(",") + tmp._2.mkString + unit(")"))
  }

  //status parse
  def statusParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (status(in))
    val res = parser(unit(0))
    println(res)
  }

  //headerName parse
  def headerNameParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (headerName(in))^^{x => make_tuple2(x.start, x.length)}
    val res = parser(unit(0))
    println(res)
  }

  //header parse
  def headerParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = header(in)^^{x =>
      make_tuple2(
        make_tuple2(x._1.start, x._1.length),
        make_tuple2(x._2.start, x._2.length)
      )
      }
    val res = parser(unit(0))
    println(res)
  }

  //headers parse
  def headersParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = headers(in)
    val res = parser(unit(0))
    println(res)
  }

  //status and message
  def responseParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = response(in)
    val res = parser(unit(0))
    println(res)
  }

  //body parse
  def bodyParse(in: Rep[Array[Char]]): Rep[Unit] = {
    //parsing "make it funky!"
    val parser = body(in, unit(0))
    val res = parser(unit(0))
    println(res)
  }

  //response
  def respAndMessageParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = respAndMessage(in)
    val res = parser(unit(0))
    println(res)
  }

  //request Type
  def reqTypeParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = requestType(in)
    val res = parser(unit(0))
    println(res)
  }

  //host
  def hostParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = host(in, Url())
    val res = parser(unit(0))
    println(res)
  }

  //request fragment
  def reqFragmentParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = reqFragment(in, Url())
    val res = parser(unit(0))
    println(res)
  }

  //queryString
  def qStringParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = queryString(in, Url())
    val res = parser(unit(0))
    println(res)
  }

  //reqPath
  def reqPathParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = reqPath(in, Url())
    val res = parser(unit(0))
    println(res)
  }

  //url
  def urlParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = url(in, Url())
    val res = parser(unit(0))
    println(res)
  }
}

/*
// TCK BEGIN
object TestHttpCParser {
  import java.io._

  class Writer(file:String) extends HttpParserProg with MyScalaOpsPkgExp with GeneratorOpsExp
    with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
    with ParseResultOpsExp with OptionOpsExp with StringStructOpsExp { self =>
    val codegen = new MyCCodeGenPkg with CGenGeneratorOps
      with CGenCharOps with CGenParseResultOps with CGenStructOps
      with CGenOptionOps with CGenStringStructOps { val IR: self.type = self }
    val buf = new ByteArrayOutputStream()
    val pr = new PrintWriter(buf)
    def close {
      val out=new FileOutputStream(file); val pr2=new java.io.PrintWriter(out)
      pr2.print("#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <stdbool.h>\n\n")
      codegen.emitDataStructures(pr2); pr2.flush; pr.flush; pr.close; out.write(buf.toByteArray); out.close
      System.out.println("Written in "+file)
    }
  }
  class Gen() extends HttpParserProg with MyScalaOpsPkgExp with GeneratorOpsExp
    with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
    with ParseResultOpsExp with OptionOpsExp with StringStructOpsExp with MyScalaCompile{self =>
      val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
      with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
      with ScalaGenOptionOps with ScalaGenStringStructOps { val IR: self.type = self }
  }
  def read(file:String) = scala.io.Source.fromFile(file).mkString.toArray

  def main(args:Array[String]) {
    val s = read("src/main/c/tweet1")
    val g = new Gen()
    val f = g.compile(g.respAndMessageParse)
    println(f(s))
    val w = new Writer("src/main/c/http_gen_full2.h")
    w.codegen.emitSource(w.respAndMessageParse _ , "respAndMessageParse", w.pr)
    w.close
    /*
    val w = new Writer("src/main/c/http_gen.h")
    w.codegen.emitSource(w.responseParse _ , "responseParse", w.pr)
    w.codegen.emitSource(w.bodyParse _ , "bodyParse", w.pr)
    w.close
    */
    /*
    val w2 = new Writer("src/main/c/http_gen_head.h")
    w2.codegen.emitSource(w2.httpNumStatusParse _ , "httpNumStatusParse", w2.pr)
    w2.close
    */
  }
}
// TCK END
*/

class TestHttpParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testHttpParser = {
    withOutFile(prefix+"http-parser"){
      new HttpParserProg with MyScalaOpsPkgExp with CharOpsExp
      with MyIfThenElseExpOpt with StructOpsFatExpOptCommon
      with ParseResultOpsExp with OptionOpsExp
      with StringStructOpsExp with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps
        with ScalaGenParseResultOps with ScalaGenFatStructOps
        with ScalaGenOptionOps with ScalaGenStringStructOps
        with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        codegen.emitSource(decimalParse _ , "decimalParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc1 = compile(decimalParse)
        testc1("12.34".toArray)
        codegen.reset

        codegen.emitSource(wildRegexParse _ , "wildRegexParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(wildRegexParse)
        testc2("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray)
        codegen.reset

        codegen.emitSource(crlfParse _ , "crlfParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcCrlf = compile(crlfParse)
        testcCrlf("\n".toArray)
        codegen.reset

        codegen.emitSource(wildRegexCrlfParse _ , "wildRegexCrlfParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcWrc = compile(wildRegexCrlfParse)
        testcWrc("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray)
        codegen.reset

        codegen.emitSource(urlCharParse _ , "urlCharParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcUrlCharParse = compile(urlCharParse)
        testcUrlCharParse("\n".toArray)
        codegen.reset

        codegen.emitSource(httpNumParse _ , "httpNumParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc3 = compile(httpNumParse)
        testc3("HTTP/1.1 200".toArray)
        codegen.reset

        codegen.emitSource(httpNumStatusParse _ , "httpNumStatusParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(httpNumStatusParse)
        testc4("HTTP/1.1 200".toArray)
        codegen.reset

        codegen.emitSource(statusParseTemp _ , "statusParseTemp", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcstpTemp = compile(statusParseTemp)
        testcstpTemp("HTTP/1.1 200 ok \n".toArray)
        codegen.reset

      }
    }

    assertFileEqualsCheck(prefix+"http-parser")
  }

  def testRespParser = {
    withOutFile(prefix+"resp-parser"){
      new HttpParserProg with MyScalaOpsPkgExp with CharOpsExp
      with MyIfThenElseExpOpt with StructOpsFatExpOptCommon
      with ParseResultOpsExp with OptionOpsExp
      with StringStructOpsExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps
        with ScalaGenParseResultOps with ScalaGenFatStructOps
        with ScalaGenOptionOps with ScalaGenStringStructOps
        with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        //codegen.emitSource(statusParse _ , "statusParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStatus = compile(statusParse)

        val statusMessages = scala.List(
          """HTTP/1.1 200 OK
          |""".stripMargin,

          """HTTP/1.1 418 I'm a teapot
          |""".stripMargin
        )

        //statusMessages.foreach{sm =>
        //  testcStatus(sm.toArray)
        //}
        codegen.reset

        //codegen.emitSource(headerNameParse _ , "headerNameParse", new java.io.PrintWriter(System.out))
        codegen.reset

        //val testcHeaderName = compile(headerNameParse)
        //testcHeaderName("Date \n".toArray)
        codegen.reset

        //codegen.emitSource(headerParse _ , "headerParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHeader = compile(headerParse)

        val headers = scala.List(
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

        //headers.foreach{h =>
        //  testcHeader(h.toArray)
        //}

        //an invalid header
        //testcHeader("Date: Mon, 23 May 2005 22:38:34 GMT".toArray)
        codegen.reset

        val allHeaders = scala.List(headers.head, headers.last).mkString
        codegen.emitSource(headersParse _, "headersParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHeaders = compile(headersParse)
        testcHeaders(allHeaders.toArray)
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

        //codegen.emitSource(responseParse _ , "responseParse", new java.io.PrintWriter(System.out))
        codegen.reset

        //val testcResponse = compile(responseParse)
        //testcResponse(httpMessage.toArray)
        codegen.reset

        //codegen.emitSource(bodyParse _ , "bodyParse", new java.io.PrintWriter(System.out))
        codegen.reset

        //val testcBody = compile(bodyParse)
        //testcBody("Make it funky! -Maceo.".toArray)
        codegen.reset

        //codegen.emitSource(respAndMessageParse _ , "respAndMessageParse", new java.io.PrintWriter(System.out))
        //codegen.emitDataStructures(new java.io.PrintWriter(System.out))
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

        //messages.foreach{msg =>
        //  testcRespAndMessage(msg.toArray)
        //}
        codegen.reset
      }
    }

    assertFileEqualsCheck(prefix+"resp-parser")
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
}
*/
