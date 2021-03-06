package done
import HttpParserLL.{http_parser,http_parser_settings}

object HandWrittenParserWrapper{
  def getParser = HttpParserLL.http_parser_init(HttpParserLL.HTTP_RESPONSE)
  def execute(p:http_parser, settings: http_parser_settings, data: Array[Char], off: Int, len: Int)
   = HttpParserLL.http_parser_execute(p, settings, data, off, len)
}

class DefaultHttpSettings extends HttpParserLL.http_parser_settings{
  def on_message_begin(parser: http_parser) = {
    //println("Just begun parsing!")
    0
  }

  def on_path(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_query_string(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_url(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_fragment(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_header_field(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_header_value(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_headers_complete(parser: http_parser) = 0

  def on_body(parser: http_parser, at: Array[Char], p: Int, length: Int) = 0

  def on_message_complete(parser: http_parser) = {
    //println("Message completed!")
    0
  }
}

class StringFoldingSettings extends DefaultHttpSettings{

  override def on_header_field(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    var s = ""; var i = 0
    while(i < length){
      s += at(p+i)
      i+=1
    }
    0
  }

  override def on_header_value(parser: http_parser, at: Array[Char], p: Int, length: Int) = {
    var s = ""; var i = 0
    while(i < length){
      s += at(p+i)
      i+=1
    }
    0
  }
}