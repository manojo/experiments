package lms.parsing

import lms._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal.GenericCodegen
import scala.reflect.SourceContext

import java.io.PrintWriter

abstract class Reader[+T]
class StringReader extends Reader[Char]

trait ReaderOps extends Base {

  type Elem
  type Input <: Reader[Elem]

  //need manifests for later
  implicit val mInput: Manifest[Input]

  implicit class ReaderCls(rdr: Rep[Input]) {
    def first: Rep[Elem] = rdr_first(rdr)
    def rest: Rep[Input] = rdr_rest(rdr)
    def atEnd: Rep[Boolean] = rdr_atEnd(rdr)
    def offset: Rep[Int] = rdr_offset(rdr)
  }

  def rdr_first(rdr: Rep[Input]): Rep[Elem]
  def rdr_rest(rdr: Rep[Input]): Rep[Input]
  def rdr_atEnd(rdr: Rep[Input]): Rep[Boolean]
  def rdr_offset(rdr: Rep[Input]): Rep[Int]
}

trait StringReaderOps extends ReaderOps with ArrayOps with OrderingOps
  with NumericOps with While with LiftVariables with BooleanOps {

  type Elem = Char
  type Input = StringReader

  implicit class StringReaderCls(rdr: Rep[StringReader]) extends ReaderCls(rdr) {
    def input: Rep[Array[Elem]] = rdr_input(rdr)

    def foreach(f: Rep[Char] => Rep[Unit]) = {
      var tmp = rdr
      while (!readVar(tmp).atEnd) {
        f(readVar(tmp).first)
        tmp = readVar(tmp).rest
      }
    }
  }

  def rdr_first(rdr: Rep[Input]): Rep[Elem] = rdr.input(rdr.offset)
  def rdr_atEnd(rdr: Rep[Input]): Rep[Boolean] = rdr.offset >= rdr.input.length
  def rdr_rest(rdr: Rep[Input]): Rep[Input] = StringReader(rdr.input, rdr.offset + unit(1))

  def rdr_input(rdr: Rep[StringReader]): Rep[Array[Char]]
  def rdr_offset(rdr: Rep[StringReader]): Rep[Int]
  def StringReader(input: Rep[Array[Char]], offset: Rep[Int] = unit(0)): Rep[StringReader]
}

trait StringReaderOpsExp extends StringReaderOps with ArrayOpsExp with OrderingOpsExp
  with NumericOpsExp with StructOpsExpOpt with WhileExp with BooleanOpsExp {

  //A bit of a hack: manifest[StringReader] causes a nullPointerException
  //possibly due to a bug in Scala

  implicit val mInput: Manifest[Input]
    = scala.reflect.ManifestFactory.classType[StringReader](classOf[StringReader])

  def StringReader(input: Rep[Array[Char]], offset: Rep[Int] = unit(0)) = {

    struct(classTag[StringReader](mInput),
      "input" -> input,
      "offset" -> offset
    )
  }

  def rdr_input(rdr: Rep[StringReader]): Rep[Array[Char]] =
    field[Array[Char]](rdr, "input")

  def rdr_offset(rdr: Rep[StringReader]): Rep[Int] =
    field[Int](rdr, "offset")
}

trait ReaderGenBase extends GenericCodegen with BaseGenStructOps {
  val IR: StringReaderOpsExp



  override def remap[A](m: Manifest[A]) = {
    m.erasure.getSimpleName match {
    case "StringReader" => IR.structName(m)
    case _ => super.remap(m)
    }
  }
}

trait ScalaGenReaderOps extends ScalaGenBase with ReaderGenBase with ScalaGenStructOps { val IR: StringReaderOpsExp }

/*

  implicit def repToCReaderImpl(a: Rep[ChunkReader]) = new ChunkReaderImpl(a)

  class ChunkReaderImpl(override val rdr: Rep[ChunkReader]) extends ReaderImpl[Char] {

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

  def infix_atEnd[T: Manifest](rdr: Rep[Reader[T]]): Rep[Boolean] =

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

//trait CGenReaderOps extends CGenBase with ReaderGenBase with CGenStructOps { val IR: ReaderOpsExp }
*/