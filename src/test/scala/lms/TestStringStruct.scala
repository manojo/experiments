package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream


trait StringStructProg extends StringStructOps with MyScalaOpsPkg{

  //testit
  def test1(in: Rep[Array[Char]], in2: Rep[Array[Char]]): Rep[Boolean] = {
    val s :Rep[StringStruct] = String(in, unit(0), in.length)
    //println(s.length)
    //val ab: Rep[Array[Char]] = in
    //println(ab.length)
    s == in2
  }

  def test2(in: Rep[Array[Char]]): Rep[Boolean] = {
    val s :Rep[StringStruct] = String(in, unit(0), in.length)
    val ab: Rep[Array[Char]] = Array(unit('a'),unit('b'))
    s == ab
  }

  def test3(in: Rep[Array[Char]]): Rep[Boolean] = {
    val s :Rep[StringStruct] = String(in, unit(0), in.length)
    s == "hello"
  }
}

class TestStringStructOps extends FileDiffSuite {

  val prefix = "test-out/"

  def testOption = {
    withOutFile(prefix+"stringstruct"){
       new StringStructProg with StringStructOpsExp with MyScalaOpsPkgExp with MyScalaCompile{self =>

        val codegen = new MyScalaCodeGenPkg with ScalaGenStringStructOps{ val IR: self.type = self }

        codegen.emitSource2(test1 _ , "test1", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc1 = compile2(test1)
        scala.Console.println(testc1("hello".toArray, "asfd".toArray))
        scala.Console.println(testc1("hello".toArray, "hello".toArray))
        scala.Console.println(testc1("hello".toArray, "hella".toArray))
        codegen.reset

        codegen.emitSource(test2 _ , "test2", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc2 = compile(test2)
        scala.Console.println(testc2("hello".toArray))
        codegen.reset

        codegen.emitSource(test3 _ , "test3", new java.io.PrintWriter(System.out))
        codegen.reset

        val testc3 = compile(test3)
        scala.Console.println(testc3("hello".toArray))
        scala.Console.println(testc3("asdf".toArray))
        scala.Console.println(testc3("HELLO".toArray))
        codegen.reset

      }
    }

    assertFileEqualsCheck(prefix+"stringstruct")
  }
}