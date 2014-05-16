package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

import scala.collection.mutable.ListBuffer

trait CSVParser extends TokenParsers with RecParsers with StringStructOps with CastingOps
 with CharOps with ListBufferOps {

  //override rep to use ListBuffer
  override def rep[T:Manifest](p : => Parser[T]) =
    repFold(p)(ListBuffer[T](),
      {(ls : Rep[ListBuffer[T]], t: Rep[T]) => ls += t }
    ) ^^ { x => x.toList }

  final val kNull = unit(0)
  final val kFalse = unit(1)
  final val kTrue = unit(2)
  final val kInt = unit(3)
  final val kDouble = unit(4)
  final val kString = unit(5)
  final val kArray = unit(6)
  final val kMember = unit(7)
  final val kObject = unit(8)

  type JV = Record { val kind:Int; val data:Any }
  def JV(k:Rep[Int], d:Rep[Any]) = new Record {
    val kind = k
    val data = d // pointer | long | double, maps alternate key/value
  }
/*
  def infix_mkString(jv: Rep[JV]) = jStr(jv)
  def jStr:Rep[JV=>String] = doLambda2{ (jv: Rep[JV]) =>
    if (jv.kind==kNull) unit("null")
    else if (jv.kind==kFalse) unit("false")
    else if (jv.kind==kTrue) unit("true")
    else if (jv.kind==kInt) unit("")+jv.data
    else if (jv.kind==kDouble) unit("")+jv.data
    else if (jv.kind==kString) unit("\"")+jv.data+unit("\"")
    else if (jv.kind==kArray) unit("[")+jv.data.AsInstanceOf[List[JV]].map(x=>jStr(x)).mkString(unit(","))+unit("]")
    else if (jv.kind==kObject) unit("{")+jv.data.AsInstanceOf[List[JV]].map{y=> val x=y.data.AsInstanceOf[(String,JV)]; unit("\"")+x._1+unit("\":")+jStr(x._2)}.mkString(unit(","))+unit("}")
    else unit("<bad kind: ")+jv.kind+unit(">")
  }
*/

  def jFalse = JV(kFalse,unit(ZeroVal[Any]))
  def jTrue = JV(kTrue,unit(ZeroVal[Any]))
  def jNull = JV(kNull,unit(ZeroVal[Any]))
  def jInt(n:Rep[Int]) = JV(kInt,n)
  def jDouble(n:Rep[Double]) = JV(kDouble,n)
  def jString(s:Rep[StringStruct]) = JV(kString,s)
  def jArray(a:Rep[List[JV]]) = JV(kArray,a)

  //FIXME: creating a struct for this is necessary for good code gen
  //def jMember(a:Rep[(StringStruct,JV)]) = JV(kMember, a)
  //FIXME: absolutely not the right way to do this
  //def jObject(a:Rep[List[JV]]) = JV(kObject,a)

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS_f(acceptIf(in, {x:Rep[Char] => x == unit(' ') || x == unit('\n')}))// ^^^ {unit("")}

  override def doubleLit(in:Rep[Input]) : Parser[Double] =
    (opt(chr(in, '-')) ~
      (numericStruct(in) ~ (chr(in, '.') ~> numeric(in)) ^^ { x => String(in, x._1.start, x._1.length + x._2.length + unit(1)) })
    ) ^^ {
      x => if(x._1.isDefined) String(in, x._2.start - unit(1), x._2.length + unit(1)) else x._2
    } ^^ { x => x.mkString.toDouble }

  def numericStruct(in: Rep[Input]): Parser[StringStruct] =
    ( digitIdx(in) ~ stringStruct(in, digitIdx(in)) ) ^^ { x =>
      String(in, x._1, x._2.length + 1)
    }

  // true | false | null | doubleLit | intLit | stringLit
  def primitives(in: Rep[Input]): Parser[JV] = (
      acceptB(in,"false") ^^^ jFalse
    | acceptB(in,"true") ^^^ jTrue
    | acceptB(in,"null") ^^^ jNull
    | doubleLit(in) ^^ { s => jDouble(s)}
    | stringStructLit(in) ^^ { s => jString(s) }
  )

  def csvOnlyDoubles(in: Rep[Input]) : Parser[List[Double]] = (
    (chr(in,'[') ~> whitespaces(in)) ~>
    repsep(doubleLit(in), whitespaces(in) ~> chr(in, ',') ~> whitespaces(in)) <~
      (whitespaces(in) ~> chr(in, ']'))
  )

  def csvBoolean(in: Rep[Input]): Parser[JV] =
  (
      acceptB(in,"false") ^^^ jFalse
    | acceptB(in,"true") ^^^ jTrue
  )

  def csv(in: Rep[Input]): Parser[JV] = {

    def arr: Parser[JV] = (
      (chr(in,'[') ~> whitespaces(in)) ~>
      repsep(csvBoolean(in), whitespaces(in) ~> chr(in, ',') ~> whitespaces(in)) <~
      (whitespaces(in) ~> chr(in, ']'))
    ) ^^ {x =>jArray(x.AsInstanceOf[List[JV]])}

    arr
  }

  def csvStringLit(in: Rep[Input]) : Parser[List[StringStruct]] = (
    (chr(in,'[') ~> whitespaces(in)) ~>
    repsep(stringStructLit(in), whitespaces(in) ~> chr(in, ',') ~> whitespaces(in)) <~
      (whitespaces(in) ~> chr(in, ']'))
  )

  def stringStructLit(in:Rep[Input]): Parser[StringStruct] = (
    chr(in,'\"') ~>
    stringStruct(in, (chr(in,'\\') ~> acceptIfIdx(in, x => unit(true))) | acceptIfIdx(in, x => x != unit('\"')))
    <~ chr(in,'\"')
  )
}
