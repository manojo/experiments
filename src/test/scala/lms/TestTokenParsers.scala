package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait TokenParsersProg extends TokenParsers{

  //keyword parse
  def keywordParse(in: Rep[Array[Char]]): Rep[(String,Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = (keyword(in)).apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //two word parse
  def twoWordParse(in: Rep[Array[Char]]): Rep[((String,String),Int)] = {
    var s = make_tuple2(make_tuple2(unit(""), unit("")), unit(-1))
    val parser = ((stringLit(in) <~ whitespaces(in)) ~ stringLit(in)).apply(unit(0))
    parser{x: Rep[((String, String), Int)] => s = x}
    s
  }

  //parse list of chars
  def parseListofChars(in: Rep[Array[Char]]): Rep[(String, Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = accept(in, "hello".toList.map{c => unit(c)}).apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //parse string
  def parseString(in: Rep[Array[Char]]): Rep[(String, Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = accept(in, "hello").apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //wholeNumber
  def parseWholeNumber(in: Rep[Array[Char]]): Rep[(Int, Int)] = {
    var s = make_tuple2(unit(0), unit(-1))
    val parser = wholeNumber(in).apply(unit(0))
    parser{x: Rep[(Int, Int)] => s = x}
    s
  }
}

class TestTokenParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testTokenParsers = {
    withOutFile(prefix+"token-parser"){
       new TokenParsersProg with ScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyScalaCompile{self =>

        val codegen = new ScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps{
          val IR: self.type = self
        }

        codegen.emitSource(keywordParse _ , "keywordParse", new java.io.PrintWriter(System.out))
        val testc1 = compile(keywordParse)
        val res1 = testc1("true false".toArray)
        scala.Console.println(res1)

        codegen.emitSource(twoWordParse _ , "twoWordParse", new java.io.PrintWriter(System.out))
        val testc2 = compile(twoWordParse)
        val res2 = testc2("\"hello\" \"carol\"".toArray)
        scala.Console.println(res2)

        codegen.emitSource(parseListofChars _ , "parseListofChars", new java.io.PrintWriter(System.out))
        val testc3 = compile(parseListofChars)
        scala.Console.println(testc3("hello21".toArray))

        codegen.emitSource(parseString _ , "parseString", new java.io.PrintWriter(System.out))
        val testc4 = compile(parseString)
        scala.Console.println(testc4("hello21".toArray))

        codegen.emitSource(parseWholeNumber _ , "parseWholeNumber", new java.io.PrintWriter(System.out))
        val testc5 = compile(parseWholeNumber)
        scala.Console.println(testc5("1234a".toArray))

      }

    }

    assertFileEqualsCheck(prefix+"token-parser")
  }
}