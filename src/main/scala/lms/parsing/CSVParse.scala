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

object CSVParse {


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
  }.map(_.toArray)

  val fileNames2 = List("csvBooleans.txt")

  val messages2 = fileNames2.foldLeft(List[Array[Char]]()){case (acc, fileName) =>
    val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
    val out = new ArrayBuffer[Char]

    var line = file.readLine
    while(line != null){
      out ++= line + "\n"
      line = file.readLine
    }
    out.toArray :: acc
  }.map(_.toArray)

  val fileNames3 = List("csvStringLits.txt")

  val messages3 = fileNames3.foldLeft(List[Array[Char]]()){case (acc, fileName) =>
    val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
    val out = new ArrayBuffer[Char]

    var line = file.readLine
    while(line != null){
      out ++= line + "\n"
      line = file.readLine
    }
    out.toArray :: acc
  }.map(_.toArray)

  def main(args : Array[String]){
    //(new CSVDoubleParseGen).apply(messages(0))
    //(new CSVDoubleParseGen2).apply(messages(0))

    //val boolParser = CSVBooleanParseGen(
    //  "false".length,
    //  "false".toArray,
    //  "true".length,
    //  "true".toArray,
    //  "false".toArray,
    //  "true".toArray
    //)

    //boolParser.apply(messages2(0))
    println((new CSVStringLitParseGen).apply(messages3(0)))
  }
}