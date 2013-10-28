package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait RecParsersProg extends TokenParsers with RecParsers{

  def recNumber(in: Rep[Array[Char]]): Parser[Int] = {
    def temp: Parser[Int] = rec("hi",
      (digit2Int(in) ~ temp) ^^ {
        x  => x._1 + x._2
      } | digit2Int(in))

    temp
  }

  // expr = term ~ rep("+" ~ term)
  // term = factor ~ rep("*" ~ factor)
  // factor = wholeNumber | "("~ expr ~")"

  def recExpr(in: Rep[Array[Char]]): Parser[Int] = {
    def expr: Parser[Int] = rec("wow",
      (term ~ repFold(accept(in, unit('+')) ~> term)(unit(0), (x:Rep[Int],y:Rep[Int]) => x + y))
      ^^ {x => x._1 + x._2}
    )

    def term: Parser[Int] =
      (factor ~ repFold(accept(in, unit('*')) ~> factor)(unit(1), (x:Rep[Int],y:Rep[Int]) => x * y)) ^^ {x => x._1 * x._2}

    def factor = wholeNumber(in) | accept(in,unit('(')) ~> expr <~ accept(in, unit(')'))
    expr
  }

  def testRecNumber(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Int](unit(-1))
    val p = recNumber(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }

  def testRecExpr(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Int](unit(-1))
    val p = recExpr(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }

}

class TestRecParsers extends FileDiffSuite {
  val prefix = "test-out/"

  def testRec = {
    withOutFile(prefix+"rec-parser") {
      new RecParsersProg with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
       with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps{
          val IR: self.type = self
        }

        codegen.emitSource(testRecNumber _ , "testRecNumber", new java.io.PrintWriter(System.out))
        val testcRecNumber = compile(testRecNumber)
        testcRecNumber("2".toArray)
        testcRecNumber("23".toArray)
        testcRecNumber("2a".toArray)
        testcRecNumber("23b".toArray)
        testcRecNumber("a".toArray)

        codegen.emitSource(testRecExpr _ , "testRecExpr", new java.io.PrintWriter(System.out))
        val testcRecExpr = compile(testRecExpr)
        testcRecExpr("2".toArray)
        testcRecExpr("2+3".toArray)
        testcRecExpr("2+3*5".toArray)
        testcRecExpr("(2+3)*5".toArray)
        testcRecExpr("(2+3)*5*5".toArray)

        //testcRecExpr("[[2]]".toArray)
      }
    }
    assertFileEqualsCheck(prefix+"rec-parser")
  }
}

