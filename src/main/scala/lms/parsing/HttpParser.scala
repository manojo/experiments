package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait HttpParser extends TokenParsers {

  val crlf = """\r?\n""".r

  val wildRegex = """[^\r\n]*""".r
  val headerName = """[A-Z][\w-]*""".r
  val hexNumber = """[0-9A-F]+""".r

  // 0x23 == '#', 0x74 == 'del'
  val urlChar = """[^\x00-\x20#\?\x7F]""".r

/*  def header: Parser[Option[(String,Any)]] =  (headerName<~":")~(wildRegex<~crlf) ^^ {
    case hName~prop => collect(hName.toLowerCase, prop)
  }
*/
}