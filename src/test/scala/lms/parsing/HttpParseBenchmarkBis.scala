package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import parsing.HTTP
import done._
//import done.HttpParserLL.http_parser

//class HttpParseBenchmark extends PerformanceTest.Regression
class HttpParseBenchmarkBis extends PerformanceTest.Quickbenchmark
  with HTTP with Serializable{

  /* configuration */
  //override def executor = SeparateJvmsExecutor(
  //  new Executor.Warmer.Default,
  //  Aggregator.min,
  //  new Measurer.Default)

  //override def reporter: Reporter = Reporter.Composite(
  //  new RegressionReporter(
  //    RegressionReporter.Tester.Accepter(),
  //    RegressionReporter.Historian.Complete()),
  //  HtmlReporter(true)
  //)
  //def persistor = new SerializationPersistor

  // multiple tests can be specified here
  val fileNames = List(1,2,3,4,6).map{x=> "tweet"+x}.take(1)
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

  val range = Gen.enumeration("size")(1)
  //val range = Gen.exponential("size")(1, 10000, 10)
  //val messagesAndRanges = messages.cached
  //val messagesAndRanges: Gen[(List[Array[Char]], Int)] = messages.cached.flatMap{m => Gen.enumeration("size")((m,1),(m,10),(m,100),(m,1000), (m,10000))}


  //performance of "HTTPParserCombinator" in {
  //  measure method "parse" config(
  //    //exec.minWarmupRuns -> 1,
  //    //exec.maxWarmupRuns -> 2,
  //    //exec.benchRuns -> 15
  //    //exec.independentSamples -> 1
  //  ) in {
  //    using(messages.cached) in {m =>
  //      parseAll(respAndMessage, m)
  //    }
  //  }
  //}


  val stagedParser = new ResponseParse

  performance of "RespAndMessageParser" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          stagedParser.apply(m)
      }
    }
  }

//staged parser bis
  val stagedParserBis = new ResponseParseBis

  performance of "RespAndMessageParserBis" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          stagedParserBis.apply(m)
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
}