package lms.parsing.gen

import java.io.{ BufferedReader, FileReader, Serializable }
import scala.collection.mutable.ArrayBuffer

/**
 * ***************************************
 * Emitting Generated Code
 * *****************************************
 */
class JsonParseResult(
    px2069: Int, px2070: Array[Char], px2072: Int,
    px2073: Array[Char], px2176: Array[Char]) extends ((Array[Char]) => (OptionAnon6507737)) with Serializable {
  def apply(x0: Array[Char]): OptionAnon6507737 = {
    var x2: scala.Function1[StringReader, ParseResultAnon6507737B] = null
    var x3156: scala.Function1[StringReader, ParseResultAnon6507737B] = null
    var x3148: scala.Function1[StringReader, ParseResultAnon6507737B] = null
    var x2068: scala.Function1[StringReader, ParseResultAnon6507737B] = null
    var x1623: scala.Function1[StringReader, ParseResultAnon6507737B] = null
    var x1510: scala.Function1[StringReader, ParseResultListAnon6507737B] = null
    var x1504: scala.Function1[StringReader, ParseResultListAnon6507737B] = null
    var x1951: scala.Function1[StringReader, ParseResultListAnon6507737B] = null
    var x1945: scala.Function1[StringReader, ParseResultListAnon6507737B] = null
    x2 = { x3: (StringReader) =>
      val x3157 = x3156(x3)
      x3157: ParseResultAnon6507737B
    }
    val x180 = { x140: (StringReader) =>
      val x141 = x140.offset
      val x142 = x140.input
      val x143 = x142.length
      val x144 = x141 >= x143
      var x158: Boolean = false
      var x159: StringReader = null
      if (x144) {
        x158 = true
        x159 = x140
      } else {
        val x146 = x142(x141)
        val x147 = x146 == '\\'
        var x153: Boolean = false
        var x154: StringReader = null
        if (x147) {
          val x148 = x141 + 1
          val x149 = new StringReader(x142, x148)
          x153 = false
          x154 = x149
        } else {
          x153 = true
          x154 = x140
        }
        x158 = x153
        x159 = x154
      }
      var x176: Char = ' '
      var x177: Boolean = false
      var x178: StringReader = null
      if (x158) {
        x176 = ' '
        x177 = true
        x178 = x140
      } else {
        val x161 = x159.offset
        val x162 = x159.input
        val x163 = x162.length
        val x164 = x161 >= x163
        var x171: Char = ' '
        var x172: Boolean = false
        var x173: StringReader = null
        if (x164) {
          x171 = ' '
          x172 = true
          x173 = x159
        } else {
          val x166 = x162(x161)
          val x167 = x161 + 1
          val x168 = new StringReader(x162, x167)
          x171 = x166
          x172 = false
          x173 = x168
        }
        x176 = x171
        x177 = x172
        x178 = x173
      }
      val x179 = new ParseResultCharB(x176, x177, x178)
      x179: ParseResultCharB
    }
    val x205 = { x139: (StringReader) =>
      val x181 = x180(x139)
      val x182 = x181.empty
      val x204 = if (x182) {
        val x183 = x139.offset
        val x184 = x139.input
        val x185 = x184.length
        val x186 = x183 >= x185
        var x200: Char = ' '
        var x201: Boolean = false
        var x202: StringReader = null
        if (x186) {
          x200 = ' '
          x201 = true
          x202 = x139
        } else {
          val x188 = x184(x183)
          val x190 = x188 == '"'
          var x195: Char = ' '
          var x196: Boolean = false
          var x197: StringReader = null
          if (x190) {
            x195 = ' '
            x196 = true
            x197 = x139
          } else {
            val x191 = x183 + 1
            val x192 = new StringReader(x184, x191)
            x195 = x188
            x196 = false
            x197 = x192
          }
          x200 = x195
          x201 = x196
          x202 = x197
        }
        val x203 = new ParseResultCharB(x200, x201, x202)
        x203
      } else {
        x181
      }
      x204: ParseResultCharB
    }
    val x94 = List()
    val x944 = { x904: (StringReader) =>
      val x905 = x904.offset
      val x906 = x904.input
      val x907 = x906.length
      val x908 = x905 >= x907
      var x922: Boolean = false
      var x923: StringReader = null
      if (x908) {
        x922 = true
        x923 = x904
      } else {
        val x910 = x906(x905)
        val x911 = x910 == '\\'
        var x917: Boolean = false
        var x918: StringReader = null
        if (x911) {
          val x912 = x905 + 1
          val x913 = new StringReader(x906, x912)
          x917 = false
          x918 = x913
        } else {
          x917 = true
          x918 = x904
        }
        x922 = x917
        x923 = x918
      }
      var x940: Char = ' '
      var x941: Boolean = false
      var x942: StringReader = null
      if (x922) {
        x940 = ' '
        x941 = true
        x942 = x904
      } else {
        val x925 = x923.offset
        val x926 = x923.input
        val x927 = x926.length
        val x928 = x925 >= x927
        var x935: Char = ' '
        var x936: Boolean = false
        var x937: StringReader = null
        if (x928) {
          x935 = ' '
          x936 = true
          x937 = x923
        } else {
          val x930 = x926(x925)
          val x931 = x925 + 1
          val x932 = new StringReader(x926, x931)
          x935 = x930
          x936 = false
          x937 = x932
        }
        x940 = x935
        x941 = x936
        x942 = x937
      }
      val x943 = new ParseResultCharB(x940, x941, x942)
      x943: ParseResultCharB
    }
    val x969 = { x903: (StringReader) =>
      val x945 = x944(x903)
      val x946 = x945.empty
      val x968 = if (x946) {
        val x947 = x903.offset
        val x948 = x903.input
        val x949 = x948.length
        val x950 = x947 >= x949
        var x964: Char = ' '
        var x965: Boolean = false
        var x966: StringReader = null
        if (x950) {
          x964 = ' '
          x965 = true
          x966 = x903
        } else {
          val x952 = x948(x947)
          val x954 = x952 == '"'
          var x959: Char = ' '
          var x960: Boolean = false
          var x961: StringReader = null
          if (x954) {
            x959 = ' '
            x960 = true
            x961 = x903
          } else {
            val x955 = x947 + 1
            val x956 = new StringReader(x948, x955)
            x959 = x952
            x960 = false
            x961 = x956
          }
          x964 = x959
          x965 = x960
          x966 = x961
        }
        val x967 = new ParseResultCharB(x964, x965, x966)
        x967
      } else {
        x945
      }
      x968: ParseResultCharB
    }
    x1504 = { x96: (StringReader) =>
      val x97 = x96.offset
      val x98 = x96.input
      val x99 = x98.length
      val x100 = x97 >= x99
      var x114: Boolean = false
      var x115: StringReader = null
      if (x100) {
        x114 = true
        x115 = x96
      } else {
        val x102 = x98(x97)
        val x103 = x102 == '"'
        var x109: Boolean = false
        var x110: StringReader = null
        if (x103) {
          val x104 = x97 + 1
          val x105 = new StringReader(x98, x104)
          x109 = false
          x110 = x105
        } else {
          x109 = true
          x110 = x96
        }
        x114 = x109
        x115 = x110
      }
      var x248: Unit = ()
      var x250: Boolean = false
      var x251: StringReader = null
      var x249: Tuple2IntInt = null
      if (x114) {
        x248 = ()
        x250 = true
        x251 = x96
        x249 = null
      } else {
        var x123: Boolean = false
        var x122: java.lang.String = ""
        var x124: StringReader = x115
        var x126: Int = -1
        var x127: Boolean = true
        var x128: StringReader = x115
        val x224 = while ({
          val x129 = x127
          val x130 = x126
          val x131 = x128
          val x132 = x131.offset
          val x133 = x130 != x132
          val x134 = x129 && x133
          x134
        }) {
          val x136 = x128
          val x137 = x136.offset
          x126 = x137
          val x206 = x205(x136)
          val x207 = x206.empty
          val x222 = if (x207) {
            x127 = false
            ()
          } else {
            val x210 = x122
            val x211 = x123
            val x212 = x124
            x122 = x210
            x123 = false
            val x215 = x206.next
            x124 = x215
            x128 = x215
            ()
          }
          x222
        }
        val x226 = x123
        val x227 = x124
        var x233: Boolean = false
        var x234: StringReader = null
        var x232: Int = 0
        if (x226) {
          x233 = true
          x234 = x115
          x232 = 0
        } else {
          val x118 = x115.offset
          x233 = false
          x234 = x227
          x232 = x118
        }
        var x243: Boolean = false
        var x244: StringReader = null
        var x242: Tuple2IntInt = null
        if (x233) {
          x243 = true
          x244 = x115
          x242 = null
        } else {
          val x237 = x234.offset
          val x239 = new Tuple2IntInt(x232, x237)
          x243 = false
          x244 = x234
          x242 = x239
        }
        // Barrier sync: TODO: Hack!
        val x225 = x122
        x248 = ()
        x250 = x243
        x251 = x244
        x249 = x242
      }
      var x281: Boolean = false
      var x280: Tuple2IntInt = null
      var x282: StringReader = null
      if (x250) {
        x281 = x250
        x280 = x249
        x282 = x251
      } else {
        val x253 = x251.offset
        val x254 = x251.input
        val x255 = x254.length
        val x256 = x253 >= x255
        var x270: Boolean = false
        var x271: StringReader = null
        if (x256) {
          x270 = true
          x271 = x251
        } else {
          val x258 = x254(x253)
          val x259 = x258 == '"'
          var x265: Boolean = false
          var x266: StringReader = null
          if (x259) {
            val x260 = x253 + 1
            val x261 = new StringReader(x254, x260)
            x265 = false
            x266 = x261
          } else {
            x265 = true
            x266 = x251
          }
          x270 = x265
          x271 = x266
        }
        var x276: Boolean = false
        var x275: Tuple2IntInt = null
        var x277: StringReader = null
        if (x270) {
          x276 = true
          x275 = null
          x277 = x96
        } else {
          x276 = false
          x275 = x249
          x277 = x271
        }
        x281 = x276
        x280 = x275
        x282 = x277
      }
      var x477: Unit = ()
      var x479: Boolean = false
      var x480: StringReader = null
      var x478: java.lang.String = null
      if (x281) {
        x477 = ()
        x479 = true
        x480 = x96
        x478 = null
      } else {
        var x458: java.lang.String = ""
        val x285 = x280._1
        val x286 = x280._2
        val x294 = x286 - x285
        val x295 = new Array[Char](x294)
        var x288: Int = x285
        val x289 = x288
        var x290: Int = x289
        var x291: Int = 0
        val x292 = x291
        var x293: Int = x292
        val x299 = x282.input
        val x455 = while ({
          val x296 = x290
          val x297 = x296 < x286
          x297
        }) {
          val x300 = x290
          val x301 = x299(x300)
          val x302 = x301 == '\\'
          val x303 = x300 + 1
          val x304 = x303 < x286
          val x305 = x302 && x304
          val x452 = if (x305) {
            val x306 = x299(x303)
            val x307 = x306 == 'u'
            val x308 = x300 + 5
            val x309 = x308 < x286
            val x310 = x307 && x309
            val x445 = if (x310) {
              val x396 = x293
              val x311 = x300 + 2
              val x312 = x299(x311)
              val x313 = x312 >= '0'
              val x314 = x312 < '9'
              val x315 = x313 && x314
              val x330 = if (x315) {
                val x316 = x312 - '0'
                val x317 = x316.toInt
                x317
              } else {
                val x318 = x312 >= 'A'
                val x319 = x312 < 'F'
                val x320 = x318 && x319
                val x329 = if (x320) {
                  val x321 = x312 - '7'
                  val x322 = x321.toInt
                  x322
                } else {
                  val x323 = x312 >= 'a'
                  val x324 = x312 < 'f'
                  val x325 = x323 && x324
                  val x328 = if (x325) {
                    val x326 = x312 - 'W'
                    val x327 = x326.toInt
                    x327
                  } else {
                    0
                  }
                  x328
                }
                x329
              }
              val x331 = x330 * 4096
              val x332 = x300 + 3
              val x333 = x299(x332)
              val x334 = x333 >= '0'
              val x335 = x333 < '9'
              val x336 = x334 && x335
              val x351 = if (x336) {
                val x337 = x333 - '0'
                val x338 = x337.toInt
                x338
              } else {
                val x339 = x333 >= 'A'
                val x340 = x333 < 'F'
                val x341 = x339 && x340
                val x350 = if (x341) {
                  val x342 = x333 - '7'
                  val x343 = x342.toInt
                  x343
                } else {
                  val x344 = x333 >= 'a'
                  val x345 = x333 < 'f'
                  val x346 = x344 && x345
                  val x349 = if (x346) {
                    val x347 = x333 - 'W'
                    val x348 = x347.toInt
                    x348
                  } else {
                    0
                  }
                  x349
                }
                x350
              }
              val x352 = x351 * 256
              val x353 = x331 + x352
              val x354 = x300 + 4
              val x355 = x299(x354)
              val x356 = x355 >= '0'
              val x357 = x355 < '9'
              val x358 = x356 && x357
              val x373 = if (x358) {
                val x359 = x355 - '0'
                val x360 = x359.toInt
                x360
              } else {
                val x361 = x355 >= 'A'
                val x362 = x355 < 'F'
                val x363 = x361 && x362
                val x372 = if (x363) {
                  val x364 = x355 - '7'
                  val x365 = x364.toInt
                  x365
                } else {
                  val x366 = x355 >= 'a'
                  val x367 = x355 < 'f'
                  val x368 = x366 && x367
                  val x371 = if (x368) {
                    val x369 = x355 - 'W'
                    val x370 = x369.toInt
                    x370
                  } else {
                    0
                  }
                  x371
                }
                x372
              }
              val x374 = x373 * 16
              val x375 = x353 + x374
              val x376 = x299(x308)
              val x377 = x376 >= '0'
              val x378 = x376 < '9'
              val x379 = x377 && x378
              val x394 = if (x379) {
                val x380 = x376 - '0'
                val x381 = x380.toInt
                x381
              } else {
                val x382 = x376 >= 'A'
                val x383 = x376 < 'F'
                val x384 = x382 && x383
                val x393 = if (x384) {
                  val x385 = x376 - '7'
                  val x386 = x385.toInt
                  x386
                } else {
                  val x387 = x376 >= 'a'
                  val x388 = x376 < 'f'
                  val x389 = x387 && x388
                  val x392 = if (x389) {
                    val x390 = x376 - 'W'
                    val x391 = x390.toInt
                    x391
                  } else {
                    0
                  }
                  x392
                }
                x393
              }
              val x395 = x375 + x394
              val x397 = x395.toChar
              val x398 = x295(x396) = x397
              val x399 = x290 += 4
              ()
            } else {
              val x401 = x306 == 'b'
              val x442 = if (x401) {
                val x402 = x293
                val x403 = x295(x402) = ''
                x403
              } else {
                val x405 = x306 == 'f'
                val x438 = if (x405) {
                  val x406 = x293
                  val x407 = x295(x406) = ''
                  x407
                } else {
                  val x409 = x306 == 't'
                  val x434 = if (x409) {
                    val x410 = x293
                    val x411 = x295(x410) = '	'
                    x411
                  } else {
                    val x413 = x306 == 'n'
                    val x430 = if (x413) {
                      val x414 = x293
                      val x415 = x295(x414) = '\n'
                      x415
                    } else {
                      val x417 = x306 == 'r'
                      val x426 = if (x417) {
                        val x418 = x293
                        val x419 = x295(x418) = '
'
                        x419
                      } else {
                        val x421 = x293
                        val x422 = x295(x421) = x306
                        x422
                      }
                      x426
                    }
                    x430
                  }
                  x434
                }
                x438
              }
              x442
            }
            val x446 = x290 += 2
            ()
          } else {
            val x448 = x293
            val x449 = x295(x448) = x301
            val x450 = x290 += 1
            ()
          }
          val x453 = x293 += 1
          ()
        }
        var x459: Int = 0
        val x456 = x293
        val x472 = while ({
          val x460 = x459
          val x461 = x460 < x456
          x461
        }) {
          val x463 = x458
          val x464 = x459
          val x465 = 0 + x464
          val x466 = x295(x465)
          val x467 = x463 + x466
          x458 = x467
          val x469 = x464 + 1
          x459 = x469
          ()
        }
        val x473 = x458
        // Barrier sync: TODO: Hack!
        x477 = ()
        x479 = false
        x480 = x282
        x478 = x473
      }
      var x657: Unit = ()
      var x659: Boolean = false
      var x660: StringReader = null
      var x658: java.lang.String = null
      if (x479) {
        x657 = ()
        x659 = x479
        x660 = x480
        x658 = x478
      } else {
        var x485: Boolean = false
        var x484: java.lang.String = ""
        var x486: StringReader = x480
        var x488: Int = -1
        var x489: Boolean = true
        var x490: StringReader = x480
        val x536 = while ({
          val x491 = x489
          val x492 = x488
          val x493 = x490
          val x494 = x493.offset
          val x495 = x492 != x494
          val x496 = x491 && x495
          x496
        }) {
          val x498 = x490
          val x499 = x498.offset
          x488 = x499
          val x501 = x498.input
          val x502 = x501.length
          val x503 = x499 >= x502
          var x519: Boolean = false
          var x520: StringReader = null
          if (x503) {
            x519 = true
            x520 = x498
          } else {
            val x505 = x501(x499)
            val x506 = x505 == ' '
            val x507 = x505 == '\n'
            val x508 = x506 || x507
            var x514: Boolean = false
            var x515: StringReader = null
            if (x508) {
              val x509 = x499 + 1
              val x510 = new StringReader(x501, x509)
              x514 = false
              x515 = x510
            } else {
              x514 = true
              x515 = x498
            }
            x519 = x514
            x520 = x515
          }
          val x534 = if (x519) {
            x489 = false
            ()
          } else {
            val x524 = x484
            val x525 = x485
            val x526 = x486
            x484 = x524
            x485 = false
            x486 = x520
            x490 = x520
            ()
          }
          x534
        }
        val x538 = x485
        val x539 = x486
        // Barrier sync: TODO: Hack!
        var x644: Unit = ()
        var x646: Boolean = false
        var x647: StringReader = null
        if (x538) {
          x644 = ()
          x646 = x538
          x647 = x539
        } else {
          val x541 = x539.offset
          val x542 = x539.input
          val x543 = x542.length
          val x544 = x541 >= x543
          var x558: Boolean = false
          var x559: StringReader = null
          if (x544) {
            x558 = true
            x559 = x539
          } else {
            val x546 = x542(x541)
            val x547 = x546 == ':'
            var x553: Boolean = false
            var x554: StringReader = null
            if (x547) {
              val x548 = x541 + 1
              val x549 = new StringReader(x542, x548)
              x553 = false
              x554 = x549
            } else {
              x553 = true
              x554 = x539
            }
            x558 = x553
            x559 = x554
          }
          var x630: Unit = ()
          var x632: Boolean = false
          var x633: StringReader = null
          if (x558) {
            x630 = ()
            x632 = true
            x633 = x539
          } else {
            var x565: Boolean = false
            var x564: java.lang.String = ""
            var x566: StringReader = x559
            var x568: Int = -1
            var x569: Boolean = true
            var x570: StringReader = x559
            val x616 = while ({
              val x571 = x569
              val x572 = x568
              val x573 = x570
              val x574 = x573.offset
              val x575 = x572 != x574
              val x576 = x571 && x575
              x576
            }) {
              val x578 = x570
              val x579 = x578.offset
              x568 = x579
              val x581 = x578.input
              val x582 = x581.length
              val x583 = x579 >= x582
              var x599: Boolean = false
              var x600: StringReader = null
              if (x583) {
                x599 = true
                x600 = x578
              } else {
                val x585 = x581(x579)
                val x586 = x585 == ' '
                val x587 = x585 == '\n'
                val x588 = x586 || x587
                var x594: Boolean = false
                var x595: StringReader = null
                if (x588) {
                  val x589 = x579 + 1
                  val x590 = new StringReader(x581, x589)
                  x594 = false
                  x595 = x590
                } else {
                  x594 = true
                  x595 = x578
                }
                x599 = x594
                x600 = x595
              }
              val x614 = if (x599) {
                x569 = false
                ()
              } else {
                val x604 = x564
                val x605 = x565
                val x606 = x566
                x564 = x604
                x565 = false
                x566 = x600
                x570 = x600
                ()
              }
              x614
            }
            val x618 = x565
            val x619 = x566
            var x625: Boolean = false
            var x626: StringReader = null
            if (x618) {
              x625 = true
              x626 = x539
            } else {
              x625 = false
              x626 = x619
            }
            // Barrier sync: TODO: Hack!
            val x617 = x564
            x630 = ()
            x632 = x625
            x633 = x626
          }
          var x639: Boolean = false
          var x640: StringReader = null
          if (x632) {
            x639 = true
            x640 = x480
          } else {
            x639 = false
            x640 = x633
          }
          x644 = ()
          x646 = x639
          x647 = x640
        }
        var x652: Boolean = false
        var x653: StringReader = null
        var x651: java.lang.String = null
        if (x646) {
          x652 = true
          x653 = x96
          x651 = null
        } else {
          x652 = false
          x653 = x647
          x651 = x478
        }
        val x537 = x484
        x657 = ()
        x659 = x652
        x660 = x653
        x658 = x651
      }
      var x676: Unit = ()
      var x677: Tuple2StringAnon6507737 = null
      var x679: StringReader = null
      var x678: Boolean = false
      if (x659) {
        x676 = ()
        x677 = null
        x679 = x96
        x678 = true
      } else {
        val x663 = x2(x660)
        val x664 = x663.empty
        var x670: Tuple2StringAnon6507737 = null
        var x672: StringReader = null
        var x671: Boolean = false
        if (x664) {
          x670 = null
          x672 = x96
          x671 = true
        } else {
          val x665 = x663.res
          val x666 = new Tuple2StringAnon6507737(x658, x665)
          val x667 = x663.next
          x670 = x666
          x672 = x667
          x671 = false
        }
        x676 = ()
        x677 = x670
        x679 = x672
        x678 = x671
      }
      var x685: Anon6507737 = null
      var x686: Boolean = false
      if (x678) {
        x685 = null
        x686 = true
      } else {
        val x682 = new Anon6507737(7, x677)
        x685 = x682
        x686 = false
      }
      var x1489: Unit = ()
      var x1490: Tuple2Anon6507737ListAnon6507737 = null
      var x1491: Boolean = false
      var x1492: StringReader = null
      if (x686) {
        x1489 = ()
        x1490 = null
        x1491 = true
        x1492 = x96
      } else {
        var x692: Boolean = false
        // Barrier sync: TODO: Hack!
        var x691: scala.collection.immutable.List[Anon6507737] = x94
        var x693: StringReader = x679
        var x695: Int = -1
        var x696: Boolean = true
        var x697: StringReader = x679
        val x1475 = while ({
          val x698 = x696
          val x699 = x695
          val x700 = x697
          val x701 = x700.offset
          val x702 = x699 != x701
          val x703 = x698 && x702
          x703
        }) {
          val x705 = x697
          val x706 = x705.offset
          x695 = x706
          // Barrier sync: TODO: Hack!
          var x710: java.lang.String = ""
          var x711: Boolean = false
          var x712: StringReader = x705
          var x714: Int = -1
          var x715: Boolean = true
          var x716: StringReader = x705
          val x762 = while ({
            val x717 = x715
            val x718 = x714
            val x719 = x716
            val x720 = x719.offset
            val x721 = x718 != x720
            val x722 = x717 && x721
            x722
          }) {
            val x724 = x716
            val x725 = x724.offset
            x714 = x725
            val x727 = x724.input
            val x728 = x727.length
            val x729 = x725 >= x728
            var x746: StringReader = null
            var x745: Boolean = false
            if (x729) {
              x746 = x724
              x745 = true
            } else {
              val x731 = x727(x725)
              val x732 = x731 == ' '
              val x733 = x731 == '\n'
              val x734 = x732 || x733
              var x741: StringReader = null
              var x740: Boolean = false
              if (x734) {
                val x735 = x725 + 1
                val x736 = new StringReader(x727, x735)
                x741 = x736
                x740 = false
              } else {
                x741 = x724
                x740 = true
              }
              x746 = x741
              x745 = x740
            }
            val x760 = if (x745) {
              x715 = false
              ()
            } else {
              val x750 = x710
              val x751 = x711
              val x752 = x712
              x710 = x750
              x711 = false
              x712 = x746
              x716 = x746
              ()
            }
            x760
          }
          val x763 = x710
          val x764 = x711
          val x765 = x712
          var x791: StringReader = null
          var x790: Boolean = false
          if (x764) {
            x791 = x705
            x790 = true
          } else {
            val x768 = x765.offset
            val x769 = x765.input
            val x770 = x769.length
            val x771 = x768 >= x770
            var x786: StringReader = null
            var x785: Boolean = false
            if (x771) {
              x786 = x765
              x785 = true
            } else {
              val x773 = x769(x768)
              val x774 = x773 == ','
              var x781: StringReader = null
              var x780: Boolean = false
              if (x774) {
                val x775 = x768 + 1
                val x776 = new StringReader(x769, x775)
                x781 = x776
                x780 = false
              } else {
                x781 = x765
                x780 = true
              }
              x786 = x781
              x785 = x780
            }
            x791 = x786
            x790 = x785
          }
          var x855: Unit = ()
          var x858: StringReader = null
          var x857: Boolean = false
          if (x790) {
            x855 = ()
            x858 = x705
            x857 = true
          } else {
            var x797: Boolean = false
            var x796: java.lang.String = ""
            var x798: StringReader = x791
            var x800: Int = -1
            var x801: Boolean = true
            var x802: StringReader = x791
            val x848 = while ({
              val x803 = x801
              val x804 = x800
              val x805 = x802
              val x806 = x805.offset
              val x807 = x804 != x806
              val x808 = x803 && x807
              x808
            }) {
              val x810 = x802
              val x811 = x810.offset
              x800 = x811
              val x813 = x810.input
              val x814 = x813.length
              val x815 = x811 >= x814
              var x832: StringReader = null
              var x831: Boolean = false
              if (x815) {
                x832 = x810
                x831 = true
              } else {
                val x817 = x813(x811)
                val x818 = x817 == ' '
                val x819 = x817 == '\n'
                val x820 = x818 || x819
                var x827: StringReader = null
                var x826: Boolean = false
                if (x820) {
                  val x821 = x811 + 1
                  val x822 = new StringReader(x813, x821)
                  x827 = x822
                  x826 = false
                } else {
                  x827 = x810
                  x826 = true
                }
                x832 = x827
                x831 = x826
              }
              val x846 = if (x831) {
                x801 = false
                ()
              } else {
                val x836 = x796
                val x837 = x797
                val x838 = x798
                x796 = x836
                x797 = false
                x798 = x832
                x802 = x832
                ()
              }
              x846
            }
            val x850 = x797
            val x851 = x798
            // Barrier sync: TODO: Hack!
            val x849 = x796
            x855 = ()
            x858 = x851
            x857 = x850
          }
          var x1454: Unit = ()
          var x1457: StringReader = null
          var x1455: Anon6507737 = null
          var x1456: Boolean = false
          if (x857) {
            x1454 = ()
            x1457 = x705
            x1455 = null
            x1456 = true
          } else {
            val x861 = x858.offset
            val x862 = x858.input
            val x863 = x862.length
            val x864 = x861 >= x863
            var x879: StringReader = null
            var x878: Boolean = false
            if (x864) {
              x879 = x858
              x878 = true
            } else {
              val x866 = x862(x861)
              val x867 = x866 == '"'
              var x874: StringReader = null
              var x873: Boolean = false
              if (x867) {
                val x868 = x861 + 1
                val x869 = new StringReader(x862, x868)
                x874 = x869
                x873 = false
              } else {
                x874 = x858
                x873 = true
              }
              x879 = x874
              x878 = x873
            }
            var x1012: Unit = ()
            var x1013: Tuple2IntInt = null
            var x1015: StringReader = null
            var x1014: Boolean = false
            if (x878) {
              x1012 = ()
              x1013 = null
              x1015 = x858
              x1014 = true
            } else {
              var x887: Boolean = false
              var x886: java.lang.String = ""
              var x888: StringReader = x879
              var x890: Int = -1
              var x891: Boolean = true
              var x892: StringReader = x879
              val x988 = while ({
                val x893 = x891
                val x894 = x890
                val x895 = x892
                val x896 = x895.offset
                val x897 = x894 != x896
                val x898 = x893 && x897
                x898
              }) {
                val x900 = x892
                val x901 = x900.offset
                x890 = x901
                val x970 = x969(x900)
                val x971 = x970.empty
                val x986 = if (x971) {
                  x891 = false
                  ()
                } else {
                  val x974 = x886
                  val x975 = x887
                  val x976 = x888
                  x886 = x974
                  x887 = false
                  val x979 = x970.next
                  x888 = x979
                  x892 = x979
                  ()
                }
                x986
              }
              val x990 = x887
              val x991 = x888
              var x996: Int = 0
              var x998: StringReader = null
              var x997: Boolean = false
              if (x990) {
                x996 = 0
                x998 = x879
                x997 = true
              } else {
                val x882 = x879.offset
                x996 = x882
                x998 = x991
                x997 = false
              }
              var x1006: Tuple2IntInt = null
              var x1008: StringReader = null
              var x1007: Boolean = false
              if (x997) {
                x1006 = null
                x1008 = x879
                x1007 = true
              } else {
                val x1001 = x998.offset
                val x1003 = new Tuple2IntInt(x996, x1001)
                x1006 = x1003
                x1008 = x998
                x1007 = false
              }
              // Barrier sync: TODO: Hack!
              val x989 = x886
              x1012 = ()
              x1013 = x1006
              x1015 = x1008
              x1014 = x1007
            }
            var x1046: StringReader = null
            var x1044: Tuple2IntInt = null
            var x1045: Boolean = false
            if (x1014) {
              x1046 = x1015
              x1044 = x1013
              x1045 = x1014
            } else {
              val x1017 = x1015.offset
              val x1018 = x1015.input
              val x1019 = x1018.length
              val x1020 = x1017 >= x1019
              var x1035: StringReader = null
              var x1034: Boolean = false
              if (x1020) {
                x1035 = x1015
                x1034 = true
              } else {
                val x1022 = x1018(x1017)
                val x1023 = x1022 == '"'
                var x1030: StringReader = null
                var x1029: Boolean = false
                if (x1023) {
                  val x1024 = x1017 + 1
                  val x1025 = new StringReader(x1018, x1024)
                  x1030 = x1025
                  x1029 = false
                } else {
                  x1030 = x1015
                  x1029 = true
                }
                x1035 = x1030
                x1034 = x1029
              }
              var x1041: StringReader = null
              var x1039: Tuple2IntInt = null
              var x1040: Boolean = false
              if (x1034) {
                x1041 = x858
                x1039 = null
                x1040 = true
              } else {
                x1041 = x1035
                x1039 = x1013
                x1040 = false
              }
              x1046 = x1041
              x1044 = x1039
              x1045 = x1040
            }
            var x1241: Unit = ()
            var x1242: java.lang.String = null
            var x1244: StringReader = null
            var x1243: Boolean = false
            if (x1045) {
              x1241 = ()
              x1242 = null
              x1244 = x858
              x1243 = true
            } else {
              var x1222: java.lang.String = ""
              val x1049 = x1044._1
              val x1050 = x1044._2
              val x1058 = x1050 - x1049
              val x1059 = new Array[Char](x1058)
              var x1052: Int = x1049
              val x1053 = x1052
              var x1054: Int = x1053
              var x1055: Int = 0
              val x1056 = x1055
              var x1057: Int = x1056
              val x1063 = x1046.input
              val x1219 = while ({
                val x1060 = x1054
                val x1061 = x1060 < x1050
                x1061
              }) {
                val x1064 = x1054
                val x1065 = x1063(x1064)
                val x1066 = x1065 == '\\'
                val x1067 = x1064 + 1
                val x1068 = x1067 < x1050
                val x1069 = x1066 && x1068
                val x1216 = if (x1069) {
                  val x1070 = x1063(x1067)
                  val x1071 = x1070 == 'u'
                  val x1072 = x1064 + 5
                  val x1073 = x1072 < x1050
                  val x1074 = x1071 && x1073
                  val x1209 = if (x1074) {
                    val x1160 = x1057
                    val x1075 = x1064 + 2
                    val x1076 = x1063(x1075)
                    val x1077 = x1076 >= '0'
                    val x1078 = x1076 < '9'
                    val x1079 = x1077 && x1078
                    val x1094 = if (x1079) {
                      val x1080 = x1076 - '0'
                      val x1081 = x1080.toInt
                      x1081
                    } else {
                      val x1082 = x1076 >= 'A'
                      val x1083 = x1076 < 'F'
                      val x1084 = x1082 && x1083
                      val x1093 = if (x1084) {
                        val x1085 = x1076 - '7'
                        val x1086 = x1085.toInt
                        x1086
                      } else {
                        val x1087 = x1076 >= 'a'
                        val x1088 = x1076 < 'f'
                        val x1089 = x1087 && x1088
                        val x1092 = if (x1089) {
                          val x1090 = x1076 - 'W'
                          val x1091 = x1090.toInt
                          x1091
                        } else {
                          0
                        }
                        x1092
                      }
                      x1093
                    }
                    val x1095 = x1094 * 4096
                    val x1096 = x1064 + 3
                    val x1097 = x1063(x1096)
                    val x1098 = x1097 >= '0'
                    val x1099 = x1097 < '9'
                    val x1100 = x1098 && x1099
                    val x1115 = if (x1100) {
                      val x1101 = x1097 - '0'
                      val x1102 = x1101.toInt
                      x1102
                    } else {
                      val x1103 = x1097 >= 'A'
                      val x1104 = x1097 < 'F'
                      val x1105 = x1103 && x1104
                      val x1114 = if (x1105) {
                        val x1106 = x1097 - '7'
                        val x1107 = x1106.toInt
                        x1107
                      } else {
                        val x1108 = x1097 >= 'a'
                        val x1109 = x1097 < 'f'
                        val x1110 = x1108 && x1109
                        val x1113 = if (x1110) {
                          val x1111 = x1097 - 'W'
                          val x1112 = x1111.toInt
                          x1112
                        } else {
                          0
                        }
                        x1113
                      }
                      x1114
                    }
                    val x1116 = x1115 * 256
                    val x1117 = x1095 + x1116
                    val x1118 = x1064 + 4
                    val x1119 = x1063(x1118)
                    val x1120 = x1119 >= '0'
                    val x1121 = x1119 < '9'
                    val x1122 = x1120 && x1121
                    val x1137 = if (x1122) {
                      val x1123 = x1119 - '0'
                      val x1124 = x1123.toInt
                      x1124
                    } else {
                      val x1125 = x1119 >= 'A'
                      val x1126 = x1119 < 'F'
                      val x1127 = x1125 && x1126
                      val x1136 = if (x1127) {
                        val x1128 = x1119 - '7'
                        val x1129 = x1128.toInt
                        x1129
                      } else {
                        val x1130 = x1119 >= 'a'
                        val x1131 = x1119 < 'f'
                        val x1132 = x1130 && x1131
                        val x1135 = if (x1132) {
                          val x1133 = x1119 - 'W'
                          val x1134 = x1133.toInt
                          x1134
                        } else {
                          0
                        }
                        x1135
                      }
                      x1136
                    }
                    val x1138 = x1137 * 16
                    val x1139 = x1117 + x1138
                    val x1140 = x1063(x1072)
                    val x1141 = x1140 >= '0'
                    val x1142 = x1140 < '9'
                    val x1143 = x1141 && x1142
                    val x1158 = if (x1143) {
                      val x1144 = x1140 - '0'
                      val x1145 = x1144.toInt
                      x1145
                    } else {
                      val x1146 = x1140 >= 'A'
                      val x1147 = x1140 < 'F'
                      val x1148 = x1146 && x1147
                      val x1157 = if (x1148) {
                        val x1149 = x1140 - '7'
                        val x1150 = x1149.toInt
                        x1150
                      } else {
                        val x1151 = x1140 >= 'a'
                        val x1152 = x1140 < 'f'
                        val x1153 = x1151 && x1152
                        val x1156 = if (x1153) {
                          val x1154 = x1140 - 'W'
                          val x1155 = x1154.toInt
                          x1155
                        } else {
                          0
                        }
                        x1156
                      }
                      x1157
                    }
                    val x1159 = x1139 + x1158
                    val x1161 = x1159.toChar
                    val x1162 = x1059(x1160) = x1161
                    val x1163 = x1054 += 4
                    ()
                  } else {
                    val x1165 = x1070 == 'b'
                    val x1206 = if (x1165) {
                      val x1166 = x1057
                      val x1167 = x1059(x1166) = ''
                      x1167
                    } else {
                      val x1169 = x1070 == 'f'
                      val x1202 = if (x1169) {
                        val x1170 = x1057
                        val x1171 = x1059(x1170) = ''
                        x1171
                      } else {
                        val x1173 = x1070 == 't'
                        val x1198 = if (x1173) {
                          val x1174 = x1057
                          val x1175 = x1059(x1174) = '	'
                          x1175
                        } else {
                          val x1177 = x1070 == 'n'
                          val x1194 = if (x1177) {
                            val x1178 = x1057
                            val x1179 = x1059(x1178) = '\n'
                            x1179
                          } else {
                            val x1181 = x1070 == 'r'
                            val x1190 = if (x1181) {
                              val x1182 = x1057
                              val x1183 = x1059(x1182) = '
'
                              x1183
                            } else {
                              val x1185 = x1057
                              val x1186 = x1059(x1185) = x1070
                              x1186
                            }
                            x1190
                          }
                          x1194
                        }
                        x1198
                      }
                      x1202
                    }
                    x1206
                  }
                  val x1210 = x1054 += 2
                  ()
                } else {
                  val x1212 = x1057
                  val x1213 = x1059(x1212) = x1065
                  val x1214 = x1054 += 1
                  ()
                }
                val x1217 = x1057 += 1
                ()
              }
              var x1223: Int = 0
              val x1220 = x1057
              val x1236 = while ({
                val x1224 = x1223
                val x1225 = x1224 < x1220
                x1225
              }) {
                val x1227 = x1222
                val x1228 = x1223
                val x1229 = 0 + x1228
                val x1230 = x1059(x1229)
                val x1231 = x1227 + x1230
                x1222 = x1231
                val x1233 = x1228 + 1
                x1223 = x1233
                ()
              }
              val x1237 = x1222
              // Barrier sync: TODO: Hack!
              x1241 = ()
              x1242 = x1237
              x1244 = x1046
              x1243 = false
            }
            var x1421: Unit = ()
            var x1422: java.lang.String = null
            var x1424: StringReader = null
            var x1423: Boolean = false
            if (x1243) {
              x1421 = ()
              x1422 = x1242
              x1424 = x1244
              x1423 = x1243
            } else {
              var x1249: Boolean = false
              var x1248: java.lang.String = ""
              var x1250: StringReader = x1244
              var x1252: Int = -1
              var x1253: Boolean = true
              var x1254: StringReader = x1244
              val x1300 = while ({
                val x1255 = x1253
                val x1256 = x1252
                val x1257 = x1254
                val x1258 = x1257.offset
                val x1259 = x1256 != x1258
                val x1260 = x1255 && x1259
                x1260
              }) {
                val x1262 = x1254
                val x1263 = x1262.offset
                x1252 = x1263
                val x1265 = x1262.input
                val x1266 = x1265.length
                val x1267 = x1263 >= x1266
                var x1284: StringReader = null
                var x1283: Boolean = false
                if (x1267) {
                  x1284 = x1262
                  x1283 = true
                } else {
                  val x1269 = x1265(x1263)
                  val x1270 = x1269 == ' '
                  val x1271 = x1269 == '\n'
                  val x1272 = x1270 || x1271
                  var x1279: StringReader = null
                  var x1278: Boolean = false
                  if (x1272) {
                    val x1273 = x1263 + 1
                    val x1274 = new StringReader(x1265, x1273)
                    x1279 = x1274
                    x1278 = false
                  } else {
                    x1279 = x1262
                    x1278 = true
                  }
                  x1284 = x1279
                  x1283 = x1278
                }
                val x1298 = if (x1283) {
                  x1253 = false
                  ()
                } else {
                  val x1288 = x1248
                  val x1289 = x1249
                  val x1290 = x1250
                  x1248 = x1288
                  x1249 = false
                  x1250 = x1284
                  x1254 = x1284
                  ()
                }
                x1298
              }
              val x1302 = x1249
              val x1303 = x1250
              // Barrier sync: TODO: Hack!
              var x1408: Unit = ()
              var x1411: StringReader = null
              var x1410: Boolean = false
              if (x1302) {
                x1408 = ()
                x1411 = x1303
                x1410 = x1302
              } else {
                val x1305 = x1303.offset
                val x1306 = x1303.input
                val x1307 = x1306.length
                val x1308 = x1305 >= x1307
                var x1323: StringReader = null
                var x1322: Boolean = false
                if (x1308) {
                  x1323 = x1303
                  x1322 = true
                } else {
                  val x1310 = x1306(x1305)
                  val x1311 = x1310 == ':'
                  var x1318: StringReader = null
                  var x1317: Boolean = false
                  if (x1311) {
                    val x1312 = x1305 + 1
                    val x1313 = new StringReader(x1306, x1312)
                    x1318 = x1313
                    x1317 = false
                  } else {
                    x1318 = x1303
                    x1317 = true
                  }
                  x1323 = x1318
                  x1322 = x1317
                }
                var x1394: Unit = ()
                var x1397: StringReader = null
                var x1396: Boolean = false
                if (x1322) {
                  x1394 = ()
                  x1397 = x1303
                  x1396 = true
                } else {
                  var x1329: Boolean = false
                  var x1328: java.lang.String = ""
                  var x1330: StringReader = x1323
                  var x1332: Int = -1
                  var x1333: Boolean = true
                  var x1334: StringReader = x1323
                  val x1380 = while ({
                    val x1335 = x1333
                    val x1336 = x1332
                    val x1337 = x1334
                    val x1338 = x1337.offset
                    val x1339 = x1336 != x1338
                    val x1340 = x1335 && x1339
                    x1340
                  }) {
                    val x1342 = x1334
                    val x1343 = x1342.offset
                    x1332 = x1343
                    val x1345 = x1342.input
                    val x1346 = x1345.length
                    val x1347 = x1343 >= x1346
                    var x1364: StringReader = null
                    var x1363: Boolean = false
                    if (x1347) {
                      x1364 = x1342
                      x1363 = true
                    } else {
                      val x1349 = x1345(x1343)
                      val x1350 = x1349 == ' '
                      val x1351 = x1349 == '\n'
                      val x1352 = x1350 || x1351
                      var x1359: StringReader = null
                      var x1358: Boolean = false
                      if (x1352) {
                        val x1353 = x1343 + 1
                        val x1354 = new StringReader(x1345, x1353)
                        x1359 = x1354
                        x1358 = false
                      } else {
                        x1359 = x1342
                        x1358 = true
                      }
                      x1364 = x1359
                      x1363 = x1358
                    }
                    val x1378 = if (x1363) {
                      x1333 = false
                      ()
                    } else {
                      val x1368 = x1328
                      val x1369 = x1329
                      val x1370 = x1330
                      x1328 = x1368
                      x1329 = false
                      x1330 = x1364
                      x1334 = x1364
                      ()
                    }
                    x1378
                  }
                  val x1382 = x1329
                  val x1383 = x1330
                  var x1390: StringReader = null
                  var x1389: Boolean = false
                  if (x1382) {
                    x1390 = x1303
                    x1389 = true
                  } else {
                    x1390 = x1383
                    x1389 = false
                  }
                  // Barrier sync: TODO: Hack!
                  val x1381 = x1328
                  x1394 = ()
                  x1397 = x1390
                  x1396 = x1389
                }
                var x1404: StringReader = null
                var x1403: Boolean = false
                if (x1396) {
                  x1404 = x1244
                  x1403 = true
                } else {
                  x1404 = x1397
                  x1403 = false
                }
                x1408 = ()
                x1411 = x1404
                x1410 = x1403
              }
              var x1415: java.lang.String = null
              var x1417: StringReader = null
              var x1416: Boolean = false
              if (x1410) {
                x1415 = null
                x1417 = x858
                x1416 = true
              } else {
                x1415 = x1242
                x1417 = x1411
                x1416 = false
              }
              val x1301 = x1248
              x1421 = ()
              x1422 = x1415
              x1424 = x1417
              x1423 = x1416
            }
            var x1440: Unit = ()
            var x1443: StringReader = null
            var x1441: Tuple2StringAnon6507737 = null
            var x1442: Boolean = false
            if (x1423) {
              x1440 = ()
              x1443 = x858
              x1441 = null
              x1442 = true
            } else {
              val x1427 = x2(x1424)
              val x1428 = x1427.empty
              var x1436: StringReader = null
              var x1434: Tuple2StringAnon6507737 = null
              var x1435: Boolean = false
              if (x1428) {
                x1436 = x858
                x1434 = null
                x1435 = true
              } else {
                val x1429 = x1427.res
                val x1430 = new Tuple2StringAnon6507737(x1422, x1429)
                val x1431 = x1427.next
                x1436 = x1431
                x1434 = x1430
                x1435 = false
              }
              x1440 = ()
              x1443 = x1436
              x1441 = x1434
              x1442 = x1435
            }
            var x1449: Anon6507737 = null
            var x1450: Boolean = false
            if (x1442) {
              x1449 = null
              x1450 = true
            } else {
              val x1446 = new Anon6507737(7, x1441)
              x1449 = x1446
              x1450 = false
            }
            x1454 = ()
            x1457 = x1443
            x1455 = x1449
            x1456 = x1450
          }
          val x1473 = if (x1456) {
            x696 = false
            ()
          } else {
            val x1461 = x691
            val x1462 = x692
            val x1463 = x693
            val x1465 = List(x1455)
            val x1466 = x1461 ::: x1465
            x691 = x1466
            x692 = false
            x693 = x1457
            x697 = x1457
            ()
          }
          x1473
        }
        val x1477 = x692
        val x1478 = x693
        val x1476 = x691
        var x1483: Tuple2Anon6507737ListAnon6507737 = null
        var x1484: Boolean = false
        var x1485: StringReader = null
        if (x1477) {
          x1483 = null
          x1484 = true
          x1485 = x96
        } else {
          val x1480 = new Tuple2Anon6507737ListAnon6507737(x685, x1476)
          x1483 = x1480
          x1484 = false
          x1485 = x1478
        }
        x1489 = ()
        x1490 = x1483
        x1491 = x1484
        x1492 = x1485
      }
      var x1501: Boolean = false
      var x1500: scala.collection.immutable.List[Anon6507737] = null
      if (x1491) {
        x1501 = true
        x1500 = null
      } else {
        val x1495 = x1490._1
        val x1496 = x1490._2
        val x1497 = x1495 :: x1496
        x1501 = false
        x1500 = x1497
      }
      val x1502 = new ParseResultListAnon6507737B(x1500, x1501, x1492)
      x1502: ParseResultListAnon6507737B
    }
    x1510 = { x95: (StringReader) =>
      val x1505 = x1504(x95)
      val x1506 = x1505.empty
      val x1508 = if (x1506) {
        val x1507 = new ParseResultListAnon6507737B(x94, false, x95)
        x1507
      } else {
        x1505
      }
      x1508: ParseResultListAnon6507737B
    }
    x1623 = { x5: (StringReader) =>
      val x6 = x5.offset
      val x7 = x5.input
      val x8 = x7.length
      val x9 = x6 >= x8
      var x23: Boolean = false
      var x24: StringReader = null
      if (x9) {
        x23 = true
        x24 = x5
      } else {
        val x11 = x7(x6)
        val x12 = x11 == '{'
        var x18: Boolean = false
        var x19: StringReader = null
        if (x12) {
          val x13 = x6 + 1
          val x14 = new StringReader(x7, x13)
          x18 = false
          x19 = x14
        } else {
          x18 = true
          x19 = x5
        }
        x23 = x18
        x24 = x19
      }
      var x88: Unit = ()
      var x90: Boolean = false
      var x91: StringReader = null
      if (x23) {
        x88 = ()
        x90 = true
        x91 = x5
      } else {
        var x30: Boolean = false
        var x29: java.lang.String = ""
        var x31: StringReader = x24
        var x33: Int = -1
        var x34: Boolean = true
        var x35: StringReader = x24
        val x81 = while ({
          val x36 = x34
          val x37 = x33
          val x38 = x35
          val x39 = x38.offset
          val x40 = x37 != x39
          val x41 = x36 && x40
          x41
        }) {
          val x43 = x35
          val x44 = x43.offset
          x33 = x44
          val x46 = x43.input
          val x47 = x46.length
          val x48 = x44 >= x47
          var x64: Boolean = false
          var x65: StringReader = null
          if (x48) {
            x64 = true
            x65 = x43
          } else {
            val x50 = x46(x44)
            val x51 = x50 == ' '
            val x52 = x50 == '\n'
            val x53 = x51 || x52
            var x59: Boolean = false
            var x60: StringReader = null
            if (x53) {
              val x54 = x44 + 1
              val x55 = new StringReader(x46, x54)
              x59 = false
              x60 = x55
            } else {
              x59 = true
              x60 = x43
            }
            x64 = x59
            x65 = x60
          }
          val x79 = if (x64) {
            x34 = false
            ()
          } else {
            val x69 = x29
            val x70 = x30
            val x71 = x31
            x29 = x69
            x30 = false
            x31 = x65
            x35 = x65
            ()
          }
          x79
        }
        val x83 = x30
        val x84 = x31
        // Barrier sync: TODO: Hack!
        val x82 = x29
        x88 = ()
        x90 = x83
        x91 = x84
      }
      val x1514 = if (x90) {
        val x93 = new ParseResultListAnon6507737B(null, true, x5)
        x93
      } else {
        val x1511 = x1510(x91)
        x1511
      }
      val x1515 = x1514.empty
      val x1611 = if (x1515) {
        x1514
      } else {
        // Barrier sync: TODO: Hack!
        var x1519: java.lang.String = ""
        var x1520: Boolean = false
        val x1516 = x1514.next
        var x1521: StringReader = x1516
        var x1523: Int = -1
        var x1524: Boolean = true
        var x1525: StringReader = x1516
        val x1571 = while ({
          val x1526 = x1524
          val x1527 = x1523
          val x1528 = x1525
          val x1529 = x1528.offset
          val x1530 = x1527 != x1529
          val x1531 = x1526 && x1530
          x1531
        }) {
          val x1533 = x1525
          val x1534 = x1533.offset
          x1523 = x1534
          val x1536 = x1533.input
          val x1537 = x1536.length
          val x1538 = x1534 >= x1537
          var x1555: StringReader = null
          var x1554: Boolean = false
          if (x1538) {
            x1555 = x1533
            x1554 = true
          } else {
            val x1540 = x1536(x1534)
            val x1541 = x1540 == ' '
            val x1542 = x1540 == '\n'
            val x1543 = x1541 || x1542
            var x1550: StringReader = null
            var x1549: Boolean = false
            if (x1543) {
              val x1544 = x1534 + 1
              val x1545 = new StringReader(x1536, x1544)
              x1550 = x1545
              x1549 = false
            } else {
              x1550 = x1533
              x1549 = true
            }
            x1555 = x1550
            x1554 = x1549
          }
          val x1569 = if (x1554) {
            x1524 = false
            ()
          } else {
            val x1559 = x1519
            val x1560 = x1520
            val x1561 = x1521
            x1519 = x1559
            x1520 = false
            x1521 = x1555
            x1525 = x1555
            ()
          }
          x1569
        }
        val x1572 = x1519
        val x1573 = x1520
        val x1574 = x1521
        var x1600: StringReader = null
        var x1599: Boolean = false
        if (x1573) {
          x1600 = x1516
          x1599 = true
        } else {
          val x1577 = x1574.offset
          val x1578 = x1574.input
          val x1579 = x1578.length
          val x1580 = x1577 >= x1579
          var x1595: StringReader = null
          var x1594: Boolean = false
          if (x1580) {
            x1595 = x1574
            x1594 = true
          } else {
            val x1582 = x1578(x1577)
            val x1583 = x1582 == '}'
            var x1590: StringReader = null
            var x1589: Boolean = false
            if (x1583) {
              val x1584 = x1577 + 1
              val x1585 = new StringReader(x1578, x1584)
              x1590 = x1585
              x1589 = false
            } else {
              x1590 = x1574
              x1589 = true
            }
            x1595 = x1590
            x1594 = x1589
          }
          x1600 = x1595
          x1599 = x1594
        }
        var x1607: StringReader = null
        var x1606: Boolean = false
        var x1605: scala.collection.immutable.List[Anon6507737] = null
        if (x1599) {
          x1607 = x5
          x1606 = true
          x1605 = null
        } else {
          val x1602 = x1514.res
          x1607 = x1600
          x1606 = false
          x1605 = x1602
        }
        val x1608 = new ParseResultListAnon6507737B(x1605, x1606, x1607)
        x1608
      }
      val x1613 = x1611.next
      val x1612 = x1611.empty
      var x1620: Boolean = false
      var x1619: Anon6507737 = null
      if (x1612) {
        x1620 = true
        x1619 = null
      } else {
        val x1615 = x1611.res
        val x1616 = new Anon6507737(8, x1615)
        x1620 = false
        x1619 = x1616
      }
      val x1621 = new ParseResultAnon6507737B(x1619, x1620, x1613)
      x1621: ParseResultAnon6507737B
    }
    x1945 = { x1715: (StringReader) =>
      val x1716 = x2(x1715)
      val x1717 = x1716.empty
      var x1930: Unit = ()
      var x1931: Tuple2Anon6507737ListAnon6507737 = null
      var x1932: Boolean = false
      var x1933: StringReader = null
      if (x1717) {
        x1930 = ()
        x1931 = null
        x1932 = true
        x1933 = x1715
      } else {
        var x1723: Boolean = false
        // Barrier sync: TODO: Hack!
        var x1722: scala.collection.immutable.List[Anon6507737] = x94
        val x1719 = x1716.next
        var x1724: StringReader = x1719
        var x1726: Int = -1
        var x1727: Boolean = true
        var x1728: StringReader = x1719
        val x1915 = while ({
          val x1729 = x1727
          val x1730 = x1726
          val x1731 = x1728
          val x1732 = x1731.offset
          val x1733 = x1730 != x1732
          val x1734 = x1729 && x1733
          x1734
        }) {
          val x1736 = x1728
          val x1737 = x1736.offset
          x1726 = x1737
          // Barrier sync: TODO: Hack!
          var x1741: java.lang.String = ""
          var x1742: Boolean = false
          var x1743: StringReader = x1736
          var x1745: Int = -1
          var x1746: Boolean = true
          var x1747: StringReader = x1736
          val x1793 = while ({
            val x1748 = x1746
            val x1749 = x1745
            val x1750 = x1747
            val x1751 = x1750.offset
            val x1752 = x1749 != x1751
            val x1753 = x1748 && x1752
            x1753
          }) {
            val x1755 = x1747
            val x1756 = x1755.offset
            x1745 = x1756
            val x1758 = x1755.input
            val x1759 = x1758.length
            val x1760 = x1756 >= x1759
            var x1777: StringReader = null
            var x1776: Boolean = false
            if (x1760) {
              x1777 = x1755
              x1776 = true
            } else {
              val x1762 = x1758(x1756)
              val x1763 = x1762 == ' '
              val x1764 = x1762 == '\n'
              val x1765 = x1763 || x1764
              var x1772: StringReader = null
              var x1771: Boolean = false
              if (x1765) {
                val x1766 = x1756 + 1
                val x1767 = new StringReader(x1758, x1766)
                x1772 = x1767
                x1771 = false
              } else {
                x1772 = x1755
                x1771 = true
              }
              x1777 = x1772
              x1776 = x1771
            }
            val x1791 = if (x1776) {
              x1746 = false
              ()
            } else {
              val x1781 = x1741
              val x1782 = x1742
              val x1783 = x1743
              x1741 = x1781
              x1742 = false
              x1743 = x1777
              x1747 = x1777
              ()
            }
            x1791
          }
          val x1794 = x1741
          val x1795 = x1742
          val x1796 = x1743
          var x1822: StringReader = null
          var x1821: Boolean = false
          if (x1795) {
            x1822 = x1736
            x1821 = true
          } else {
            val x1799 = x1796.offset
            val x1800 = x1796.input
            val x1801 = x1800.length
            val x1802 = x1799 >= x1801
            var x1817: StringReader = null
            var x1816: Boolean = false
            if (x1802) {
              x1817 = x1796
              x1816 = true
            } else {
              val x1804 = x1800(x1799)
              val x1805 = x1804 == ','
              var x1812: StringReader = null
              var x1811: Boolean = false
              if (x1805) {
                val x1806 = x1799 + 1
                val x1807 = new StringReader(x1800, x1806)
                x1812 = x1807
                x1811 = false
              } else {
                x1812 = x1796
                x1811 = true
              }
              x1817 = x1812
              x1816 = x1811
            }
            x1822 = x1817
            x1821 = x1816
          }
          var x1886: Unit = ()
          var x1889: StringReader = null
          var x1888: Boolean = false
          if (x1821) {
            x1886 = ()
            x1889 = x1736
            x1888 = true
          } else {
            var x1828: Boolean = false
            var x1827: java.lang.String = ""
            var x1829: StringReader = x1822
            var x1831: Int = -1
            var x1832: Boolean = true
            var x1833: StringReader = x1822
            val x1879 = while ({
              val x1834 = x1832
              val x1835 = x1831
              val x1836 = x1833
              val x1837 = x1836.offset
              val x1838 = x1835 != x1837
              val x1839 = x1834 && x1838
              x1839
            }) {
              val x1841 = x1833
              val x1842 = x1841.offset
              x1831 = x1842
              val x1844 = x1841.input
              val x1845 = x1844.length
              val x1846 = x1842 >= x1845
              var x1863: StringReader = null
              var x1862: Boolean = false
              if (x1846) {
                x1863 = x1841
                x1862 = true
              } else {
                val x1848 = x1844(x1842)
                val x1849 = x1848 == ' '
                val x1850 = x1848 == '\n'
                val x1851 = x1849 || x1850
                var x1858: StringReader = null
                var x1857: Boolean = false
                if (x1851) {
                  val x1852 = x1842 + 1
                  val x1853 = new StringReader(x1844, x1852)
                  x1858 = x1853
                  x1857 = false
                } else {
                  x1858 = x1841
                  x1857 = true
                }
                x1863 = x1858
                x1862 = x1857
              }
              val x1877 = if (x1862) {
                x1832 = false
                ()
              } else {
                val x1867 = x1827
                val x1868 = x1828
                val x1869 = x1829
                x1827 = x1867
                x1828 = false
                x1829 = x1863
                x1833 = x1863
                ()
              }
              x1877
            }
            val x1881 = x1828
            val x1882 = x1829
            // Barrier sync: TODO: Hack!
            val x1880 = x1827
            x1886 = ()
            x1889 = x1882
            x1888 = x1881
          }
          val x1895 = if (x1888) {
            val x1891 = new ParseResultAnon6507737B(null, true, x1736)
            x1891
          } else {
            val x1892 = x2(x1889)
            x1892
          }
          val x1896 = x1895.empty
          val x1913 = if (x1896) {
            x1727 = false
            ()
          } else {
            val x1899 = x1722
            val x1900 = x1723
            val x1901 = x1724
            val x1903 = x1895.res
            val x1904 = List(x1903)
            val x1905 = x1899 ::: x1904
            x1722 = x1905
            x1723 = false
            val x1906 = x1895.next
            x1724 = x1906
            x1728 = x1906
            ()
          }
          x1913
        }
        val x1917 = x1723
        val x1918 = x1724
        val x1916 = x1722
        var x1924: Tuple2Anon6507737ListAnon6507737 = null
        var x1925: Boolean = false
        var x1926: StringReader = null
        if (x1917) {
          x1924 = null
          x1925 = true
          x1926 = x1715
        } else {
          val x1920 = x1716.res
          val x1921 = new Tuple2Anon6507737ListAnon6507737(x1920, x1916)
          x1924 = x1921
          x1925 = false
          x1926 = x1918
        }
        x1930 = ()
        x1931 = x1924
        x1932 = x1925
        x1933 = x1926
      }
      var x1942: Boolean = false
      var x1941: scala.collection.immutable.List[Anon6507737] = null
      if (x1932) {
        x1942 = true
        x1941 = null
      } else {
        val x1936 = x1931._1
        val x1937 = x1931._2
        val x1938 = x1936 :: x1937
        x1942 = false
        x1941 = x1938
      }
      val x1943 = new ParseResultListAnon6507737B(x1941, x1942, x1933)
      x1943: ParseResultListAnon6507737B
    }
    x1951 = { x1714: (StringReader) =>
      val x1946 = x1945(x1714)
      val x1947 = x1946.empty
      val x1949 = if (x1947) {
        val x1948 = new ParseResultListAnon6507737B(x94, false, x1714)
        x1948
      } else {
        x1946
      }
      x1949: ParseResultListAnon6507737B
    }
    x2068 = { x4: (StringReader) =>
      val x1624 = x1623(x4)
      val x1625 = x1624.empty
      val x2066 = if (x1625) {
        val x1626 = x4.offset
        val x1627 = x4.input
        val x1628 = x1627.length
        val x1629 = x1626 >= x1628
        var x1643: Boolean = false
        var x1644: StringReader = null
        if (x1629) {
          x1643 = true
          x1644 = x4
        } else {
          val x1631 = x1627(x1626)
          val x1632 = x1631 == '['
          var x1638: Boolean = false
          var x1639: StringReader = null
          if (x1632) {
            val x1633 = x1626 + 1
            val x1634 = new StringReader(x1627, x1633)
            x1638 = false
            x1639 = x1634
          } else {
            x1638 = true
            x1639 = x4
          }
          x1643 = x1638
          x1644 = x1639
        }
        var x1708: Unit = ()
        var x1711: StringReader = null
        var x1710: Boolean = false
        if (x1643) {
          x1708 = ()
          x1711 = x4
          x1710 = true
        } else {
          var x1650: Boolean = false
          var x1649: java.lang.String = ""
          var x1651: StringReader = x1644
          var x1653: Int = -1
          var x1654: Boolean = true
          var x1655: StringReader = x1644
          val x1701 = while ({
            val x1656 = x1654
            val x1657 = x1653
            val x1658 = x1655
            val x1659 = x1658.offset
            val x1660 = x1657 != x1659
            val x1661 = x1656 && x1660
            x1661
          }) {
            val x1663 = x1655
            val x1664 = x1663.offset
            x1653 = x1664
            val x1666 = x1663.input
            val x1667 = x1666.length
            val x1668 = x1664 >= x1667
            var x1684: Boolean = false
            var x1685: StringReader = null
            if (x1668) {
              x1684 = true
              x1685 = x1663
            } else {
              val x1670 = x1666(x1664)
              val x1671 = x1670 == ' '
              val x1672 = x1670 == '\n'
              val x1673 = x1671 || x1672
              var x1679: Boolean = false
              var x1680: StringReader = null
              if (x1673) {
                val x1674 = x1664 + 1
                val x1675 = new StringReader(x1666, x1674)
                x1679 = false
                x1680 = x1675
              } else {
                x1679 = true
                x1680 = x1663
              }
              x1684 = x1679
              x1685 = x1680
            }
            val x1699 = if (x1684) {
              x1654 = false
              ()
            } else {
              val x1689 = x1649
              val x1690 = x1650
              val x1691 = x1651
              x1649 = x1689
              x1650 = false
              x1651 = x1685
              x1655 = x1685
              ()
            }
            x1699
          }
          val x1703 = x1650
          val x1704 = x1651
          // Barrier sync: TODO: Hack!
          val x1702 = x1649
          x1708 = ()
          x1711 = x1704
          x1710 = x1703
        }
        val x1955 = if (x1710) {
          val x1713 = new ParseResultListAnon6507737B(null, true, x4)
          x1713
        } else {
          val x1952 = x1951(x1711)
          x1952
        }
        val x1956 = x1955.empty
        val x2052 = if (x1956) {
          x1955
        } else {
          // Barrier sync: TODO: Hack!
          var x1960: java.lang.String = ""
          var x1961: Boolean = false
          val x1957 = x1955.next
          var x1962: StringReader = x1957
          var x1964: Int = -1
          var x1965: Boolean = true
          var x1966: StringReader = x1957
          val x2012 = while ({
            val x1967 = x1965
            val x1968 = x1964
            val x1969 = x1966
            val x1970 = x1969.offset
            val x1971 = x1968 != x1970
            val x1972 = x1967 && x1971
            x1972
          }) {
            val x1974 = x1966
            val x1975 = x1974.offset
            x1964 = x1975
            val x1977 = x1974.input
            val x1978 = x1977.length
            val x1979 = x1975 >= x1978
            var x1996: StringReader = null
            var x1995: Boolean = false
            if (x1979) {
              x1996 = x1974
              x1995 = true
            } else {
              val x1981 = x1977(x1975)
              val x1982 = x1981 == ' '
              val x1983 = x1981 == '\n'
              val x1984 = x1982 || x1983
              var x1991: StringReader = null
              var x1990: Boolean = false
              if (x1984) {
                val x1985 = x1975 + 1
                val x1986 = new StringReader(x1977, x1985)
                x1991 = x1986
                x1990 = false
              } else {
                x1991 = x1974
                x1990 = true
              }
              x1996 = x1991
              x1995 = x1990
            }
            val x2010 = if (x1995) {
              x1965 = false
              ()
            } else {
              val x2000 = x1960
              val x2001 = x1961
              val x2002 = x1962
              x1960 = x2000
              x1961 = false
              x1962 = x1996
              x1966 = x1996
              ()
            }
            x2010
          }
          val x2013 = x1960
          val x2014 = x1961
          val x2015 = x1962
          var x2041: StringReader = null
          var x2040: Boolean = false
          if (x2014) {
            x2041 = x1957
            x2040 = true
          } else {
            val x2018 = x2015.offset
            val x2019 = x2015.input
            val x2020 = x2019.length
            val x2021 = x2018 >= x2020
            var x2036: StringReader = null
            var x2035: Boolean = false
            if (x2021) {
              x2036 = x2015
              x2035 = true
            } else {
              val x2023 = x2019(x2018)
              val x2024 = x2023 == ']'
              var x2031: StringReader = null
              var x2030: Boolean = false
              if (x2024) {
                val x2025 = x2018 + 1
                val x2026 = new StringReader(x2019, x2025)
                x2031 = x2026
                x2030 = false
              } else {
                x2031 = x2015
                x2030 = true
              }
              x2036 = x2031
              x2035 = x2030
            }
            x2041 = x2036
            x2040 = x2035
          }
          var x2048: StringReader = null
          var x2047: Boolean = false
          var x2046: scala.collection.immutable.List[Anon6507737] = null
          if (x2040) {
            x2048 = x4
            x2047 = true
            x2046 = null
          } else {
            val x2043 = x1955.res
            x2048 = x2041
            x2047 = false
            x2046 = x2043
          }
          val x2049 = new ParseResultListAnon6507737B(x2046, x2047, x2048)
          x2049
        }
        val x2054 = x2052.next
        val x2053 = x2052.empty
        var x2062: Boolean = false
        var x2061: Anon6507737 = null
        if (x2053) {
          x2062 = true
          x2061 = null
        } else {
          val x2056 = x2052.res
          val x2057 = x2056.asInstanceOf[scala.collection.immutable.List[Anon6507737]]
          val x2058 = new Anon6507737(6, x2057)
          x2062 = false
          x2061 = x2058
        }
        val x2063 = new ParseResultAnon6507737B(x2061, x2062, x2054)
        x2063
      } else {
        x1624
      }
      x2066: ParseResultAnon6507737B
    }
    x3148 = { x3145: (StringReader) =>
      val x3146 = x2068(x3145)
      x3146: ParseResultAnon6507737B
    }
    val x2069 = px2069 // static data: 5
    var x2084: Boolean = true
    var x2083: Int = 0
    val x2070 = px2070 // static data: Array(f,a,l,s,e)
    val x2071 = new Anon6507737(1, null)
    val x2124 = { x2076: (StringReader) =>
      val x2077 = x2076.offset
      val x2078 = x2077 + x2069
      val x2079 = x2076.input
      val x2080 = x2079.length
      val x2081 = x2078 > x2080
      var x2116: StringReader = null
      var x2115: Boolean = false
      if (x2081) {
        x2116 = x2076
        x2115 = true
      } else {
        val x2102 = while ({
          val x2085 = x2084
          val x2086 = x2083
          val x2087 = x2086 < x2069
          val x2088 = x2085 && x2087
          x2088
        }) {
          val x2090 = x2083
          val x2091 = x2077 + x2090
          val x2092 = x2079(x2091)
          val x2093 = x2070(x2090)
          val x2095 = x2092 == x2093
          val x2098 = if (x2095) {
            ()
          } else {
            x2084 = false
            ()
          }
          val x2099 = x2090 + 1
          x2083 = x2099
          ()
        }
        val x2103 = x2084
        var x2109: StringReader = null
        var x2108: Boolean = false
        if (x2103) {
          val x2104 = new StringReader(x2079, x2078)
          x2109 = x2104
          x2108 = false
        } else {
          x2109 = x2076
          x2108 = true
        }
        x2116 = x2109
        x2115 = x2108
      }
      var x2121: Anon6507737 = null
      var x2122: Boolean = false
      if (x2115) {
        x2121 = null
        x2122 = true
      } else {
        x2121 = x2071
        x2122 = false
      }
      val x2123 = new ParseResultAnon6507737B(x2121, x2122, x2116)
      x2123: ParseResultAnon6507737B
    }
    val x2072 = px2072 // static data: 4
    var x2134: Boolean = true
    var x2133: Int = 0
    val x2073 = px2073 // static data: Array(t,r,u,e)
    val x2074 = new Anon6507737(2, null)
    val x2175 = { x2075: (StringReader) =>
      val x2125 = x2124(x2075)
      val x2126 = x2125.empty
      val x2174 = if (x2126) {
        val x2127 = x2075.offset
        val x2128 = x2127 + x2072
        val x2129 = x2075.input
        val x2130 = x2129.length
        val x2131 = x2128 > x2130
        var x2166: StringReader = null
        var x2165: Boolean = false
        if (x2131) {
          x2166 = x2075
          x2165 = true
        } else {
          val x2152 = while ({
            val x2135 = x2134
            val x2136 = x2133
            val x2137 = x2136 < x2072
            val x2138 = x2135 && x2137
            x2138
          }) {
            val x2140 = x2133
            val x2141 = x2127 + x2140
            val x2142 = x2129(x2141)
            val x2143 = x2073(x2140)
            val x2145 = x2142 == x2143
            val x2148 = if (x2145) {
              ()
            } else {
              x2134 = false
              ()
            }
            val x2149 = x2140 + 1
            x2133 = x2149
            ()
          }
          val x2153 = x2134
          var x2159: StringReader = null
          var x2158: Boolean = false
          if (x2153) {
            val x2154 = new StringReader(x2129, x2128)
            x2159 = x2154
            x2158 = false
          } else {
            x2159 = x2075
            x2158 = true
          }
          x2166 = x2159
          x2165 = x2158
        }
        var x2171: Anon6507737 = null
        var x2172: Boolean = false
        if (x2165) {
          x2171 = null
          x2172 = true
        } else {
          x2171 = x2074
          x2172 = false
        }
        val x2173 = new ParseResultAnon6507737B(x2171, x2172, x2166)
        x2173
      } else {
        x2125
      }
      x2174: ParseResultAnon6507737B
    }
    val x2181 = { x2179: (StringReader) =>
      val x2180 = x2175(x2179)
      x2180: ParseResultAnon6507737B
    }
    var x2191: Boolean = true
    var x2190: Int = 0
    val x2176 = px2176 // static data: Array(n,u,l,l)
    val x2177 = new Anon6507737(0, null)
    val x2232 = { x2178: (StringReader) =>
      val x2182 = x2181(x2178)
      val x2183 = x2182.empty
      val x2231 = if (x2183) {
        val x2184 = x2178.offset
        val x2185 = x2184 + x2072
        val x2186 = x2178.input
        val x2187 = x2186.length
        val x2188 = x2185 > x2187
        var x2223: StringReader = null
        var x2222: Boolean = false
        if (x2188) {
          x2223 = x2178
          x2222 = true
        } else {
          val x2209 = while ({
            val x2192 = x2191
            val x2193 = x2190
            val x2194 = x2193 < x2072
            val x2195 = x2192 && x2194
            x2195
          }) {
            val x2197 = x2190
            val x2198 = x2184 + x2197
            val x2199 = x2186(x2198)
            val x2200 = x2176(x2197)
            val x2202 = x2199 == x2200
            val x2205 = if (x2202) {
              ()
            } else {
              x2191 = false
              ()
            }
            val x2206 = x2197 + 1
            x2190 = x2206
            ()
          }
          val x2210 = x2191
          var x2216: StringReader = null
          var x2215: Boolean = false
          if (x2210) {
            val x2211 = new StringReader(x2186, x2185)
            x2216 = x2211
            x2215 = false
          } else {
            x2216 = x2178
            x2215 = true
          }
          x2223 = x2216
          x2222 = x2215
        }
        var x2228: Anon6507737 = null
        var x2229: Boolean = false
        if (x2222) {
          x2228 = null
          x2229 = true
        } else {
          x2228 = x2177
          x2229 = false
        }
        val x2230 = new ParseResultAnon6507737B(x2228, x2229, x2223)
        x2230
      } else {
        x2182
      }
      x2231: ParseResultAnon6507737B
    }
    val x2236 = { x2234: (StringReader) =>
      val x2235 = x2232(x2234)
      x2235: ParseResultAnon6507737B
    }
    val x2259 = null.asInstanceOf[Char]
    val x2260 = new OptionChar(x2259, false)
    val x2563 = { x2233: (StringReader) =>
      val x2237 = x2236(x2233)
      val x2238 = x2237.empty
      val x2561 = if (x2238) {
        val x2239 = x2233.offset
        val x2240 = x2233.input
        val x2241 = x2240.length
        val x2242 = x2239 >= x2241
        var x2257: StringReader = null
        var x2256: Boolean = false
        var x2255: Char = ' '
        if (x2242) {
          x2257 = x2233
          x2256 = true
          x2255 = ' '
        } else {
          val x2244 = x2240(x2239)
          val x2245 = x2244 == '-'
          var x2252: StringReader = null
          var x2251: Boolean = false
          var x2250: Char = ' '
          if (x2245) {
            val x2246 = x2239 + 1
            val x2247 = new StringReader(x2240, x2246)
            x2252 = x2247
            x2251 = false
            x2250 = x2244
          } else {
            x2252 = x2233
            x2251 = true
            x2250 = ' '
          }
          x2257 = x2252
          x2256 = x2251
          x2255 = x2250
        }
        val x2267 = x2257.offset
        val x2268 = x2257.input
        val x2269 = x2268.length
        val x2270 = x2267 >= x2269
        var x2286: Boolean = false
        var x2287: StringReader = null
        var x2285: Char = ' '
        if (x2270) {
          x2286 = true
          x2287 = x2257
          x2285 = ' '
        } else {
          val x2272 = x2268(x2267)
          val x2273 = x2272 >= '0'
          val x2274 = x2272 <= '9'
          val x2275 = x2273 && x2274
          var x2281: Boolean = false
          var x2282: StringReader = null
          var x2280: Char = ' '
          if (x2275) {
            val x2276 = x2267 + 1
            val x2277 = new StringReader(x2268, x2276)
            x2281 = false
            x2282 = x2277
            x2280 = x2272
          } else {
            x2281 = true
            x2282 = x2257
            x2280 = ' '
          }
          x2286 = x2281
          x2287 = x2282
          x2285 = x2280
        }
        var x2359: Unit = ()
        var x2361: Boolean = false
        var x2362: StringReader = null
        var x2360: Tuple2CharString = null
        if (x2286) {
          x2359 = ()
          x2361 = true
          x2362 = x2257
          x2360 = null
        } else {
          var x2293: Boolean = false
          var x2292: java.lang.String = ""
          var x2294: StringReader = x2287
          var x2296: Int = -1
          var x2297: Boolean = true
          var x2298: StringReader = x2287
          val x2345 = while ({
            val x2299 = x2297
            val x2300 = x2296
            val x2301 = x2298
            val x2302 = x2301.offset
            val x2303 = x2300 != x2302
            val x2304 = x2299 && x2303
            x2304
          }) {
            val x2306 = x2298
            val x2307 = x2306.offset
            x2296 = x2307
            val x2309 = x2306.input
            val x2310 = x2309.length
            val x2311 = x2307 >= x2310
            var x2327: Boolean = false
            var x2326: Char = ' '
            var x2328: StringReader = null
            if (x2311) {
              x2327 = true
              x2326 = ' '
              x2328 = x2306
            } else {
              val x2313 = x2309(x2307)
              val x2314 = x2313 >= '0'
              val x2315 = x2313 <= '9'
              val x2316 = x2314 && x2315
              var x2322: Boolean = false
              var x2321: Char = ' '
              var x2323: StringReader = null
              if (x2316) {
                val x2317 = x2307 + 1
                val x2318 = new StringReader(x2309, x2317)
                x2322 = false
                x2321 = x2313
                x2323 = x2318
              } else {
                x2322 = true
                x2321 = ' '
                x2323 = x2306
              }
              x2327 = x2322
              x2326 = x2321
              x2328 = x2323
            }
            val x2343 = if (x2327) {
              x2297 = false
              ()
            } else {
              val x2332 = x2292
              val x2333 = x2293
              val x2334 = x2294
              val x2336 = x2332 + x2326
              x2292 = x2336
              x2293 = false
              x2294 = x2328
              x2298 = x2328
              ()
            }
            x2343
          }
          val x2347 = x2293
          val x2348 = x2294
          val x2346 = x2292
          var x2354: Boolean = false
          var x2355: StringReader = null
          var x2353: Tuple2CharString = null
          if (x2347) {
            x2354 = true
            x2355 = x2257
            x2353 = null
          } else {
            val x2350 = new Tuple2CharString(x2285, x2346)
            x2354 = false
            x2355 = x2348
            x2353 = x2350
          }
          // Barrier sync: TODO: Hack!
          x2359 = ()
          x2361 = x2354
          x2362 = x2355
          x2360 = x2353
        }
        var x2371: Boolean = false
        var x2370: java.lang.String = null
        if (x2361) {
          x2371 = true
          x2370 = null
        } else {
          val x2365 = x2360._1
          val x2366 = x2360._2
          val x2367 = x2365 + x2366
          x2371 = false
          x2370 = x2367
        }
        var x2378: Boolean = false
        var x2379: StringReader = null
        var x2377: Tuple2OptionCharString = null
        if (x2371) {
          x2378 = true
          x2379 = x2233
          x2377 = null
        } else {
          val x2265 = if (x2256) {
            x2260
          } else {
            val x2262 = new OptionChar(x2255, true)
            x2262
          }
          val x2374 = new Tuple2OptionCharString(x2265, x2370)
          x2378 = false
          x2379 = x2362
          x2377 = x2374
        }
        var x2391: Boolean = false
        var x2390: java.lang.String = null
        if (x2378) {
          x2391 = true
          x2390 = null
        } else {
          val x2382 = x2377._1
          val x2384 = x2382.defined
          val x2387 = if (x2384) {
            val x2383 = x2377._2
            val x2385 = x2382.value
            val x2386 = x2385 + x2383
            x2386
          } else {
            val x2383 = x2377._2
            x2383
          }
          x2391 = false
          x2390 = x2387
        }
        var x2536: Unit = ()
        var x2539: StringReader = null
        var x2538: Boolean = false
        var x2537: Tuple2StringString = null
        if (x2391) {
          x2536 = ()
          x2539 = x2233
          x2538 = true
          x2537 = null
        } else {
          val x2394 = x2379.offset
          val x2395 = x2379.input
          val x2396 = x2395.length
          val x2397 = x2394 >= x2396
          var x2411: Boolean = false
          var x2412: StringReader = null
          if (x2397) {
            x2411 = true
            x2412 = x2379
          } else {
            val x2399 = x2395(x2394)
            val x2400 = x2399 == '.'
            var x2406: Boolean = false
            var x2407: StringReader = null
            if (x2400) {
              val x2401 = x2394 + 1
              val x2402 = new StringReader(x2395, x2401)
              x2406 = false
              x2407 = x2402
            } else {
              x2406 = true
              x2407 = x2379
            }
            x2411 = x2406
            x2412 = x2407
          }
          var x2522: Unit = ()
          var x2524: Boolean = false
          var x2525: StringReader = null
          var x2523: java.lang.String = null
          if (x2411) {
            x2522 = ()
            x2524 = true
            x2525 = x2379
            x2523 = null
          } else {
            val x2414 = x2412.offset
            val x2415 = x2412.input
            val x2416 = x2415.length
            val x2417 = x2414 >= x2416
            var x2433: Boolean = false
            var x2434: StringReader = null
            var x2432: Char = ' '
            if (x2417) {
              x2433 = true
              x2434 = x2412
              x2432 = ' '
            } else {
              val x2419 = x2415(x2414)
              val x2420 = x2419 >= '0'
              val x2421 = x2419 <= '9'
              val x2422 = x2420 && x2421
              var x2428: Boolean = false
              var x2429: StringReader = null
              var x2427: Char = ' '
              if (x2422) {
                val x2423 = x2414 + 1
                val x2424 = new StringReader(x2415, x2423)
                x2428 = false
                x2429 = x2424
                x2427 = x2419
              } else {
                x2428 = true
                x2429 = x2412
                x2427 = ' '
              }
              x2433 = x2428
              x2434 = x2429
              x2432 = x2427
            }
            var x2506: Unit = ()
            var x2508: Boolean = false
            var x2509: StringReader = null
            var x2507: Tuple2CharString = null
            if (x2433) {
              x2506 = ()
              x2508 = true
              x2509 = x2412
              x2507 = null
            } else {
              var x2440: Boolean = false
              var x2439: java.lang.String = ""
              var x2441: StringReader = x2434
              var x2443: Int = -1
              var x2444: Boolean = true
              var x2445: StringReader = x2434
              val x2492 = while ({
                val x2446 = x2444
                val x2447 = x2443
                val x2448 = x2445
                val x2449 = x2448.offset
                val x2450 = x2447 != x2449
                val x2451 = x2446 && x2450
                x2451
              }) {
                val x2453 = x2445
                val x2454 = x2453.offset
                x2443 = x2454
                val x2456 = x2453.input
                val x2457 = x2456.length
                val x2458 = x2454 >= x2457
                var x2474: Boolean = false
                var x2473: Char = ' '
                var x2475: StringReader = null
                if (x2458) {
                  x2474 = true
                  x2473 = ' '
                  x2475 = x2453
                } else {
                  val x2460 = x2456(x2454)
                  val x2461 = x2460 >= '0'
                  val x2462 = x2460 <= '9'
                  val x2463 = x2461 && x2462
                  var x2469: Boolean = false
                  var x2468: Char = ' '
                  var x2470: StringReader = null
                  if (x2463) {
                    val x2464 = x2454 + 1
                    val x2465 = new StringReader(x2456, x2464)
                    x2469 = false
                    x2468 = x2460
                    x2470 = x2465
                  } else {
                    x2469 = true
                    x2468 = ' '
                    x2470 = x2453
                  }
                  x2474 = x2469
                  x2473 = x2468
                  x2475 = x2470
                }
                val x2490 = if (x2474) {
                  x2444 = false
                  ()
                } else {
                  val x2479 = x2439
                  val x2480 = x2440
                  val x2481 = x2441
                  val x2483 = x2479 + x2473
                  x2439 = x2483
                  x2440 = false
                  x2441 = x2475
                  x2445 = x2475
                  ()
                }
                x2490
              }
              val x2494 = x2440
              val x2495 = x2441
              val x2493 = x2439
              var x2501: Boolean = false
              var x2502: StringReader = null
              var x2500: Tuple2CharString = null
              if (x2494) {
                x2501 = true
                x2502 = x2412
                x2500 = null
              } else {
                val x2497 = new Tuple2CharString(x2432, x2493)
                x2501 = false
                x2502 = x2495
                x2500 = x2497
              }
              // Barrier sync: TODO: Hack!
              x2506 = ()
              x2508 = x2501
              x2509 = x2502
              x2507 = x2500
            }
            var x2518: Boolean = false
            var x2517: java.lang.String = null
            if (x2508) {
              x2518 = true
              x2517 = null
            } else {
              val x2512 = x2507._1
              val x2513 = x2507._2
              val x2514 = x2512 + x2513
              x2518 = false
              x2517 = x2514
            }
            x2522 = ()
            x2524 = x2518
            x2525 = x2509
            x2523 = x2517
          }
          var x2532: StringReader = null
          var x2531: Boolean = false
          var x2530: Tuple2StringString = null
          if (x2524) {
            x2532 = x2233
            x2531 = true
            x2530 = null
          } else {
            val x2527 = new Tuple2StringString(x2390, x2523)
            x2532 = x2525
            x2531 = false
            x2530 = x2527
          }
          x2536 = ()
          x2539 = x2532
          x2538 = x2531
          x2537 = x2530
        }
        var x2550: Boolean = false
        var x2549: Double = 0.0
        if (x2538) {
          x2550 = true
          x2549 = 0.0
        } else {
          val x2543 = x2537._2
          val x2542 = x2537._1
          val x2544 = x2542 + "."
          val x2545 = x2544 + x2543
          val x2546 = x2545.toDouble
          x2550 = false
          x2549 = x2546
        }
        var x2556: Anon6507737 = null
        var x2557: Boolean = false
        if (x2550) {
          x2556 = null
          x2557 = true
        } else {
          val x2553 = new Anon6507737(4, x2549)
          x2556 = x2553
          x2557 = false
        }
        val x2558 = new ParseResultAnon6507737B(x2556, x2557, x2539)
        x2558
      } else {
        x2237
      }
      x2561: ParseResultAnon6507737B
    }
    val x2568 = { x2565: (StringReader) =>
      val x2566 = x2563(x2565)
      x2566: ParseResultAnon6507737B
    }
    val x2739 = { x2564: (StringReader) =>
      val x2569 = x2568(x2564)
      val x2570 = x2569.empty
      val x2737 = if (x2570) {
        val x2571 = x2564.offset
        val x2572 = x2564.input
        val x2573 = x2572.length
        val x2574 = x2571 >= x2573
        var x2589: StringReader = null
        var x2588: Boolean = false
        var x2587: Char = ' '
        if (x2574) {
          x2589 = x2564
          x2588 = true
          x2587 = ' '
        } else {
          val x2576 = x2572(x2571)
          val x2577 = x2576 == '-'
          var x2584: StringReader = null
          var x2583: Boolean = false
          var x2582: Char = ' '
          if (x2577) {
            val x2578 = x2571 + 1
            val x2579 = new StringReader(x2572, x2578)
            x2584 = x2579
            x2583 = false
            x2582 = x2576
          } else {
            x2584 = x2564
            x2583 = true
            x2582 = ' '
          }
          x2589 = x2584
          x2588 = x2583
          x2587 = x2582
        }
        val x2597 = x2589.offset
        val x2598 = x2589.input
        val x2599 = x2598.length
        val x2600 = x2597 >= x2599
        var x2616: Boolean = false
        var x2615: Char = ' '
        var x2617: StringReader = null
        if (x2600) {
          x2616 = true
          x2615 = ' '
          x2617 = x2589
        } else {
          val x2602 = x2598(x2597)
          val x2603 = x2602 >= '0'
          val x2604 = x2602 <= '9'
          val x2605 = x2603 && x2604
          var x2611: Boolean = false
          var x2610: Char = ' '
          var x2612: StringReader = null
          if (x2605) {
            val x2606 = x2597 + 1
            val x2607 = new StringReader(x2598, x2606)
            x2611 = false
            x2610 = x2602
            x2612 = x2607
          } else {
            x2611 = true
            x2610 = ' '
            x2612 = x2589
          }
          x2616 = x2611
          x2615 = x2610
          x2617 = x2612
        }
        var x2625: Boolean = false
        var x2624: Int = 0
        if (x2616) {
          x2625 = true
          x2624 = 0
        } else {
          val x2620 = x2615 - '0'
          val x2621 = x2620.toInt
          x2625 = false
          x2624 = x2621
        }
        var x2704: Unit = ()
        var x2706: Boolean = false
        var x2707: StringReader = null
        var x2705: Int = 0
        if (x2625) {
          x2704 = ()
          x2706 = true
          x2707 = x2589
          x2705 = 0
        } else {
          var x2630: Int = x2624
          var x2631: Boolean = false
          var x2632: StringReader = x2617
          var x2634: Int = -1
          var x2635: Boolean = true
          var x2636: StringReader = x2617
          val x2692 = while ({
            val x2637 = x2635
            val x2638 = x2634
            val x2639 = x2636
            val x2640 = x2639.offset
            val x2641 = x2638 != x2640
            val x2642 = x2637 && x2641
            x2642
          }) {
            val x2644 = x2636
            val x2645 = x2644.offset
            x2634 = x2645
            val x2647 = x2644.input
            val x2648 = x2647.length
            val x2649 = x2645 >= x2648
            var x2665: Boolean = false
            var x2664: Char = ' '
            var x2666: StringReader = null
            if (x2649) {
              x2665 = true
              x2664 = ' '
              x2666 = x2644
            } else {
              val x2651 = x2647(x2645)
              val x2652 = x2651 >= '0'
              val x2653 = x2651 <= '9'
              val x2654 = x2652 && x2653
              var x2660: Boolean = false
              var x2659: Char = ' '
              var x2661: StringReader = null
              if (x2654) {
                val x2655 = x2645 + 1
                val x2656 = new StringReader(x2647, x2655)
                x2660 = false
                x2659 = x2651
                x2661 = x2656
              } else {
                x2660 = true
                x2659 = ' '
                x2661 = x2644
              }
              x2665 = x2660
              x2664 = x2659
              x2666 = x2661
            }
            var x2674: Boolean = false
            var x2673: Int = 0
            if (x2665) {
              x2674 = true
              x2673 = 0
            } else {
              val x2669 = x2664 - '0'
              val x2670 = x2669.toInt
              x2674 = false
              x2673 = x2670
            }
            val x2690 = if (x2674) {
              x2635 = false
              ()
            } else {
              val x2678 = x2630
              val x2679 = x2631
              val x2680 = x2632
              val x2682 = x2678 * 10
              val x2683 = x2682 + x2673
              x2630 = x2683
              x2631 = false
              x2632 = x2666
              x2636 = x2666
              ()
            }
            x2690
          }
          val x2693 = x2630
          val x2694 = x2631
          val x2695 = x2632
          var x2699: Boolean = false
          var x2700: StringReader = null
          var x2698: Int = 0
          if (x2694) {
            x2699 = true
            x2700 = x2589
            x2698 = 0
          } else {
            x2699 = x2694
            x2700 = x2695
            x2698 = x2693
          }
          // Barrier sync: TODO: Hack!
          x2704 = ()
          x2706 = x2699
          x2707 = x2700
          x2705 = x2698
        }
        var x2715: StringReader = null
        var x2714: Boolean = false
        var x2713: Tuple2OptionCharInt = null
        if (x2706) {
          x2715 = x2564
          x2714 = true
          x2713 = null
        } else {
          val x2595 = if (x2588) {
            x2260
          } else {
            val x2592 = new OptionChar(x2587, true)
            x2592
          }
          val x2710 = new Tuple2OptionCharInt(x2595, x2705)
          x2715 = x2707
          x2714 = false
          x2713 = x2710
        }
        var x2726: Boolean = false
        var x2725: Int = 0
        if (x2714) {
          x2726 = true
          x2725 = 0
        } else {
          val x2718 = x2713._1
          val x2720 = x2718.defined
          val x2722 = if (x2720) {
            val x2719 = x2713._2
            val x2721 = -1 * x2719
            x2721
          } else {
            val x2719 = x2713._2
            x2719
          }
          x2726 = false
          x2725 = x2722
        }
        var x2732: Anon6507737 = null
        var x2733: Boolean = false
        if (x2726) {
          x2732 = null
          x2733 = true
        } else {
          val x2729 = new Anon6507737(3, x2725)
          x2732 = x2729
          x2733 = false
        }
        val x2734 = new ParseResultAnon6507737B(x2732, x2733, x2715)
        x2734
      } else {
        x2569
      }
      x2737: ParseResultAnon6507737B
    }
    val x2744 = { x2741: (StringReader) =>
      val x2742 = x2739(x2741)
      x2742: ParseResultAnon6507737B
    }
    val x2830 = { x2790: (StringReader) =>
      val x2791 = x2790.offset
      val x2792 = x2790.input
      val x2793 = x2792.length
      val x2794 = x2791 >= x2793
      var x2808: Boolean = false
      var x2809: StringReader = null
      if (x2794) {
        x2808 = true
        x2809 = x2790
      } else {
        val x2796 = x2792(x2791)
        val x2797 = x2796 == '\\'
        var x2803: Boolean = false
        var x2804: StringReader = null
        if (x2797) {
          val x2798 = x2791 + 1
          val x2799 = new StringReader(x2792, x2798)
          x2803 = false
          x2804 = x2799
        } else {
          x2803 = true
          x2804 = x2790
        }
        x2808 = x2803
        x2809 = x2804
      }
      var x2826: Char = ' '
      var x2827: Boolean = false
      var x2828: StringReader = null
      if (x2808) {
        x2826 = ' '
        x2827 = true
        x2828 = x2790
      } else {
        val x2811 = x2809.offset
        val x2812 = x2809.input
        val x2813 = x2812.length
        val x2814 = x2811 >= x2813
        var x2821: Char = ' '
        var x2822: Boolean = false
        var x2823: StringReader = null
        if (x2814) {
          x2821 = ' '
          x2822 = true
          x2823 = x2809
        } else {
          val x2816 = x2812(x2811)
          val x2817 = x2811 + 1
          val x2818 = new StringReader(x2812, x2817)
          x2821 = x2816
          x2822 = false
          x2823 = x2818
        }
        x2826 = x2821
        x2827 = x2822
        x2828 = x2823
      }
      val x2829 = new ParseResultCharB(x2826, x2827, x2828)
      x2829: ParseResultCharB
    }
    val x2855 = { x2789: (StringReader) =>
      val x2831 = x2830(x2789)
      val x2832 = x2831.empty
      val x2854 = if (x2832) {
        val x2833 = x2789.offset
        val x2834 = x2789.input
        val x2835 = x2834.length
        val x2836 = x2833 >= x2835
        var x2850: Char = ' '
        var x2851: Boolean = false
        var x2852: StringReader = null
        if (x2836) {
          x2850 = ' '
          x2851 = true
          x2852 = x2789
        } else {
          val x2838 = x2834(x2833)
          val x2840 = x2838 == '"'
          var x2845: Char = ' '
          var x2846: Boolean = false
          var x2847: StringReader = null
          if (x2840) {
            x2845 = ' '
            x2846 = true
            x2847 = x2789
          } else {
            val x2841 = x2833 + 1
            val x2842 = new StringReader(x2834, x2841)
            x2845 = x2838
            x2846 = false
            x2847 = x2842
          }
          x2850 = x2845
          x2851 = x2846
          x2852 = x2847
        }
        val x2853 = new ParseResultCharB(x2850, x2851, x2852)
        x2853
      } else {
        x2831
      }
      x2854: ParseResultCharB
    }
    val x3143 = { x2740: (StringReader) =>
      val x2745 = x2744(x2740)
      val x2746 = x2745.empty
      val x3141 = if (x2746) {
        val x2747 = x2740.offset
        val x2748 = x2740.input
        val x2749 = x2748.length
        val x2750 = x2747 >= x2749
        var x2764: Boolean = false
        var x2765: StringReader = null
        if (x2750) {
          x2764 = true
          x2765 = x2740
        } else {
          val x2752 = x2748(x2747)
          val x2753 = x2752 == '"'
          var x2759: Boolean = false
          var x2760: StringReader = null
          if (x2753) {
            val x2754 = x2747 + 1
            val x2755 = new StringReader(x2748, x2754)
            x2759 = false
            x2760 = x2755
          } else {
            x2759 = true
            x2760 = x2740
          }
          x2764 = x2759
          x2765 = x2760
        }
        var x2898: Unit = ()
        var x2900: Boolean = false
        var x2901: StringReader = null
        var x2899: Tuple2IntInt = null
        if (x2764) {
          x2898 = ()
          x2900 = true
          x2901 = x2740
          x2899 = null
        } else {
          var x2773: Boolean = false
          var x2772: java.lang.String = ""
          var x2774: StringReader = x2765
          var x2776: Int = -1
          var x2777: Boolean = true
          var x2778: StringReader = x2765
          val x2874 = while ({
            val x2779 = x2777
            val x2780 = x2776
            val x2781 = x2778
            val x2782 = x2781.offset
            val x2783 = x2780 != x2782
            val x2784 = x2779 && x2783
            x2784
          }) {
            val x2786 = x2778
            val x2787 = x2786.offset
            x2776 = x2787
            val x2856 = x2855(x2786)
            val x2857 = x2856.empty
            val x2872 = if (x2857) {
              x2777 = false
              ()
            } else {
              val x2860 = x2772
              val x2861 = x2773
              val x2862 = x2774
              x2772 = x2860
              x2773 = false
              val x2865 = x2856.next
              x2774 = x2865
              x2778 = x2865
              ()
            }
            x2872
          }
          val x2876 = x2773
          val x2877 = x2774
          var x2883: Boolean = false
          var x2884: StringReader = null
          var x2882: Int = 0
          if (x2876) {
            x2883 = true
            x2884 = x2765
            x2882 = 0
          } else {
            val x2768 = x2765.offset
            x2883 = false
            x2884 = x2877
            x2882 = x2768
          }
          var x2893: Boolean = false
          var x2894: StringReader = null
          var x2892: Tuple2IntInt = null
          if (x2883) {
            x2893 = true
            x2894 = x2765
            x2892 = null
          } else {
            val x2887 = x2884.offset
            val x2889 = new Tuple2IntInt(x2882, x2887)
            x2893 = false
            x2894 = x2884
            x2892 = x2889
          }
          // Barrier sync: TODO: Hack!
          val x2875 = x2772
          x2898 = ()
          x2900 = x2893
          x2901 = x2894
          x2899 = x2892
        }
        var x2931: Boolean = false
        var x2930: Tuple2IntInt = null
        var x2932: StringReader = null
        if (x2900) {
          x2931 = x2900
          x2930 = x2899
          x2932 = x2901
        } else {
          val x2903 = x2901.offset
          val x2904 = x2901.input
          val x2905 = x2904.length
          val x2906 = x2903 >= x2905
          var x2920: Boolean = false
          var x2921: StringReader = null
          if (x2906) {
            x2920 = true
            x2921 = x2901
          } else {
            val x2908 = x2904(x2903)
            val x2909 = x2908 == '"'
            var x2915: Boolean = false
            var x2916: StringReader = null
            if (x2909) {
              val x2910 = x2903 + 1
              val x2911 = new StringReader(x2904, x2910)
              x2915 = false
              x2916 = x2911
            } else {
              x2915 = true
              x2916 = x2901
            }
            x2920 = x2915
            x2921 = x2916
          }
          var x2926: Boolean = false
          var x2925: Tuple2IntInt = null
          var x2927: StringReader = null
          if (x2920) {
            x2926 = true
            x2925 = null
            x2927 = x2740
          } else {
            x2926 = false
            x2925 = x2899
            x2927 = x2921
          }
          x2931 = x2926
          x2930 = x2925
          x2932 = x2927
        }
        var x3127: Unit = ()
        var x3130: StringReader = null
        var x3129: Boolean = false
        var x3128: java.lang.String = null
        if (x2931) {
          x3127 = ()
          x3130 = x2740
          x3129 = true
          x3128 = null
        } else {
          var x3108: java.lang.String = ""
          val x2935 = x2930._1
          val x2936 = x2930._2
          val x2944 = x2936 - x2935
          val x2945 = new Array[Char](x2944)
          var x2938: Int = x2935
          val x2939 = x2938
          var x2940: Int = x2939
          var x2941: Int = 0
          val x2942 = x2941
          var x2943: Int = x2942
          val x2949 = x2932.input
          val x3105 = while ({
            val x2946 = x2940
            val x2947 = x2946 < x2936
            x2947
          }) {
            val x2950 = x2940
            val x2951 = x2949(x2950)
            val x2952 = x2951 == '\\'
            val x2953 = x2950 + 1
            val x2954 = x2953 < x2936
            val x2955 = x2952 && x2954
            val x3102 = if (x2955) {
              val x2956 = x2949(x2953)
              val x2957 = x2956 == 'u'
              val x2958 = x2950 + 5
              val x2959 = x2958 < x2936
              val x2960 = x2957 && x2959
              val x3095 = if (x2960) {
                val x3046 = x2943
                val x2961 = x2950 + 2
                val x2962 = x2949(x2961)
                val x2963 = x2962 >= '0'
                val x2964 = x2962 < '9'
                val x2965 = x2963 && x2964
                val x2980 = if (x2965) {
                  val x2966 = x2962 - '0'
                  val x2967 = x2966.toInt
                  x2967
                } else {
                  val x2968 = x2962 >= 'A'
                  val x2969 = x2962 < 'F'
                  val x2970 = x2968 && x2969
                  val x2979 = if (x2970) {
                    val x2971 = x2962 - '7'
                    val x2972 = x2971.toInt
                    x2972
                  } else {
                    val x2973 = x2962 >= 'a'
                    val x2974 = x2962 < 'f'
                    val x2975 = x2973 && x2974
                    val x2978 = if (x2975) {
                      val x2976 = x2962 - 'W'
                      val x2977 = x2976.toInt
                      x2977
                    } else {
                      0
                    }
                    x2978
                  }
                  x2979
                }
                val x2981 = x2980 * 4096
                val x2982 = x2950 + 3
                val x2983 = x2949(x2982)
                val x2984 = x2983 >= '0'
                val x2985 = x2983 < '9'
                val x2986 = x2984 && x2985
                val x3001 = if (x2986) {
                  val x2987 = x2983 - '0'
                  val x2988 = x2987.toInt
                  x2988
                } else {
                  val x2989 = x2983 >= 'A'
                  val x2990 = x2983 < 'F'
                  val x2991 = x2989 && x2990
                  val x3000 = if (x2991) {
                    val x2992 = x2983 - '7'
                    val x2993 = x2992.toInt
                    x2993
                  } else {
                    val x2994 = x2983 >= 'a'
                    val x2995 = x2983 < 'f'
                    val x2996 = x2994 && x2995
                    val x2999 = if (x2996) {
                      val x2997 = x2983 - 'W'
                      val x2998 = x2997.toInt
                      x2998
                    } else {
                      0
                    }
                    x2999
                  }
                  x3000
                }
                val x3002 = x3001 * 256
                val x3003 = x2981 + x3002
                val x3004 = x2950 + 4
                val x3005 = x2949(x3004)
                val x3006 = x3005 >= '0'
                val x3007 = x3005 < '9'
                val x3008 = x3006 && x3007
                val x3023 = if (x3008) {
                  val x3009 = x3005 - '0'
                  val x3010 = x3009.toInt
                  x3010
                } else {
                  val x3011 = x3005 >= 'A'
                  val x3012 = x3005 < 'F'
                  val x3013 = x3011 && x3012
                  val x3022 = if (x3013) {
                    val x3014 = x3005 - '7'
                    val x3015 = x3014.toInt
                    x3015
                  } else {
                    val x3016 = x3005 >= 'a'
                    val x3017 = x3005 < 'f'
                    val x3018 = x3016 && x3017
                    val x3021 = if (x3018) {
                      val x3019 = x3005 - 'W'
                      val x3020 = x3019.toInt
                      x3020
                    } else {
                      0
                    }
                    x3021
                  }
                  x3022
                }
                val x3024 = x3023 * 16
                val x3025 = x3003 + x3024
                val x3026 = x2949(x2958)
                val x3027 = x3026 >= '0'
                val x3028 = x3026 < '9'
                val x3029 = x3027 && x3028
                val x3044 = if (x3029) {
                  val x3030 = x3026 - '0'
                  val x3031 = x3030.toInt
                  x3031
                } else {
                  val x3032 = x3026 >= 'A'
                  val x3033 = x3026 < 'F'
                  val x3034 = x3032 && x3033
                  val x3043 = if (x3034) {
                    val x3035 = x3026 - '7'
                    val x3036 = x3035.toInt
                    x3036
                  } else {
                    val x3037 = x3026 >= 'a'
                    val x3038 = x3026 < 'f'
                    val x3039 = x3037 && x3038
                    val x3042 = if (x3039) {
                      val x3040 = x3026 - 'W'
                      val x3041 = x3040.toInt
                      x3041
                    } else {
                      0
                    }
                    x3042
                  }
                  x3043
                }
                val x3045 = x3025 + x3044
                val x3047 = x3045.toChar
                val x3048 = x2945(x3046) = x3047
                val x3049 = x2940 += 4
                ()
              } else {
                val x3051 = x2956 == 'b'
                val x3092 = if (x3051) {
                  val x3052 = x2943
                  val x3053 = x2945(x3052) = ''
                  x3053
                } else {
                  val x3055 = x2956 == 'f'
                  val x3088 = if (x3055) {
                    val x3056 = x2943
                    val x3057 = x2945(x3056) = ''
                    x3057
                  } else {
                    val x3059 = x2956 == 't'
                    val x3084 = if (x3059) {
                      val x3060 = x2943
                      val x3061 = x2945(x3060) = '	'
                      x3061
                    } else {
                      val x3063 = x2956 == 'n'
                      val x3080 = if (x3063) {
                        val x3064 = x2943
                        val x3065 = x2945(x3064) = '\n'
                        x3065
                      } else {
                        val x3067 = x2956 == 'r'
                        val x3076 = if (x3067) {
                          val x3068 = x2943
                          val x3069 = x2945(x3068) = '
'
                          x3069
                        } else {
                          val x3071 = x2943
                          val x3072 = x2945(x3071) = x2956
                          x3072
                        }
                        x3076
                      }
                      x3080
                    }
                    x3084
                  }
                  x3088
                }
                x3092
              }
              val x3096 = x2940 += 2
              ()
            } else {
              val x3098 = x2943
              val x3099 = x2945(x3098) = x2951
              val x3100 = x2940 += 1
              ()
            }
            val x3103 = x2943 += 1
            ()
          }
          var x3109: Int = 0
          val x3106 = x2943
          val x3122 = while ({
            val x3110 = x3109
            val x3111 = x3110 < x3106
            x3111
          }) {
            val x3113 = x3108
            val x3114 = x3109
            val x3115 = 0 + x3114
            val x3116 = x2945(x3115)
            val x3117 = x3113 + x3116
            x3108 = x3117
            val x3119 = x3114 + 1
            x3109 = x3119
            ()
          }
          val x3123 = x3108
          // Barrier sync: TODO: Hack!
          x3127 = ()
          x3130 = x2932
          x3129 = false
          x3128 = x3123
        }
        var x3136: Anon6507737 = null
        var x3137: Boolean = false
        if (x3129) {
          x3136 = null
          x3137 = true
        } else {
          val x3133 = new Anon6507737(5, x3128)
          x3136 = x3133
          x3137 = false
        }
        val x3138 = new ParseResultAnon6507737B(x3136, x3137, x3130)
        x3138
      } else {
        x2745
      }
      x3141: ParseResultAnon6507737B
    }
    x3156 = { x3144: (StringReader) =>
      val x3149 = x3148(x3144)
      val x3150 = x3149.empty
      val x3154 = if (x3150) {
        val x3151 = x3143(x3144)
        x3151
      } else {
        x3149
      }
      x3154: ParseResultAnon6507737B
    }
    val x1 = new StringReader(x0, 0)
    val x3159 = x2(x1)
    val x3160 = x3159.empty
    var x3166: Anon6507737 = null
    var x3167: Boolean = false
    if (x3160) {
      val x3161 = null.asInstanceOf[Anon6507737]
      x3166 = x3161
      x3167 = false
    } else {
      val x3163 = x3159.res
      x3166 = x3163
      x3167 = true
    }
    val x3168 = new OptionAnon6507737(x3166, x3167)
    x3168
  }
}
/**
 * ***************************************
 * End of Generated Code
 * *****************************************
 */
