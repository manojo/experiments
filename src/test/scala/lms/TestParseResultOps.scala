package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait ParseResultProg extends ParseResultOps with MyScalaOpsPkg{

  //map
  def test1(in: Rep[Int]): Rep[Unit] = {
    val s: Rep[ParseResult[Int]] = Success(in, 10)
    //val t = s.map(x => x * unit(2))
    println(s)
  }

}

class TestParseResultOps extends FileDiffSuite {

  val prefix = "test-out/"

  def testOption = {
    withOutFile(prefix+"parseresult"){
       new ParseResultProg with ParseResultOpsExp with MyScalaOpsPkgExp
        with IfThenElseExpOpt with StructOpsExpOptCommon with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenParseResultOps
          with lms.ScalaGenStructOps{ val IR: self.type = self }

        codegen.emitSource(test1 _ , "test1", new java.io.PrintWriter(System.out))
        val testc1 = compile(test1)
        testc1(3)

      }
    }

    assertFileEqualsCheck(prefix+"parseresult")
  }
}