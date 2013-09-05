package lms.parsing

object TestResponse{
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

    new ResponseParse().apply(resp.toArray)
  }
}

/*****************************************
  Emitting Generated Code
*******************************************/
class ResponseParse extends ((Array[Char])=>(Unit)) with java.io.Serializable{
def apply(x3130:Array[Char]): Unit = {
val x2151 = null.asInstanceOf[Anon1323431030]
var x3131: Anon1323431030 = x2151
var x3132: Boolean = true
var x3133: Int = -1
val x3147 = x3130.length
val x3216 = 0 >= x3147
val x4106 = if (x3216) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3217 = x3130(0)
val x3218 = x3217 == 'H'
val x4104 = if (x3218) {
val x14 = 0 + 1
val x3229 = x14 >= x3147
val x4098 = if (x3229) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3230 = x3130(x14)
val x3231 = x3230 == 'T'
val x4096 = if (x3231) {
val x34 = x14 + 1
val x3237 = x34 >= x3147
val x4090 = if (x3237) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3238 = x3130(x34)
val x3239 = x3238 == 'T'
val x4088 = if (x3239) {
val x46 = x34 + 1
val x3246 = x46 >= x3147
val x4082 = if (x3246) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3247 = x3130(x46)
val x3248 = x3247 == 'P'
val x4080 = if (x3248) {
val x59 = x46 + 1
val x3255 = x59 >= x3147
val x4074 = if (x3255) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3256 = x3130(x59)
val x3257 = x3256 == '/'
val x4072 = if (x3257) {
var x3283: Int = 0
var x3284: Boolean = false
val x72 = x59 + 1
var x3285: Int = x72
var x3287: Int = -1
var x3288: Boolean = true
var x3289: Int = x72
val x3330 = while ({val x3290 = x3288
val x3291 = x3287
val x3292 = x3289
val x3293 = x3291 != x3292
val x3294 = x3290 && x3293
x3294}) {
val x3296 = x3289
x3287 = x3296
val x3298 = x3296 >= x3147
val x3328 = if (x3298) {
x3288 = false
()
} else {
val x3300 = x3130(x3296)
val x3301 = x3300 >= '0'
val x3302 = x3300 <= '9'
val x3303 = x3301 && x3302
val x3326 = if (x3303) {
val x3312 = x3283
val x3313 = x3284
val x3314 = x3285
val x3309 = x3300 - '0'
val x3310 = x3309.toInt
val x3316 = x3312 * 10
val x3317 = x3316 + x3310
x3283 = x3317
x3284 = false
val x3304 = x3296 + 1
x3285 = x3304
x3289 = x3304
()
} else {
x3288 = false
()
}
x3326
}
x3328
}
val x3331 = x3283
val x3332 = x3284
val x3333 = x3285
val x4066 = if (x3332) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3335 = x3333 >= x3147
val x4064 = if (x3335) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3337 = x3130(x3333)
val x3338 = x3337 == '.'
val x4062 = if (x3338) {
var x3351: Int = 0
var x3352: Boolean = false
val x3339 = x3333 + 1
var x3353: Int = x3339
var x3355: Int = -1
var x3356: Boolean = true
var x3357: Int = x3339
val x3398 = while ({val x3358 = x3356
val x3359 = x3355
val x3360 = x3357
val x3361 = x3359 != x3360
val x3362 = x3358 && x3361
x3362}) {
val x3364 = x3357
x3355 = x3364
val x3366 = x3364 >= x3147
val x3396 = if (x3366) {
x3356 = false
()
} else {
val x3368 = x3130(x3364)
val x3369 = x3368 >= '0'
val x3370 = x3368 <= '9'
val x3371 = x3369 && x3370
val x3394 = if (x3371) {
val x3380 = x3351
val x3381 = x3352
val x3382 = x3353
val x3377 = x3368 - '0'
val x3378 = x3377.toInt
val x3384 = x3380 * 10
val x3385 = x3384 + x3378
x3351 = x3385
x3352 = false
val x3372 = x3364 + 1
x3353 = x3372
x3357 = x3372
()
} else {
x3356 = false
()
}
x3394
}
x3396
}
val x3399 = x3351
val x3400 = x3352
val x3401 = x3353
val x3406 = if (x3400) {
true
} else {
false
}
val x3412 = if (x3406) {
true
} else {
false
}
val x4056 = if (x3412) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x7 = List()
var x3420: scala.collection.immutable.List[Char] = x7
var x3421: Boolean = false
val x3413 = if (x3406) {
0
} else {
val x3407 = if (x3400) {
x72
} else {
x3401
}
x3407
}
var x3422: Int = x3413
var x3424: Int = -1
var x3425: Boolean = true
var x3426: Int = x3413
val x3461 = while ({val x3427 = x3425
val x3428 = x3424
val x3429 = x3426
val x3430 = x3428 != x3429
val x3431 = x3427 && x3430
x3431}) {
val x3433 = x3426
x3424 = x3433
val x3435 = x3433 >= x3147
val x3459 = if (x3435) {
x3425 = false
()
} else {
val x3437 = x3130(x3433)
val x3438 = x3437 == ' '
val x3457 = if (x3438) {
val x3443 = x3420
val x3444 = x3421
val x3445 = x3422
val x3447 = List(x3437)
val x3448 = x3443 ::: x3447
x3420 = x3448
x3421 = false
val x3439 = x3433 + 1
x3422 = x3439
x3426 = x3439
()
} else {
x3425 = false
()
}
x3457
}
x3459
}
val x3462 = x3420
val x3463 = x3421
val x3464 = x3422
val x3469 = if (x3463) {
true
} else {
false
}
val x3475 = if (x3469) {
true
} else {
false
}
val x4054 = if (x3475) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
var x3483: Int = 0
var x3484: Boolean = false
val x3476 = if (x3469) {
0
} else {
val x3470 = if (x3463) {
x3464
} else {
x3464
}
x3470
}
var x3485: Int = x3476
var x3487: Int = -1
var x3488: Boolean = true
var x3489: Int = x3476
val x3530 = while ({val x3490 = x3488
val x3491 = x3487
val x3492 = x3489
val x3493 = x3491 != x3492
val x3494 = x3490 && x3493
x3494}) {
val x3496 = x3489
x3487 = x3496
val x3498 = x3496 >= x3147
val x3528 = if (x3498) {
x3488 = false
()
} else {
val x3500 = x3130(x3496)
val x3501 = x3500 >= '0'
val x3502 = x3500 <= '9'
val x3503 = x3501 && x3502
val x3526 = if (x3503) {
val x3512 = x3483
val x3513 = x3484
val x3514 = x3485
val x3509 = x3500 - '0'
val x3510 = x3509.toInt
val x3516 = x3512 * 10
val x3517 = x3516 + x3510
x3483 = x3517
x3484 = false
val x3504 = x3496 + 1
x3485 = x3504
x3489 = x3504
()
} else {
x3488 = false
()
}
x3526
}
x3528
}
val x3531 = x3483
val x3532 = x3484
val x3533 = x3485
val x4052 = if (x3532) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
var x3540: java.lang.String = ""
var x3541: Boolean = false
var x3542: Int = x3533
var x3544: Int = -1
var x3545: Boolean = true
var x3546: Int = x3533
val x3581 = while ({val x3547 = x3545
val x3548 = x3544
val x3549 = x3546
val x3550 = x3548 != x3549
val x3551 = x3547 && x3550
x3551}) {
val x3553 = x3546
x3544 = x3553
val x3555 = x3553 >= x3147
val x3579 = if (x3555) {
x3545 = false
()
} else {
val x3557 = x3130(x3553)
val x3563 = x3557 == '
'
val x3577 = if (x3563) {
x3545 = false
()
} else {
val x3566 = x3540
val x3567 = x3541
val x3568 = x3542
val x3570 = x3566+x3557
x3540 = x3570
x3541 = false
val x3559 = x3553 + 1
x3542 = x3559
x3546 = x3559
()
}
x3577
}
x3579
}
val x3582 = x3540
val x3583 = x3541
val x3584 = x3542
val x4050 = if (x3583) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3587 = x3584 >= x3147
val x4048 = if (x3587) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x3589 = x3130(x3584)
val x3590 = x3589 == '
'
val x4046 = if (x3590) {
var x3605: Int = 200
var x3606: Int = 0
var x3607: java.lang.String = "close"
var x3608: Boolean = false
var x3609: Boolean = false
var x3611: Boolean = false
val x3591 = x3584 + 1
var x3612: Int = x3591
var x3614: Int = -1
var x3615: Boolean = true
var x3616: Int = x3591
val x10 = null.asInstanceOf[Char]
val x3179 = {x3141: (Int) =>
var x3143: Char = x10
var x3144: Boolean = true
var x3145: Int = x3141
val x3148 = x3141 >= x3147
val x3173 = if (x3148) {
x3143 = x10
x3144 = true
x3145 = x3141
()
} else {
val x3149 = x3130(x3141)
val x3150 = x3149 >= 'a'
val x3151 = x3149 <= 'z'
val x3152 = x3150 && x3151
val x3153 = x3149 >= 'A'
val x3154 = x3149 <= 'Z'
val x3155 = x3153 && x3154
val x3156 = x3152 || x3155
val x3171 = if (x3156) {
x3143 = x3149
x3144 = false
val x3157 = x3141 + 1
x3145 = x3157
()
} else {
x3143 = x10
x3144 = true
x3145 = x3141
()
}
x3171
}
val x3174 = x3143
val x3175 = x3144
val x3176 = x3145
val x3177 = new ParseResultChar(x3174,x3175,x3176)
x3177
}
val x3215 = {x3135: (Int) =>
var x3137: Char = x10
var x3138: Boolean = true
var x3139: Int = x3135
val x3180 = x3179(x3135)
val x3181 = x3180.empty
val x3209 = if (x3181) {
val x3182 = x3135 >= x3147
val x3201 = if (x3182) {
x3137 = x10
x3138 = true
x3139 = x3135
()
} else {
val x3183 = x3130(x3135)
val x3184 = x3183 == '-'
val x3199 = if (x3184) {
x3137 = x3183
x3138 = false
val x3185 = x3135 + 1
x3139 = x3185
()
} else {
x3137 = x10
x3138 = true
x3139 = x3135
()
}
x3199
}
x3201
} else {
val x3203 = x3180.res
x3137 = x3203
x3138 = x3181
val x3206 = x3180.next
x3139 = x3206
()
}
val x3210 = x3137
val x3211 = x3138
val x3212 = x3139
val x3213 = new ParseResultChar(x3210,x3211,x3212)
x3213
}
val x19 = null.asInstanceOf[java.lang.String]
val x16 = null.asInstanceOf[Tuple2CharString]
val x3988 = while ({val x3617 = x3615
val x3618 = x3614
val x3619 = x3616
val x3620 = x3618 != x3619
val x3621 = x3617 && x3620
x3621}) {
val x3623 = x3616
x3614 = x3623
val x3625 = x3623 >= x3147
val x3986 = if (x3625) {
x3615 = false
()
} else {
val x3627 = x3130(x3623)
val x3628 = x3627 >= 'a'
val x3629 = x3627 <= 'z'
val x3630 = x3628 && x3629
val x3631 = x3627 >= 'A'
val x3632 = x3627 <= 'Z'
val x3633 = x3631 && x3632
val x3634 = x3630 || x3633
val x3984 = if (x3634) {
var x3643: java.lang.String = ""
var x3644: Boolean = false
val x3635 = x3623 + 1
var x3645: Int = x3635
var x3647: Int = -1
var x3648: Boolean = true
var x3649: Int = x3635
val x3680 = while ({val x3650 = x3648
val x3651 = x3647
val x3652 = x3649
val x3653 = x3651 != x3652
val x3654 = x3650 && x3653
x3654}) {
val x3656 = x3649
x3647 = x3656
val x3658 = x3215(x3656)
val x3659 = x3658.empty
val x3678 = if (x3659) {
x3648 = false
()
} else {
val x3662 = x3643
val x3663 = x3644
val x3664 = x3645
val x3666 = x3658.res
val x3667 = x3666.toInt
val x3668 = x3667 | 32
val x3669 = x3668.toChar
val x3670 = x3662+x3669
x3643 = x3670
x3644 = false
val x3671 = x3658.next
x3645 = x3671
x3649 = x3671
()
}
x3678
}
val x3681 = x3643
val x3682 = x3644
val x3683 = x3645
val x3688 = if (x3682) {
true
} else {
false
}
val x3700 = if (x3688) {
true
} else {
false
}
val x3980 = if (x3700) {
x3615 = false
()
} else {
var x3706: scala.collection.immutable.List[Char] = x7
var x3707: Boolean = false
val x3689 = if (x3682) {
x3623
} else {
x3683
}
val x3701 = if (x3688) {
x3689
} else {
x3689
}
var x3708: Int = x3701
var x3710: Int = -1
var x3711: Boolean = true
var x3712: Int = x3701
val x3747 = while ({val x3713 = x3711
val x3714 = x3710
val x3715 = x3712
val x3716 = x3714 != x3715
val x3717 = x3713 && x3716
x3717}) {
val x3719 = x3712
x3710 = x3719
val x3721 = x3719 >= x3147
val x3745 = if (x3721) {
x3711 = false
()
} else {
val x3723 = x3130(x3719)
val x3724 = x3723 == ' '
val x3743 = if (x3724) {
val x3729 = x3706
val x3730 = x3707
val x3731 = x3708
val x3733 = List(x3723)
val x3734 = x3729 ::: x3733
x3706 = x3734
x3707 = false
val x3725 = x3719 + 1
x3708 = x3725
x3712 = x3725
()
} else {
x3711 = false
()
}
x3743
}
x3745
}
val x3748 = x3706
val x3749 = x3707
val x3750 = x3708
val x3755 = if (x3749) {
true
} else {
false
}
val x3978 = if (x3755) {
x3615 = false
()
} else {
val x3756 = if (x3749) {
x3750
} else {
x3750
}
val x3759 = x3756 >= x3147
val x3976 = if (x3759) {
x3615 = false
()
} else {
val x3761 = x3130(x3756)
val x3762 = x3761 == ':'
val x3974 = if (x3762) {
var x3781: scala.collection.immutable.List[Char] = x7
var x3782: Boolean = false
val x3763 = x3756 + 1
var x3783: Int = x3763
var x3785: Int = -1
var x3786: Boolean = true
var x3787: Int = x3763
val x3822 = while ({val x3788 = x3786
val x3789 = x3785
val x3790 = x3787
val x3791 = x3789 != x3790
val x3792 = x3788 && x3791
x3792}) {
val x3794 = x3787
x3785 = x3794
val x3796 = x3794 >= x3147
val x3820 = if (x3796) {
x3786 = false
()
} else {
val x3798 = x3130(x3794)
val x3799 = x3798 == ' '
val x3818 = if (x3799) {
val x3804 = x3781
val x3805 = x3782
val x3806 = x3783
val x3808 = List(x3798)
val x3809 = x3804 ::: x3808
x3781 = x3809
x3782 = false
val x3800 = x3794 + 1
x3783 = x3800
x3787 = x3800
()
} else {
x3786 = false
()
}
x3818
}
x3820
}
val x3823 = x3781
val x3824 = x3782
val x3825 = x3783
val x3830 = if (x3824) {
true
} else {
false
}
val x3970 = if (x3830) {
x3615 = false
()
} else {
var x3843: java.lang.String = ""
var x3844: Boolean = false
val x3831 = if (x3824) {
x3825
} else {
x3825
}
var x3845: Int = x3831
var x3847: Int = -1
var x3848: Boolean = true
var x3849: Int = x3831
val x3884 = while ({val x3850 = x3848
val x3851 = x3847
val x3852 = x3849
val x3853 = x3851 != x3852
val x3854 = x3850 && x3853
x3854}) {
val x3856 = x3849
x3847 = x3856
val x3858 = x3856 >= x3147
val x3882 = if (x3858) {
x3848 = false
()
} else {
val x3860 = x3130(x3856)
val x3866 = x3860 == '
'
val x3880 = if (x3866) {
x3848 = false
()
} else {
val x3869 = x3843
val x3870 = x3844
val x3871 = x3845
val x3873 = x3869+x3860
x3843 = x3873
x3844 = false
val x3862 = x3856 + 1
x3845 = x3862
x3849 = x3862
()
}
x3880
}
x3882
}
val x3885 = x3843
val x3886 = x3844
val x3887 = x3845
val x3968 = if (x3886) {
x3615 = false
()
} else {
val x3889 = x3887 >= x3147
val x3966 = if (x3889) {
x3615 = false
()
} else {
val x3891 = x3130(x3887)
val x3892 = x3891 == '
'
val x3964 = if (x3892) {
val x3902 = x3605
val x3903 = x3606
val x3904 = x3607
val x3905 = x3608
val x3906 = x3609
val x3908 = x3611
val x3909 = x3612
val x3699 = if (x3688) {
x19
} else {
val x3687 = if (x3682) {
x16
} else {
val x3685 = new Tuple2CharString(x3627,x3681)
x3685
}
val x3693 = x3687._2
val x3692 = x3687._1
val x3694 = x3692.toInt
val x3695 = x3694 | 32
val x3696 = x3695.toChar
val x3697 = x3696+x3693
x3697
}
val x3911 = x3699 == "connection"
val x3912 = x3699 == "proxy-connection"
val x3913 = x3911 || x3912
val x3914 = x3885 == "keep-alive"
val x3915 = x3885 == "close"
val x3916 = x3914 || x3915
val x3917 = x3913 && x3916
val x3946 = if (x3917) {
x3902
} else {
val x3919 = x3699 == "content-length"
val x3940 = if (x3919) {
x3902
} else {
val x3922 = x3699 == "transfer-encoding"
val x3923 = x3885 == "chunked"
val x3924 = x3922 && x3923
val x3934 = if (x3924) {
x3902
} else {
val x3926 = x3699 == "upgrade"
val x3928 = if (x3926) {
x3902
} else {
x3902
}
x3928
}
x3934
}
x3940
}
x3605 = x3946
val x3947 = if (x3917) {
x3903
} else {
val x3919 = x3699 == "content-length"
val x3941 = if (x3919) {
val x3920 = x3885.toInt
x3920
} else {
val x3922 = x3699 == "transfer-encoding"
val x3923 = x3885 == "chunked"
val x3924 = x3922 && x3923
val x3935 = if (x3924) {
x3903
} else {
val x3926 = x3699 == "upgrade"
val x3929 = if (x3926) {
x3903
} else {
x3903
}
x3929
}
x3935
}
x3941
}
x3606 = x3947
val x3948 = if (x3917) {
x3885
} else {
val x3919 = x3699 == "content-length"
val x3942 = if (x3919) {
x3904
} else {
val x3922 = x3699 == "transfer-encoding"
val x3923 = x3885 == "chunked"
val x3924 = x3922 && x3923
val x3936 = if (x3924) {
x3904
} else {
val x3926 = x3699 == "upgrade"
val x3930 = if (x3926) {
x3904
} else {
x3904
}
x3930
}
x3936
}
x3942
}
x3607 = x3948
val x3949 = if (x3917) {
x3905
} else {
val x3919 = x3699 == "content-length"
val x3943 = if (x3919) {
x3905
} else {
val x3922 = x3699 == "transfer-encoding"
val x3923 = x3885 == "chunked"
val x3924 = x3922 && x3923
val x3937 = if (x3924) {
true
} else {
val x3926 = x3699 == "upgrade"
val x3931 = if (x3926) {
x3905
} else {
x3905
}
x3931
}
x3937
}
x3943
}
x3608 = x3949
val x3950 = if (x3917) {
x3906
} else {
val x3919 = x3699 == "content-length"
val x3944 = if (x3919) {
x3906
} else {
val x3922 = x3699 == "transfer-encoding"
val x3923 = x3885 == "chunked"
val x3924 = x3922 && x3923
val x3938 = if (x3924) {
x3906
} else {
val x3926 = x3699 == "upgrade"
val x3932 = if (x3926) {
true
} else {
x3906
}
x3932
}
x3938
}
x3944
}
x3609 = x3950
x3611 = false
val x3893 = x3887 + 1
x3612 = x3893
x3616 = x3893
()
} else {
x3615 = false
()
}
x3964
}
x3966
}
x3968
}
x3970
} else {
x3615 = false
()
}
x3974
}
x3976
}
x3978
}
x3980
} else {
x3615 = false
()
}
x3984
}
x3986
}
val x3989 = x3605
val x3990 = x3606
val x3991 = x3607
val x3992 = x3608
val x3993 = x3609
val x3995 = x3611
val x3996 = x3612
val x4001 = if (x3995) {
true
} else {
false
}
val x4040 = if (x4001) {
x3131 = x2151
x3132 = true
val x4002 = if (x3995) {
0
} else {
x3996
}
x3133 = x4002
()
} else {
val x4002 = if (x3995) {
0
} else {
x3996
}
val x4004 = x4002 >= x3147
val x4038 = if (x4004) {
x3131 = x2151
x3132 = true
x3133 = 0
()
} else {
val x4006 = x3130(x4002)
val x4007 = x4006 == '
'
val x4036 = if (x4007) {
val x4000 = if (x3995) {
val x3221 = null.asInstanceOf[Tuple2IntAnon1323431030]
x3221
} else {
val x3994 = new Anon1323431030(x3989,x3990,x3991,x3992,x3993)
val x3998 = new Tuple2IntAnon1323431030(x3531,x3994)
x3998
}
val x4020 = x4000._1
val x4021 = x4000._2
val x4022 = x4021.contentLength
val x4023 = x4021.connection
val x4024 = x4021.chunked
val x4025 = x4021.upgrade
val x4026 = new Anon1323431030(x4020,x4022,x4023,x4024,x4025)
x3131 = x4026
x3132 = false
val x4008 = x4002 + 1
x3133 = x4008
()
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4036
}
x4038
}
x4040
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4046
}
x4048
}
x4050
}
x4052
}
x4054
}
x4056
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4062
}
x4064
}
x4066
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4072
}
x4074
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4080
}
x4082
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4088
}
x4090
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4096
}
x4098
} else {
x3131 = x2151
x3132 = true
x3133 = 0
()
}
x4104
}
val x4107 = x3131
val x4108 = x3132
val x4109 = x3133
val x4110 = new ParseResultAnon1323431030(x4107,x4108,x4109)
val x4111 = println(x4110)
x4111
}
}
/*****************************************
  End of Generated Code
*******************************************/