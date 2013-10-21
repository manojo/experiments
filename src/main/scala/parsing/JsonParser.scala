package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

class JSON extends JavaTokenParsers {
  def value : Parser[Any] = obj | arr | stringLiteral |
            floatingPointNumber |
            "null" | "true" | "false"
  def obj : Parser[Any] = "{"~repsep(member, ",")~"}"
  def arr : Parser[Any] = "["~repsep(value, ",")~"]"
  def member: Parser[Any] = stringLiteral~":"~value

  def wNum : Parser[Int] = wholeNumber ^^ (_.toInt)
  def simpleRec: Parser[Int] = (wNum ~ simpleRec) ^^ {case x~y => x+y} | wNum
}

object JsonParser extends JSON{

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

  def main(args:Array[String]){
    println("Hello world!")
    val reader = new CharSequenceReader(addressbook, 0)
    println(parseAll(value, reader))

    val reader2 = new CharSequenceReader("12 13 14", 0)
    println(parseAll(simpleRec, reader2))
  }
}