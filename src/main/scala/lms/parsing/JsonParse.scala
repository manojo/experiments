package lms.parsing

import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer

// To rebuild from sources, use:
// sbt ';test:run-main lms.parsing.TestJson;run-main lms.parsing.TestJsonParse'

// rep-> list.reverse : 6.5 -> 5.5
// unicode -> char    : 5.5 -> 5.2
// no string-dequote  : 3.6
// no string-content  : 0.9

object TestJsonParse{
  val jsonparser = new JsonParse(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray //,
    //print = true
  )

  val fileNames = List(1,2,3,4,6).map{x=> "just_tweet"+x}

  val messages = fileNames.foldLeft(List[Array[Char]]()){case (acc, fileName) =>
    val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
    val out = new ArrayBuffer[Char]

    var line = file.readLine
    while(line != null){
      out ++= line + "\n"
      line = file.readLine
    }
    out.toArray :: acc
  }.map(_.toArray)

  def time(ns:Long,n:Int=2) = { val ms=ns/1000000; ("%"+(if (n==0)"" else n)+"d.%03d").format(ms/1000,ms%1000) }
  def ns[T](f:()=>T) = { val t0=System.nanoTime(); var r=f(); val t1=System.nanoTime(); (t1-t0,r) }

  def main(args:Array[String]){
    val N_LOOPS = 100 // 100
    val N_SAMPLES = 5 // 5

    (0 until N_SAMPLES).foreach { k =>
      val n = ns{()=>
        var i=0;
        while(i<N_LOOPS) {
          jsonparser.apply(messages(0))
          jsonparser.apply(messages(1))
          jsonparser.apply(messages(2))
          jsonparser.apply(messages(3))
          jsonparser.apply(messages(4))
          i=i+1;
        }
      }._1
      println("Time = "+time(n))
    }
  }
}
