package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

import org.scalatest.FunSuite

//import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class TestHttpParser extends HTTP with FunSuite{

  def isSuccessful(p: Parser[Any], in: java.lang.CharSequence): Boolean =
    parseAll(p,in) match {
      case Success(_,_) => true
      case _ => false
    }

  def testWithResult(p: Parser[Any], in: java.lang.CharSequence, out: Any) {
    assert(
      parseAll(p, in) match {
        case Success(res, _) => res == out
        case _ => false
      }
    )
  }

  test("response headers: valid"){

    val headers = List(
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
      assert(isSuccessful(header, h))
    }

  }


  test("response headers: invalid"){

    val headers = List(
      """Date: Mon, 23 May 2005 22:38:34 GMT""",
      """Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)""",
      """Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT""",
      """Etag: \"3f80f-1b6-3e1cb03b\" """,
      """Content-Type: text/html; charset=UTF-8""",
      """Content-Length: 131"""
    )

    headers.foreach{h =>
      assert(!isSuccessful(header, h))
    }
  }

  test("statusMessages: valid"){
    val statusMessages = List(
      """HTTP/1.1 200 OK
      |""".stripMargin,

      """HTTP/1.1 418 I'm a teapot
      |""".stripMargin
    )

    statusMessages.foreach{sm =>
      assert(isSuccessful(status, sm))
    }
  }

  test("statusMessages: invalid"){
    val statusMessages = List(
      """HTTP/1.1 200 OK""",
      """HTTP/1.1 418 I'm a teapot"""
    )

    statusMessages.foreach{sm =>
      assert(!isSuccessful(status, sm))
    }
  }

  test("A response with headers"){
    val httpMessage =
   """|HTTP/1.1 200 OK
      |Date: Mon, 23 May 2005 22:38:34 GMT
      |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
      |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
      |Etag: "3f80f-1b6-3e1cb03b"
      |Content-Type: text/html; charset=UTF-8
      |Content-Length: 131
      |Connection: close
      |
      |""".stripMargin

    val rsp2 = Response(
      status = 200,
      connection = "close",
      contentLength = 131,
      upgrade = false,
      chunked = false
    )

    testWithResult(response, httpMessage, rsp2)

  }

  test("chunked data"){
    val messages = List(
      ("0\r\n\r\n", ""),
      (
    """4
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
    """Wikipedia in
      |
      |chunks.""".stripMargin
      )
    )

    messages foreach { case (message, res) =>
      testWithResult(chunkedParser, message, res)
    }
  }

  test("response and messages"){
     val messages = List(
      ("""|HTTP/1.1 200 OK
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
        (
          Response(
              status = 200,
              connection = "close",
              contentLength = 2,
              upgrade = false,
              chunked = false
          ), "AA"
        )
      ),

      ("""|HTTP/1.1 200 OK
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
          |""".stripMargin,
          (
            Response(
                status = 200,
                connection = "close",
                contentLength = 131,
                upgrade = false,
                chunked = true
            ),
            """Wikipedia in
              |
              |chunks.""".stripMargin
          )
      )
    )

    messages foreach { case (message, res) =>
      testWithResult(respAndMessage, message, res)
    }

  }
}