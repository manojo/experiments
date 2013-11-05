package parsing

/** A parser combinator implementation based on Koopman and Klasmeijer 1998, Efficient Combinator Parsers */

trait OldSchoolParsers{
  type ParseResult[S,R] = List[(List[S], R)]
  abstract class Parser[S,R] extends (List[S] => ParseResult[S,R]){ self =>

    def flatMap[T](f: R => Parser[S,T]) = Parser[S,T]{xs:List[S] =>
      for((rest, r) <- self(xs);
          (rest2, r2) <- f(r)(rest)
         ) yield (rest2, r2)
    }

    //classic monad law
    def map[T](f: R => T): Parser[S,T] = this.flatMap{r:R => unit(f(r))}

    def >> [T](f: R => Parser[S,T]) = flatMap(f)

    def | (that: Parser[S,R]) = Parser{xs:List[S] => self(xs) ++ that(xs)}

    //Not defined in the paper, they just use flatMap
    //but corresponds to ~ in ADP
    def ~ [T](that: Parser[S,T]) : Parser[S,(R,T)] =
      for(r1 <- this;
          r2 <- that
        ) yield (r1, r2)

  }

  def Parser[S,R](f: List[S] => ParseResult[S,R]) = new Parser[S,R]{
    def apply(ls: List[S]) = f(ls)
  }

  //called symbol in the paper
  def accept[S](s:S) = Parser[S,S]{ (xs:List[S]) => xs match {
    case s2::ss if s == s2 => (ss,s)::Nil
    case _ => Nil
  }}

  //called satisfy in the paper
  def acceptIf[S](p: S => Boolean) = Parser[S,S]{xs:List[S] => xs match{
    case s::ss if p(s) => (ss,s)::Nil
    case _ => Nil
  }}

  def fail[S,R] = Parser[S,R]{ xs => Nil }

  def unit[S,R](r:R) = Parser[S,R]{xs: List[S] => (xs,r)::Nil}
}

//With continuations now
trait ContParsers extends OldSchoolParsers{

  abstract class ParserC[S,R,T] extends ((Success[S,R,T], NextRes[S,T]) => Parser[S,T]){self =>
    def flatMap[V](f: R => ParserC[S,V,T]): ParserC[S,V,T] = ParserC[S,V,T]{
      (succ:Success[S,V,T], next:NextRes[S,T]) =>  self.apply(
        Success[S,R,T]{(r:R, nr: NextRes[S,T]) =>
          Parser[S,T]{xs:List[S] => f(r)(succ,nr)(xs)}
        },
        next
      )
    }

    def | (that: ParserC[S,R,T]) = ParserC[S,R,T]{
      (succ: Success[S,R,T], nr: NextRes[S,T]) => Parser{xs: List[S] =>
        self.apply(succ, that(succ,nr)(xs))(xs)
      }

    }
  }
  abstract class Success[S,R,T] extends ((R,NextRes[S,T]) => Parser[S,T])
  type NextRes[S,T] = ParseResult[S,T]

  def ParserC[S,R,T](f: (Success[S,R,T], NextRes[S,T]) => Parser[S,T]) = new ParserC[S,R,T]{
    def apply(s: Success[S,R,T], nr: NextRes[S,T]) = f(s,nr)
  }

  def Success[S,R,T](f: (R, NextRes[S,T]) => Parser[S,T]) = new Success[S,R,T]{
    def apply(r: R, nr: NextRes[S,T]) = f(r,nr)
  }

  def failC[S,R,T] = ParserC[S,R,T]{
    (succ: Success[S,R,T], next: NextRes[S,T]) => Parser[S,T]{xs:List[S] => next}
  }

  def unitC[S,R,T](r:R) = ParserC[S,R,T]{
    (succ: Success[S,R,T], next:NextRes[S,T]) => Parser[S,T]{xs:List[S] => succ(r,next)(xs)}
  }

  def symbolC[S,T](s:S) = ParserC[S,S,T]{
    (succ: Success[S,S,T], next: NextRes[S,T]) => Parser[S,T]{xs: List[S] => xs match{
      case s2::ss if s ==s2 => succ(s, next)(ss)
      case _ => next
    }}
  }

  def begin[S,T](p: ParserC[S,T,T]) = p (
    Success{(t:T, nr:NextRes[S,T]) =>  Parser{xs:List[S] => (xs,t)::nr}},
    Nil
  )
}



