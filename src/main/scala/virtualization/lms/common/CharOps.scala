package scala.virtualization.lms
package common

import java.io.PrintWriter
import scala.virtualization.lms.util.OverloadHack
import scala.virtualization.lms.internal.{ GenerationFailedException }
import scala.reflect.SourceContext

trait CharOps extends Variables with OverloadHack {
  //quite a hack, this overloaded one!
  def infix_toInt(c: Rep[Char])(implicit o: Overloaded2, pos: SourceContext) = char_toint(c)
  def infix_toChar(i: Rep[Int])(implicit pos: SourceContext) = int_tochar(i)

  def char_toint(c: Rep[Char])(implicit pos: SourceContext): Rep[Int]
  def int_tochar(i: Rep[Int])(implicit pos: SourceContext): Rep[Char]
}

trait CharOpsExp extends CharOps with VariablesExp {
  case class CharToInt(c: Exp[Char]) extends Def[Int]
  case class IntToChar(i: Exp[Int]) extends Def[Char]

  def char_toint(c: Rep[Char])(implicit pos: SourceContext) = CharToInt(c)
  def int_tochar(i: Rep[Int])(implicit pos: SourceContext) = IntToChar(i)
}

trait ScalaGenCharOps extends ScalaGenBase {
  val IR: CharOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case CharToInt(c) => emitValDef(sym, "%s.toInt".format(quote(c)))
    case IntToChar(i) => emitValDef(sym, "%s.toChar".format(quote(i)))
    case _ => super.emitNode(sym, rhs)
  }
}

trait CGenCharOps extends CGenBase {
  val IR: CharOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case CharToInt(c) => emitValDef(sym, "(int)%s".format(quote(c)))
    case IntToChar(i) => emitValDef(sym, "(char)%s".format(quote(i)))
    case _ => super.emitNode(sym, rhs)
  }
}