package benchmark

import lms._
import lms.parsing._
import lms.parsing.gen._

import org.scalameter.api._
import java.io.{ BufferedReader, FileReader, Serializable }
import scala.collection.mutable.ArrayBuffer
import spray.json._
import DefaultJsonProtocol._

//class JsonParseBenchmark extends PerformanceTest.Regression
class JsonParseBenchmark extends PerformanceTest
    with Serializable {

  /* configuration */
  def executor = SeparateJvmsExecutor(
    new Executor.Warmer.Default,
    Aggregator.min,
    new Measurer.Default)

  def reporter = new LoggingReporter
  def persistor = Persistor.None

  /******* Uncomment below for using regression testing ****/
  //override def reporter: Reporter = Reporter.Composite(
  // new RegressionReporter(
  // RegressionReporter.Tester.Accepter(),
  // RegressionReporter.Historian.Complete()),
  // HtmlReporter(true)
  //)
  /******* Stop uncommenting *****/
  //def persistor = new SerializationPersistor

  // multiple tests can be specified here
  val fileNames = List(1, 2, 3, 4, 6).map { x => "just_tweet" + x }
  val messages = fileNames.foldLeft(List[Array[Char]]()) {
    case (acc, fileName) =>
      val file = new BufferedReader(new FileReader("src/test/resources/" + fileName))
      val out = new ArrayBuffer[Char]

      var line = file.readLine
      while (line != null) {
        out ++= line + "\n"
        line = file.readLine
      }
      out.toArray :: acc
  }

  val range = Gen.enumeration("size")(100)
  //val range = Gen.exponential("size")(1, 10000, 10)

  val stagedJsonParser = new JsonParse(
    "false".length, "false".toArray,
    "true".length, "true".toArray,
    "null".toArray //,
  //print = false
  )

  performance of "StagedJsonParser" in {
    measure method "parse" config ( //exec.minWarmupRuns -> 500,
    //exec.maxWarmupRuns -> 500
    //exec.benchRuns -> 15
    //exec.independentSamples -> 1
    ) in {
      using(range) in { j =>
        for (i <- 1 to j; m <- messages)
          stagedJsonParser.apply(m)
      }
    }
  }

  //parser simple
  val stagedJsonParserSimple = new JsonParse(
    "false".length, "false".toArray,
    "true".length, "true".toArray,
    "null".toArray //,
  //print = false
  )

  performance of "StagedJsonParser" in {
    measure method "parse" config ( //exec.minWarmupRuns -> 500,
    //exec.maxWarmupRuns -> 500
    //exec.benchRuns -> 15
    //exec.independentSamples -> 1
    ) in {
      using(range) in { j =>
        for (i <- 1 to j; m <- messages)
          stagedJsonParserSimple.apply(m)
      }
    }
  }

  //spray json

  //performance of "SprayJsonParser" in {
  //  measure method "parse" config(
  //    //exec.minWarmupRuns -> 500,
  //    //exec.maxWarmupRuns -> 500
  //    //exec.benchRuns -> 15
  //    //exec.independentSamples -> 1
  //  ) in {
  //    using(range) in {j =>
  //      for(i <- 1 to j; m <- messages)
  //        spray.json.JsonParser(m)
  //    }
  //  }
  //}

  //scala parser combinators

  // performance of "ScalaJsonParser" in {
  // measure method "parse" config(
  // //exec.minWarmupRuns -> 500,
  // //exec.maxWarmupRuns -> 500
  // //exec.benchRuns -> 15
  // //exec.independentSamples -> 1
  // ) in {
  // using(range) in {j =>
  // for(i <- 1 to j; m <- messages)
  // spray.json.JsonParser(m)
  // }
  // }
  // }
}