package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait HttpParserProgBis extends HttpParserBis{

  //headerName parse
  def headerNameParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[StringStruct](unit(-1))
    val parser = (headerName(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //header parse
  def headerParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(StringStruct, StringStruct)](unit(-1))
    val parser = header(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //headers parse
  def headersParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Response](unit(-1))
    val parser = headers(in).apply(unit(0))
    parser{x: Rep[ParseResult[Response]] => s = x}
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
/*  def bodyParse(in: Rep[Array[Char]]): Rep[Unit] = {
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
*/
}

class TestHttpParserBis extends FileDiffSuite {

  val prefix = "test-out/"

  def testRespParser = {
    withOutFile(prefix+"resp-parser-bis"){
      new HttpParserProgBis with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with OptionOpsExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
         with ScalaGenOptionOps{
          val IR: self.type = self
        }

//        codegen.emitSource(headerNameParse _ , "headerNameParse", new java.io.PrintWriter(System.out))
//        val testcHeaderName = compile(headerNameParse)
//        testcHeaderName("Date \n".toArray)
//
//        codegen.emitSource(headerParse _ , "headerParse", new java.io.PrintWriter(System.out))
//        val testcHeader = compile(headerParse)

        val headers1 = scala.List(
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

        """|content-length: 131
           |""".stripMargin
        )

//        headers1.foreach{h =>
//          testcHeader(h.toArray)
//        }
//
//        //an invalid header
//        testcHeader("Date: Mon, 23 May 2005 22:38:34 GMT".toArray)
//
//        val allHeaders = headers1.mkString
//        codegen.emitSource(headersParse _, "headersParse", new java.io.PrintWriter(System.out))
//        val testcHeaders = compile(headersParse)
//        testcHeaders(allHeaders.toArray)

        //a status and some headers
        val httpMessage =
        """|HTTP/1.1 418 I'm a teapot
           |Date: Mon, 23 May 2005 22:38:34 GMT
           |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
           |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
           |Etag: "3f80f-1b6-3e1cb03b"
           |Content-Type: text/html; charset=UTF-8
           |content-length: 131
           |connection: close
           |
           |""".stripMargin

        codegen.emitSource(responseParse _ , "responseParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        val testcResponse = compile(responseParse)
        testcResponse(httpMessage.toArray)
/*
        codegen.emitSource(bodyParse _ , "bodyParse", new java.io.PrintWriter(System.out))
        val testcBody = compile(bodyParse)
        testcBody("Make it funky! -Maceo.".toArray)

        codegen.emitSource(respAndMessageParse _ , "respAndMessageParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
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
        */
      }
    }
    assertFileEqualsCheck(prefix+"resp-parser-bis")
  }
}