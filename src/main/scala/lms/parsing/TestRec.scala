package lms.parsing

class TestRec extends ((Array[Char])=>(Unit)) {
def apply(x0:Array[Char]): Unit = {

var f3 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
var f2 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
val x1 = null.asInstanceOf[Int]

//var x10: Int = x1
//var x11: Boolean = true
//var x12: Int = x8
//val x125 = f3(x8)
//val x126 = x125.res
//x10 = x126
//val x128 = x125.empty
//x11 = x128
//val x130 = x125.next
//x12 = x130
//val x132 = x10
//val x133 = x11
//val x134 = x12
//val x135 = new ParseResultInt(x132,x133,x134)
//x135
//}

val x26 = x0.length
val x36 = null.asInstanceOf[Tuple2IntInt]

// digit ~ num
f2 = {x20: (Int) =>
var x22: Int = x1
var x23: Boolean = true
var x24: Int = x20
val x27 = x20 >= x26
//index >= length
val x76 = if (x27) {
//val x38 = f3(x20)
x22 = x1
x23 = true
x24 = x20
()
} else {
val x30 = x0(x20)
val x31 = x30 >= '0'
val x32 = x30 <= '9'
val x33 = x31 && x32
val x74 = if (x33) {
val x34 = x20 + 1
val x46 = f3(x34)
val x47 = x46.empty
val x53 = if (x47) {
true
} else {
false
}
val x61 = if (x53) {
x1
} else {
val x52 = {
val x43 = x30 - '0'
val x44 = x43.toInt
val x48 = x46.res
val x49 = new Tuple2IntInt(x44,x48)
x49
}
val x57 = x52._1
val x58 = x52._2
val x59 = x57 + x58
x59
}
x22 = x61
val x62 = if (x53) {
true
} else {
false
}
x23 = x62
val x54 = if (x47) {
x20
} else {
val x50 = x46.next
x50
}
val x63 = if (x53) {
x54
} else {
x54
}
x24 = x63
()
} else {
//val x69 = f3(x20)
x22 = x1
x23 = true
x24 = x20
()
}
x74
}
val x77 = x22
val x78 = x23
val x79 = x24
val x80 = new ParseResultInt(x77,x78,x79)
x80
}

// f3!! : the recursive function itself
f3 = {x14: (Int) =>
var x16: Int = x1
var x17: Boolean = true
var x18: Int = x14
val x83 = f2(x14)
val x84 = x83.empty
//a = digit ~ a | digit, and we have failed on digit ~ a.
//so we parse digit now
val x118 = if (x84) {
val x85 = x14 >= x26
val x110 = if (x85) {
x16 = x1
x17 = true
x18 = x14
()
} else {
val x87 = x0(x14)
val x88 = x87 >= '0'
val x89 = x87 <= '9'
val x90 = x88 && x89
val x108 = if (x90) {
val x97 = x87 - '0'
val x98 = x97.toInt
x16 = x98
x17 = false
val x91 = x14 + 1
x18 = x91
()
} else {
x16 = x1
x17 = true
x18 = x14
()
}
x108
}
x110
} else {
val x112 = x83.res
x16 = x112
x17 = x84
val x115 = x83.next
x18 = x115
()
}
val x119 = x16
val x120 = x17
val x121 = x18
val x122 = new ParseResultInt(x119,x120,x121)
x122
}
var x3: Int = x1
var x4: Boolean = true
var x5: Int = -1
val x137 = f3(0)
val x138 = x137.res
x3 = x138
val x140 = x137.empty
x4 = x140
val x142 = x137.next
x5 = x142
val x144 = x3
val x145 = x4
val x146 = x5
val x147 = new ParseResultInt(x144,x145,x146)
val x148 = println(x147)
x148
}
}

object TestRec{
  def main(args:Array[String]){
    println("watch out!")
    new TestRec().apply("123a".toArray)
  }
}

case class Tuple2IntInt(_1: Int, _2: Int)