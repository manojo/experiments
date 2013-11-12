package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait JsonParser extends TokenParsers with RecParsers with StringStructOps with CastingOps
 with CharOps/*with FunctionsRecursiveExp*/ {
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
  // Desired function
  def infix_mkString(jv: Rep[JV]) = jStr(jv)
  def jStr:Rep[JV=>String] = doLambda{ (jv: Rep[JV]) =>
    if (jv.kind==kNull) unit("null")
    else if (jv.kind==kFalse) unit("false")
    else if (jv.kind==kTrue) unit("true")
    else if (jv.kind==kInt) unit("")+jv.data
    else if (jv.kind==kDouble) unit("")+jv.data
    else if (jv.kind==kString) unit("\"")+jv.data+unit("\"")
    else if (jv.kind==kArray) unit("[")+jv.data.AsInstanceOf[List[JV]].map(x=>jStr(x)).mkString(unit(","))+unit("]")
    else if (jv.kind==kObject) unit("{")+jv.data.AsInstanceOf[List[(String,JV)]].map(x=>unit("\"")+x._1+unit("\":")+x._2).mkString(unit(","))+unit("}")
    else unit("<bad kind: ")+jv.kind+unit(">")
  }
  */

  //def rec_mks:Rep[JV=>String] = doLambda((jv: Rep[JV]) =>infix_mkString(jv))
  def infix_mkString(jv: Rep[JV]) : Rep[String] = {
    if (jv.kind==kNull) unit("null")
    else if (jv.kind==kFalse) unit("false")
    else if (jv.kind==kTrue) unit("true")
    else if (jv.kind==kInt) unit("")+jv.data
    else if (jv.kind==kDouble) unit("")+jv.data
    else if (jv.kind==kString) unit("\"")+jv.data+unit("\"")
    else if (jv.kind==kArray) unit("[")+jv.data.AsInstanceOf[List[JV]] /*.map(rec_mks)*/ .mkString(unit(","))+unit("]")
    else if (jv.kind==kObject) unit("{")+jv.data.AsInstanceOf[List[(String,JV)]].map(x=>unit("\"")+x._1+unit("\":")+x._2).mkString(unit(","))+unit("}")
    else unit("<bad kind: ")+jv.kind+unit(">")
  }

  def jFalse = JV(kFalse,unit(ZeroVal[Any]))
  def jTrue = JV(kTrue,unit(ZeroVal[Any]))
  def jNull = JV(kNull,unit(ZeroVal[Any]))
  def jInt(n:Rep[Int]) = JV(kInt,n)
  def jDouble(n:Rep[Double]) = JV(kDouble,n)
  def jString(s:Rep[String]) = JV(kString,s)
  def jArray(a:Rep[List[JV]]) = JV(kArray,a)
  //FIXME: creating a struct for this is necessary for good code gen
  def jMember(a:Rep[(String,JV)]) = JV(kMember, a)
  //FIXME: absolutely not the right way to do this
  def jObject(a:Rep[List[JV]]) = JV(kObject,a)

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS_f(acceptIf(in, {x:Rep[Char] => x == unit(' ') || x == unit('\n')}))// ^^^ {unit("")}

  // true | false | null | doubleLit | intLit | stringLit
  def primitives(in: Rep[Input]): Parser[JV] = (
      acceptB(in,"false") ^^^ jFalse
    | acceptB(in,"true") ^^^ jTrue
    | acceptB(in,"null") ^^^ jNull
    | doubleLit(in) ^^ { s => jDouble(s)}
    | intLit(in) ^^ { s => jInt(s) }
    | stringLit(in) ^^ { s => jString(s) }
  )


  def json(in: Rep[Input]): Parser[JV] = {

    //Original grammar
    //def value : Parser[Any] = obj | arr | stringLiteral |
    //          floatingPointNumber |
    //          "null" | "true" | "false"
    //def obj : Parser[Any] = "{"~repsep(member, ",")~"}"
    //def arr : Parser[Any] = "["~repsep(value, ",")~"]"
    //def member: Parser[Any] = stringLiteral~":"~value

    def value: Parser[JV] = rec("value",
      obj | arr | primitives(in)
    )

    def arr: Parser[JV] = (
      (chr(in,'[') ~> whitespaces(in)) ~>
      repsep(value, whitespaces(in) ~> chr(in, ',') ~> whitespaces(in)) <~
      (whitespaces(in) ~> chr(in, ']'))
    ) ^^ {x =>jArray(x.AsInstanceOf[List[JV]])}

    def member: Parser[JV] = (
      (stringLit(in)
      <~ (whitespaces(in) <~ accept(in, unit(':')) ~ whitespaces(in)))
      ~ value
    ) ^^ {x => jMember(x)}

    def obj: Parser[JV] = (
      (chr(in,'{') ~> whitespaces(in)) ~>
      repsep(member, whitespaces(in) ~> chr(in, ',') ~> whitespaces(in)) <~
      (whitespaces(in) ~> chr(in, '}'))
    ) ^^ { x => jObject(x)}

    value
  }


  /*
  // Ignore string content (skip)
  override def stringLit(in:Rep[Input]): Parser[String] =
    chr(in,'\"') ~>
      repFold( (chr(in,'\\')~>acceptIf(in,x=>unit(true))) | acceptIf(in, x => x!=unit('\"'))
      )(unit(""), (acc: Rep[String], x: Rep[Char]) => acc
    ) <~ chr(in,'\"')
  */

  /*
  // Copy _NON-DEQUOTED_ content
  override def stringLit(in:Rep[Input]): Parser[String] =
    chr(in,'\"') ~> (((pos(in) <~
      repFold( (chr(in,'\\')~>acceptIf(in,x=>unit(true))) | acceptIf(in, x => x!=unit('\"'))
      )(unit(""), (acc: Rep[String], x: Rep[Char]) => acc
    )) ~ pos(in)) ^^ { x => String(in,x._1,x._2-x._1).toStr } ) <~ chr(in,'\"')
  */



  override def stringLit(in:Rep[Input]): Parser[String] =
    chr(in,'\"') ~>
    repFold( escQuotes(in) ^^ { x=> unit("")+x } | uChars(in) ^^ { x=>unit("")+x } |
      acceptIf(in, x => x != unit('\"') && x != unit('\\'))^^{ x=> unit("")+x}
    )(unit(""), (acc: Rep[String], x: Rep[String]) => acc + x
    ) <~ chr(in,'\"')

    //  repToS(acceptIf(in, (x:Rep[Char]) => x != unit('\"'))) <~
    //accept(in, unit('\"'))

  def escQuotes(in: Rep[Input]): Parser[Char] = {
    chr(in,'\\') ~> acceptIf(in, c =>
      c == '\\' || c == '\'' || c == '\"' || c =='b'
    ||c == 'f' || c == 'n' || c == 'r' || c =='t'
    ||c == '/'
    )
  }

  def uChars(in: Rep[Input]): Parser[Char] = {
    chr(in,'\\') ~> chr(in,'u') ~>
    repNFold(hex(in), unit(4))(unit('\0'), (acc: Rep[Char],x:Rep[Char]) => (acc*unit('\u000A') + x).toInt.toChar)
  }

  def hex(in:Rep[Input]) = acceptIf(in,
    c => isDigit(c) ||  (c >= unit('A') && c <= unit('F'))
  )
}
