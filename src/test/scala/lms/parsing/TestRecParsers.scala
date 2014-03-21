package lms.parsing

import lms._
import lms.util._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait RecParsersProg extends TokenParsers with RecParsers {

  def recNumber: Parser[Int] = {
    def temp: Parser[Int] = rec("hi",
      (digit2Int ~ temp) ^^ {
        x => x._1 + x._2
      } | digit2Int)

    temp
  }

  // expr = term ~ rep("+" ~ term)
  // term = factor ~ rep("*" ~ factor)
  // factor = wholeNumber | "("~ expr ~")"

  def recExpr: Parser[Int] = {
    def expr: Parser[Int] = rec("wow",
      (term ~ repFold(accept(unit('+')) ~> term)(unit(0), (x: Rep[Int], y: Rep[Int]) => x + y))
        ^^ { x => x._1 + x._2 }
    )

    def term: Parser[Int] = (
      factor ~ repFold(accept(unit('*')) ~> factor)(unit(1), (x: Rep[Int], y: Rep[Int]) => x * y)
    ) ^^ { x => x._1 * x._2 }

    def factor = wholeNumber | accept(unit('(')) ~> expr <~ accept(unit(')'))

    expr
  }

  def testRecNumber(in: Rep[Array[Char]]): Rep[Option[Int]] = {
    val parser = recNumber
    phrase(parser, StringReader(in))
  }

  def testRecExpr(in: Rep[Array[Char]]): Rep[Option[Int]] = {
    val parser = recExpr
    phrase(parser, StringReader(in))
  }

}

class TestRecParsers extends FileDiffSuite {
  val prefix = "test-out/"

  def testRec = {
    withOutFile(prefix + "rec-parser") {
      new RecParsersProg with RecParsersExp with MyScalaOpsPkgExp with CharOpsExp
        with MyIfThenElseExpOpt with StructOpsFatExpOptCommon with ParseResultOpsExp
        with FunctionsExp with OptionOpsExp with StringStructOpsExp with StringReaderOpsExp
        with BarrierOpsExp with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps with ScalaGenParseResultOps
          with ScalaGenFatStructOps with ScalaGenFunctions with ScalaGenOptionOps
          with ScalaGenStringStructOps with ScalaGenReaderOps with ScalaGenBarrierOps
          with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        codegen.emitSource(testRecNumber _, "testRecNumber", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcRecNumber = compile(testRecNumber)
        scala.Console.println(testcRecNumber("2".toArray))
        scala.Console.println(testcRecNumber("23".toArray))
        scala.Console.println(testcRecNumber("2a".toArray))
        scala.Console.println(testcRecNumber("23b".toArray))
        scala.Console.println(testcRecNumber("a".toArray))
        codegen.reset

        codegen.emitSource(testRecExpr _, "testRecExpr", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcRecExpr = compile(testRecExpr)
        scala.Console.println(testcRecExpr("2".toArray))
        scala.Console.println(testcRecExpr("2+3".toArray))
        scala.Console.println(testcRecExpr("2+3*5".toArray))
        scala.Console.println(testcRecExpr("(2+3)*5".toArray))
        scala.Console.println(testcRecExpr("(2+3)*5*5".toArray))
        codegen.reset
      }
    }
    assertFileEqualsCheck(prefix + "rec-parser")
  }
}