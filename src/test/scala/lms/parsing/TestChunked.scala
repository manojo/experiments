package lms.parsing

class TestChunked extends ((Array[Char])=>(Int)) with Serializable {
def apply(x0:Array[Char]): Int = {
val x1 = x0.length
val x2 = new Array[Char](x1)
var x3: Int = 0
val x4 = 0 >= x1
val x357 = if (x4) {
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
val x355 = if (x19) {
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
val x353 = if (x102) {
()
} else {
val x103 = if (x98) {
0
} else {
x99
}
val x105 = x103 >= x1
val x351 = if (x105) {
()
} else {
val x107 = x0(x103)
val x108 = x107 == '\n'
val x349 = if (x108) {
val x101 = if (x98) {
0
} else {
x97
}
val x112 = x101 == 0
val x347 = if (x112) {
val x109 = x103 + 1
val x113 = x109 >= x1
val x122 = if (x113) {
()
} else {
val x116 = x0(x109)
val x117 = x116 == '\n'
val x121 = if (x117) {
()
} else {
()
}
x121
}
x122
} else {
val x109 = x103 + 1
var x124 : Int = 0
val x130 = while (x124 < x101) {
val x125 = 0 + x124
val x126 = x109 + x124
val x127 = x0(x126)
val x128 = x2(x125) = x127

x124 = x124 + 1
}
val x131 = 0 + x101
x3 = x131
var x136: Unit = ()
var x137: Boolean = false
val x132 = x109 + x101
var x138: Int = x132
var x140: Int = -1
var x141: Boolean = true
var x142: Int = x132
val x337 = while ({val x143 = x141
val x144 = x140
val x145 = x142
val x146 = x144 != x145
val x147 = x143 && x146
x147}) {
val x149 = x142
x140 = x149
val x151 = x149 >= x1
val x335 = if (x151) {
x141 = false
()
} else {
val x156 = x0(x149)
val x157 = x156 == '\n'
val x333 = if (x157) {
val x158 = x149 + 1
val x160 = x158 >= x1
val x329 = if (x160) {
x141 = false
()
} else {
val x165 = x0(x158)
val x166 = x165 >= '0'
val x167 = x165 <= '9'
val x168 = x166 && x167
val x169 = x165 >= 'A'
val x170 = x165 <= 'F'
val x171 = x169 && x170
val x172 = x168 || x171
val x173 = x165 >= 'a'
val x174 = x165 <= 'f'
val x175 = x173 && x174
val x176 = x172 || x175
val x327 = if (x176) {
val x188 = if (x168) {
val x179 = x165 - '0'
val x180 = x179.toInt
x180
} else {
val x187 = if (x171) {
val x181 = x165 - 'A'
val x182 = x181.toInt
val x183 = x182 + 10
x183
} else {
val x184 = x165 - 'a'
val x185 = x184.toInt
val x186 = x185 + 10
x186
}
x187
}
var x190: Int = x188
var x191: Boolean = false
val x177 = x158 + 1
var x192: Int = x177
var x194: Int = -1
var x195: Boolean = true
var x196: Int = x177
val x253 = while ({val x197 = x195
val x198 = x194
val x199 = x196
val x200 = x198 != x199
val x201 = x197 && x200
x201}) {
val x203 = x196
x194 = x203
val x205 = x203 >= x1
val x251 = if (x205) {
x195 = false
()
} else {
val x210 = x0(x203)
val x211 = x210 >= '0'
val x212 = x210 <= '9'
val x213 = x211 && x212
val x214 = x210 >= 'A'
val x215 = x210 <= 'F'
val x216 = x214 && x215
val x217 = x213 || x216
val x218 = x210 >= 'a'
val x219 = x210 <= 'f'
val x220 = x218 && x219
val x221 = x217 || x220
val x249 = if (x221) {
val x235 = x190
val x236 = x191
val x237 = x192
val x233 = if (x213) {
val x224 = x210 - '0'
val x225 = x224.toInt
x225
} else {
val x232 = if (x216) {
val x226 = x210 - 'A'
val x227 = x226.toInt
val x228 = x227 + 10
x228
} else {
val x229 = x210 - 'a'
val x230 = x229.toInt
val x231 = x230 + 10
x231
}
x232
}
val x239 = x235 * 16
val x240 = x239 + x233
x190 = x240
x191 = false
val x222 = x203 + 1
x192 = x222
x196 = x222
()
} else {
x195 = false
()
}
x249
}
x251
}
val x254 = x190
val x255 = x191
val x256 = x192
val x259 = if (x255) {
true
} else {
x255
}
val x323 = if (x259) {
x141 = false
()
} else {
val x260 = if (x255) {
x158
} else {
x256
}
val x264 = x260 >= x1
val x321 = if (x264) {
x141 = false
()
} else {
val x268 = x0(x260)
val x269 = x268 == '\n'
val x319 = if (x269) {
val x258 = if (x255) {
0
} else {
x254
}
val x273 = x258 == 0
val x315 = if (x273) {
val x270 = x260 + 1
val x274 = x270 >= x1
val x290 = if (x274) {
x141 = false
()
} else {
val x279 = x0(x270)
val x280 = x279 == '\n'
val x288 = if (x280) {
x141 = false
()
} else {
x141 = false
()
}
x288
}
x290
} else {
val x292 = x3
val x270 = x260 + 1
var x294 : Int = 0
val x300 = while (x294 < x258) {
val x295 = x292 + x294
val x296 = x270 + x294
val x297 = x0(x296)
val x298 = x2(x295) = x297

x294 = x294 + 1
}
val x304 = x136
val x305 = x137
val x306 = x138
val x301 = x292 + x258
x3 = x301
x136 = ()
x137 = false
val x302 = x270 + x258
x138 = x302
x142 = x302
()
}
x315
} else {
x141 = false
()
}
x319
}
x321
}
x323
} else {
x141 = false
()
}
x327
}
x329
} else {
x141 = false
()
}
x333
}
x335
}
val x338 = x136
val x339 = x137
val x340 = x138
()
}
x347
} else {
()
}
x349
}
x351
}
x353
} else {
()
}
x355
}
var x358: Int = 0
var x359: Boolean = true
var x360: Int = 0
var x363: Unit = ()
var x364: Boolean = false
var x365: Int = 0
var x367: Int = -1
var x368: Boolean = true
var x369: Int = 0
val x413 = while ({val x370 = x368
val x371 = x367
val x372 = x369
val x373 = x371 != x372
val x374 = x370 && x373
x374}) {
val x376 = x369
x367 = x376
val x378 = x3
val x379 = x376 >= x378
val x411 = if (x379) {
x368 = false
()
} else {
val x383 = x2(x376)
val x384 = x383 == ' '
val x385 = x383 == ''
val x386 = x384 || x385
val x387 = x383 == '\n'
val x388 = x386 || x387
val x389 = x383 == ''
val x390 = x388 || x389
val x391 = x383 == '	'
val x392 = x390 || x391
val x393 = x383 == ''
val x394 = x392 || x393
val x409 = if (x394) {
val x397 = x363
val x398 = x364
val x399 = x365
x363 = ()
x364 = false
val x395 = x376 + 1
x365 = x395
x369 = x395
()
} else {
x368 = false
()
}
x409
}
x411
}
val x414 = x363
val x415 = x364
val x416 = x365
val x611 = if (x415) {
x358 = 0
x359 = true
x360 = 0
()
} else {
var x423: Int = 0
var x424: Boolean = false
var x425: Int = x416
var x427: Int = -1
var x428: Boolean = true
var x429: Int = x416
val x602 = while ({val x430 = x428
val x431 = x427
val x432 = x429
val x433 = x431 != x432
val x434 = x430 && x433
x434}) {
val x436 = x429
x427 = x436
val x438 = x3
val x439 = x436 >= x438
val x600 = if (x439) {
x428 = false
()
} else {
val x444 = x2(x436)
val x445 = x444 == ' '
val x446 = x444 == ''
val x447 = x445 || x446
val x448 = x444 == '\n'
val x449 = x447 || x448
val x450 = x444 == ''
val x451 = x449 || x450
val x452 = x444 == '	'
val x453 = x451 || x452
val x454 = x444 == ''
val x455 = x453 || x454
val x598 = if (x455) {
x428 = false
()
} else {
var x462: Unit = ()
var x463: Boolean = false
val x459 = x436 + 1
var x464: Int = x459
var x466: Int = -1
var x467: Boolean = true
var x468: Int = x459
val x513 = while ({val x469 = x467
val x470 = x466
val x471 = x468
val x472 = x470 != x471
val x473 = x469 && x472
x473}) {
val x475 = x468
x466 = x475
val x477 = x3
val x478 = x475 >= x477
val x511 = if (x478) {
x467 = false
()
} else {
val x482 = x2(x475)
val x483 = x482 == ' '
val x484 = x482 == ''
val x485 = x483 || x484
val x486 = x482 == '\n'
val x487 = x485 || x486
val x488 = x482 == ''
val x489 = x487 || x488
val x490 = x482 == '	'
val x491 = x489 || x490
val x492 = x482 == ''
val x493 = x491 || x492
val x509 = if (x493) {
x467 = false
()
} else {
val x499 = x462
val x500 = x463
val x501 = x464
x462 = ()
x463 = false
val x497 = x475 + 1
x464 = x497
x468 = x497
()
}
x509
}
x511
}
val x514 = x462
val x515 = x463
val x516 = x464
val x596 = if (x515) {
x428 = false
()
} else {
var x521: Unit = ()
var x522: Boolean = false
var x523: Int = x516
var x525: Int = -1
var x526: Boolean = true
var x527: Int = x516
val x571 = while ({val x528 = x526
val x529 = x525
val x530 = x527
val x531 = x529 != x530
val x532 = x528 && x531
x532}) {
val x534 = x527
x525 = x534
val x536 = x3
val x537 = x534 >= x536
val x569 = if (x537) {
x526 = false
()
} else {
val x541 = x2(x534)
val x542 = x541 == ' '
val x543 = x541 == ''
val x544 = x542 || x543
val x545 = x541 == '\n'
val x546 = x544 || x545
val x547 = x541 == ''
val x548 = x546 || x547
val x549 = x541 == '	'
val x550 = x548 || x549
val x551 = x541 == ''
val x552 = x550 || x551
val x567 = if (x552) {
val x555 = x521
val x556 = x522
val x557 = x523
x521 = ()
x522 = false
val x553 = x534 + 1
x523 = x553
x527 = x553
()
} else {
x526 = false
()
}
x567
}
x569
}
val x572 = x521
val x573 = x522
val x574 = x523
val x578 = if (x573) {
true
} else {
false
}
val x594 = if (x578) {
x428 = false
()
} else {
val x583 = x423
val x584 = x424
val x585 = x425
val x587 = x583 + 1
x423 = x587
x424 = false
val x579 = if (x573) {
x436
} else {
x574
}
x425 = x579
x429 = x579
()
}
x594
}
x596
}
x598
}
x600
}
val x603 = x423
val x604 = x424
val x605 = x425
x358 = x603
x359 = x604
x360 = x605
()
}
val x612 = x358
val x613 = x359
val x614 = x360
x612
}
}
