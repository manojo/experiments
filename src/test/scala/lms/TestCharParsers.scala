package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait CharParsersProg extends CharParsers{

  //simple acceptIf filter
  def test1(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = acceptIf(in, x => x == unit('h'))
    val res = parser(unit(0))
    println(res)
  }

  //accept function: generates the exact same code as test1
  def test2(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = accept(in, unit('h'))
    val res = parser(unit(0))
    println(res)
  }

  //parsing a single letter
  def test3(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = letter(in)
    val res = parser(unit(0))
    println(res)
  }

  //parsing a single digit
  def test4(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = digit(in)
    val res = parser(unit(0))
    println(res)
  }

  //two letters
  def test5(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (letter(in)~letter(in))
    val res = parser(unit(0))
    println(res)
  }

  //ignoring left result
  def test6(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (letter(in)~>letter(in))
    val res = parser(unit(0))
    println(res)
  }

  //ignoring right result
  def test7(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (letter(in)<~letter(in))
    val res = parser(unit(0))
    println(res)
  }

  //digit to int
  def test8(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = digit2Int(in)
    val res = parser(unit(0))
    println(res)
  }

  //or
  def test9(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (letter(in) | digit(in))
    val res = parser(unit(0))
    println(res)
  }

  //or2: testing that or creates functions
  def testOr2(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser =
      ((accept(in, unit('h'))~accept(in, unit('e'))) |
       (accept(in, unit('1'))~accept(in, unit('2'))))
    val res = parser(unit(0))
    println(res)
  }

  //or3: (a | b) ~ c
  def testOr3(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser =
      (((accept(in, unit('h'))~accept(in, unit('e'))) |
        (accept(in, unit('1'))~accept(in, unit('2')))
       ) ~ accept(in, unit('3'))
      )
    val res = parser(unit(0))
    println(res)
  }

  //rep
  def test10(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = (rep(letter(in)) ^^ {x: Rep[List[Char]] => x.mkString})
    val res = parser(unit(0))
    println(res)
  }

  //repFold
  def test11(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser =
      repFold(digit2Int(in))(unit(0), (x: Rep[Int], y :Rep[Int]) => x + y)
    val res = parser(unit(0))
    println(res)
  }

  //cond
  def testCond(in: Rep[Array[Char]], n :Rep[Int]): Rep[Unit] = {
    val parser: Parser[Char] =
      if(n < unit(3)) accept(in, unit('b'))
      else accept(in, unit('c'))
    val res = parser(unit(0))
    println(res)
  }


  //bind
  def testBind(in: Rep[Array[Char]]): Rep[Unit] = {
    val parser = letter(in) >> { x: Rep[Char] =>
      if(x == unit('a')) accept(in, unit('b')) ^^ { y: Rep[Char] => x+unit(", ")+y}
      else accept(in, unit('d')) ^^ { y: Rep[Char] => x+unit(", ")+y}
    }

    val res = parser(unit(0))
    println(res)
  }
}

class TestCharParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testSimpleParsers = {
    withOutFile(prefix+"char-parser"){
       new CharParsersProg with MyScalaOpsPkgExp with CharOpsExp
        with MyIfThenElseExpOpt with StructOpsFatExpOptCommon
        with ParseResultOpsExp with FunctionsExp with OptionOpsExp
        with StringStructOpsExp with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps
          with ScalaGenParseResultOps with ScalaGenFatStructOps
          with ScalaGenFunctions with ScalaGenOptionOps
          with ScalaGenStringStructOps with ScalaGenIfThenElseFat{
            val IR: self.type = self
        }

        codegen.emitSource(test1 _ , "test1", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc1 = compile(test1)
        testc1("hello".toArray)
        codegen.reset

        codegen.emitSource(test2 _ , "test2", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(test2)
        testc2("hello".toArray)
        testc2("1".toArray)
        codegen.reset

        codegen.emitSource(test3 _ , "test3", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc3 = compile(test3)
        testc3("hello".toArray)
        testc2("1".toArray)
        codegen.reset

        codegen.emitSource(test4 _ , "test4", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc4 = compile(test4)
        testc4("12".toArray)
        testc4("hello".toArray)
        codegen.reset

        codegen.emitSource(test5 _ , "test5", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc5 = compile(test5)
        testc5("hello".toArray) //succeeding a ~ b
        testc5("1ello".toArray) //failing left
        testc5("h2llo".toArray) //failing right
        codegen.reset

        codegen.emitSource(test6 _ , "test6", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc6 = compile(test6)
        testc6("hello".toArray)
        codegen.reset

        codegen.emitSource(test7 _ , "test7", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc7 = compile(test7)
        testc7("hello".toArray)
        codegen.reset

        //digit2Int
        codegen.emitSource(test8 _ , "test8", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc8 = compile(test8)
        testc8("1ello".toArray)
        testc8("hello".toArray)
        codegen.reset

        codegen.emitSource(test9 _ , "test9", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc9 = compile(test9)
        testc9("hello".toArray)
        testc9("12".toArray)
        testc9(":".toArray)
        codegen.reset

        codegen.emitSource(testOr2 _ , "testOr2", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcOr2 = compile(testOr2)
        testcOr2("hello".toArray)
        testcOr2("12".toArray)
        testcOr2(":".toArray) //fail case
        testcOr2("h1".toArray) //fail case
        testcOr2("1d".toArray) //fail case
        codegen.reset

        codegen.emitSource(test10 _ , "test10", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc10 = compile(test10)
        testc10("hello21".toArray)
        codegen.reset

        codegen.emitSource(test11 _ , "test11", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc11 = compile(test11)
        testc11("12345".toArray)
        testc11("asd".toArray)
        testc11("".toArray)
        codegen.reset

        val printWriter = new java.io.PrintWriter(System.out)
        codegen.emitSource2(testCond _, "testCond", printWriter)
        codegen.emitDataStructures(printWriter)
        codegen.reset

        val source = new StringWriter
        codegen.emitDataStructures(new PrintWriter(source))
        val testcCond = compile2s(testCond, source)
        testcCond("b".toArray, 2)
        testcCond("c".toArray, 6)
        codegen.reset

        codegen.emitSource(testBind _ , "testBind", new java.io.PrintWriter(System.out))
        codegen.reset

        val testcBind = compile(testBind)
        testcBind("ab".toArray) //successful
        testcBind("ac".toArray) //fail
        testcBind("cd".toArray) //successful
        testcBind("ca".toArray) //fail
        codegen.reset

      }
    assertFileEqualsCheck(prefix+"char-parser")
    }
  }

  def testOr{
    withOutFile(prefix+"or-parser"){
      new CharParsersProg with MyScalaOpsPkgExp with CharOpsExp
      with MyIfThenElseExpOpt with StructOpsFatExpOptCommon
      with ParseResultOpsExp with FunctionsExp with OptionOpsExp
      with StringStructOpsExp with MyScalaCompile { self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenCharOps
        with ScalaGenParseResultOps with ScalaGenFatStructOps
        with ScalaGenFunctions with ScalaGenStringStructOps
        with ScalaGenOptionOps with ScalaGenIfThenElseFat{
            val IR: self.type = self
        }

        codegen.emitSource(testOr2 _ , "testOr2", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcOr2 = compile(testOr2)
        testcOr2("hello".toArray)
        testcOr2("12".toArray)
        testcOr2(":".toArray) //fail case
        testcOr2("h1".toArray) //fail case
        testcOr2("1d".toArray) //fail case
        codegen.reset

        codegen.emitSource(testOr3 _ , "testOr3", new java.io.PrintWriter(System.out))
        codegen.emitDataStructures(new java.io.PrintWriter(System.out))
        codegen.reset

        val testcOr3 = compile(testOr3)
        testcOr3("he3lo".toArray)
        testcOr3("123".toArray)
        testcOr3(":".toArray) //fail case
        testcOr3("he1".toArray) //fail case
        testcOr3("12d".toArray) //fail case
        codegen.reset

      }
    }
    assertFileEqualsCheck(prefix+"or-parser")
  }
}
