package lms.parsing

class TestRec extends ((Array[Char])=>(Unit)) {
def apply(x0:Array[Char]): Unit = {
var x7 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
var x122 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
var x80 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
val x1 = null.asInstanceOf[Int]
x7 = {x8: (Int) =>
var x10: Int = x1
var x11: Boolean = true
var x12: Int = x8
val x123 = x122(x8)
val x124 = x123.res
x10 = x124
val x126 = x123.empty
x11 = x126
val x128 = x123.next
x12 = x128
val x130 = x10
val x131 = x11
val x132 = x12
val x133 = new ParseResultInt(x130,x131,x132)
x133
}
val x26 = x0.length
val x30 = null.asInstanceOf[Tuple2IntInt]
x80 = {x20: (Int) =>
var x22: Int = x1
var x23: Boolean = true
var x24: Int = x20
val x27 = x20 >= x26
val x74 = if (x27) {
x22 = x1
x23 = true
x24 = x20
()
} else {
val x36 = x0(x20)
val x37 = x36 >= '0'
val x38 = x36 <= '9'
val x39 = x37 && x38
val x72 = if (x39) {
val x40 = x20 + 1
val x45 = x7(x40)
val x46 = x45.empty
val x52 = if (x46) {
true
} else {
false
}
val x60 = if (x52) {
x1
} else {
val x51 = if (x46) {
x30
} else {
val x42 = x36 - '0'
val x43 = x42.toInt
val x47 = x45.res
val x48 = new Tuple2IntInt(x43,x47)
x48
}
val x56 = x51._1
val x57 = x51._2
val x58 = x56 + x57
x58
}
x22 = x60
val x61 = if (x52) {
true
} else {
false
}
x23 = x61
val x53 = if (x46) {
x20
} else {
val x49 = x45.next
x49
}
val x62 = if (x52) {
x53
} else {
x53
}
x24 = x62
()
} else {
x22 = x1
x23 = true
x24 = x20
()
}
x72
}
val x75 = x22
val x76 = x23
val x77 = x24
val x78 = new ParseResultInt(x75,x76,x77)
x78
}
x122 = {x14: (Int) =>
var x16: Int = x1
var x17: Boolean = true
var x18: Int = x14
val x81 = x80(x14)
val x82 = x81.empty
val x116 = if (x82) {
val x83 = x14 >= x26
val x108 = if (x83) {
x16 = x1
x17 = true
x18 = x14
()
} else {
val x89 = x0(x14)
val x90 = x89 >= '0'
val x91 = x89 <= '9'
val x92 = x90 && x91
val x106 = if (x92) {
val x95 = x89 - '0'
val x96 = x95.toInt
x16 = x96
x17 = false
val x93 = x14 + 1
x18 = x93
()
} else {
x16 = x1
x17 = true
x18 = x14
()
}
x106
}
x108
} else {
val x110 = x81.res
x16 = x110
x17 = x82
val x113 = x81.next
x18 = x113
()
}
val x117 = x16
val x118 = x17
val x119 = x18
val x120 = new ParseResultInt(x117,x118,x119)
x120
}
var x3: Int = x1
var x4: Boolean = true
var x5: Int = -1
val x135 = x7(0)
val x136 = x135.res
x3 = x136
val x138 = x135.empty
x4 = x138
val x140 = x135.next
x5 = x140
val x142 = x3
val x143 = x4
val x144 = x5
val x145 = new ParseResultInt(x142,x143,x144)
val x146 = println(x145)
x146
}
}

object TestRec{
  def main(args:Array[String]){
    println("watch out!")
    new TestRec().apply("1+12".toArray)
  }
}

case class Tuple2IntInt(_1: Int, _2: Int)