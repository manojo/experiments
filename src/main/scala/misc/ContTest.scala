package misc

import scala.util.continuations._

object ContTest{

  def foo() = {
    println("Once here!")
    shift{ k: (Int => Int) =>
      k(k(k(7)))
    }
  }

  def bar() = 1 + foo()

  def baz() = reset{
    bar() * 2
  }

  //Interesting example
  val interesting = reset {
    shift { k: (Int=>Int) =>
      k(k(k(7))); "done"
    } + 1
  }

  //control flow reasoning: prints A, B, D, E, G, F, C
  val controlFlow = reset {
    println("A")
    shift { k1: (Unit=>Unit) =>
        println("B")
        k1()
        println("C")
    }
    println("D")
    shift { k2: (Unit=>Unit) =>
        println("E")
        k2()
        println("F")
    }
    println("G")
  }

  def pingpong = {

    var pingCount = 0
    var pingK: Unit => Unit = null
    var pongK: Unit => Unit = null

    //ping
    val ping = reset{
      shift{ k: (Unit => Unit) =>
        pingK = k
      }

      if(pingCount < 3){println("ping"); pongK()} else ()
    }

    val pong = reset{
      shift{ k: (Unit => Unit) =>
        pongK = k
      }
      println("pong")
      pingCount += 1
      pingK()
    }

    pingK()

  }

  def yieldlike = {

    def bla(i:Int, k: Int => Int): Int = {k(i+1)}

    var i = 0
    while(i <= 10){
      val newI = reset{
        shift{k: (Int => Int) => bla(i, k)}
      }
      println(newI)
      i = newI
    }

  }

  def main(args:Array[String]){
    println("hola!")

    val r1 = reset{
      10 + shift{k: (Int => Int) =>
        k(1 + 100)
      }
    }


    println(r1)
    println(baz())
    println(reset{1 + 100})

    reset {
      println(1)
      shift { (cont: Unit => Unit) => }
      println(2)
    }

    println("Interesting")
    println(interesting)

    pingpong
    yieldlike
  }
}