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
    var s = Failure[(Int,Int)](unit(-1))
    val parser = (decimalNumber(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //wildRegex
  def wildRegexParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    val parser = (wildRegex(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //crlf
  def crlfParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = crlf(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //wildRegexCrlf
  def wildRegexCrlfParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    val parser = ((wildRegex(in)~crlf(in))^^{
      x: Rep[(String, Char)] => x._1 + x._2
    }).apply(unit(0))

    parser{x => s = x}
    println(s)
  }

  //url
  def urlCharParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = urlChar(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //
  def httpNumParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(Int,Int)](unit(0))
    val parser = (accept(in, "HTTP/")~>decimalNumber(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  def httpNumStatusParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Int](unit(-1))
    val parser =
      ((accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //status parse temp
  def statusParseTemp(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(Int,String)](unit(-1))

    val statusTemp: Parser[(Int,String)] =
      (accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)~(wildRegex(in)<~crlf(in))

    val parser = statusTemp.apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //status parse
  def statusParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Int](unit(-1))
    val parser = (status(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //headerName parse
  def headerNameParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    val parser = (headerName(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //header parse
  def headerParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(String, String)](unit(-1))
    val parser = header(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //headers parse
  def headersParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Response](unit(-1))
    val parser = headers(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //status and message
  def responseParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Response](unit(-1))
    val parser = response(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //body parse
  def bodyParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    //parsing "make it funky!"
    val parser = body(in, unit(14)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //response
  def respAndMessageParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(Response,String)](unit(-1))
    val parser = respAndMessage(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //request Type
  def reqTypeParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    val parser = requestType(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //host
  def hostParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Url](unit(-1))
    val parser = host(in, Url()).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //request fragment
  def reqFragmentParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Url](unit(-1))
    val parser = reqFragment(in, Url()).apply(unit(0))
    parser{x => s = x}
    println(s)
  }
}

class TestHttpParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testHttpParser = {
    withOutFile(prefix+"http-parser"){
      new HttpParserProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with OptionOpsExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
         with ScalaGenOptionOps{
          val IR: self.type = self
        }

        codegen.emitSource(decimalParse _ , "decimalParse", new java.io.PrintWriter(System.out))
        val testc1 = compile(decimalParse)
        testc1("12.34".toArray)

        codegen.emitSource(wildRegexParse _ , "wildRegexParse", new java.io.PrintWriter(System.out))
        val testc2 = compile(wildRegexParse)
        testc2("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray)

        codegen.emitSource(crlfParse _ , "crlfParse", new java.io.PrintWriter(System.out))
        val testcCrlf = compile(crlfParse)
        testcCrlf("\n".toArray)

        codegen.emitSource(wildRegexCrlfParse _ , "wildRegexCrlfParse", new java.io.PrintWriter(System.out))
        val testcWrc = compile(wildRegexCrlfParse)
        testcWrc("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray)

        codegen.emitSource(urlCharParse _ , "urlCharParse", new java.io.PrintWriter(System.out))
        val testcUrlCharParse = compile(urlCharParse)
        testcUrlCharParse("\n".toArray)

        codegen.emitSource(httpNumParse _ , "httpNumParse", new java.io.PrintWriter(System.out))
        val testc3 = compile(httpNumParse)
        testc3("HTTP/1.1 200".toArray)

        codegen.emitSource(httpNumStatusParse _ , "httpNumStatusParse", new java.io.PrintWriter(System.out))
        val testc4 = compile(httpNumStatusParse)
        testc4("HTTP/1.1 200".toArray)

        codegen.emitSource(statusParseTemp _ , "statusParseTemp", new java.io.PrintWriter(System.out))
        val testcstpTemp = compile(statusParseTemp)
        testcstpTemp("HTTP/1.1 200 ok \n".toArray)

      }
    }

    assertFileEqualsCheck(prefix+"http-parser")
  }

  def testRespParser = {
    withOutFile(prefix+"resp-parser"){
      new HttpParserProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with OptionOpsExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
         with ScalaGenOptionOps{
          val IR: self.type = self
        }

        codegen.emitSource(statusParse _ , "statusParse", new java.io.PrintWriter(System.out))
        val testcStatus = compile(statusParse)

        val statusMessages = scala.List(
          """HTTP/1.1 200 OK
          |""".stripMargin,

          """HTTP/1.1 418 I'm a teapot
          |""".stripMargin
        )

        statusMessages.foreach{sm =>
          testcStatus(sm.toArray)
        }

        codegen.emitSource(headerNameParse _ , "headerNameParse", new java.io.PrintWriter(System.out))
        val testcHeaderName = compile(headerNameParse)
        testcHeaderName("Date \n".toArray)

        codegen.emitSource(headerParse _ , "headerParse", new java.io.PrintWriter(System.out))
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

        headers.foreach{h =>
          testcHeader(h.toArray)
        }

        //an invalid header
        testcHeader("Date: Mon, 23 May 2005 22:38:34 GMT".toArray)

        val allHeaders = headers.mkString
        codegen.emitSource(headersParse _, "headersParse", new java.io.PrintWriter(System.out))
        val testcHeaders = compile(headersParse)
        testcHeaders(allHeaders.toArray)

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

        codegen.emitSource(responseParse _ , "responseParse", new java.io.PrintWriter(System.out))
        val testcResponse = compile(responseParse)
        testcResponse(httpMessage.toArray)

        codegen.emitSource(bodyParse _ , "bodyParse", new java.io.PrintWriter(System.out))
        val testcBody = compile(bodyParse)
        testcBody("Make it funky! -Maceo.".toArray)

        codegen.emitSource(respAndMessageParse _ , "respAndMessageParse", new java.io.PrintWriter(System.out))
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

        messages.foreach{msg =>
          testcRespAndMessage(msg.toArray)
        }
      }
    }

    assertFileEqualsCheck(prefix+"resp-parser")
  }
}

class TestReqParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testReqParser = {

    withOutFile(prefix+"req-parser"){
      new HttpParserProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with SetOpsExp with OptionOpsExp
        with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
         with ScalaGenSetOps with ScalaGenOptionOps{
          val IR: self.type = self
        }

        codegen.emitSource(reqTypeParse _ , "reqTypeParse", new java.io.PrintWriter(System.out))
        val testcReqParse = compile(reqTypeParse)
        requestTypesUnRepped.foreach{rType =>
          testcReqParse(rType.toArray)
        }
        testcReqParse("What".toArray) //failure case

        codegen.emitSource(hostParse _ , "hostParse", new java.io.PrintWriter(System.out))
        val testcHostParse = compile(hostParse)
        testcHostParse("123..asdf3.adf:90".toArray)
        testcHostParse("123..asdf3.adf".toArray)
        testcHostParse(" asd2".toArray) //failure case
        testcHostParse("123..asdf3.adf:a0".toArray) //failure case

        codegen.emitSource(reqFragmentParse _ , "reqFragmentParse", new java.io.PrintWriter(System.out))
        val testcReqFragmentParse = compile(reqFragmentParse)
        testcReqFragmentParse("##3adsfd.html".toArray)
        testcReqFragmentParse("##3asfd#adf".toArray)
        testcReqFragmentParse("asdf".toArray)


      }

    }
    assertFileEqualsCheck(prefix+"req-parser")
  }
}