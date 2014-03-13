package lms.parsing.gen

object RespAndMessageParse {
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

    new RespAndMessageParse().apply(resp.toArray)
  }
}

/**
 * ***************************************
 * Emitting Generated Code
 * *****************************************
 */
class RespAndMessageParse extends ((Array[Char]) => (Unit)) with java.io.Serializable {
  def apply(x5218: Array[Char]): Unit = {
    val x5219 = null.asInstanceOf[Tuple2Anon1323431030String]
    var x5221: Tuple2Anon1323431030String = x5219
    var x5222: Boolean = true
    var x5223: Int = -1
    val x5237 = x5218.length
    val x5306 = 0 >= x5237
    val x6254 = if (x5306) {
      x5221 = x5219
      x5222 = true
      x5223 = 0
      ()
    } else {
      val x5307 = x5218(0)
      val x5308 = x5307 == 'H'
      val x6252 = if (x5308) {
        val x14 = 0 + 1
        val x5318 = x14 >= x5237
        val x6246 = if (x5318) {
          x5221 = x5219
          x5222 = true
          x5223 = 0
          ()
        } else {
          val x5319 = x5218(x14)
          val x5320 = x5319 == 'T'
          val x6244 = if (x5320) {
            val x34 = x14 + 1
            val x5326 = x34 >= x5237
            val x6238 = if (x5326) {
              x5221 = x5219
              x5222 = true
              x5223 = 0
              ()
            } else {
              val x5327 = x5218(x34)
              val x5328 = x5327 == 'T'
              val x6236 = if (x5328) {
                val x46 = x34 + 1
                val x5335 = x46 >= x5237
                val x6230 = if (x5335) {
                  x5221 = x5219
                  x5222 = true
                  x5223 = 0
                  ()
                } else {
                  val x5336 = x5218(x46)
                  val x5337 = x5336 == 'P'
                  val x6228 = if (x5337) {
                    val x59 = x46 + 1
                    val x5344 = x59 >= x5237
                    val x6222 = if (x5344) {
                      x5221 = x5219
                      x5222 = true
                      x5223 = 0
                      ()
                    } else {
                      val x5345 = x5218(x59)
                      val x5346 = x5345 == '/'
                      val x6220 = if (x5346) {
                        var x5372: Int = 0
                        var x5373: Boolean = false
                        val x72 = x59 + 1
                        var x5374: Int = x72
                        var x5376: Int = -1
                        var x5377: Boolean = true
                        var x5378: Int = x72
                        val x5419 = while ({
                          val x5379 = x5377
                          val x5380 = x5376
                          val x5381 = x5378
                          val x5382 = x5380 != x5381
                          val x5383 = x5379 && x5382
                          x5383
                        }) {
                          val x5385 = x5378
                          x5376 = x5385
                          val x5387 = x5385 >= x5237
                          val x5417 = if (x5387) {
                            x5377 = false
                            ()
                          } else {
                            val x5389 = x5218(x5385)
                            val x5390 = x5389 >= '0'
                            val x5391 = x5389 <= '9'
                            val x5392 = x5390 && x5391
                            val x5415 = if (x5392) {
                              val x5401 = x5372
                              val x5402 = x5373
                              val x5403 = x5374
                              val x5398 = x5389 - '0'
                              val x5399 = x5398.toInt
                              val x5405 = x5401 * 10
                              val x5406 = x5405 + x5399
                              x5372 = x5406
                              x5373 = false
                              val x5393 = x5385 + 1
                              x5374 = x5393
                              x5378 = x5393
                              ()
                            } else {
                              x5377 = false
                              ()
                            }
                            x5415
                          }
                          x5417
                        }
                        val x5420 = x5372
                        val x5421 = x5373
                        val x5422 = x5374
                        val x6214 = if (x5421) {
                          x5221 = x5219
                          x5222 = true
                          x5223 = 0
                          ()
                        } else {
                          val x5424 = x5422 >= x5237
                          val x6212 = if (x5424) {
                            x5221 = x5219
                            x5222 = true
                            x5223 = 0
                            ()
                          } else {
                            val x5426 = x5218(x5422)
                            val x5427 = x5426 == '.'
                            val x6210 = if (x5427) {
                              var x5440: Int = 0
                              var x5441: Boolean = false
                              val x5428 = x5422 + 1
                              var x5442: Int = x5428
                              var x5444: Int = -1
                              var x5445: Boolean = true
                              var x5446: Int = x5428
                              val x5487 = while ({
                                val x5447 = x5445
                                val x5448 = x5444
                                val x5449 = x5446
                                val x5450 = x5448 != x5449
                                val x5451 = x5447 && x5450
                                x5451
                              }) {
                                val x5453 = x5446
                                x5444 = x5453
                                val x5455 = x5453 >= x5237
                                val x5485 = if (x5455) {
                                  x5445 = false
                                  ()
                                } else {
                                  val x5457 = x5218(x5453)
                                  val x5458 = x5457 >= '0'
                                  val x5459 = x5457 <= '9'
                                  val x5460 = x5458 && x5459
                                  val x5483 = if (x5460) {
                                    val x5469 = x5440
                                    val x5470 = x5441
                                    val x5471 = x5442
                                    val x5466 = x5457 - '0'
                                    val x5467 = x5466.toInt
                                    val x5473 = x5469 * 10
                                    val x5474 = x5473 + x5467
                                    x5440 = x5474
                                    x5441 = false
                                    val x5461 = x5453 + 1
                                    x5442 = x5461
                                    x5446 = x5461
                                    ()
                                  } else {
                                    x5445 = false
                                    ()
                                  }
                                  x5483
                                }
                                x5485
                              }
                              val x5488 = x5440
                              val x5489 = x5441
                              val x5490 = x5442
                              val x5495 = if (x5489) {
                                true
                              } else {
                                false
                              }
                              val x5501 = if (x5495) {
                                true
                              } else {
                                false
                              }
                              val x6204 = if (x5501) {
                                x5221 = x5219
                                x5222 = true
                                x5223 = 0
                                ()
                              } else {
                                val x7 = List()
                                var x5509: scala.collection.immutable.List[Char] = x7
                                var x5510: Boolean = false
                                val x5502 = if (x5495) {
                                  0
                                } else {
                                  val x5496 = if (x5489) {
                                    x72
                                  } else {
                                    x5490
                                  }
                                  x5496
                                }
                                var x5511: Int = x5502
                                var x5513: Int = -1
                                var x5514: Boolean = true
                                var x5515: Int = x5502
                                val x5550 = while ({
                                  val x5516 = x5514
                                  val x5517 = x5513
                                  val x5518 = x5515
                                  val x5519 = x5517 != x5518
                                  val x5520 = x5516 && x5519
                                  x5520
                                }) {
                                  val x5522 = x5515
                                  x5513 = x5522
                                  val x5524 = x5522 >= x5237
                                  val x5548 = if (x5524) {
                                    x5514 = false
                                    ()
                                  } else {
                                    val x5526 = x5218(x5522)
                                    val x5527 = x5526 == ' '
                                    val x5546 = if (x5527) {
                                      val x5532 = x5509
                                      val x5533 = x5510
                                      val x5534 = x5511
                                      val x5536 = List(x5526)
                                      val x5537 = x5532 ::: x5536
                                      x5509 = x5537
                                      x5510 = false
                                      val x5528 = x5522 + 1
                                      x5511 = x5528
                                      x5515 = x5528
                                      ()
                                    } else {
                                      x5514 = false
                                      ()
                                    }
                                    x5546
                                  }
                                  x5548
                                }
                                val x5551 = x5509
                                val x5552 = x5510
                                val x5553 = x5511
                                val x5558 = if (x5552) {
                                  true
                                } else {
                                  false
                                }
                                val x5564 = if (x5558) {
                                  true
                                } else {
                                  false
                                }
                                val x6202 = if (x5564) {
                                  x5221 = x5219
                                  x5222 = true
                                  x5223 = 0
                                  ()
                                } else {
                                  var x5572: Int = 0
                                  var x5573: Boolean = false
                                  val x5565 = if (x5558) {
                                    0
                                  } else {
                                    val x5559 = if (x5552) {
                                      x5553
                                    } else {
                                      x5553
                                    }
                                    x5559
                                  }
                                  var x5574: Int = x5565
                                  var x5576: Int = -1
                                  var x5577: Boolean = true
                                  var x5578: Int = x5565
                                  val x5619 = while ({
                                    val x5579 = x5577
                                    val x5580 = x5576
                                    val x5581 = x5578
                                    val x5582 = x5580 != x5581
                                    val x5583 = x5579 && x5582
                                    x5583
                                  }) {
                                    val x5585 = x5578
                                    x5576 = x5585
                                    val x5587 = x5585 >= x5237
                                    val x5617 = if (x5587) {
                                      x5577 = false
                                      ()
                                    } else {
                                      val x5589 = x5218(x5585)
                                      val x5590 = x5589 >= '0'
                                      val x5591 = x5589 <= '9'
                                      val x5592 = x5590 && x5591
                                      val x5615 = if (x5592) {
                                        val x5601 = x5572
                                        val x5602 = x5573
                                        val x5603 = x5574
                                        val x5598 = x5589 - '0'
                                        val x5599 = x5598.toInt
                                        val x5605 = x5601 * 10
                                        val x5606 = x5605 + x5599
                                        x5572 = x5606
                                        x5573 = false
                                        val x5593 = x5585 + 1
                                        x5574 = x5593
                                        x5578 = x5593
                                        ()
                                      } else {
                                        x5577 = false
                                        ()
                                      }
                                      x5615
                                    }
                                    x5617
                                  }
                                  val x5620 = x5572
                                  val x5621 = x5573
                                  val x5622 = x5574
                                  val x6200 = if (x5621) {
                                    x5221 = x5219
                                    x5222 = true
                                    x5223 = 0
                                    ()
                                  } else {
                                    var x5629: java.lang.String = ""
                                    var x5630: Boolean = false
                                    var x5631: Int = x5622
                                    var x5633: Int = -1
                                    var x5634: Boolean = true
                                    var x5635: Int = x5622
                                    val x5670 = while ({
                                      val x5636 = x5634
                                      val x5637 = x5633
                                      val x5638 = x5635
                                      val x5639 = x5637 != x5638
                                      val x5640 = x5636 && x5639
                                      x5640
                                    }) {
                                      val x5642 = x5635
                                      x5633 = x5642
                                      val x5644 = x5642 >= x5237
                                      val x5668 = if (x5644) {
                                        x5634 = false
                                        ()
                                      } else {
                                        val x5646 = x5218(x5642)
                                        val x5652 = x5646 == '
'
                                        val x5666 = if (x5652) {
                                          x5634 = false
                                          ()
                                        } else {
                                          val x5655 = x5629
                                          val x5656 = x5630
                                          val x5657 = x5631
                                          val x5659 = x5655 + x5646
                                          x5629 = x5659
                                          x5630 = false
                                          val x5648 = x5642 + 1
                                          x5631 = x5648
                                          x5635 = x5648
                                          ()
                                        }
                                        x5666
                                      }
                                      x5668
                                    }
                                    val x5671 = x5629
                                    val x5672 = x5630
                                    val x5673 = x5631
                                    val x6198 = if (x5672) {
                                      x5221 = x5219
                                      x5222 = true
                                      x5223 = 0
                                      ()
                                    } else {
                                      val x5676 = x5673 >= x5237
                                      val x6196 = if (x5676) {
                                        x5221 = x5219
                                        x5222 = true
                                        x5223 = 0
                                        ()
                                      } else {
                                        val x5678 = x5218(x5673)
                                        val x5679 = x5678 == '
'
                                        val x6194 = if (x5679) {
                                          var x5694: Int = 200
                                          var x5695: Int = 0
                                          var x5696: java.lang.String = "close"
                                          var x5697: Boolean = false
                                          var x5698: Boolean = false
                                          var x5700: Boolean = false
                                          val x5680 = x5673 + 1
                                          var x5701: Int = x5680
                                          var x5703: Int = -1
                                          var x5704: Boolean = true
                                          var x5705: Int = x5680
                                          val x10 = null.asInstanceOf[Char]
                                          val x5269 = { x5231: (Int) =>
                                            var x5233: Char = x10
                                            var x5234: Boolean = true
                                            var x5235: Int = x5231
                                            val x5238 = x5231 >= x5237
                                            val x5263 = if (x5238) {
                                              x5233 = x10
                                              x5234 = true
                                              x5235 = x5231
                                              ()
                                            } else {
                                              val x5239 = x5218(x5231)
                                              val x5240 = x5239 >= 'a'
                                              val x5241 = x5239 <= 'z'
                                              val x5242 = x5240 && x5241
                                              val x5243 = x5239 >= 'A'
                                              val x5244 = x5239 <= 'Z'
                                              val x5245 = x5243 && x5244
                                              val x5246 = x5242 || x5245
                                              val x5261 = if (x5246) {
                                                x5233 = x5239
                                                x5234 = false
                                                val x5247 = x5231 + 1
                                                x5235 = x5247
                                                ()
                                              } else {
                                                x5233 = x10
                                                x5234 = true
                                                x5235 = x5231
                                                ()
                                              }
                                              x5261
                                            }
                                            val x5264 = x5233
                                            val x5265 = x5234
                                            val x5266 = x5235
                                            val x5267 = new ParseResultChar(x5264, x5265, x5266)
                                            x5267
                                          }
                                          val x5305 = { x5225: (Int) =>
                                            var x5227: Char = x10
                                            var x5228: Boolean = true
                                            var x5229: Int = x5225
                                            val x5270 = x5269(x5225)
                                            val x5271 = x5270.empty
                                            val x5299 = if (x5271) {
                                              val x5272 = x5225 >= x5237
                                              val x5291 = if (x5272) {
                                                x5227 = x10
                                                x5228 = true
                                                x5229 = x5225
                                                ()
                                              } else {
                                                val x5273 = x5218(x5225)
                                                val x5274 = x5273 == '-'
                                                val x5289 = if (x5274) {
                                                  x5227 = x5273
                                                  x5228 = false
                                                  val x5275 = x5225 + 1
                                                  x5229 = x5275
                                                  ()
                                                } else {
                                                  x5227 = x10
                                                  x5228 = true
                                                  x5229 = x5225
                                                  ()
                                                }
                                                x5289
                                              }
                                              x5291
                                            } else {
                                              val x5293 = x5270.res
                                              x5227 = x5293
                                              x5228 = x5271
                                              val x5296 = x5270.next
                                              x5229 = x5296
                                              ()
                                            }
                                            val x5300 = x5227
                                            val x5301 = x5228
                                            val x5302 = x5229
                                            val x5303 = new ParseResultChar(x5300, x5301, x5302)
                                            x5303
                                          }
                                          val x19 = null.asInstanceOf[java.lang.String]
                                          val x16 = null.asInstanceOf[Tuple2CharString]
                                          val x6077 = while ({
                                            val x5706 = x5704
                                            val x5707 = x5703
                                            val x5708 = x5705
                                            val x5709 = x5707 != x5708
                                            val x5710 = x5706 && x5709
                                            x5710
                                          }) {
                                            val x5712 = x5705
                                            x5703 = x5712
                                            val x5714 = x5712 >= x5237
                                            val x6075 = if (x5714) {
                                              x5704 = false
                                              ()
                                            } else {
                                              val x5716 = x5218(x5712)
                                              val x5717 = x5716 >= 'a'
                                              val x5718 = x5716 <= 'z'
                                              val x5719 = x5717 && x5718
                                              val x5720 = x5716 >= 'A'
                                              val x5721 = x5716 <= 'Z'
                                              val x5722 = x5720 && x5721
                                              val x5723 = x5719 || x5722
                                              val x6073 = if (x5723) {
                                                var x5732: java.lang.String = ""
                                                var x5733: Boolean = false
                                                val x5724 = x5712 + 1
                                                var x5734: Int = x5724
                                                var x5736: Int = -1
                                                var x5737: Boolean = true
                                                var x5738: Int = x5724
                                                val x5769 = while ({
                                                  val x5739 = x5737
                                                  val x5740 = x5736
                                                  val x5741 = x5738
                                                  val x5742 = x5740 != x5741
                                                  val x5743 = x5739 && x5742
                                                  x5743
                                                }) {
                                                  val x5745 = x5738
                                                  x5736 = x5745
                                                  val x5747 = x5305(x5745)
                                                  val x5748 = x5747.empty
                                                  val x5767 = if (x5748) {
                                                    x5737 = false
                                                    ()
                                                  } else {
                                                    val x5751 = x5732
                                                    val x5752 = x5733
                                                    val x5753 = x5734
                                                    val x5755 = x5747.res
                                                    val x5756 = x5755.toInt
                                                    val x5757 = x5756 | 32
                                                    val x5758 = x5757.toChar
                                                    val x5759 = x5751 + x5758
                                                    x5732 = x5759
                                                    x5733 = false
                                                    val x5760 = x5747.next
                                                    x5734 = x5760
                                                    x5738 = x5760
                                                    ()
                                                  }
                                                  x5767
                                                }
                                                val x5770 = x5732
                                                val x5771 = x5733
                                                val x5772 = x5734
                                                val x5777 = if (x5771) {
                                                  true
                                                } else {
                                                  false
                                                }
                                                val x5789 = if (x5777) {
                                                  true
                                                } else {
                                                  false
                                                }
                                                val x6069 = if (x5789) {
                                                  x5704 = false
                                                  ()
                                                } else {
                                                  var x5795: scala.collection.immutable.List[Char] = x7
                                                  var x5796: Boolean = false
                                                  val x5778 = if (x5771) {
                                                    x5712
                                                  } else {
                                                    x5772
                                                  }
                                                  val x5790 = if (x5777) {
                                                    x5778
                                                  } else {
                                                    x5778
                                                  }
                                                  var x5797: Int = x5790
                                                  var x5799: Int = -1
                                                  var x5800: Boolean = true
                                                  var x5801: Int = x5790
                                                  val x5836 = while ({
                                                    val x5802 = x5800
                                                    val x5803 = x5799
                                                    val x5804 = x5801
                                                    val x5805 = x5803 != x5804
                                                    val x5806 = x5802 && x5805
                                                    x5806
                                                  }) {
                                                    val x5808 = x5801
                                                    x5799 = x5808
                                                    val x5810 = x5808 >= x5237
                                                    val x5834 = if (x5810) {
                                                      x5800 = false
                                                      ()
                                                    } else {
                                                      val x5812 = x5218(x5808)
                                                      val x5813 = x5812 == ' '
                                                      val x5832 = if (x5813) {
                                                        val x5818 = x5795
                                                        val x5819 = x5796
                                                        val x5820 = x5797
                                                        val x5822 = List(x5812)
                                                        val x5823 = x5818 ::: x5822
                                                        x5795 = x5823
                                                        x5796 = false
                                                        val x5814 = x5808 + 1
                                                        x5797 = x5814
                                                        x5801 = x5814
                                                        ()
                                                      } else {
                                                        x5800 = false
                                                        ()
                                                      }
                                                      x5832
                                                    }
                                                    x5834
                                                  }
                                                  val x5837 = x5795
                                                  val x5838 = x5796
                                                  val x5839 = x5797
                                                  val x5844 = if (x5838) {
                                                    true
                                                  } else {
                                                    false
                                                  }
                                                  val x6067 = if (x5844) {
                                                    x5704 = false
                                                    ()
                                                  } else {
                                                    val x5845 = if (x5838) {
                                                      x5839
                                                    } else {
                                                      x5839
                                                    }
                                                    val x5848 = x5845 >= x5237
                                                    val x6065 = if (x5848) {
                                                      x5704 = false
                                                      ()
                                                    } else {
                                                      val x5850 = x5218(x5845)
                                                      val x5851 = x5850 == ':'
                                                      val x6063 = if (x5851) {
                                                        var x5870: scala.collection.immutable.List[Char] = x7
                                                        var x5871: Boolean = false
                                                        val x5852 = x5845 + 1
                                                        var x5872: Int = x5852
                                                        var x5874: Int = -1
                                                        var x5875: Boolean = true
                                                        var x5876: Int = x5852
                                                        val x5911 = while ({
                                                          val x5877 = x5875
                                                          val x5878 = x5874
                                                          val x5879 = x5876
                                                          val x5880 = x5878 != x5879
                                                          val x5881 = x5877 && x5880
                                                          x5881
                                                        }) {
                                                          val x5883 = x5876
                                                          x5874 = x5883
                                                          val x5885 = x5883 >= x5237
                                                          val x5909 = if (x5885) {
                                                            x5875 = false
                                                            ()
                                                          } else {
                                                            val x5887 = x5218(x5883)
                                                            val x5888 = x5887 == ' '
                                                            val x5907 = if (x5888) {
                                                              val x5893 = x5870
                                                              val x5894 = x5871
                                                              val x5895 = x5872
                                                              val x5897 = List(x5887)
                                                              val x5898 = x5893 ::: x5897
                                                              x5870 = x5898
                                                              x5871 = false
                                                              val x5889 = x5883 + 1
                                                              x5872 = x5889
                                                              x5876 = x5889
                                                              ()
                                                            } else {
                                                              x5875 = false
                                                              ()
                                                            }
                                                            x5907
                                                          }
                                                          x5909
                                                        }
                                                        val x5912 = x5870
                                                        val x5913 = x5871
                                                        val x5914 = x5872
                                                        val x5919 = if (x5913) {
                                                          true
                                                        } else {
                                                          false
                                                        }
                                                        val x6059 = if (x5919) {
                                                          x5704 = false
                                                          ()
                                                        } else {
                                                          var x5932: java.lang.String = ""
                                                          var x5933: Boolean = false
                                                          val x5920 = if (x5913) {
                                                            x5914
                                                          } else {
                                                            x5914
                                                          }
                                                          var x5934: Int = x5920
                                                          var x5936: Int = -1
                                                          var x5937: Boolean = true
                                                          var x5938: Int = x5920
                                                          val x5973 = while ({
                                                            val x5939 = x5937
                                                            val x5940 = x5936
                                                            val x5941 = x5938
                                                            val x5942 = x5940 != x5941
                                                            val x5943 = x5939 && x5942
                                                            x5943
                                                          }) {
                                                            val x5945 = x5938
                                                            x5936 = x5945
                                                            val x5947 = x5945 >= x5237
                                                            val x5971 = if (x5947) {
                                                              x5937 = false
                                                              ()
                                                            } else {
                                                              val x5949 = x5218(x5945)
                                                              val x5955 = x5949 == '
'
                                                              val x5969 = if (x5955) {
                                                                x5937 = false
                                                                ()
                                                              } else {
                                                                val x5958 = x5932
                                                                val x5959 = x5933
                                                                val x5960 = x5934
                                                                val x5962 = x5958 + x5949
                                                                x5932 = x5962
                                                                x5933 = false
                                                                val x5951 = x5945 + 1
                                                                x5934 = x5951
                                                                x5938 = x5951
                                                                ()
                                                              }
                                                              x5969
                                                            }
                                                            x5971
                                                          }
                                                          val x5974 = x5932
                                                          val x5975 = x5933
                                                          val x5976 = x5934
                                                          val x6057 = if (x5975) {
                                                            x5704 = false
                                                            ()
                                                          } else {
                                                            val x5978 = x5976 >= x5237
                                                            val x6055 = if (x5978) {
                                                              x5704 = false
                                                              ()
                                                            } else {
                                                              val x5980 = x5218(x5976)
                                                              val x5981 = x5980 == '
'
                                                              val x6053 = if (x5981) {
                                                                val x5991 = x5694
                                                                val x5992 = x5695
                                                                val x5993 = x5696
                                                                val x5994 = x5697
                                                                val x5995 = x5698
                                                                val x5997 = x5700
                                                                val x5998 = x5701
                                                                val x5788 = if (x5777) {
                                                                  x19
                                                                } else {
                                                                  val x5776 = if (x5771) {
                                                                    x16
                                                                  } else {
                                                                    val x5774 = new Tuple2CharString(x5716, x5770)
                                                                    x5774
                                                                  }
                                                                  val x5782 = x5776._2
                                                                  val x5781 = x5776._1
                                                                  val x5783 = x5781.toInt
                                                                  val x5784 = x5783 | 32
                                                                  val x5785 = x5784.toChar
                                                                  val x5786 = x5785 + x5782
                                                                  x5786
                                                                }
                                                                val x6000 = x5788 == "connection"
                                                                val x6001 = x5788 == "proxy-connection"
                                                                val x6002 = x6000 || x6001
                                                                val x6003 = x5974 == "keep-alive"
                                                                val x6004 = x5974 == "close"
                                                                val x6005 = x6003 || x6004
                                                                val x6006 = x6002 && x6005
                                                                val x6035 = if (x6006) {
                                                                  x5991
                                                                } else {
                                                                  val x6008 = x5788 == "content-length"
                                                                  val x6029 = if (x6008) {
                                                                    x5991
                                                                  } else {
                                                                    val x6011 = x5788 == "transfer-encoding"
                                                                    val x6012 = x5974 == "chunked"
                                                                    val x6013 = x6011 && x6012
                                                                    val x6023 = if (x6013) {
                                                                      x5991
                                                                    } else {
                                                                      val x6015 = x5788 == "upgrade"
                                                                      val x6017 = if (x6015) {
                                                                        x5991
                                                                      } else {
                                                                        x5991
                                                                      }
                                                                      x6017
                                                                    }
                                                                    x6023
                                                                  }
                                                                  x6029
                                                                }
                                                                x5694 = x6035
                                                                val x6036 = if (x6006) {
                                                                  x5992
                                                                } else {
                                                                  val x6008 = x5788 == "content-length"
                                                                  val x6030 = if (x6008) {
                                                                    val x6009 = x5974.toInt
                                                                    x6009
                                                                  } else {
                                                                    val x6011 = x5788 == "transfer-encoding"
                                                                    val x6012 = x5974 == "chunked"
                                                                    val x6013 = x6011 && x6012
                                                                    val x6024 = if (x6013) {
                                                                      x5992
                                                                    } else {
                                                                      val x6015 = x5788 == "upgrade"
                                                                      val x6018 = if (x6015) {
                                                                        x5992
                                                                      } else {
                                                                        x5992
                                                                      }
                                                                      x6018
                                                                    }
                                                                    x6024
                                                                  }
                                                                  x6030
                                                                }
                                                                x5695 = x6036
                                                                val x6037 = if (x6006) {
                                                                  x5974
                                                                } else {
                                                                  val x6008 = x5788 == "content-length"
                                                                  val x6031 = if (x6008) {
                                                                    x5993
                                                                  } else {
                                                                    val x6011 = x5788 == "transfer-encoding"
                                                                    val x6012 = x5974 == "chunked"
                                                                    val x6013 = x6011 && x6012
                                                                    val x6025 = if (x6013) {
                                                                      x5993
                                                                    } else {
                                                                      val x6015 = x5788 == "upgrade"
                                                                      val x6019 = if (x6015) {
                                                                        x5993
                                                                      } else {
                                                                        x5993
                                                                      }
                                                                      x6019
                                                                    }
                                                                    x6025
                                                                  }
                                                                  x6031
                                                                }
                                                                x5696 = x6037
                                                                val x6038 = if (x6006) {
                                                                  x5994
                                                                } else {
                                                                  val x6008 = x5788 == "content-length"
                                                                  val x6032 = if (x6008) {
                                                                    x5994
                                                                  } else {
                                                                    val x6011 = x5788 == "transfer-encoding"
                                                                    val x6012 = x5974 == "chunked"
                                                                    val x6013 = x6011 && x6012
                                                                    val x6026 = if (x6013) {
                                                                      true
                                                                    } else {
                                                                      val x6015 = x5788 == "upgrade"
                                                                      val x6020 = if (x6015) {
                                                                        x5994
                                                                      } else {
                                                                        x5994
                                                                      }
                                                                      x6020
                                                                    }
                                                                    x6026
                                                                  }
                                                                  x6032
                                                                }
                                                                x5697 = x6038
                                                                val x6039 = if (x6006) {
                                                                  x5995
                                                                } else {
                                                                  val x6008 = x5788 == "content-length"
                                                                  val x6033 = if (x6008) {
                                                                    x5995
                                                                  } else {
                                                                    val x6011 = x5788 == "transfer-encoding"
                                                                    val x6012 = x5974 == "chunked"
                                                                    val x6013 = x6011 && x6012
                                                                    val x6027 = if (x6013) {
                                                                      x5995
                                                                    } else {
                                                                      val x6015 = x5788 == "upgrade"
                                                                      val x6021 = if (x6015) {
                                                                        true
                                                                      } else {
                                                                        x5995
                                                                      }
                                                                      x6021
                                                                    }
                                                                    x6027
                                                                  }
                                                                  x6033
                                                                }
                                                                x5698 = x6039
                                                                x5700 = false
                                                                val x5982 = x5976 + 1
                                                                x5701 = x5982
                                                                x5705 = x5982
                                                                ()
                                                              } else {
                                                                x5704 = false
                                                                ()
                                                              }
                                                              x6053
                                                            }
                                                            x6055
                                                          }
                                                          x6057
                                                        }
                                                        x6059
                                                      } else {
                                                        x5704 = false
                                                        ()
                                                      }
                                                      x6063
                                                    }
                                                    x6065
                                                  }
                                                  x6067
                                                }
                                                x6069
                                              } else {
                                                x5704 = false
                                                ()
                                              }
                                              x6073
                                            }
                                            x6075
                                          }
                                          val x6078 = x5694
                                          val x6079 = x5695
                                          val x6080 = x5696
                                          val x6081 = x5697
                                          val x6082 = x5698
                                          val x6084 = x5700
                                          val x6085 = x5701
                                          val x6090 = if (x6084) {
                                            true
                                          } else {
                                            false
                                          }
                                          val x6188 = if (x6090) {
                                            x5221 = x5219
                                            x5222 = true
                                            x5223 = 0
                                            ()
                                          } else {
                                            val x6091 = if (x6084) {
                                              0
                                            } else {
                                              x6085
                                            }
                                            val x6093 = x6091 >= x5237
                                            val x6186 = if (x6093) {
                                              x5221 = x5219
                                              x5222 = true
                                              x5223 = 0
                                              ()
                                            } else {
                                              val x6095 = x5218(x6091)
                                              val x6096 = x6095 == '
'
                                              val x6184 = if (x6096) {
                                                var x6118: java.lang.String = ""
                                                var x6119: Boolean = false
                                                val x6097 = x6091 + 1
                                                var x6120: Int = x6097
                                                var x6122: Int = -1
                                                var x6123: Boolean = true
                                                var x6124: Int = x6097
                                                var x6125: Int = 0
                                                val x6089 = if (x6084) {
                                                  val x3221 = null.asInstanceOf[Tuple2IntAnon1323431030]
                                                  x3221
                                                } else {
                                                  val x6083 = new Anon1323431030(x6078, x6079, x6080, x6081, x6082)
                                                  val x6087 = new Tuple2IntAnon1323431030(x5620, x6083)
                                                  x6087
                                                }
                                                val x6110 = x6089._2
                                                val x6111 = x6110.contentLength
                                                val x6160 = while ({
                                                  val x6126 = x6125
                                                  val x6128 = x6122
                                                  val x6129 = x6124
                                                  val x6132 = x6123
                                                  val x6127 = x6126 < x6111
                                                  val x6130 = x6128 != x6129
                                                  val x6131 = x6127 && x6130
                                                  val x6133 = x6131 && x6132
                                                  x6133
                                                }) {
                                                  val x6135 = x6124
                                                  x6122 = x6135
                                                  val x6137 = x6135 >= x5237
                                                  val x6158 = if (x6137) {
                                                    x6123 = false
                                                    ()
                                                  } else {
                                                    val x6144 = x6118
                                                    val x6145 = x6119
                                                    val x6146 = x6120
                                                    val x6139 = x5218(x6135)
                                                    val x6148 = x6144 + x6139
                                                    x6118 = x6148
                                                    x6119 = false
                                                    val x6140 = x6135 + 1
                                                    x6120 = x6140
                                                    x6124 = x6140
                                                    val x6154 = x6125
                                                    val x6155 = x6154 + 1
                                                    x6125 = x6155
                                                    ()
                                                  }
                                                  x6158
                                                }
                                                val x6161 = x6118
                                                val x6162 = x6119
                                                val x6163 = x6120
                                                val x6169 = if (x6162) {
                                                  true
                                                } else {
                                                  false
                                                }
                                                val x6172 = if (x6169) {
                                                  x5219
                                                } else {
                                                  val x6168 = if (x6162) {
                                                    x5219
                                                  } else {
                                                    val x6109 = x6089._1
                                                    val x6112 = x6110.connection
                                                    val x6113 = x6110.chunked
                                                    val x6114 = x6110.upgrade
                                                    val x6115 = new Anon1323431030(x6109, x6111, x6112, x6113, x6114)
                                                    val x6166 = new Tuple2Anon1323431030String(x6115, x6161)
                                                    x6166
                                                  }
                                                  x6168
                                                }
                                                x5221 = x6172
                                                val x6173 = if (x6169) {
                                                  true
                                                } else {
                                                  x6169
                                                }
                                                x5222 = x6173
                                                val x6174 = if (x6169) {
                                                  0
                                                } else {
                                                  val x6170 = if (x6162) {
                                                    x6163
                                                  } else {
                                                    x6163
                                                  }
                                                  x6170
                                                }
                                                x5223 = x6174
                                                ()
                                              } else {
                                                x5221 = x5219
                                                x5222 = true
                                                x5223 = 0
                                                ()
                                              }
                                              x6184
                                            }
                                            x6186
                                          }
                                          x6188
                                        } else {
                                          x5221 = x5219
                                          x5222 = true
                                          x5223 = 0
                                          ()
                                        }
                                        x6194
                                      }
                                      x6196
                                    }
                                    x6198
                                  }
                                  x6200
                                }
                                x6202
                              }
                              x6204
                            } else {
                              x5221 = x5219
                              x5222 = true
                              x5223 = 0
                              ()
                            }
                            x6210
                          }
                          x6212
                        }
                        x6214
                      } else {
                        x5221 = x5219
                        x5222 = true
                        x5223 = 0
                        ()
                      }
                      x6220
                    }
                    x6222
                  } else {
                    x5221 = x5219
                    x5222 = true
                    x5223 = 0
                    ()
                  }
                  x6228
                }
                x6230
              } else {
                x5221 = x5219
                x5222 = true
                x5223 = 0
                ()
              }
              x6236
            }
            x6238
          } else {
            x5221 = x5219
            x5222 = true
            x5223 = 0
            ()
          }
          x6244
        }
        x6246
      } else {
        x5221 = x5219
        x5222 = true
        x5223 = 0
        ()
      }
      x6252
    }
    val x6255 = x5221
    val x6256 = x5222
    val x6257 = x5223
    val x6258 = new ParseResultTuple2Anon1323431030String(x6255, x6256, x6257)
    //val x6259 = println(x6258)
    //x6259
    ()
  }
}
/**
 * ***************************************
 * End of Generated Code
 * *****************************************
 */

case class Tuple2StringString(_1: java.lang.String, _2: java.lang.String)

case class Anon1323431030(status: Int, contentLength: Int, connection: java.lang.String, chunked: Boolean, upgrade: Boolean)

case class ParseResultTuple2StringString(res: Tuple2StringString, empty: Boolean, next: Int)

case class Tuple2Anon1323431030String(_1: Anon1323431030, _2: java.lang.String)

case class Tuple2CharString(_1: Char, _2: java.lang.String)

case class ParseResultInt(res: Int, empty: Boolean, next: Int)

case class ParseResultTuple2Anon1323431030String(res: Tuple2Anon1323431030String, empty: Boolean, next: Int)

case class ParseResultChar(res: Char, empty: Boolean, next: Int)

case class ParseResultAnon1323431030(res: Anon1323431030, empty: Boolean, next: Int)

case class Tuple2IntAnon1323431030(_1: Int, _2: Anon1323431030)

case class ParseResultString(res: java.lang.String, empty: Boolean, next: Int)
