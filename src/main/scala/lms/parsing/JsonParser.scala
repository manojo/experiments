package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait JsonParser extends TokenParsers with RecParsers with StringStructOps with CastingOpsExp /*with FunctionsRecursiveExp*/ {
  final val kNull = unit(0)
  final val kFalse = unit(1)
  final val kTrue = unit(2)
  final val kInt = unit(3)
  final val kDouble = unit(4)
  final val kString = unit(5)
  final val kArray = unit(6)
  final val kObject = unit(7)

  type JV = Record { val kind:Int; val data:Any }
  def JV(k:Rep[Int], d:Rep[Any]) = new Record {
    val kind = k
    val data = d // pointer | long | double, maps alternate key/value
  }

  /*
  // Desired function
  def infix_mkString(jv: Rep[JV]) = jStr(jv)
  def jStr:Rep[JV=>String] = doLambda{ (jv: Rep[JV]) =>
    if (jv.kind==kNull) unit("null")
    else if (jv.kind==kFalse) unit("false")
    else if (jv.kind==kTrue) unit("true")
    else if (jv.kind==kInt) unit("")+jv.data
    else if (jv.kind==kDouble) unit("")+jv.data
    else if (jv.kind==kString) unit("\"")+jv.data+unit("\"")
    else if (jv.kind==kArray) unit("[")+jv.data.AsInstanceOf[List[JV]].map(x=>jStr(x)).mkString(unit(","))+unit("]")
    else if (jv.kind==kObject) unit("{")+jv.data.AsInstanceOf[List[(String,JV)]].map(x=>unit("\"")+x._1+unit("\":")+x._2).mkString(unit(","))+unit("}")
    else unit("<bad kind: ")+jv.kind+unit(">")
  }
  */

  //def rec_mks:Rep[JV=>String] = doLambda((jv: Rep[JV]) =>infix_mkString(jv))
  def infix_mkString(jv: Rep[JV]) : Rep[String] = {
    if (jv.kind==kNull) unit("null")
    else if (jv.kind==kFalse) unit("false")
    else if (jv.kind==kTrue) unit("true")
    else if (jv.kind==kInt) unit("")+jv.data
    else if (jv.kind==kDouble) unit("")+jv.data
    else if (jv.kind==kString) unit("\"")+jv.data+unit("\"")
    else if (jv.kind==kArray) unit("[")+jv.data.AsInstanceOf[List[JV]] /*.map(rec_mks)*/ .mkString(unit(","))+unit("]")
    else if (jv.kind==kObject) unit("{")+jv.data.AsInstanceOf[List[(String,JV)]].map(x=>unit("\"")+x._1+unit("\":")+x._2).mkString(unit(","))+unit("}")
    else unit("<bad kind: ")+jv.kind+unit(">")
  }

  def jFalse = JV(kFalse,unit(null))
  def jTrue = JV(kTrue,unit(null))
  def jNull = JV(kNull,unit(null))
  def jInt(n:Rep[Int]) = JV(kInt,n)
  def jDouble(n:Rep[Double]) = JV(kDouble,n)
  def jString(s:Rep[String]) = JV(kString,s)
  def jArray(a:Rep[List[JV]]) = JV(kArray,a)
  def jObject(a:Rep[List[(String,JV)]]) = JV(kObject,a)

  //local whitespaces
  override def whitespaces(in: Rep[Input]) : Parser[String] =
    repToS_f(acceptIf(in, {x:Rep[Char] => x == unit(' ') || x == unit('\n')}))// ^^^ {unit("")}

  def json2(in:Rep[Input]): Parser[JV] = rec("json2",
    (accept(in,"false") ^^^ jFalse
  | accept(in,"true") ^^^ jTrue
  | accept(in,"null") ^^^ jNull
  | doubleLit(in) ^^ { s => jDouble(s) }
  | intLit(in) ^^ { s => jInt(s) }
  | stringLit(in) ^^ { s => jString(s) }
  | chr(in,'[') ~> repsep(json2(in), chr(in,',')) <~ chr(in,']') ^^  { a=>jArray(a) }
  | chr(in,'{') ~> repsep((stringLit(in) <~ chr(in,':')) ~ json2(in) ^^ {x=> jNull }, chr(in,',')) <~ chr(in,'}') ^^ { l=> jNull /*jObject(l)*/ } // XXX: fix this
  ))

  // true | false | null | doubleLit | intLit | stringLit
  def primitives(in: Rep[Input]): Parser[JV] = (
      acceptB(in,"false") ^^^ jFalse
    | acceptB(in,"true") ^^^ jTrue
    | acceptB(in,"null") ^^^ jNull
    | doubleLit(in) ^^ { s => jDouble(s) }
    | intLit(in) ^^ { s => jInt(s) }
  )


  def json(in: Rep[Input]): Parser[Any] = {
  /*
    def value = ( //wholeNumber(in) ^^ { x=>valInt(x) }
              //|
              accept(in,"null") ^^^ valNull
              //|  accept(in,"false") ^^^ valFalse
              //|  accept(in,"true") ^^^ valTrue
              )
  */
    //def value = rec("json",
    //  obj | arr | stringLit(in) | wholeNumber(in) //|
    //  //"null", "true", "false"
    //)

    //def arr: Parser[List[Any]] =
    //  (accept(in,unit('[')) ~> whitespaces(in)) ~>
    //  repsep(value, accept(in, unit(',')) ~> whitespaces(in)) <~
    //  (accept(in, unit(']')) ~> whitespaces(in))

    //def obj: Parser[List[Any]] =
    //  (accept(in,unit('{')) ~> whitespaces(in)) ~>
    //  repsep(member, accept(in, unit(',')) ~> whitespaces(in)) <~
    //  (accept(in, unit('}')) ~> whitespaces(in))

    def member: Parser[Any] =
      (stringLit(in) <~
      (whitespaces(in) <~ accept(in, unit(':')) ~ whitespaces(in))) ~
      stringLit(in)

    member//value
  }

  override def stringLit(in:Rep[Input]): Parser[String] =
    accept(in, unit('\"')) ~>
    repToS(acceptIf(in, (x:Rep[Char]) => x != unit('\"'))) <~
    accept(in, unit('\"'))
}



object TestJson {
  def main(args:Array[String]) {
    new JsonParser with RecParsersExp with MyScalaOpsPkgExp with GeneratorOpsExp
     with CharOpsExp with MyIfThenElseExpOpt with StructOpsExpOptCommon
     with ParseResultOpsExp with FunctionsExp with OptionOpsExp with StringStructOpsExp
     with MyScalaCompile{self =>
      val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
        with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps
        with ScalaGenFunctions with ScalaGenOptionOps with ScalaGenStringStructOps {
        val IR: self.type = self
      }

      // JSON parser prog

      /*
      def jsonParse(in: Rep[Array[Char]]): Rep[Unit] = {
        var s = Failure[(String,String)](unit(-1))
        val p = json(in).apply(unit(0))
        p{x => s = x}
        println(s)
      }
      */

      def jsonParse(in: Rep[Array[Char]]): Rep[Unit] = {
        var s = Failure[JV](unit(0))
        val parser = (json2(in)).apply(unit(0))
        parser{x => s = x}
        val r = readVar(s)
        println(unit("Empty=")+r.isEmpty+unit(", next=")+r.next)
        if (!r.isEmpty) println(r.get.mkString)
      }

      codegen.emitSource(jsonParse _ , "jsonParse", new java.io.PrintWriter(System.out))
      codegen.emitDataStructures(new java.io.PrintWriter(System.out))
      codegen.reset

      val testcJsonParse = compile(jsonParse)
       //false,true,null,123,1.23,
      testcJsonParse("[null,false,true,\"hello\",123,1.23,[],[[],[]]]".toArray)
      testcJsonParse("{\"foo\":true,\"bar\":false}".toArray)

/*
      codegen.emitSource(jsonParse _ , "jsonParse", new java.io.PrintWriter(System.out))
      val testcJsonParse = compile(jsonParse)
      testcJsonParse("{}".toArray)
      testcJsonParse("{\"asdf\" : \"asd\"}".toArray)
*/
    }
  }
}
