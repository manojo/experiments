/*package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait MinCaseProg extends HttpParser{

  def myheaders(in: Rep[Input]): Parser[Response] = repFold(header(in))(Response(),
    (res: Rep[Response], hds: Rep[(StringStruct,StringStruct)]) => collect(res, hds._1, hds._2)
  )

  //wholeNum
  def parseWholeNumber(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = wholeNumber(in)
    val res = parser(unit(0))
    println(res)
  }

  //headers parse
  def headersParse(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = myheaders(in)
    val res = parser(unit(0))
    println(res)
  }

}

class TestCaseMin extends FileDiffSuite {

  val prefix = "test-out/"

  def testRespParser = {
    withOutFile(prefix+"resp-parser"){
      new MinCaseProg with MyScalaOpsPkgExp with CharOpsExp
      with MyIfThenElseExpOpt with StructOpsFatExpOptCommon
      with ParseResultOpsExp with OptionOpsExp
      with StringStructOpsExp with BarrierOpsExp
      with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps
        with ScalaGenParseResultOps with ScalaGenFatStructOps
        with ScalaGenOptionOps with ScalaGenStringStructOps
        with ScalaGenBarrierOps with ScalaGenIfThenElseFat {
          val IR: self.type = self
        }

        codegen.emitSource(parseWholeNumber _ , "parseWholeNum", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc5 = compile(parseWholeNumber)
        testc5("1234a".toArray)
        codegen.reset


        val headers = scala.List(
        """|Date: Mon, 23 May 2005 22:38:34 GMT
           |""".stripMargin,

        """|Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
           |""".stripMargin,

        """|Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
           |""".stripMargin,

        """|Etag: \"3f80f-1b6-3e1cb03b\"
           |""".stripMargin,

        """|Content-Type: text/html; charset=UTF-8
           |""".stripMargin,

        """|Content-Length: 131
           |""".stripMargin
        )


        val allHeaders = headers.mkString
        codegen.emitSource(headersParse _, "headersParse", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcHeaders = compile(headersParse)
        testcHeaders(allHeaders.toArray)
        codegen.reset
      }
    }
    assertFileEqualsCheck(prefix+"resp-parser")
  }
}
*/ 