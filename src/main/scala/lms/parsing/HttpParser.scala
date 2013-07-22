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

  def capitalLetter(in:Rep[Input]) = {
    acceptIf(in, {
      c: Rep[Char] => c >= unit('A') && c <= unit('Z')
    })
  }

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    rep(accept(in, unit(' '))) ^^^ {unit("")}

  //just keep the major and minor disctinction
  def decimalNumber(in: Rep[Input]): Parser[(Int,Int)] =
    wholeNumber(in)~(accept(in, unit('.'))~>wholeNumber(in))

  def wildChar(in:Rep[Input]) = acceptIf(in, {
    x: Rep[Char] => x != unit('\n')
  })

  def wildRegex(in: Rep[Input]) = repToS(wildChar(in))

  //TODO: ignoring \r for now
  def crlf(in:Rep[Input]) = accept(in, unit('\n'))

  def status(in: Rep[Input]): Parser[Int] =
    (accept(in, "HTTP/")~decimalNumber(in)~whitespaces(in))~>wholeNumber(in)<~(wildRegex(in)~crlf(in))

  def headerName(in: Rep[Input]): Parser[String] =
    capitalLetter(in)~repToS(letter(in) | accept(in, unit('-'))) ^^ {
      x: Rep[(Char, String)] => x._1 + x._2
    }

  //TODO: do filtering based on input. Option[(String,String)]
  def header(in: Rep[Input]): Parser[(String, String)] =
    (headerName(in)<~(whitespaces(in)~accept(in,":")))~(wildRegex(in)<~crlf(in))

  def headers(in: Rep[Input]) = rep(header(in))

  def response(in: Rep[Input]) = status(in)~headers(in)<~crlf(in)


}