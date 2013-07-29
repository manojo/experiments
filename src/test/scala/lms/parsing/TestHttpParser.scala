package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait HttpParserProg extends HttpParser{

  //decimal number
  def decimalParse(in: Rep[Array[Char]]): Rep[((Int,Int),Int)] = {
    var s = make_tuple2(make_tuple2(unit(0), unit(0)), unit(-1))
    val parser = (decimalNumber(in)).apply(unit(0))
    parser{x: Rep[((Int,Int), Int)] => s = x}
    s
  }

  //wildRegex
  def wildRegexParse(in: Rep[Array[Char]]): Rep[(String,Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = (wildRegex(in)).apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //crlf
  def crlfParse(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = crlf(in).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //wildRegexCrlf
  def wildRegexCrlfParse(in: Rep[Array[Char]]): Rep[(String,Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = ((wildRegex(in)~crlf(in))^^{
      x: Rep[(String, Char)] => x._1 + x._2
    }).apply(unit(0))

    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //url
  def urlCharParse(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = urlChar(in).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //
  def httpNumParse(in: Rep[Array[Char]]): Rep[((Int, Int),Int)] = {
    var s = make_tuple2(make_tuple2(unit(0), unit(0)), unit(-1))
    val parser = (accept(in, "HTTP/")~>decimalNumber(in)).apply(unit(0))
    parser{x: Rep[((Int, Int), Int)] => s = x}
    s
  }

  def httpNumStatusParse(in: Rep[Array[Char]]): Rep[(Int,Int)] = {
    var s = make_tuple2(unit(0), unit(-1))
    val parser =
      ((accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)).apply(unit(0))
    parser{x: Rep[(Int, Int)] => s = x}
    s
  }

  //status parse temp
  def statusParseTemp(in: Rep[Array[Char]]): Rep[((Int,String),Int)] = {
    var s = make_tuple2(make_tuple2(unit(0),unit("")), unit(-1))

    val statusTemp: Parser[(Int,String)] =
      (accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)~(wildRegex(in)<~crlf(in))

    val parser = statusTemp.apply(unit(0))
    parser{x: Rep[((Int, String), Int)] => s = x}
    s
  }

  //status parse
  def statusParse(in: Rep[Array[Char]]): Rep[(Int,Int)] = {
    var s = make_tuple2(unit(0), unit(-1))
    val parser = (status(in)).apply(unit(0))
    parser{x: Rep[(Int, Int)] => s = x}
    s
  }

  //headerName parse
  def headerNameParse(in: Rep[Array[Char]]): Rep[(String,Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = (headerName(in)).apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //header parse
  def headerParse(in: Rep[Array[Char]]): Rep[((String, String),Int)] = {
    var s = make_tuple2(make_tuple2(unit(""),unit("")), unit(-1))
    val parser = header(in).apply(unit(0))
    parser{x: Rep[((String,String), Int)] => s = x}
    s
  }

  //type Response = (Int, List[(String,String)])

  //status and message
  def responseParse(in: Rep[Array[Char]]): Rep[(Response, Int)] = {
    var s = make_tuple2(Response(), unit(-1))
    val parser = response(in).apply(unit(0))
    parser{x: Rep[(Response,Int)] => s = x}
    s
  }

  //body parse
  def bodyParse(in: Rep[Array[Char]]): Rep[(String, Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    //parsing "make it funky!"
    val parser = body(in, unit(14)).apply(unit(0))
    parser{x: Rep[(String,Int)] => s = x}
    s
  }

  //response
  def respAndMessageParse(in: Rep[Array[Char]]): Rep[((Response,String), Int)] = {
    var s = make_tuple2(make_tuple2(Response(),unit("")), unit(-1))
    val parser = respAndMessage(in).apply(unit(0))
    parser{x: Rep[((Response,String),Int)] => s = x}
    s
  }

  def reqTypeParse(in: Rep[Array[Char]]): Rep[(String, Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = requestType(in).apply(unit(0))
    parser{x: Rep[(String,Int)] => s = x}
    s
  }

  def optionParse(in: Rep[Array[Char]]): Rep[(Option, Int)] = {
    var s = make_tuple2(None, unit(-1))
    val parser = opt(headerName(in)).apply(unit(0))
    parser{x: Rep[(Option,Int)] => s = x}
    s
  }

}

class TestHttpParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testHttpParser = {
    withOutFile(prefix+"http-parser"){
       new HttpParserProg with ScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with StructExpOptCommon with MyScalaCompile{self =>

        val codegen = new ScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenStruct{
          val IR: self.type = self
        }

        codegen.emitSource(decimalParse _ , "decimalParse", new java.io.PrintWriter(System.out))
        val testc1 = compile(decimalParse)
        val res1 = testc1("12.34".toArray)
        scala.Console.println(res1)

        codegen.emitSource(wildRegexParse _ , "wildRegexParse", new java.io.PrintWriter(System.out))
        val testc2 = compile(wildRegexParse)
        val res2 = testc2("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray)
        scala.Console.println(res2)

        codegen.emitSource(crlfParse _ , "crlfParse", new java.io.PrintWriter(System.out))
        val testcCrlf = compile(crlfParse)
        val resCrlf = testcCrlf("\n".toArray)
        scala.Console.println(resCrlf)

        codegen.emitSource(wildRegexCrlfParse _ , "wildRegexCrlfParse", new java.io.PrintWriter(System.out))
        val testcWrc = compile(wildRegexCrlfParse)
        val resWrc = testcWrc("f33l l1ke funkin' it up! (o_^) \\o/ \n".toArray)
        scala.Console.println(resWrc)

        codegen.emitSource(urlCharParse _ , "urlCharParse", new java.io.PrintWriter(System.out))
        val testcUrlCharParse = compile(urlCharParse)
        val resUrlCharParse = testcUrlCharParse("\n".toArray)
        scala.Console.println(resUrlCharParse)

        codegen.emitSource(httpNumParse _ , "httpNumParse", new java.io.PrintWriter(System.out))
        val testc3 = compile(httpNumParse)
        val res3 = testc3("HTTP/1.1 200".toArray)
        scala.Console.println(res3)

        codegen.emitSource(httpNumStatusParse _ , "httpNumStatusParse", new java.io.PrintWriter(System.out))
        val testc4 = compile(httpNumStatusParse)
        val res4 = testc4("HTTP/1.1 200".toArray)
        scala.Console.println(res4)

        codegen.emitSource(statusParseTemp _ , "statusParseTemp", new java.io.PrintWriter(System.out))
        val testcstpTemp = compile(statusParseTemp)
        val rescstpTemp = testcstpTemp("HTTP/1.1 200 ok \n".toArray)
        scala.Console.println(rescstpTemp)

/*        codegen.emitSource(statusParse _ , "statusParse", new java.io.PrintWriter(System.out))
        val testcStatus = compile(statusParse)
        val rescStatus = testcStatus("HTTP/1.1 200 ok \n".toArray)
        scala.Console.println(rescStatus)
*/
        codegen.emitSource(statusParse _ , "statusParse", new java.io.PrintWriter(System.out))
        val testcStatus = compile(statusParse)

        val statusMessages = scala.List(
          """HTTP/1.1 200 OK
          |""".stripMargin,

          """HTTP/1.1 418 I'm a teapot
          |""".stripMargin
        )

        statusMessages.foreach{sm =>
          scala.Console.println(testcStatus(sm.toArray))
        }

        codegen.emitSource(headerNameParse _ , "headerNameParse", new java.io.PrintWriter(System.out))
        val testcHeaderName = compile(headerNameParse)
        val resHeaderName = testcHeaderName("Date \n".toArray)
        scala.Console.println(resHeaderName)

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
          scala.Console.println(testcHeader(h.toArray))
        }

        //an invalid header
        scala.Console.println(testcHeader("Date: Mon, 23 May 2005 22:38:34 GMT".toArray))

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
        val resResponse = testcResponse(httpMessage.toArray)
        scala.Console.println(resResponse)

        codegen.emitSource(bodyParse _ , "bodyParse", new java.io.PrintWriter(System.out))
        val testcBody = compile(bodyParse)
        val resBody= testcBody("Make it funky! -Maceo.".toArray)
        scala.Console.println(resBody)

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
          scala.Console.println(testcRespAndMessage(msg.toArray))
        }

        codegen.emitSource(optionParse _ , "optionParse", new java.io.PrintWriter(System.out))
        val testcOptionParse = compile(optionParse)
        scala.Console.println(testcOptionParse("Header".toArray))
        scala.Console.println(testcOptionParse("header".toArray))
      }
    }

    assertFileEqualsCheck(prefix+"http-parser")

    withOutFile(prefix+"req-parser"){
       new HttpParserProg with ScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with StructExpOptCommon with MyScalaCompile{self =>

        val codegen = new ScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenStruct{
          val IR: self.type = self
        }

        codegen.emitSource(reqTypeParse _ , "reqTypeParse", new java.io.PrintWriter(System.out))
        val testcReqParse = compile(reqTypeParse)
        requestTypes.foreach{rType =>
          scala.Console.println(testcReqParse(rType.toArray))
        }
        scala.Console.println(testcReqParse("What".toArray))
      }
    }

    assertFileEqualsCheck(prefix+"req-parser")

  }


}