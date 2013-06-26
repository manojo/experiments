package done

import HttpParserLL.http_parser

object HttpTest{

  val httpResponse =
  """HTTP/1.1 200 OK
Date: Mon, 23 May 2005 22:38:34 GMT
Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
Etag: "3f80f-1b6-3e1cb03b"
Content-Type: text/html; charset=UTF-8
Content-Length: 131
Connection: close

<html>
<head>
  <title>An Example Page</title>
</head>
<body>
  Hello World, this is a very simple HTML document.
</body>
</html>
""".toCharArray


  def main(args: Array[String]){
    println("Welcome!")
    val parser = HttpParserLL.http_parser_init(HttpParserLL.HTTP_RESPONSE)
    HttpParserLL.http_parser_execute(parser, new MyHttpSettings, httpResponse, 0, httpResponse.length)

  }
}

/**
 * a default event processing
 */
class MyHttpSettings extends HttpParserLL.http_parser_settings{
  def on_message_begin(parser: http_parser) = {
    println("Just begun parsing!")
    0
  }

  def on_path(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    0
  }

  def on_query_string(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    0
  }

  def on_url(parser: http_parser, at: Array[Char], p: Int, length: Int) ={
    println("got the following url")
    for(i <- p to (p+length)){
      print(at(i))
    }
    println
    0
  }

  def on_fragment(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    0
  }

  def on_header_field(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    println("got the following header field")
    for(i <- p to (p+length)){
      print(at(i))
    }
    println
    0
  }

  def on_header_value(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    println("got the following header value")
    for(i <- p to (p+length)){
      print(at(i))
    }
    println
    0
  }

  def on_headers_complete(parser: http_parser) = {
    println("headers done!")
    0
  }

  def on_body(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    0
  }

  def on_message_complete(parser: http_parser) = {
    println("Message completed!")
    0
  }
}