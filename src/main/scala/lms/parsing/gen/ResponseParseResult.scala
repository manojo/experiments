package lms.parsing.gen

import java.io.{ BufferedReader, FileReader, Serializable }
import scala.collection.mutable.ArrayBuffer

object ResponseParseResult {

  def main(args: Array[String]) {

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

    val stagedParserStatic = new ResponseParseResult(
      "connection".toArray, // "connection".length,
      "proxy-connection".toArray, // "proxy-connection".length,
      "keep-alive".toArray, //"keep-alive".length,
      "close".toArray, //"close".length,
      "content-length".toArray, //"content-length".length,
      "transfer-encoding".toArray, //"transfer-encoding".length,
      "chunked".toArray, //"chunked".length,
      "upgrade".toArray //, "upgrade".length
    )

    val fileNames = List(1, 2, 3, 4, 6).map { x => "tweet" + x }

    val messages = fileNames.foldLeft(List[Array[Char]]()) {
      case (acc, fileName) =>
        val file = new BufferedReader(new FileReader("src/test/resources/" + fileName))
        val out = new ArrayBuffer[Char]

        var line = file.readLine
        while (line != null) {
          out ++= line + "\n"
          line = file.readLine
        }
        out.toArray :: acc
    }

    for (k <- 1 to 50) {
      val now = System.nanoTime
      for (i <- 1 to 100; m <- messages) {
        stagedParserStatic.apply(resp.toArray)
      }
      println("time taken: " + (System.nanoTime - now))
    }
  }
}

/**
 * ***************************************
 * Emitting Generated Code
 * *****************************************
 */

class ResponseParseResult(
    px1175: Array[Char], px1208: Array[Char], px1239: Array[Char], px1272: Array[Char],
    px1322: Array[Char], px1371: Array[Char], px1401: Array[Char], px1433: Array[Char]) extends ((Array[Char]) => (OptionAnon1323431030)) with Serializable {
  def apply(x0: Array[Char]): OptionAnon1323431030 = {
    val x3 = x0.length
    val x4 = 0 >= x3
    var x18: Boolean = false
    var x19: StringReader = null
    if (x4) {
      val x2 = new StringReader(x0, 0)
      x18 = true
      x19 = x2
    } else {
      val x6 = x0(0)
      val x7 = x6 == 'H'
      var x13: Boolean = false
      var x14: StringReader = null
      if (x7) {
        val x8 = 0 + 1
        val x9 = new StringReader(x0, x8)
        x13 = false
        x14 = x9
      } else {
        val x2 = new StringReader(x0, 0)
        x13 = true
        x14 = x2
      }
      x18 = x13
      x19 = x14
    }
    var x195: Boolean = false
    var x196: StringReader = null
    if (x18) {
      val x2 = new StringReader(x0, 0)
      x195 = true
      x196 = x2
    } else {
      val x22 = x19.offset
      val x23 = x19.input
      val x24 = x23.length
      val x25 = x22 >= x24
      var x39: Boolean = false
      var x40: StringReader = null
      if (x25) {
        x39 = true
        x40 = x19
      } else {
        val x27 = x23(x22)
        val x28 = x27 == 'T'
        var x34: Boolean = false
        var x35: StringReader = null
        if (x28) {
          val x29 = x22 + 1
          val x30 = new StringReader(x23, x29)
          x34 = false
          x35 = x30
        } else {
          x34 = true
          x35 = x19
        }
        x39 = x34
        x40 = x35
      }
      var x174: Boolean = false
      var x175: StringReader = null
      if (x39) {
        x174 = true
        x175 = x19
      } else {
        val x43 = x40.offset
        val x44 = x40.input
        val x45 = x44.length
        val x46 = x43 >= x45
        var x60: Boolean = false
        var x61: StringReader = null
        if (x46) {
          x60 = true
          x61 = x40
        } else {
          val x48 = x44(x43)
          val x49 = x48 == 'T'
          var x55: Boolean = false
          var x56: StringReader = null
          if (x49) {
            val x50 = x43 + 1
            val x51 = new StringReader(x44, x50)
            x55 = false
            x56 = x51
          } else {
            x55 = true
            x56 = x40
          }
          x60 = x55
          x61 = x56
        }
        var x153: Boolean = false
        var x154: StringReader = null
        if (x60) {
          x153 = true
          x154 = x40
        } else {
          val x64 = x61.offset
          val x65 = x61.input
          val x66 = x65.length
          val x67 = x64 >= x66
          var x81: Boolean = false
          var x82: StringReader = null
          if (x67) {
            x81 = true
            x82 = x61
          } else {
            val x69 = x65(x64)
            val x70 = x69 == 'P'
            var x76: Boolean = false
            var x77: StringReader = null
            if (x70) {
              val x71 = x64 + 1
              val x72 = new StringReader(x65, x71)
              x76 = false
              x77 = x72
            } else {
              x76 = true
              x77 = x61
            }
            x81 = x76
            x82 = x77
          }
          var x132: Boolean = false
          var x133: StringReader = null
          if (x81) {
            x132 = true
            x133 = x61
          } else {
            val x85 = x82.offset
            val x86 = x82.input
            val x87 = x86.length
            val x88 = x85 >= x87
            var x102: Boolean = false
            var x103: StringReader = null
            if (x88) {
              x102 = true
              x103 = x82
            } else {
              val x90 = x86(x85)
              val x91 = x90 == '/'
              var x97: Boolean = false
              var x98: StringReader = null
              if (x91) {
                val x92 = x85 + 1
                val x93 = new StringReader(x86, x92)
                x97 = false
                x98 = x93
              } else {
                x97 = true
                x98 = x82
              }
              x102 = x97
              x103 = x98
            }
            var x111: Boolean = false
            var x112: StringReader = null
            if (x102) {
              x111 = true
              x112 = x82
            } else {
              x111 = false
              x112 = x103
            }
            val x121 = if (x111) {
              true
            } else {
              false
            }
            var x127: Boolean = false
            var x128: StringReader = null
            if (x121) {
              x127 = true
              x128 = x61
            } else {
              x127 = false
              x128 = x112
            }
            x132 = x127
            x133 = x128
          }
          val x142 = if (x132) {
            true
          } else {
            false
          }
          var x148: Boolean = false
          var x149: StringReader = null
          if (x142) {
            x148 = true
            x149 = x40
          } else {
            x148 = false
            x149 = x133
          }
          x153 = x148
          x154 = x149
        }
        val x163 = if (x153) {
          true
        } else {
          false
        }
        var x169: Boolean = false
        var x170: StringReader = null
        if (x163) {
          x169 = true
          x170 = x19
        } else {
          x169 = false
          x170 = x154
        }
        x174 = x169
        x175 = x170
      }
      val x184 = if (x174) {
        true
      } else {
        false
      }
      var x190: Boolean = false
      var x191: StringReader = null
      if (x184) {
        val x2 = new StringReader(x0, 0)
        x190 = true
        x191 = x2
      } else {
        x190 = false
        x191 = x175
      }
      x195 = x190
      x196 = x191
    }
    val x205 = if (x195) {
      true
    } else {
      false
    }
    var x478: Boolean = false
    var x479: StringReader = null
    if (x205) {
      val x2 = new StringReader(x0, 0)
      x478 = true
      x479 = x2
    } else {
      val x208 = x196.offset
      val x209 = x196.input
      val x210 = x209.length
      val x211 = x208 >= x210
      var x227: Boolean = false
      var x226: Char = ' '
      var x228: StringReader = null
      if (x211) {
        x227 = true
        x226 = ' '
        x228 = x196
      } else {
        val x213 = x209(x208)
        val x214 = x213 >= '0'
        val x215 = x213 <= '9'
        val x216 = x214 && x215
        var x222: Boolean = false
        var x221: Char = ' '
        var x223: StringReader = null
        if (x216) {
          val x217 = x208 + 1
          val x218 = new StringReader(x209, x217)
          x222 = false
          x221 = x213
          x223 = x218
        } else {
          x222 = true
          x221 = ' '
          x223 = x196
        }
        x227 = x222
        x226 = x221
        x228 = x223
      }
      var x236: Boolean = false
      var x235: Int = 0
      if (x227) {
        x236 = true
        x235 = 0
      } else {
        val x231 = x226 - '0'
        val x232 = x231.toInt
        x236 = false
        x235 = x232
      }
      var x316: Boolean = false
      var x317: StringReader = null
      if (x236) {
        x316 = true
        x317 = x196
      } else {
        var x241: Boolean = false
        var x240: Int = x235
        var x242: StringReader = x228
        var x244: Int = -1
        var x245: Boolean = true
        var x246: StringReader = x228
        val x302 = while ({
          val x247 = x245
          val x248 = x244
          val x249 = x246
          val x250 = x249.offset
          val x251 = x248 != x250
          val x252 = x247 && x251
          x252
        }) {
          val x254 = x246
          val x255 = x254.offset
          x244 = x255
          val x257 = x254.input
          val x258 = x257.length
          val x259 = x255 >= x258
          var x275: Boolean = false
          var x274: Char = ' '
          var x276: StringReader = null
          if (x259) {
            x275 = true
            x274 = ' '
            x276 = x254
          } else {
            val x261 = x257(x255)
            val x262 = x261 >= '0'
            val x263 = x261 <= '9'
            val x264 = x262 && x263
            var x270: Boolean = false
            var x269: Char = ' '
            var x271: StringReader = null
            if (x264) {
              val x265 = x255 + 1
              val x266 = new StringReader(x257, x265)
              x270 = false
              x269 = x261
              x271 = x266
            } else {
              x270 = true
              x269 = ' '
              x271 = x254
            }
            x275 = x270
            x274 = x269
            x276 = x271
          }
          var x284: Boolean = false
          var x283: Int = 0
          if (x275) {
            x284 = true
            x283 = 0
          } else {
            val x279 = x274 - '0'
            val x280 = x279.toInt
            x284 = false
            x283 = x280
          }
          val x300 = if (x284) {
            x245 = false
            ()
          } else {
            val x288 = x240
            val x289 = x241
            val x290 = x242
            val x292 = x288 * 10
            val x293 = x292 + x283
            x240 = x293
            x241 = false
            x242 = x276
            x246 = x276
            ()
          }
          x300
        }
        val x304 = x241
        var x309: Boolean = false
        var x310: StringReader = null
        if (x304) {
          x309 = true
          x310 = x196
        } else {
          val x305 = x242
          x309 = x304
          x310 = x305
        }
        x316 = x309
        x317 = x310
      }
      var x466: Boolean = false
      var x467: StringReader = null
      if (x316) {
        x466 = true
        x467 = x196
      } else {
        val x320 = x317.offset
        val x321 = x317.input
        val x322 = x321.length
        val x323 = x320 >= x322
        var x337: Boolean = false
        var x338: StringReader = null
        if (x323) {
          x337 = true
          x338 = x317
        } else {
          val x325 = x321(x320)
          val x326 = x325 == '.'
          var x332: Boolean = false
          var x333: StringReader = null
          if (x326) {
            val x327 = x320 + 1
            val x328 = new StringReader(x321, x327)
            x332 = false
            x333 = x328
          } else {
            x332 = true
            x333 = x317
          }
          x337 = x332
          x338 = x333
        }
        var x454: Boolean = false
        var x455: StringReader = null
        if (x337) {
          x454 = true
          x455 = x317
        } else {
          val x341 = x338.offset
          val x342 = x338.input
          val x343 = x342.length
          val x344 = x341 >= x343
          var x360: Boolean = false
          var x359: Char = ' '
          var x361: StringReader = null
          if (x344) {
            x360 = true
            x359 = ' '
            x361 = x338
          } else {
            val x346 = x342(x341)
            val x347 = x346 >= '0'
            val x348 = x346 <= '9'
            val x349 = x347 && x348
            var x355: Boolean = false
            var x354: Char = ' '
            var x356: StringReader = null
            if (x349) {
              val x350 = x341 + 1
              val x351 = new StringReader(x342, x350)
              x355 = false
              x354 = x346
              x356 = x351
            } else {
              x355 = true
              x354 = ' '
              x356 = x338
            }
            x360 = x355
            x359 = x354
            x361 = x356
          }
          var x369: Boolean = false
          var x368: Int = 0
          if (x360) {
            x369 = true
            x368 = 0
          } else {
            val x364 = x359 - '0'
            val x365 = x364.toInt
            x369 = false
            x368 = x365
          }
          var x449: Boolean = false
          var x450: StringReader = null
          if (x369) {
            x449 = true
            x450 = x338
          } else {
            var x374: Boolean = false
            var x373: Int = x368
            var x375: StringReader = x361
            var x377: Int = -1
            var x378: Boolean = true
            var x379: StringReader = x361
            val x435 = while ({
              val x380 = x378
              val x381 = x377
              val x382 = x379
              val x383 = x382.offset
              val x384 = x381 != x383
              val x385 = x380 && x384
              x385
            }) {
              val x387 = x379
              val x388 = x387.offset
              x377 = x388
              val x390 = x387.input
              val x391 = x390.length
              val x392 = x388 >= x391
              var x408: Boolean = false
              var x407: Char = ' '
              var x409: StringReader = null
              if (x392) {
                x408 = true
                x407 = ' '
                x409 = x387
              } else {
                val x394 = x390(x388)
                val x395 = x394 >= '0'
                val x396 = x394 <= '9'
                val x397 = x395 && x396
                var x403: Boolean = false
                var x402: Char = ' '
                var x404: StringReader = null
                if (x397) {
                  val x398 = x388 + 1
                  val x399 = new StringReader(x390, x398)
                  x403 = false
                  x402 = x394
                  x404 = x399
                } else {
                  x403 = true
                  x402 = ' '
                  x404 = x387
                }
                x408 = x403
                x407 = x402
                x409 = x404
              }
              var x417: Boolean = false
              var x416: Int = 0
              if (x408) {
                x417 = true
                x416 = 0
              } else {
                val x412 = x407 - '0'
                val x413 = x412.toInt
                x417 = false
                x416 = x413
              }
              val x433 = if (x417) {
                x378 = false
                ()
              } else {
                val x421 = x373
                val x422 = x374
                val x423 = x375
                val x425 = x421 * 10
                val x426 = x425 + x416
                x373 = x426
                x374 = false
                x375 = x409
                x379 = x409
                ()
              }
              x433
            }
            val x437 = x374
            var x442: Boolean = false
            var x443: StringReader = null
            if (x437) {
              x442 = true
              x443 = x338
            } else {
              val x438 = x375
              x442 = x437
              x443 = x438
            }
            x449 = x442
            x450 = x443
          }
          x454 = x449
          x455 = x450
        }
        var x461: Boolean = false
        var x462: StringReader = null
        if (x454) {
          x461 = true
          x462 = x196
        } else {
          x461 = false
          x462 = x455
        }
        x466 = x461
        x467 = x462
      }
      var x473: Boolean = false
      var x474: StringReader = null
      if (x466) {
        val x2 = new StringReader(x0, 0)
        x473 = true
        x474 = x2
      } else {
        x473 = false
        x474 = x467
      }
      x478 = x473
      x479 = x474
    }
    var x549: Boolean = false
    var x550: StringReader = null
    if (x478) {
      val x2 = new StringReader(x0, 0)
      x549 = true
      x550 = x2
    } else {
      var x484: Boolean = false
      var x483: java.lang.String = ""
      var x485: StringReader = x479
      var x487: Int = -1
      var x488: Boolean = true
      var x489: StringReader = x479
      val x533 = while ({
        val x490 = x488
        val x491 = x487
        val x492 = x489
        val x493 = x492.offset
        val x494 = x491 != x493
        val x495 = x490 && x494
        x495
      }) {
        val x497 = x489
        val x498 = x497.offset
        x487 = x498
        val x500 = x497.input
        val x501 = x500.length
        val x502 = x498 >= x501
        var x516: Boolean = false
        var x517: StringReader = null
        if (x502) {
          x516 = true
          x517 = x497
        } else {
          val x504 = x500(x498)
          val x505 = x504 == ' '
          var x511: Boolean = false
          var x512: StringReader = null
          if (x505) {
            val x506 = x498 + 1
            val x507 = new StringReader(x500, x506)
            x511 = false
            x512 = x507
          } else {
            x511 = true
            x512 = x497
          }
          x516 = x511
          x517 = x512
        }
        val x531 = if (x516) {
          x488 = false
          ()
        } else {
          val x521 = x483
          val x522 = x484
          val x523 = x485
          x483 = x521
          x484 = false
          x485 = x517
          x489 = x517
          ()
        }
        x531
      }
      val x535 = x484
      var x542: Boolean = false
      var x543: StringReader = null
      if (x535) {
        val x2 = new StringReader(x0, 0)
        x542 = true
        x543 = x2
      } else {
        val x536 = x485
        x542 = false
        x543 = x536
      }
      x549 = x542
      x550 = x543
    }
    var x666: Boolean = false
    var x667: StringReader = null
    var x665: Int = 0
    if (x549) {
      val x2 = new StringReader(x0, 0)
      x666 = true
      x667 = x2
      x665 = 0
    } else {
      val x553 = x550.offset
      val x554 = x550.input
      val x555 = x554.length
      val x556 = x553 >= x555
      var x572: Boolean = false
      var x571: Char = ' '
      var x573: StringReader = null
      if (x556) {
        x572 = true
        x571 = ' '
        x573 = x550
      } else {
        val x558 = x554(x553)
        val x559 = x558 >= '0'
        val x560 = x558 <= '9'
        val x561 = x559 && x560
        var x567: Boolean = false
        var x566: Char = ' '
        var x568: StringReader = null
        if (x561) {
          val x562 = x553 + 1
          val x563 = new StringReader(x554, x562)
          x567 = false
          x566 = x558
          x568 = x563
        } else {
          x567 = true
          x566 = ' '
          x568 = x550
        }
        x572 = x567
        x571 = x566
        x573 = x568
      }
      var x581: Boolean = false
      var x580: Int = 0
      if (x572) {
        x581 = true
        x580 = 0
      } else {
        val x576 = x571 - '0'
        val x577 = x576.toInt
        x581 = false
        x580 = x577
      }
      var x661: Boolean = false
      var x662: StringReader = null
      var x660: Int = 0
      if (x581) {
        x661 = true
        x662 = x550
        x660 = 0
      } else {
        var x585: Int = x580
        var x586: Boolean = false
        var x587: StringReader = x573
        var x589: Int = -1
        var x590: Boolean = true
        var x591: StringReader = x573
        val x647 = while ({
          val x592 = x590
          val x593 = x589
          val x594 = x591
          val x595 = x594.offset
          val x596 = x593 != x595
          val x597 = x592 && x596
          x597
        }) {
          val x599 = x591
          val x600 = x599.offset
          x589 = x600
          val x602 = x599.input
          val x603 = x602.length
          val x604 = x600 >= x603
          var x620: Boolean = false
          var x619: Char = ' '
          var x621: StringReader = null
          if (x604) {
            x620 = true
            x619 = ' '
            x621 = x599
          } else {
            val x606 = x602(x600)
            val x607 = x606 >= '0'
            val x608 = x606 <= '9'
            val x609 = x607 && x608
            var x615: Boolean = false
            var x614: Char = ' '
            var x616: StringReader = null
            if (x609) {
              val x610 = x600 + 1
              val x611 = new StringReader(x602, x610)
              x615 = false
              x614 = x606
              x616 = x611
            } else {
              x615 = true
              x614 = ' '
              x616 = x599
            }
            x620 = x615
            x619 = x614
            x621 = x616
          }
          var x629: Boolean = false
          var x628: Int = 0
          if (x620) {
            x629 = true
            x628 = 0
          } else {
            val x624 = x619 - '0'
            val x625 = x624.toInt
            x629 = false
            x628 = x625
          }
          val x645 = if (x629) {
            x590 = false
            ()
          } else {
            val x633 = x585
            val x634 = x586
            val x635 = x587
            val x637 = x633 * 10
            val x638 = x637 + x628
            x585 = x638
            x586 = false
            x587 = x621
            x591 = x621
            ()
          }
          x645
        }
        val x649 = x586
        var x654: Boolean = false
        var x655: StringReader = null
        var x653: Int = 0
        if (x649) {
          x654 = true
          x655 = x550
          x653 = 0
        } else {
          val x648 = x585
          val x650 = x587
          x654 = x649
          x655 = x650
          x653 = x648
        }
        x661 = x654
        x662 = x655
        x660 = x653
      }
      x666 = x661
      x667 = x662
      x665 = x660
    }
    var x752: Unit = ()
    var x754: Boolean = false
    var x755: StringReader = null
    var x753: Int = 0
    if (x666) {
      x752 = ()
      x754 = x666
      x755 = x667
      x753 = x665
    } else {
      var x672: StringReader = x667
      var x670: Int = -1
      var x671: Boolean = true
      val x709 = while ({
        val x673 = x671
        val x674 = x670
        val x675 = x672
        val x676 = x675.offset
        val x677 = x674 != x676
        val x678 = x673 && x677
        x678
      }) {
        val x680 = x672
        val x681 = x680.offset
        x670 = x681
        val x683 = x680.input
        val x684 = x683.length
        val x685 = x681 >= x684
        var x700: Boolean = false
        var x701: StringReader = null
        if (x685) {
          x700 = true
          x701 = x680
        } else {
          val x687 = x683(x681)
          val x689 = x687 == '\n'
          var x695: Boolean = false
          var x696: StringReader = null
          if (x689) {
            x695 = true
            x696 = x680
          } else {
            val x690 = x681 + 1
            val x691 = new StringReader(x683, x690)
            x695 = false
            x696 = x691
          }
          x700 = x695
          x701 = x696
        }
        val x707 = if (x700) {
          x671 = false
          ()
        } else {
          x672 = x701
          ()
        }
        x707
      }
      val x712 = x672
      val x713 = x712.offset
      val x717 = x712.input
      val x718 = x717.length
      val x719 = x713 >= x718
      var x733: Boolean = false
      var x734: StringReader = null
      if (x719) {
        x733 = true
        x734 = x712
      } else {
        val x721 = x717(x713)
        val x722 = x721 == '\n'
        var x728: Boolean = false
        var x729: StringReader = null
        if (x722) {
          val x723 = x713 + 1
          val x724 = new StringReader(x717, x723)
          x728 = false
          x729 = x724
        } else {
          x728 = true
          x729 = x712
        }
        x733 = x728
        x734 = x729
      }
      var x741: Boolean = false
      var x742: StringReader = null
      if (x733) {
        x741 = true
        x742 = x667
      } else {
        x741 = false
        x742 = x734
      }
      var x747: Boolean = false
      var x748: StringReader = null
      var x746: Int = 0
      if (x741) {
        val x2 = new StringReader(x0, 0)
        x747 = true
        x748 = x2
        x746 = 0
      } else {
        x747 = false
        x748 = x742
        x746 = x665
      }
      // Barrier sync: TODO: Hack!
      x752 = ()
      x754 = x747
      x755 = x748
      x753 = x746
    }
    var x1515: Unit = ()
    var x1517: Boolean = false
    var x1518: StringReader = null
    var x1516: Tuple2IntAnon1323431030 = null
    if (x754) {
      val x2 = new StringReader(x0, 0)
      x1515 = ()
      x1517 = true
      x1518 = x2
      x1516 = null
    } else {
      var x765: Boolean = false
      var x759: Int = 200
      var x760: Int = 0
      var x761: java.lang.String = "close"
      var x762: Boolean = false
      var x763: Boolean = false
      var x766: StringReader = x755
      var x768: Int = -1
      var x769: Boolean = true
      var x770: StringReader = x755
      var x885: Boolean = false
      var x884: java.lang.String = ""
      var x888: Int = -1
      var x889: Boolean = true
      val x1175 = px1175 // static data: Array(c,o,n,n,e,c,t,i,o,n)
      val x1177 = x1175.length
      val x1208 = px1208 // static data: Array(p,r,o,x,y,-,c,o,n,n,e,c,t,i,o,n)
      val x1209 = x1208.length
      val x1239 = px1239 // static data: Array(k,e,e,p,-,a,l,i,v,e)
      val x1241 = x1239.length
      val x1272 = px1272 // static data: Array(c,l,o,s,e)
      val x1273 = x1272.length
      var x1304: java.lang.String = ""
      var x1305: Int = 0
      val x1322 = px1322 // static data: Array(c,o,n,t,e,n,t,-,l,e,n,g,t,h)
      val x1323 = x1322.length
      var x1352: java.lang.String = ""
      var x1353: Int = 0
      val x1371 = px1371 // static data: Array(t,r,a,n,s,f,e,r,-,e,n,c,o,d,i,n,g)
      val x1372 = x1371.length
      val x1401 = px1401 // static data: Array(c,h,u,n,k,e,d)
      val x1402 = x1401.length
      val x1433 = px1433 // static data: Array(u,p,g,r,a,d,e)
      val x1434 = x1433.length
      val x1496 = while ({
        val x771 = x769
        val x772 = x768
        val x773 = x770
        val x774 = x773.offset
        val x775 = x772 != x774
        val x776 = x771 && x775
        x776
      }) {
        val x778 = x770
        val x779 = x778.offset
        x768 = x779
        val x781 = x778.input
        val x782 = x781.length
        val x783 = x779 >= x782
        var x803: Boolean = false
        var x804: StringReader = null
        var x802: Int = 0
        if (x783) {
          x803 = true
          x804 = x778
          x802 = 0
        } else {
          val x785 = x781(x779)
          val x786 = x785 >= 'a'
          val x787 = x785 <= 'z'
          val x788 = x786 && x787
          val x789 = x785 >= 'A'
          val x790 = x785 <= 'Z'
          val x791 = x789 && x790
          val x792 = x788 || x791
          var x798: Boolean = false
          var x799: StringReader = null
          var x797: Int = 0
          if (x792) {
            val x793 = x779 + 1
            val x794 = new StringReader(x781, x793)
            x798 = false
            x799 = x794
            x797 = x779
          } else {
            x798 = true
            x799 = x778
            x797 = 0
          }
          x803 = x798
          x804 = x799
          x802 = x797
        }
        var x866: Unit = ()
        var x868: Boolean = false
        var x869: StringReader = null
        var x867: Tuple2IntAnon1680061013 = null
        if (x803) {
          x866 = ()
          x868 = true
          x869 = x778
          x867 = null
        } else {
          var x810: StringReader = x804
          var x808: Int = -1
          var x809: Boolean = true
          val x854 = while ({
            val x811 = x809
            val x812 = x808
            val x813 = x810
            val x814 = x813.offset
            val x815 = x812 != x814
            val x816 = x811 && x815
            x816
          }) {
            val x818 = x810
            val x819 = x818.offset
            x808 = x819
            val x821 = x818.input
            val x822 = x821.length
            val x823 = x819 >= x822
            var x845: Boolean = false
            var x846: StringReader = null
            if (x823) {
              x845 = true
              x846 = x818
            } else {
              val x825 = x821(x819)
              val x826 = x825 >= 'a'
              val x827 = x825 <= 'z'
              val x828 = x826 && x827
              val x829 = x825 >= 'A'
              val x830 = x825 <= 'Z'
              val x831 = x829 && x830
              val x832 = x828 || x831
              val x833 = x825 == '-'
              val x834 = x832 || x833
              var x840: Boolean = false
              var x841: StringReader = null
              if (x834) {
                val x835 = x819 + 1
                val x836 = new StringReader(x821, x835)
                x840 = false
                x841 = x836
              } else {
                x840 = true
                x841 = x818
              }
              x845 = x840
              x846 = x841
            }
            val x852 = if (x845) {
              x809 = false
              ()
            } else {
              x810 = x846
              ()
            }
            x852
          }
          val x857 = x810
          val x855 = x804.input
          val x856 = x804.offset
          val x858 = x857.offset
          val x859 = x858 - x856
          val x860 = new Anon1680061013(x855, x856, x859)
          val x862 = new Tuple2IntAnon1680061013(x802, x860)
          // Barrier sync: TODO: Hack!
          x866 = ()
          x868 = false
          x869 = x857
          x867 = x862
        }
        var x881: Boolean = false
        var x880: Anon1680061013 = null
        if (x868) {
          x881 = true
          x880 = null
        } else {
          val x872 = x867._1
          val x873 = x867._2
          val x874 = x873.input
          val x875 = x873.length
          val x876 = x875 + 1
          val x877 = new Anon1680061013(x874, x872, x876)
          x881 = false
          x880 = x877
        }
        var x1001: Boolean = false
        var x1002: StringReader = null
        var x1000: Anon1680061013 = null
        if (x881) {
          x1001 = x881
          x1002 = x869
          x1000 = x880
        } else {
          var x886: StringReader = x869
          var x890: StringReader = x869
          val x934 = while ({
            val x891 = x889
            val x892 = x888
            val x893 = x890
            val x894 = x893.offset
            val x895 = x892 != x894
            val x896 = x891 && x895
            x896
          }) {
            val x898 = x890
            val x899 = x898.offset
            x888 = x899
            val x901 = x898.input
            val x902 = x901.length
            val x903 = x899 >= x902
            var x917: Boolean = false
            var x918: StringReader = null
            if (x903) {
              x917 = true
              x918 = x898
            } else {
              val x905 = x901(x899)
              val x906 = x905 == ' '
              var x912: Boolean = false
              var x913: StringReader = null
              if (x906) {
                val x907 = x899 + 1
                val x908 = new StringReader(x901, x907)
                x912 = false
                x913 = x908
              } else {
                x912 = true
                x913 = x898
              }
              x917 = x912
              x918 = x913
            }
            val x932 = if (x917) {
              x889 = false
              ()
            } else {
              val x922 = x884
              val x923 = x885
              val x924 = x886
              x884 = x922
              x885 = false
              x886 = x918
              x890 = x918
              ()
            }
            x932
          }
          val x936 = x885
          var x987: Boolean = false
          var x988: StringReader = null
          if (x936) {
            x987 = true
            x988 = x869
          } else {
            val x937 = x886
            val x940 = x937.offset
            val x941 = x937.input
            val x942 = x941.length
            val x943 = x940 >= x942
            var x957: Boolean = false
            var x958: StringReader = null
            if (x943) {
              x957 = true
              x958 = x937
            } else {
              val x945 = x941(x940)
              val x946 = x945 == ':'
              var x952: Boolean = false
              var x953: StringReader = null
              if (x946) {
                val x947 = x940 + 1
                val x948 = new StringReader(x941, x947)
                x952 = false
                x953 = x948
              } else {
                x952 = true
                x953 = x937
              }
              x957 = x952
              x958 = x953
            }
            var x966: Boolean = false
            var x967: StringReader = null
            if (x957) {
              x966 = true
              x967 = x937
            } else {
              x966 = false
              x967 = x958
            }
            val x976 = if (x966) {
              true
            } else {
              false
            }
            var x982: Boolean = false
            var x983: StringReader = null
            if (x976) {
              x982 = true
              x983 = x869
            } else {
              x982 = false
              x983 = x967
            }
            x987 = x982
            x988 = x983
          }
          var x994: Boolean = false
          var x995: StringReader = null
          var x993: Anon1680061013 = null
          if (x987) {
            x994 = true
            x995 = x778
            x993 = null
          } else {
            x994 = false
            x995 = x988
            x993 = x880
          }
          x1001 = x994
          x1002 = x995
          x1000 = x993
        }
        var x1157: Unit = ()
        var x1159: Boolean = false
        var x1158: Tuple2Anon1680061013Anon1680061013 = null
        var x1160: StringReader = null
        if (x1001) {
          x1157 = ()
          x1159 = true
          x1158 = null
          x1160 = x778
        } else {
          var x1007: Boolean = false
          var x1006: java.lang.String = ""
          var x1008: StringReader = x1002
          var x1010: Int = -1
          var x1011: Boolean = true
          var x1012: StringReader = x1002
          val x1056 = while ({
            val x1013 = x1011
            val x1014 = x1010
            val x1015 = x1012
            val x1016 = x1015.offset
            val x1017 = x1014 != x1016
            val x1018 = x1013 && x1017
            x1018
          }) {
            val x1020 = x1012
            val x1021 = x1020.offset
            x1010 = x1021
            val x1023 = x1020.input
            val x1024 = x1023.length
            val x1025 = x1021 >= x1024
            var x1039: Boolean = false
            var x1040: StringReader = null
            if (x1025) {
              x1039 = true
              x1040 = x1020
            } else {
              val x1027 = x1023(x1021)
              val x1028 = x1027 == ' '
              var x1034: Boolean = false
              var x1035: StringReader = null
              if (x1028) {
                val x1029 = x1021 + 1
                val x1030 = new StringReader(x1023, x1029)
                x1034 = false
                x1035 = x1030
              } else {
                x1034 = true
                x1035 = x1020
              }
              x1039 = x1034
              x1040 = x1035
            }
            val x1054 = if (x1039) {
              x1011 = false
              ()
            } else {
              val x1044 = x1006
              val x1045 = x1007
              val x1046 = x1008
              x1006 = x1044
              x1007 = false
              x1008 = x1040
              x1012 = x1040
              ()
            }
            x1054
          }
          val x1058 = x1007
          val x1059 = x1008
          var x1112: Unit = ()
          var x1114: Boolean = false
          var x1115: StringReader = null
          var x1113: Anon1680061013 = null
          if (x1058) {
            x1112 = ()
            x1114 = true
            x1115 = x1002
            x1113 = null
          } else {
            var x1065: StringReader = x1059
            var x1063: Int = -1
            var x1064: Boolean = true
            val x1102 = while ({
              val x1066 = x1064
              val x1067 = x1063
              val x1068 = x1065
              val x1069 = x1068.offset
              val x1070 = x1067 != x1069
              val x1071 = x1066 && x1070
              x1071
            }) {
              val x1073 = x1065
              val x1074 = x1073.offset
              x1063 = x1074
              val x1076 = x1073.input
              val x1077 = x1076.length
              val x1078 = x1074 >= x1077
              var x1093: Boolean = false
              var x1094: StringReader = null
              if (x1078) {
                x1093 = true
                x1094 = x1073
              } else {
                val x1080 = x1076(x1074)
                val x1082 = x1080 == '\n'
                var x1088: Boolean = false
                var x1089: StringReader = null
                if (x1082) {
                  x1088 = true
                  x1089 = x1073
                } else {
                  val x1083 = x1074 + 1
                  val x1084 = new StringReader(x1076, x1083)
                  x1088 = false
                  x1089 = x1084
                }
                x1093 = x1088
                x1094 = x1089
              }
              val x1100 = if (x1093) {
                x1064 = false
                ()
              } else {
                x1065 = x1094
                ()
              }
              x1100
            }
            val x1105 = x1065
            val x1103 = x1059.input
            val x1104 = x1059.offset
            val x1106 = x1105.offset
            val x1107 = x1106 - x1104
            val x1108 = new Anon1680061013(x1103, x1104, x1107)
            // Barrier sync: TODO: Hack!
            x1112 = ()
            x1114 = false
            x1115 = x1105
            x1113 = x1108
          }
          var x1145: Boolean = false
          var x1144: Anon1680061013 = null
          var x1146: StringReader = null
          if (x1114) {
            x1145 = x1114
            x1144 = x1113
            x1146 = x1115
          } else {
            val x1117 = x1115.offset
            val x1118 = x1115.input
            val x1119 = x1118.length
            val x1120 = x1117 >= x1119
            var x1134: Boolean = false
            var x1135: StringReader = null
            if (x1120) {
              x1134 = true
              x1135 = x1115
            } else {
              val x1122 = x1118(x1117)
              val x1123 = x1122 == '\n'
              var x1129: Boolean = false
              var x1130: StringReader = null
              if (x1123) {
                val x1124 = x1117 + 1
                val x1125 = new StringReader(x1118, x1124)
                x1129 = false
                x1130 = x1125
              } else {
                x1129 = true
                x1130 = x1115
              }
              x1134 = x1129
              x1135 = x1130
            }
            var x1140: Boolean = false
            var x1139: Anon1680061013 = null
            var x1141: StringReader = null
            if (x1134) {
              x1140 = true
              x1139 = null
              x1141 = x1002
            } else {
              x1140 = false
              x1139 = x1113
              x1141 = x1135
            }
            x1145 = x1140
            x1144 = x1139
            x1146 = x1141
          }
          var x1152: Boolean = false
          var x1151: Tuple2Anon1680061013Anon1680061013 = null
          var x1153: StringReader = null
          if (x1145) {
            x1152 = true
            x1151 = null
            x1153 = x778
          } else {
            val x1148 = new Tuple2Anon1680061013Anon1680061013(x1000, x1144)
            x1152 = false
            x1151 = x1148
            x1153 = x1146
          }
          val x1057 = x1006
          x1157 = ()
          x1159 = x1152
          x1158 = x1151
          x1160 = x1153
        }
        val x1494 = if (x1159) {
          x769 = false
          ()
        } else {
          val x1164 = x759
          val x1165 = x760
          val x1166 = x761
          val x1167 = x762
          val x1168 = x763
          val x1170 = x765
          val x1171 = x766
          x759 = x1164
          val x1173 = x1158._1
          val x1176 = x1173.length
          val x1178 = x1176 == x1177
          val x1207 = if (x1178) {
            var x1181: Int = 0
            var x1182: Boolean = true
            val x1179 = x1173.input
            val x1180 = x1173.start
            val x1203 = while ({
              val x1183 = x1181
              val x1185 = x1182
              val x1184 = x1183 < x1176
              val x1186 = x1184 && x1185
              x1186
            }) {
              val x1188 = x1181
              val x1189 = x1188 + x1180
              val x1190 = x1179(x1189)
              val x1191 = x1190.toInt
              val x1192 = x1191 | 32
              val x1193 = x1192.toChar
              val x1194 = x1175(x1188)
              val x1196 = x1193 == x1194
              val x1199 = if (x1196) {
                ()
              } else {
                x1182 = false
                ()
              }
              val x1200 = x1188 + 1
              x1181 = x1200
              ()
            }
            val x1204 = x1182
            x1204
          } else {
            false
          }
          val x1210 = x1176 == x1209
          val x1237 = if (x1210) {
            var x1211: Int = 0
            var x1212: Boolean = true
            val x1179 = x1173.input
            val x1180 = x1173.start
            val x1233 = while ({
              val x1213 = x1211
              val x1215 = x1212
              val x1214 = x1213 < x1176
              val x1216 = x1214 && x1215
              x1216
            }) {
              val x1218 = x1211
              val x1219 = x1218 + x1180
              val x1220 = x1179(x1219)
              val x1221 = x1220.toInt
              val x1222 = x1221 | 32
              val x1223 = x1222.toChar
              val x1224 = x1208(x1218)
              val x1226 = x1223 == x1224
              val x1229 = if (x1226) {
                ()
              } else {
                x1212 = false
                ()
              }
              val x1230 = x1218 + 1
              x1211 = x1230
              ()
            }
            val x1234 = x1212
            x1234
          } else {
            false
          }
          val x1238 = x1207 || x1237
          val x1174 = x1158._2
          val x1240 = x1174.length
          val x1242 = x1240 == x1241
          val x1271 = if (x1242) {
            var x1245: Int = 0
            var x1246: Boolean = true
            val x1243 = x1174.input
            val x1244 = x1174.start
            val x1267 = while ({
              val x1247 = x1245
              val x1249 = x1246
              val x1248 = x1247 < x1240
              val x1250 = x1248 && x1249
              x1250
            }) {
              val x1252 = x1245
              val x1253 = x1252 + x1244
              val x1254 = x1243(x1253)
              val x1255 = x1254.toInt
              val x1256 = x1255 | 32
              val x1257 = x1256.toChar
              val x1258 = x1239(x1252)
              val x1260 = x1257 == x1258
              val x1263 = if (x1260) {
                ()
              } else {
                x1246 = false
                ()
              }
              val x1264 = x1252 + 1
              x1245 = x1264
              ()
            }
            val x1268 = x1246
            x1268
          } else {
            false
          }
          val x1274 = x1240 == x1273
          val x1301 = if (x1274) {
            var x1275: Int = 0
            var x1276: Boolean = true
            val x1243 = x1174.input
            val x1244 = x1174.start
            val x1297 = while ({
              val x1277 = x1275
              val x1279 = x1276
              val x1278 = x1277 < x1240
              val x1280 = x1278 && x1279
              x1280
            }) {
              val x1282 = x1275
              val x1283 = x1282 + x1244
              val x1284 = x1243(x1283)
              val x1285 = x1284.toInt
              val x1286 = x1285 | 32
              val x1287 = x1286.toChar
              val x1288 = x1272(x1282)
              val x1290 = x1287 == x1288
              val x1293 = if (x1290) {
                ()
              } else {
                x1276 = false
                ()
              }
              val x1294 = x1282 + 1
              x1275 = x1294
              ()
            }
            val x1298 = x1276
            x1298
          } else {
            false
          }
          val x1302 = x1271 || x1301
          val x1303 = x1238 && x1302
          var x1479: Int = 0
          var x1480: java.lang.String = null
          var x1481: Boolean = false
          var x1482: Boolean = false
          if (x1303) {
            val x1243 = x1174.input
            val x1244 = x1174.start
            val x1318 = while ({
              val x1306 = x1305
              val x1307 = x1306 < x1240
              x1307
            }) {
              val x1309 = x1304
              val x1310 = x1305
              val x1311 = x1244 + x1310
              val x1312 = x1243(x1311)
              val x1313 = x1309 + x1312
              x1304 = x1313
              val x1315 = x1310 + 1
              x1305 = x1315
              ()
            }
            val x1319 = x1304
            x1479 = x1165
            x1480 = x1319
            x1481 = x1167
            x1482 = x1168
          } else {
            val x1324 = x1176 == x1323
            val x1351 = if (x1324) {
              var x1325: Int = 0
              var x1326: Boolean = true
              val x1179 = x1173.input
              val x1180 = x1173.start
              val x1347 = while ({
                val x1327 = x1325
                val x1329 = x1326
                val x1328 = x1327 < x1176
                val x1330 = x1328 && x1329
                x1330
              }) {
                val x1332 = x1325
                val x1333 = x1332 + x1180
                val x1334 = x1179(x1333)
                val x1335 = x1334.toInt
                val x1336 = x1335 | 32
                val x1337 = x1336.toChar
                val x1338 = x1322(x1332)
                val x1340 = x1337 == x1338
                val x1343 = if (x1340) {
                  ()
                } else {
                  x1326 = false
                  ()
                }
                val x1344 = x1332 + 1
                x1325 = x1344
                ()
              }
              val x1348 = x1326
              x1348
            } else {
              false
            }
            var x1473: Int = 0
            var x1474: Boolean = false
            var x1475: Boolean = false
            if (x1351) {
              val x1243 = x1174.input
              val x1244 = x1174.start
              val x1366 = while ({
                val x1354 = x1353
                val x1355 = x1354 < x1240
                x1355
              }) {
                val x1357 = x1352
                val x1358 = x1353
                val x1359 = x1244 + x1358
                val x1360 = x1243(x1359)
                val x1361 = x1357 + x1360
                x1352 = x1361
                val x1363 = x1358 + 1
                x1353 = x1363
                ()
              }
              val x1367 = x1352
              val x1368 = x1367.toInt
              x1473 = x1368
              x1474 = x1167
              x1475 = x1168
            } else {
              val x1373 = x1176 == x1372
              val x1400 = if (x1373) {
                var x1374: Int = 0
                var x1375: Boolean = true
                val x1179 = x1173.input
                val x1180 = x1173.start
                val x1396 = while ({
                  val x1376 = x1374
                  val x1378 = x1375
                  val x1377 = x1376 < x1176
                  val x1379 = x1377 && x1378
                  x1379
                }) {
                  val x1381 = x1374
                  val x1382 = x1381 + x1180
                  val x1383 = x1179(x1382)
                  val x1384 = x1383.toInt
                  val x1385 = x1384 | 32
                  val x1386 = x1385.toChar
                  val x1387 = x1371(x1381)
                  val x1389 = x1386 == x1387
                  val x1392 = if (x1389) {
                    ()
                  } else {
                    x1375 = false
                    ()
                  }
                  val x1393 = x1381 + 1
                  x1374 = x1393
                  ()
                }
                val x1397 = x1375
                x1397
              } else {
                false
              }
              val x1403 = x1240 == x1402
              val x1430 = if (x1403) {
                var x1404: Int = 0
                var x1405: Boolean = true
                val x1243 = x1174.input
                val x1244 = x1174.start
                val x1426 = while ({
                  val x1406 = x1404
                  val x1408 = x1405
                  val x1407 = x1406 < x1240
                  val x1409 = x1407 && x1408
                  x1409
                }) {
                  val x1411 = x1404
                  val x1412 = x1411 + x1244
                  val x1413 = x1243(x1412)
                  val x1414 = x1413.toInt
                  val x1415 = x1414 | 32
                  val x1416 = x1415.toChar
                  val x1417 = x1401(x1411)
                  val x1419 = x1416 == x1417
                  val x1422 = if (x1419) {
                    ()
                  } else {
                    x1405 = false
                    ()
                  }
                  val x1423 = x1411 + 1
                  x1404 = x1423
                  ()
                }
                val x1427 = x1405
                x1427
              } else {
                false
              }
              val x1431 = x1400 && x1430
              var x1468: Boolean = false
              var x1469: Boolean = false
              if (x1431) {
                x1468 = true
                x1469 = x1168
              } else {
                val x1435 = x1176 == x1434
                val x1462 = if (x1435) {
                  var x1436: Int = 0
                  var x1437: Boolean = true
                  val x1179 = x1173.input
                  val x1180 = x1173.start
                  val x1458 = while ({
                    val x1438 = x1436
                    val x1440 = x1437
                    val x1439 = x1438 < x1176
                    val x1441 = x1439 && x1440
                    x1441
                  }) {
                    val x1443 = x1436
                    val x1444 = x1443 + x1180
                    val x1445 = x1179(x1444)
                    val x1446 = x1445.toInt
                    val x1447 = x1446 | 32
                    val x1448 = x1447.toChar
                    val x1449 = x1433(x1443)
                    val x1451 = x1448 == x1449
                    val x1454 = if (x1451) {
                      ()
                    } else {
                      x1437 = false
                      ()
                    }
                    val x1455 = x1443 + 1
                    x1436 = x1455
                    ()
                  }
                  val x1459 = x1437
                  x1459
                } else {
                  false
                }
                val x1465 = if (x1462) {
                  true
                } else {
                  x1168
                }
                x1468 = x1167
                x1469 = x1465
              }
              x1473 = x1165
              x1474 = x1468
              x1475 = x1469
            }
            x1479 = x1473
            x1480 = x1166
            x1481 = x1474
            x1482 = x1475
          }
          x760 = x1479
          x761 = x1480
          x762 = x1481
          x763 = x1482
          x765 = false
          x766 = x1160
          x770 = x1160
          ()
        }
        x1494
      }
      val x1503 = x765
      val x1504 = x766
      val x1497 = x759
      val x1498 = x760
      val x1499 = x761
      val x1500 = x762
      val x1501 = x763
      var x1510: Boolean = false
      var x1511: StringReader = null
      var x1509: Tuple2IntAnon1323431030 = null
      if (x1503) {
        val x2 = new StringReader(x0, 0)
        x1510 = true
        x1511 = x2
        x1509 = null
      } else {
        val x1502 = new Anon1323431030(x1497, x1498, x1499, x1500, x1501)
        val x1506 = new Tuple2IntAnon1323431030(x753, x1502)
        x1510 = false
        x1511 = x1504
        x1509 = x1506
      }
      x1515 = ()
      x1517 = x1510
      x1518 = x1511
      x1516 = x1509
    }
    var x1548: Boolean = false
    var x1547: Tuple2IntAnon1323431030 = null
    if (x1517) {
      x1548 = x1517
      x1547 = x1516
    } else {
      val x1520 = x1518.offset
      val x1521 = x1518.input
      val x1522 = x1521.length
      val x1523 = x1520 >= x1522
      val x1537 = if (x1523) {
        true
      } else {
        val x1525 = x1521(x1520)
        val x1526 = x1525 == '\n'
        val x1532 = if (x1526) {
          false
        } else {
          true
        }
        x1532
      }
      var x1543: Boolean = false
      var x1542: Tuple2IntAnon1323431030 = null
      if (x1537) {
        x1543 = true
        x1542 = null
      } else {
        x1543 = false
        x1542 = x1516
      }
      x1548 = x1543
      x1547 = x1542
    }
    var x1561: Anon1323431030 = null
    var x1562: Boolean = false
    if (x1548) {
      x1561 = null
      x1562 = true
    } else {
      val x1552 = x1547._1
      val x1553 = x1547._2
      val x1554 = x1553.contentLength
      val x1555 = x1553.connection
      val x1556 = x1553.chunked
      val x1557 = x1553.upgrade
      val x1558 = new Anon1323431030(x1552, x1554, x1555, x1556, x1557)
      x1561 = x1558
      x1562 = false
    }
    var x1568: Anon1323431030 = null
    var x1569: Boolean = false
    if (x1562) {
      val x1564 = null.asInstanceOf[Anon1323431030]
      x1568 = x1564
      x1569 = false
    } else {
      x1568 = x1561
      x1569 = true
    }
    val x1570 = new OptionAnon1323431030(x1568, x1569)
    x1570
  }
}
/**
 * ***************************************
 * End of Generated Code
 * *****************************************
 */
