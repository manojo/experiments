package lms.parsing

import lms._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

/**
 * Inspired from TupleOps on delite-develop branch
 */
trait ParseResultOps extends Base with IfThenElse with BooleanOps { self: ReaderOps =>

  /**
   * A mini implementation of a parseresult
   *
   */
  abstract class ParseResult[+T: Manifest] {
    def isEmpty: Rep[Boolean]
    def next: Rep[Input]
    def res: Rep[T]
  }

  def Success[T: Manifest](res: Rep[T], next: Rep[Input]): Rep[ParseResult[T]]
  def Failure[T: Manifest](next: Rep[Input]): Rep[ParseResult[T]]

  implicit class ParseResultCls[A: Manifest](pr: Rep[ParseResult[A]]) {
    def isEmpty: Rep[Boolean] = parseresult_isEmpty(pr)
    def get: Rep[A] = parseresult_get(pr)
    def orElse(that: Rep[ParseResult[A]]) = parseresult_orElse(pr, that)
    def next: Rep[Input] = parseresult_next(pr)

    def map[B: Manifest](f: Rep[A] => Rep[B]) = parseresult_map(pr, f)
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

  def parseresult_isEmpty[A: Manifest](pr: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[Boolean]
  def parseresult_get[A: Manifest](pr: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[A]
  def parseresult_next[A: Manifest](pr: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[Input]

  def parseresult_orElse[A: Manifest](pr: Rep[ParseResult[A]], that: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[ParseResult[A]] =
    if (pr.isEmpty) that else pr

  def parseresult_map[A: Manifest, B: Manifest](pr: Rep[ParseResult[A]], f: Rep[A] => Rep[B]): Rep[ParseResult[B]] =
    if (pr.isEmpty) Failure[B](pr.next) else Success(f(pr.get), pr.next)

}

trait ParseResultOpsExp extends ParseResultOps with IfThenElseExp with BooleanOpsExp
    with StructOpsExpOpt { self: ReaderOps =>

  //implicit def make_parseResult[A:Manifest](pr: ParseResult[A])(implicit pos: SourceContext): Exp[ParseResult[A]]
  //  = struct(classTag[ParseResult[A]], "res" -> pr.res, "empty" -> pr.isEmpty, "next" -> pr.next)

  def parseresult_isEmpty[A: Manifest](pr: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[Boolean] = field[Boolean](pr, "empty")

  def parseresult_get[A: Manifest](pr: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[A] = field[A](pr, "res")

  def parseresult_next[A: Manifest](pr: Rep[ParseResult[A]])(implicit pos: SourceContext): Rep[Input] = field[Input](pr, "next")

  def Success[T: Manifest](res: Rep[T], next: Rep[Input]): Exp[ParseResult[T]] =
    struct(classTag[ParseResult[T]], "res" -> res, "empty" -> unit(false), "next" -> next)

  // FIXME: Remove this once
  // https://github.com/TiarkRompf/virtualization-lms-core/pull/70 has
  // been merged.
  object ZeroVal {

    val BooleanC = classOf[Boolean]
    val ByteC = classOf[Byte]
    val CharC = classOf[Char]
    val IntC = classOf[Int]
    val LongC = classOf[Long]
    val ShortC = classOf[Short]
    val DoubleC = classOf[Double]
    val FloatC = classOf[Float]
    val UnitC = classOf[Unit]

    def apply[A: Manifest]: A = {
      val z: Any = implicitly[Manifest[A]].runtimeClass match {
        case ByteC => 0.toByte
        case CharC => 0.toChar
        case IntC => 0
        case LongC => 0L
        case ShortC => 0.toShort
        case DoubleC => 0.0
        case FloatC => (0.0).toFloat
        case BooleanC => false
        case UnitC => ()
        case _ => null
      }
      z.asInstanceOf[A]
    }

  }

  def Failure[T: Manifest](next: Rep[Input]): Exp[ParseResult[T]] = struct(classTag[ParseResult[T]], "res" -> unit(ZeroVal[T]), "empty" -> unit(true), "next" -> next)
}

trait ParseResultGenBase extends GenericCodegen with BaseGenStructOps {
  val IR: ParseResultOpsExp

  override def remap[A](m: Manifest[A]) = m.erasure.getSimpleName match {
    case "ParseResult" => IR.structName(m)
    case _ => super.remap(m)
  }
}

trait ScalaGenParseResultOps extends ScalaGenBase with ParseResultGenBase with ScalaGenStructOps { val IR: ParseResultOpsExp }
trait CGenParseResultOps extends CGenBase with ParseResultGenBase with CGenStructOps { val IR: ParseResultOpsExp }
