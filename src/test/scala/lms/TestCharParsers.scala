package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait CharParsersProg extends TokenParsers{

  //simple acceptIf filter
  def test1(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = acceptIf(in, x => x == unit('h')).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //accept function: generates the exact same code as test1
  def test2(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = accept(in, unit('h')).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //parsing a single lowercase letter
  def test3(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = letter(in).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //parsing a single digit
  def test4(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = digit(in).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //two letters
  def test5(in: Rep[Array[Char]]): Rep[((Char, Char),Int)] = {
    var s = make_tuple2(make_tuple2(unit('a'), unit('a')), unit(-1))
    val parser = (letter(in)~letter(in)).apply(unit(0))
    parser{x: Rep[((Char, Char), Int)] => s = x}
    s
  }

  //ignoring left result
  def test6(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = (letter(in)~>letter(in)).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //ignoring right result
  def test7(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = (letter(in)<~letter(in)).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //or
  def test9(in: Rep[Array[Char]]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = (letter(in) | digit(in)).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //rep
  def test10(in: Rep[Array[Char]]): Rep[(String,Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val parser = (rep(letter(in)) ^^ {x: Rep[List[Char]] => x.mkString}).apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }

  //repFold
  def test11(in: Rep[Array[Char]]): Rep[(Int,Int)] = {
    var s = make_tuple2(unit(0), unit(-1))
    val digitP : Parser[Int] =  digit(in) ^^ {x: Rep[Char] => char_toint(x - unit('0'))}
    val parser = repFold(digitP)(unit(0), (x: Rep[Int], y :Rep[Int]) => x + y) .apply(unit(0))
    parser{x: Rep[(Int, Int)] => s = x}
    s
  }

  //cond
  def testCond(in: Rep[Array[Char]], n :Rep[Int]): Rep[(Char,Int)] = {
    var s = make_tuple2(unit('a'), unit(-1))
    val parser = condP(n < unit(3), accept(in, unit('b')), accept(in, unit('c'))).apply(unit(0))
    parser{x: Rep[(Char, Int)] => s = x}
    s
  }

  //bind
  def testBind(in: Rep[Array[Char]]): Rep[(String,Int)] = {
    var s = make_tuple2(unit(""), unit(-1))
    val b = letter(in) >> { x: Rep[Char] =>
      condP(x == unit('a'),
        accept(in, unit('b')) ^^ { y: Rep[Char] => x+unit(", ")+y},
        accept(in, unit('d')) ^^ { y: Rep[Char] => x+unit(", ")+y}
      )
    }
    val parser = b.apply(unit(0))
    parser{x: Rep[(String, Int)] => s = x}
    s
  }
}


trait CharStructParser extends TokenParsers with Structs {
  //a basic struct
  type Lettah = Record { val left: Char; val right: Char }
  def Lettah(l: Rep[Char], r: Rep[Char]): Rep[Lettah] = new Record {
    val left = l; val right = r
  }

  //a simple map
  def testLettah(in: Rep[Array[Char]], i: Rep[Int]): Rep[(Lettah,Int)] = {
    val l = Lettah(unit('a'), unit('a'))
    var s = make_tuple2(l, unit(-1))
    val parser = (letter(in)~letter(in) ^^ {x: Rep[(Char, Char)] =>
      Lettah(x._1, x._2)
    }).apply(unit(0))

    parser{x: Rep[(Lettah, Int)] => s = x}
    s
  }
}

class TestCharParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testSimpleParsers = {
    withOutFile(prefix+"char-parser"){
       new CharParsersProg with ScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with MyScalaCompile{self =>

        val codegen = new ScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps{ val IR: self.type = self }

        codegen.emitSource(test1 _ , "test1", new java.io.PrintWriter(System.out))
        val testc1 = compile(test1)
        val res1 = testc1("hello".toArray)
        scala.Console.println(res1)

        codegen.emitSource(test2 _ , "test2", new java.io.PrintWriter(System.out))
        val testc2 = compile(test2)
        val res2 = testc2("hello".toArray)
        scala.Console.println(res2)

        codegen.emitSource(test3 _ , "test3", new java.io.PrintWriter(System.out))
        val testc3 = compile(test3)
        val res3 = testc3("hello".toArray)
        scala.Console.println(res3)

        codegen.emitSource(test4 _ , "test4", new java.io.PrintWriter(System.out))
        val testc4 = compile(test4)
        scala.Console.println(testc4("hello".toArray))
        scala.Console.println(testc4("12".toArray))

        codegen.emitSource(test5 _ , "test5", new java.io.PrintWriter(System.out))
        val testc5 = compile(test5)
        scala.Console.println(testc5("hello".toArray)) //succeeding a ~ b
        scala.Console.println(testc5("1ello".toArray)) //failing left
        scala.Console.println(testc5("h2llo".toArray)) //failing right

        codegen.emitSource(test6 _ , "test6", new java.io.PrintWriter(System.out))
        val testc6 = compile(test6)
        val res6 = testc6("hello".toArray)
        scala.Console.println(res6)

        codegen.emitSource(test7 _ , "test7", new java.io.PrintWriter(System.out))
        val testc7 = compile(test7)
        val res7 = testc7("hello".toArray)
        scala.Console.println(res7)

        codegen.emitSource(test9 _ , "test9", new java.io.PrintWriter(System.out))
        val testc9 = compile(test9)
        scala.Console.println(testc9("hello".toArray))
        scala.Console.println(testc9("12".toArray))

        codegen.emitSource(test10 _ , "test10", new java.io.PrintWriter(System.out))
        val testc10 = compile(test10)
        scala.Console.println(testc10("hello21".toArray))

        codegen.emitSource(test11 _ , "test11", new java.io.PrintWriter(System.out))
        val testc11 = compile(test11)
        scala.Console.println(testc11("12345".toArray))

        codegen.emitSource2(testCond _ , "testCond", new java.io.PrintWriter(System.out))
        val testcCond = compile2(testCond)
        scala.Console.println(testcCond("b".toArray, 2))
        scala.Console.println(testcCond("c".toArray, 6))

        codegen.emitSource(testBind _ , "testBind", new java.io.PrintWriter(System.out))
        val testcBind = compile(testBind)
        scala.Console.println(testcBind("ab".toArray))
        scala.Console.println(testcBind("cd".toArray))

      }

      new CharStructParser with ScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with StructExpOptCommon with MyScalaCompile{self =>

       val codegen = new ScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenStruct{ val IR: self.type = self }

       val printWriter = new java.io.PrintWriter(System.out)

       codegen.emitSource2(testLettah _, "testLettah", printWriter)
       codegen.emitDataStructures(printWriter)
       val source = new StringWriter
       codegen.emitDataStructures(new PrintWriter(source))
       val testcLettah = compile2s(testLettah, source)
       scala.Console.println(testcLettah("hello".toArray, 1))

      }

    }

    assertFileEqualsCheck(prefix+"char-parser")
  }
}