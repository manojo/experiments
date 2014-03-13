package lms.util

import lms._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

/**
 * Inspired from TupleOps is the delite-develop branch
 */

trait OptionOps extends Base with IfThenElse with BooleanOps {
  import scala.language.implicitConversions
  //  implicit def varToOptionOps[T:Manifest](x: Var[Option[T]]) = new OptionOpsCls(readVar(x)) // FIXME: dep on var is not nice
  implicit def repToOptionOps[T: Manifest](a: Rep[Option[T]]) = new OptionOpsCls(a)
  //implicit def optionToOptionOps[T:Manifest](a: Option[T]) = new ListOpsCls(unit(a))
  implicit def make_opt[A: Manifest](o: Option[Rep[A]])(implicit pos: SourceContext): Rep[Option[A]]

  def none[T: Manifest](): Rep[Option[T]]

  class OptionOpsCls[A: Manifest](o: Rep[Option[A]]) {
    def map[B: Manifest](f: Rep[A] => Rep[B]) = option_map(o, f)
    def isDefined: Rep[Boolean] = option_isDefined(o)
    def get: Rep[A] = option_get(o)
    def flatMap[B: Manifest](f: Rep[A] => Rep[Option[B]]) = option_flatMap(o, f)
    def filter(f: Rep[A] => Rep[Boolean]) = option_filter(o, f)
    //    def sortBy[B:Manifest:Ordering](f: Rep[A] => Rep[B]) = list_sortby(l,f)
    //    def ::(e: Rep[A]) = list_prepend(l,e)
    //    def ++ (l2: Rep[List[A]]) = list_concat(l, l2)
    //    def mkString = list_mkString(l)
    //    def head = list_head(l)
    //    def tail = list_tail(l)
  }

  def option_isDefined[A: Manifest](o: Rep[Option[A]])(implicit pos: SourceContext): Rep[Boolean]
  def option_get[A: Manifest](o: Rep[Option[A]])(implicit pos: SourceContext): Rep[A]

  def option_map[A: Manifest, B: Manifest](o: Rep[Option[A]], f: Rep[A] => Rep[B]): Rep[Option[B]] =
    if (o.isDefined) Some(f(o.get)) else None.asInstanceOf[Option[Rep[B]]]

  def option_flatMap[A: Manifest, B: Manifest](o: Rep[Option[A]], f: Rep[A] => Rep[Option[B]]): Rep[Option[B]] =
    if (o.isDefined) f(o.get) else None.asInstanceOf[Option[Rep[B]]]

  def option_filter[A: Manifest](o: Rep[Option[A]], p: Rep[A] => Rep[Boolean]): Rep[Option[A]] =
    if (o.isDefined && p(o.get)) o else None.asInstanceOf[Option[Rep[A]]]

}

trait OptionOpsExp extends OptionOps with IfThenElseExp with BooleanOpsExp with StructOpsExpOpt with CastingOpsExp {
  import scala.language.implicitConversions
  implicit def make_opt[A: Manifest](o: Option[Rep[A]])(implicit pos: SourceContext): Exp[Option[A]] = struct(classTag[Option[A]], "value" -> o.getOrElse(rep_asinstanceof(unit(null), manifest[Null], manifest[A])), "defined" -> unit(o.isDefined))

  def option_isDefined[A: Manifest](o: Rep[Option[A]])(implicit pos: SourceContext): Rep[Boolean] = field[Boolean](o, "defined")
  def option_get[A: Manifest](o: Rep[Option[A]])(implicit pos: SourceContext): Rep[A] = field[A](o, "value")

  def none[T: Manifest](): Rep[Option[T]] =
    struct(classTag[Option[T]], "value" -> rep_asinstanceof(unit(null), manifest[Null], manifest[T]), "defined" -> unit(false))
}

trait OptionGenBase extends GenericCodegen with BaseGenStructOps {
  val IR: OptionOpsExp

  override def remap[A](m: Manifest[A]) = m.erasure.getSimpleName match {
    case "Option" => IR.structName(m)
    case _ => super.remap(m)
  }
}

trait ScalaGenOptionOps extends ScalaGenBase with OptionGenBase with ScalaGenStructOps with ScalaGenCastingOps { val IR: OptionOpsExp }
trait CGenOptionOps extends CGenBase with OptionGenBase with CGenStructOps with CGenCastingOps { val IR: OptionOpsExp }
