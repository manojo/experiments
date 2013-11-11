package parsing

import spray.json._
import DefaultJsonProtocol._
import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer

object SprayJsonParser {

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
  }

  def main(args:Array[String]){
    println("watchout!")
    println(spray.json.JsonParser(messages(0)))
  }

}