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
def apply(x3115:Array[Char]): Unit = {
val x2142 = null.asInstanceOf[Anon1323431030]
var x3116: Anon1323431030 = x2142
var x3117: Boolean = true
var x3118: Int = -1
val x3132 = x3115.length
val x3201 = 0 >= x3132
val x4087 = if (x3201) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3202 = x3115(0)
val x3203 = x3202 == 'H'
val x4085 = if (x3203) {
val x13 = 0 + 1
val x3214 = x13 >= x3132
val x4079 = if (x3214) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3215 = x3115(x13)
val x3216 = x3215 == 'T'
val x4077 = if (x3216) {
val x33 = x13 + 1
val x3222 = x33 >= x3132
val x4071 = if (x3222) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3223 = x3115(x33)
val x3224 = x3223 == 'T'
val x4069 = if (x3224) {
val x45 = x33 + 1
val x3231 = x45 >= x3132
val x4063 = if (x3231) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3232 = x3115(x45)
val x3233 = x3232 == 'P'
val x4061 = if (x3233) {
val x58 = x45 + 1
val x3240 = x58 >= x3132
val x4055 = if (x3240) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3241 = x3115(x58)
val x3242 = x3241 == '/'
val x4053 = if (x3242) {
var x3268: Int = 0
var x3269: Boolean = false
val x71 = x58 + 1
var x3270: Int = x71
var x3272: Int = -1
var x3273: Boolean = true
var x3274: Int = x71
val x3315 = while ({val x3275 = x3273
val x3276 = x3272
val x3277 = x3274
val x3278 = x3276 != x3277
val x3279 = x3275 && x3278
x3279}) {
val x3281 = x3274
x3272 = x3281
val x3283 = x3281 >= x3132
val x3313 = if (x3283) {
x3273 = false
()
} else {
val x3285 = x3115(x3281)
val x3286 = x3285 >= '0'
val x3287 = x3285 <= '9'
val x3288 = x3286 && x3287
val x3311 = if (x3288) {
val x3297 = x3268
val x3298 = x3269
val x3299 = x3270
val x3294 = x3285 - '0'
val x3295 = x3294.toInt
val x3301 = x3297 * 10
val x3302 = x3301 + x3295
x3268 = x3302
x3269 = false
val x3289 = x3281 + 1
x3270 = x3289
x3274 = x3289
()
} else {
x3273 = false
()
}
x3311
}
x3313
}
val x3316 = x3268
val x3317 = x3269
val x3318 = x3270
val x4047 = if (x3317) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3320 = x3318 >= x3132
val x4045 = if (x3320) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3322 = x3115(x3318)
val x3323 = x3322 == '.'
val x4043 = if (x3323) {
var x3336: Int = 0
var x3337: Boolean = false
val x3324 = x3318 + 1
var x3338: Int = x3324
var x3340: Int = -1
var x3341: Boolean = true
var x3342: Int = x3324
val x3383 = while ({val x3343 = x3341
val x3344 = x3340
val x3345 = x3342
val x3346 = x3344 != x3345
val x3347 = x3343 && x3346
x3347}) {
val x3349 = x3342
x3340 = x3349
val x3351 = x3349 >= x3132
val x3381 = if (x3351) {
x3341 = false
()
} else {
val x3353 = x3115(x3349)
val x3354 = x3353 >= '0'
val x3355 = x3353 <= '9'
val x3356 = x3354 && x3355
val x3379 = if (x3356) {
val x3365 = x3336
val x3366 = x3337
val x3367 = x3338
val x3362 = x3353 - '0'
val x3363 = x3362.toInt
val x3369 = x3365 * 10
val x3370 = x3369 + x3363
x3336 = x3370
x3337 = false
val x3357 = x3349 + 1
x3338 = x3357
x3342 = x3357
()
} else {
x3341 = false
()
}
x3379
}
x3381
}
val x3384 = x3336
val x3385 = x3337
val x3386 = x3338
val x3391 = if (x3385) {
true
} else {
false
}
val x3397 = if (x3391) {
true
} else {
false
}
val x4037 = if (x3397) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
var x3405: java.lang.String = ""
var x3406: Boolean = false
val x3398 = if (x3391) {
0
} else {
val x3392 = if (x3385) {
x71
} else {
x3386
}
x3392
}
var x3407: Int = x3398
var x3409: Int = -1
var x3410: Boolean = true
var x3411: Int = x3398
val x3445 = while ({val x3412 = x3410
val x3413 = x3409
val x3414 = x3411
val x3415 = x3413 != x3414
val x3416 = x3412 && x3415
x3416}) {
val x3418 = x3411
x3409 = x3418
val x3420 = x3418 >= x3132
val x3443 = if (x3420) {
x3410 = false
()
} else {
val x3422 = x3115(x3418)
val x3423 = x3422 == ' '
val x3441 = if (x3423) {
val x3428 = x3405
val x3429 = x3406
val x3430 = x3407
val x3432 = x3428+x3422
x3405 = x3432
x3406 = false
val x3424 = x3418 + 1
x3407 = x3424
x3411 = x3424
()
} else {
x3410 = false
()
}
x3441
}
x3443
}
val x3446 = x3405
val x3447 = x3406
val x3448 = x3407
val x3453 = if (x3447) {
true
} else {
false
}
val x3459 = if (x3453) {
true
} else {
false
}
val x4035 = if (x3459) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
var x3467: Int = 0
var x3468: Boolean = false
val x3460 = if (x3453) {
0
} else {
val x3454 = if (x3447) {
x3448
} else {
x3448
}
x3454
}
var x3469: Int = x3460
var x3471: Int = -1
var x3472: Boolean = true
var x3473: Int = x3460
val x3514 = while ({val x3474 = x3472
val x3475 = x3471
val x3476 = x3473
val x3477 = x3475 != x3476
val x3478 = x3474 && x3477
x3478}) {
val x3480 = x3473
x3471 = x3480
val x3482 = x3480 >= x3132
val x3512 = if (x3482) {
x3472 = false
()
} else {
val x3484 = x3115(x3480)
val x3485 = x3484 >= '0'
val x3486 = x3484 <= '9'
val x3487 = x3485 && x3486
val x3510 = if (x3487) {
val x3496 = x3467
val x3497 = x3468
val x3498 = x3469
val x3493 = x3484 - '0'
val x3494 = x3493.toInt
val x3500 = x3496 * 10
val x3501 = x3500 + x3494
x3467 = x3501
x3468 = false
val x3488 = x3480 + 1
x3469 = x3488
x3473 = x3488
()
} else {
x3472 = false
()
}
x3510
}
x3512
}
val x3515 = x3467
val x3516 = x3468
val x3517 = x3469
val x4033 = if (x3516) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
var x3524: java.lang.String = ""
var x3525: Boolean = false
var x3526: Int = x3517
var x3528: Int = -1
var x3529: Boolean = true
var x3530: Int = x3517
val x3565 = while ({val x3531 = x3529
val x3532 = x3528
val x3533 = x3530
val x3534 = x3532 != x3533
val x3535 = x3531 && x3534
x3535}) {
val x3537 = x3530
x3528 = x3537
val x3539 = x3537 >= x3132
val x3563 = if (x3539) {
x3529 = false
()
} else {
val x3541 = x3115(x3537)
val x3547 = x3541 == '
'
val x3561 = if (x3547) {
x3529 = false
()
} else {
val x3550 = x3524
val x3551 = x3525
val x3552 = x3526
val x3554 = x3550+x3541
x3524 = x3554
x3525 = false
val x3543 = x3537 + 1
x3526 = x3543
x3530 = x3543
()
}
x3561
}
x3563
}
val x3566 = x3524
val x3567 = x3525
val x3568 = x3526
val x4031 = if (x3567) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3571 = x3568 >= x3132
val x4029 = if (x3571) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3573 = x3115(x3568)
val x3574 = x3573 == '
'
val x4027 = if (x3574) {
var x3589: Int = 200
var x3590: Int = 0
var x3591: java.lang.String = "close"
var x3592: Boolean = false
var x3593: Boolean = false
var x3595: Boolean = false
val x3575 = x3568 + 1
var x3596: Int = x3575
var x3598: Int = -1
var x3599: Boolean = true
var x3600: Int = x3575
val x9 = null.asInstanceOf[Char]
val x3164 = {x3126: (Int) =>
var x3128: Char = x9
var x3129: Boolean = true
var x3130: Int = x3126
val x3133 = x3126 >= x3132
val x3158 = if (x3133) {
x3128 = x9
x3129 = true
x3130 = x3126
()
} else {
val x3134 = x3115(x3126)
val x3135 = x3134 >= 'a'
val x3136 = x3134 <= 'z'
val x3137 = x3135 && x3136
val x3138 = x3134 >= 'A'
val x3139 = x3134 <= 'Z'
val x3140 = x3138 && x3139
val x3141 = x3137 || x3140
val x3156 = if (x3141) {
x3128 = x3134
x3129 = false
val x3142 = x3126 + 1
x3130 = x3142
()
} else {
x3128 = x9
x3129 = true
x3130 = x3126
()
}
x3156
}
val x3159 = x3128
val x3160 = x3129
val x3161 = x3130
val x3162 = new ParseResultChar(x3159,x3160,x3161)
x3162
}
val x3200 = {x3120: (Int) =>
var x3122: Char = x9
var x3123: Boolean = true
var x3124: Int = x3120
val x3165 = x3164(x3120)
val x3166 = x3165.empty
val x3194 = if (x3166) {
val x3167 = x3120 >= x3132
val x3186 = if (x3167) {
x3122 = x9
x3123 = true
x3124 = x3120
()
} else {
val x3168 = x3115(x3120)
val x3169 = x3168 == '-'
val x3184 = if (x3169) {
x3122 = x3168
x3123 = false
val x3170 = x3120 + 1
x3124 = x3170
()
} else {
x3122 = x9
x3123 = true
x3124 = x3120
()
}
x3184
}
x3186
} else {
val x3188 = x3165.res
x3122 = x3188
x3123 = x3166
val x3191 = x3165.next
x3124 = x3191
()
}
val x3195 = x3122
val x3196 = x3123
val x3197 = x3124
val x3198 = new ParseResultChar(x3195,x3196,x3197)
x3198
}
val x18 = null.asInstanceOf[java.lang.String]
val x15 = null.asInstanceOf[Tuple2CharString]
val x3969 = while ({val x3601 = x3599
val x3602 = x3598
val x3603 = x3600
val x3604 = x3602 != x3603
val x3605 = x3601 && x3604
x3605}) {
val x3607 = x3600
x3598 = x3607
val x3609 = x3607 >= x3132
val x3967 = if (x3609) {
x3599 = false
()
} else {
val x3611 = x3115(x3607)
val x3612 = x3611 >= 'a'
val x3613 = x3611 <= 'z'
val x3614 = x3612 && x3613
val x3615 = x3611 >= 'A'
val x3616 = x3611 <= 'Z'
val x3617 = x3615 && x3616
val x3618 = x3614 || x3617
val x3965 = if (x3618) {
var x3627: java.lang.String = ""
var x3628: Boolean = false
val x3619 = x3607 + 1
var x3629: Int = x3619
var x3631: Int = -1
var x3632: Boolean = true
var x3633: Int = x3619
val x3664 = while ({val x3634 = x3632
val x3635 = x3631
val x3636 = x3633
val x3637 = x3635 != x3636
val x3638 = x3634 && x3637
x3638}) {
val x3640 = x3633
x3631 = x3640
val x3642 = x3200(x3640)
val x3643 = x3642.empty
val x3662 = if (x3643) {
x3632 = false
()
} else {
val x3646 = x3627
val x3647 = x3628
val x3648 = x3629
val x3650 = x3642.res
val x3651 = x3650.toInt
val x3652 = x3651 | 32
val x3653 = x3652.toChar
val x3654 = x3646+x3653
x3627 = x3654
x3628 = false
val x3655 = x3642.next
x3629 = x3655
x3633 = x3655
()
}
x3662
}
val x3665 = x3627
val x3666 = x3628
val x3667 = x3629
val x3672 = if (x3666) {
true
} else {
false
}
val x3684 = if (x3672) {
true
} else {
false
}
val x3961 = if (x3684) {
x3599 = false
()
} else {
var x3690: java.lang.String = ""
var x3691: Boolean = false
val x3673 = if (x3666) {
x3607
} else {
x3667
}
val x3685 = if (x3672) {
x3673
} else {
x3673
}
var x3692: Int = x3685
var x3694: Int = -1
var x3695: Boolean = true
var x3696: Int = x3685
val x3730 = while ({val x3697 = x3695
val x3698 = x3694
val x3699 = x3696
val x3700 = x3698 != x3699
val x3701 = x3697 && x3700
x3701}) {
val x3703 = x3696
x3694 = x3703
val x3705 = x3703 >= x3132
val x3728 = if (x3705) {
x3695 = false
()
} else {
val x3707 = x3115(x3703)
val x3708 = x3707 == ' '
val x3726 = if (x3708) {
val x3713 = x3690
val x3714 = x3691
val x3715 = x3692
val x3717 = x3713+x3707
x3690 = x3717
x3691 = false
val x3709 = x3703 + 1
x3692 = x3709
x3696 = x3709
()
} else {
x3695 = false
()
}
x3726
}
x3728
}
val x3731 = x3690
val x3732 = x3691
val x3733 = x3692
val x3738 = if (x3732) {
true
} else {
false
}
val x3959 = if (x3738) {
x3599 = false
()
} else {
val x3739 = if (x3732) {
x3733
} else {
x3733
}
val x3742 = x3739 >= x3132
val x3957 = if (x3742) {
x3599 = false
()
} else {
val x3744 = x3115(x3739)
val x3745 = x3744 == ':'
val x3955 = if (x3745) {
var x3763: java.lang.String = ""
var x3764: Boolean = false
val x3746 = x3739 + 1
var x3765: Int = x3746
var x3767: Int = -1
var x3768: Boolean = true
var x3769: Int = x3746
val x3803 = while ({val x3770 = x3768
val x3771 = x3767
val x3772 = x3769
val x3773 = x3771 != x3772
val x3774 = x3770 && x3773
x3774}) {
val x3776 = x3769
x3767 = x3776
val x3778 = x3776 >= x3132
val x3801 = if (x3778) {
x3768 = false
()
} else {
val x3780 = x3115(x3776)
val x3781 = x3780 == ' '
val x3799 = if (x3781) {
val x3786 = x3763
val x3787 = x3764
val x3788 = x3765
val x3790 = x3786+x3780
x3763 = x3790
x3764 = false
val x3782 = x3776 + 1
x3765 = x3782
x3769 = x3782
()
} else {
x3768 = false
()
}
x3799
}
x3801
}
val x3804 = x3763
val x3805 = x3764
val x3806 = x3765
val x3811 = if (x3805) {
true
} else {
false
}
val x3951 = if (x3811) {
x3599 = false
()
} else {
var x3824: java.lang.String = ""
var x3825: Boolean = false
val x3812 = if (x3805) {
x3806
} else {
x3806
}
var x3826: Int = x3812
var x3828: Int = -1
var x3829: Boolean = true
var x3830: Int = x3812
val x3865 = while ({val x3831 = x3829
val x3832 = x3828
val x3833 = x3830
val x3834 = x3832 != x3833
val x3835 = x3831 && x3834
x3835}) {
val x3837 = x3830
x3828 = x3837
val x3839 = x3837 >= x3132
val x3863 = if (x3839) {
x3829 = false
()
} else {
val x3841 = x3115(x3837)
val x3847 = x3841 == '
'
val x3861 = if (x3847) {
x3829 = false
()
} else {
val x3850 = x3824
val x3851 = x3825
val x3852 = x3826
val x3854 = x3850+x3841
x3824 = x3854
x3825 = false
val x3843 = x3837 + 1
x3826 = x3843
x3830 = x3843
()
}
x3861
}
x3863
}
val x3866 = x3824
val x3867 = x3825
val x3868 = x3826
val x3949 = if (x3867) {
x3599 = false
()
} else {
val x3870 = x3868 >= x3132
val x3947 = if (x3870) {
x3599 = false
()
} else {
val x3872 = x3115(x3868)
val x3873 = x3872 == '
'
val x3945 = if (x3873) {
val x3883 = x3589
val x3884 = x3590
val x3885 = x3591
val x3886 = x3592
val x3887 = x3593
val x3889 = x3595
val x3890 = x3596
val x3683 = if (x3672) {
x18
} else {
val x3671 = if (x3666) {
x15
} else {
val x3669 = new Tuple2CharString(x3611,x3665)
x3669
}
val x3677 = x3671._2
val x3676 = x3671._1
val x3678 = x3676.toInt
val x3679 = x3678 | 32
val x3680 = x3679.toChar
val x3681 = x3680+x3677
x3681
}
val x3892 = x3683 == "connection"
val x3893 = x3683 == "proxy-connection"
val x3894 = x3892 || x3893
val x3895 = x3866 == "keep-alive"
val x3896 = x3866 == "close"
val x3897 = x3895 || x3896
val x3898 = x3894 && x3897
val x3927 = if (x3898) {
x3883
} else {
val x3900 = x3683 == "content-length"
val x3921 = if (x3900) {
x3883
} else {
val x3903 = x3683 == "transfer-encoding"
val x3904 = x3866 == "chunked"
val x3905 = x3903 && x3904
val x3915 = if (x3905) {
x3883
} else {
val x3907 = x3683 == "upgrade"
val x3909 = if (x3907) {
x3883
} else {
x3883
}
x3909
}
x3915
}
x3921
}
x3589 = x3927
val x3928 = if (x3898) {
x3884
} else {
val x3900 = x3683 == "content-length"
val x3922 = if (x3900) {
val x3901 = x3866.toInt
x3901
} else {
val x3903 = x3683 == "transfer-encoding"
val x3904 = x3866 == "chunked"
val x3905 = x3903 && x3904
val x3916 = if (x3905) {
x3884
} else {
val x3907 = x3683 == "upgrade"
val x3910 = if (x3907) {
x3884
} else {
x3884
}
x3910
}
x3916
}
x3922
}
x3590 = x3928
val x3929 = if (x3898) {
x3866
} else {
val x3900 = x3683 == "content-length"
val x3923 = if (x3900) {
x3885
} else {
val x3903 = x3683 == "transfer-encoding"
val x3904 = x3866 == "chunked"
val x3905 = x3903 && x3904
val x3917 = if (x3905) {
x3885
} else {
val x3907 = x3683 == "upgrade"
val x3911 = if (x3907) {
x3885
} else {
x3885
}
x3911
}
x3917
}
x3923
}
x3591 = x3929
val x3930 = if (x3898) {
x3886
} else {
val x3900 = x3683 == "content-length"
val x3924 = if (x3900) {
x3886
} else {
val x3903 = x3683 == "transfer-encoding"
val x3904 = x3866 == "chunked"
val x3905 = x3903 && x3904
val x3918 = if (x3905) {
true
} else {
val x3907 = x3683 == "upgrade"
val x3912 = if (x3907) {
x3886
} else {
x3886
}
x3912
}
x3918
}
x3924
}
x3592 = x3930
val x3931 = if (x3898) {
x3887
} else {
val x3900 = x3683 == "content-length"
val x3925 = if (x3900) {
x3887
} else {
val x3903 = x3683 == "transfer-encoding"
val x3904 = x3866 == "chunked"
val x3905 = x3903 && x3904
val x3919 = if (x3905) {
x3887
} else {
val x3907 = x3683 == "upgrade"
val x3913 = if (x3907) {
true
} else {
x3887
}
x3913
}
x3919
}
x3925
}
x3593 = x3931
x3595 = false
val x3874 = x3868 + 1
x3596 = x3874
x3600 = x3874
()
} else {
x3599 = false
()
}
x3945
}
x3947
}
x3949
}
x3951
} else {
x3599 = false
()
}
x3955
}
x3957
}
x3959
}
x3961
} else {
x3599 = false
()
}
x3965
}
x3967
}
val x3970 = x3589
val x3971 = x3590
val x3972 = x3591
val x3973 = x3592
val x3974 = x3593
val x3976 = x3595
val x3977 = x3596
val x3982 = if (x3976) {
true
} else {
false
}
val x4021 = if (x3982) {
x3116 = x2142
x3117 = true
val x3983 = if (x3976) {
0
} else {
x3977
}
x3118 = x3983
()
} else {
val x3983 = if (x3976) {
0
} else {
x3977
}
val x3985 = x3983 >= x3132
val x4019 = if (x3985) {
x3116 = x2142
x3117 = true
x3118 = 0
()
} else {
val x3987 = x3115(x3983)
val x3988 = x3987 == '
'
val x4017 = if (x3988) {
val x3981 = if (x3976) {
val x3206 = null.asInstanceOf[Tuple2IntAnon1323431030]
x3206
} else {
val x3975 = new Anon1323431030(x3970,x3971,x3972,x3973,x3974)
val x3979 = new Tuple2IntAnon1323431030(x3515,x3975)
x3979
}
val x4001 = x3981._1
val x4002 = x3981._2
val x4003 = x4002.contentLength
val x4004 = x4002.connection
val x4005 = x4002.chunked
val x4006 = x4002.upgrade
val x4007 = new Anon1323431030(x4001,x4003,x4004,x4005,x4006)
x3116 = x4007
x3117 = false
val x3989 = x3983 + 1
x3118 = x3989
()
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4017
}
x4019
}
x4021
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4027
}
x4029
}
x4031
}
x4033
}
x4035
}
x4037
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4043
}
x4045
}
x4047
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4053
}
x4055
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4061
}
x4063
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4069
}
x4071
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4077
}
x4079
} else {
x3116 = x2142
x3117 = true
x3118 = 0
()
}
x4085
}
val x4088 = x3116
val x4089 = x3117
val x4090 = x3118
val x4091 = new ParseResultAnon1323431030(x4088,x4089,x4090)
//val x4092 = println(x4091)
//x4092
()
}
}
/*****************************************
  End of Generated Code
*******************************************/