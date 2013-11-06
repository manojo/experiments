package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait JsonParser extends TokenParsers with RecParsers with StringStructOps{

  final val kFalse = 0
  final val kTrue = 1
  final val kNull = 2
  final val kLong = 4
  final val kDouble = 5
  final val kString = 6
  final val kArray = 7
  final val kObject = 8

  type JV = Record { val kind:Int; val data:Any; val length:Int }
  def JV(k:Rep[Int], d:Rep[Any], l:Rep[Int]) = new Record {
    val kind = k
    val data = d // pointer | long | double, maps alternate key/value
    val length = l // # of elements in object/
    }

  def valFalse = JV(unit(0),unit(null),unit(0))
  def valTrue = JV(unit(1),unit(null),unit(0))
  def valNull = JV(unit(2),unit(null),unit(0))
  def valInt(n:Rep[Int]) = JV(unit(4),n,unit(0))
  def valLong(n:Rep[Long]) = JV(unit(4),n,unit(0))
  def valFloat(n:Rep[Float]) = JV(unit(5),n,unit(0))
  def valDouble(n:Rep[Double]) = JV(unit(5),n,unit(0))
  def valString(s:Rep[String]) = JV(unit(6),s,s.length)
  def valArray(a:Rep[Array[JV]],l:Rep[Int]) = JV(unit(7),a,l)
  def valObject(a:Rep[(String,JV)],l:Rep[Int]) = JV(unit(7),a,l)

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS_f(acceptIf(in, {x:Rep[Char] => x == unit(' ') || x == unit('\n')}))// ^^^ {unit("")}

  def json(in: Rep[Input]): Parser[Any] = {
    def value = (wholeNumber(in) ^^ { x=>valInt(x) }
              |  accept(in,"null") ^^^ valNull
              |  accept(in,"false") ^^^ valFalse
              |  accept(in,"true") ^^^ valTrue
              )

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
