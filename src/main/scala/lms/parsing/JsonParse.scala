package lms.parsing

import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer

object TestJsonParse{
  val jsonparser = new JsonParse(
    "false".length,"false".toArray,
    "true".length,"true".toArray,
    "null".toArray,
    print = true
  )

  val fileNames = List(1,2,3,4,6).map{x=> "just_tweet"+x}

  val messages = fileNames.foldLeft(List[Array[Char]]()){case (acc, fileName) =>
    val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
    val out = new ArrayBuffer[Char]

    var line = file.readLine
    while(line != null){
      out ++= line + "\n"
      line = file.readLine
    }
    out.toArray :: acc
  }.map(_.toArray)

  def time(ns:Long,n:Int=2) = { val ms=ns/1000000; ("%"+(if (n==0)"" else n)+"d.%03d").format(ms/1000,ms%1000) }
  def ns[T](f:()=>T) = { val t0=System.nanoTime(); var r=f(); val t1=System.nanoTime(); (t1-t0,r) }

  def main(args:Array[String]){
    val N_LOOPS = 100
    val N_SAMPLES = 5

    (0 until N_SAMPLES).foreach { k =>
      val n = ns{()=>
        var i=0;
        while(i<N_LOOPS) {
          jsonparser.apply(messages(0))
          jsonparser.apply(messages(1))
          jsonparser.apply(messages(2))
          jsonparser.apply(messages(3))
          jsonparser.apply(messages(4))
          i=i+1;
        }
      }._1
      println("Time = "+time(n))
    }
  }
}

case class OptionChar(value: Char, defined: Boolean)
case class Tuple2OptionCharInt(_1: OptionChar, _2: Int)
case class Tuple2StringAnon6507737(_1: java.lang.String, _2: Anon6507737)
case class ParseResultAnon6507737(res: Anon6507737, empty: Boolean, next: Int)
case class Anon6507737(kind: Int, data: Any)
case class Tuple2Anon6507737ListAnon6507737(_1: Anon6507737, _2: scala.collection.immutable.List[Anon6507737])
case class ParseResultListAnon6507737(res: scala.collection.immutable.List[Anon6507737], empty: Boolean, next: Int)
case class Tuple2IntInt(_1: Int, _2: Int)
case class Tuple2OptionCharString(_1: OptionChar, _2: java.lang.String)


class JsonParse(
  px1804:Int,
  px1805:Array[Char],
  px1807:Int,px1808:Array[Char],
  px1926:Array[Char],
  print: Boolean
) extends ((Array[Char])=>(Unit)) with Serializable {
def apply(x0:Array[Char]): Unit = {
var x6: scala.Function1[Int, ParseResultAnon6507737] = null
var x3238: scala.Function1[Int, ParseResultAnon6507737] = null
var x3215: scala.Function1[Int, ParseResultAnon6507737] = null
var x1803: scala.Function1[Int, ParseResultAnon6507737] = null
var x1397: scala.Function1[Int, ParseResultAnon6507737] = null
var x1292: scala.Function1[Int, ParseResultListAnon6507737] = null
var x1272: scala.Function1[Int, ParseResultListAnon6507737] = null
var x1689: scala.Function1[Int, ParseResultListAnon6507737] = null
var x1669: scala.Function1[Int, ParseResultListAnon6507737] = null
x6 = {x7: (Int) =>
var x9: Anon6507737 = null
var x10: Boolean = true
var x11: Int = x7
val x3239 = x3238(x7)
val x3240 = x3239.res
x9 = x3240
val x3242 = x3239.empty
x10 = x3242
val x3244 = x3239.next
x11 = x3244
val x3246 = x9
val x3247 = x10
val x3248 = x11
val x3249 = new ParseResultAnon6507737(x3246,x3247,x3248)
x3249: ParseResultAnon6507737
}
val x25 = x0.length
val x207 = {x138: (Int) =>
var x140: java.lang.String = null
var x141: Boolean = true
var x142: Int = x138
val x144 = x138 >= x25
val x201 = if (x144) {
x140 = null
x141 = true
x142 = x138
()
} else {
val x150 = x0(x138)
val x151 = x150 == '\\'
val x199 = if (x151) {
val x152 = x138 + 1
val x154 = x152 >= x25
val x193 = if (x154) {
x140 = null
x141 = true
x142 = x152
()
} else {
val x161 = x0(x152)
val x162 = x161 == '\\'
val x163 = x161 == '\''
val x164 = x162 || x163
val x165 = x161 == '"'
val x166 = x164 || x165
val x167 = x161 == 'b'
val x168 = x166 || x167
val x169 = x161 == 'f'
val x170 = x168 || x169
val x171 = x161 == 'n'
val x172 = x170 || x171
val x173 = x161 == 'r'
val x174 = x172 || x173
val x175 = x161 == 't'
val x176 = x174 || x175
val x177 = x161 == '/'
val x178 = x176 || x177
val x191 = if (x178) {
val x181 = ""+x161
x140 = x181
x141 = false
val x179 = x152 + 1
x142 = x179
()
} else {
x140 = null
x141 = true
x142 = x152
()
}
x191
}
x193
} else {
x140 = null
x141 = true
x142 = x138
()
}
x199
}
val x202 = x140
val x203 = x141
val x204 = x142
val x205 = new ParseResultString(x202,x203,x204)
x205: ParseResultString
}
val x321 = {x132: (Int) =>
var x134: java.lang.String = null
var x135: Boolean = true
var x136: Int = x132
val x208 = x207(x132)
val x209 = x208.empty
val x315 = if (x209) {
val x210 = x132 >= x25
val x307 = if (x210) {
x134 = null
x135 = true
x136 = x132
()
} else {
val x216 = x0(x132)
val x217 = x216 == '\\'
val x305 = if (x217) {
val x218 = x132 + 1
val x220 = x218 >= x25
val x299 = if (x220) {
x134 = null
x135 = true
x136 = x132
()
} else {
val x226 = x0(x218)
val x227 = x226 == 'u'
val x297 = if (x227) {
var x231: java.lang.String = ""
var x232: Boolean = false
val x228 = x218 + 1
var x233: Int = x228
var x235: Int = -1
var x236: Boolean = true
var x237: Int = x228
var x238: Int = 0
val x284 = while ({val x239 = x238
val x241 = x235
val x242 = x237
val x245 = x236
val x240 = x239 < 4
val x243 = x241 != x242
val x244 = x240 && x243
val x246 = x244 && x245
x246}) {
val x248 = x237
x235 = x248
val x250 = x248 >= x25
val x282 = if (x250) {
x236 = false
()
} else {
val x254 = x0(x248)
val x255 = x254 >= '0'
val x256 = x254 <= '9'
val x257 = x255 && x256
val x258 = x254 >= 'A'
val x259 = x254 <= 'F'
val x260 = x258 && x259
val x261 = x257 || x260
val x280 = if (x261) {
val x264 = x231
val x265 = x232
val x266 = x233
val x268 = x264+x254
x231 = x268
x232 = false
val x262 = x248 + 1
x233 = x262
x237 = x262
val x274 = x238
val x275 = x274 + 1
x238 = x275
()
} else {
x236 = false
()
}
x280
}
x282
}
val x285 = x231
val x286 = x232
val x287 = x233
x134 = x285
x135 = x286
x136 = x287
()
} else {
x134 = null
x135 = true
x136 = x132
()
}
x297
}
x299
} else {
x134 = null
x135 = true
x136 = x132
()
}
x305
}
x307
} else {
val x309 = x208.res
x134 = x309
x135 = x209
val x312 = x208.next
x136 = x312
()
}
val x316 = x134
val x317 = x135
val x318 = x136
val x319 = new ParseResultString(x316,x317,x318)
x319: ParseResultString
}
val x346 = {x328: (Int) =>
var x330: java.lang.String = null
var x331: Boolean = true
var x332: Int = x328
val x334 = x321(x328)
val x335 = x334.res
x330 = x335
val x337 = x334.empty
x331 = x337
val x339 = x334.next
x332 = x339
val x341 = x330
val x342 = x331
val x343 = x332
val x344 = new ParseResultString(x341,x342,x343)
x344: ParseResultString
}
val x387 = {x322: (Int) =>
var x324: java.lang.String = null
var x325: Boolean = true
var x326: Int = x322
val x347 = x346(x322)
val x348 = x347.empty
val x381 = if (x348) {
val x349 = x322 >= x25
val x373 = if (x349) {
x324 = null
x325 = true
x326 = x322
()
} else {
val x355 = x0(x322)
val x356 = x355 != '"'
val x357 = x355 != '\\'
val x358 = x356 && x357
val x371 = if (x358) {
val x361 = ""+x355
x324 = x361
x325 = false
val x359 = x322 + 1
x326 = x359
()
} else {
x324 = null
x325 = true
x326 = x322
()
}
x371
}
x373
} else {
val x375 = x347.res
x324 = x375
x325 = x348
val x378 = x347.next
x326 = x378
()
}
val x382 = x324
val x383 = x325
val x384 = x326
val x385 = new ParseResultString(x382,x383,x384)
x385: ParseResultString
}
val x89 = List()
val x805 = {x736: (Int) =>
var x738: java.lang.String = null
var x739: Boolean = true
var x740: Int = x736
val x742 = x736 >= x25
val x799 = if (x742) {
x738 = null
x739 = true
x740 = x736
()
} else {
val x748 = x0(x736)
val x749 = x748 == '\\'
val x797 = if (x749) {
val x750 = x736 + 1
val x752 = x750 >= x25
val x791 = if (x752) {
x738 = null
x739 = true
x740 = x750
()
} else {
val x759 = x0(x750)
val x760 = x759 == '\\'
val x761 = x759 == '\''
val x762 = x760 || x761
val x763 = x759 == '"'
val x764 = x762 || x763
val x765 = x759 == 'b'
val x766 = x764 || x765
val x767 = x759 == 'f'
val x768 = x766 || x767
val x769 = x759 == 'n'
val x770 = x768 || x769
val x771 = x759 == 'r'
val x772 = x770 || x771
val x773 = x759 == 't'
val x774 = x772 || x773
val x775 = x759 == '/'
val x776 = x774 || x775
val x789 = if (x776) {
val x779 = ""+x759
x738 = x779
x739 = false
val x777 = x750 + 1
x740 = x777
()
} else {
x738 = null
x739 = true
x740 = x750
()
}
x789
}
x791
} else {
x738 = null
x739 = true
x740 = x736
()
}
x797
}
val x800 = x738
val x801 = x739
val x802 = x740
val x803 = new ParseResultString(x800,x801,x802)
x803: ParseResultString
}
val x919 = {x730: (Int) =>
var x732: java.lang.String = null
var x733: Boolean = true
var x734: Int = x730
val x806 = x805(x730)
val x807 = x806.empty
val x913 = if (x807) {
val x808 = x730 >= x25
val x905 = if (x808) {
x732 = null
x733 = true
x734 = x730
()
} else {
val x814 = x0(x730)
val x815 = x814 == '\\'
val x903 = if (x815) {
val x816 = x730 + 1
val x818 = x816 >= x25
val x897 = if (x818) {
x732 = null
x733 = true
x734 = x730
()
} else {
val x824 = x0(x816)
val x825 = x824 == 'u'
val x895 = if (x825) {
var x829: java.lang.String = ""
var x830: Boolean = false
val x826 = x816 + 1
var x831: Int = x826
var x833: Int = -1
var x834: Boolean = true
var x835: Int = x826
var x836: Int = 0
val x882 = while ({val x837 = x836
val x839 = x833
val x840 = x835
val x843 = x834
val x838 = x837 < 4
val x841 = x839 != x840
val x842 = x838 && x841
val x844 = x842 && x843
x844}) {
val x846 = x835
x833 = x846
val x848 = x846 >= x25
val x880 = if (x848) {
x834 = false
()
} else {
val x852 = x0(x846)
val x853 = x852 >= '0'
val x854 = x852 <= '9'
val x855 = x853 && x854
val x856 = x852 >= 'A'
val x857 = x852 <= 'F'
val x858 = x856 && x857
val x859 = x855 || x858
val x878 = if (x859) {
val x862 = x829
val x863 = x830
val x864 = x831
val x866 = x862+x852
x829 = x866
x830 = false
val x860 = x846 + 1
x831 = x860
x835 = x860
val x872 = x836
val x873 = x872 + 1
x836 = x873
()
} else {
x834 = false
()
}
x878
}
x880
}
val x883 = x829
val x884 = x830
val x885 = x831
x732 = x883
x733 = x884
x734 = x885
()
} else {
x732 = null
x733 = true
x734 = x730
()
}
x895
}
x897
} else {
x732 = null
x733 = true
x734 = x730
()
}
x903
}
x905
} else {
val x907 = x806.res
x732 = x907
x733 = x807
val x910 = x806.next
x734 = x910
()
}
val x914 = x732
val x915 = x733
val x916 = x734
val x917 = new ParseResultString(x914,x915,x916)
x917: ParseResultString
}
val x944 = {x926: (Int) =>
var x928: java.lang.String = null
var x929: Boolean = true
var x930: Int = x926
val x932 = x919(x926)
val x933 = x932.res
x928 = x933
val x935 = x932.empty
x929 = x935
val x937 = x932.next
x930 = x937
val x939 = x928
val x940 = x929
val x941 = x930
val x942 = new ParseResultString(x939,x940,x941)
x942: ParseResultString
}
val x985 = {x920: (Int) =>
var x922: java.lang.String = null
var x923: Boolean = true
var x924: Int = x920
val x945 = x944(x920)
val x946 = x945.empty
val x979 = if (x946) {
val x947 = x920 >= x25
val x971 = if (x947) {
x922 = null
x923 = true
x924 = x920
()
} else {
val x953 = x0(x920)
val x954 = x953 != '"'
val x955 = x953 != '\\'
val x956 = x954 && x955
val x969 = if (x956) {
val x959 = ""+x953
x922 = x959
x923 = false
val x957 = x920 + 1
x924 = x957
()
} else {
x922 = null
x923 = true
x924 = x920
()
}
x969
}
x971
} else {
val x973 = x945.res
x922 = x973
x923 = x946
val x976 = x945.next
x924 = x976
()
}
val x980 = x922
val x981 = x923
val x982 = x924
val x983 = new ParseResultString(x980,x981,x982)
x983: ParseResultString
}
x1272 = {x96: (Int) =>
var x98: scala.collection.immutable.List[Anon6507737] = null
var x99: Boolean = true
var x100: Int = x96
val x102 = x96 >= x25
val x1266 = if (x102) {
x98 = null
x99 = true
x100 = x96
()
} else {
val x112 = x0(x96)
val x113 = x112 == '"'
val x1264 = if (x113) {
var x117: java.lang.String = ""
var x118: Boolean = false
val x114 = x96 + 1
var x119: Int = x114
var x121: Int = -1
var x122: Boolean = true
var x123: Int = x114
val x407 = while ({val x124 = x122
val x125 = x121
val x126 = x123
val x127 = x125 != x126
val x128 = x124 && x127
x128}) {
val x130 = x123
x121 = x130
val x388 = x387(x130)
val x389 = x388.empty
val x405 = if (x389) {
x122 = false
()
} else {
val x392 = x117
val x393 = x118
val x394 = x119
val x396 = x388.res
val x397 = x392+x396
x117 = x397
x118 = false
val x398 = x388.next
x119 = x398
x123 = x398
()
}
x405
}
val x408 = x117
val x409 = x118
val x410 = x119
val x1258 = if (x409) {
x98 = null
x99 = true
x100 = x96
()
} else {
val x416 = x410 >= x25
val x1256 = if (x416) {
x98 = null
x99 = true
x100 = x96
()
} else {
val x422 = x0(x410)
val x423 = x422 == '"'
val x1254 = if (x423) {
var x428: java.lang.String = ""
var x429: Boolean = false
val x424 = x410 + 1
var x430: Int = x424
var x432: Int = -1
var x433: Boolean = true
var x434: Int = x424
val x469 = while ({val x435 = x433
val x436 = x432
val x437 = x434
val x438 = x436 != x437
val x439 = x435 && x438
x439}) {
val x441 = x434
x432 = x441
val x443 = x441 >= x25
val x467 = if (x443) {
x433 = false
()
} else {
val x447 = x0(x441)
val x448 = x447 == ' '
val x449 = x447 == '\n'
val x450 = x448 || x449
val x465 = if (x450) {
val x453 = x428
val x454 = x429
val x455 = x430
x428 = x453
x429 = false
val x451 = x441 + 1
x430 = x451
x434 = x451
()
} else {
x433 = false
()
}
x465
}
x467
}
val x470 = x428
val x471 = x429
val x472 = x430
val x1248 = if (x471) {
x98 = null
x99 = true
x100 = x96
()
} else {
val x478 = x472 >= x25
val x1246 = if (x478) {
x98 = null
x99 = true
x100 = x96
()
} else {
val x486 = x0(x472)
val x487 = x486 == ':'
val x1244 = if (x487) {
var x491: java.lang.String = ""
var x492: Boolean = false
val x488 = x472 + 1
var x493: Int = x488
var x495: Int = -1
var x496: Boolean = true
var x497: Int = x488
val x532 = while ({val x498 = x496
val x499 = x495
val x500 = x497
val x501 = x499 != x500
val x502 = x498 && x501
x502}) {
val x504 = x497
x495 = x504
val x506 = x504 >= x25
val x530 = if (x506) {
x496 = false
()
} else {
val x510 = x0(x504)
val x511 = x510 == ' '
val x512 = x510 == '\n'
val x513 = x511 || x512
val x528 = if (x513) {
val x516 = x491
val x517 = x492
val x518 = x493
x491 = x516
x492 = false
val x514 = x504 + 1
x493 = x514
x497 = x514
()
} else {
x496 = false
()
}
x528
}
x530
}
val x533 = x491
val x534 = x492
val x535 = x493
val x540 = if (x534) {
true
} else {
false
}
val x545 = if (x540) {
true
} else {
false
}
val x550 = if (x545) {
true
} else {
false
}
val x1238 = if (x550) {
x98 = null
x99 = true
x100 = x96
()
} else {
val x551 = if (x545) {
x96
} else {
val x546 = if (x540) {
x424
} else {
val x541 = if (x534) {
x472
} else {
x535
}
x541
}
x546
}
val x557 = x6(x551)
val x558 = x557.empty
val x564 = if (x558) {
true
} else {
false
}
val x571 = if (x564) {
true
} else {
false
}
val x1236 = if (x571) {
x98 = null
x99 = true
x100 = x96
()
} else {
var x579: scala.collection.immutable.List[Anon6507737] = x89
var x580: Boolean = false
val x565 = if (x558) {
x96
} else {
val x561 = x557.next
x561
}
val x572 = if (x564) {
x565
} else {
x565
}
var x581: Int = x572
var x583: Int = -1
var x584: Boolean = true
var x585: Int = x572
val x1212 = while ({val x586 = x584
val x587 = x583
val x588 = x585
val x589 = x587 != x588
val x590 = x586 && x589
x590}) {
val x592 = x585
x583 = x592
var x595: java.lang.String = ""
var x596: Boolean = false
var x597: Int = x592
var x599: Int = -1
var x600: Boolean = true
var x601: Int = x592
val x636 = while ({val x602 = x600
val x603 = x599
val x604 = x601
val x605 = x603 != x604
val x606 = x602 && x605
x606}) {
val x608 = x601
x599 = x608
val x610 = x608 >= x25
val x634 = if (x610) {
x600 = false
()
} else {
val x614 = x0(x608)
val x615 = x614 == ' '
val x616 = x614 == '\n'
val x617 = x615 || x616
val x632 = if (x617) {
val x620 = x595
val x621 = x596
val x622 = x597
x595 = x620
x596 = false
val x618 = x608 + 1
x597 = x618
x601 = x618
()
} else {
x600 = false
()
}
x632
}
x634
}
val x637 = x595
val x638 = x596
val x639 = x597
val x1210 = if (x638) {
x584 = false
()
} else {
val x646 = x639 >= x25
val x1208 = if (x646) {
x584 = false
()
} else {
val x650 = x0(x639)
val x651 = x650 == ','
val x1206 = if (x651) {
var x655: java.lang.String = ""
var x656: Boolean = false
val x652 = x639 + 1
var x657: Int = x652
var x659: Int = -1
var x660: Boolean = true
var x661: Int = x652
val x696 = while ({val x662 = x660
val x663 = x659
val x664 = x661
val x665 = x663 != x664
val x666 = x662 && x665
x666}) {
val x668 = x661
x659 = x668
val x670 = x668 >= x25
val x694 = if (x670) {
x660 = false
()
} else {
val x674 = x0(x668)
val x675 = x674 == ' '
val x676 = x674 == '\n'
val x677 = x675 || x676
val x692 = if (x677) {
val x680 = x655
val x681 = x656
val x682 = x657
x655 = x680
x656 = false
val x678 = x668 + 1
x657 = x678
x661 = x678
()
} else {
x660 = false
()
}
x692
}
x694
}
val x697 = x655
val x698 = x656
val x699 = x657
val x1202 = if (x698) {
x584 = false
()
} else {
val x703 = x699 >= x25
val x1200 = if (x703) {
x584 = false
()
} else {
val x710 = x0(x699)
val x711 = x710 == '"'
val x1198 = if (x711) {
var x715: java.lang.String = ""
var x716: Boolean = false
val x712 = x699 + 1
var x717: Int = x712
var x719: Int = -1
var x720: Boolean = true
var x721: Int = x712
val x1005 = while ({val x722 = x720
val x723 = x719
val x724 = x721
val x725 = x723 != x724
val x726 = x722 && x725
x726}) {
val x728 = x721
x719 = x728
val x986 = x985(x728)
val x987 = x986.empty
val x1003 = if (x987) {
x720 = false
()
} else {
val x990 = x715
val x991 = x716
val x992 = x717
val x994 = x986.res
val x995 = x990+x994
x715 = x995
x716 = false
val x996 = x986.next
x717 = x996
x721 = x996
()
}
x1003
}
val x1006 = x715
val x1007 = x716
val x1008 = x717
val x1194 = if (x1007) {
x584 = false
()
} else {
val x1012 = x1008 >= x25
val x1192 = if (x1012) {
x584 = false
()
} else {
val x1016 = x0(x1008)
val x1017 = x1016 == '"'
val x1190 = if (x1017) {
var x1022: java.lang.String = ""
var x1023: Boolean = false
val x1018 = x1008 + 1
var x1024: Int = x1018
var x1026: Int = -1
var x1027: Boolean = true
var x1028: Int = x1018
val x1063 = while ({val x1029 = x1027
val x1030 = x1026
val x1031 = x1028
val x1032 = x1030 != x1031
val x1033 = x1029 && x1032
x1033}) {
val x1035 = x1028
x1026 = x1035
val x1037 = x1035 >= x25
val x1061 = if (x1037) {
x1027 = false
()
} else {
val x1041 = x0(x1035)
val x1042 = x1041 == ' '
val x1043 = x1041 == '\n'
val x1044 = x1042 || x1043
val x1059 = if (x1044) {
val x1047 = x1022
val x1048 = x1023
val x1049 = x1024
x1022 = x1047
x1023 = false
val x1045 = x1035 + 1
x1024 = x1045
x1028 = x1045
()
} else {
x1027 = false
()
}
x1059
}
x1061
}
val x1064 = x1022
val x1065 = x1023
val x1066 = x1024
val x1186 = if (x1065) {
x584 = false
()
} else {
val x1070 = x1066 >= x25
val x1184 = if (x1070) {
x584 = false
()
} else {
val x1076 = x0(x1066)
val x1077 = x1076 == ':'
val x1182 = if (x1077) {
var x1081: java.lang.String = ""
var x1082: Boolean = false
val x1078 = x1066 + 1
var x1083: Int = x1078
var x1085: Int = -1
var x1086: Boolean = true
var x1087: Int = x1078
val x1122 = while ({val x1088 = x1086
val x1089 = x1085
val x1090 = x1087
val x1091 = x1089 != x1090
val x1092 = x1088 && x1091
x1092}) {
val x1094 = x1087
x1085 = x1094
val x1096 = x1094 >= x25
val x1120 = if (x1096) {
x1086 = false
()
} else {
val x1100 = x0(x1094)
val x1101 = x1100 == ' '
val x1102 = x1100 == '\n'
val x1103 = x1101 || x1102
val x1118 = if (x1103) {
val x1106 = x1081
val x1107 = x1082
val x1108 = x1083
x1081 = x1106
x1082 = false
val x1104 = x1094 + 1
x1083 = x1104
x1087 = x1104
()
} else {
x1086 = false
()
}
x1118
}
x1120
}
val x1123 = x1081
val x1124 = x1082
val x1125 = x1083
val x1130 = if (x1124) {
true
} else {
false
}
val x1135 = if (x1130) {
true
} else {
false
}
val x1140 = if (x1135) {
true
} else {
false
}
val x1178 = if (x1140) {
x584 = false
()
} else {
val x1141 = if (x1135) {
x699
} else {
val x1136 = if (x1130) {
x1018
} else {
val x1131 = if (x1124) {
x1066
} else {
x1125
}
x1131
}
x1136
}
val x1145 = x6(x1141)
val x1146 = x1145.empty
val x1152 = if (x1146) {
true
} else {
false
}
val x1159 = if (x1152) {
true
} else {
false
}
val x1176 = if (x1159) {
x584 = false
()
} else {
val x1164 = x579
val x1165 = x580
val x1166 = x581
val x1158 = if (x1152) {
null
} else {
val x1151 = if (x1146) {
null
} else {
val x1139 = if (x1135) {
null
} else {
x1006
}
val x1147 = x1145.res
val x1148 = new Tuple2StringAnon6507737(x1139,x1147)
x1148
}
val x1156 = new Anon6507737(7,x1151)
x1156
}
val x1168 = List(x1158)
val x1169 = x1164 ::: x1168
x579 = x1169
x580 = false
val x1153 = if (x1146) {
x699
} else {
val x1149 = x1145.next
x1149
}
val x1160 = if (x1152) {
x1153
} else {
x1153
}
x581 = x1160
x585 = x1160
()
}
x1176
}
x1178
} else {
x584 = false
()
}
x1182
}
x1184
}
x1186
} else {
x584 = false
()
}
x1190
}
x1192
}
x1194
} else {
x584 = false
()
}
x1198
}
x1200
}
x1202
} else {
x584 = false
()
}
x1206
}
x1208
}
x1210
}
val x1213 = x579
val x1214 = x580
val x1215 = x581
val x1220 = if (x1214) {
true
} else {
false
}
val x1228 = if (x1220) {
null
} else {
val x1219 = if (x1214) {
null
} else {
val x570 = if (x564) {
null
} else {
val x563 = if (x558) {
null
} else {
val x549 = if (x545) {
null
} else {
x408
}
val x559 = x557.res
val x560 = new Tuple2StringAnon6507737(x549,x559)
x560
}
val x568 = new Anon6507737(7,x563)
x568
}
val x1217 = new Tuple2Anon6507737ListAnon6507737(x570,x1213)
x1217
}
val x1224 = x1219._1
val x1225 = x1219._2
val x1226 = x1224 :: x1225
x1226
}
x98 = x1228
val x1229 = if (x1220) {
true
} else {
false
}
x99 = x1229
val x1221 = if (x1214) {
x96
} else {
x1215
}
val x1230 = if (x1220) {
x1221
} else {
x1221
}
x100 = x1230
()
}
x1236
}
x1238
} else {
x98 = null
x99 = true
x100 = x96
()
}
x1244
}
x1246
}
x1248
} else {
x98 = null
x99 = true
x100 = x96
()
}
x1254
}
x1256
}
x1258
} else {
x98 = null
x99 = true
x100 = x96
()
}
x1264
}
val x1267 = x98
val x1268 = x99
val x1269 = x100
val x1270 = new ParseResultListAnon6507737(x1267,x1268,x1269)
x1270: ParseResultListAnon6507737
}
x1292 = {x90: (Int) =>
var x92: scala.collection.immutable.List[Anon6507737] = null
var x93: Boolean = true
var x94: Int = x90
val x1273 = x1272(x90)
val x1274 = x1273.empty
val x1286 = if (x1274) {
x92 = x89
x93 = false
x94 = x90
()
} else {
val x1280 = x1273.res
x92 = x1280
x93 = x1274
val x1283 = x1273.next
x94 = x1283
()
}
val x1287 = x92
val x1288 = x93
val x1289 = x94
val x1290 = new ParseResultListAnon6507737(x1287,x1288,x1289)
x1290: ParseResultListAnon6507737
}
x1397 = {x19: (Int) =>
var x21: Anon6507737 = null
var x22: Boolean = true
var x23: Int = x19
val x26 = x19 >= x25
val x1391 = if (x26) {
x21 = null
x22 = true
x23 = x19
()
} else {
val x34 = x0(x19)
val x35 = x34 == '{'
val x1389 = if (x35) {
var x39: java.lang.String = ""
var x40: Boolean = false
val x36 = x19 + 1
var x41: Int = x36
var x43: Int = -1
var x44: Boolean = true
var x45: Int = x36
val x80 = while ({val x46 = x44
val x47 = x43
val x48 = x45
val x49 = x47 != x48
val x50 = x46 && x49
x50}) {
val x52 = x45
x43 = x52
val x54 = x52 >= x25
val x78 = if (x54) {
x44 = false
()
} else {
val x58 = x0(x52)
val x59 = x58 == ' '
val x60 = x58 == '\n'
val x61 = x59 || x60
val x76 = if (x61) {
val x64 = x39
val x65 = x40
val x66 = x41
x39 = x64
x40 = false
val x62 = x52 + 1
x41 = x62
x45 = x62
()
} else {
x44 = false
()
}
x76
}
x78
}
val x81 = x39
val x82 = x40
val x83 = x41
val x1383 = if (x82) {
x21 = null
x22 = true
x23 = x19
()
} else {
val x1293 = x1292(x83)
val x1294 = x1293.empty
val x1381 = if (x1294) {
x21 = null
x22 = true
val x1295 = x1293.next
x23 = x1295
()
} else {
var x1302: java.lang.String = ""
var x1303: Boolean = false
val x1295 = x1293.next
var x1304: Int = x1295
var x1306: Int = -1
var x1307: Boolean = true
var x1308: Int = x1295
val x1343 = while ({val x1309 = x1307
val x1310 = x1306
val x1311 = x1308
val x1312 = x1310 != x1311
val x1313 = x1309 && x1312
x1313}) {
val x1315 = x1308
x1306 = x1315
val x1317 = x1315 >= x25
val x1341 = if (x1317) {
x1307 = false
()
} else {
val x1321 = x0(x1315)
val x1322 = x1321 == ' '
val x1323 = x1321 == '\n'
val x1324 = x1322 || x1323
val x1339 = if (x1324) {
val x1327 = x1302
val x1328 = x1303
val x1329 = x1304
x1302 = x1327
x1303 = false
val x1325 = x1315 + 1
x1304 = x1325
x1308 = x1325
()
} else {
x1307 = false
()
}
x1339
}
x1341
}
val x1344 = x1302
val x1345 = x1303
val x1346 = x1304
val x1379 = if (x1345) {
x21 = null
x22 = true
x23 = x19
()
} else {
val x1353 = x1346 >= x25
val x1377 = if (x1353) {
x21 = null
x22 = true
x23 = x19
()
} else {
val x1359 = x0(x1346)
val x1360 = x1359 == '}'
val x1375 = if (x1360) {
val x1363 = x1293.res
val x1365 = new Anon6507737(8,x1363)
x21 = x1365
x22 = false
val x1361 = x1346 + 1
x23 = x1361
()
} else {
x21 = null
x22 = true
x23 = x19
()
}
x1375
}
x1377
}
x1379
}
x1381
}
x1383
} else {
x21 = null
x22 = true
x23 = x19
()
}
x1389
}
val x1392 = x21
val x1393 = x22
val x1394 = x23
val x1395 = new ParseResultAnon6507737(x1392,x1393,x1394)
x1395: ParseResultAnon6507737
}
x1669 = {x1469: (Int) =>
var x1471: scala.collection.immutable.List[Anon6507737] = null
var x1472: Boolean = true
var x1473: Int = x1469
val x1475 = x6(x1469)
val x1476 = x1475.empty
val x1663 = if (x1476) {
x1471 = null
x1472 = true
x1473 = x1469
()
} else {
var x1484: scala.collection.immutable.List[Anon6507737] = x89
var x1485: Boolean = false
val x1482 = x1475.next
var x1486: Int = x1482
var x1488: Int = -1
var x1489: Boolean = true
var x1490: Int = x1482
val x1638 = while ({val x1491 = x1489
val x1492 = x1488
val x1493 = x1490
val x1494 = x1492 != x1493
val x1495 = x1491 && x1494
x1495}) {
val x1497 = x1490
x1488 = x1497
var x1500: java.lang.String = ""
var x1501: Boolean = false
var x1502: Int = x1497
var x1504: Int = -1
var x1505: Boolean = true
var x1506: Int = x1497
val x1541 = while ({val x1507 = x1505
val x1508 = x1504
val x1509 = x1506
val x1510 = x1508 != x1509
val x1511 = x1507 && x1510
x1511}) {
val x1513 = x1506
x1504 = x1513
val x1515 = x1513 >= x25
val x1539 = if (x1515) {
x1505 = false
()
} else {
val x1519 = x0(x1513)
val x1520 = x1519 == ' '
val x1521 = x1519 == '\n'
val x1522 = x1520 || x1521
val x1537 = if (x1522) {
val x1525 = x1500
val x1526 = x1501
val x1527 = x1502
x1500 = x1525
x1501 = false
val x1523 = x1513 + 1
x1502 = x1523
x1506 = x1523
()
} else {
x1505 = false
()
}
x1537
}
x1539
}
val x1542 = x1500
val x1543 = x1501
val x1544 = x1502
val x1636 = if (x1543) {
x1489 = false
()
} else {
val x1551 = x1544 >= x25
val x1634 = if (x1551) {
x1489 = false
()
} else {
val x1555 = x0(x1544)
val x1556 = x1555 == ','
val x1632 = if (x1556) {
var x1560: java.lang.String = ""
var x1561: Boolean = false
val x1557 = x1544 + 1
var x1562: Int = x1557
var x1564: Int = -1
var x1565: Boolean = true
var x1566: Int = x1557
val x1601 = while ({val x1567 = x1565
val x1568 = x1564
val x1569 = x1566
val x1570 = x1568 != x1569
val x1571 = x1567 && x1570
x1571}) {
val x1573 = x1566
x1564 = x1573
val x1575 = x1573 >= x25
val x1599 = if (x1575) {
x1565 = false
()
} else {
val x1579 = x0(x1573)
val x1580 = x1579 == ' '
val x1581 = x1579 == '\n'
val x1582 = x1580 || x1581
val x1597 = if (x1582) {
val x1585 = x1560
val x1586 = x1561
val x1587 = x1562
x1560 = x1585
x1561 = false
val x1583 = x1573 + 1
x1562 = x1583
x1566 = x1583
()
} else {
x1565 = false
()
}
x1597
}
x1599
}
val x1602 = x1560
val x1603 = x1561
val x1604 = x1562
val x1628 = if (x1603) {
x1489 = false
()
} else {
val x1608 = x6(x1604)
val x1609 = x1608.empty
val x1626 = if (x1609) {
x1489 = false
()
} else {
val x1612 = x1484
val x1613 = x1485
val x1614 = x1486
val x1616 = x1608.res
val x1617 = List(x1616)
val x1618 = x1612 ::: x1617
x1484 = x1618
x1485 = false
val x1619 = x1608.next
x1486 = x1619
x1490 = x1619
()
}
x1626
}
x1628
} else {
x1489 = false
()
}
x1632
}
x1634
}
x1636
}
val x1639 = x1484
val x1640 = x1485
val x1641 = x1486
val x1647 = if (x1640) {
true
} else {
false
}
val x1655 = if (x1647) {
null
} else {
val x1646 = if (x1640) {
null
} else {
val x1643 = x1475.res
val x1644 = new Tuple2Anon6507737ListAnon6507737(x1643,x1639)
x1644
}
val x1651 = x1646._1
val x1652 = x1646._2
val x1653 = x1651 :: x1652
x1653
}
x1471 = x1655
val x1656 = if (x1647) {
true
} else {
false
}
x1472 = x1656
val x1648 = if (x1640) {
x1469
} else {
x1641
}
val x1657 = if (x1647) {
x1648
} else {
x1648
}
x1473 = x1657
()
}
val x1664 = x1471
val x1665 = x1472
val x1666 = x1473
val x1667 = new ParseResultListAnon6507737(x1664,x1665,x1666)
x1667: ParseResultListAnon6507737
}
x1689 = {x1463: (Int) =>
var x1465: scala.collection.immutable.List[Anon6507737] = null
var x1466: Boolean = true
var x1467: Int = x1463
val x1670 = x1669(x1463)
val x1671 = x1670.empty
val x1683 = if (x1671) {
x1465 = x89
x1466 = false
x1467 = x1463
()
} else {
val x1677 = x1670.res
x1465 = x1677
x1466 = x1671
val x1680 = x1670.next
x1467 = x1680
()
}
val x1684 = x1465
val x1685 = x1466
val x1686 = x1467
val x1687 = new ParseResultListAnon6507737(x1684,x1685,x1686)
x1687: ParseResultListAnon6507737
}
x1803 = {x13: (Int) =>
var x15: Anon6507737 = null
var x16: Boolean = true
var x17: Int = x13
val x1398 = x1397(x13)
val x1399 = x1398.empty
val x1797 = if (x1399) {
val x1400 = x13 >= x25
val x1789 = if (x1400) {
x15 = null
x16 = true
x17 = x13
()
} else {
val x1408 = x0(x13)
val x1409 = x1408 == '['
val x1787 = if (x1409) {
var x1413: java.lang.String = ""
var x1414: Boolean = false
val x1410 = x13 + 1
var x1415: Int = x1410
var x1417: Int = -1
var x1418: Boolean = true
var x1419: Int = x1410
val x1454 = while ({val x1420 = x1418
val x1421 = x1417
val x1422 = x1419
val x1423 = x1421 != x1422
val x1424 = x1420 && x1423
x1424}) {
val x1426 = x1419
x1417 = x1426
val x1428 = x1426 >= x25
val x1452 = if (x1428) {
x1418 = false
()
} else {
val x1432 = x0(x1426)
val x1433 = x1432 == ' '
val x1434 = x1432 == '\n'
val x1435 = x1433 || x1434
val x1450 = if (x1435) {
val x1438 = x1413
val x1439 = x1414
val x1440 = x1415
x1413 = x1438
x1414 = false
val x1436 = x1426 + 1
x1415 = x1436
x1419 = x1436
()
} else {
x1418 = false
()
}
x1450
}
x1452
}
val x1455 = x1413
val x1456 = x1414
val x1457 = x1415
val x1781 = if (x1456) {
x15 = null
x16 = true
x17 = x13
()
} else {
val x1690 = x1689(x1457)
val x1691 = x1690.empty
val x1779 = if (x1691) {
x15 = null
x16 = true
val x1692 = x1690.next
x17 = x1692
()
} else {
var x1699: java.lang.String = ""
var x1700: Boolean = false
val x1692 = x1690.next
var x1701: Int = x1692
var x1703: Int = -1
var x1704: Boolean = true
var x1705: Int = x1692
val x1740 = while ({val x1706 = x1704
val x1707 = x1703
val x1708 = x1705
val x1709 = x1707 != x1708
val x1710 = x1706 && x1709
x1710}) {
val x1712 = x1705
x1703 = x1712
val x1714 = x1712 >= x25
val x1738 = if (x1714) {
x1704 = false
()
} else {
val x1718 = x0(x1712)
val x1719 = x1718 == ' '
val x1720 = x1718 == '\n'
val x1721 = x1719 || x1720
val x1736 = if (x1721) {
val x1724 = x1699
val x1725 = x1700
val x1726 = x1701
x1699 = x1724
x1700 = false
val x1722 = x1712 + 1
x1701 = x1722
x1705 = x1722
()
} else {
x1704 = false
()
}
x1736
}
x1738
}
val x1741 = x1699
val x1742 = x1700
val x1743 = x1701
val x1777 = if (x1742) {
x15 = null
x16 = true
x17 = x13
()
} else {
val x1750 = x1743 >= x25
val x1775 = if (x1750) {
x15 = null
x16 = true
x17 = x13
()
} else {
val x1756 = x0(x1743)
val x1757 = x1756 == ']'
val x1773 = if (x1757) {
val x1760 = x1690.res
val x1762 = x1760.asInstanceOf[scala.collection.immutable.List[Anon6507737]]
val x1763 = new Anon6507737(6,x1762)
x15 = x1763
x16 = false
val x1758 = x1743 + 1
x17 = x1758
()
} else {
x15 = null
x16 = true
x17 = x13
()
}
x1773
}
x1775
}
x1777
}
x1779
}
x1781
} else {
x15 = null
x16 = true
x17 = x13
()
}
x1787
}
x1789
} else {
val x1791 = x1398.res
x15 = x1791
x16 = x1399
val x1794 = x1398.next
x17 = x1794
()
}
val x1798 = x15
val x1799 = x16
val x1800 = x17
val x1801 = new ParseResultAnon6507737(x1798,x1799,x1800)
x1801: ParseResultAnon6507737
}
x3215 = {x3197: (Int) =>
var x3199: Anon6507737 = null
var x3200: Boolean = true
var x3201: Int = x3197
val x3203 = x1803(x3197)
val x3204 = x3203.res
x3199 = x3204
val x3206 = x3203.empty
x3200 = x3206
val x3208 = x3203.next
x3201 = x3208
val x3210 = x3199
val x3211 = x3200
val x3212 = x3201
val x3213 = new ParseResultAnon6507737(x3210,x3211,x3212)
x3213: ParseResultAnon6507737
}
val x1804 = px1804 // static data: 5
val x1805 = px1805 // static data: Array(f,a,l,s,e)
val x1806 = new Anon6507737(1,null)
val x1868 = {x1816: (Int) =>
var x1818: Anon6507737 = null
var x1819: Boolean = true
var x1820: Int = x1816
val x1822 = x1816 + x1804
val x1823 = x1822 > x25
val x1862 = if (x1823) {
x1818 = null
x1819 = true
x1820 = x1816
()
} else {
var x1829: Int = 0
var x1830: Boolean = true
val x1848 = while ({val x1831 = x1830
val x1832 = x1829
val x1833 = x1832 < x1804
val x1834 = x1831 && x1833
x1834}) {
val x1836 = x1829
val x1837 = x1816 + x1836
val x1838 = x0(x1837)
val x1839 = x1805(x1836)
val x1841 = x1838 == x1839
val x1844 = if (x1841) {
()
} else {
x1830 = false
()
}
val x1845 = x1836 + 1
x1829 = x1845
()
}
val x1849 = x1830
val x1860 = if (x1849) {
x1818 = x1806
x1819 = false
x1820 = x1822
()
} else {
x1818 = null
x1819 = true
x1820 = x1816
()
}
x1860
}
val x1863 = x1818
val x1864 = x1819
val x1865 = x1820
val x1866 = new ParseResultAnon6507737(x1863,x1864,x1865)
x1866: ParseResultAnon6507737
}
val x1807 = px1807 // static data: 4
val x1808 = px1808 // static data: Array(t,r,u,e)
val x1809 = new Anon6507737(2,null)
val x1925 = {x1810: (Int) =>
var x1812: Anon6507737 = null
var x1813: Boolean = true
var x1814: Int = x1810
val x1869 = x1868(x1810)
val x1870 = x1869.empty
val x1919 = if (x1870) {
val x1871 = x1810 + x1807
val x1872 = x1871 > x25
val x1911 = if (x1872) {
x1812 = null
x1813 = true
x1814 = x1810
()
} else {
var x1878: Int = 0
var x1879: Boolean = true
val x1897 = while ({val x1880 = x1879
val x1881 = x1878
val x1882 = x1881 < x1807
val x1883 = x1880 && x1882
x1883}) {
val x1885 = x1878
val x1886 = x1810 + x1885
val x1887 = x0(x1886)
val x1888 = x1808(x1885)
val x1890 = x1887 == x1888
val x1893 = if (x1890) {
()
} else {
x1879 = false
()
}
val x1894 = x1885 + 1
x1878 = x1894
()
}
val x1898 = x1879
val x1909 = if (x1898) {
x1812 = x1809
x1813 = false
x1814 = x1871
()
} else {
x1812 = null
x1813 = true
x1814 = x1810
()
}
x1909
}
x1911
} else {
val x1913 = x1869.res
x1812 = x1913
x1813 = x1870
val x1916 = x1869.next
x1814 = x1916
()
}
val x1920 = x1812
val x1921 = x1813
val x1922 = x1814
val x1923 = new ParseResultAnon6507737(x1920,x1921,x1922)
x1923: ParseResultAnon6507737
}
val x1952 = {x1934: (Int) =>
var x1936: Anon6507737 = null
var x1937: Boolean = true
var x1938: Int = x1934
val x1940 = x1925(x1934)
val x1941 = x1940.res
x1936 = x1941
val x1943 = x1940.empty
x1937 = x1943
val x1945 = x1940.next
x1938 = x1945
val x1947 = x1936
val x1948 = x1937
val x1949 = x1938
val x1950 = new ParseResultAnon6507737(x1947,x1948,x1949)
x1950: ParseResultAnon6507737
}
val x1926 = px1926 // static data: Array(n,u,l,l)
val x1927 = new Anon6507737(0,null)
val x2009 = {x1928: (Int) =>
var x1930: Anon6507737 = null
var x1931: Boolean = true
var x1932: Int = x1928
val x1953 = x1952(x1928)
val x1954 = x1953.empty
val x2003 = if (x1954) {
val x1955 = x1928 + x1807
val x1956 = x1955 > x25
val x1995 = if (x1956) {
x1930 = null
x1931 = true
x1932 = x1928
()
} else {
var x1962: Int = 0
var x1963: Boolean = true
val x1981 = while ({val x1964 = x1963
val x1965 = x1962
val x1966 = x1965 < x1807
val x1967 = x1964 && x1966
x1967}) {
val x1969 = x1962
val x1970 = x1928 + x1969
val x1971 = x0(x1970)
val x1972 = x1926(x1969)
val x1974 = x1971 == x1972
val x1977 = if (x1974) {
()
} else {
x1963 = false
()
}
val x1978 = x1969 + 1
x1962 = x1978
()
}
val x1982 = x1963
val x1993 = if (x1982) {
x1930 = x1927
x1931 = false
x1932 = x1955
()
} else {
x1930 = null
x1931 = true
x1932 = x1928
()
}
x1993
}
x1995
} else {
val x1997 = x1953.res
x1930 = x1997
x1931 = x1954
val x2000 = x1953.next
x1932 = x2000
()
}
val x2004 = x1930
val x2005 = x1931
val x2006 = x1932
val x2007 = new ParseResultAnon6507737(x2004,x2005,x2006)
x2007: ParseResultAnon6507737
}
val x2034 = {x2016: (Int) =>
var x2018: Anon6507737 = null
var x2019: Boolean = true
var x2020: Int = x2016
val x2022 = x2009(x2016)
val x2023 = x2022.res
x2018 = x2023
val x2025 = x2022.empty
x2019 = x2025
val x2027 = x2022.next
x2020 = x2027
val x2029 = x2018
val x2030 = x2019
val x2031 = x2020
val x2032 = new ParseResultAnon6507737(x2029,x2030,x2031)
x2032: ParseResultAnon6507737
}
val x2039 = null.asInstanceOf[Char]
val x2040 = new OptionChar(x2039,false)
val x2540 = {x2010: (Int) =>
var x2012: Anon6507737 = null
var x2013: Boolean = true
var x2014: Int = x2010
val x2035 = x2034(x2010)
val x2036 = x2035.empty
val x2534 = if (x2036) {
val x2037 = x2010 >= x25
val x2526 = if (x2037) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2051 = x0(x2010)
val x2052 = x2051 == '-'
val x2524 = if (x2052) {
val x2053 = x2010 + 1
val x2057 = x2053 >= x25
val x2295 = if (x2057) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2065 = x0(x2053)
val x2066 = x2065 >= '0'
val x2067 = x2065 <= '9'
val x2068 = x2066 && x2067
val x2293 = if (x2068) {
var x2072: java.lang.String = ""
var x2073: Boolean = false
val x2069 = x2053 + 1
var x2074: Int = x2069
var x2076: Int = -1
var x2077: Boolean = true
var x2078: Int = x2069
val x2114 = while ({val x2079 = x2077
val x2080 = x2076
val x2081 = x2078
val x2082 = x2080 != x2081
val x2083 = x2079 && x2082
x2083}) {
val x2085 = x2078
x2076 = x2085
val x2087 = x2085 >= x25
val x2112 = if (x2087) {
x2077 = false
()
} else {
val x2091 = x0(x2085)
val x2092 = x2091 >= '0'
val x2093 = x2091 <= '9'
val x2094 = x2092 && x2093
val x2110 = if (x2094) {
val x2097 = x2072
val x2098 = x2073
val x2099 = x2074
val x2101 = x2097+x2091
x2072 = x2101
x2073 = false
val x2095 = x2085 + 1
x2074 = x2095
x2078 = x2095
()
} else {
x2077 = false
()
}
x2110
}
x2112
}
val x2115 = x2072
val x2116 = x2073
val x2117 = x2074
val x2122 = if (x2116) {
true
} else {
false
}
val x2131 = if (x2122) {
true
} else {
false
}
val x2137 = if (x2131) {
true
} else {
false
}
val x2149 = if (x2137) {
true
} else {
false
}
val x2287 = if (x2149) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2138 = if (x2131) {
x2010
} else {
val x2123 = if (x2116) {
x2053
} else {
x2117
}
val x2132 = if (x2122) {
x2123
} else {
x2123
}
x2132
}
val x2150 = if (x2137) {
x2138
} else {
x2138
}
val x2156 = x2150 >= x25
val x2285 = if (x2156) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2163 = x0(x2150)
val x2164 = x2163 == '.'
val x2283 = if (x2164) {
val x2165 = x2150 + 1
val x2167 = x2165 >= x25
val x2277 = if (x2167) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2175 = x0(x2165)
val x2176 = x2175 >= '0'
val x2177 = x2175 <= '9'
val x2178 = x2176 && x2177
val x2275 = if (x2178) {
var x2182: java.lang.String = ""
var x2183: Boolean = false
val x2179 = x2165 + 1
var x2184: Int = x2179
var x2186: Int = -1
var x2187: Boolean = true
var x2188: Int = x2179
val x2224 = while ({val x2189 = x2187
val x2190 = x2186
val x2191 = x2188
val x2192 = x2190 != x2191
val x2193 = x2189 && x2192
x2193}) {
val x2195 = x2188
x2186 = x2195
val x2197 = x2195 >= x25
val x2222 = if (x2197) {
x2187 = false
()
} else {
val x2201 = x0(x2195)
val x2202 = x2201 >= '0'
val x2203 = x2201 <= '9'
val x2204 = x2202 && x2203
val x2220 = if (x2204) {
val x2207 = x2182
val x2208 = x2183
val x2209 = x2184
val x2211 = x2207+x2201
x2182 = x2211
x2183 = false
val x2205 = x2195 + 1
x2184 = x2205
x2188 = x2205
()
} else {
x2187 = false
()
}
x2220
}
x2222
}
val x2225 = x2182
val x2226 = x2183
val x2227 = x2184
val x2232 = if (x2226) {
true
} else {
false
}
val x2241 = if (x2232) {
true
} else {
false
}
val x2247 = if (x2241) {
true
} else {
false
}
val x2257 = if (x2247) {
true
} else {
false
}
val x2263 = if (x2257) {
null
} else {
val x2256 = if (x2247) {
0.0
} else {
val x2246 = if (x2241) {
null
} else {
val x2148 = if (x2137) {
null
} else {
val x2136 = if (x2131) {
null
} else {
val x2055 = new OptionChar(x2051,true)
val x2130 = if (x2122) {
null
} else {
val x2121 = if (x2116) {
null
} else {
val x2119 = new Tuple2CharString(x2065,x2115)
x2119
}
val x2126 = x2121._1
val x2127 = x2121._2
val x2128 = x2126+x2127
x2128
}
val x2134 = new Tuple2OptionCharString(x2055,x2130)
x2134
}
val x2141 = x2136._1
val x2143 = x2141.defined
val x2146 = if (x2143) {
val x2142 = x2136._2
val x2144 = x2141.value
val x2145 = x2144+x2142
x2145
} else {
val x2142 = x2136._2
x2142
}
x2146
}
val x2240 = if (x2232) {
null
} else {
val x2231 = if (x2226) {
null
} else {
val x2229 = new Tuple2CharString(x2175,x2225)
x2229
}
val x2236 = x2231._1
val x2237 = x2231._2
val x2238 = x2236+x2237
x2238
}
val x2244 = new Tuple2StringString(x2148,x2240)
x2244
}
val x2251 = x2246._1
val x2252 = x2246._2
val x2253 = x2251+x2252
val x2254 = x2253.toDouble
x2254
}
val x2261 = new Anon6507737(4,x2256)
x2261
}
x2012 = x2263
val x2264 = if (x2257) {
true
} else {
false
}
x2013 = x2264
val x2248 = if (x2241) {
x2010
} else {
val x2233 = if (x2226) {
x2165
} else {
x2227
}
val x2242 = if (x2232) {
x2233
} else {
x2233
}
x2242
}
val x2258 = if (x2247) {
x2248
} else {
x2248
}
val x2265 = if (x2257) {
x2258
} else {
x2258
}
x2014 = x2265
()
} else {
x2012 = null
x2013 = true
x2014 = x2010
()
}
x2275
}
x2277
} else {
x2012 = null
x2013 = true
x2014 = x2010
()
}
x2283
}
x2285
}
x2287
} else {
x2012 = null
x2013 = true
x2014 = x2010
()
}
x2293
}
x2295
} else {
val x2297 = x2051 >= '0'
val x2298 = x2051 <= '9'
val x2299 = x2297 && x2298
val x2522 = if (x2299) {
var x2301: java.lang.String = ""
var x2302: Boolean = false
val x2053 = x2010 + 1
var x2303: Int = x2053
var x2305: Int = -1
var x2306: Boolean = true
var x2307: Int = x2053
val x2343 = while ({val x2308 = x2306
val x2309 = x2305
val x2310 = x2307
val x2311 = x2309 != x2310
val x2312 = x2308 && x2311
x2312}) {
val x2314 = x2307
x2305 = x2314
val x2316 = x2314 >= x25
val x2341 = if (x2316) {
x2306 = false
()
} else {
val x2320 = x0(x2314)
val x2321 = x2320 >= '0'
val x2322 = x2320 <= '9'
val x2323 = x2321 && x2322
val x2339 = if (x2323) {
val x2326 = x2301
val x2327 = x2302
val x2328 = x2303
val x2330 = x2326+x2320
x2301 = x2330
x2302 = false
val x2324 = x2314 + 1
x2303 = x2324
x2307 = x2324
()
} else {
x2306 = false
()
}
x2339
}
x2341
}
val x2344 = x2301
val x2345 = x2302
val x2346 = x2303
val x2351 = if (x2345) {
true
} else {
false
}
val x2360 = if (x2351) {
true
} else {
false
}
val x2366 = if (x2360) {
true
} else {
false
}
val x2378 = if (x2366) {
true
} else {
false
}
val x2516 = if (x2378) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2367 = if (x2360) {
x2010
} else {
val x2352 = if (x2345) {
x2010
} else {
x2346
}
val x2361 = if (x2351) {
x2352
} else {
x2352
}
x2361
}
val x2379 = if (x2366) {
x2367
} else {
x2367
}
val x2385 = x2379 >= x25
val x2514 = if (x2385) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2392 = x0(x2379)
val x2393 = x2392 == '.'
val x2512 = if (x2393) {
val x2394 = x2379 + 1
val x2396 = x2394 >= x25
val x2506 = if (x2396) {
x2012 = null
x2013 = true
x2014 = x2010
()
} else {
val x2404 = x0(x2394)
val x2405 = x2404 >= '0'
val x2406 = x2404 <= '9'
val x2407 = x2405 && x2406
val x2504 = if (x2407) {
var x2411: java.lang.String = ""
var x2412: Boolean = false
val x2408 = x2394 + 1
var x2413: Int = x2408
var x2415: Int = -1
var x2416: Boolean = true
var x2417: Int = x2408
val x2453 = while ({val x2418 = x2416
val x2419 = x2415
val x2420 = x2417
val x2421 = x2419 != x2420
val x2422 = x2418 && x2421
x2422}) {
val x2424 = x2417
x2415 = x2424
val x2426 = x2424 >= x25
val x2451 = if (x2426) {
x2416 = false
()
} else {
val x2430 = x0(x2424)
val x2431 = x2430 >= '0'
val x2432 = x2430 <= '9'
val x2433 = x2431 && x2432
val x2449 = if (x2433) {
val x2436 = x2411
val x2437 = x2412
val x2438 = x2413
val x2440 = x2436+x2430
x2411 = x2440
x2412 = false
val x2434 = x2424 + 1
x2413 = x2434
x2417 = x2434
()
} else {
x2416 = false
()
}
x2449
}
x2451
}
val x2454 = x2411
val x2455 = x2412
val x2456 = x2413
val x2461 = if (x2455) {
true
} else {
false
}
val x2470 = if (x2461) {
true
} else {
false
}
val x2476 = if (x2470) {
true
} else {
false
}
val x2486 = if (x2476) {
true
} else {
false
}
val x2492 = if (x2486) {
null
} else {
val x2485 = if (x2476) {
0.0
} else {
val x2475 = if (x2470) {
null
} else {
val x2377 = if (x2366) {
null
} else {
val x2365 = if (x2360) {
null
} else {
val x2359 = if (x2351) {
null
} else {
val x2350 = if (x2345) {
null
} else {
val x2348 = new Tuple2CharString(x2051,x2344)
x2348
}
val x2355 = x2350._1
val x2356 = x2350._2
val x2357 = x2355+x2356
x2357
}
val x2363 = new Tuple2OptionCharString(x2040,x2359)
x2363
}
val x2370 = x2365._1
val x2372 = x2370.defined
val x2375 = if (x2372) {
val x2371 = x2365._2
val x2373 = x2370.value
val x2374 = x2373+x2371
x2374
} else {
val x2371 = x2365._2
x2371
}
x2375
}
val x2469 = if (x2461) {
null
} else {
val x2460 = if (x2455) {
null
} else {
val x2458 = new Tuple2CharString(x2404,x2454)
x2458
}
val x2465 = x2460._1
val x2466 = x2460._2
val x2467 = x2465+x2466
x2467
}
val x2473 = new Tuple2StringString(x2377,x2469)
x2473
}
val x2480 = x2475._1
val x2481 = x2475._2
val x2482 = x2480+x2481
val x2483 = x2482.toDouble
x2483
}
val x2490 = new Anon6507737(4,x2485)
x2490
}
x2012 = x2492
val x2493 = if (x2486) {
true
} else {
false
}
x2013 = x2493
val x2477 = if (x2470) {
x2010
} else {
val x2462 = if (x2455) {
x2394
} else {
x2456
}
val x2471 = if (x2461) {
x2462
} else {
x2462
}
x2471
}
val x2487 = if (x2476) {
x2477
} else {
x2477
}
val x2494 = if (x2486) {
x2487
} else {
x2487
}
x2014 = x2494
()
} else {
x2012 = null
x2013 = true
x2014 = x2010
()
}
x2504
}
x2506
} else {
x2012 = null
x2013 = true
x2014 = x2010
()
}
x2512
}
x2514
}
x2516
} else {
x2012 = null
x2013 = true
x2014 = x2010
()
}
x2522
}
x2524
}
x2526
} else {
val x2528 = x2035.res
x2012 = x2528
x2013 = x2036
val x2531 = x2035.next
x2014 = x2531
()
}
val x2535 = x2012
val x2536 = x2013
val x2537 = x2014
val x2538 = new ParseResultAnon6507737(x2535,x2536,x2537)
x2538: ParseResultAnon6507737
}
val x2565 = {x2547: (Int) =>
var x2549: Anon6507737 = null
var x2550: Boolean = true
var x2551: Int = x2547
val x2553 = x2540(x2547)
val x2554 = x2553.res
x2549 = x2554
val x2556 = x2553.empty
x2550 = x2556
val x2558 = x2553.next
x2551 = x2558
val x2560 = x2549
val x2561 = x2550
val x2562 = x2551
val x2563 = new ParseResultAnon6507737(x2560,x2561,x2562)
x2563: ParseResultAnon6507737
}
val x2803 = {x2541: (Int) =>
var x2543: Anon6507737 = null
var x2544: Boolean = true
var x2545: Int = x2541
val x2566 = x2565(x2541)
val x2567 = x2566.empty
val x2797 = if (x2567) {
val x2568 = x2541 >= x25
val x2789 = if (x2568) {
x2543 = null
x2544 = true
x2545 = x2541
()
} else {
val x2577 = x0(x2541)
val x2578 = x2577 == '-'
val x2787 = if (x2578) {
val x2579 = x2541 + 1
val x2583 = x2579 >= x25
val x2689 = if (x2583) {
x2543 = null
x2544 = true
x2545 = x2541
()
} else {
val x2590 = x0(x2579)
val x2591 = x2590 >= '0'
val x2592 = x2590 <= '9'
val x2593 = x2591 && x2592
val x2687 = if (x2593) {
val x2596 = x2590 - '0'
val x2597 = x2596.toInt
var x2599: Int = x2597
var x2600: Boolean = false
val x2594 = x2579 + 1
var x2601: Int = x2594
var x2603: Int = -1
var x2604: Boolean = true
var x2605: Int = x2594
val x2646 = while ({val x2606 = x2604
val x2607 = x2603
val x2608 = x2605
val x2609 = x2607 != x2608
val x2610 = x2606 && x2609
x2610}) {
val x2612 = x2605
x2603 = x2612
val x2614 = x2612 >= x25
val x2644 = if (x2614) {
x2604 = false
()
} else {
val x2619 = x0(x2612)
val x2620 = x2619 >= '0'
val x2621 = x2619 <= '9'
val x2622 = x2620 && x2621
val x2642 = if (x2622) {
val x2628 = x2599
val x2629 = x2600
val x2630 = x2601
val x2625 = x2619 - '0'
val x2626 = x2625.toInt
val x2632 = x2628 * 10
val x2633 = x2632 + x2626
x2599 = x2633
x2600 = false
val x2623 = x2612 + 1
x2601 = x2623
x2605 = x2623
()
} else {
x2604 = false
()
}
x2642
}
x2644
}
val x2647 = x2599
val x2648 = x2600
val x2649 = x2601
val x2652 = if (x2648) {
true
} else {
x2648
}
val x2658 = if (x2652) {
true
} else {
false
}
val x2669 = if (x2658) {
true
} else {
false
}
val x2675 = if (x2669) {
null
} else {
val x2668 = if (x2658) {
0
} else {
val x2657 = if (x2652) {
null
} else {
val x2581 = new OptionChar(x2577,true)
val x2651 = if (x2648) {
0
} else {
x2647
}
val x2655 = new Tuple2OptionCharInt(x2581,x2651)
x2655
}
val x2662 = x2657._1
val x2664 = x2662.defined
val x2666 = if (x2664) {
val x2663 = x2657._2
val x2665 = -1 * x2663
x2665
} else {
val x2663 = x2657._2
x2663
}
x2666
}
val x2673 = new Anon6507737(3,x2668)
x2673
}
x2543 = x2675
val x2676 = if (x2669) {
true
} else {
false
}
x2544 = x2676
val x2659 = if (x2652) {
x2541
} else {
val x2653 = if (x2648) {
x2579
} else {
x2649
}
x2653
}
val x2670 = if (x2658) {
x2659
} else {
x2659
}
val x2677 = if (x2669) {
x2670
} else {
x2670
}
x2545 = x2677
()
} else {
x2543 = null
x2544 = true
x2545 = x2541
()
}
x2687
}
x2689
} else {
val x2691 = x2577 >= '0'
val x2692 = x2577 <= '9'
val x2693 = x2691 && x2692
val x2785 = if (x2693) {
val x2694 = x2577 - '0'
val x2695 = x2694.toInt
var x2697: Int = x2695
var x2698: Boolean = false
val x2579 = x2541 + 1
var x2699: Int = x2579
var x2701: Int = -1
var x2702: Boolean = true
var x2703: Int = x2579
val x2744 = while ({val x2704 = x2702
val x2705 = x2701
val x2706 = x2703
val x2707 = x2705 != x2706
val x2708 = x2704 && x2707
x2708}) {
val x2710 = x2703
x2701 = x2710
val x2712 = x2710 >= x25
val x2742 = if (x2712) {
x2702 = false
()
} else {
val x2717 = x0(x2710)
val x2718 = x2717 >= '0'
val x2719 = x2717 <= '9'
val x2720 = x2718 && x2719
val x2740 = if (x2720) {
val x2726 = x2697
val x2727 = x2698
val x2728 = x2699
val x2723 = x2717 - '0'
val x2724 = x2723.toInt
val x2730 = x2726 * 10
val x2731 = x2730 + x2724
x2697 = x2731
x2698 = false
val x2721 = x2710 + 1
x2699 = x2721
x2703 = x2721
()
} else {
x2702 = false
()
}
x2740
}
x2742
}
val x2745 = x2697
val x2746 = x2698
val x2747 = x2699
val x2750 = if (x2746) {
true
} else {
x2746
}
val x2756 = if (x2750) {
true
} else {
false
}
val x2767 = if (x2756) {
true
} else {
false
}
val x2773 = if (x2767) {
null
} else {
val x2766 = if (x2756) {
0
} else {
val x2755 = if (x2750) {
null
} else {
val x2749 = if (x2746) {
0
} else {
x2745
}
val x2753 = new Tuple2OptionCharInt(x2040,x2749)
x2753
}
val x2760 = x2755._1
val x2762 = x2760.defined
val x2764 = if (x2762) {
val x2761 = x2755._2
val x2763 = -1 * x2761
x2763
} else {
val x2761 = x2755._2
x2761
}
x2764
}
val x2771 = new Anon6507737(3,x2766)
x2771
}
x2543 = x2773
val x2774 = if (x2767) {
true
} else {
false
}
x2544 = x2774
val x2757 = if (x2750) {
x2541
} else {
val x2751 = if (x2746) {
x2541
} else {
x2747
}
x2751
}
val x2768 = if (x2756) {
x2757
} else {
x2757
}
val x2775 = if (x2767) {
x2768
} else {
x2768
}
x2545 = x2775
()
} else {
x2543 = null
x2544 = true
x2545 = x2541
()
}
x2785
}
x2787
}
x2789
} else {
val x2791 = x2566.res
x2543 = x2791
x2544 = x2567
val x2794 = x2566.next
x2545 = x2794
()
}
val x2798 = x2543
val x2799 = x2544
val x2800 = x2545
val x2801 = new ParseResultAnon6507737(x2798,x2799,x2800)
x2801: ParseResultAnon6507737
}
val x2828 = {x2810: (Int) =>
var x2812: Anon6507737 = null
var x2813: Boolean = true
var x2814: Int = x2810
val x2816 = x2803(x2810)
val x2817 = x2816.res
x2812 = x2817
val x2819 = x2816.empty
x2813 = x2819
val x2821 = x2816.next
x2814 = x2821
val x2823 = x2812
val x2824 = x2813
val x2825 = x2814
val x2826 = new ParseResultAnon6507737(x2823,x2824,x2825)
x2826: ParseResultAnon6507737
}
val x2933 = {x2864: (Int) =>
var x2866: java.lang.String = null
var x2867: Boolean = true
var x2868: Int = x2864
val x2870 = x2864 >= x25
val x2927 = if (x2870) {
x2866 = null
x2867 = true
x2868 = x2864
()
} else {
val x2876 = x0(x2864)
val x2877 = x2876 == '\\'
val x2925 = if (x2877) {
val x2878 = x2864 + 1
val x2880 = x2878 >= x25
val x2919 = if (x2880) {
x2866 = null
x2867 = true
x2868 = x2878
()
} else {
val x2887 = x0(x2878)
val x2888 = x2887 == '\\'
val x2889 = x2887 == '\''
val x2890 = x2888 || x2889
val x2891 = x2887 == '"'
val x2892 = x2890 || x2891
val x2893 = x2887 == 'b'
val x2894 = x2892 || x2893
val x2895 = x2887 == 'f'
val x2896 = x2894 || x2895
val x2897 = x2887 == 'n'
val x2898 = x2896 || x2897
val x2899 = x2887 == 'r'
val x2900 = x2898 || x2899
val x2901 = x2887 == 't'
val x2902 = x2900 || x2901
val x2903 = x2887 == '/'
val x2904 = x2902 || x2903
val x2917 = if (x2904) {
val x2907 = ""+x2887
x2866 = x2907
x2867 = false
val x2905 = x2878 + 1
x2868 = x2905
()
} else {
x2866 = null
x2867 = true
x2868 = x2878
()
}
x2917
}
x2919
} else {
x2866 = null
x2867 = true
x2868 = x2864
()
}
x2925
}
val x2928 = x2866
val x2929 = x2867
val x2930 = x2868
val x2931 = new ParseResultString(x2928,x2929,x2930)
x2931: ParseResultString
}
val x3047 = {x2858: (Int) =>
var x2860: java.lang.String = null
var x2861: Boolean = true
var x2862: Int = x2858
val x2934 = x2933(x2858)
val x2935 = x2934.empty
val x3041 = if (x2935) {
val x2936 = x2858 >= x25
val x3033 = if (x2936) {
x2860 = null
x2861 = true
x2862 = x2858
()
} else {
val x2942 = x0(x2858)
val x2943 = x2942 == '\\'
val x3031 = if (x2943) {
val x2944 = x2858 + 1
val x2946 = x2944 >= x25
val x3025 = if (x2946) {
x2860 = null
x2861 = true
x2862 = x2858
()
} else {
val x2952 = x0(x2944)
val x2953 = x2952 == 'u'
val x3023 = if (x2953) {
var x2957: java.lang.String = ""
var x2958: Boolean = false
val x2954 = x2944 + 1
var x2959: Int = x2954
var x2961: Int = -1
var x2962: Boolean = true
var x2963: Int = x2954
var x2964: Int = 0
val x3010 = while ({val x2965 = x2964
val x2967 = x2961
val x2968 = x2963
val x2971 = x2962
val x2966 = x2965 < 4
val x2969 = x2967 != x2968
val x2970 = x2966 && x2969
val x2972 = x2970 && x2971
x2972}) {
val x2974 = x2963
x2961 = x2974
val x2976 = x2974 >= x25
val x3008 = if (x2976) {
x2962 = false
()
} else {
val x2980 = x0(x2974)
val x2981 = x2980 >= '0'
val x2982 = x2980 <= '9'
val x2983 = x2981 && x2982
val x2984 = x2980 >= 'A'
val x2985 = x2980 <= 'F'
val x2986 = x2984 && x2985
val x2987 = x2983 || x2986
val x3006 = if (x2987) {
val x2990 = x2957
val x2991 = x2958
val x2992 = x2959
val x2994 = x2990+x2980
x2957 = x2994
x2958 = false
val x2988 = x2974 + 1
x2959 = x2988
x2963 = x2988
val x3000 = x2964
val x3001 = x3000 + 1
x2964 = x3001
()
} else {
x2962 = false
()
}
x3006
}
x3008
}
val x3011 = x2957
val x3012 = x2958
val x3013 = x2959
x2860 = x3011
x2861 = x3012
x2862 = x3013
()
} else {
x2860 = null
x2861 = true
x2862 = x2858
()
}
x3023
}
x3025
} else {
x2860 = null
x2861 = true
x2862 = x2858
()
}
x3031
}
x3033
} else {
val x3035 = x2934.res
x2860 = x3035
x2861 = x2935
val x3038 = x2934.next
x2862 = x3038
()
}
val x3042 = x2860
val x3043 = x2861
val x3044 = x2862
val x3045 = new ParseResultString(x3042,x3043,x3044)
x3045: ParseResultString
}
val x3072 = {x3054: (Int) =>
var x3056: java.lang.String = null
var x3057: Boolean = true
var x3058: Int = x3054
val x3060 = x3047(x3054)
val x3061 = x3060.res
x3056 = x3061
val x3063 = x3060.empty
x3057 = x3063
val x3065 = x3060.next
x3058 = x3065
val x3067 = x3056
val x3068 = x3057
val x3069 = x3058
val x3070 = new ParseResultString(x3067,x3068,x3069)
x3070: ParseResultString
}
val x3113 = {x3048: (Int) =>
var x3050: java.lang.String = null
var x3051: Boolean = true
var x3052: Int = x3048
val x3073 = x3072(x3048)
val x3074 = x3073.empty
val x3107 = if (x3074) {
val x3075 = x3048 >= x25
val x3099 = if (x3075) {
x3050 = null
x3051 = true
x3052 = x3048
()
} else {
val x3081 = x0(x3048)
val x3082 = x3081 != '"'
val x3083 = x3081 != '\\'
val x3084 = x3082 && x3083
val x3097 = if (x3084) {
val x3087 = ""+x3081
x3050 = x3087
x3051 = false
val x3085 = x3048 + 1
x3052 = x3085
()
} else {
x3050 = null
x3051 = true
x3052 = x3048
()
}
x3097
}
x3099
} else {
val x3101 = x3073.res
x3050 = x3101
x3051 = x3074
val x3104 = x3073.next
x3052 = x3104
()
}
val x3108 = x3050
val x3109 = x3051
val x3110 = x3052
val x3111 = new ParseResultString(x3108,x3109,x3110)
x3111: ParseResultString
}
val x3190 = {x2804: (Int) =>
var x2806: Anon6507737 = null
var x2807: Boolean = true
var x2808: Int = x2804
val x2829 = x2828(x2804)
val x2830 = x2829.empty
val x3184 = if (x2830) {
val x2831 = x2804 >= x25
val x3176 = if (x2831) {
x2806 = null
x2807 = true
x2808 = x2804
()
} else {
val x2838 = x0(x2804)
val x2839 = x2838 == '"'
val x3174 = if (x2839) {
var x2843: java.lang.String = ""
var x2844: Boolean = false
val x2840 = x2804 + 1
var x2845: Int = x2840
var x2847: Int = -1
var x2848: Boolean = true
var x2849: Int = x2840
val x3133 = while ({val x2850 = x2848
val x2851 = x2847
val x2852 = x2849
val x2853 = x2851 != x2852
val x2854 = x2850 && x2853
x2854}) {
val x2856 = x2849
x2847 = x2856
val x3114 = x3113(x2856)
val x3115 = x3114.empty
val x3131 = if (x3115) {
x2848 = false
()
} else {
val x3118 = x2843
val x3119 = x2844
val x3120 = x2845
val x3122 = x3114.res
val x3123 = x3118+x3122
x2843 = x3123
x2844 = false
val x3124 = x3114.next
x2845 = x3124
x2849 = x3124
()
}
x3131
}
val x3134 = x2843
val x3135 = x2844
val x3136 = x2845
val x3168 = if (x3135) {
x2806 = null
x2807 = true
x2808 = x3136
()
} else {
val x3143 = x3136 >= x25
val x3166 = if (x3143) {
x2806 = null
x2807 = true
x2808 = x2804
()
} else {
val x3149 = x0(x3136)
val x3150 = x3149 == '"'
val x3164 = if (x3150) {
val x3154 = new Anon6507737(5,x3134)
x2806 = x3154
x2807 = false
val x3151 = x3136 + 1
x2808 = x3151
()
} else {
x2806 = null
x2807 = true
x2808 = x2804
()
}
x3164
}
x3166
}
x3168
} else {
x2806 = null
x2807 = true
x2808 = x2804
()
}
x3174
}
x3176
} else {
val x3178 = x2829.res
x2806 = x3178
x2807 = x2830
val x3181 = x2829.next
x2808 = x3181
()
}
val x3185 = x2806
val x3186 = x2807
val x3187 = x2808
val x3188 = new ParseResultAnon6507737(x3185,x3186,x3187)
x3188: ParseResultAnon6507737
}
x3238 = {x3191: (Int) =>
var x3193: Anon6507737 = null
var x3194: Boolean = true
var x3195: Int = x3191
val x3216 = x3215(x3191)
val x3217 = x3216.empty
val x3232 = if (x3217) {
val x3218 = x3190(x3191)
val x3219 = x3218.res
x3193 = x3219
val x3221 = x3218.empty
x3194 = x3221
val x3223 = x3218.next
x3195 = x3223
()
} else {
val x3226 = x3216.res
x3193 = x3226
x3194 = x3217
val x3229 = x3216.next
x3195 = x3229
()
}
val x3233 = x3193
val x3234 = x3194
val x3235 = x3195
val x3236 = new ParseResultAnon6507737(x3233,x3234,x3235)
x3236: ParseResultAnon6507737
}
var x2: Anon6507737 = null
var x3: Boolean = true
var x4: Int = -1
val x3251 = x6(0)
val x3252 = x3251.res
x2 = x3252
val x3254 = x3251.empty
x3 = x3254
val x3256 = x3251.next
x4 = x3256
val x3258 = x2
val x3259 = x3
val x3260 = x4
val x3261 = new ParseResultAnon6507737(x3258,x3259,x3260)
if(print){
//val x3262 = println(x3261)
//x3262
()
} else {()}
}
}