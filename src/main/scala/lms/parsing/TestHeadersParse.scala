package lms.parsing

object TestHeadersParse{
  val hp = new headersParse(
    "connection".toArray,// "connection".length,
    "proxy-connection".toArray,// "proxy-connection".length,
    "keep-alive".toArray, //"keep-alive".length,
    "close".toArray, //"close".length,
    "content-length".toArray, //"content-length".length,
    "transfer-encoding".toArray, //"transfer-encoding".length,
    "chunked".toArray, //"chunked".length,
    "upgrade".toArray//, "upgrade".length
  )

  val str =
    List( """|Date: Mon, 23 May 2005 22:38:34 GMT
           |""".stripMargin,

          """|Content-Length: 131
             |""".stripMargin
        ).mkString

  def main(args:Array[String]){
    println(str)
    println(str.length)

    hp.apply(str.toArray)
  }
}

class headersParse(
  px419:Array[Char],
  px452:Array[Char],
  px483:Array[Char],
  px516:Array[Char],
  px566:Array[Char],
  px616:Array[Char],
  px646:Array[Char],
  px678:Array[Char]) extends ((Array[Char])=>(Unit)){
def apply(x0:Array[Char]): Unit = {
var x2: Int = -1
var x3: Boolean = true
var x4: Int = 0
var x6: Int = 200
var x7: Int = 0
var x8: java.lang.String = "close"
var x9: Boolean = false
var x10: Boolean = false
var x12: Boolean = false
var x13: Int = 0
val x23 = x0.length
var x48: Int = 0
var x49: Boolean = false
var x52: Int = -1
var x53: Boolean = true
var x134: Boolean = false
var x129: Int = -1
var x130: Boolean = true
var x133: java.lang.String = ""
var x247: Boolean = false
var x242: Int = -1
var x243: Boolean = true
var x246: java.lang.String = ""
var x295: Int = 0
var x296: Boolean = false
var x299: Int = -1
var x300: Boolean = true
val x419 = px419 // static data: Array(c,o,n,n,e,c,t,i,o,n)
val x421 = x419.length
val x452 = px452 // static data: Array(p,r,o,x,y,-,c,o,n,n,e,c,t,i,o,n)
val x453 = x452.length
val x483 = px483 // static data: Array(k,e,e,p,-,a,l,i,v,e)
val x485 = x483.length
val x516 = px516 // static data: Array(c,l,o,s,e)
val x517 = x516.length
val x566 = px566 // static data: Array(c,o,n,t,e,n,t,-,l,e,n,g,t,h)
val x567 = x566.length
val x616 = px616 // static data: Array(t,r,a,n,s,f,e,r,-,e,n,c,o,d,i,n,g)
val x617 = x616.length
val x646 = px646 // static data: Array(c,h,u,n,k,e,d)
val x647 = x646.length
val x678 = px678 // static data: Array(u,p,g,r,a,d,e)
val x679 = x678.length
val x743 = while ({val x15 = x3
  println("continue: "+x15)
val x16 = x2
val x17 = x4
val x18 = x16 != x17
val x19 = x15 && x18
println("old != cur: " + (x16,x17).toString)
x19}) {
val x21 = x4
x2 = x21
val x24 = x21 >= x23
var x43: Boolean = false
var x44: Int = 0
var x42: Int = 0
if (x24) {
x43 = true
x44 = x21
x42 = 0
} else {
val x26 = x0(x21)
val x27 = x26 >= 'a'
val x28 = x26 <= 'z'
val x29 = x27 && x28
val x30 = x26 >= 'A'
val x31 = x26 <= 'Z'
val x32 = x30 && x31
val x33 = x29 || x32
var x38: Boolean = false
var x39: Int = 0
var x37: Int = 0
if (x33) {
val x34 = x21 + 1
x38 = false
x39 = x34
x37 = x21
} else {
x38 = true
x39 = x21
x37 = 0
}
x43 = x38
x44 = x39
x42 = x37
}
var x115: Boolean = false
var x116: Int = 0
var x114: Tuple2IntAnon1680061013 = null
if (x43) {
x115 = true
x116 = x21
x114 = null
} else {
var x50: Int = x44
var x54: Int = x44
val x102 = while ({val x55 = x53
val x56 = x52
val x57 = x54
val x58 = x56 != x57
val x59 = x55 && x58
x59}) {
val x61 = x54
x52 = x61
val x63 = x61 >= x23
var x84: Boolean = false
var x85: Int = 0
if (x63) {
x84 = true
x85 = x61
} else {
val x65 = x0(x61)
val x66 = x65 >= 'a'
val x67 = x65 <= 'z'
val x68 = x66 && x67
val x69 = x65 >= 'A'
val x70 = x65 <= 'Z'
val x71 = x69 && x70
val x72 = x68 || x71
val x73 = x65 == '-'
val x74 = x72 || x73
var x79: Boolean = false
var x80: Int = 0
if (x74) {
val x75 = x61 + 1
x79 = false
x80 = x75
} else {
x79 = true
x80 = x61
}
x84 = x79
x85 = x80
}
val x100 = if (x84) {
x53 = false
()
} else {
val x89 = x48
val x90 = x49
val x91 = x50
val x93 = x89 + 1
x48 = x93
x49 = false
x50 = x85
x54 = x85
()
}
x100
}
val x105 = x50
val x103 = x48
val x107 = new Anon1680061013(x0,x44,x103)
val x109 = new Tuple2IntAnon1680061013(x42,x107)
x115 = false
x116 = x105
x114 = x109
}
var x127: Boolean = false
var x126: Anon1680061013 = null
if (x115) {
x127 = true
x126 = null
} else {
val x119 = x114._1
val x120 = x114._2
val x121 = x120.length
val x122 = x121 + 1
val x123 = new Anon1680061013(x0,x119,x122)
x127 = false
x126 = x123
}
var x238: Boolean = false
var x239: Int = 0
var x237: Anon1680061013 = null
if (x127) {
x238 = x127
x239 = x116
x237 = x126
} else {
var x131: Int = x116
var x135: Int = x116
val x175 = while ({val x137 = x130
val x138 = x129
val x139 = x131
val x140 = x138 != x139
val x141 = x137 && x140
x141}) {
val x143 = x131
x129 = x143
val x145 = x143 >= x23
var x158: Boolean = false
var x159: Int = 0
if (x145) {
x158 = true
x159 = x143
} else {
val x147 = x0(x143)
val x148 = x147 == ' '
var x153: Boolean = false
var x154: Int = 0
if (x148) {
val x149 = x143 + 1
x153 = false
x154 = x149
} else {
x153 = true
x154 = x143
}
x158 = x153
x159 = x154
}
val x173 = if (x158) {
x130 = false
()
} else {
val x163 = x133
val x164 = x134
val x165 = x135
x133 = x163
x134 = false
x135 = x159
x131 = x159
()
}
x173
}
val x177 = x134
var x224: Boolean = false
var x225: Int = 0
if (x177) {
x224 = true
x225 = x116
} else {
val x178 = x135
val x181 = x178 >= x23
var x194: Boolean = false
var x195: Int = 0
if (x181) {
x194 = true
x195 = x178
} else {
val x183 = x0(x178)
val x184 = x183 == ':'
var x189: Boolean = false
var x190: Int = 0
if (x184) {
val x185 = x178 + 1
x189 = false
x190 = x185
} else {
x189 = true
x190 = x178
}
x194 = x189
x195 = x190
}
var x203: Boolean = false
var x204: Int = 0
if (x194) {
x203 = true
x204 = x178
} else {
x203 = false
x204 = x195
}
val x213 = if (x203) {
true
} else {
false
}
var x219: Boolean = false
var x220: Int = 0
if (x213) {
x219 = true
x220 = x116
} else {
x219 = false
x220 = x204
}
x224 = x219
x225 = x220
}
var x231: Boolean = false
var x232: Int = 0
var x230: Anon1680061013 = null
if (x224) {
x231 = true
x232 = x21
x230 = null
} else {
x231 = false
x232 = x225
x230 = x126
}
x238 = x231
x239 = x232
x237 = x230
}
var x394: Boolean = false
var x393: Tuple2Anon1680061013Anon1680061013 = null
var x395: Int = 0
if (x238) {
x394 = true
x393 = null
x395 = x21
} else {
var x244: Int = x239
var x248: Int = x239
val x288 = while ({val x250 = x243
val x251 = x242
val x252 = x244
val x253 = x251 != x252
val x254 = x250 && x253
x254}) {
val x256 = x244
x242 = x256
val x258 = x256 >= x23
var x271: Boolean = false
var x272: Int = 0
if (x258) {
x271 = true
x272 = x256
} else {
val x260 = x0(x256)
val x261 = x260 == ' '
var x266: Boolean = false
var x267: Int = 0
if (x261) {
val x262 = x256 + 1
x266 = false
x267 = x262
} else {
x266 = true
x267 = x256
}
x271 = x266
x272 = x267
}
val x286 = if (x271) {
x243 = false
()
} else {
val x276 = x246
val x277 = x247
val x278 = x248
x246 = x276
x247 = false
x248 = x272
x244 = x272
()
}
x286
}
val x290 = x247
var x353: Boolean = false
var x354: Int = 0
var x352: Anon1680061013 = null
if (x290) {
x353 = true
x354 = x239
x352 = null
} else {
val x291 = x248
var x297: Int = x291
var x301: Int = x291
val x342 = while ({val x302 = x300
val x303 = x299
val x304 = x301
val x305 = x303 != x304
val x306 = x302 && x305
x306}) {
val x308 = x301
x299 = x308
val x310 = x308 >= x23
var x324: Boolean = false
var x325: Int = 0
if (x310) {
x324 = true
x325 = x308
} else {
val x312 = x0(x308)
val x314 = x312 == '\n'
var x319: Boolean = false
var x320: Int = 0
if (x314) {
x319 = true
x320 = x308
} else {
val x315 = x308 + 1
x319 = false
x320 = x315
}
x324 = x319
x325 = x320
}
val x340 = if (x324) {
x300 = false
()
} else {
val x329 = x295
val x330 = x296
val x331 = x297
val x333 = x329 + 1
x295 = x333
x296 = false
x297 = x325
x301 = x325
()
}
x340
}
val x345 = x297
val x343 = x295
val x347 = new Anon1680061013(x0,x291,x343)
x353 = false
x354 = x345
x352 = x347
}
var x380: Boolean = false
var x379: Anon1680061013 = null
var x381: Int = 0
if (x353) {
x380 = x353
x379 = x352
x381 = x354
} else {
val x356 = x354 >= x23
var x369: Boolean = false
var x370: Int = 0
if (x356) {
x369 = true
x370 = x354
} else {
val x358 = x0(x354)
val x359 = x358 == '\n'
println("how many times!: "+x359)
var x364: Boolean = false
var x365: Int = 0
if (x359) {
val x360 = x354 + 1
x364 = false
x365 = x360
} else {
  println("ever in this branch???")
x364 = true
x365 = x354
}
x369 = x364
x370 = x365
}
var x375: Boolean = false
var x374: Anon1680061013 = null
var x376: Int = 0
if (x369) {
x375 = true
x374 = null
x376 = x239
} else {
x375 = false
x374 = x352
x376 = x370
}
x380 = x375
x379 = x374
x381 = x376
}
var x387: Boolean = false
var x386: Tuple2Anon1680061013Anon1680061013 = null
var x388: Int = 0
if (x380) {
x387 = true
x386 = null
x388 = x21
} else {
val x383 = new Tuple2Anon1680061013Anon1680061013(x237,x379)
x387 = false
x386 = x383
x388 = x381
}
x394 = x387
x393 = x386
x395 = x388
}
var x402: Unit = ()
var x404: Boolean = false
var x403: Tuple2Anon1680061013Anon1680061013 = null
if (x394) {
x402 = ()
x404 = true
x403 = null
} else {
val x398 = println("parsed a header")
x402 = ()
x404 = false
x403 = x393
}
val x741 = if (x404) {
x3 = false
()
} else {
val x408 = x6
val x409 = x7
val x410 = x8
val x411 = x9
val x412 = x10
val x414 = x12
val x415 = x13
val x417 = x403._1
val x420 = x417.length
val x422 = x420 == x421
val x451 = if (x422) {
var x425: Int = 0
var x426: Boolean = true
val x423 = x417.input
val x424 = x417.start
val x447 = while ({val x427 = x425
val x429 = x426
val x428 = x427 < x420
val x430 = x428 && x429
x430}) {
val x432 = x425
val x433 = x432 + x424
val x434 = x423(x433)
val x435 = x434.toInt
val x436 = x435 | 32
val x437 = x436.toChar
val x438 = x419(x432)
val x440 = x437 == x438
val x443 = if (x440) {
()
} else {
x426 = false
()
}
val x444 = x432 + 1
x425 = x444
()
}
val x448 = x426
x448
} else {
false
}
val x454 = x420 == x453
val x481 = if (x454) {
var x455: Int = 0
var x456: Boolean = true
val x423 = x417.input
val x424 = x417.start
val x477 = while ({val x457 = x455
val x459 = x456
val x458 = x457 < x420
val x460 = x458 && x459
x460}) {
val x462 = x455
val x463 = x462 + x424
val x464 = x423(x463)
val x465 = x464.toInt
val x466 = x465 | 32
val x467 = x466.toChar
val x468 = x452(x462)
val x470 = x467 == x468
val x473 = if (x470) {
()
} else {
x456 = false
()
}
val x474 = x462 + 1
x455 = x474
()
}
val x478 = x456
x478
} else {
false
}
val x482 = x451 || x481
val x418 = x403._2
val x484 = x418.length
val x486 = x484 == x485
val x515 = if (x486) {
var x489: Int = 0
var x490: Boolean = true
val x487 = x418.input
val x488 = x418.start
val x511 = while ({val x491 = x489
val x493 = x490
val x492 = x491 < x484
val x494 = x492 && x493
x494}) {
val x496 = x489
val x497 = x496 + x488
val x498 = x487(x497)
val x499 = x498.toInt
val x500 = x499 | 32
val x501 = x500.toChar
val x502 = x483(x496)
val x504 = x501 == x502
val x507 = if (x504) {
()
} else {
x490 = false
()
}
val x508 = x496 + 1
x489 = x508
()
}
val x512 = x490
x512
} else {
false
}
val x518 = x484 == x517
val x545 = if (x518) {
var x519: Int = 0
var x520: Boolean = true
val x487 = x418.input
val x488 = x418.start
val x541 = while ({val x521 = x519
val x523 = x520
val x522 = x521 < x484
val x524 = x522 && x523
x524}) {
val x526 = x519
val x527 = x526 + x488
val x528 = x487(x527)
val x529 = x528.toInt
val x530 = x529 | 32
val x531 = x530.toChar
val x532 = x516(x526)
val x534 = x531 == x532
val x537 = if (x534) {
()
} else {
x520 = false
()
}
val x538 = x526 + 1
x519 = x538
()
}
val x542 = x520
x542
} else {
false
}
val x546 = x515 || x545
val x547 = x482 && x546
var x725: Unit = ()
var x726: Int = 0
var x727: java.lang.String = null
var x728: Boolean = false
var x729: Boolean = false
if (x547) {
var x548: java.lang.String = ""
var x549: Int = 0
val x487 = x418.input
val x488 = x418.start
val x562 = while ({val x550 = x549
val x551 = x550 < x484
x551}) {
val x553 = x548
val x554 = x549
val x555 = x488 + x554
val x556 = x487(x555)
val x557 = x553+x556
x548 = x557
val x559 = x554 + 1
x549 = x559
()
}
val x563 = x548
x725 = ()
x726 = x409
x727 = x563
x728 = x411
x729 = x412
} else {
val x568 = x420 == x567
val x595 = if (x568) {
var x569: Int = 0
var x570: Boolean = true
val x423 = x417.input
val x424 = x417.start
val x591 = while ({val x571 = x569
val x573 = x570
val x572 = x571 < x420
val x574 = x572 && x573
x574}) {
val x576 = x569
val x577 = x576 + x424
val x578 = x423(x577)
val x579 = x578.toInt
val x580 = x579 | 32
val x581 = x580.toChar
val x582 = x566(x576)
val x584 = x581 == x582
val x587 = if (x584) {
()
} else {
x570 = false
()
}
val x588 = x576 + 1
x569 = x588
()
}
val x592 = x570
x592
} else {
false
}
var x717: Unit = ()
var x718: Int = 0
var x719: Boolean = false
var x720: Boolean = false
if (x595) {
var x597: java.lang.String = ""
var x598: Int = 0
val x487 = x418.input
val x488 = x418.start
val x611 = while ({val x599 = x598
val x600 = x599 < x484
x600}) {
val x602 = x597
val x603 = x598
val x604 = x488 + x603
val x605 = x487(x604)
val x606 = x602+x605
x597 = x606
val x608 = x603 + 1
x598 = x608
()
}
val x612 = x597
val x613 = x612.toInt
val x596 = println("adfadsfasfds")
x717 = ()
x718 = x613
x719 = x411
x720 = x412
} else {
val x618 = x420 == x617
val x645 = if (x618) {
var x619: Int = 0
var x620: Boolean = true
val x423 = x417.input
val x424 = x417.start
val x641 = while ({val x621 = x619
val x623 = x620
val x622 = x621 < x420
val x624 = x622 && x623
x624}) {
val x626 = x619
val x627 = x626 + x424
val x628 = x423(x627)
val x629 = x628.toInt
val x630 = x629 | 32
val x631 = x630.toChar
val x632 = x616(x626)
val x634 = x631 == x632
val x637 = if (x634) {
()
} else {
x620 = false
()
}
val x638 = x626 + 1
x619 = x638
()
}
val x642 = x620
x642
} else {
false
}
val x648 = x484 == x647
val x675 = if (x648) {
var x649: Int = 0
var x650: Boolean = true
val x487 = x418.input
val x488 = x418.start
val x671 = while ({val x651 = x649
val x653 = x650
val x652 = x651 < x484
val x654 = x652 && x653
x654}) {
val x656 = x649
val x657 = x656 + x488
val x658 = x487(x657)
val x659 = x658.toInt
val x660 = x659 | 32
val x661 = x660.toChar
val x662 = x646(x656)
val x664 = x661 == x662
val x667 = if (x664) {
()
} else {
x650 = false
()
}
val x668 = x656 + 1
x649 = x668
()
}
val x672 = x650
x672
} else {
false
}
val x676 = x645 && x675
var x713: Boolean = false
var x714: Boolean = false
if (x676) {
x713 = true
x714 = x412
} else {
val x680 = x420 == x679
val x707 = if (x680) {
var x681: Int = 0
var x682: Boolean = true
val x423 = x417.input
val x424 = x417.start
val x703 = while ({val x683 = x681
val x685 = x682
val x684 = x683 < x420
val x686 = x684 && x685
x686}) {
val x688 = x681
val x689 = x688 + x424
val x690 = x423(x689)
val x691 = x690.toInt
val x692 = x691 | 32
val x693 = x692.toChar
val x694 = x678(x688)
val x696 = x693 == x694
val x699 = if (x696) {
()
} else {
x682 = false
()
}
val x700 = x688 + 1
x681 = x700
()
}
val x704 = x682
x704
} else {
false
}
val x710 = if (x707) {
true
} else {
x412
}
x713 = x411
x714 = x710
}
x717 = ()
x718 = x409
x719 = x713
x720 = x714
}
x725 = ()
x726 = x718
x727 = x410
x728 = x719
x729 = x720
}
x6 = x408
x7 = x726
x8 = x727
x9 = x728
x10 = x729
x12 = false
x13 = x395
x4 = x395
()
}
x741
}
val x744 = x6
val x745 = x7
val x746 = x8
val x747 = x9
val x748 = x10
val x750 = x12
val x751 = x13
val x749 = new Anon1323431030(x744,x745,x746,x747,x748)
val x752 = new ParseResultAnon1323431030(x749,x750,x751)
val x753 = println(x752)
x753
}
}

case class Tuple2IntAnon1680061013(_1: Int, _2: Anon1680061013)

//case class Anon1323431030(status: Int, contentLength: Int, connection: java.lang.String, chunked: Boolean, upgrade: Boolean)

case class ParseResultTuple2Tuple2IntIntTuple2IntInt(res: Tuple2Tuple2IntIntTuple2IntInt, empty: Boolean, next: Int)

//case class Anon1680061013(input: Array[Char], start: Int, length: Int)

//case class ParseResultInt(res: Int, empty: Boolean, next: Int)

case class Tuple2Anon1680061013Anon1680061013(_1: Anon1680061013, _2: Anon1680061013)

//case class ParseResultAnon1323431030(res: Anon1323431030, empty: Boolean, next: Int)

case class Tuple2Tuple2IntIntTuple2IntInt(_1: Tuple2IntInt, _2: Tuple2IntInt)

case class Tuple2IntInt(_1: Int, _2: Int)