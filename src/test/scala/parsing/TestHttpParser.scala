package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

import org.scalatest.FunSuite

//import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class TestHttpParser extends HTTP with FunSuite{

  def isSuccessful(p: Parser[Any], in: java.lang.CharSequence): Boolean =
    parseAll(p,in) match {
      case s@Success(_,_) => true
      case _ => false
    }


  test("response headers: valid"){

    val headers = List(
      """Date: Mon, 23 May 2005 22:38:34 GMT
""",
      """Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
""",
      """Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
""",
      """Etag: \"3f80f-1b6-3e1cb03b\"
""",
      """Content-Type: text/html; charset=UTF-8
""",
      """Content-Length: 131
"""   )

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
""",
      """HTTP/1.1 418 I'm a teapot
"""
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

  test("An almost full response"){
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
    assert(isSuccessful(message, httpMessage))
  }

}