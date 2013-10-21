 package generators

/**
 * An implementation of the general yield as described in
 * "Yield: mainstream delimited continuations" by Roshan P. James et al.
 */

trait Generators{

  //an iterator takes inputs of type i, yields temp values of type o and eventually
  //returns a value of type R
  abstract class Iterator[I,O,R]{ self =>
    //def yield(o: O): Iterator[I,O,I]
    def flatMap[B](f: R => Iterator[I,O,B]): Iterator[I,O,B] = self match {
      case Result(r) =>  f(r)
      case Susp(o, k) => Susp(o, (i: I) => k(i).flatMap(f))
    }

    def map[B](f: R => B): Iterator[I,O,B] = self match {
      case Result(r) => Result(f(r))
      case Susp(o,k) => Susp(o, (i: I) => k(i).map(f))
    }

    def filter(p: R => Boolean): Iterator[I,O,Option[R]] = self match {
      case Result(r) => Result(if(p(r)) Some(r) else None)
      case Susp(o,k) => Susp(o, (i: I) => k(i).filter(p))
    }

    def loop(f: O => I): R = self match {
      case Result(r) => r
      case Susp(o,k) => k(f(o)) loop f
    }

  }

  case class Result[I,O,R](r: R) extends Iterator[I,O,R]
  case class Susp[I,O,R](o: O, cont: I => Iterator[I,O,R]) extends Iterator[I,O,R]

  def unit[I,O,R](r:R): Iterator[I,O,R] = Result[I,O,R](r)
  def yld[I,O](o: O): Iterator[I,O,I] = Susp(o,(i:I) => unit[I,O,I](i))


  abstract class Tree[+T]
  case class Leaf[+T](t:T) extends Tree[T]
  case class Node[+T](l: Tree[T], r: Tree[T]) extends Tree[T]


  /**
   * Monadic style writing
   * The magic of this function however is how easy samefringe and swapfringe become!
   */

  def depthWalk[A,B](t: Tree[A]): Iterator[B,A,Tree[B]] = t match {
    case Node(l,r) =>
      for(l2 <- depthWalk(l); r2 <- depthWalk(r)) yield Node(l2,r2)
    case Leaf(t) => for(b <- yld(t)) yield Leaf(b)
  }

  def renum[T](it: Iterator[Int,Int,T]) : T = it.loop{i => i+1}

  def samefringe[A,T](l: Iterator[A,A,T] , r: Iterator[A,A,T]): Boolean = (l,r) match {
    case (Result(_), Result(_)) => true
    case (Susp(o1, k1), Susp(o2, k2)) if (o1 == o2) => samefringe(k1(o1), k2(o2))
    case _ => false
  }

  def swapfringe[A,T](l: Iterator[A,A,T] , r: Iterator[A,A,T]) : (T,T) = (l,r) match {
    case (Result(t1), Result(t2)) => (t1, t2)
    case (Susp(o1, k1), Susp(o2, k2)) => swapfringe(k1(o2), k2(o1))
  }

  //type SR[I,A,R] = Iterator[I]

}


object GeneratorTest extends Generators{
  def main(args:Array[String]){
    println("Generators y'all")

    val tree = Node(Leaf(1), Node(Leaf(10), Leaf(5)))
    val tree2 = Node(Node(Leaf(1), Leaf(10)), Leaf(5))

    val tree3 = Node(Node(Leaf(4), Leaf(7)), Leaf(2))

    //println(renum(depthWalk(tree)))
    //println(samefringe(depthWalk[Int,Int](tree), depthWalk[Int,Int](tree2)))
    //println(swapfringe(depthWalk[Int,Int](tree), depthWalk[Int,Int](tree3)))
  }
}