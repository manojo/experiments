package lms
import scala.virtualization.lms.common._
import scala.reflect.SourceContext

trait StringStructOps extends StructOps with While with IfThenElse
with NumericOps with ArrayOps with Equal with StringOps with OrderingOps
with BooleanOps with MiscOps with LiftVariables{
  type StringStruct = Record{
    val input: Array[Char]
    val start: Int
    val length: Int
  }

  def String(in : Rep[Array[Char]], st: Rep[Int], len: Rep[Int] = unit(0))
    = new Record{
      val input = in
      val start = st
      val length = len
    }


  //unsound operation in general, we need to have the same input !!
/*  def infix_+(l: Rep[StringStruct], r: Rep[StringStruct])(implicit pos: SourceContext)
    = stringStruct_plus(l,r)
  def stringStruct_plus(l: Rep[StringStruct], r: Rep[StringStruct])(implicit pos: SourceContext) : Rep[StringStruct]
    = String(in = l.input, st = l.start, len = (r.length:Rep[Int]))
*/
  def __equal(l: Rep[StringStruct], r: Rep[Array[Char]])(implicit pos: SourceContext): Rep[Boolean] = {
    if(l.length == r.length){
      val in :Rep[Array[Char]] = l.input
      val st = l.start
      var i = unit(0); var tmp = unit(true)
      while(i < l.length && tmp){
        if(in(i + st) != r(i)){
          tmp = unit(false)
        }
        i = i + unit(1)
      }
      tmp
    }else{
      unit(false)
    }
  }

  def __equal(l: Rep[StringStruct], r: String)(implicit pos: SourceContext): Rep[Boolean] = {
    //TODO: lms.Array.apply not working
    val tmp: Rep[Array[Char]] = array_obj_fromseq{
      r.toSeq.map{x: Char => unit(x)}
    }
    l == tmp
  }

/*
  def infix_unary_toString(st: Rep[StringStruct])(implicit pos: SourceContext) = {
    var s = unit("")
    s =
  }
*/

}

trait StringStructOpsExp extends StringStructOps with StructOpsExpOptCommon with WhileExp with IfThenElseExpOpt
with BooleanOpsExp with NumericOpsExp with ArrayOpsExp with EqualExpOpt with StringOpsExp with OrderingOpsExp
with MiscOpsExp with VariablesExp

trait ScalaGenStringStructOps extends ScalaGenBase with ScalaGenStructOps with ScalaGenWhile with ScalaGenIfThenElse
with ScalaGenNumericOps with ScalaGenArrayOps with ScalaGenEqual with ScalaGenStringOps with ScalaGenOrderingOps
with ScalaGenBooleanOps with ScalaGenMiscOps with ScalaGenVariables{
  val IR: StringStructOpsExp
}