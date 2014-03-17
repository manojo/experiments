package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

/**
 * Inspired from TupleOps on delite-develop branch
 */
trait ReaderOps extends Base with IfThenElse with BooleanOps with ArrayOps
    with OrderingOps with StructOps with NumericOps with LiftVariables with While {

  /**
   * A mini implementation of a Reader
   *
   */
  abstract class Reader[+T: Manifest] {
    def atEnd: Rep[Boolean]
    def rest: Rep[Reader[T]]
    def first: Rep[T]
  }

  abstract class StringReader extends Reader[Char] {
    def input: Rep[Array[Char]]
    def offset: Rep[Int] = unit(0)
  }

  implicit def repToReaderCls(a: Rep[StringReader]) = new StringReaderCls(a)

  //just specialize for now, see what happens later
  class StringReaderCls(rdr: Rep[StringReader]) {

    def atEnd = reader_atEnd(rdr)
    def first = reader_first(rdr)
    def rest = reader_rest(rdr)

    def input = reader_input(rdr)
    def offset = reader_offset(rdr)

    def foreach(f: Rep[Char] => Rep[Unit]) = reader_foreach(rdr, f)

  }

  // the constructor
  def StringReader(input: Rep[Array[Char]], offset: Rep[Int] = unit(0)): Rep[StringReader]
  def reader_input(rdr: Rep[StringReader]): Rep[Array[Char]]
  def reader_offset(rdr: Rep[StringReader]): Rep[Int]

  def reader_atEnd(rdr: Rep[StringReader])(implicit pos: SourceContext): Rep[Boolean] =
    rdr.offset >= rdr.input.length

  def reader_first(rdr: Rep[StringReader])(implicit pos: SourceContext) =
    rdr.input(rdr.offset)

  def reader_rest(rdr: Rep[StringReader])(implicit pos: SourceContext) =
    StringReader(rdr.input, rdr.offset + unit(1))

  def reader_foreach(rdr: Rep[StringReader], f: Rep[Char] => Rep[Unit])(implicit pos: SourceContext) = {
    var tmp = rdr
    while (!readVar(tmp).atEnd) {
      f(readVar(tmp).first)
      tmp = readVar(tmp).rest
    }
  }

}

trait ReaderOpsExp extends ReaderOps with StructOpsExpOpt {

  def StringReader(input: Rep[Array[Char]], offset: Rep[Int] = unit(0)) =
    struct(classTag[StringReader],
      "input" -> input,
      "offset" -> offset
    )

  def reader_input(rdr: Rep[StringReader]): Rep[Array[Char]] =
    field[Array[Char]](rdr, "input")

  def reader_offset(rdr: Rep[StringReader]): Rep[Int] =
    field[Int](rdr, "offset")

}

trait ReaderGenBase extends GenericCodegen with BaseGenStructOps {
  val IR: ReaderOpsExp

  override def remap[A](m: Manifest[A]) = m.erasure.getSimpleName match {
    case "StringReader" => IR.structName(m)
    case _ => super.remap(m)
  }
}

trait ScalaGenReaderOps extends ScalaGenBase with ReaderGenBase with ScalaGenStructOps { val IR: ReaderOpsExp }

//trait CGenReaderOps extends CGenBase with ReaderGenBase with CGenStructOps { val IR: ReaderOpsExp }
