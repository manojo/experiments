package lms

import scala.virtualization.lms.common._
import scala.reflect.SourceContext
import scala.virtualization.lms.internal.GenericNestedCodegen
import scala.collection.mutable.ListBuffer

trait ListBufferOps extends Base {

  object ListBuffer {
    def apply[A:Manifest](xs: Rep[A]*)(implicit pos: SourceContext) = listBuffer_new(xs)
  }

  implicit class ListOpsCls[A:Manifest](l: Rep[ListBuffer[A]]) {
    def += (e: Rep[A]) = listBuffer_append(l, e)
    def toList = listBuffer_toList(l)
  }

  def listBuffer_new[A:Manifest](xs: Seq[Rep[A]])(implicit pos: SourceContext): Rep[ListBuffer[A]]
  def listBuffer_append[A:Manifest](xs: Rep[ListBuffer[A]], e: Rep[A])(implicit pos: SourceContext): Rep[ListBuffer[A]]
  def listBuffer_toList[A:Manifest](xs: Rep[ListBuffer[A]])(implicit pos: SourceContext): Rep[List[A]]
}

trait ListBufferOpsExp extends ListBufferOps with EffectExp {
  case class ListBufferNew[A:Manifest](xs: Seq[Rep[A]]) extends Def[ListBuffer[A]] {
    val mA = manifest[A]
  }
  case class ListBufferAppend[A:Manifest](xs: Rep[ListBuffer[A]], e: Rep[A]) extends Def[ListBuffer[A]]
  case class ListBufferToList[A:Manifest](l: Rep[ListBuffer[A]]) extends Def[List[A]]

  def listBuffer_new[A:Manifest](xs: Seq[Rep[A]])(implicit pos: SourceContext)
    = reflectMutable(ListBufferNew(xs))

  def listBuffer_append[A:Manifest](xs: Rep[ListBuffer[A]], e: Rep[A])(implicit pos: SourceContext)
    = reflectWrite(xs)(ListBufferAppend(xs, e))

  def listBuffer_toList[A:Manifest](xs: Rep[ListBuffer[A]])(implicit pos: SourceContext)
    = ListBufferToList(xs)

}

trait BaseGenListBufferOps extends GenericNestedCodegen {
  val IR: ListBufferOpsExp
  import IR._

}

trait ScalaGenListBufferOps extends BaseGenListBufferOps with ScalaGenEffect {
  val IR: ListBufferOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case a@ListBufferNew(xs) => emitValDef(sym, src"scala.collection.mutable.ListBuffer[${a.mA}](${(xs map {quote}).mkString(",")})")
    case ListBufferAppend(xs, e) => emitValDef(sym, src"$xs += $e")
    case ListBufferToList(l) => emitValDef(sym, src"$l.toList")
    case _ => super.emitNode(sym, rhs)
  }
}