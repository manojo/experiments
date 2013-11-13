package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import parsing.HTTP
import done._

//class HttpParseBenchmark extends PerformanceTest.Regression
class HttpParseBenchmark extends PerformanceTest
  with HTTP with Serializable {

  /* configuration */
  def executor = SeparateJvmsExecutor(
    new Executor.Warmer.Default,
    Aggregator.min,
    new Measurer.Default)

  def reporter = new LoggingReporter
  def persistor = Persistor.None

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
  val fileNames = List(1,2,3,4,6).map{x=> "tweet"+x}
  val messages = fileNames.foldLeft(List[Array[Char]]()){case (acc, fileName) =>
    val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
    val out = new ArrayBuffer[Char]

    var line = file.readLine
    while(line != null){
      out ++= line + "\n"
      line = file.readLine
    }
    out.toArray :: acc
  }

  def bench(obj:String,meth:String,f:Array[Char]=>_) {
    val range = Gen.exponential("size")(1, 1000, 10)
    val ms = messages.toArray
    val mn = messages.length
    performance of obj in {
      measure method meth config(
        exec.minWarmupRuns -> 5,
        exec.maxWarmupRuns -> 10,
        exec.benchRuns -> 25,
        exec.independentSamples -> 4
      ) in {
        using(range) /*.config(exec.jvmflags -> "-Xmx12G -Xms12G -Xss64m")*/ in { n=>
          // we use while to remove overhead of for ... yield
          var i=0; while (i<n) { var m=0; while (m<mn) { f(ms(m)); m+=1 }; i+=1 }
        }
      }
    }
  }

  // Scala combinators, very slow
  //bench("HTTPParserCombinator","parse",(m:Array[Char])=>parseAll(response,m))

  // staged parser
  //val stagedParser = new ResponseParse
  //bench("RespAndMessageParser","parse",stagedParser.apply _)

  //staged parser static
  val stagedParserStatic = new ResponseParseStatic(
    "connection".toArray,
    "proxy-connection".toArray,
    "keep-alive".toArray,
    "close".toArray,
    "content-length".toArray,
    "transfer-encoding".toArray,
    "chunked".toArray,
    "upgrade".toArray
  )
  bench("RespAndMessageParserStatic","parse",stagedParserStatic.apply _)

  // hand written, folding
  val handWrittenParser = HandWrittenParserWrapper.getParser
  //bench("HTTPParserLL","parseFoldString",(m:Array[Char])=>HandWrittenParserWrapper.execute(handWrittenParser, new StringFoldingSettings, m, 0, m.length))

  // NGINX Java port
  bench("HTTPParserLL","parse",(m:Array[Char])=>HandWrittenParserWrapper.execute(handWrittenParser, new DefaultHttpSettings, m, 0, m.length))

/*
  //val range = Gen.enumeration("size")(100)
  val range = Gen.exponential("size")(1, 10000, 10)
  //val messagesAndRanges = messages.cached
  //val messagesAndRanges: Gen[(List[Array[Char]], Int)] = messages.cached.flatMap{m => Gen.enumeration("size")((m,1),(m,10),(m,100),(m,1000), (m,10000))}

  //performance of "HTTPParserCombinator" in {
  //  measure method "parse" config(
  //    //exec.minWarmupRuns -> 1,
  //    //exec.maxWarmupRuns -> 2,
  //    //exec.benchRuns -> 15
  //    //exec.independentSamples -> 1
  //  ) in {
  //    using(range) in {j =>
  //      for(i <- 1 to j; m <- messages)
  //        parseAll(response,m)
  //    }
  //  }
  //}

  val stagedParser = new ResponseParse

  performance of "RespAndMessageParser" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 500,
      //exec.maxWarmupRuns -> 500
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          stagedParser.apply(m)
      }
    }
  }

  //staged parser static
  val stagedParserStatic = new ResponseParseStatic(
    "connection".toArray,
    "proxy-connection".toArray,
    "keep-alive".toArray,
    "close".toArray,
    "content-length".toArray,
    "transfer-encoding".toArray,
    "chunked".toArray,
    "upgrade".toArray
  )

  performance of "RespAndMessageParserStatic" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 500,
      //exec.maxWarmupRuns -> 500
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range)/ *.config(exec.jvmflags -> "-XX:+PrintCompilation").* / in {j =>
        for(i <- 1 to j; m <- messages)
          stagedParserStatic.apply(m)
      }
    }
  }

//hand written, folding

  val handWrittenParser = HandWrittenParserWrapper.getParser

  performance of "HTTPParserLL" in {
    measure method "parseFoldString" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          HandWrittenParserWrapper.execute(handWrittenParser, new StringFoldingSettings, m, 0, m.length)
      }
    }
  }

  performance of "HTTPParserLL" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          HandWrittenParserWrapper.execute(handWrittenParser, new DefaultHttpSettings, m, 0, m.length)
      }
    }
  }
*/
}