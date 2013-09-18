package lms.parsing

object TestResponseBis{
  def main(args: Array[String]){

    val resp =
    """|HTTP/1.1 200 OK
       |cache-control: no-cache, no-store, must-revalidate, pre-check=0, post-check=0
       |content-length: 2
       |content-type: application/json;charset=utf-8
       |date: Tue, 03 Sep 2013 19:10:56 GMT
       |expires: Tue, 31 Mar 1981 05:00:00 GMT
       |last-modified: Tue, 03 Sep 2013 19:10:56 GMT
       |pragma: no-cache
       |server: tfe
       |set-cookie: lang=en
       |set-cookie: guest_id=v1%3A137823545658205848; Domain=.twitter.com; Path=/; Expires=Thu, 03-Sep-2015 19:10:56 UTC
       |status: 200 OK
       |x-access-level: read
       |x-frame-options: SAMEORIGIN
       |x-rate-limit-limit: 180
       |x-rate-limit-remaining: 179
       |x-rate-limit-reset: 1378236356
       |x-transaction: 7c742b402f213b9d
       |
       |AA
       |""".stripMargin

    new ResponseParseBis().apply(resp.toArray)
  }
}
/*****************************************
  Emitting Generated Code
*******************************************/
class ResponseParseBis extends ((Array[Char])=>(Unit)) with Serializable{
def apply(x0:Array[Char]): Unit = {
val x1 = null.asInstanceOf[Anon1323431030]
var x3: Anon1323431030 = x1
var x4: Boolean = true
var x5: Int = -1
val x20 = x0.length
val x90 = 0 >= x20
val x1195 = if (x90) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x93 = x0(0)
val x94 = x93 == 'H'
val x1193 = if (x94) {
val x95 = 0 + 1
val x115 = x95 >= x20
val x1187 = if (x115) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x117 = x0(x95)
val x118 = x117 == 'T'
val x1185 = if (x118) {
val x119 = x95 + 1
val x127 = x119 >= x20
val x1179 = if (x127) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x129 = x0(x119)
val x130 = x129 == 'T'
val x1177 = if (x130) {
val x131 = x119 + 1
val x140 = x131 >= x20
val x1171 = if (x140) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x142 = x0(x131)
val x143 = x142 == 'P'
val x1169 = if (x143) {
val x144 = x131 + 1
val x153 = x144 >= x20
val x1163 = if (x153) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x155 = x0(x144)
val x156 = x155 == '/'
val x1161 = if (x156) {
var x188: Int = 0
var x189: Boolean = false
val x157 = x144 + 1
var x190: Int = x157
var x192: Int = -1
var x193: Boolean = true
var x194: Int = x157
val x235 = while ({val x195 = x193
val x196 = x192
val x197 = x194
val x198 = x196 != x197
val x199 = x195 && x198
x199}) {
val x201 = x194
x192 = x201
val x203 = x201 >= x20
val x233 = if (x203) {
x193 = false
()
} else {
val x205 = x0(x201)
val x206 = x205 >= '0'
val x207 = x205 <= '9'
val x208 = x206 && x207
val x231 = if (x208) {
val x217 = x188
val x218 = x189
val x219 = x190
val x214 = x205 - '0'
val x215 = x214.toInt
val x221 = x217 * 10
val x222 = x221 + x215
x188 = x222
x189 = false
val x209 = x201 + 1
x190 = x209
x194 = x209
()
} else {
x193 = false
()
}
x231
}
x233
}
val x236 = x188
val x237 = x189
val x238 = x190
val x1155 = if (x237) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x242 = x238 >= x20
val x1153 = if (x242) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x244 = x0(x238)
val x245 = x244 == '.'
val x1151 = if (x245) {
var x258: Int = 0
var x259: Boolean = false
val x246 = x238 + 1
var x260: Int = x246
var x262: Int = -1
var x263: Boolean = true
var x264: Int = x246
val x305 = while ({val x265 = x263
val x266 = x262
val x267 = x264
val x268 = x266 != x267
val x269 = x265 && x268
x269}) {
val x271 = x264
x262 = x271
val x273 = x271 >= x20
val x303 = if (x273) {
x263 = false
()
} else {
val x275 = x0(x271)
val x276 = x275 >= '0'
val x277 = x275 <= '9'
val x278 = x276 && x277
val x301 = if (x278) {
val x287 = x258
val x288 = x259
val x289 = x260
val x284 = x275 - '0'
val x285 = x284.toInt
val x291 = x287 * 10
val x292 = x291 + x285
x258 = x292
x259 = false
val x279 = x271 + 1
x260 = x279
x264 = x279
()
} else {
x263 = false
()
}
x301
}
x303
}
val x306 = x258
val x307 = x259
val x308 = x260
val x313 = if (x307) {
true
} else {
false
}
val x319 = if (x313) {
true
} else {
false
}
val x1145 = if (x319) {
x3 = x1
x4 = true
x5 = 0
()
} else {
var x327: java.lang.String = ""
var x328: Boolean = false
val x320 = if (x313) {
0
} else {
val x314 = if (x307) {
x157
} else {
x308
}
x314
}
var x329: Int = x320
var x331: Int = -1
var x332: Boolean = true
var x333: Int = x320
val x366 = while ({val x334 = x332
val x335 = x331
val x336 = x333
val x337 = x335 != x336
val x338 = x334 && x337
x338}) {
val x340 = x333
x331 = x340
val x342 = x340 >= x20
val x364 = if (x342) {
x332 = false
()
} else {
val x344 = x0(x340)
val x345 = x344 == ' '
val x362 = if (x345) {
val x350 = x327
val x351 = x328
val x352 = x329
x327 = x350
x328 = false
val x346 = x340 + 1
x329 = x346
x333 = x346
()
} else {
x332 = false
()
}
x362
}
x364
}
val x367 = x327
val x368 = x328
val x369 = x329
val x374 = if (x368) {
true
} else {
false
}
val x1143 = if (x374) {
x3 = x1
x4 = true
x5 = 0
()
} else {
var x382: Int = 0
var x383: Boolean = false
val x375 = if (x368) {
0
} else {
x369
}
var x384: Int = x375
var x386: Int = -1
var x387: Boolean = true
var x388: Int = x375
val x429 = while ({val x389 = x387
val x390 = x386
val x391 = x388
val x392 = x390 != x391
val x393 = x389 && x392
x393}) {
val x395 = x388
x386 = x395
val x397 = x395 >= x20
val x427 = if (x397) {
x387 = false
()
} else {
val x399 = x0(x395)
val x400 = x399 >= '0'
val x401 = x399 <= '9'
val x402 = x400 && x401
val x425 = if (x402) {
val x411 = x382
val x412 = x383
val x413 = x384
val x408 = x399 - '0'
val x409 = x408.toInt
val x415 = x411 * 10
val x416 = x415 + x409
x382 = x416
x383 = false
val x403 = x395 + 1
x384 = x403
x388 = x403
()
} else {
x387 = false
()
}
x425
}
x427
}
val x430 = x382
val x431 = x383
val x432 = x384
val x1141 = if (x431) {
x3 = x1
x4 = true
x5 = 0
()
} else {
var x439: Int = 0
var x440: Boolean = false
var x441: Int = x432
var x443: Int = -1
var x444: Boolean = true
var x445: Int = x432
val x480 = while ({val x446 = x444
val x447 = x443
val x448 = x445
val x449 = x447 != x448
val x450 = x446 && x449
x450}) {
val x452 = x445
x443 = x452
val x454 = x452 >= x20
val x478 = if (x454) {
x444 = false
()
} else {
val x456 = x0(x452)
val x462 = x456 == '
'
val x476 = if (x462) {
x444 = false
()
} else {
val x465 = x439
val x466 = x440
val x467 = x441
val x469 = x465 + 1
x439 = x469
x440 = false
val x458 = x452 + 1
x441 = x458
x445 = x458
()
}
x476
}
x478
}
val x481 = x439
val x482 = x440
val x483 = x441
val x489 = x483 >= x20
val x1139 = if (x489) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x491 = x0(x483)
val x492 = x491 == '
'
val x1137 = if (x492) {
var x503: Int = 200
var x504: Int = 0
var x505: java.lang.String = "close"
var x506: Boolean = false
var x507: Boolean = false
var x509: Boolean = false
val x493 = x483 + 1
var x510: Int = x493
var x512: Int = -1
var x513: Boolean = true
var x514: Int = x493
val x8 = null.asInstanceOf[Int]
val x52 = {x14: (Int) =>
var x16: Int = x8
var x17: Boolean = true
var x18: Int = x14
val x21 = x14 >= x20
val x46 = if (x21) {
x16 = x8
x17 = true
x18 = x14
()
} else {
val x22 = x0(x14)
val x23 = x22 >= 'a'
val x24 = x22 <= 'z'
val x25 = x23 && x24
val x26 = x22 >= 'A'
val x27 = x22 <= 'Z'
val x28 = x26 && x27
val x29 = x25 || x28
val x44 = if (x29) {
x16 = x14
x17 = false
val x30 = x14 + 1
x18 = x30
()
} else {
x16 = x8
x17 = true
x18 = x14
()
}
x44
}
val x47 = x16
val x48 = x17
val x49 = x18
val x50 = new ParseResultInt(x47,x48,x49)
x50
}
val x88 = {x7: (Int) =>
var x10: Int = x8
var x11: Boolean = true
var x12: Int = x7
val x53 = x52(x7)
val x54 = x53.empty
val x82 = if (x54) {
val x55 = x7 >= x20
val x74 = if (x55) {
x10 = x8
x11 = true
x12 = x7
()
} else {
val x56 = x0(x7)
val x57 = x56 == '-'
val x72 = if (x57) {
x10 = x7
x11 = false
val x58 = x7 + 1
x12 = x58
()
} else {
x10 = x8
x11 = true
x12 = x7
()
}
x72
}
x74
} else {
val x76 = x53.res
x10 = x76
x11 = x54
val x79 = x53.next
x12 = x79
()
}
val x83 = x10
val x84 = x11
val x85 = x12
val x86 = new ParseResultInt(x83,x84,x85)
x86
}
val x777 = Array('c','o','n','n','e','c','t','i','o','n')
val x778 = x777.length
val x803 = Array('p','r','o','x','y','-','c','o','n','n','e','c','t','i','o','n')
val x804 = x803.length
val x830 = Array('k','e','e','p','-','a','l','i','v','e')
val x831 = x830.length
val x856 = Array('c','l','o','s','e')
val x857 = x856.length
val x902 = Array('c','o','n','t','e','n','t','-','l','e','n','g','t','h')
val x903 = x902.length
val x947 = Array('t','r','a','n','s','f','e','r','-','e','n','c','o','d','i','n','g')
val x948 = x947.length
val x973 = Array('c','h','u','n','k','e','d')
val x974 = x973.length
val x1001 = Array('u','p','g','r','a','d','e')
val x1002 = x1001.length
val x1079 = while ({val x515 = x513
val x516 = x512
val x517 = x514
val x518 = x516 != x517
val x519 = x515 && x518
x519}) {
val x521 = x514
x512 = x521
val x523 = x521 >= x20
val x1077 = if (x523) {
x513 = false
()
} else {
val x525 = x0(x521)
val x526 = x525 >= 'a'
val x527 = x525 <= 'z'
val x528 = x526 && x527
val x529 = x525 >= 'A'
val x530 = x525 <= 'Z'
val x531 = x529 && x530
val x532 = x528 || x531
val x1075 = if (x532) {
var x542: Int = 0
var x543: Boolean = false
val x533 = x521 + 1
var x544: Int = x533
var x546: Int = -1
var x547: Boolean = true
var x548: Int = x533
val x575 = while ({val x549 = x547
val x550 = x546
val x551 = x548
val x552 = x550 != x551
val x553 = x549 && x552
x553}) {
val x555 = x548
x546 = x555
val x557 = x88(x555)
val x558 = x557.empty
val x573 = if (x558) {
x547 = false
()
} else {
val x561 = x542
val x562 = x543
val x563 = x544
val x565 = x561 + 1
x542 = x565
x543 = false
val x566 = x557.next
x544 = x566
x548 = x566
()
}
x573
}
val x576 = x542
val x577 = x543
val x578 = x544
var x588: java.lang.String = ""
var x589: Boolean = false
var x590: Int = x578
var x592: Int = -1
var x593: Boolean = true
var x594: Int = x578
val x627 = while ({val x595 = x593
val x596 = x592
val x597 = x594
val x598 = x596 != x597
val x599 = x595 && x598
x599}) {
val x601 = x594
x592 = x601
val x603 = x601 >= x20
val x625 = if (x603) {
x593 = false
()
} else {
val x605 = x0(x601)
val x606 = x605 == ' '
val x623 = if (x606) {
val x611 = x588
val x612 = x589
val x613 = x590
x588 = x611
x589 = false
val x607 = x601 + 1
x590 = x607
x594 = x607
()
} else {
x593 = false
()
}
x623
}
x625
}
val x628 = x588
val x629 = x589
val x630 = x590
val x1071 = if (x629) {
x513 = false
()
} else {
val x634 = x630 >= x20
val x1069 = if (x634) {
x513 = false
()
} else {
val x636 = x0(x630)
val x637 = x636 == ':'
val x1067 = if (x637) {
var x655: java.lang.String = ""
var x656: Boolean = false
val x638 = x630 + 1
var x657: Int = x638
var x659: Int = -1
var x660: Boolean = true
var x661: Int = x638
val x694 = while ({val x662 = x660
val x663 = x659
val x664 = x661
val x665 = x663 != x664
val x666 = x662 && x665
x666}) {
val x668 = x661
x659 = x668
val x670 = x668 >= x20
val x692 = if (x670) {
x660 = false
()
} else {
val x672 = x0(x668)
val x673 = x672 == ' '
val x690 = if (x673) {
val x678 = x655
val x679 = x656
val x680 = x657
x655 = x678
x656 = false
val x674 = x668 + 1
x657 = x674
x661 = x674
()
} else {
x660 = false
()
}
x690
}
x692
}
val x695 = x655
val x696 = x656
val x697 = x657
val x1063 = if (x696) {
x513 = false
()
} else {
var x709: Int = 0
var x710: Boolean = false
var x711: Int = x697
var x713: Int = -1
var x714: Boolean = true
var x715: Int = x697
val x750 = while ({val x716 = x714
val x717 = x713
val x718 = x715
val x719 = x717 != x718
val x720 = x716 && x719
x720}) {
val x722 = x715
x713 = x722
val x724 = x722 >= x20
val x748 = if (x724) {
x714 = false
()
} else {
val x726 = x0(x722)
val x732 = x726 == '
'
val x746 = if (x732) {
x714 = false
()
} else {
val x735 = x709
val x736 = x710
val x737 = x711
val x739 = x735 + 1
x709 = x739
x710 = false
val x728 = x722 + 1
x711 = x728
x715 = x728
()
}
x746
}
x748
}
val x751 = x709
val x752 = x710
val x753 = x711
val x757 = x753 >= x20
val x1061 = if (x757) {
x513 = false
()
} else {
val x759 = x0(x753)
val x760 = x759 == '
'
val x1059 = if (x760) {
val x768 = x503
val x769 = x504
val x770 = x505
val x771 = x506
val x772 = x507
val x774 = x509
val x775 = x510
val x584 = x576 + 1
val x779 = x584 == x778
val x802 = if (x779) {
var x780: Int = 0
var x781: Boolean = true
val x799 = while ({val x782 = x780
val x784 = x781
val x783 = x782 < x584
val x785 = x783 && x784
x785}) {
val x787 = x780
val x788 = x787 + x521
val x789 = x0(x788)
val x790 = x777(x787)
val x792 = x789 == x790
val x795 = if (x792) {
()
} else {
x781 = false
()
}
val x796 = x787 + 1
x780 = x796
()
}
val x800 = x781
x800
} else {
false
}
val x805 = x584 == x804
val x828 = if (x805) {
var x806: Int = 0
var x807: Boolean = true
val x825 = while ({val x808 = x806
val x810 = x807
val x809 = x808 < x584
val x811 = x809 && x810
x811}) {
val x813 = x806
val x814 = x813 + x521
val x815 = x0(x814)
val x816 = x803(x813)
val x818 = x815 == x816
val x821 = if (x818) {
()
} else {
x807 = false
()
}
val x822 = x813 + 1
x806 = x822
()
}
val x826 = x807
x826
} else {
false
}
val x829 = x802 || x828
val x832 = x751 == x831
val x855 = if (x832) {
var x833: Int = 0
var x834: Boolean = true
val x852 = while ({val x835 = x833
val x837 = x834
val x836 = x835 < x751
val x838 = x836 && x837
x838}) {
val x840 = x833
val x841 = x840 + x697
val x842 = x0(x841)
val x843 = x830(x840)
val x845 = x842 == x843
val x848 = if (x845) {
()
} else {
x834 = false
()
}
val x849 = x840 + 1
x833 = x849
()
}
val x853 = x834
x853
} else {
false
}
val x858 = x751 == x857
val x881 = if (x858) {
var x859: Int = 0
var x860: Boolean = true
val x878 = while ({val x861 = x859
val x863 = x860
val x862 = x861 < x751
val x864 = x862 && x863
x864}) {
val x866 = x859
val x867 = x866 + x697
val x868 = x0(x867)
val x869 = x856(x866)
val x871 = x868 == x869
val x874 = if (x871) {
()
} else {
x860 = false
()
}
val x875 = x866 + 1
x859 = x875
()
}
val x879 = x860
x879
} else {
false
}
val x882 = x855 || x881
val x883 = x829 && x882
val x1041 = if (x883) {
var x884: java.lang.String = ""
var x885: Int = 0
val x898 = while ({val x886 = x885
val x887 = x886 < x751
x887}) {
val x889 = x884
val x890 = x885
val x891 = x697 + x890
val x892 = x0(x891)
val x893 = x889+x892
x884 = x893
val x895 = x890 + 1
x885 = x895
()
}
val x899 = x884
val x900 = new Anon1323431030(x768,x769,x899,x771,x772)
x900
} else {
val x904 = x584 == x903
val x927 = if (x904) {
var x905: Int = 0
var x906: Boolean = true
val x924 = while ({val x907 = x905
val x909 = x906
val x908 = x907 < x584
val x910 = x908 && x909
x910}) {
val x912 = x905
val x913 = x912 + x521
val x914 = x0(x913)
val x915 = x902(x912)
val x917 = x914 == x915
val x920 = if (x917) {
()
} else {
x906 = false
()
}
val x921 = x912 + 1
x905 = x921
()
}
val x925 = x906
x925
} else {
false
}
val x1040 = if (x927) {
var x928: java.lang.String = ""
var x929: Int = 0
val x942 = while ({val x930 = x929
val x931 = x930 < x751
x931}) {
val x933 = x928
val x934 = x929
val x935 = x697 + x934
val x936 = x0(x935)
val x937 = x933+x936
x928 = x937
val x939 = x934 + 1
x929 = x939
()
}
val x943 = x928
val x944 = x943.toInt
val x945 = new Anon1323431030(x768,x944,x770,x771,x772)
x945
} else {
val x949 = x584 == x948
val x972 = if (x949) {
var x950: Int = 0
var x951: Boolean = true
val x969 = while ({val x952 = x950
val x954 = x951
val x953 = x952 < x584
val x955 = x953 && x954
x955}) {
val x957 = x950
val x958 = x957 + x521
val x959 = x0(x958)
val x960 = x947(x957)
val x962 = x959 == x960
val x965 = if (x962) {
()
} else {
x951 = false
()
}
val x966 = x957 + 1
x950 = x966
()
}
val x970 = x951
x970
} else {
false
}
val x975 = x751 == x974
val x998 = if (x975) {
var x976: Int = 0
var x977: Boolean = true
val x995 = while ({val x978 = x976
val x980 = x977
val x979 = x978 < x751
val x981 = x979 && x980
x981}) {
val x983 = x976
val x984 = x983 + x697
val x985 = x0(x984)
val x986 = x973(x983)
val x988 = x985 == x986
val x991 = if (x988) {
()
} else {
x977 = false
()
}
val x992 = x983 + 1
x976 = x992
()
}
val x996 = x977
x996
} else {
false
}
val x999 = x972 && x998
val x1034 = if (x999) {
x768
} else {
val x1003 = x584 == x1002
val x1026 = if (x1003) {
var x1004: Int = 0
var x1005: Boolean = true
val x1023 = while ({val x1006 = x1004
val x1008 = x1005
val x1007 = x1006 < x584
val x1009 = x1007 && x1008
x1009}) {
val x1011 = x1004
val x1012 = x1011 + x521
val x1013 = x0(x1012)
val x1014 = x1001(x1011)
val x1016 = x1013 == x1014
val x1019 = if (x1016) {
()
} else {
x1005 = false
()
}
val x1020 = x1011 + 1
x1004 = x1020
()
}
val x1024 = x1005
x1024
} else {
false
}
val x1028 = if (x1026) {
x768
} else {
x768
}
x1028
}
val x1035 = if (x999) {
x769
} else {
val x1003 = x584 == x1002
val x1026 = if (x1003) {
var x1004: Int = 0
var x1005: Boolean = true
val x1023 = while ({val x1006 = x1004
val x1008 = x1005
val x1007 = x1006 < x584
val x1009 = x1007 && x1008
x1009}) {
val x1011 = x1004
val x1012 = x1011 + x521
val x1013 = x0(x1012)
val x1014 = x1001(x1011)
val x1016 = x1013 == x1014
val x1019 = if (x1016) {
()
} else {
x1005 = false
()
}
val x1020 = x1011 + 1
x1004 = x1020
()
}
val x1024 = x1005
x1024
} else {
false
}
val x1029 = if (x1026) {
x769
} else {
x769
}
x1029
}
val x1036 = if (x999) {
x770
} else {
val x1003 = x584 == x1002
val x1026 = if (x1003) {
var x1004: Int = 0
var x1005: Boolean = true
val x1023 = while ({val x1006 = x1004
val x1008 = x1005
val x1007 = x1006 < x584
val x1009 = x1007 && x1008
x1009}) {
val x1011 = x1004
val x1012 = x1011 + x521
val x1013 = x0(x1012)
val x1014 = x1001(x1011)
val x1016 = x1013 == x1014
val x1019 = if (x1016) {
()
} else {
x1005 = false
()
}
val x1020 = x1011 + 1
x1004 = x1020
()
}
val x1024 = x1005
x1024
} else {
false
}
val x1030 = if (x1026) {
x770
} else {
x770
}
x1030
}
val x1037 = if (x999) {
true
} else {
val x1003 = x584 == x1002
val x1026 = if (x1003) {
var x1004: Int = 0
var x1005: Boolean = true
val x1023 = while ({val x1006 = x1004
val x1008 = x1005
val x1007 = x1006 < x584
val x1009 = x1007 && x1008
x1009}) {
val x1011 = x1004
val x1012 = x1011 + x521
val x1013 = x0(x1012)
val x1014 = x1001(x1011)
val x1016 = x1013 == x1014
val x1019 = if (x1016) {
()
} else {
x1005 = false
()
}
val x1020 = x1011 + 1
x1004 = x1020
()
}
val x1024 = x1005
x1024
} else {
false
}
val x1031 = if (x1026) {
x771
} else {
x771
}
x1031
}
val x1038 = if (x999) {
x772
} else {
val x1003 = x584 == x1002
val x1026 = if (x1003) {
var x1004: Int = 0
var x1005: Boolean = true
val x1023 = while ({val x1006 = x1004
val x1008 = x1005
val x1007 = x1006 < x584
val x1009 = x1007 && x1008
x1009}) {
val x1011 = x1004
val x1012 = x1011 + x521
val x1013 = x0(x1012)
val x1014 = x1001(x1011)
val x1016 = x1013 == x1014
val x1019 = if (x1016) {
()
} else {
x1005 = false
()
}
val x1020 = x1011 + 1
x1004 = x1020
()
}
val x1024 = x1005
x1024
} else {
false
}
val x1032 = if (x1026) {
true
} else {
x772
}
x1032
}
val x1039 = new Anon1323431030(x1034,x1035,x1036,x1037,x1038)
x1039
}
x1040
}
val x1043 = x1041.status
x503 = x1043
val x1045 = x1041.contentLength
x504 = x1045
val x1047 = x1041.connection
x505 = x1047
val x1049 = x1041.chunked
x506 = x1049
val x1051 = x1041.upgrade
x507 = x1051
x509 = false
val x761 = x753 + 1
x510 = x761
x514 = x761
()
} else {
x513 = false
()
}
x1059
}
x1061
}
x1063
} else {
x513 = false
()
}
x1067
}
x1069
}
x1071
} else {
x513 = false
()
}
x1075
}
x1077
}
val x1080 = x503
val x1081 = x504
val x1082 = x505
val x1083 = x506
val x1084 = x507
val x1086 = x509
val x1087 = x510
val x1092 = if (x1086) {
true
} else {
false
}
val x1131 = if (x1092) {
x3 = x1
x4 = true
val x1093 = if (x1086) {
0
} else {
x1087
}
x5 = x1093
()
} else {
val x1093 = if (x1086) {
0
} else {
x1087
}
val x1095 = x1093 >= x20
val x1129 = if (x1095) {
x3 = x1
x4 = true
x5 = 0
()
} else {
val x1097 = x0(x1093)
val x1098 = x1097 == '
'
val x1127 = if (x1098) {
val x1091 = if (x1086) {
val x107 = null.asInstanceOf[Tuple2IntAnon1323431030]
x107
} else {
val x1085 = new Anon1323431030(x1080,x1081,x1082,x1083,x1084)
val x1089 = new Tuple2IntAnon1323431030(x430,x1085)
x1089
}
val x1111 = x1091._1
val x1112 = x1091._2
val x1113 = x1112.contentLength
val x1114 = x1112.connection
val x1115 = x1112.chunked
val x1116 = x1112.upgrade
val x1117 = new Anon1323431030(x1111,x1113,x1114,x1115,x1116)
x3 = x1117
x4 = false
val x1099 = x1093 + 1
x5 = x1099
()
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1127
}
x1129
}
x1131
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1137
}
x1139
}
x1141
}
x1143
}
x1145
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1151
}
x1153
}
x1155
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1161
}
x1163
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1169
}
x1171
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1177
}
x1179
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1185
}
x1187
} else {
x3 = x1
x4 = true
x5 = 0
()
}
x1193
}
val x1196 = x3
val x1197 = x4
val x1198 = x5
val x1199 = new ParseResultAnon1323431030(x1196,x1197,x1198)
//val x1200 = println(x1199)
//x1200
()
}
}
/*****************************************
  End of Generated Code
*******************************************/