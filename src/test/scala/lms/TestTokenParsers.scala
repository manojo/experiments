package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait TokenParsersProg extends TokenParsers{

  //keyword parse
  def keywordParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    val parser = keyword(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //two word parse
  def twoWordParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(String, String)](unit(-1))
    val parser = ((stringLit(in) <~ whitespaces(in)) ~ stringLit(in)).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //parse string
  def parseString(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](unit(-1))
    val parser = accept(in, "hello").apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //wholeNum
  def parseWholeNumber(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Int](unit(-1))
    val parser = wholeNumber(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //doubleLit
  def parseDoubleLit(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Double](unit(-1))
    val parser = doubleLit(in).apply(unit(0))
    parser{x => s = x}
    println(s)
  }

  //stringStruct
  def parseStringStruct(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[StringStruct](unit(-1))
    val parser = stringStruct(in, letterIdx(in)).apply(unit(0))
    parser{x => s = x}
    println(readVar(s).get.start + unit(", ") + readVar(s).get.length)
  }

  //stringStruct
  def parseStringStruct2(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[StringStruct](unit(-1))
    val parser = stringStruct(in, letterIdx(in) | acceptIdx(in, unit('-'))).apply(unit(0))
    parser{x => s = x}
    println(readVar(s).get.start + unit(", ") + readVar(s).get.length)
  }

  //acceptB
  def parseStringB(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Boolean](unit(-1))
    val parser = acceptB(in, "hello").apply(unit(0))
    parser{x => s = x}
    println(s)
  }

}

class TestTokenParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testTokenParsers = {
    withOutFile(prefix+"token-parser"){
       new TokenParsersProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with OptionOpsExp with StringStructOpsExp with MyScalaCompile{self =>

        //dumpGeneratedCode = true

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenParseResultOps
         with ScalaGenStructOps with ScalaGenOptionOps with ScalaGenStringStructOps{
          val IR: self.type = self
        }

        val printWriter = new java.io.PrintWriter(System.out)

        codegen.emitSource(keywordParse _ , "keywordParse", printWriter)
        codegen.reset

        val testc1 = compile(keywordParse)
        testc1("true false".toArray)//successful
        testc1("bla".toArray)//fail
        codegen.reset

        codegen.emitSource(twoWordParse _ , "twoWordParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(twoWordParse)
        testc2("\"hello\" \"carol\"".toArray)
        testc2("\"hello\" ".toArray)
        codegen.reset

        codegen.emitSource(parseString _ , "parseString", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(parseString)
        testc4("hello21".toArray)
        codegen.reset

        codegen.emitSource(parseWholeNumber _ , "parseWholeNum", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc5 = compile(parseWholeNumber)
        testc5("1234a".toArray)
        testc5("-123".toArray)
        codegen.reset

        codegen.emitSource(parseDoubleLit _ , "parseDoubleLit", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcDoubleLit = compile(parseDoubleLit)
        testcDoubleLit("55.932083999999996".toArray)
        testcDoubleLit("-55.932083999999996".toArray)
        codegen.reset

        codegen.emitSource(parseStringStruct _ , "parseStringStruct", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStringStruct = compile(parseStringStruct)
        testcStringStruct("hello21".toArray)
        testcStringStruct("helloasd".toArray)
        codegen.reset

        codegen.emitSource(parseStringStruct2 _ , "parseStringStruct2", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcStringStruct2 = compile(parseStringStruct2)
        testcStringStruct2("content-length".toArray)
        testcStringStruct2("passing-ast".toArray)
        codegen.reset

        codegen.emitSource(parseStringB _ , "parseStringB", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcParseStringB = compile(parseStringB)
        testcParseStringB("hello".toArray)
        testcParseStringB("blah".toArray) //different length
        testcParseStringB("h3ll0".toArray) //same length
        codegen.reset


      }
    }

    assertFileEqualsCheck(prefix+"token-parser")
  }
}