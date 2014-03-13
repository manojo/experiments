package lms

import scala.virtualization.lms.common._

import scala.virtualization.lms.util.OverloadHack
import scala.virtualization.lms.internal.{ GenericNestedCodegen, GenericFatCodegen }
import scala.reflect.{ SourceContext, RefinedManifest }

import java.io.PrintWriter

trait MyIfThenElseExpOpt extends IfThenElseExpOpt { this: BooleanOpsExp with EqualExpBridge =>

  val map = new scala.collection.mutable.HashMap[Rep[Boolean], Boolean]

  //TODO: eliminate conditional if both branches return same value!

  // it would be nice to handle rewrites in method ifThenElse but we'll need to
  // 'de-reify' blocks in case we rewrite if(true) to thenp.
  // TODO: make reflect(Reify(..)) do the right thing

  override def __ifThenElse[T: Manifest](cond: Rep[Boolean], thenp: => Rep[T], elsep: => Rep[T])(implicit pos: SourceContext) = cond match {
    case Const(true) => thenp
    case Const(false) => elsep
    case Def(BooleanNegate(a)) => __ifThenElse(a, elsep, thenp)
    case Def(NotEqual(a, b)) => __ifThenElse(equals(a, b), elsep, thenp)
    case _ =>
      if (map.contains(cond)) {
        if (map(cond)) thenp else elsep
      } else {
        val a = reifyEffectsHere {
          map += (cond) -> true
          //the by name parameter is now evaluated
          //thereby triggering possible nested ifThenElse-s
          val tmp = thenp
          map -= cond
          tmp
        }

        val b = reifyEffectsHere {
          map += (cond) -> false
          val tmp = elsep
          map -= cond
          tmp
        }

        ifThenElse(cond, a, b)
      }
  }
}