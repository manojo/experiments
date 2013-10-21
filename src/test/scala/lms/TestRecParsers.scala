package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait RecParsersProg extends CharParsers with RecParsers{

  def expr(in: Rep[Array[Char]]): Parser[Int] = {
    lazy val temp: Parser[Int] = rec("hi",
      Parser{i: Rep[Int] =>
        ((digit2Int(in) ~ temp) ^^ {
          x: Rep[(Int,Int)]  => x._1 + x._2
        } | digit2Int(in)).apply(i)
      }
    )
    temp
  }

  def test1(in: Rep[Array[Char]]): Rep[Unit]= {
    var s = Failure[Int](unit(-1))
    val p = expr(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }


}

class TestRecParsers extends FileDiffSuite {
  val prefix = "test-out/"

  def testRec = {
    withOutFile(prefix+"gen-topdown-rec") {
      new RecParsersProg with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with FunctionsExp with OptionOpsExp
       with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps{
          val IR: self.type = self
        }

        codegen.emitSource(test1 _ , "test1", new java.io.PrintWriter(System.out))
        //val testc1 = compile(test1)
        //scala.Console.println(testc1("2".toArray))
        //val testc1 = compile(f)
        //scala.Console.println(testc1("\"hello\" \"carol\"".toArray))


      }
    }
    assertFileEqualsCheck(prefix+"gen-topdown-rec")
  }
}

