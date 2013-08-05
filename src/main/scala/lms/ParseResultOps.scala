package lms

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter


/**A mini implementation of a parseresult */
abstract class ParseResult[T]{
  def isEmpty: Boolean
  def next: Int
  def res: T
}

case class Success[T](res: T, next: Int) extends ParseResult[T]{
  def isEmpty = false
}

case class Failure[T](next: Int) extends ParseResult[T]{
  def isEmpty = true
  def res = null.asInstanceOf[T]
}

/**
 * Taken char-for-char from the delite-develop branch of lms
 */
trait ParseResultOps extends Base with IfThenElse with BooleanOps{

  implicit def repToParseResultCls[T:Manifest](a: Rep[ParseResult[T]]) = new ParseResultCls(a)
  implicit def make_parseResult[A:Manifest](o: ParseResult[Rep[A]])(implicit pos: SourceContext): Rep[ParseResult[A]]

  class ParseResultCls[A:Manifest](pr: Rep[ParseResult[A]]) {
//    def map[B:Manifest](f: Rep[A] => Rep[B]) = option_map(o,f)
    def isEmpty: Rep[Boolean] = parseresult_isEmpty(pr)
    def get: Rep[A] = parseresult_get(pr)
//    def flatMap[B : Manifest](f: Rep[A] => Rep[Option[B]]) = option_flatMap(o,f)
//    def filter(f: Rep[A] => Rep[Boolean]) = option_filter(o, f)
//    def sortBy[B:Manifest:Ordering](f: Rep[A] => Rep[B]) = list_sortby(l,f)
//    def ::(e: Rep[A]) = list_prepend(l,e)
//    def ++ (l2: Rep[List[A]]) = list_concat(l, l2)
//    def mkString = list_mkString(l)
//    def head = list_head(l)s
//    def tail = list_tail(l)
  }

  def parseresult_isEmpty[A:Manifest](pr:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[Boolean]
  def parseresult_get[A:Manifest](pr:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[A]
  def parseresult_next[A:Manifest](o:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[Int]

/*  def option_map[A:Manifest, B:Manifest](o: Rep[Option[A]], f: Rep[A] => Rep[B]) : Rep[Option[B]] =
    if(o.isDefined) Some(f(o.get)) else None.asInstanceOf[Option[Rep[B]]]

  def option_flatMap[A:Manifest, B:Manifest](o:Rep[Option[A]], f: Rep[A] => Rep[Option[B]]) : Rep[Option[B]] =
    if(o.isDefined) f(o.get) else None.asInstanceOf[Option[Rep[B]]]

  def option_filter[A:Manifest](o: Rep[Option[A]], p: Rep[A] => Rep[Boolean]) : Rep[Option[A]] =
    if(o.isDefined && p(o.get)) o else None.asInstanceOf[Option[Rep[A]]]
*/
}

trait ParseResultOpsExp extends ParseResultOps with IfThenElseExp with BooleanOpsExp with StructOpsExpOpt with CastingOpsExp{

  implicit def make_parseResult[A:Manifest](o: ParseResult[Rep[A]])(implicit pos: SourceContext): Exp[ParseResult[A]]
    = struct(classTag[ParseResult[A]], "res" -> o.res, "empty" -> unit(o.isEmpty), "next" -> unit(o.next))

  //getOrElse(rep_asinstanceof(unit(null), manifest[Null], manifest[A]))

  def parseresult_isEmpty[A:Manifest](o:Rep[ParseResult[A]])(implicit pos: SourceContext) : Rep[Boolean] = field[Boolean](o, "empty")
  def parseresult_get[A:Manifest](o:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[A] = field[A](o, "res")
  def parseresult_next[A:Manifest](o:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[Int] = field[Int](o, "next")
}

trait ParseResultGenBase extends GenericCodegen with BaseGenStructOps with ScalaGenCastingOps{
  val IR: ParseResultOpsExp

  override def remap[A](m: Manifest[A]) = m.erasure.getSimpleName match {
    case "ParseResult" => IR.structName(m)
    case _ => super.remap(m)
  }
}

trait ScalaGenParseResultOps extends ScalaGenBase with ParseResultGenBase with ScalaGenStructOps { val IR: ParseResultOpsExp }
