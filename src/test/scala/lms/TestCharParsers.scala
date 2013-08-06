package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait CharParsersProg extends CharParsers /*TokenParsers*/{

  //simple acceptIf filter
  def test1(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = acceptIf(in, x => x == unit('h')).apply(unit(0))
    parser{x: Rep[ParseResult[Char]] => s = x}
    println(s)
  }

  //accept function: generates the exact same code as test1
  def test2(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = accept(in, unit('h')).apply(unit(0))
    parser{x: Rep[ParseResult[Char]] => s = x}
    println(s)
  }

  //parsing a single letter
  def test3(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = letter(in).apply(unit(0))
    parser{x: Rep[ParseResult[Char]] => s = x}
    println(s)
  }

  //parsing a single digit
  def test4(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = digit(in).apply(unit(0))
    parser{x: Rep[ParseResult[Char]] => s = x}
    println(s)
  }

  //two letters
  def test5(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[(Char,Char)](unit(-1))
    val parser = (letter(in)~letter(in)).apply(unit(0))
    parser{x: Rep[ParseResult[(Char,Char)]] => s = x}
    println(s)
  }

  //ignoring left result
  def test6(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = (letter(in)~>letter(in)).apply(unit(0))
    parser{x: Rep[ParseResult[Char]] => s = x}
    println(s)
  }

  //ignoring right result
  def test7(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Char](unit(-1))
    val parser = (letter(in)<~letter(in)).apply(unit(0))
    parser{x: Rep[ParseResult[Char]] => s = x}
    println(s)
  }

  //digit to int
  def test8(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = Failure[Int](unit(-1))
    val parser = digitI(in).apply(unit(0))
    parser{x: Rep[ParseResult[Int]] => s = x}
    println(s)
  }
/*
  //or
  def test9(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit('a'), ParseResult(unit(false), unit(-1)))
    val parser = (letter(in) | digit(in)).apply(unit(0))
    parser{x: Rep[(Char, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //rep
  def test10(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit(""), ParseResult(unit(false), unit(-1)))
    val parser = (rep(letter(in)) ^^ {x: Rep[List[Char]] => x.mkString}).apply(unit(0))
    parser{x: Rep[(String, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //repFold
  def test11(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit(0), ParseResult(unit(false), unit(-1)))
    val digitP : Parser[Int] =  digit(in) ^^ {x: Rep[Char] => char_toint(x - unit('0'))}
    val parser = repFold(digitP)(unit(0), (x: Rep[Int], y :Rep[Int]) => x + y) .apply(unit(0))
    parser{x: Rep[(Int, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //cond
  def testCond(in: Rep[Array[Char]], n :Rep[Int]): Rep[Unit] = {
    var s = make_tuple2(unit('a'), ParseResult(unit(false), unit(-1)))
    val parser = condP(n < unit(3), accept(in, unit('b')), accept(in, unit('c'))).apply(unit(0))
    parser{x: Rep[(Char, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

  //bind
  def testBind(in: Rep[Array[Char]]): Rep[Unit] = {
    var s = make_tuple2(unit(""), ParseResult(unit(false), unit(-1)))
    val b = letter(in) >> { x: Rep[Char] =>
      condP(x == unit('a'),
        accept(in, unit('b')) ^^ { y: Rep[Char] => x+unit(", ")+y},
        accept(in, unit('d')) ^^ { y: Rep[Char] => x+unit(", ")+y}
      )
    }
    val parser = b.apply(unit(0))
    parser{x: Rep[(String, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }
 */
}

/*
trait CharStructParser extends TokenParsers {
  //a basic struct
  type Lettah = Record { val left: Char; val right: Char }
  def Lettah(l: Rep[Char], r: Rep[Char]): Rep[Lettah] = new Record {
    val left = l; val right = r
  }

  //a simple map
  def testLettah(in: Rep[Array[Char]], i: Rep[Int]): Rep[Unit] = {
    val l = Lettah(unit('a'), unit('a'))
    var s = make_tuple2(l, ParseResult(unit(false), unit(-1)))
    val parser = (letter(in)~letter(in) ^^ {x: Rep[(Char, Char)] =>
      Lettah(x._1, x._2)
    }).apply(unit(0))

    parser{x: Rep[(Lettah, ParseResult)] => s = x}
    println("Result: "+readVar(s)._1)
    println("("+readVar(s)._2.position+","+readVar(s)._2.success+")")
  }

}
*/

class TestCharParsers extends FileDiffSuite {

  val prefix = "test-out/"

  def testSimpleParsers = {
    withOutFile(prefix+"char-parser"){
       new CharParsersProg with MyScalaOpsPkgExp with GeneratorOpsExp
        with CharOpsExp with IfThenElseExpOpt with StructOpsExpOptCommon
        with ParseResultOpsExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
          with ScalaGenCharOps with ScalaGenParseResultOps with ScalaGenStructOps{
            val IR: self.type = self
        }

        codegen.emitSource(test1 _ , "test1", new java.io.PrintWriter(System.out))
        val testc1 = compile(test1)
        testc1("hello".toArray)

        codegen.emitSource(test2 _ , "test2", new java.io.PrintWriter(System.out))
        val testc2 = compile(test2)
        testc2("hello".toArray)
        testc2("1".toArray)

        codegen.emitSource(test3 _ , "test3", new java.io.PrintWriter(System.out))
        val testc3 = compile(test3)
        testc3("hello".toArray)
        testc2("1".toArray)

        codegen.emitSource(test4 _ , "test4", new java.io.PrintWriter(System.out))
        val testc4 = compile(test4)
        testc4("12".toArray)
        testc4("hello".toArray)

        codegen.emitSource(test5 _ , "test5", new java.io.PrintWriter(System.out))
        val testc5 = compile(test5)
        testc5("hello".toArray) //succeeding a ~ b
        testc5("1ello".toArray) //failing left
        testc5("h2llo".toArray) //failing right

        codegen.emitSource(test6 _ , "test6", new java.io.PrintWriter(System.out))
        val testc6 = compile(test6)
        testc6("hello".toArray)

        codegen.emitSource(test7 _ , "test7", new java.io.PrintWriter(System.out))
        val testc7 = compile(test7)
        testc7("hello".toArray)

        //digitI
        codegen.emitSource(test8 _ , "test8", new java.io.PrintWriter(System.out))
        val testc8 = compile(test8)
        testc8("1ello".toArray)
        testc8("hello".toArray)
/*
        codegen.emitSource(test9 _ , "test9", new java.io.PrintWriter(System.out))
        val testc9 = compile(test9)
        testc9("hello".toArray)
        testc9("12".toArray)

        codegen.emitSource(test10 _ , "test10", new java.io.PrintWriter(System.out))
        val testc10 = compile(test10)
        testc10("hello21".toArray)

        codegen.emitSource(test11 _ , "test11", new java.io.PrintWriter(System.out))
        val testc11 = compile(test11)
        testc11("12345".toArray)

        codegen.emitSource2(testCond _ , "testCond", new java.io.PrintWriter(System.out))
        val testcCond = compile2(testCond)
        testcCond("b".toArray, 2)
        testcCond("c".toArray, 6)

        codegen.emitSource(testBind _ , "testBind", new java.io.PrintWriter(System.out))
        val testcBind = compile(testBind)
        testcBind("ab".toArray)
        testcBind("cd".toArray)
*/
      }
/*
      new CharStructParser with MyScalaOpsPkgExp with GeneratorOpsExp
       with CharOpsExp with StructOpsExpOptCommon
       with IfThenElseExpOpt with MyScalaCompile{self =>

       val codegen = new MyScalaCodeGenPkg with ScalaGenGeneratorOps
         with ScalaGenCharOps with ScalaGenStructOps{ val IR: self.type = self }

       val printWriter = new java.io.PrintWriter(System.out)

       codegen.emitSource2(testLettah _, "testLettah", printWriter)
       codegen.emitDataStructures(printWriter)
       val source = new StringWriter
       codegen.emitDataStructures(new PrintWriter(source))
       val testcLettah = compile2s(testLettah, source)
       testcLettah("hello".toArray, 1)

      }
*/
    }

    assertFileEqualsCheck(prefix+"char-parser")
  }
}