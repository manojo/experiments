package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait Chunker extends NewDesignParsers {

  import ParserWorld._

  /** Parse the length of the first chunk. */
  def firstChunkLength(in: Rep[Input]): Parser[Int]

  /**
   * Parse the next chunk length.  Should also parse any trailing
   * characters from the previous chunk that might precede the chunk
   * length.
   */
  def nextChunkLength(in: Rep[Input]): Parser[Int]
}

trait Chunked extends NewDesignParsers {

  import ParserWorld._

  /**
   * The "end-of-chunk" pointer.  This holds the position of the end
   * of the last chunk parsed so far.
   */
  val chunkEnd = var_new(publicUnit(0))

  /** The set of parsers used to parse chunk lengths. */
  val chunker: Chunker

  /**
   * Chunk-aware elementary parser.
   *
   * This is where the actual interleaving happens.
   *
   * In addition to checking for the end of the input stream, this
   * parser also checks whether it has reached the end of a chunk, in
   * which case it will call back to the `nextChunkLength` parser to
   * process the next chunk in the input.
   */
  override def acceptIf(in: Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char] { i =>

    if (i >= chunkEnd) { // reached end of chunk

      // Parse the length of the next chunk and continue parsing the
      // next chunk.
      val nextChunk = updateChunkEnd(in) >> { _ =>
        super.acceptIf(in, p)
      }
      nextChunk(i)
    } else super.acceptIf(in, p)(i)
  }

  // FIXME: This parser will most likely never be called recursively.
  // We're just exploiting the 'rec' combinator to generate a
  // top-level function for this parser.
  private def updateChunkEnd(in: Rep[Input]): Parser[Int] =
    rec("chunkLength", success(publicUnit(0)) >> { _ =>
      // Parse the next chunk length using the chunker and adjust the
      // end-of-chunk pointer.
      Parser { i => chunker.nextChunkLength(in)(i) } >> { octets =>
        Parser { i =>
          chunkEnd = i + octets
          val s = success(octets)
          s(i)
        }
      }
    })

  def initChunkLength(in: Rep[Input]): Parser[Int] =
    success(publicUnit(0)) >> { _ =>
      // Parse the first chunk length using the chunker and adjust the
      // end-of-chunk pointer.
      Parser { i => chunker.firstChunkLength(in)(i) } >> { octets =>
        Parser { i =>
          chunkEnd = i + octets
          val s = success(octets)
          s(i)
        }
      }
    }
}

class JsonTest(val chunker: Chunker) extends Chunked {

  import ParserWorld._

  def apply(in: Rep[Input]) = { i: Rep[Int] =>
    val p = initChunkLength(in) ~> rep(word(in) <~ whitespaces(in))
    p(i)
  }
}

object HTTPTestProg extends Chunker {

  import ParserWorld._

  //TODO: ignoring \r for now
  def crlf(in: Rep[Input]) = accept(in, publicUnit('\n'))

  def firstChunkLength(in: Rep[Input]): Parser[Int] =
    (hexNumber(in) <~ crlf(in)) >> { octets =>
      println(publicUnit("octets: ") + octets)
      if (octets == publicUnit(0)) crlf(in) ~> failure
      else success(octets)
    }

  def nextChunkLength(in: Rep[Input]): Parser[Int] =
    (crlf(in) ~> hexNumber(in) <~ crlf(in)) >> { octets =>
      println(publicUnit("octets: ") + octets)
      if (octets == publicUnit(0)) crlf(in) ~> failure
      else success(octets)
    }

  def testChunked(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[List[String]](publicUnit(-1))
    val p = new JsonTest(this)(in)(publicUnit(0))
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
      """|6
         |Some l
         |1d
         |onger text
         |also including LFs
         |0
         |
         |""".stripMargin

      val testcChunked = ParserWorld.compile(testChunked)
      testcChunked("0\n".toArray)
      testcChunked("2\nhe\n3\nllo\n0\n\n".toArray)
      testcChunked(longText.toArray)
    }
    assertFileEqualsCheck(prefix+"interleaved")
  }
}

