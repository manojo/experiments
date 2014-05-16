package lms.parsing

import org.scalameter.api._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer
import spray.json._
import DefaultJsonProtocol._

class CSVParseBenchmark extends PerformanceTest
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
    //  new RegressionReporter(
    //    RegressionReporter.Tester.Accepter(),
    //    RegressionReporter.Historian.Complete()),
    //  HtmlReporter(true)
    //)
  /******* Stop uncommenting *****/
    //def persistor = new SerializationPersistor

  // multiple tests can be specified here
  val fileNames = List("csvDoubles.txt")
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
    val range = Gen.enumeration("size")(1)
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

  bench("CSVDoublesParser","parse",(new CSVDoubleParseGen).apply _)

  bench("CSVDoublesParser2","parse",(new CSVDoubleParseGen2).apply _)

}