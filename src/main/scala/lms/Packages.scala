package lms

import scala.virtualization.lms.common._

//replacing traits with my own

trait MyScalaOpsPkg extends Base
  with ImplicitOps with NumericOps with FractionalOps with OrderingOps with StringOps
  with RangeOps with IOOps with ArrayOps with BooleanOps with PrimitiveOps with MiscOps
  with Equal with IfThenElse with Variables with While with MyTupleOps with ListOps
  with SeqOps with MathOps with CastingOps with SetOps with ObjectOps with ArrayBufferOps

trait MyScalaOpsPkgExp extends MyScalaOpsPkg
  with ImplicitOpsExp with NumericOpsExp with FractionalOpsExp with OrderingOpsExp with StringOpsExp
  with RangeOpsExp with IOOpsExp with ArrayOpsExp with BooleanOpsExp with PrimitiveOpsExp with MiscOpsExp
  with FunctionsExp with EqualExp with IfThenElseExp with VariablesExp with WhileExp with MyTupleOpsExp with ListOpsExp
  with SeqOpsExp with DSLOpsExp with MathOpsExp with CastingOpsExp with SetOpsExp with ObjectOpsExp with ArrayBufferOpsExp

trait MyScalaCodeGenPkg extends ScalaGenImplicitOps with ScalaGenNumericOps with ScalaGenFractionalOps with ScalaGenOrderingOps
  with ScalaGenStringOps with ScalaGenRangeOps with ScalaGenIOOps with ScalaGenArrayOps with ScalaGenBooleanOps
  with ScalaGenPrimitiveOps with ScalaGenMiscOps with ScalaGenFunctions with ScalaGenEqual with ScalaGenIfThenElse
  with ScalaGenVariables with ScalaGenWhile with ScalaGenMyTupleOps with ScalaGenListOps
  with ScalaGenSeqOps with ScalaGenDSLOps with ScalaGenMathOps with ScalaGenCastingOps with ScalaGenSetOps
  with ScalaGenObjectOps with ScalaGenArrayBufferOps { val IR: MyScalaOpsPkgExp }

trait MyCCodeGenPkg extends CGenDSLOps with CGenImplicitOps with CGenNumericOps with CGenFractionalOps with CGenOrderingOps
  with CGenStringOps with CGenRangeOps with CGenIOOps with CGenArrayOps with CGenBooleanOps
  with CGenPrimitiveOps with CGenMiscOps with CGenFunctions with CGenEqual with CGenIfThenElse
  with CGenVariables with CGenWhile with CGenMyTupleOps
  with CGenMathOps with CGenCastingOps with CGenSetOps with CGenArrayBufferOps { val IR: MyScalaOpsPkgExp }
//No SeqOps and no ListOps

/*
trait Package extends ScalaOpsPkg with MyRangeOps with MyListOps /*with LiftScala*/ {

}

trait PackageExp extends ScalaOpsPkgExp with MyRangeOpsExp with MyListOpsExp {

}

trait ScalaGenPackage extends ScalaCodeGenPkg with ScalaGenMyRangeOps with ScalaGenMyListOps {
  val IR: ScalaOpsPkgExp with MyRangeOpsExp with MyListOpsExp
}

trait CGenPackage extends CCodeGenPkg {
  val IR: ScalaOpsPkgExp
}
*/