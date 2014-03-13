package stream

/**
 * A scala implementation of streams described in the 'stream fusion' paper by
 * Duncan Coutts et al.
 */

trait Streams {

  abstract class Stream[A, S](seed: S) { self =>

    def stepper: S => Step[A, S]

    def map[B](f: A => B): Stream[B, S] = new Stream[B, S](seed) {
      def stepper = (s: S) => self.stepper(s) match {
        case Done() => Done()
        case Yield(a, s2) => Yield(f(a), s2)
        case Skip(s) => Skip(s)
      }
    }

    def filter(p: A => Boolean): Stream[A, S] = new Stream[A, S](seed) {
      def stepper = (s: S) => self.stepper(s) match {
        case Done() => Done()
        case Yield(a, s2) => if (p(a)) Yield(a, s2) else Skip(s2)
        case Skip(s) => Skip(s)
      }
    }

    /*
    def flatMap[B](f: A => Stream[B,S]) = new Stream[B,S](seed){
      def stepper = (s:S) => {

        self.stepper(seed) match {
          case Done() =>
        }

        def inner()
      }
    }
*/
    def unstream: List[A] = {
      def unfold(s: S): List[A] = stepper(s) match {
        case Done() => Nil
        case Skip(s2) => unfold(s2)
        case Yield(x, s2) => x :: unfold(s2)
      }
      unfold(seed)
    }

  }

  def mkStream[T](ls: List[T]) = new Stream[T, List[T]](ls) {
    def stepper = (xs: List[T]) => xs match {
      case Nil => Done[T, List[T]]
      case (y :: ys) => Yield(y, ys)
    }
  }

  abstract class Step[A, S]
  case class Done[A, S]() extends Step[A, S]
  case class Yield[A, S](a: A, s: S) extends Step[A, S]
  case class Skip[A, S](s: S) extends Step[A, S]

}