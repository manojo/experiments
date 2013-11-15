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

trait InterleavedParsers extends NewDesignParsers {

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
  // top-level function for it.
  private def updateChunkEnd(in: Rep[Input]): Parser[Int] = rec("chunkLength",
    // Parse the next chunk length using the chunker and adjust the
    // end-of-chunk pointer.
    Parser { i => chunker.nextChunkLength(in)(i) } >> { octets =>
      Parser { i =>
        chunkEnd = i + octets
        val s = success(octets)
        s(i)
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

trait WordCounter extends NewDesignParsers {

  import ParserWorld._

  /**
   * Check if a given character is white space.
   *
   * This method accepts the same set of white space characters as the
   * C standard library `isspace` function from '<ctype.h>' when used
   * in the "C" or "POXIX" locale.  According to the `isspace(3)`
   * manual page, these are
   *
   *  - space,
   *  - form-feed ('\f'),
   *  - newline ('\n'),
   *  - carriage return ('\r'),
   *  - horizontal tab ('\t'), and
   *  - vertical tab ('\13').
   */
  def isSpace(c: Rep[Char]): Rep[Boolean] =
    c == publicUnit(' ')  || c == publicUnit('\f') ||
    c == publicUnit('\n') || c == publicUnit('\r') ||
    c == publicUnit('\t') || c == publicUnit('\13')
  def isNotSpace(c: Rep[Char]) = !isSpace(c)

  def skipWhile(in: Rep[Input], p: Rep[Elem] => Rep[Boolean]): Parser[Unit] =
    repFold(acceptIf(in, p))(
      publicUnit(()), (_: Rep[Unit], c: Rep[Elem]) => publicUnit(()))

  def skipSpace(in: Rep[Input]): Parser[Unit] = skipWhile(in, isSpace _)
  def skipWord(in: Rep[Input]): Parser[Unit] =
    acceptIf(in, isNotSpace _) ~> skipWhile(in, isNotSpace _)

  def wordCount(in: Rep[Input], acc: Rep[Int]): Parser[Int] =
    skipSpace(in) ~> repFold(skipWord(in) <~ skipSpace(in))(
      acc, (i: Rep[Int], _) => i + 1)

  def apply(in: Rep[Input], acc: Rep[Int]) = wordCount(in, acc)
}

class InterleavedWordCounter(val chunker: Chunker)
    extends WordCounter with InterleavedParsers {

  import ParserWorld._

  override def apply(in: Rep[Input], acc: Rep[Int]) =
    initChunkLength(in) ~> wordCount(in, acc)
}

class ChunkedWordCounter(length: ParserWorld.Rep[Int]) extends WordCounter {

  import ParserWorld._

  // We need a buffer to store chunks in
  val buf: Rep[Input] = NewArray[Char](length)
  val end: Var[Int] = var_new(publicUnit(0))

  // Don't parse after the end of the buffer.
  override def acceptIf(in: Rep[Input], p: Rep[Elem] => Rep[Boolean]) = Parser[Char]{ i =>
    if (i >= readVar(end)) elGen(Failure[Char](i))
    else if (p(in(i))) elGen(Success(in(i), i + publicUnit(1)))
    else elGen(Failure[Char](i))
  }
}

object HTTPTestProg extends Chunker {

  import ParserWorld._

  //TODO: ignoring \r for now
  def crlf(in: Rep[Input]) = accept(in, publicUnit('\n'))

  def firstChunkLength(in: Rep[Input]): Parser[Int] =
    (hexNumber(in) <~ crlf(in)) >> { octets =>
      Parser { i =>
        if (octets == publicUnit(0)) (crlf(in) ~> failure).apply(i)
        else success(octets).apply(i)
      }
    }

  def nextChunkLength(in: Rep[Input]): Parser[Int] =
    (crlf(in) ~> hexNumber(in) <~ crlf(in)) >> { octets =>
      Parser { i =>
        if (octets == publicUnit(0)) (crlf(in) ~> failure).apply(i)
        else success(octets).apply(i)
      }
    }

  def copy(in: Rep[Input], out: Rep[Input], pos: Rep[Int],
    length: Rep[Int]) = Parser[Int] { i =>
    for (j <- publicUnit(0) until length) { out(pos + j) = in(i + j) }
    val s = success(pos + length)
    s(i + length)
  }

  def testChunked(in: Rep[Input]): Rep[Unit] = {

    val wc = new ChunkedWordCounter(in.length)

    // Parse chunk lengths and copy chunks into the buffer.
    val p = firstChunkLength(in) >> { len =>
      copy(in, wc.buf, publicUnit(0), len) } >> { e1 =>
      wc.end = e1
      repFold(nextChunkLength(in) >> { len => copy(in, wc.buf, wc.end, len) })(
        publicUnit(()), { (_: Rep[Unit], e2: Rep[Int]) => wc.end = e2; publicUnit(()) })
    }
    p(publicUnit(0)){ _ => publicUnit(()) }

    var r = Failure[Int](publicUnit(0))
    wc(wc.buf, publicUnit(0))(publicUnit(0)){ x => r = x }
    println(r)
  }

  def testInterleaved(in: Rep[Array[Char]]): Rep[Unit] = {
    var r = Failure[Int](publicUnit(0))
    val wc = new InterleavedWordCounter(this)(in, publicUnit(0))(publicUnit(0))
    wc{ x => r = x }
    println(r)
  }
}

class InterleavedTest extends FileDiffSuite {
  import HTTPTestProg._

  val prefix = "test-out/"

  def testChunkedInterleaved = {
    withOutFile(prefix + "interleaved"){

      val longText =
      """|6
         |Some l
         |1d
         |onger text
         |also including LFs
         |0
         |
         |""".stripMargin

      ParserWorld.codegen.emitSource(
        testChunked _,
        "testChunked",
        new java.io.PrintWriter(System.out)
      )

      val testcChunked = ParserWorld.compile(testChunked)
      testcChunked("0\n".toArray)
      testcChunked("2\nhe\n3\nllo\n0\n\n".toArray)
      testcChunked(longText.toArray)

      ParserWorld.codegen.emitSource(
        testInterleaved _,
        "testInterleaved",
        new java.io.PrintWriter(System.out)
      )

      val testcInterleaved = ParserWorld.compile(testInterleaved)
      testcInterleaved("0\n".toArray)
      testcInterleaved("2\nhe\n3\nllo\n0\n\n".toArray)
      testcInterleaved(longText.toArray)
    }
    assertFileEqualsCheck(prefix+"interleaved")
  }
}

