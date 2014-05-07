package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import spray.json._
import DefaultJsonProtocol._

//class JsonParseBenchmark extends PerformanceTest.Regression
class JsonParseBenchmark extends PerformanceTest
  with Serializable{

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
  val fileNames = /*(1 to 101)*/ List(1,2,3,4,6).map{x=> "just_tweet"+x}
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
    val range = Gen.enumeration("size")(10)
    //val range = Gen.exponential("size")(1, 10 /*1000*/, 10)
    val ms = messages.toArray
    val mn = messages.length
    performance of obj in {
      measure method meth config(
        exec.minWarmupRuns -> 5,
        exec.maxWarmupRuns -> 10,
        exec.benchRuns -> 25,
        exec.independentSamples -> 4
      ) in {
        using(range) /* .config(exec.jvmflags -> "-Xmx12G -Xms12G -Xss64m") */ in { n=>
          // we use while to remove overhead of for ... yield
          var i=0; while (i < n) { var m=0; while (m < mn) { f(ms(m)); m+=1 }; i+=1 }
        }
      }
    }
  }

  // staged
  val stagedJsonParser = new JsonParse(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray
  )

  // staged2
  val stagedJsonParser2 = new JsonParse2(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray
  )

  bench("StagedJsonParser","parse",stagedJsonParser.apply _)

  bench("StagedJsonParser2","parse",stagedJsonParser2.apply _)

  // spray json
  bench("SprayJsonParser","parse",spray.json.JsonParser.apply _)

  // scala parser combinators
  // bench("ScalaJsonParser","parse",...)

/*
  //val range = Gen.enumeration("size")(1)
  //val range = Gen.exponential("size")(1, 10000, 10)
  val range = Gen.exponential("size")(1, 100, 10)

  val stagedJsonParser = new JsonParse(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray
  )

  performance of "StagedJsonParser" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 500,
      //exec.maxWarmupRuns -> 500
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          stagedJsonParser.apply(m)
      }
    }
  }

//spray json

  performance of "SprayJsonParser" in {
    measure method "parse" config(
      //exec.minWarmupRuns -> 500,
      //exec.maxWarmupRuns -> 500
      //exec.benchRuns -> 15
      //exec.independentSamples -> 1
    ) in {
      using(range) in {j =>
        for(i <- 1 to j; m <- messages)
          spray.json.JsonParser(m)
      }
    }
  }

//scala parser combinators

//  performance of "ScalaJsonParser" in {
//    measure method "parse" config(
//      //exec.minWarmupRuns -> 500,
//      //exec.maxWarmupRuns -> 500
//      //exec.benchRuns -> 15
//      //exec.independentSamples -> 1
//    ) in {
//      using(range) in {j =>
//        for(i <- 1 to j; m <- messages)
//          spray.json.JsonParser(m)
//      }
//    }
//  }
*/
}