package lms

import scala.virtualization.lms.common._
import scala.reflect.SourceContext

trait MyFunctionsRecursiveExp extends FunctionsRecursiveExp {
  override def canonicalize(f: Function[_,_]) = {
    val s = new java.io.ByteArrayOutputStream()
    val o = new java.io.ObjectOutputStream(s)
    o.writeObject(f)
    s.toString("ASCII")
  }

}