package lms

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.Effects

import java.io.PrintWriter
import java.io.StringWriter
import java.io.FileOutputStream

trait RecParsersProg extends TokenParsers with Functions {

  class LambdaOps[A:Manifest,B:Manifest](f: Rep[A=>B]) {
    def apply(x:Rep[A]): Rep[B] = doApply(f, x)
  }

  //def expr: Parser[String] = term ~ rep("+" ~ term | "-" ~ term)
/*
  def ~ [U:Manifest](that: => Parser[U]) = Parser[(T,U)]{ pos =>
    self(pos).flatMap{ x: Rep[(T,Int)] =>
      that(x._2).map{ y: Rep[(U,Int)] =>
        make_tuple2((x._1, y._1), y._2)
      }
    }
  }
*/
/*  term(in) = digit(in) ~ opt(term(in))

  digit(in)(i).flatMap{ x: Rep[(Char, Int)] =>
    term(in)(x._2).map{ y:Rep[(String,Int)] =>
      if(y._2 == x._2) {()} else {
        (unit(x._1)+y._1 , y._2)
      }
    }
  }

  {
    self(pos).flatMap{ x: Rep[(T,Int)] =>
      that(x._2).map{ y: Rep[(U,Int)] =>
        make_tuple2((x._1, y._1), y._2)
      }
    }

    digit(in)
  }

  expr = term ~ rep("+" ~ term | "-" ~ term)
  term = factor ~ rep(" * " ~ factor | "/" ~ factor)
  factor = floatingPointNumber | "(" ~ expr ~ ")"

  def expr(in: Rep[Input]): Parser[String] = Parser{ i: Rep[Int] =>
    new Generator[(String,Int)]{

    }

  }

*/

/*  def rec(p: Parser[T]) = Parser{ i:Rep[Int] =>
    new Generator[(T,Int)]{
      def apply(f: Rep[(T,Int)] => Rep[Unit]) = {
        lazy val termg: Rep[((T,Int))=>Unit] = doLambda{ t: Rep =>
          digit(in)(t._2).apply{ x: Rep[(Char,Int)] =>
            val param = make_tuple2(t._1 + (unit("")+x._1), x._2 )
            f(param)
            termg(param)
        }
      }
    }
  }}

  def term(in: Rep[Input]): Parser[String] = Parser{ i: Rep[Int] =>
    new Generator[(String, Int)]{
      def apply(f: Rep[(String,Int)] => Rep[Unit]) = {
        lazy val termg: Rep[((String,Int))=>Unit] = doLambda{ t: Rep[(String,Int)] =>
          digit(in)(t._2).apply{ x: Rep[(Char,Int)] =>
            val param = make_tuple2(t._1 + (unit("")+x._1), x._2 )
            f(param)
            termg(param)
          }
//          val param = make_tuple2( (unit("")+x._1)+t._1, x._2 )
        }
        termg(make_tuple2(unit(""), i))
      }
    }
  }

  def testTerm(in:Rep[Input]) = {
    var s = make_tuple2(unit(""), unit(-1))
    term(in).apply(unit(0)).apply{x : Rep[(String, Int)] => s =x }
    s
  }
  */
}


/*  def testRec = {
    withOutFile(prefix+"gen-topdown-rec") {
      new GenRecParsersProg with FunctionsExternalDef
       with GeneratorOpsExp with PackageExp with MyScalaCompile {self =>

        val codegen = new ScalaGenPackage with ScalaGenGeneratorOps
         with ScalaGenFunctionsExternal {
          val IR: self.type = self
        }

        codegen.emitSource(testTerm, "LiftTerm", new java.io.PrintWriter(System.out))
        val testc2 = compile(testTerm)
        scala.Console.println(testc2("23".toArray))
        //val testc1 = compile(f)
        //scala.Console.println(testc1("\"hello\" \"carol\"".toArray))


      }
    }
    assertFileEqualsCheck(prefix+"gen-topdown-rec")

  }
*/