package lms.parsing.examples

import lms._
import lms.parsing._
import lms.util._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

// -------- Copied from FunctionsRecursiveExp in lms/src/common/Functions.scala
import scala.reflect.SourceContext
import scala.virtualization.lms.util.ClosureCompare

trait FunctionsRecursiveExp2 extends FunctionsExp with ClosureCompare {
  var funTable2: List[(Sym[_], Any)] = List()
  def doLambda2[A: Manifest, B: Manifest](f: Exp[A] => Exp[B])(implicit pos: SourceContext): Exp[A => B] = {
    val can = canonicalize(f)
    funTable2.find(_._2 == can) match {
      case Some((funSym, _)) =>
        funSym.asInstanceOf[Exp[A => B]]
      case _ =>
        val funSym = fresh[A => B]
        funTable2 = (funSym, can) :: funTable2
        createDefinition(funSym, doLambdaDef(f))
        funSym
    }
  }
}
// --------

trait JsonParser extends TokenParsers with RecParsers with StringStructOps with CastingOps
    with CharOps with FunctionsRecursiveExp2 {

  final val kNull = unit(0)
  final val kFalse = unit(1)
  final val kTrue = unit(2)
  final val kInt = unit(3)
  final val kDouble = unit(4)
  final val kString = unit(5)
  final val kArray = unit(6)
  final val kMember = unit(7)
  final val kObject = unit(8)

  type JV = Record { val kind: Int; val data: Any }
  def JV(k: Rep[Int], d: Rep[Any]) = new Record {
    val kind = k
    val data = d // pointer | long | double, maps alternate key/value
  }

  def infix_mkString(jv: Rep[JV]) = jStr(jv)
  def jStr: Rep[JV => String] = doLambda2 { (jv: Rep[JV]) =>
    if (jv.kind == kNull) unit("null")
    else if (jv.kind == kFalse) unit("false")
    else if (jv.kind == kTrue) unit("true")
    else if (jv.kind == kInt) unit("") + jv.data
    else if (jv.kind == kDouble) unit("") + jv.data
    else if (jv.kind == kString) unit("\"") + jv.data + unit("\"")
    else if (jv.kind == kArray) unit("[") + jv.data.AsInstanceOf[List[JV]].map(x => jStr(x)).mkString(unit(",")) + unit("]")
    else if (jv.kind == kObject) unit("{") + jv.data.AsInstanceOf[List[JV]].map { y => val x = y.data.AsInstanceOf[(String, JV)]; unit("\"") + x._1 + unit("\":") + jStr(x._2) }.mkString(unit(",")) + unit("}")
    else unit("<bad kind: ") + jv.kind + unit(">")
  }

  def jFalse = JV(kFalse, unit(ZeroVal[Any]))
  def jTrue = JV(kTrue, unit(ZeroVal[Any]))
  def jNull = JV(kNull, unit(ZeroVal[Any]))
  def jInt(n: Rep[Int]) = JV(kInt, n)
  def jDouble(n: Rep[Double]) = JV(kDouble, n)
  def jString(s: Rep[String]) = JV(kString, s)
  def jArray(a: Rep[List[JV]]) = JV(kArray, a)
  //FIXME: creating a struct for this is necessary for good code gen
  def jMember(a: Rep[(String, JV)]) = JV(kMember, a)
  //FIXME: absolutely not the right way to do this
  def jObject(a: Rep[List[JV]]) = JV(kObject, a)

  //local whitespaces
  override def whitespaces: Parser[String] =
    repToS_f(acceptIf({ x: Rep[Char] => x == unit(' ') || x == unit('\n') })) // ^^^ {unit("")}

  // true | false | null | doubleLit | intLit | stringLit
  def primitives: Parser[JV] = (
    acceptB("false") ^^^ jFalse
    | acceptB("true") ^^^ jTrue
    | acceptB("null") ^^^ jNull
    | doubleLit ^^ { s => jDouble(s) }
    | intLit ^^ { s => jInt(s) }
    | stringLit ^^ { s => jString(s) }
  )

  def json: Parser[JV] = {

    //Original grammar
    //def value : Parser[Any] = obj | arr | stringLiteral |
    // floatingPointNumber |
    // "null" | "true" | "false"
    //def obj : Parser[Any] = "{"~repsep(member, ",")~"}"
    //def arr : Parser[Any] = "["~repsep(value, ",")~"]"
    //def member: Parser[Any] = stringLiteral~":"~value

    def value: Parser[JV] = rec("value",
      obj | arr | primitives
    )

    def arr: Parser[JV] = (
      (chr('[') ~> whitespaces) ~>
      repsep(value, whitespaces ~> chr(',') ~> whitespaces) <~
      (whitespaces ~> chr(']'))
    ) ^^ { x => jArray(x.AsInstanceOf[List[JV]]) }

    def member: Parser[JV] = (
      (stringLit
        <~ (whitespaces <~ accept(unit(':')) ~ whitespaces))
        ~ value
    ) ^^ { x => jMember(x) }

    def obj: Parser[JV] = (
      (chr('{') ~> whitespaces) ~>
      repsep(member, whitespaces ~> chr(',') ~> whitespaces) <~
      (whitespaces ~> chr('}'))
    ) ^^ { x => jObject(x) }

    value
  }

  // Callbacks to unquote a string
  def unhex(c: Rep[Char]): Rep[Int] =
    if (c >= unit('0') && c < unit('9')) (c - unit('0' + 0)).toInt
    else if (c >= unit('A') && c < unit('F')) (c - unit('A' - 10)).toInt
    else if (c >= unit('a') && c < unit('f')) (c - unit('a' - 10)).toInt
    else unit(0)

  def unquote(start: Rep[Int], end: Rep[Int]) = Parser[String] { in =>

    barrierSync("TODO: Hack!")

    var p = __newVar(start) // read head position
    var n = __newVar(unit(0)) // number of valid chars
    val a = NewArray[Char](end - start)
    while (p < end) {
      if (in.input(p) == unit('\\') && p + unit(1) < end) {
        val c = in.input(p + 1)
        if (c == 'u' && p + unit(5) < end) {
          val x =
            unhex(in.input(p + 2)) * unit(0x1000) +
              unhex(in.input(p + 3)) * unit(0x100) +
              unhex(in.input(p + 4)) * unit(0x10) +
              unhex(in.input(p + 5))

          a(n) = x.toChar; p += 4;
        } else if (c == unit('b')) a(n) = unit('\b')
        else if (c == unit('f')) a(n) = unit('\f')
        else if (c == unit('t')) a(n) = unit('\t')
        else if (c == unit('n')) a(n) = unit('\n')
        else if (c == unit('r')) a(n) = unit('\r')
        else a(n) = c // invalid escape ignored
        p += 2
      } else {
        a(n) = in.input(p); p += 1
      }
      n += 1;
    }

    Success(String(a, unit(0), n).mkString, in)
  }

  /*
def stringStructLit(in:Rep[Input]): Parser[StringStruct] =
chr(in,'\"') ~> (((pos(in) <~
repFold( (chr(in,'\\')~>acceptIf(in,x=>unit(true))) | acceptIf(in, x => x!=unit('\"'))
)(unit(""), (acc: Rep[String], x: Rep[Char]) => acc
)) ~ pos(in)) ^^ { x => / *String(in,x._1,x._2-x._1)* / dequote(in,x._1,x._2) } ) <~ chr(in,'\"')
*/

  override def stringLit: Parser[String] = {

    val parser: Parser[(Int, Int)] = chr('\"') ~> ((pos <~
      repFold((chr('\\') ~> acceptIf(x => unit(true))) | acceptIf(x => x != unit('\"'))
      )(unit(""), (acc: Rep[String], x: Rep[Char]) => acc
      )) ~ pos) <~ chr('\"')

    val res = parser >> { x => unquote(x._1, x._2) }
    res
  }

  def hex = acceptIf(
    c => isDigit(c) || (c >= unit('A') && c <= unit('F'))
  )
}