package lms.parsing

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
    val a = jArray(List(jTrue))
    println(f)
    println(t)
    println(n)
    println(a)
  }

  def primitiveParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[JV](unit(-1))
    val p = primitives(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }

  def jsonParse(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[JV](unit(-1))
    val p = json(in).apply(unit(0))
    p{x => s = x}
    println(s)
  }
}

// TCK BEGIN
// test:run-main lms.parsing.TestJson
object TestJson {
  import java.io._
  class Writer(file:String) extends JsonParserProg with RecParsersExp with MyScalaOpsPkgExp
    with GeneratorOpsExp with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
    with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
    with CastingOpsExp with MyScalaCompile{self =>

    val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
      with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
      with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps
      with ScalaGenCastingOps {
        val IR: self.type = self
      }
    val buf = new ByteArrayOutputStream()
    val pr = new PrintWriter(buf)
    def close {
      val out=new FileOutputStream(file); val pr2=new java.io.PrintWriter(out)
      pr2.println("// Generated file using sbt> test:run-main lms.parsing.TestJson")
      pr2.println("package lms.parsing")
      codegen.emitDataStructures(pr2); pr2.flush; pr.flush; pr.close; out.write(buf.toByteArray); out.close
      System.out.println("Written in "+file)

      // Re-hack the generated file
      val txt = scala.io.Source.fromFile(file).mkString
                 .replaceAll("case class (Tuple2StringString|Tuple2CharString|ParseResultString|ParseResultChar).*\n","")
                 .replaceAll("println\\(.*\\)","()")
      val o2 = new FileOutputStream(file);
      o2.write(txt.getBytes)
      o2.close
    }
  }
  def main(args:Array[String]) {
    val w = new Writer("src/main/scala/lms/parsing/JsonParseGen.scala")
    w.codegen.emitSource(w.jsonParse _ , "JsonParse", w.pr)
    w.close
  }
}

/*
object TestJson {
  def main(args:Array[String]) {
    new JsonParser with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
     with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
     with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
     with MyScalaCompile{self =>
      val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
        with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
        with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps {
        val IR: self.type = self
      }
      // JSON parser prog
      def jsonParse(in: Rep[Array[Char]]): Rep[Unit] = {
        var s = Failure[JV](unit(0))
        val parser = (json2(in)).apply(unit(0))
        parser{x => s = x}
        val r = readVar(s)
        println(unit("Empty=")+r.isEmpty+unit(", next=")+r.next)
        if (!r.isEmpty) println(r.get.mkString)
      }
      codegen.emitSource(jsonParse _ , "jsonParse", new java.io.PrintWriter(System.out))
      codegen.emitDataStructures(new java.io.PrintWriter(System.out))
      codegen.reset
      val testcJsonParse = compile(jsonParse)
       //false,true,null,123,1.23,
      testcJsonParse("[null,false,true,\"hello\",123,1.23,[],[[],[]]]".toArray)
      testcJsonParse("{\"foo\":true,\"bar\":false}".toArray)
    }
  }
}
*/
// TCK END


class TestJsonParser extends FileDiffSuite {

  val prefix = "test-out/"

  def testJsonParser = {
    withOutFile(prefix+"json-parser"){
      new JsonParserProg with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
       with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
       with CastingOpsExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
          with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps
          with ScalaGenCastingOps{
          val IR: self.type = self
        }

        codegen.emitSource(testJPrimitives _, "testJPrimitives", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcJPrimitives = compile(testJPrimitives)
        testcJPrimitives(1)
        codegen.reset

        codegen.emitSource(primitiveParse _, "primitiveParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcPrimitives = compile(primitiveParse)
        testcPrimitives("23".toArray)
        testcPrimitives("2.13".toArray)
        testcPrimitives("-22.13".toArray)
        testcPrimitives("false".toArray)
        testcPrimitives("null".toArray)
        testcPrimitives("true".toArray)
        testcPrimitives("\"hello\"".toArray)
        testcPrimitives("\"\\\"hello\"".toArray)
        testcPrimitives("\"\\/hello\"".toArray)
        testcPrimitives("\"\u003c\"".toArray)
        codegen.reset

        codegen.emitSource(jsonParse _, "jsonParse", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcJson = compile(jsonParse)
        val jsonMsgs = scala.List(
          "3","-32",
          "55.932083999999996", "-55.932083999999996",
          "true","false","null",
          "\"hi\"", "\"\\\"hello\"", "\"\\/hello\"",
          "[3]","[3,[2],[[1]]]",
          "{\"hi\" : 2,\"hey\" : {\"hey\" : 2}}",
          """{
          "address book": {
          "name": "John Smith",
          "address": {
          "street": "10 Market Street",
          "city" : "San Francisco, CA",
          "zip" : 94111
          },
          "phone Nums": [
          "408 338-4238",
          "408 111-6892"
          ]
          }
          }
          """
        )

        jsonMsgs.foreach{msg =>
          testcJson(msg.toArray)
        }

        codegen.reset
      }
    }

    assertFileEqualsCheck(prefix+"json-parser")
  }
}
