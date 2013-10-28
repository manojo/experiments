package lms.parsing

class TestRec extends ((Array[Char])=>(Unit)) {
def apply(x0:Array[Char]): Unit = {
var x7 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
var x155 = null.asInstanceOf[scala.Function1[Int, ParseResultInt]]
val x1 = null.asInstanceOf[Int]
x7 = {x8: (Int) =>
var x10: Int = x1
var x11: Boolean = true
var x12: Int = x8
val x156 = x155(x8)
val x157 = x156.res
x10 = x157
val x159 = x156.empty
x11 = x159
val x161 = x156.next
x12 = x161
val x163 = x10
val x164 = x11
val x165 = x12
val x166 = new ParseResultInt(x163,x164,x165)
x166
}
val x42 = x0.length
val x89 = {x20: (Int) =>
var x22: Int = x1
var x23: Boolean = true
var x24: Int = x20
var x27: Int = 0
var x28: Boolean = false
var x29: Int = x20
var x31: Int = -1
var x32: Boolean = true
var x33: Int = x20
val x76 = while ({val x34 = x32
val x35 = x31
val x36 = x33
val x37 = x35 != x36
val x38 = x34 && x37
x38}) {
val x40 = x33
x31 = x40
val x43 = x40 >= x42
val x74 = if (x43) {
x32 = false
()
} else {
val x49 = x0(x40)
val x50 = x49 >= '0'
val x51 = x49 <= '9'
val x52 = x50 && x51
val x72 = if (x52) {
val x58 = x27
val x59 = x28
val x60 = x29
val x55 = x49 - '0'
val x56 = x55.toInt
val x62 = x58 * 10
val x63 = x62 + x56
x27 = x63
x28 = false
val x53 = x40 + 1
x29 = x53
x33 = x53
()
} else {
x32 = false
()
}
x72
}
x74
}
val x77 = x27
val x78 = x28
val x79 = x29
x22 = x77
x23 = x78
x24 = x79
val x84 = x22
val x85 = x23
val x86 = x24
val x87 = new ParseResultInt(x84,x85,x86)
x87
}
x155 = {x14: (Int) =>
var x16: Int = x1
var x17: Boolean = true
var x18: Int = x14
val x90 = x89(x14)
val x91 = x90.empty
val x149 = if (x91) {
val x92 = x14 >= x42
val x141 = if (x92) {
x16 = x1
x17 = true
x18 = x14
()
} else {
val x98 = x0(x14)
val x99 = x98 == '['
val x139 = if (x99) {
  println("rockers!")
val x100 = x14 + 1
val x102 = x7(x100)
val x103 = x102.empty
val x133 = if (x103) {
val x104 = x102.res
x16 = x104
x17 = x103
val x107 = x102.next
x18 = x107
()
} else {
val x107 = x102.next
val x110 = x107 >= x42
val x131 = if (x110) {
x16 = x1
x17 = true
x18 = x14
()
} else {
val x116 = x0(x107)
val x117 = x116 == ']'
val x129 = if (x117) {
val x104 = x102.res
x16 = x104
x17 = false
val x118 = x107 + 1
x18 = x118
()
} else {
x16 = x1
x17 = true
x18 = x14
()
}
x129
}
x131
}
x133
} else {
x16 = x1
x17 = true
x18 = x14
()
}
x139
}
x141
} else {
val x143 = x90.res
x16 = x143
x17 = x91
val x146 = x90.next
x18 = x146
()
}
val x150 = x16
val x151 = x17
val x152 = x18
val x153 = new ParseResultInt(x150,x151,x152)
x153
}
var x3: Int = x1
var x4: Boolean = true
var x5: Int = -1
val x168 = x7(0)
val x169 = x168.res
x3 = x169
val x171 = x168.empty
x4 = x171
val x173 = x168.next
x5 = x173
val x175 = x3
val x176 = x4
val x177 = x5
val x178 = new ParseResultInt(x175,x176,x177)
val x179 = println(x178)
x179
}
}

object TestRec{
  def main(args:Array[String]){
    println("watch out!")
    new TestRec().apply("[12]".toArray)
  }
}

case class Tuple2IntInt(_1: Int, _2: Int)