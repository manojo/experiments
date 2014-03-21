package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

import org.scalatest._

//import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class TestHttpParser extends FunSpec with HTTP {

  def isSuccessful(p: Parser[Any], in: java.lang.CharSequence): Boolean =
    parseAll(p, in) match {
      case Success(_, _) => true
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

  it("response headers: valid") {

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

    headers.foreach { h =>
      assert(isSuccessful(header, h))
    }

  }

  it("response headers: invalid") {

    val headers = List(
      """Date: Mon, 23 May 2005 22:38:34 GMT""",
      """Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)""",
      """Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT""",
      """Etag: \"3f80f-1b6-3e1cb03b\" """,
      """Content-Type: text/html; charset=UTF-8""",
      """Content-Length: 131"""
    )

    headers.foreach { h =>
      assert(!isSuccessful(header, h))
    }
  }

  it("statusMessages: valid") {
    val statusMessages = List(
      """HTTP/1.1 200 OK
      |""".stripMargin,

      """HTTP/1.1 418 I'm a teapot
      |""".stripMargin
    )

    statusMessages.foreach { sm =>
      assert(isSuccessful(status, sm))
    }
  }

  it("statusMessages: invalid") {
    val statusMessages = List(
      """HTTP/1.1 200 OK""",
      """HTTP/1.1 418 I'm a teapot"""
    )

    statusMessages.foreach { sm =>
      assert(!isSuccessful(status, sm))
    }
  }

  it("A response with headers") {
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

  it("chunked data") {
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

    messages foreach {
      case (message, res) =>
        testWithResult(chunkedParser, message, res)
    }
  }

  it("response and messages") {
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
      ),
      ("""HTTP/1.1 200 OK
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
         |""".stripMargin,
        (
          Response(
            status = 200,
            connection = "close",
            contentLength = 129,
            upgrade = false,
            chunked = false
          ),
            """<html>
              |<head>
              |  <title>An Example Page</title>
              |</head>
              |<body>
              |  Hello World, this is a very simple HTML document.
              |</body>
              |</html>""".stripMargin
        )
      ),
      ("""|HTTP/1.1 200 OK
          |cache-control: no-cache, no-store, must-revalidate, pre-check=0, post-check=0
          |content-length: 2
          |content-type: application/json;charset=utf-8
          |date: Tue, 03 Sep 2013 19:10:56 GMT
          |expires: Tue, 31 Mar 1981 05:00:00 GMT
          |last-modified: Tue, 03 Sep 2013 19:10:56 GMT
          |pragma: no-cache
          |server: tfe
          |set-cookie: lang=en
          |set-cookie: guest_id=v1%3A137823545658205848; Domain=.twitter.com; Path=/; Expires=Thu, 03-Sep-2015 19:10:56 UTC
          |status: 200 OK
          |x-access-level: read
          |x-frame-options: SAMEORIGIN
          |x-rate-limit-limit: 180
          |x-rate-limit-remaining: 179
          |x-rate-limit-reset: 1378236356
          |x-transaction: 7c742b402f213b9d
          |
          |AA
          |""".stripMargin,
        (Response(
          status = 200,
          connection = "close",
          contentLength = 0,
          upgrade = false,
          chunked = false
        ), "")
      )
    )

    messages foreach {
      case (message, res) =>
        testWithResult(respAndMessage, message, res)
    }
  }

  it("urls") {
    val urls = List(
      ("http://en.wikipedia.org/wiki/URI_scheme",
        Url(
          schema = "http",
          hostName = "en.wikipedia.org",
          path = "/wiki/URI_scheme",
          queryString = "",
          fragment = "",
          port = 80
        )
      ),

      ("https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_Expressions?redirectlocale=en-US&redirectslug=JavaScript%2FGuide%2FRegular_Expressions",
        Url(schema = "https",
          hostName = "developer.mozilla.org",
          path = "/en-US/docs/Web/JavaScript/Guide/Regular_Expressions?redirectlocale=en-US&redirectslug=JavaScript%2FGuide%2FRegular_Expressions",
          queryString = "redirectlocale=en-US&redirectslug=JavaScript%2FGuide%2FRegular_Expressions",
          fragment = "",
          port = 80
        )
      ),
      ("http://en.wikipedia.org/wiki/List_of_HTTP_headers#Responses",
        Url(schema = "http",
          hostName = "en.wikipedia.org",
          path = "/wiki/List_of_HTTP_headers#Responses",
          queryString = "",
          fragment = "Responses",
          port = 80
        )
      ),

      //TODO: some delimiting characters are lost, to be corrected
      ("ldap://ldap1.example.net:6666/o=University%20of%20Michigan, c=US??sub?(cn=Babs%20Jensen)",
        Url(schema = "ldap",
          hostName = "ldap1.example.net",
          path = "/o=University%20of%20Michigan,c=US?sub(cn=Babs%20Jensen)",
          queryString = "sub(cn=Babs%20Jensen)",
          fragment = "",
          port = 6666
        )
      )

    )

    urls foreach {
      case (url1, res) =>
        testWithResult(url, url1, res)
    }

  }
}