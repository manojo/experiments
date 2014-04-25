package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

sealed abstract class JSValue
case class JSObject(map: Map[String, JSValue]) extends JSValue
case class JSArray(arr: Array[JSValue]) extends JSValue {
  override def equals(obj: Any) = obj match {
    case tmp: JSArray => arr.toSet == tmp.arr.toSet
    case _ => false
  }
}

//case class JSInt(i: Int) extends JSValue
case class JSDouble(d: Double) extends JSValue
case class JSString(s: String) extends JSValue
case class JSBool(b: Boolean) extends JSValue
case object JSNull extends JSValue

trait JSON extends JavaTokenParsers {

  def myStringLit: Parser[String] = stringLiteral ^^ { s => s.substring(1, s.length - 1) }

  def value: Parser[JSValue] = obj | arr | (myStringLit ^^ { s => JSString(s) } ) |
    floatingPointNumber ^^ { d => JSDouble(d.toDouble) } |
    "null" ^^^ JSNull | "true" ^^^ JSBool(true) | "false" ^^^ JSBool(false)

  def obj: Parser[JSValue] = "{" ~> repsep(member, ",") <~ "}" ^^ { xs =>
    val mp = xs.map { case str ~ v => (str, v) }.toMap
    JSObject(mp)
  }
  def arr: Parser[JSValue] = "[" ~> repsep(value, ",") <~ "]" ^^ { xs => JSArray(xs.toArray)}
  def member = myStringLit ~ (":" ~> value)

  def wNum: Parser[Int] = bla
  def bla: Parser[Int] = (wholeNumber ^^ (_.toInt)) | "[" ~> wNum <~ "]"
}


/**
 * Missing operators (that exist in jq)
 * - array construction
 * - object construction
 * - weak flatten
 */

trait JSONQueryEngine {

  implicit def toJSBool(b: Boolean) = JSBool(b)

  def ws(n: Int) = {

    var loc_n = n
    val str = new scala.collection.mutable.StringBuilder

    while(loc_n > 0) {
      str += ' '
      loc_n -= 1
    }

    str.toString
  }

  implicit class JsonQueryOps(jsValue: JSValue) {

    def apply(s:String): JSValue = jsValue match {
      case JSObject(map) if map contains s => map(s)
      case _ => JSNull
    }

    def apply(i:Int): JSValue = jsValue match {
      case JSArray(arr) if (i < arr.length) => arr(i)
      case _ => JSNull
    }

    /**
     * filter on the key of a JsonObject
     */
    def filter(p: String => Boolean): JSValue = jsValue match {
      case JSObject(map) => JSObject(map filterKeys p)
      case _ => JSObject(Map.empty)
    }

    /**
     * map works only on an array atm
     */
    def map(f: JSValue => JSValue): JSValue = jsValue match {
      case JSArray(arr) => JSArray(arr map f)
      case _ => JSNull
    }

    def length: Int = jsValue match {
      case JSNull => 0
      case JSBool(_) => ???
      case JSDouble(_) => ???
      case JSString(s) => s.length
      case JSArray(arr) => arr.length
      case JSObject(obj) => obj.size
    }

    def keys: JSArray = jsValue match {
      case JSObject(obj) => JSArray(obj.keys.map{ s => JSString(s) }.toArray)
      case JSArray(arr) => JSArray(arr.indices.toArray map {x => JSDouble(x)})
      case _ => ???
    }

    def has(s: String): Boolean = jsValue match {
      case JSObject(obj) => obj.contains(s)
      case _ => ???
    }

    def has(i: Int): Boolean = jsValue match {
      case JSArray(arr) => (i > 0) && (i < arr.length)
      case _ => ???
    }

  }

  def prettyString(js: JSValue, depth: Int = 0): String = {
    val innerString: String = js match {
      case JSNull => "null"
      case JSBool(b) => b.toString
      case JSDouble(d) => d.toString
      case JSString(s) => "\"" + s + "\""
      case JSArray(arr) =>
        val elems = arr.map { elem => ws(depth) + prettyString(elem, depth + 2) }
        val elemString = elems.mkString(
          ws(depth) + "[\n",
          ",\n",
          "\n" + ws(depth) + "]"
        )
        elemString

      case JSObject(obj) =>
        val members = obj.map { case (key, value) =>
          val valueString = prettyString(value, depth + 2)
          ws(depth) + "\"" + key + "\" : " + valueString
        }

        val memberString = members.mkString(
          ws(depth) + "{\n",
          ",\n",
          "\n" + ws(depth) + "}"
        )
        memberString
    }
    innerString
  }

}

object JsonParser extends JSON with JSONQueryEngine {

  def getValue(jsonString: String): JSValue = {
    parseAll(value, new CharSequenceReader(jsonString, 0)) match {
      case Success(res, _) => res
      case _ => JSObject(Map.empty)
    }
  }

  val addressbook =
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

  def main(args: Array[String]) {
    println("Hello world!")
    val reader = new CharSequenceReader(addressbook, 0)

    val aBook: JSValue = parseAll(value, reader) match {
      case Success(res, _) => res
      case _ => JSObject(Map.empty)
    }

    println(prettyString(aBook("address book")))
    println(prettyString(aBook("asdf")))

//    println(parseAll(value ^^ { v => prettyString(v) } , reader))

    val reader2 = new CharSequenceReader("[[22]]", 0)
    println(parseAll(value ^^ { v => prettyString(v) }, reader2))
  }
}