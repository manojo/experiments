package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait Chunked extends NewDesignParsers {

  import ParserWorld._

  val chunkEnd = var_new(publicUnit(0))

  //TODO: ignoring \r for now
  def crlf(in: Rep[Input]) = accept(in, publicUnit('\n'))

  // FIXME: Make this a single top-level function?
  def chunkLength(in: Rep[Input]): Parser[Int] = {

    // Temporarily disable end-of-chunk checking so we can parse
    // the length of the next chunk.
    val in2 = (in._1, publicUnit(false))

    (crlf(in2) ~> hexNumber(in2) <~ crlf(in2)) >> { octets =>
      println(publicUnit("octets: ") + octets)
      if (octets == publicUnit(0)) crlf(in2) ~> failure
      else Parser { i => elGen(Success(i + octets, i)) }
    }
  }

  override def acceptIf(in: Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char] { i =>

    // FIXME: Implement proper short-cutting of && and || in LMS...
    val eoc = if (in._2) i >= chunkEnd else publicUnit(false)
    if (eoc) { // reached end of chunk

      // Parse the length of the next chunk, adjust the end-of-chunk
      // pointer and continue parsing the next chunk.
      val nextChunk = chunkLength(in) >> { end: Rep[Int] =>
        chunkEnd = end
        super.acceptIf((in._1, publicUnit(true)), p)
      }
      nextChunk(i)
    } else super.acceptIf(in, p)(i)
  }
}

object JsonTest extends Chunked {

  import ParserWorld._

  def apply(in: Rep[Input]) = {
    chunkEnd = publicUnit(0)
    //numeric(in)
    rep(word(in) <~ whitespaces(in))
    //wholeNumber(in)
    //(wholeNumber(in) <~ accept(in,publicUnit('.'))) |
    //wholeNumber(in)
  }
}

object HTTPTestProg extends NewDesignParsers {

  import ParserWorld._


  def testChunked(in: Rep[Array[Char]]): Rep[Unit] = {
    val initIn = (in, publicUnit(true))
    var s = Failure[List[String]](publicUnit(-1))
    val p = JsonTest(initIn)(publicUnit(0))
    p{ x => s = x }
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

      // A HTTP message
      val httpMessage =
      """|HTTP/1.1 418 I'm a teapot
         |Date: Mon, 23 May 2005 22:38:34 GMT
         |Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
         |Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
         |Etag: "3f80f-1b6-3e1cb03b"
         |Content-Type: text/html; charset=UTF-8
         |Transfer-Encoding: chunked
         |Connection: close
         |
         |6
         |Some l
         |1a
         |onger text:
         |including LFs...
         |
         |""".stripMargin

      val longText =
      """|
         |6
         |Some l
         |1d
         |onger text
         |also including LFs
         |0
         |
         |""".stripMargin

      val testcChunked = ParserWorld.compile(testChunked)
      testcChunked("\n0\n".toArray)
      testcChunked("\n2\nhe\n3\nllo\n0\n\n".toArray)
      testcChunked(longText.toArray)
    }
    assertFileEqualsCheck(prefix+"interleaved")
  }
}

