package lms

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

/**
 * Inspired from TupleOps on delite-develop branch
 */
trait ParseResultOps extends Base with IfThenElse with BooleanOps with CastingOps{

  /**A mini implementation of a parseresult
   *
   */
  abstract class ParseResult[+T:Manifest]{
    def isEmpty: Rep[Boolean]
    def next: Rep[Int]
    def res: Rep[T]
  }

  def Success[T:Manifest](res: Rep[T], next:Rep[Int]) : Rep[ParseResult[T]]
  def Failure[T:Manifest](next: Rep[Int]): Rep[ParseResult[T]]

  implicit def repToParseResultCls[T:Manifest](a: Rep[ParseResult[T]]) = new ParseResultCls(a)
  //implicit def make_parseResult[A:Manifest](o: ParseResult[Rep[A]])(implicit pos: SourceContext): Rep[ParseResult[A]]

  class ParseResultCls[A:Manifest](pr: Rep[ParseResult[A]]) {
    def isEmpty: Rep[Boolean] = parseresult_isEmpty(pr)
    def get: Rep[A] = parseresult_get(pr)
    def orElse(that: Rep[ParseResult[A]]) = parseresult_orElse(pr, that)
    def next: Rep[Int] = parseresult_next(pr)

    def map[B:Manifest](f: Rep[A] => Rep[B]) = parseresult_map(pr,f)
//    def flatMapWithNext[B:Manifest](f: Rep[A] => Rep[Int] => Generator[ParseResult[B]]) = parseresult_flatMapWithNext(pr, f)
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
  def parseresult_next[A:Manifest](pr:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[Int]

  def parseresult_orElse[A:Manifest](pr:Rep[ParseResult[A]], that:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[ParseResult[A]] =
    if(pr.isEmpty) that else pr

  def parseresult_map[A:Manifest, B:Manifest](pr: Rep[ParseResult[A]], f: Rep[A] => Rep[B]) : Rep[ParseResult[B]] =
    if(pr.isEmpty) Failure[B](pr.next) else Success(f(pr.get), pr.next)

/*  def option_flatMap[A:Manifest, B:Manifest](o:Rep[Option[A]], f: Rep[A] => Rep[Option[B]]) : Rep[Option[B]] =
    if(o.isDefined) f(o.get) else None.asInstanceOf[Option[Rep[B]]]

  def option_filter[A:Manifest](o: Rep[Option[A]], p: Rep[A] => Rep[Boolean]) : Rep[Option[A]] =
    if(o.isDefined && p(o.get)) o else None.asInstanceOf[Option[Rep[A]]]
*/
}

trait ParseResultOpsExp extends ParseResultOps with IfThenElseExp with BooleanOpsExp with StructOpsExpOpt with CastingOpsExp{

  //implicit def make_parseResult[A:Manifest](pr: ParseResult[A])(implicit pos: SourceContext): Exp[ParseResult[A]]
  //  = struct(classTag[ParseResult[A]], "res" -> pr.res, "empty" -> pr.isEmpty, "next" -> pr.next)

  //getOrElse(rep_asinstanceof(unit(null), manifest[Null], manifest[A]))

  def parseresult_isEmpty[A:Manifest](pr:Rep[ParseResult[A]])(implicit pos: SourceContext) : Rep[Boolean] = field[Boolean](pr, "empty")
  def parseresult_get[A:Manifest](pr:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[A] = field[A](pr, "res")
  def parseresult_next[A:Manifest](pr:Rep[ParseResult[A]])(implicit pos: SourceContext):Rep[Int] = field[Int](pr, "next")

  def Success[T:Manifest](res: Rep[T], next:Rep[Int]) : Exp[ParseResult[T]]
    = struct(classTag[ParseResult[T]], "res" -> res, "empty" -> unit(false), "next" -> next)

  def Failure[T:Manifest](next: Rep[Int]): Exp[ParseResult[T]]
    = struct(classTag[ParseResult[T]], "res" -> rep_asinstanceof(unit(null), manifest[Null], manifest[T]), "empty" -> unit(true), "next" -> next)
}

trait ParseResultGenBase extends GenericCodegen with BaseGenStructOps{
  val IR: ParseResultOpsExp

  override def remap[A](m: Manifest[A]) = m.erasure.getSimpleName match {
    case "ParseResult" => IR.structName(m)
    case _ => super.remap(m)
  }
}

trait ScalaGenParseResultOps extends ScalaGenBase with ParseResultGenBase with ScalaGenStructOps with ScalaGenCastingOps{ val IR: ParseResultOpsExp }
trait CGenParseResultOps extends CGenBase with ParseResultGenBase with CGenStructOps with CGenCastingOps{ val IR: ParseResultOpsExp }
