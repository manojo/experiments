package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import parsing.HTTP
//import TestResponseBis.{a1,a2,a3,a4,a5,a6,a7,a8}
import done._
//import done.HttpParserLL.http_parser

//class HttpParseBenchmark extends PerformanceTest.Regression
class HttpParseBenchmarkBis extends PerformanceTest
  with HTTP with Serializable{

  /* configuration */
  def executor = SeparateJvmsExecutor(
    new Executor.Warmer.Default,
    Aggregator.min,
    new Measurer.Default)

  def reporter = new LoggingReporter
  def persistor = Persistor.None

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

  //val range = Gen.enumeration("size")(1000)
  val range = Gen.exponential("size")(1, 10, 10)
  //val messagesAndRanges = messages.cached
  //val messagesAndRanges: Gen[(List[Array[Char]], Int)] = messages.cached.flatMap{m => Gen.enumeration("size")((m,1),(m,10),(m,100),(m,1000), (m,10000))}


  performance of "HTTPParserCombinator" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1,
      //exec.maxWarmupRuns -> 2,
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          parseAll(response,m)
      }
    }
  }


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

//staged parser bis
  val stagedParserBis = new ResponseParseBis //(x1,x2,x3,x4,x5,x6,x7,x8)

  performance of "RespAndMessageParserBis" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 1000,
      //exec.maxWarmupRuns -> 1000
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          stagedParserBis.apply(m)
      }
    }
  }

  //staged parser static
    //val stagedParserStatic = new ResponseParseStatic(a1,a2,a3,a4,a5,a6,a7,a8)

    //performance of "RespAndMessageParserStatic" in {
    //  measure method "parse" config(
    //    //exec.minWarmupRuns -> 1000,
    //    //exec.maxWarmupRuns -> 1000
    //    //exec.benchRuns -> 15
    //    //exec.independentSamples -> 1
    //  ) in {
    //    using(range) in {j =>
    //      for(i <- 1 to j; m <- messages)
    //        stagedParserStatic.apply(m)
    //    }
    //  }
    //}

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