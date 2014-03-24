package lms.parsing

import lms._
import lms.util._
import examples._

import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait JsonParserProg extends JsonParser {

  def jsonParse(in: Rep[Array[Char]]): Rep[Option[JV]] = {
    phrase(json, StringReader(in))
  }

  def testJPrimitives(i: Rep[Int]): Rep[Unit] = {
    val f = jFalse
    val t = jTrue
    val n = jNull
    println(f)
    println(t)
    println(n)
  }

  def primitiveParse(in: Rep[Array[Char]]): Rep[Option[JV]] = {
    phrase(primitives, StringReader(in))
  }

  def reppedPrimitives(in: Rep[Array[Char]]): Rep[Option[List[JV]]] = {
    val parser =
      (chr('[') ~> whitespaces) ~>
      repsep(primitives, whitespaces ~> chr(',') ~> whitespaces) <~
      (whitespaces ~> chr(']'))

    phrase(parser, StringReader(in))
  }
}

class TestJsonParser extends FileDiffSuite {

  val prefix = "test-out/"

  //load tweet data
  def tweetData: Array[Char] = {
    import java.io.{ BufferedReader, FileReader, Serializable }
    import scala.collection.mutable.ArrayBuffer

    val file = new BufferedReader(new FileReader("src/test/resources/just_tweet1"))
    val out = new ArrayBuffer[Char]

    var line = file.readLine

    while (line != null) {
      out ++= line + "\n"
      line = file.readLine
    }

    out.toArray
  }

  def testJsonParser = {
    withOutFile(prefix + "json-parser") {
      new JsonParserProg with RecParsersExp with MyScalaOpsPkgExp with CharOpsExp
        with MyIfThenElseExpOpt with StructOpsFatExpOptCommon with ParseResultOpsExp
        with OptionOpsExp with StringStructOpsExp with StringReaderOpsExp with BarrierOpsExp
        with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps with ScalaGenParseResultOps
          with ScalaGenFatStructOps with ScalaGenOptionOps with ScalaGenStringStructOps
          with ScalaGenReaderOps with ScalaGenBarrierOps with ScalaGenIfThenElseFat {
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
        scala.Console.println(testcPrimitives("23".toArray))
        scala.Console.println(testcPrimitives("2.13".toArray))
        scala.Console.println(testcPrimitives("-22.13".toArray))
        scala.Console.println(testcPrimitives("false".toArray))
        scala.Console.println(testcPrimitives("null".toArray))
        scala.Console.println(testcPrimitives("true".toArray))
        scala.Console.println(testcPrimitives("\"hello\"".toArray))
        scala.Console.println(testcPrimitives("\"\\\"hello\"".toArray))
        scala.Console.println(testcPrimitives("\"\\/hello\"".toArray))
        scala.Console.println(testcPrimitives("\"\u003c\"".toArray))
        codegen.reset


        codegen.emitSource(reppedPrimitives _, "reppedPrimitives", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcReppedPrimitives = compile(reppedPrimitives)
        scala.Console.println(testcReppedPrimitives("[2,3,3]".toArray))
        scala.Console.println(testcReppedPrimitives("[1,false,54]".toArray))
        scala.Console.println(testcReppedPrimitives("[-22.13, 56, null]".toArray))
        scala.Console.println(testcReppedPrimitives("[null, true]".toArray))
        scala.Console.println(testcReppedPrimitives("[null, false]".toArray))
        codegen.reset

        codegen.emitSource(jsonParse _, "jsonParse", new java.io.PrintWriter(System.out))
//        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcJson = compile(jsonParse)
        val jsonMsgs = scala.List(
          "3", "-32",
          "55.932083999999996", "-55.932083999999996",
          "true", "false", "null",
          "\"hi\"", "\"\\\"hello\"", "\"\\/hello\"",
          "[3]", "[3,[2],[[1]]]",
          "[false, true]",
          "{\"hi\" : 2}",
          "{\"hi\" : 2, \"hoy\" : 3}",
          "{\"hi\" : {\"hoy\" : 3}}",
          "{\"hi\" : 2, \"hoy\" : [3]}",
          "{\"hi\" : 2,\"hey\" : {\"hey\" : 2}}",
          "{\"hi\" : true,\"hey\" : null}",
          "{\"hi\" : true,\"hey\" : {\"hey\" : null}}",
          "{\"hi\" : true,\"hey\" : {\"hey\" : false}}",
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

        jsonMsgs.foreach { msg =>
          scala.Console.println(testcJson(msg.toArray))
        }

        //scala.Console.println(testcJson(tweetData))

        codegen.reset
      }

    }

    assertFileEqualsCheck(prefix + "json-parser")
  }
}