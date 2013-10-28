package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait JsonParser extends TokenParsers with RecParsers with StringStructOps{

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS_f(acceptIf(in, {x:Rep[Char] => x == unit(' ') || x == unit('\n')}))// ^^^ {unit("")}

  def json(in: Rep[Input]): Parser[Any] = {
    //def value = rec("json",
    //  obj | arr | stringLit(in) | wholeNumber(in) //|
    //  //"null", "true", "false"
    //)

    //def arr: Parser[List[Any]] =
    //  (accept(in,unit('[')) ~> whitespaces(in)) ~>
    //  repsep(value, accept(in, unit(',')) ~> whitespaces(in)) <~
    //  (accept(in, unit(']')) ~> whitespaces(in))

    //def obj: Parser[List[Any]] =
    //  (accept(in,unit('{')) ~> whitespaces(in)) ~>
    //  repsep(member, accept(in, unit(',')) ~> whitespaces(in)) <~
    //  (accept(in, unit('}')) ~> whitespaces(in))

    def member: Parser[Any] =
      (stringLit(in) <~
      (whitespaces(in) <~ accept(in, unit(':')) ~ whitespaces(in))) ~
      stringLit(in)

    member//value
  }

  override def stringLit(in:Rep[Input]): Parser[String] =
    accept(in, unit('\"')) ~>
    repToS(acceptIf(in, (x:Rep[Char]) => x != unit('\"'))) <~
    accept(in, unit('\"'))


}