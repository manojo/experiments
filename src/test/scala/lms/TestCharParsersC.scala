package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

class TestCharParsersC extends FileDiffSuite {

  val prefix = "test-out/"

  def testSimpleParsers = {
    withOutFile(prefix+"char-parser-c"){
       new CharParsersProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with FunctionsExp with OptionOpsExp{self =>

        val codegen = new MyCCodeGenPkg with CGenGeneratorOps
          with CGenCharOps with CGenParseResultOps with CGenStructOps
          with CGenFunctions with CGenOptionOps{
            val IR: self.type = self
        }

        codegen.emitSource(test1 _ , "test1", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))

//        codegen.emitSource(test2 _ , "test2", new java.io.PrintWriter(System.out))
//        val testc2 = compile(test2)
//        testc2("hello".toArray)
//        testc2("1".toArray)
//
//        codegen.emitSource(test3 _ , "test3", new java.io.PrintWriter(System.out))
//        val testc3 = compile(test3)
//        testc3("hello".toArray)
//        testc2("1".toArray)
//
//        codegen.emitSource(test4 _ , "test4", new java.io.PrintWriter(System.out))
//        val testc4 = compile(test4)
//        testc4("12".toArray)
//        testc4("hello".toArray)
//
//        codegen.emitSource(test5 _ , "test5", new java.io.PrintWriter(System.out))
//        val testc5 = compile(test5)
//        testc5("hello".toArray) //succeeding a ~ b
//        testc5("1ello".toArray) //failing left
//        testc5("h2llo".toArray) //failing right
//
//        codegen.emitSource(test6 _ , "test6", new java.io.PrintWriter(System.out))
//        val testc6 = compile(test6)
//        testc6("hello".toArray)
//
//        codegen.emitSource(test7 _ , "test7", new java.io.PrintWriter(System.out))
//        val testc7 = compile(test7)
//        testc7("hello".toArray)
//
//        //digit2Int
//        codegen.emitSource(test8 _ , "test8", new java.io.PrintWriter(System.out))
//        val testc8 = compile(test8)
//        testc8("1ello".toArray)
//        testc8("hello".toArray)
//
//        codegen.emitSource(test9 _ , "test9", new java.io.PrintWriter(System.out))
//        val testc9 = compile(test9)
//        testc9("hello".toArray)
//        testc9("12".toArray)
//        testc9(":".toArray)
//
//        codegen.emitSource(testOr2 _ , "testOr2", new java.io.PrintWriter(System.out))
//        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
//        val testcOr2 = compile(testOr2)
//        testcOr2("hello".toArray)
//        testcOr2("12".toArray)
//        testcOr2(":".toArray) //fail case
//        testcOr2("h1".toArray) //fail case
//        testcOr2("1d".toArray) //fail case
//
//        codegen.emitSource(test10 _ , "test10", new java.io.PrintWriter(System.out))
//        val testc10 = compile(test10)
//        testc10("hello21".toArray)
//
//        codegen.emitSource(test11 _ , "test11", new java.io.PrintWriter(System.out))
//        val testc11 = compile(test11)
//        testc11("12345".toArray)
//        testc11("asd".toArray)
//        testc11("".toArray)
//
//        val printWriter = new java.io.PrintWriter(System.out)
//        codegen.emitSource2(testCond _, "testCond", printWriter)
//        codegen.emitDataStructures(printWriter)
//
//        val source = new StringWriter
//        codegen.emitDataStructures(new PrintWriter(source))
//        val testcCond = compile2s(testCond, source)
//        testcCond("b".toArray, 2)
//        testcCond("c".toArray, 6)
//
//        codegen.emitSource(testBind _ , "testBind", new java.io.PrintWriter(System.out))
//        val testcBind = compile(testBind)
//        testcBind("ab".toArray) //successful
//        testcBind("ac".toArray) //fail
//        testcBind("cd".toArray) //successful
//        testcBind("ca".toArray) //fail

      }
      assertFileEqualsCheck(prefix+"char-parser-c")
    }
  }
/*  def testOr{
    withOutFile(prefix+"or-parser"){
      new CharParsersProg with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with MyFunctionsRecursiveExp with OptionOpsExp
       with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps{
            val IR: self.type = self
        }

        codegen.emitSource(testOr2 _ , "testOr2", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        val testcOr2 = compile(testOr2)
        testcOr2("hello".toArray)
        testcOr2("12".toArray)
        testcOr2(":".toArray) //fail case
        testcOr2("h1".toArray) //fail case
        testcOr2("1d".toArray) //fail case

        codegen.emitSource(testOr3 _ , "testOr3", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        val testcOr3 = compile(testOr3)
        testcOr3("he3lo".toArray)
        testcOr3("123".toArray)
        testcOr3(":".toArray) //fail case
        testcOr3("he1".toArray) //fail case
        testcOr3("12d".toArray) //fail case

      }
    }
    assertFileEqualsCheck(prefix+"or-parser")
  }
*/
}