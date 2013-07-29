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
    var s = make_tuple2(unit(""), ParseResult(unit(false), unit(-1)))
    val parser = (keyword(in)).apply(unit(0))
    parser{x: Rep[(String, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2+")")
    //println("("+readVar(s)._2.position +","+readVar(s)._2.success +")")
  }

  //two word parse
  def twoWordParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(make_tuple2(unit(""), unit("")), ParseResult(unit(false), unit(-1)))
    val parser = ((stringLit(in) <~ whitespaces(in)) ~ stringLit(in)).apply(unit(0))
    parser{x: Rep[((String, String), ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //parse list of chars
  def parseListofChars(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit(""), ParseResult(unit(false), unit(-1)))
    val parser = accept(in, "hello".toList.map{c => unit(c)}).apply(unit(0))
    parser{x: Rep[(String, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //parse string
  def parseString(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit(""), ParseResult(unit(false), unit(-1)))
    val parser = accept(in, "hello").apply(unit(0))
    parser{x: Rep[(String, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //wholeNumber
  def parseWholeNumber(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit(0), ParseResult(unit(false), unit(-1)))
    val parser = wholeNumber(in).apply(unit(0))
    parser{x: Rep[(Int, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

}

class TestTokenParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testTokenParsers = {
    withOutFile(prefix+"token-parser"){
       new TokenParsersProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyScalaCompile{self =>

        //dumpGeneratedCode = true

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps{
          val IR: self.type = self
        }

        val printWriter = new java.io.PrintWriter(System.out)

        codegen.emitSource(keywordParse _ , "keywordParse", printWriter)
        codegen.emitDataStructures(printWriter)
        val testc1 = compile(keywordParse)
        testc1("true false".toArray)


        codegen.emitSource(twoWordParse _ , "twoWordParse", new java.io.PrintWriter(System.out))
        val testc2 = compile(twoWordParse)
        testc2("\"hello\" \"carol\"".toArray)
/*
        codegen.emitSource(parseListofChars _ , "parseListofChars", new java.io.PrintWriter(System.out))
        val testc3 = compile(parseListofChars)
        testc3("hello21".toArray)

        codegen.emitSource(parseString _ , "parseString", new java.io.PrintWriter(System.out))
        val testc4 = compile(parseString)
        testc4("hello21".toArray)

        codegen.emitSource(parseWholeNumber _ , "parseWholeNumber", new java.io.PrintWriter(System.out))
        val testc5 = compile(parseWholeNumber)
        testc5("1234a".toArray)
*/
      }

    }

    assertFileEqualsCheck(prefix+"token-parser")
  }
}
