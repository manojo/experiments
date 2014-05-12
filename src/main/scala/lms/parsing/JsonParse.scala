package lms.parsing

import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer

// To rebuild from sources, use:
// sbt ';test:run-main lms.parsing.TestJson;run-main lms.parsing.TestJsonParse'

// JQ 100 loops: 1.531 sec
//
// rep-> list.reverse : 6.5 -> 5.5
// unicode -> char    : 5.5 -> 5.2
// no string-dequote  : 3.6
// no string-content  : 0.9
// no dequote-StringStruct : 0.95

object TestJsonParse{
  val jsonparser = new JsonParse(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray
  )

  val jsonparser2 = new JsonParse2(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray
  )

  val jsonparser3 = new JsonParse3(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray
  )

  val fileNames = List(1/*,2,3,4,6*/).map{x=> "just_tweet"+x}

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

    val addressbook=
"""{
"address book": {
"name": "John Smith",
"address": {
"street": "10 Market Street",
"city" : "San Francisco, CA",
"zip" : 94111
},
"phone Nums": [
"408 338-4238",
"408 111-6892"
]
}
}
"""

  def time(ns:Long,n:Int=2) = { val ms=ns/1000000; ("%"+(if (n==0)"" else n)+"d.%03d").format(ms/1000,ms%1000) }
  def ns[T](f:()=>T) = { val t0=System.nanoTime(); var r=f(); val t1=System.nanoTime(); (t1-t0,r) }

  def main(args:Array[String]){
    val N_LOOPS = 1 // 100
    val N_SAMPLES = 1 // 5

    (0 until N_SAMPLES).foreach { k =>
      val n = ns{()=>
        var i=0;
        while(i < N_LOOPS) {
          // jsonparser.apply(addressbook.toArray)
          jsonparser2.apply(addressbook.toArray)

          println("")
          println("blabla")
          println("")

          jsonparser3.apply(addressbook.toArray)

          i=i+1;
        }
      }._1
      println("Time = "+time(n))
    }
  }
}
