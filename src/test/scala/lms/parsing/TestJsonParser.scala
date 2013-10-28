package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait JsonParserProg extends JsonParser{

  def jsonParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(String,String)](unit(-1))
    val p = json(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }

}

class TestJsonParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testHttpParser = {
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

        codegen.emitSource(jsonParse _ , "jsonParse", new java.io.PrintWriter(System.out))
        val testcJsonParse = compile(jsonParse)
        testcJsonParse("{}".toArray)
        testcJsonParse("{\"asdf\" : \"asd\"}".toArray)
      }
    }

    assertFileEqualsCheck(prefix+"json-parser")
  }
}