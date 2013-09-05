package done

import HttpParserLL.http_parser
import java.io._
import scala.collection.mutable.ArrayBuffer

object HttpTest{

  val file = new BufferedReader(new FileReader("src/test/resources/tweet1"))
  val out = new ArrayBuffer[Char]

  var line = file.readLine
  while(line != null){
    out ++= line + "\n"
    line = file.readLine
  }

  val httpResponse = out.toArray

  def main(args: Array[String]){
    println("Welcome!")

    for(i <- 1 to 10){
      val time = System.currentTimeMillis
      val parser = HttpParserLL.http_parser_init(HttpParserLL.HTTP_RESPONSE)
      HttpParserLL.http_parser_execute(parser, new MyHttpSettings, httpResponse, 0, httpResponse.length)
      println("time taken: " + (System.currentTimeMillis - time))
    }

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
    //println("got the following url")
    //for(i <- p to (p+length)){
    //  print(at(i))
    //}
    //println
    0
  }

  def on_fragment(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    0
  }

  def on_header_field(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    //println("got the following header field")
    for(i <- p to (p+length)){
      print(at(i))
    }
    println
    0
  }

  def on_header_value(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    //println("got the following header value")
    for(i <- p to (p+length)){
      print(at(i))
    }
    println
    0
  }

  def on_headers_complete(parser: http_parser) = {
    //println("headers done!")
    0
  }

  def on_body(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    //println("body deh!")
    0
  }

  def on_message_complete(parser: http_parser) = {
    println("Message completed!")
    0
  }
}