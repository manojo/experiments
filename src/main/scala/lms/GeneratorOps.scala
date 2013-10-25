package lms

import java.io.PrintWriter

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericNestedCodegen
import scala.reflect.SourceContext

trait GeneratorOps extends Variables with While with LiftVariables
  with RangeOps with NumericOps with OrderingOps with IfThenElse
  with MiscOps with EmbeddedControls with Equal {

  object Gen {
    def fSeq[A:Manifest](xs: Rep[A]*)(implicit pos: SourceContext) = fromSeq(xs)
  }

  abstract class Generator[T:Manifest] extends ((Rep[T] => Rep[Unit]) => Rep[Unit]) {self =>

    def map[U:Manifest](g: Rep[T] => Rep[U]) = Generator[U]{ f =>
      self.apply{
        x:Rep[T] => f(g(x))
      }
    }

    def filter(p: Rep[T] => Rep[Boolean]) = Generator[T]{ f =>
      self.apply{
        x:Rep[T] => if(p(x)) f(x)
      }
    }

    def ++(that: Generator[T]) = Generator[T]{ f =>
      self.apply(f)
      that.apply(f)
    }

    def flatMap[U:Manifest](g: Rep[T] => Generator[U]) = Generator[U]{ f =>
      self.apply{ x:Rep[T] =>
        val tmp : Generator[U] = g(x)
        tmp(f)
      }
    }

    def reduce(h:(Rep[T],Rep[T])=>Rep[T], z:Rep[T]) = Generator[T]{ f =>
      var best = z;
      self.apply { x:Rep[T] => if (best==z) best=x; else best=h(best,x) }
      if (best!=z) f(best)
    }
  }

  def Generator[T:Manifest](g: (Rep[T] => Rep[Unit]) => Rep[Unit]) = new Generator{
    def apply(f: Rep[T] => Rep[Unit]) = g(f)
  }

  def range(start: Rep[Int], end: Rep[Int]) : Generator[Int] = {
    val tmp = Generator[Int]{ f =>
      for(i <- start until end){
        f(i)
      }
    }
    if(start < end) tmp else emptyGen[Int]()
  }

  def fromSeq[A:Manifest](xs: Seq[Rep[A]]): Generator[A] =
    if(xs.isEmpty) emptyGen()
    else if(xs.length == 1) elGen(xs.head)
    else elGen(xs.head) ++ fromSeq(xs.tail)

  def emptyGen[A:Manifest](): Generator[A] = Generator[A]{
    f => ()
  }

  /**
   * A generator for a single element
   */
  def elGen[A:Manifest](a: Rep[A]): Generator[A] = Generator[A]{
    f => f(a)
  }

  def cond[A:Manifest](cond: Rep[Boolean], a: => Generator[A], b: => Generator[A]) = Generator[A]{
    f => if(cond) a(f) else b(f)
  }

  def __ifThenElse[T:Manifest](c: Rep[Boolean], thenp: => Generator[T], elsep: => Generator[T]) : Generator[T] =
    cond(c, thenp, elsep)

  abstract class TupleGenerator[T:Manifest,U:Manifest] extends Generator[(T,U)]
}

trait GeneratorOpsExp extends GeneratorOps with EffectExp with VariablesExp
  with RangeOpsExp with WhileExp with NumericOpsExp with OrderingOpsExp
  with IfThenElseExp with MiscOpsExp{

  //a Let tree for
  case class Let[T: Manifest,U: Manifest](x: Sym[T], rhs: Exp[T], body: Block[U]) extends Def[U]

  def let[T: Manifest,U: Manifest](x: Sym[T], rhs: Exp[T], b: => Exp[U]): Rep[U] = {
    val body = reifyEffects(b)
    val s = summarizeEffects(body)
    reflectEffect(Let(x,rhs,body), s)
  }

  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case Let(x, rhs, block) => x :: effectSyms(block)
    case _ => super.boundSyms(e)
  }
}

trait ScalaGenGeneratorOps extends ScalaGenWhile with ScalaGenVariables
  with ScalaGenRangeOps with ScalaGenNumericOps with ScalaGenOrderingOps
  with ScalaGenIfThenElse with ScalaGenMiscOps{
  val IR: GeneratorOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case Let(x,y,blk) =>
      stream.println("val "+ quote(x) + " = "+ quote(y))
      emitBlock(blk)
      emitValDef(sym,quote(getBlockResult(blk)) )

    case _ => super.emitNode(sym, rhs)
  }

}


trait CGenGeneratorOps extends CGenWhile with CGenVariables
  with CGenRangeOps with CGenNumericOps with CGenOrderingOps
  with CGenIfThenElse with CGenMiscOps{
  val IR: GeneratorOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case Let(x,y,blk) =>
      stream.println("val "+ quote(x) + " = "+ quote(y))
      emitBlock(blk)
      emitValDef(sym,quote(getBlockResult(blk)) )

    case _ => super.emitNode(sym, rhs)
  }

}