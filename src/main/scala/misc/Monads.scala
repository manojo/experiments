package misc

/**
 * Different monads as described in Wadler's "monads for functional programming"
 */

trait Monad{

  type M[+A]

  def unit[A](a : A) : M[A]
  def bind[A,B](m : M[A], f: A => M[B]): M[B]

  def map[A,B](m: M[A], f: A => B) : M[B] = {
    bind(m, (a: A) => unit(f(a)))
  }

  def join[A](m: M[M[A]]): M[A] = {
    bind(m, (a: M[A]) => a)
  }

}


class IdentityMonad extends Monad{
  type M[+A] = A

  def unit[A](a: A) = a
  def bind[A,B](m : M[A], f: A => M[B]) = f(m)

}


class ExceptionMonad extends Monad{

  abstract class Exp[+A]
  case class Return[A](a: A) extends Exp[A]
  case class Raise(s: String) extends Exp[Nothing]

  type M[+A] = Exp[A]

  def unit[A](a: A) = Return(a)
  def bind[A,B](m : M[A], f: A => M[B]) = m match {
    case Return(a) => f(a)
    case e@Raise(_) => e
  }

  def raise[A](e: String) : M[A] = Raise(e)

}

class StateMonad extends Monad{

  type State = Int
  type M[+A] = State => (A, State)

  def unit[A](a: A) = {s: State => (a, s)}
  def bind[A,B](m : M[A], f: A => M[B]) = {s : State =>

    val (a1, s1) = m(s)
    val (a2, s2) = f(a1)(s1)
    (a2, s2)
  }

  def tick : M[Unit] = {s : State => ((), s+1)}

}


class OutputMonad extends Monad{

  type Output = String
  type M[+A] = (Output, A)

  def unit[A](a: A) = ("", a)
  def bind[A,B](m : M[A], f: A => M[B]) = {
    val (s1, a1) = m
    val (s2, a2) = f(a1)

    (s1 ++ s2, a2)
  }

}
