package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects
import scala.virtualization.lms.internal._

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait CSVParserProg extends CSVParser {

  def csvOnlyDoublesParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[List[Double]](unit(-1))
    val p = csvOnlyDoubles(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }

  def csvBooleanParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[JV](unit(-1))
    val p = csv(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }

}

class TestCSVParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testCSVParser  = {
    withOutFile(prefix+"csv-parser"){

      new CSVParserProg with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
       with CastingOpsExp with ListBufferOpsExp with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps
          with ScalaGenCastingOps with ScalaGenListBufferOps {
          val IR: self.type = self
        }

        codegen.emitSource(csvOnlyDoublesParse _, "csvOnlyDoublesParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcCsvDoubles = compile(csvOnlyDoublesParse)
        testcCsvDoubles("[23.0, -123.4323, 43.252, 2.3421, 34.5678]".toArray)
        codegen.reset

        codegen.emitSource(csvBooleanParse _, "csvBooleanParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcCsvBoolean = compile(csvBooleanParse)
        testcCsvBoolean("[true, false, false, true, false, true, true]".toArray)
        codegen.reset
      }
    }

    assertFileEqualsCheck(prefix+"csv-parser")
  }
}

// test:run-main lms.parsing.TestCSV
object TestCSV {
  import java.io._

  class Writer(file:String, className: String) extends CSVParserProg with RecParsersExp with MyScalaOpsPkgExp
    with GeneratorOpsExp with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
    with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
    with CastingOpsExp with ListBufferOpsExp with MyScalaCompile { self =>

    val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
      with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
      with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps
      with ScalaGenCastingOps with ScalaGenListBufferOps {
        val IR: self.type = self
      }
    val buf = new ByteArrayOutputStream()
    val pr = new PrintWriter(buf)

    def close {
      val out = new FileOutputStream(file); val pr2 = new java.io.PrintWriter(out)
      pr2.println("// Generated file using sbt> test:run-main lms.parsing.TestCSV")
      pr2.println("package lms.parsing")
      codegen.emitDataStructures(pr2); pr2.flush; pr.flush; pr.close; out.write(buf.toByteArray); out.close

      System.out.println("Written in "+file)

      // Re-hack the generated file
      val txt = scala.io.Source.fromFile(file).mkString
                 .replaceAll("case class (Tuple2StringString|Tuple2CharString|ParseResultString|ParseResultChar).*\n","")
                 .replaceAll("class " + className,"case class " + className) // serializability for benchmarks
                 .replaceAll("println\\(.*\\)","()")
      val o2 = new FileOutputStream(file);
      o2.write(txt.getBytes)
      o2.close
    }
  }

  def main(args:Array[String]) {
    val w = new Writer("src/main/scala/lms/parsing/CSVDoubleParseGen.scala", "CSVDoubleParseGen")
    w.codegen.emitSource(w.csvOnlyDoublesParse _ , "CSVDoubleParseGen", w.pr)
    w.close

    val w2 = new Writer("src/main/scala/lms/parsing/CSVBooleanParseGen.scala", "CSVBooleanParseGen")
    w2.codegen.emitSource(w2.csvBooleanParse _ , "CSVBooleanParseGen", w2.pr)
    w2.close
  }
}