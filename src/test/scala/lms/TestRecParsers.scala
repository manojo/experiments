package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait RecParsersProg extends CharParsers with RecParsers{

  def recNumber(in: Rep[Array[Char]]): Parser[Int] = {
    lazy val temp: Parser[Int] = rec("hi",
      Parser{i: Rep[Int] =>
        ((digit2Int(in) ~ temp) ^^ {
          x  => x._1 + x._2
        } | digit2Int(in)).apply(i)
      }
    )
    temp
  }

  def testRecNumber(in: Rep[Array[Char]]): Rep[Unit]= {
    var s = Failure[Int](unit(-1))
    val p = recNumber(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }
}

class TestRecParsers extends FileDiffSuite {
  val prefix = "test-out/"

  def testRec = {
    withOutFile(prefix+"rec-parser") {
      new RecParsersProg with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with /*IfThenElseExp*/ MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with FunctionsExp with OptionOpsExp
       with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps{
          val IR: self.type = self
        }

        codegen.emitSource(testRecNumber _ , "testRecNumber", new java.io.PrintWriter(System.out))
        val testcRecNumber = compile(testRecNumber)
        testcRecNumber("2".toArray)
        testcRecNumber("23".toArray)
        testcRecNumber("2a".toArray)
        testcRecNumber("23b".toArray)
        testcRecNumber("a".toArray)
      }
    }
    assertFileEqualsCheck(prefix+"rec-parser")
  }
}

