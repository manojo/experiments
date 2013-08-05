package lms

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

/**
 * Taken char-for-char from the delite-develop branch of lms
 */

trait OptionOps extends Base with IfThenElse{

//  implicit def varToOptionOps[T:Manifest](x: Var[Option[T]]) = new OptionOpsCls(readVar(x)) // FIXME: dep on var is not nice
  implicit def repToOptionOps[T:Manifest](a: Rep[Option[T]]) = new OptionOpsCls(a)
  //implicit def optionToOptionOps[T:Manifest](a: Option[T]) = new ListOpsCls(unit(a))
  implicit def make_opt[A:Manifest](o: Option[Rep[A]])(implicit pos: SourceContext): Rep[Option[A]]

  class OptionOpsCls[A:Manifest](o: Rep[Option[A]]) {
    def map[B:Manifest](f: Rep[A] => Rep[B]) = option_map(o,f)
    def isDefined: Rep[Boolean] = option_isDefined(o)
    def get: Rep[A] = option_get(o)
    def flatMap[B : Manifest](f: Rep[A] => Rep[Option[B]]) = option_flatMap(o,f)
//    def filter(f: Rep[A] => Rep[Boolean]) = list_filter(l, f)
//    def sortBy[B:Manifest:Ordering](f: Rep[A] => Rep[B]) = list_sortby(l,f)
//    def ::(e: Rep[A]) = list_prepend(l,e)
//    def ++ (l2: Rep[List[A]]) = list_concat(l, l2)
//    def mkString = list_mkString(l)
//    def head = list_head(l)
//    def tail = list_tail(l)
  }

  def option_isDefined[A:Manifest](o:Rep[Option[A]])(implicit pos: SourceContext):Rep[Boolean]
  def option_get[A:Manifest](o:Rep[Option[A]])(implicit pos: SourceContext):Rep[A]

  def option_map[A:Manifest, B:Manifest](o: Rep[Option[A]], f: Rep[A] => Rep[B]) : Rep[Option[B]] =
    if(o.isDefined) Some(f(o.get)) else None.asInstanceOf[Option[Rep[B]]]

  def option_flatMap[A:Manifest, B:Manifest](o:Rep[Option[A]], f: Rep[A] => Rep[Option[B]]) : Rep[Option[B]] =
    if(o.isDefined) f(o.get) else None.asInstanceOf[Option[Rep[B]]]

//  implicit def back_to_opt[A:Manifest](o: Rep[Option[A]])(implicit pos: SourceContext) =
//      if (infix_isDefined(o)) Some(o.get) else None

}

trait OptionOpsExp extends OptionOps with IfThenElseExp with StructOpsExpOpt with CastingOpsExp{

  implicit def make_opt[A:Manifest](o: Option[Rep[A]])(implicit pos: SourceContext): Exp[Option[A]]
    = struct(classTag[Option[A]], "value" -> o.getOrElse(rep_asinstanceof(unit(null), manifest[Null], manifest[A])), "defined" -> unit(o.isDefined))

  def option_isDefined[A:Manifest](o:Rep[Option[A]])(implicit pos: SourceContext) : Rep[Boolean] = field[Boolean](o, "defined")
  def option_get[A:Manifest](o:Rep[Option[A]])(implicit pos: SourceContext):Rep[A] = field[A](o, "value")

  //  implicit def make_tuple2[A:Manifest,B:Manifest](t: (Exp[A],Exp[B]))(implicit pos: SourceContext) : Exp[(A,B)] = struct(classTag[(A,B)], "_1" -> t._1, "_2" -> t._2)

}

trait OptionGenBase extends GenericCodegen with BaseGenStructOps with ScalaGenCastingOps{
  val IR: OptionOpsExp

  override def remap[A](m: Manifest[A]) = m.erasure.getSimpleName match {
    case "Option" => IR.structName(m)
    case _ => super.remap(m)
  }
}

trait ScalaGenOptionOps extends ScalaGenBase with OptionGenBase with ScalaGenStructOps { val IR: OptionOpsExp }