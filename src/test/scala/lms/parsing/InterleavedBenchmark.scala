package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import parsing.HTTP
import done._

//class HttpParseBenchmark extends PerformanceTest.Regression
class InterleavedBenchmark extends PerformanceTest
  with Serializable {

  /* configuration */
  def executor = SeparateJvmsExecutor(
    new Executor.Warmer.Default,
    Aggregator.min,
    new Measurer.Default)

  def reporter = new LoggingReporter
  def persistor = Persistor.None

  def mkTestData(size: Int): Array[Char] = {

    // Minimal an maximal chunk size
    val minChunkLength = 4000
    val maxChunkLength = 5000

    // Tokens used to generate the string
    val tokens = List("hi", " ", "foo", "bar")
    val rand = new scala.util.Random(1234)

    // Generate a random string of a few thousand characters from the
    // tokens.
    var randString = ""
    while(randString.length < 12355){
      val num = rand.nextInt(tokens.length)
      randString += tokens(num)
    }

    // Fill an array of the desired size with the random string data.
    val len = randString.length
    val data = Array.tabulate[Char](size) { i =>
      randString(i % len)
    }

    // Chunk the data
    var pos = 0
    while(pos < (size - maxChunkLength)){

      // Pick a chunk size at random between `minChunkLength` and
      // `maxChunkSize`.
      val chunkSize = minChunkLength + rand.nextInt(maxChunkLength - minChunkLength)

      // Copy the chunk size into the data array.
      val s = chunkSize.toHexString
      s.copyToArray(data, pos)
      pos += s.length

      // Add an LF terminator after the chunk size.
      data(pos) = '\n'
      pos +=1

      // Skip to the position after the chunk (`chunkSize` characters
      // after the chunk header) and insert an LF terminator for
      // the chunk.
      pos += chunkSize
      data(pos) = '\n'
      pos += 1
    }

    // Add the terminator sequence (an empty chunk followed by CRLF).
    data(pos + 0) = '0';
    data(pos + 1) = '\n'
    data(pos + 2) = '\n'

    println("data: " + data.take(60).mkString("").replace("\n", "\\n") + "...")
    data
  }

  /******* Uncomment below for using regression testing ****/
    //override def reporter: Reporter = Reporter.Composite(
    //  new RegressionReporter(
    //    RegressionReporter.Tester.Accepter(),
    //    RegressionReporter.Historian.Complete()),
    //  HtmlReporter(true)
    //)
  /******* Stop uncommenting *****/
    //def persistor = new SerializationPersistor

  // multiple tests can be specified here

  def bench(obj: String, meth: String, f: Array[Char] => _) {
    //val range = Gen.enumeration("size")(1, 10)
    val range = Gen.exponential("size")(1, 1000, 10)
    performance of obj in {
      measure method meth config(
        exec.minWarmupRuns -> 5,
        exec.maxWarmupRuns -> 10,
        exec.benchRuns -> 25,
        exec.independentSamples -> 4
      ) in {
        using(range) /*.config(exec.jvmflags -> "-Xmx12G -Xms12G -Xss64m")*/ in { n=>
          // we use while to remove overhead of for ... yield
          var i=0; while (i<n) { f(data); i+=1 }
        }
      }
    }
  }

  // We're taking advantage of the fact that the only LF characters in
  // the data are chunk terminators.
  def wordCount(in: Array[Char]): Int = {

    // skip to the first chunk
    var pos = in.indexOf('\n') + 1

    // skip to the first non-space
    while (in(pos) == ' ') { pos += 1 }

    // count!
    var wc = 0
    var inWord = false
    var continue = true
    while (continue) {
      //println("'" + (if (in(pos) == '\n') "\\n" else in(pos).toString) + "'")
      in(pos) match {
        case ' ' => if (inWord) {
          //println("inWord => false")
          inWord = false
        }
        case '\n' => {
          pos = in.indexOf('\n', pos + 1)
          if (in(pos + 1) == '\n') continue = false
        }
        case c => if (!inWord) {
          //println("inWord => true")
          inWord = true
          wc += 1
        }
      }
      pos += 1
    }
    println("word count: " + wc)
    wc
  }

  // Instantiate the buffered parser
  val bufferedParser = new TestChunked

  // Instantiate the interleaved parser
  val interleavedParser = new TestInterleaved

  // Make some data
  val data = mkTestData(1 << 15)

  // == Sanity checks: do the parsers give the right result? ==
  val wc = wordCount(data)
  bufferedParser(data)
  println(s"buffered res: ${bufferedParser.res.res}")
  assert(bufferedParser.res.res == wc, s"${bufferedParser.res.res} != $wc")
  interleavedParser(data)
  println(s"interleaved res: ${interleavedParser.res.res}")
  assert(interleavedParser.res.res == wc, s"${interleavedParser.res.res} != $wc")

  // Run benchmarks
  bench("bufferedParser", "parse", bufferedParser)
  bench("interleavedParser", "parse", interleavedParser)
}
