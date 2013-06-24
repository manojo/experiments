package iteratees

/**
 * An implementation of iteratees as explained by John Lato in
 * "Iteratee: teaching an old fold new tricks".
 * More advanced scala implementations include:
 * - Scalaz's implementation: http://apocalisp.wordpress.com/2010/10/17/scalaz-tutorial-enumeration-based-io-with-iteratees/
 * - Play's implmentation: http://www.playframework.com/documentation/2.0.2/Iteratees
 */

trait Iteratees {
  abstract class Stream[+T]
  case object Empty extends Stream[Nothing]
  case object EOF extends Stream[Nothing]
  case class El[T](el: T) extends Stream[T]

  abstract class IterV[T,A] { self =>
    def enum(ls: List[T]): IterV[T,A] = ls match {
      case Nil => self
      case x::xs => self match {
        case Done(_, _) => self
        case Cont(f) => f(El(x)).enum(xs)
      }
    }

    def run: Option[A] = self match {
      case Done(a, _) => Some(a)
      case Cont(f) =>
        def run2(it2 : IterV[T,A]) = it2 match {
          case Done(a, _) => Some(a)
          case _ => None
        }
        run2(f(EOF))
    }

    def map[B](f: A => B): IterV[T,B] = self match {
      case Done(a, s) => Done(f(a), s)
      case Cont(g) => Cont({ s: Stream[T] => g(s) map f })
    }

    def flatMap[B](f: A => IterV[T, B]): IterV[T,B] = self match {
      case Done(a, s) => f(a) match {
        case Done(b, _) => Done(b,s)
        case Cont(g) => Cont(g)
      }
      case Cont(g) => Cont({s: Stream[T] => g(s) flatMap f})
    }

  }

  case class Done[T,A](a: A, s: Stream[T]) extends IterV[T,A]
  case class Cont[T,A](f: Stream[T] => IterV[T,A]) extends IterV[T,A]

  /** utility iteratees */

  def head[T]: IterV[T, Option[T]] = {
    def step(s: Stream[T]): IterV[T,Option[T]] = s match {
      case Empty => Cont(step)
      case EOF => Done(None, EOF)
      case El(a) => Done(Some(a), Empty)
    }
    Cont(step)
  }

/*
  def mapper[T,U,A](f: T => U): IterV[T,A] = {
    def step(s: Stream[T]): IterV[T,Option[T]] = s match {
      case Empty => Cont(step)
      case EOF => Done(None, EOF)
      case El(a) => Done(Some(a), Empty)
    }
    Cont(step)
  }
*/

  def print[T]: IterV[T, Unit] = {
    def step(s: Stream[T]): IterV[T,Unit] = s match {
      case Empty => Cont(step)
      case EOF => Done(None, EOF)
      case El(a) => println(a); Cont(step)//Done(Some(a), Empty)
    }
    Cont(step)
  }

  def peek[T]: IterV[T, Option[T]] = {
    def step(s: Stream[T]): IterV[T,Option[T]] = s match {
      case EOF => Done(None, EOF)
      case Empty => Cont(step)
      case El(a) => Done(Some(a), s)
    }
    Cont(step)
  }


  def drop[T](n:Int): IterV[T, Unit] =
    if(n == 0) Done((), Empty) else{
      def step(s: Stream[T]) : IterV[T, Unit] = s match{
        case EOF => Done((), EOF)
        case El(a) => drop(n-1)
        case Empty => Cont(step)
      }
      Cont(step)
    }

  def take[T](n:Int): IterV[T, List[T]] = {
    def inner(n:Int, ls:List[T]): IterV[T, List[T]] = {
      if(n == 0) Done(ls, EOF) else {
        def step(s: Stream[T]) : IterV[T, List[T]] = s match{
          case EOF => Done(Nil, EOF)
          case El(a) => inner(n-1, a::ls)
          case Empty => Cont(step)
        }

        Cont(step)
      }
    }
    inner(n, Nil)
  }

  def length[T] : IterV[T, Int] = {
    def step(i: Int)(s: Stream[T]) : IterV[T, Int] = s match {
      case Empty => Cont(step(i))
      case EOF => Done(i, EOF)
      case El(a) => Cont(step(i+1))
    }
    Cont(step(0))
  }

  def sum : IterV[Int, Int] = {
    def step(i: Int)(s: Stream[Int]) : IterV[Int, Int] = s match {
      case Empty => Cont(step(i))
      case EOF => Done(i, EOF)
      case El(a) => Cont(step(i+a))
    }
    Cont(step(0))
  }

  def drop1keep1[T]: IterV[T,Option[T]] =
    //for(_ <- drop(1); x <- head) yield x
    drop(1).flatMap{x =>
      head
    }

}

object IterateeTest extends Iteratees{

  def main(args: Array[String]){
    println("hello world!")

    println(drop[Int](1).enum(List(4,5,6)).run)
    println(drop1keep1[Int].enum(List(4,5,6)).run)
    println(print[Int].enum(List(4,5,6)).run)
    println(take[Int](3).enum(List(1,2,3,4,5,6)).run)
  }
}


