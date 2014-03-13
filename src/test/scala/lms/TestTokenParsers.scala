package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait TokenParsersProg extends TokenParsers {

  //keyword parse
  def keywordParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = keyword(in)
    val res = parser(unit(0))
    println(res)
  }

  //two word parse
  def twoWordParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = ((stringLit(in) <~ whitespaces(in)) ~ stringLit(in))
    val res = parser(unit(0))
    println(res)
  }

  //parse string
  def parseString(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = accept(in, "hello")
    val res = parser(unit(0))
    println(res)
  }

  //wholeNum
  def parseWholeNumber(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = wholeNumber(in)
    val res = parser(unit(0))
    println(res)
  }

  //stringStruct
  def parseStringStruct(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = stringStruct(in, letterIdx(in)) ^^ { x => make_tuple2(x.start, x.length) }
    val res = parser(unit(0))
    println(res)
  }

  //stringStruct
  def parseStringStruct2(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = stringStruct(in, letterIdx(in) | acceptIdx(in, unit('-'))) ^^ { x => make_tuple2(x.start, x.length) }
    val res = parser(unit(0))
    println(res)
  }

  //acceptB
  def parseStringB(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = acceptB(in, "hello")
    val res = parser(unit(0))
    println(res)
  }

}

class TestTokenParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testTokenParsers = {
    withOutFile(prefix + "token-parser") {
      new TokenParsersProg with MyScalaOpsPkgExp with CharOpsExp with MyIfThenElseExpOpt with StructOpsFatExpOptCommon with ParseResultOpsExp with OptionOpsExp with StringStructOpsExp with BarrierOpsExp with MyScalaCompile { self =>

        //dumpGeneratedCode = true

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenFatStructOps with ScalaGenOptionOps with ScalaGenStringStructOps with ScalaGenBarrierOps with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        val printWriter = new java.io.PrintWriter(System.out)

        codegen.emitSource(keywordParse _, "keywordParse", printWriter)
        codegen.reset

        val testc1 = compile(keywordParse)
        testc1("true false".toArray) //successful
        testc1("bla".toArray) //fail
        codegen.reset

        codegen.emitSource(twoWordParse _, "twoWordParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(twoWordParse)
        testc2("\"hello\" \"carol\"".toArray)
        testc2("\"hello\" ".toArray)
        codegen.reset

        codegen.emitSource(parseString _, "parseString", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(parseString)
        testc4("hello21".toArray)
        codegen.reset

        codegen.emitSource(parseWholeNumber _, "parseWholeNum", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc5 = compile(parseWholeNumber)
        testc5("1234a".toArray)
        codegen.reset

        codegen.emitSource(parseStringStruct _, "parseStringStruct", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStringStruct = compile(parseStringStruct)
        testcStringStruct("hello21".toArray)
        testcStringStruct("helloasd".toArray)
        codegen.reset

        codegen.emitSource(parseStringStruct2 _, "parseStringStruct2", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStringStruct2 = compile(parseStringStruct2)
        testcStringStruct2("content-length".toArray)
        testcStringStruct2("passing-ast".toArray)
        codegen.reset

        codegen.emitSource(parseStringB _, "parseStringB", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcParseStringB = compile(parseStringB)
        testcParseStringB("hello".toArray)
        testcParseStringB("blah".toArray) //different length
        testcParseStringB("h3ll0".toArray) //same length
        codegen.reset

      }
    }

    assertFileEqualsCheck(prefix + "token-parser")
  }
}
