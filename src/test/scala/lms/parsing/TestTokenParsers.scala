package lms.parsing

import lms._
import lms.util._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait TokenParsersProg extends TokenParsers {

  //keyword parse
  def keywordParse(in: Rep[Array[Char]]): Rep[Option[String]] = {
    val parser = keyword
    phrase(parser, StringReader(in))
  }

  //two word parse
  def twoWordParse(in: Rep[Array[Char]]): Rep[Option[(String, String)]] = {
    val parser = (stringLit <~ whitespaces) ~ stringLit
    phrase(parser, StringReader(in))
  }

  //parse string
  def parseString(in: Rep[Array[Char]]): Rep[Option[String]] = {
    val parser = accept("hello")
    phrase(parser, StringReader(in))
  }

  //wholeNum
  def parseWholeNumber(in: Rep[Array[Char]]): Rep[Option[Int]] = {
    val parser = wholeNumber
    phrase(parser, StringReader(in))
  }

  //stringStruct
  def parseStringStruct(in: Rep[Array[Char]]): Rep[Option[(Int,Int)]] = {
    val parser = stringStruct(letterIdx) ^^ { x => make_tuple2(x.start, x.length) }
    phrase(parser, StringReader(in))
  }

  //stringStruct
  def parseStringStruct2(in: Rep[Array[Char]]): Rep[Option[(Int,Int)]] = {
    val parser = stringStruct(letterIdx | acceptIdx(unit('-'))) ^^ { x => make_tuple2(x.start, x.length) }
    phrase(parser, StringReader(in))
  }

  //acceptB
  def parseStringB(in: Rep[Array[Char]]): Rep[Option[Boolean]] = {
    val parser = acceptB("hello")
    phrase(parser, StringReader(in))
  }

}

class TestTokenParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testTokenParsers = {
    withOutFile(prefix + "token-parser") {
      new TokenParsersProg with MyScalaOpsPkgExp with CharOpsExp with MyIfThenElseExpOpt
        with StructOpsFatExpOptCommon with ParseResultOpsExp with OptionOpsExp with StringStructOpsExp
        with StringReaderOpsExp with BarrierOpsExp with MyScalaCompile { self =>

        //dumpGeneratedCode = true

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps with ScalaGenParseResultOps
          with ScalaGenFatStructOps with ScalaGenOptionOps with ScalaGenStringStructOps
          with ScalaGenBarrierOps with ScalaGenIfThenElseFat with ScalaGenReaderOps {
          val IR: self.type = self
        }

        val printWriter = new java.io.PrintWriter(System.out)

        codegen.emitSource(keywordParse _, "keywordParse", printWriter)
        codegen.reset

        val testc1 = compile(keywordParse)
        scala.Console.println(testc1("true false".toArray)) //successful
        scala.Console.println(testc1("bla".toArray)) //fail
        codegen.reset

        codegen.emitSource(twoWordParse _, "twoWordParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(twoWordParse)
        scala.Console.println(testc2("\"hello\" \"carol\"".toArray))
        scala.Console.println(testc2("\"hello\" ".toArray))
        codegen.reset

        codegen.emitSource(parseString _, "parseString", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(parseString)
        scala.Console.println(testc4("hello21".toArray))
        codegen.reset

        codegen.emitSource(parseWholeNumber _, "parseWholeNum", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc5 = compile(parseWholeNumber)
        scala.Console.println(testc5("1234a".toArray))
        codegen.reset

        codegen.emitSource(parseStringStruct _, "parseStringStruct", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStringStruct = compile(parseStringStruct)
        scala.Console.println(testcStringStruct("hello21".toArray))
        scala.Console.println(testcStringStruct("helloasd".toArray))
        codegen.reset

        codegen.emitSource(parseStringStruct2 _, "parseStringStruct2", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStringStruct2 = compile(parseStringStruct2)
        scala.Console.println(testcStringStruct2("content-length".toArray))
        scala.Console.println(testcStringStruct2("passing-ast".toArray))
        codegen.reset

        codegen.emitSource(parseStringB _, "parseStringB", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcParseStringB = compile(parseStringB)
        scala.Console.println(testcParseStringB("hello".toArray))
        scala.Console.println(testcParseStringB("blah".toArray)) //different length
        scala.Console.println(testcParseStringB("h3ll0".toArray)) //same length
        codegen.reset

      }
    }

    assertFileEqualsCheck(prefix + "token-parser")
  }
}