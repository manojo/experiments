package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait ParseResultProg extends ParseResultOps with MyScalaOpsPkg {

  def test1(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[ParseResult[Int]] = Success(in, unit(10))
    //val t = s.map(x => x * unit(2))
    println(s)
  }

  //a map
  def testMap(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[ParseResult[Int]] = Success(in, unit(10))
    val t = s.map(x => x * unit(2))
    println(t)
  }

  //a map of Fail
  def testMapFail(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[ParseResult[Int]] = Failure[Int](in)
    val t = s.map(x => x * unit(2))
    println(t)
  }

  //orElse left
  def testOrElseLeft(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[ParseResult[Int]] = Failure[Int](in)
    val t = s orElse Success(unit(2), in)
    println(t)
  }

  //orElse right
  def testOrElseRight(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[ParseResult[Int]] = Success[Int](in, unit(10))
    val t = s orElse Success(unit(2), in)
    println(t)
  }

}

class TestParseResultOps extends FileDiffSuite {

  val prefix = "test-out/"

  def testOption = {
    withOutFile(prefix + "parseresult") {
      new ParseResultProg with ParseResultOpsExp with MyScalaOpsPkgExp with IfThenElseExpOpt with StructOpsExpOptCommon with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenParseResultOps with lms.ScalaGenStructOps { val IR: self.type = self }

        codegen.emitSource(test1 _, "test1", new java.io.PrintWriter(System.out))
        val testc1 = compile(test1)
        testc1(3)

        codegen.emitSource(testMap _, "testMap", new java.io.PrintWriter(System.out))
        val testcMap = compile(testMap)
        testcMap(3)

        codegen.emitSource(testMapFail _, "testMapFail", new java.io.PrintWriter(System.out))
        val testcMapFail = compile(testMapFail)
        testcMapFail(3)

        codegen.emitSource(testOrElseLeft _, "testOrElseLeft", new java.io.PrintWriter(System.out))
        val testcOrElseLeft = compile(testOrElseLeft)
        testcOrElseLeft(3)

        codegen.emitSource(testOrElseRight _, "testOrElseRight", new java.io.PrintWriter(System.out))
        val testcOrElseRight = compile(testOrElseRight)
        testcOrElseRight(3)

      }
    }

    assertFileEqualsCheck(prefix + "parseresult")
  }
}