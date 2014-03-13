package lms.util

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait OptionProg extends OptionOps with MyScalaOpsPkg {

  //map
  def test1(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[Option[Int]] = Some(in)
    val t = s.map(x => x * unit(2))
    println(t)
  }

  //map on None
  def test2(in: Rep[Int]): Rep[Unit] = {
    //option[rep[int]] is implicitly converted to rep[option[int]]
    val s = None.asInstanceOf[Option[Rep[Int]]]
    val t = s.map(x => x * unit(2))
    println(t)
  }

  //flatMap
  def test3(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[Option[Int]] = Some(in)
    val t = s.flatMap(x => Some(x * unit(2)))
    println(t)
  }

  //flatMap on None
  def test4(in: Rep[Int]): Rep[Unit] = {
    val s = None.asInstanceOf[Option[Rep[Int]]]
    val t = s.flatMap(x => Some(x * unit(2)))
    println(t)
  }

  //filter
  def testFilter(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[Option[Int]] = Some(in)
    val t = s.filter { x: Rep[Int] => x == unit(3) }
    println(t)
  }

  //filter on None
  def testFilterNone(in: Rep[Int]): Rep[Unit] = {
    val s = None.asInstanceOf[Option[Rep[Int]]]
    val t = s.filter(x => x == unit(2))
    println(t)
  }

}

class TestOptionOps extends FileDiffSuite {

  val prefix = "test-out/"

  def testOption = {
    withOutFile(prefix + "option") {
      new OptionProg with OptionOpsExp with MyScalaOpsPkgExp with IfThenElseExpOpt with StructOpsExpOptCommon with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenOptionOps with lms.ScalaGenStructOps { val IR: self.type = self }

        codegen.emitSource(test1 _, "test1", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc1 = compile(test1)
        testc1(3)
        codegen.reset

        codegen.emitSource(test2 _, "test2", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(test2)
        testc2(3)
        codegen.reset

        codegen.emitSource(test3 _, "test3", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc3 = compile(test3)
        testc3(3)
        codegen.reset

        codegen.emitSource(test4 _, "test4", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(test4)
        testc4(3)
        codegen.reset

        codegen.emitSource(testFilter _, "testFilter", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcFilter = compile(testFilter)
        testcFilter(3)
        testcFilter(2)
        codegen.reset

        codegen.emitSource(testFilterNone _, "testFilterNone", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcFilterNone = compile(testFilterNone)
        testcFilterNone(3)
        codegen.reset

      }
    }

    assertFileEqualsCheck(prefix + "option")
  }
}