package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

//creating new types so we can Rep them
abstract class Reader[+T: Manifest]
abstract class StringReader extends Reader[Char]
abstract class ChunkReader extends Reader[Char]

/**
 * Inspired from TupleOps on delite-develop branch
 */
trait ReaderOps extends Base with IfThenElse with BooleanOps with ArrayOps
    with OrderingOps with StructOps with NumericOps with LiftVariables with While {

  /**
   * A mini implementation of a Reader
   *
   */

  abstract class ReaderCls[+T: Manifest] {
    def rdr: Rep[Reader[T]]

    def atEnd: Rep[Boolean]
    def first: Rep[T]
    def rest: Rep[Reader[T]]

  }

  implicit def repToSReaderCls(a: Rep[StringReader]) = new StringReaderCls(a)

  class StringReaderCls(override val rdr: Rep[StringReader]) extends ReaderCls[Char] {

    def input = sreader_input(rdr)
    def offset: Rep[Int] = sreader_offset(rdr)

    def atEnd = rdr.offset >= rdr.input.length
    def first = rdr.input(rdr.offset)
    def rest = StringReader(rdr.input, rdr.offset + unit(1))

    def foreach(f: Rep[Char] => Rep[Unit]) = {
      var tmp = rdr
      while (!readVar(tmp).atEnd) {
        f(readVar(tmp).first)
        tmp = readVar(tmp).rest
      }
    }
  }

  // the constructor
  def StringReader(input: Rep[Array[Char]], offset: Rep[Int] = unit(0)): Rep[StringReader]
  def sreader_input(rdr: Rep[StringReader]): Rep[Array[Char]]
  def sreader_offset(rdr: Rep[StringReader]): Rep[Int]

  implicit def repToCReaderCls(a: Rep[ChunkReader]) = new ChunkReaderCls(a)

  class ChunkReaderCls(override val rdr: Rep[ChunkReader]) extends ReaderCls[Char] {

    def innerReader: Rep[StringReader] = creader_inner(rdr)
    def chunkEnd: Rep[Int] = creader_chunkEnd(rdr)

    def input = innerReader.input
    def offset = innerReader.offset

    def atEnd = innerReader.atEnd
    def first = innerReader.first
    def rest: Rep[Reader[Char]] = {
      if (offset == chunkEnd - unit(1)) {
        val next = innerReader.rest
        innerReader // number match ...
      } else ChunkReader(innerReader.rest, chunkEnd)
    }

  }

  def ChunkReader(innerRdr: Rep[StringReader], chunkEnd: Rep[Int]): Rep[ChunkReader]
  def creader_inner(rdr: Rep[ChunkReader]): Rep[StringReader]
  def creader_chunkEnd(rdr: Rep[ChunkReader]): Rep[Int]

}

trait ReaderOpsExp extends ReaderOps with StructOpsExpOpt {

  def StringReader(input: Rep[Array[Char]], offset: Rep[Int] = unit(0)) =
    struct(classTag[StringReader],
      "input" -> input,
      "offset" -> offset
    )

  def sreader_input(rdr: Rep[StringReader]): Rep[Array[Char]] =
    field[Array[Char]](rdr, "input")

  def sreader_offset(rdr: Rep[StringReader]): Rep[Int] =
    field[Int](rdr, "offset")

  def ChunkReader(innerRdr: Rep[StringReader], chunkEnd: Rep[Int]) =
    struct(classTag[ChunkReader],
      "innerRdr" -> innerRdr,
      "chunkEnd" -> chunkEnd
    )

  def creader_inner(rdr: Rep[ChunkReader]): Rep[StringReader] =
    field[StringReader](rdr, "innerRdr")

  def creader_chunkEnd(rdr: Rep[ChunkReader]): Rep[Int] =
    field[Int](rdr, "chunkEnd")

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
