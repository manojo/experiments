/*package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait JsonParserProg extends JsonParser{
/*
  def jsonParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(String,String)](unit(-1))
    val p = json(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }
*/

  def testJPrimitives(i: Rep[Int]) = {
    val f = jFalse
    val t = jTrue
    val n = jNull
    println(f)
    println(t)
    println(n)
  }

  def primitiveParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[JV](unit(-1))
    val p = primitives(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }
}

class TestJsonParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testJsonParser = {
    withOutFile(prefix+"json-parser"){
      new JsonParserProg with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
       with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps{
          val IR: self.type = self
        }

        codegen.emitSource(testJPrimitives _, "testJPrimitives", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcJPrimitives = compile(testJPrimitives)
        testcJPrimitives(1)
        codegen.reset

        codegen.emitSource(primitiveParse _, "primitiveParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcPrimitives = compile(primitiveParse)
        testcPrimitives("23".toArray)
        //testcPrimitives("2.13".toArray)
        testcPrimitives("false".toArray)
        testcPrimitives("null".toArray)
        testcPrimitives("true".toArray)
        testcPrimitives("\"hello\"".toArray)
        codegen.reset

        //codegen.emitSource(jsonParse _ , "jsonParse", new java.io.PrintWriter(System.out))
        //val testcJsonParse = compile(jsonParse)
        //testcJsonParse("{}".toArray)
        //testcJsonParse("{\"asdf\" : \"asd\"}".toArray)
      }
    }

    assertFileEqualsCheck(prefix+"json-parser")
  }
}
*/