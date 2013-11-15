package lms.parsing

/*****************************************
  Emitting Generated Code
*******************************************/
class TestChunked extends ((Array[Char])=>(Unit)) with Serializable{
var res: ParseResultInt = null
def apply(x0:Array[Char]): Unit = {
val x1 = x0.length
val x2 = new Array[Char](x1)
var x3: Int = 0
val x4 = 0 >= x1
val x663 = if (x4) {
()
} else {
val x8 = x0(0)
val x9 = x8 >= '0'
val x10 = x8 <= '9'
val x11 = x9 && x10
val x12 = x8 >= 'A'
val x13 = x8 <= 'F'
val x14 = x12 && x13
val x15 = x11 || x14
val x16 = x8 >= 'a'
val x17 = x8 <= 'f'
val x18 = x16 && x17
val x19 = x15 || x18
val x661 = if (x19) {
val x31 = if (x11) {
val x22 = x8 - '0'
val x23 = x22.toInt
x23
} else {
val x30 = if (x14) {
val x24 = x8 - 'A'
val x25 = x24.toInt
val x26 = x25 + 10
x26
} else {
val x27 = x8 - 'a'
val x28 = x27.toInt
val x29 = x28 + 10
x29
}
x30
}
var x33: Int = x31
var x34: Boolean = false
val x20 = 0 + 1
var x35: Int = x20
var x37: Int = -1
var x38: Boolean = true
var x39: Int = x20
val x96 = while ({val x40 = x38
val x41 = x37
val x42 = x39
val x43 = x41 != x42
val x44 = x40 && x43
x44}) {
val x46 = x39
x37 = x46
val x48 = x46 >= x1
val x94 = if (x48) {
x38 = false
()
} else {
val x53 = x0(x46)
val x54 = x53 >= '0'
val x55 = x53 <= '9'
val x56 = x54 && x55
val x57 = x53 >= 'A'
val x58 = x53 <= 'F'
val x59 = x57 && x58
val x60 = x56 || x59
val x61 = x53 >= 'a'
val x62 = x53 <= 'f'
val x63 = x61 && x62
val x64 = x60 || x63
val x92 = if (x64) {
val x78 = x33
val x79 = x34
val x80 = x35
val x76 = if (x56) {
val x67 = x53 - '0'
val x68 = x67.toInt
x68
} else {
val x75 = if (x59) {
val x69 = x53 - 'A'
val x70 = x69.toInt
val x71 = x70 + 10
x71
} else {
val x72 = x53 - 'a'
val x73 = x72.toInt
val x74 = x73 + 10
x74
}
x75
}
val x82 = x78 * 16
val x83 = x82 + x76
x33 = x83
x34 = false
val x65 = x46 + 1
x35 = x65
x39 = x65
()
} else {
x38 = false
()
}
x92
}
x94
}
val x97 = x33
val x98 = x34
val x99 = x35
val x102 = if (x98) {
true
} else {
x98
}
val x659 = if (x102) {
val x381 = if (x102) {
()
} else {
val x101 = if (x98) {
0
} else {
x97
}
val x105 = x101 == 0
val x379 = if (x105) {
val x103 = if (x98) {
0
} else {
x99
}
val x106 = x103 >= x1
val x115 = if (x106) {
()
} else {
val x109 = x0(x103)
val x110 = x109 == '\n'
val x114 = if (x110) {
()
} else {
()
}
x114
}
x115
} else {
val x103 = if (x98) {
0
} else {
x99
}
var x118 : Int = 0
val x124 = while (x118 < x101) {
val x119 = 0 + x118
val x120 = x103 + x118
val x121 = x0(x120)
val x122 = x2(x119) = x121

x118 = x118 + 1
}
val x125 = 0 + x101
x3 = x125
var x130: Unit = ()
var x131: Boolean = false
val x126 = x103 + x101
var x132: Int = x126
var x134: Int = -1
var x135: Boolean = true
var x136: Int = x126
val x369 = while ({val x137 = x135
val x138 = x134
val x139 = x136
val x140 = x138 != x139
val x141 = x137 && x140
x141}) {
val x143 = x136
x134 = x143
val x145 = x143 >= x1
val x367 = if (x145) {
x135 = false
()
} else {
val x150 = x0(x143)
val x151 = x150 == '\n'
val x365 = if (x151) {
val x152 = x143 + 1
val x154 = x152 >= x1
val x361 = if (x154) {
x135 = false
()
} else {
val x159 = x0(x152)
val x160 = x159 >= '0'
val x161 = x159 <= '9'
val x162 = x160 && x161
val x163 = x159 >= 'A'
val x164 = x159 <= 'F'
val x165 = x163 && x164
val x166 = x162 || x165
val x167 = x159 >= 'a'
val x168 = x159 <= 'f'
val x169 = x167 && x168
val x170 = x166 || x169
val x359 = if (x170) {
val x182 = if (x162) {
val x173 = x159 - '0'
val x174 = x173.toInt
x174
} else {
val x181 = if (x165) {
val x175 = x159 - 'A'
val x176 = x175.toInt
val x177 = x176 + 10
x177
} else {
val x178 = x159 - 'a'
val x179 = x178.toInt
val x180 = x179 + 10
x180
}
x181
}
var x184: Int = x182
var x185: Boolean = false
val x171 = x152 + 1
var x186: Int = x171
var x188: Int = -1
var x189: Boolean = true
var x190: Int = x171
val x247 = while ({val x191 = x189
val x192 = x188
val x193 = x190
val x194 = x192 != x193
val x195 = x191 && x194
x195}) {
val x197 = x190
x188 = x197
val x199 = x197 >= x1
val x245 = if (x199) {
x189 = false
()
} else {
val x204 = x0(x197)
val x205 = x204 >= '0'
val x206 = x204 <= '9'
val x207 = x205 && x206
val x208 = x204 >= 'A'
val x209 = x204 <= 'F'
val x210 = x208 && x209
val x211 = x207 || x210
val x212 = x204 >= 'a'
val x213 = x204 <= 'f'
val x214 = x212 && x213
val x215 = x211 || x214
val x243 = if (x215) {
val x229 = x184
val x230 = x185
val x231 = x186
val x227 = if (x207) {
val x218 = x204 - '0'
val x219 = x218.toInt
x219
} else {
val x226 = if (x210) {
val x220 = x204 - 'A'
val x221 = x220.toInt
val x222 = x221 + 10
x222
} else {
val x223 = x204 - 'a'
val x224 = x223.toInt
val x225 = x224 + 10
x225
}
x226
}
val x233 = x229 * 16
val x234 = x233 + x227
x184 = x234
x185 = false
val x216 = x197 + 1
x186 = x216
x190 = x216
()
} else {
x189 = false
()
}
x243
}
x245
}
val x248 = x184
val x249 = x185
val x250 = x186
val x253 = if (x249) {
true
} else {
x249
}
val x355 = if (x253) {
val x303 = if (x253) {
x135 = false
()
} else {
val x252 = if (x249) {
0
} else {
x248
}
val x258 = x252 == 0
val x301 = if (x258) {
val x254 = if (x249) {
x152
} else {
x250
}
val x259 = x254 >= x1
val x275 = if (x259) {
x135 = false
()
} else {
val x264 = x0(x254)
val x265 = x264 == '\n'
val x273 = if (x265) {
x135 = false
()
} else {
x135 = false
()
}
x273
}
x275
} else {
val x278 = x3
val x254 = if (x249) {
x152
} else {
x250
}
var x280 : Int = 0
val x286 = while (x280 < x252) {
val x281 = x278 + x280
val x282 = x254 + x280
val x283 = x0(x282)
val x284 = x2(x281) = x283

x280 = x280 + 1
}
val x290 = x130
val x291 = x131
val x292 = x132
val x287 = x278 + x252
x3 = x287
x130 = ()
x131 = false
val x288 = x254 + x252
x132 = x288
x136 = x288
()
}
x301
}
x303
} else {
val x254 = if (x249) {
x152
} else {
x250
}
val x259 = x254 >= x1
val x353 = if (x259) {
x135 = false
()
} else {
val x264 = x0(x254)
val x265 = x264 == '\n'
val x351 = if (x265) {
val x252 = if (x249) {
0
} else {
x248
}
val x258 = x252 == 0
val x347 = if (x258) {
val x266 = x254 + 1
val x308 = x266 >= x1
val x323 = if (x308) {
x135 = false
()
} else {
val x312 = x0(x266)
val x313 = x312 == '\n'
val x321 = if (x313) {
x135 = false
()
} else {
x135 = false
()
}
x321
}
x323
} else {
val x325 = x3
val x266 = x254 + 1
var x326 : Int = 0
val x332 = while (x326 < x252) {
val x327 = x325 + x326
val x328 = x266 + x326
val x329 = x0(x328)
val x330 = x2(x327) = x329

x326 = x326 + 1
}
val x336 = x130
val x337 = x131
val x338 = x132
val x333 = x325 + x252
x3 = x333
x130 = ()
x131 = false
val x334 = x266 + x252
x132 = x334
x136 = x334
()
}
x347
} else {
x135 = false
()
}
x351
}
x353
}
x355
} else {
x135 = false
()
}
x359
}
x361
} else {
x135 = false
()
}
x365
}
x367
}
val x370 = x130
val x371 = x131
val x372 = x132
()
}
x379
}
x381
} else {
val x103 = if (x98) {
0
} else {
x99
}
val x106 = x103 >= x1
val x657 = if (x106) {
()
} else {
val x109 = x0(x103)
val x110 = x109 == '\n'
val x655 = if (x110) {
val x101 = if (x98) {
0
} else {
x97
}
val x105 = x101 == 0
val x653 = if (x105) {
val x111 = x103 + 1
val x384 = x111 >= x1
val x392 = if (x384) {
()
} else {
val x386 = x0(x111)
val x387 = x386 == '\n'
val x391 = if (x387) {
()
} else {
()
}
x391
}
x392
} else {
val x111 = x103 + 1
var x393 : Int = 0
val x399 = while (x393 < x101) {
val x394 = 0 + x393
val x395 = x111 + x393
val x396 = x0(x395)
val x397 = x2(x394) = x396

x393 = x393 + 1
}
val x125 = 0 + x101
x3 = x125
var x404: Unit = ()
var x405: Boolean = false
val x400 = x111 + x101
var x406: Int = x400
var x408: Int = -1
var x409: Boolean = true
var x410: Int = x400
val x643 = while ({val x411 = x409
val x412 = x408
val x413 = x410
val x414 = x412 != x413
val x415 = x411 && x414
x415}) {
val x417 = x410
x408 = x417
val x419 = x417 >= x1
val x641 = if (x419) {
x409 = false
()
} else {
val x424 = x0(x417)
val x425 = x424 == '\n'
val x639 = if (x425) {
val x426 = x417 + 1
val x428 = x426 >= x1
val x635 = if (x428) {
x409 = false
()
} else {
val x433 = x0(x426)
val x434 = x433 >= '0'
val x435 = x433 <= '9'
val x436 = x434 && x435
val x437 = x433 >= 'A'
val x438 = x433 <= 'F'
val x439 = x437 && x438
val x440 = x436 || x439
val x441 = x433 >= 'a'
val x442 = x433 <= 'f'
val x443 = x441 && x442
val x444 = x440 || x443
val x633 = if (x444) {
val x456 = if (x436) {
val x447 = x433 - '0'
val x448 = x447.toInt
x448
} else {
val x455 = if (x439) {
val x449 = x433 - 'A'
val x450 = x449.toInt
val x451 = x450 + 10
x451
} else {
val x452 = x433 - 'a'
val x453 = x452.toInt
val x454 = x453 + 10
x454
}
x455
}
var x458: Int = x456
var x459: Boolean = false
val x445 = x426 + 1
var x460: Int = x445
var x462: Int = -1
var x463: Boolean = true
var x464: Int = x445
val x521 = while ({val x465 = x463
val x466 = x462
val x467 = x464
val x468 = x466 != x467
val x469 = x465 && x468
x469}) {
val x471 = x464
x462 = x471
val x473 = x471 >= x1
val x519 = if (x473) {
x463 = false
()
} else {
val x478 = x0(x471)
val x479 = x478 >= '0'
val x480 = x478 <= '9'
val x481 = x479 && x480
val x482 = x478 >= 'A'
val x483 = x478 <= 'F'
val x484 = x482 && x483
val x485 = x481 || x484
val x486 = x478 >= 'a'
val x487 = x478 <= 'f'
val x488 = x486 && x487
val x489 = x485 || x488
val x517 = if (x489) {
val x503 = x458
val x504 = x459
val x505 = x460
val x501 = if (x481) {
val x492 = x478 - '0'
val x493 = x492.toInt
x493
} else {
val x500 = if (x484) {
val x494 = x478 - 'A'
val x495 = x494.toInt
val x496 = x495 + 10
x496
} else {
val x497 = x478 - 'a'
val x498 = x497.toInt
val x499 = x498 + 10
x499
}
x500
}
val x507 = x503 * 16
val x508 = x507 + x501
x458 = x508
x459 = false
val x490 = x471 + 1
x460 = x490
x464 = x490
()
} else {
x463 = false
()
}
x517
}
x519
}
val x522 = x458
val x523 = x459
val x524 = x460
val x527 = if (x523) {
true
} else {
x523
}
val x629 = if (x527) {
val x577 = if (x527) {
x409 = false
()
} else {
val x526 = if (x523) {
0
} else {
x522
}
val x532 = x526 == 0
val x575 = if (x532) {
val x528 = if (x523) {
x426
} else {
x524
}
val x533 = x528 >= x1
val x549 = if (x533) {
x409 = false
()
} else {
val x538 = x0(x528)
val x539 = x538 == '\n'
val x547 = if (x539) {
x409 = false
()
} else {
x409 = false
()
}
x547
}
x549
} else {
val x552 = x3
val x528 = if (x523) {
x426
} else {
x524
}
var x554 : Int = 0
val x560 = while (x554 < x526) {
val x555 = x552 + x554
val x556 = x528 + x554
val x557 = x0(x556)
val x558 = x2(x555) = x557

x554 = x554 + 1
}
val x564 = x404
val x565 = x405
val x566 = x406
val x561 = x552 + x526
x3 = x561
x404 = ()
x405 = false
val x562 = x528 + x526
x406 = x562
x410 = x562
()
}
x575
}
x577
} else {
val x528 = if (x523) {
x426
} else {
x524
}
val x533 = x528 >= x1
val x627 = if (x533) {
x409 = false
()
} else {
val x538 = x0(x528)
val x539 = x538 == '\n'
val x625 = if (x539) {
val x526 = if (x523) {
0
} else {
x522
}
val x532 = x526 == 0
val x621 = if (x532) {
val x540 = x528 + 1
val x582 = x540 >= x1
val x597 = if (x582) {
x409 = false
()
} else {
val x586 = x0(x540)
val x587 = x586 == '\n'
val x595 = if (x587) {
x409 = false
()
} else {
x409 = false
()
}
x595
}
x597
} else {
val x599 = x3
val x540 = x528 + 1
var x600 : Int = 0
val x606 = while (x600 < x526) {
val x601 = x599 + x600
val x602 = x540 + x600
val x603 = x0(x602)
val x604 = x2(x601) = x603

x600 = x600 + 1
}
val x610 = x404
val x611 = x405
val x612 = x406
val x607 = x599 + x526
x3 = x607
x404 = ()
x405 = false
val x608 = x540 + x526
x406 = x608
x410 = x608
()
}
x621
} else {
x409 = false
()
}
x625
}
x627
}
x629
} else {
x409 = false
()
}
x633
}
x635
} else {
x409 = false
()
}
x639
}
x641
}
val x644 = x404
val x645 = x405
val x646 = x406
()
}
x653
} else {
()
}
x655
}
x657
}
x659
} else {
()
}
x661
}
var x664: Int = 0
var x665: Boolean = true
var x666: Int = 0
var x669: Unit = ()
var x670: Boolean = false
var x671: Int = 0
var x673: Int = -1
var x674: Boolean = true
var x675: Int = 0
val x719 = while ({val x676 = x674
val x677 = x673
val x678 = x675
val x679 = x677 != x678
val x680 = x676 && x679
x680}) {
val x682 = x675
x673 = x682
val x684 = x3
val x685 = x682 >= x684
val x717 = if (x685) {
x674 = false
()
} else {
val x689 = x2(x682)
val x690 = x689 == ' '
val x691 = x689 == ''
val x692 = x690 || x691
val x693 = x689 == '\n'
val x694 = x692 || x693
val x695 = x689 == '
'
val x696 = x694 || x695
val x697 = x689 == '  '
val x698 = x696 || x697
val x699 = x689 == ''
val x700 = x698 || x699
val x715 = if (x700) {
val x703 = x669
val x704 = x670
val x705 = x671
x669 = ()
x670 = false
val x701 = x682 + 1
x671 = x701
x675 = x701
()
} else {
x674 = false
()
}
x715
}
x717
}
val x720 = x669
val x721 = x670
val x722 = x671
val x930 = if (x721) {
x664 = 0
x665 = true
x666 = 0
()
} else {
var x729: Int = 0
var x730: Boolean = false
var x731: Int = x722
var x733: Int = -1
var x734: Boolean = true
var x735: Int = x722
val x921 = while ({val x736 = x734
val x737 = x733
val x738 = x735
val x739 = x737 != x738
val x740 = x736 && x739
x740}) {
val x742 = x735
x733 = x742
val x744 = x3
val x745 = x742 >= x744
val x919 = if (x745) {
x734 = false
()
} else {
val x750 = x2(x742)
val x751 = x750 == ' '
val x752 = x750 == ''
val x753 = x751 || x752
val x754 = x750 == '\n'
val x755 = x753 || x754
val x756 = x750 == '
'
val x757 = x755 || x756
val x758 = x750 == '  '
val x759 = x757 || x758
val x760 = x750 == ''
val x761 = x759 || x760
val x917 = if (x761) {
x734 = false
()
} else {
var x768: Unit = ()
var x769: Boolean = false
val x765 = x742 + 1
var x770: Int = x765
var x772: Int = -1
var x773: Boolean = true
var x774: Int = x765
val x819 = while ({val x775 = x773
val x776 = x772
val x777 = x774
val x778 = x776 != x777
val x779 = x775 && x778
x779}) {
val x781 = x774
x772 = x781
val x783 = x3
val x784 = x781 >= x783
val x817 = if (x784) {
x773 = false
()
} else {
val x788 = x2(x781)
val x789 = x788 == ' '
val x790 = x788 == ''
val x791 = x789 || x790
val x792 = x788 == '\n'
val x793 = x791 || x792
val x794 = x788 == '
'
val x795 = x793 || x794
val x796 = x788 == '  '
val x797 = x795 || x796
val x798 = x788 == ''
val x799 = x797 || x798
val x815 = if (x799) {
x773 = false
()
} else {
val x805 = x768
val x806 = x769
val x807 = x770
x768 = ()
x769 = false
val x803 = x781 + 1
x770 = x803
x774 = x803
()
}
x815
}
x817
}
val x820 = x768
val x821 = x769
val x822 = x770
val x915 = if (x821) {
val x837 = if (x821) {
x734 = false
()
} else {
val x826 = x729
val x827 = x730
val x828 = x731
val x830 = x826 + 1
x729 = x830
x730 = false
x731 = x822
x735 = x822
()
}
x837
} else {
var x840: Unit = ()
var x841: Boolean = false
var x842: Int = x822
var x844: Int = -1
var x845: Boolean = true
var x846: Int = x822
val x890 = while ({val x847 = x845
val x848 = x844
val x849 = x846
val x850 = x848 != x849
val x851 = x847 && x850
x851}) {
val x853 = x846
x844 = x853
val x855 = x3
val x856 = x853 >= x855
val x888 = if (x856) {
x845 = false
()
} else {
val x860 = x2(x853)
val x861 = x860 == ' '
val x862 = x860 == ''
val x863 = x861 || x862
val x864 = x860 == '\n'
val x865 = x863 || x864
val x866 = x860 == '
'
val x867 = x865 || x866
val x868 = x860 == '  '
val x869 = x867 || x868
val x870 = x860 == ''
val x871 = x869 || x870
val x886 = if (x871) {
val x874 = x840
val x875 = x841
val x876 = x842
x840 = ()
x841 = false
val x872 = x853 + 1
x842 = x872
x846 = x872
()
} else {
x845 = false
()
}
x886
}
x888
}
val x891 = x840
val x892 = x841
val x893 = x842
val x897 = if (x892) {
true
} else {
false
}
val x913 = if (x897) {
x734 = false
()
} else {
val x902 = x729
val x903 = x730
val x904 = x731
val x906 = x902 + 1
x729 = x906
x730 = false
val x898 = if (x892) {
x742
} else {
x893
}
x731 = x898
x735 = x898
()
}
x913
}
x915
}
x917
}
x919
}
val x922 = x729
val x923 = x730
val x924 = x731
x664 = x922
x665 = x923
x666 = x924
()
}
val x931 = x664
val x932 = x665
val x933 = x666
val x934 = new ParseResultInt(x931,x932,x933)
//val x935 = println(x934)
//x935
res = x934
}
}
