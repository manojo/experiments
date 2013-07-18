package scala.virtualization.lms
package common

import java.io.PrintWriter
import scala.virtualization.lms.util.OverloadHack
import scala.virtualization.lms.internal.{GenerationFailedException}
import scala.reflect.SourceContext

trait CharOps extends Variables with OverloadHack {
  //quite a hack, this overloaded one!
  def infix_toInt(c: Rep[Char])(implicit o: Overloaded2, pos: SourceContext) = char_toint(c)

  def char_toint(c: Rep[Char])(implicit pos: SourceContext): Rep[Int]
}

trait CharOpsExp extends CharOps with VariablesExp {
  case class CharToInt(c: Exp[Char]) extends Def[Int]

  def char_toint(c: Rep[Char])(implicit pos: SourceContext) = CharToInt(c)
}

trait ScalaGenCharOps extends ScalaGenBase {
  val IR: CharOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case CharToInt(c) => emitValDef(sym, "%s.toInt".format(quote(c)))
    case _ => super.emitNode(sym, rhs)
  }
}