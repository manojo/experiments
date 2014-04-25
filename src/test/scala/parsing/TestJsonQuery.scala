package parsing

import scala.util.parsing.combinator._
import scala.util.parsing.input._

import org.scalatest._

//import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class TestJsonQuery extends FunSpec with JSON with JSONQueryEngine {

  def getValue(jsonString: String): JSValue = {
    parseAll(value, new CharSequenceReader(jsonString, 0)) match {
      case Success(res, _) => res
      case _ => JSObject(Map.empty)
    }
  }

/**
 * Most examples here are taken from jq's manual
 * http://stedolan.github.io/jq/manual/
 */


  it("key selection") {

    val obj1 = "{\"foo\": 42, \"bar\": \"less interesting data\"}"
    assert(getValue(obj1)("foo") == JSDouble(42))

    val obj2 =  "{\"notfoo\": true, \"alsonotfoo\": false}"
    assert(getValue(obj2)("foo") == JSNull)

    val obj3 = "{\"foo\": 42}"
    assert(getValue(obj3)("foo") == JSDouble(42))
  }

  it("array selection") {

    val arr1 = """|[
    | {"name":"JSON", "good":true},
    | {"name":"XML", "good":false}
    | ]""".stripMargin

    val res1 = """{"name":"JSON", "good":true}""".stripMargin

    assert(getValue(arr1)(0) == getValue(res1))
    assert(getValue(arr1)(2) == JSNull)
  }

  it("array mapping") {

    val arr1 = """|[
    | {"name":"JSON", "good":true},
    | {"name":"XML", "good":false}
    | ]""".stripMargin

    val res1 = """["JSON", "XML"]""".stripMargin

    val mapped: JSValue = getValue(arr1) map { x => x("name") }

    assert(mapped == getValue(res1))
  }

  it("length") {

    val arr1 = """[[1,2], "string", {"a":2}, null]"""

    val res1 = """[2,6,1,0]""".stripMargin

    val mapped: JSValue = getValue(arr1) map { x => JSDouble(x.length) }
    assert(mapped == getValue(res1))
  }

  it("has") {

    val arr1 = """  [{"foo": 42}, {}]"""
    val res1 = """[true, false]""".stripMargin

    val mapped: JSValue = getValue(arr1) map { x => x has "foo" }
    assert(mapped == getValue(res1))

    val arr2 = """[[0,1], ["a","b","c"]]"""
    val res2 = """[false, true]""".stripMargin

    val mapped2: JSValue = getValue(arr2) map { x => x has 2 }
    assert(mapped2 == getValue(res2))
  }
}