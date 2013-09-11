package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import parsing.HTTP
import done._
//import done.HttpParserLL.http_parser

class HttpParseBenchmark extends PerformanceTest.Regression
  with HTTP with Serializable{

  /* configuration */
  //def executor = SeparateJvmsExecutor(
  //  new Executor.Warmer.Default,
  //  Aggregator.min,
  //  new Measurer.Default)
  override def reporter: Reporter = Reporter.Composite(
    new RegressionReporter(
      RegressionReporter.Tester.Accepter(),
      RegressionReporter.Historian.Complete()),
    HtmlReporter(true)
  )
  def persistor = new SerializationPersistor

  // multiple tests can be specified here
  val files: Gen[Int] = Gen.range("file")(1,1,1)
  val fileNames = files.map{x=> "tweet"+x}
  val messages: Gen[Array[Char]] = fileNames.map{fileName =>
    val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
    val out = new ArrayBuffer[Char]

    var line = file.readLine
    while(line != null){
      out ++= line + "\n"
      line = file.readLine
    }
    out.toArray
  }


  performance of "HTTPParserCombinator" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(messages.cached) in {m =>
        parseAll(respAndMessage, m)
      }
    }
  }


  val stagedParser = new ResponseParse

  performance of "RespAndMessageParser" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(messages.cached) in {m =>
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
      using(messages.cached) in {m =>
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
      using(messages.cached) in {m =>
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
      using(messages.cached) in {m =>
        HandWrittenParserWrapper.execute(handWrittenParser, new DefaultHttpSettings, m, 0, m.length)
      }
    }
  }

}