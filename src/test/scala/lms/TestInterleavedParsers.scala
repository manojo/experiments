package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

object HTTPTestProg extends NewDesignParsers{ self =>
  import ParserWorld._

  val chunkEnd = var_new(publicUnit(0))

  def chunkedStart(in:Rep[Array[Char]]): Parser[String] =
    (digit2Int(in)<~ accept(in, publicUnit('-'))) >> {d => Parser{ i=>
      if(d == publicUnit(0)) elGen(Success(/*publicUnit(-1)*/publicUnit(""),i))
      else{
        chunkEnd = i+d
        JsonTest(in).apply(i)
      }
    }}

  def chunkedInner(in:Rep[Array[Char]]): Parser[Unit] = //rec("chunked",
    (digit2Int(in)<~ accept(in, publicUnit('-'))) >> {d => Parser{ i=>
      if(d == publicUnit(0)) elGen(Failure(i))
      else{
        chunkEnd = i + d
        elGen(Success(publicUnit(()), i))
      }
    }}
  //)

  object JsonTest extends NewDesignParsers{
    //import ParserWorld._

    override def acceptIf(in:Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char]{ i =>
      if(i == readVar(chunkEnd))
        (chunkedInner(in) >> { x: Rep[Unit] => super.acceptIf(in,p).asInstanceOf[HTTPTestProg.Parser[Char]]}).apply(i)
      else
        super.acceptIf(in,p).apply(i) //asInstanceOf[lms.HTTPTestProg.Parser[Char]]
    }

    def apply(in: Rep[Input]) = (
      numeric(in) //word(in)
      //wholeNumber(in)
      //(wholeNumber(in) <~ accept(in,publicUnit('.'))) |
      //wholeNumber(in)
    )
  }

  def testChunked(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[String](publicUnit(-1))
    val p = chunkedStart(in).apply(publicUnit(0))
    p{x => s = x}
    println(s)
  }

}

class InterleavedTest extends FileDiffSuite {
  import HTTPTestProg._

  val prefix = "test-out/"

  def testInterleaved = {
    withOutFile(prefix + "interleaved"){

      ParserWorld.codegen.emitSource(
        testChunked _,
        "testChunked",
        new java.io.PrintWriter(System.out)
      )

      val testcChunked = ParserWorld.compile(testChunked)
      testcChunked("0-".toArray)
      //testcChunked("223323.0".toArray)
      //testcChunked("2he3llo0".toArray)
      testcChunked("2-123-3450-".toArray)
    }
    assertFileEqualsCheck(prefix+"interleaved")
  }
}

