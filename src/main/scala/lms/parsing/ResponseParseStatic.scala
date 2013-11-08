package lms.parsing

import java.io.{BufferedReader, FileReader, Serializable}
import scala.collection.mutable.ArrayBuffer

object TestResponseStatic{

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

    val stagedParserStatic = new ResponseParseStatic(
      "connection".toArray,// "connection".length,
      "proxy-connection".toArray,// "proxy-connection".length,
      "keep-alive".toArray, //"keep-alive".length,
      "close".toArray, //"close".length,
      "content-length".toArray, //"content-length".length,
      "transfer-encoding".toArray, //"transfer-encoding".length,
      "chunked".toArray, //"chunked".length,
      "upgrade".toArray//, "upgrade".length
    )

    val stagedParserStatic2 = new ResponseParseStatic2(
      "connection".toArray,// "connection".length,
      "proxy-connection".toArray,// "proxy-connection".length,
      "keep-alive".toArray, //"keep-alive".length,
      "close".toArray, //"close".length,
      "content-length".toArray, //"content-length".length,
      "transfer-encoding".toArray, //"transfer-encoding".length,
      "chunked".toArray, //"chunked".length,
      "upgrade".toArray//, "upgrade".length
    )


    val fileNames = List(1,2,3,4,6).map{x=> "tweet"+x}

    val messages = fileNames.foldLeft(List[Array[Char]]()){case (acc, fileName) =>
      val file = new BufferedReader(new FileReader("src/test/resources/"+fileName))
      val out = new ArrayBuffer[Char]

      var line = file.readLine
      while(line != null){
        out ++= line + "\n"
        line = file.readLine
      }
      out.toArray :: acc
    }

    //for(k <- 1 to 50){
    //  val now = System.nanoTime
    //  for(i <- 1 to 100; m <- messages){
        stagedParserStatic.apply(resp.toArray)
        stagedParserStatic2.apply(resp.toArray)
    //  }
    //  println("time taken: " + (System.nanoTime - now))
    //}
  }
}
/*****************************************
  Emitting Generated Code
*******************************************/
class ResponseParseStatic(
  px1231:Array[Char],
  px1257:Array[Char],
  px1284:Array[Char],
  px1310:Array[Char],
  px1356:Array[Char],
  px1401:Array[Char],
  px1427:Array[Char],
  px1455:Array[Char]) extends ((Array[Char])=>(Unit)) with Serializable{
def apply(x489:Array[Char]): Unit = {
val x490 = null.asInstanceOf[Anon1323431030]
var x492: Anon1323431030 = x490
var x493: Boolean = true
var x494: Int = -1
val x508 = x489.length
val x578 = 0 >= x508
val x1649 = if (x578) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x579 = x489(0)
val x580 = x579 == 'H'
val x1647 = if (x580) {
val x13 = 0 + 1
val x591 = x13 >= x508
val x1641 = if (x591) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x592 = x489(x13)
val x593 = x592 == 'T'
val x1639 = if (x593) {
val x33 = x13 + 1
val x599 = x33 >= x508
val x1633 = if (x599) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x600 = x489(x33)
val x601 = x600 == 'T'
val x1631 = if (x601) {
val x45 = x33 + 1
val x608 = x45 >= x508
val x1625 = if (x608) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x609 = x489(x45)
val x610 = x609 == 'P'
val x1623 = if (x610) {
val x58 = x45 + 1
val x617 = x58 >= x508
val x1617 = if (x617) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x618 = x489(x58)
val x619 = x618 == '/'
val x1615 = if (x619) {
var x645: Int = 0
var x646: Boolean = false
val x71 = x58 + 1
var x647: Int = x71
var x649: Int = -1
var x650: Boolean = true
var x651: Int = x71
val x692 = while ({val x652 = x650
val x653 = x649
val x654 = x651
val x655 = x653 != x654
val x656 = x652 && x655
x656}) {
val x658 = x651
x649 = x658
val x660 = x658 >= x508
val x690 = if (x660) {
x650 = false
()
} else {
val x662 = x489(x658)
val x663 = x662 >= '0'
val x664 = x662 <= '9'
val x665 = x663 && x664
val x688 = if (x665) {
val x674 = x645
val x675 = x646
val x676 = x647
val x671 = x662 - '0'
val x672 = x671.toInt
val x678 = x674 * 10
val x679 = x678 + x672
x645 = x679
x646 = false
val x666 = x658 + 1
x647 = x666
x651 = x666
()
} else {
x650 = false
()
}
x688
}
x690
}
val x693 = x645
val x694 = x646
val x695 = x647
val x1609 = if (x694) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x697 = x695 >= x508
val x1607 = if (x697) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x699 = x489(x695)
val x700 = x699 == '.'
val x1605 = if (x700) {
var x713: Int = 0
var x714: Boolean = false
val x701 = x695 + 1
var x715: Int = x701
var x717: Int = -1
var x718: Boolean = true
var x719: Int = x701
val x760 = while ({val x720 = x718
val x721 = x717
val x722 = x719
val x723 = x721 != x722
val x724 = x720 && x723
x724}) {
val x726 = x719
x717 = x726
val x728 = x726 >= x508
val x758 = if (x728) {
x718 = false
()
} else {
val x730 = x489(x726)
val x731 = x730 >= '0'
val x732 = x730 <= '9'
val x733 = x731 && x732
val x756 = if (x733) {
val x742 = x713
val x743 = x714
val x744 = x715
val x739 = x730 - '0'
val x740 = x739.toInt
val x746 = x742 * 10
val x747 = x746 + x740
x713 = x747
x714 = false
val x734 = x726 + 1
x715 = x734
x719 = x734
()
} else {
x718 = false
()
}
x756
}
x758
}
val x761 = x713
val x762 = x714
val x763 = x715
val x768 = if (x762) {
true
} else {
false
}
val x774 = if (x768) {
true
} else {
false
}
val x1599 = if (x774) {
x492 = x490
x493 = true
x494 = 0
()
} else {
var x782: java.lang.String = ""
var x783: Boolean = false
val x775 = if (x768) {
0
} else {
val x769 = if (x762) {
x71
} else {
x763
}
x769
}
var x784: Int = x775
var x786: Int = -1
var x787: Boolean = true
var x788: Int = x775
val x821 = while ({val x789 = x787
val x790 = x786
val x791 = x788
val x792 = x790 != x791
val x793 = x789 && x792
x793}) {
val x795 = x788
x786 = x795
val x797 = x795 >= x508
val x819 = if (x797) {
x787 = false
()
} else {
val x799 = x489(x795)
val x800 = x799 == ' '
val x817 = if (x800) {
val x805 = x782
val x806 = x783
val x807 = x784
x782 = x805
x783 = false
val x801 = x795 + 1
x784 = x801
x788 = x801
()
} else {
x787 = false
()
}
x817
}
x819
}
val x822 = x782
val x823 = x783
val x824 = x784
val x829 = if (x823) {
true
} else {
false
}
val x1597 = if (x829) {
x492 = x490
x493 = true
x494 = 0
()
} else {
var x837: Int = 0
var x838: Boolean = false
val x830 = if (x823) {
0
} else {
x824
}
var x839: Int = x830
var x841: Int = -1
var x842: Boolean = true
var x843: Int = x830
val x884 = while ({val x844 = x842
val x845 = x841
val x846 = x843
val x847 = x845 != x846
val x848 = x844 && x847
x848}) {
val x850 = x843
x841 = x850
val x852 = x850 >= x508
val x882 = if (x852) {
x842 = false
()
} else {
val x854 = x489(x850)
val x855 = x854 >= '0'
val x856 = x854 <= '9'
val x857 = x855 && x856
val x880 = if (x857) {
val x866 = x837
val x867 = x838
val x868 = x839
val x863 = x854 - '0'
val x864 = x863.toInt
val x870 = x866 * 10
val x871 = x870 + x864
x837 = x871
x838 = false
val x858 = x850 + 1
x839 = x858
x843 = x858
()
} else {
x842 = false
()
}
x880
}
x882
}
val x885 = x837
val x886 = x838
val x887 = x839
val x1595 = if (x886) {
x492 = x490
x493 = true
x494 = 0
()
} else {
var x894: Int = 0
var x895: Boolean = false
var x896: Int = x887
var x898: Int = -1
var x899: Boolean = true
var x900: Int = x887
val x935 = while ({val x901 = x899
val x902 = x898
val x903 = x900
val x904 = x902 != x903
val x905 = x901 && x904
x905}) {
val x907 = x900
x898 = x907
val x909 = x907 >= x508
val x933 = if (x909) {
x899 = false
()
} else {
val x911 = x489(x907)
val x917 = x911 == '
'
val x931 = if (x917) {
x899 = false
()
} else {
val x920 = x894
val x921 = x895
val x922 = x896
val x924 = x920 + 1
x894 = x924
x895 = false
val x913 = x907 + 1
x896 = x913
x900 = x913
()
}
x931
}
x933
}
val x936 = x894
val x937 = x895
val x938 = x896
val x943 = x938 >= x508
val x1593 = if (x943) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x945 = x489(x938)
val x946 = x945 == '
'
val x1591 = if (x946) {
var x957: Int = 200
var x958: Int = 0
var x959: java.lang.String = "close"
var x960: Boolean = false
var x961: Boolean = false
var x963: Boolean = false
val x947 = x938 + 1
var x964: Int = x947
var x966: Int = -1
var x967: Boolean = true
var x968: Int = x947
val x1 = null.asInstanceOf[Int]
val x540 = {x502: (Int) =>
var x504: Int = x1
var x505: Boolean = true
var x506: Int = x502
val x509 = x502 >= x508
val x534 = if (x509) {
x504 = x1
x505 = true
x506 = x502
()
} else {
val x510 = x489(x502)
val x511 = x510 >= 'a'
val x512 = x510 <= 'z'
val x513 = x511 && x512
val x514 = x510 >= 'A'
val x515 = x510 <= 'Z'
val x516 = x514 && x515
val x517 = x513 || x516
val x532 = if (x517) {
x504 = x502
x505 = false
val x518 = x502 + 1
x506 = x518
()
} else {
x504 = x1
x505 = true
x506 = x502
()
}
x532
}
val x535 = x504
val x536 = x505
val x537 = x506
val x538 = new ParseResultInt(x535,x536,x537)
x538
}
val x576 = {x496: (Int) =>
var x498: Int = x1
var x499: Boolean = true
var x500: Int = x496
val x541 = x540(x496)
val x542 = x541.empty
val x570 = if (x542) {
val x543 = x496 >= x508
val x562 = if (x543) {
x498 = x1
x499 = true
x500 = x496
()
} else {
val x544 = x489(x496)
val x545 = x544 == '-'
val x560 = if (x545) {
x498 = x496
x499 = false
val x546 = x496 + 1
x500 = x546
()
} else {
x498 = x1
x499 = true
x500 = x496
()
}
x560
}
x562
} else {
val x564 = x541.res
x498 = x564
x499 = x542
val x567 = x541.next
x500 = x567
()
}
val x571 = x498
val x572 = x499
val x573 = x500
val x574 = new ParseResultInt(x571,x572,x573)
x574
}
val x1231 = px1231 // static data: Array(c,o,n,n,e,c,t,i,o,n)
val x1232 = x1231.length
val x1257 = px1257 // static data: Array(p,r,o,x,y,-,c,o,n,n,e,c,t,i,o,n)
val x1258 = x1257.length
val x1284 = px1284 // static data: Array(k,e,e,p,-,a,l,i,v,e)
val x1285 = x1284.length
val x1310 = px1310 // static data: Array(c,l,o,s,e)
val x1311 = x1310.length
val x1356 = px1356 // static data: Array(c,o,n,t,e,n,t,-,l,e,n,g,t,h)
val x1357 = x1356.length
val x1401 = px1401 // static data: Array(t,r,a,n,s,f,e,r,-,e,n,c,o,d,i,n,g)
val x1402 = x1401.length
val x1427 = px1427 // static data: Array(c,h,u,n,k,e,d)
val x1428 = x1427.length
val x1455 = px1455 // static data: Array(u,p,g,r,a,d,e)
val x1456 = x1455.length
val x1533 = while ({val x969 = x967
val x970 = x966
val x971 = x968
val x972 = x970 != x971
val x973 = x969 && x972
x973}) {
val x975 = x968
x966 = x975
val x977 = x975 >= x508
val x1531 = if (x977) {
x967 = false
()
} else {
val x979 = x489(x975)
val x980 = x979 >= 'a'
val x981 = x979 <= 'z'
val x982 = x980 && x981
val x983 = x979 >= 'A'
val x984 = x979 <= 'Z'
val x985 = x983 && x984
val x986 = x982 || x985
val x1529 = if (x986) {
var x996: Int = 0
var x997: Boolean = false
val x987 = x975 + 1
var x998: Int = x987
var x1000: Int = -1
var x1001: Boolean = true
var x1002: Int = x987
val x1029 = while ({val x1003 = x1001
val x1004 = x1000
val x1005 = x1002
val x1006 = x1004 != x1005
val x1007 = x1003 && x1006
x1007}) {
val x1009 = x1002
x1000 = x1009
val x1011 = x576(x1009)
val x1012 = x1011.empty
val x1027 = if (x1012) {
x1001 = false
()
} else {
val x1015 = x996
val x1016 = x997
val x1017 = x998
val x1019 = x1015 + 1
x996 = x1019
x997 = false
val x1020 = x1011.next
x998 = x1020
x1002 = x1020
()
}
x1027
}
val x1030 = x996
val x1031 = x997
val x1032 = x998
var x1042: java.lang.String = ""
var x1043: Boolean = false
var x1044: Int = x1032
var x1046: Int = -1
var x1047: Boolean = true
var x1048: Int = x1032
val x1081 = while ({val x1049 = x1047
val x1050 = x1046
val x1051 = x1048
val x1052 = x1050 != x1051
val x1053 = x1049 && x1052
x1053}) {
val x1055 = x1048
x1046 = x1055
val x1057 = x1055 >= x508
val x1079 = if (x1057) {
x1047 = false
()
} else {
val x1059 = x489(x1055)
val x1060 = x1059 == ' '
val x1077 = if (x1060) {
val x1065 = x1042
val x1066 = x1043
val x1067 = x1044
x1042 = x1065
x1043 = false
val x1061 = x1055 + 1
x1044 = x1061
x1048 = x1061
()
} else {
x1047 = false
()
}
x1077
}
x1079
}
val x1082 = x1042
val x1083 = x1043
val x1084 = x1044
val x1525 = if (x1083) {
x967 = false
()
} else {
val x1088 = x1084 >= x508
val x1523 = if (x1088) {
x967 = false
()
} else {
val x1090 = x489(x1084)
val x1091 = x1090 == ':'
val x1521 = if (x1091) {
var x1109: java.lang.String = ""
var x1110: Boolean = false
val x1092 = x1084 + 1
var x1111: Int = x1092
var x1113: Int = -1
var x1114: Boolean = true
var x1115: Int = x1092
val x1148 = while ({val x1116 = x1114
val x1117 = x1113
val x1118 = x1115
val x1119 = x1117 != x1118
val x1120 = x1116 && x1119
x1120}) {
val x1122 = x1115
x1113 = x1122
val x1124 = x1122 >= x508
val x1146 = if (x1124) {
x1114 = false
()
} else {
val x1126 = x489(x1122)
val x1127 = x1126 == ' '
val x1144 = if (x1127) {
val x1132 = x1109
val x1133 = x1110
val x1134 = x1111
x1109 = x1132
x1110 = false
val x1128 = x1122 + 1
x1111 = x1128
x1115 = x1128
()
} else {
x1114 = false
()
}
x1144
}
x1146
}
val x1149 = x1109
val x1150 = x1110
val x1151 = x1111
val x1517 = if (x1150) {
x967 = false
()
} else {
var x1163: Int = 0
var x1164: Boolean = false
var x1165: Int = x1151
var x1167: Int = -1
var x1168: Boolean = true
var x1169: Int = x1151
val x1204 = while ({val x1170 = x1168
val x1171 = x1167
val x1172 = x1169
val x1173 = x1171 != x1172
val x1174 = x1170 && x1173
x1174}) {
val x1176 = x1169
x1167 = x1176
val x1178 = x1176 >= x508
val x1202 = if (x1178) {
x1168 = false
()
} else {
val x1180 = x489(x1176)
val x1186 = x1180 == '
'
val x1200 = if (x1186) {
x1168 = false
()
} else {
val x1189 = x1163
val x1190 = x1164
val x1191 = x1165
val x1193 = x1189 + 1
x1163 = x1193
x1164 = false
val x1182 = x1176 + 1
x1165 = x1182
x1169 = x1182
()
}
x1200
}
x1202
}
val x1205 = x1163
val x1206 = x1164
val x1207 = x1165
val x1211 = x1207 >= x508
val x1515 = if (x1211) {
x967 = false
()
} else {
val x1213 = x489(x1207)
val x1214 = x1213 == '
'
val x1513 = if (x1214) {
val x1222 = x957
val x1223 = x958
val x1224 = x959
val x1225 = x960
val x1226 = x961
val x1228 = x963
val x1229 = x964
val x1038 = x1030 + 1
val x1233 = x1038 == x1232
val x1256 = if (x1233) {
var x1234: Int = 0
var x1235: Boolean = true
val x1253 = while ({val x1236 = x1234
val x1238 = x1235
val x1237 = x1236 < x1038
val x1239 = x1237 && x1238
x1239}) {
val x1241 = x1234
val x1242 = x1241 + x975
val x1243 = x489(x1242)
val x1244 = x1231(x1241)
val x1246 = x1243 == x1244
val x1249 = if (x1246) {
()
} else {
x1235 = false
()
}
val x1250 = x1241 + 1
x1234 = x1250
()
}
val x1254 = x1235
x1254
} else {
false
}
val x1259 = x1038 == x1258
val x1282 = if (x1259) {
var x1260: Int = 0
var x1261: Boolean = true
val x1279 = while ({val x1262 = x1260
val x1264 = x1261
val x1263 = x1262 < x1038
val x1265 = x1263 && x1264
x1265}) {
val x1267 = x1260
val x1268 = x1267 + x975
val x1269 = x489(x1268)
val x1270 = x1257(x1267)
val x1272 = x1269 == x1270
val x1275 = if (x1272) {
()
} else {
x1261 = false
()
}
val x1276 = x1267 + 1
x1260 = x1276
()
}
val x1280 = x1261
x1280
} else {
false
}
val x1283 = x1256 || x1282
val x1286 = x1205 == x1285
val x1309 = if (x1286) {
var x1287: Int = 0
var x1288: Boolean = true
val x1306 = while ({val x1289 = x1287
val x1291 = x1288
val x1290 = x1289 < x1205
val x1292 = x1290 && x1291
x1292}) {
val x1294 = x1287
val x1295 = x1294 + x1151
val x1296 = x489(x1295)
val x1297 = x1284(x1294)
val x1299 = x1296 == x1297
val x1302 = if (x1299) {
()
} else {
x1288 = false
()
}
val x1303 = x1294 + 1
x1287 = x1303
()
}
val x1307 = x1288
x1307
} else {
false
}
val x1312 = x1205 == x1311
val x1335 = if (x1312) {
var x1313: Int = 0
var x1314: Boolean = true
val x1332 = while ({val x1315 = x1313
val x1317 = x1314
val x1316 = x1315 < x1205
val x1318 = x1316 && x1317
x1318}) {
val x1320 = x1313
val x1321 = x1320 + x1151
val x1322 = x489(x1321)
val x1323 = x1310(x1320)
val x1325 = x1322 == x1323
val x1328 = if (x1325) {
()
} else {
x1314 = false
()
}
val x1329 = x1320 + 1
x1313 = x1329
()
}
val x1333 = x1314
x1333
} else {
false
}
val x1336 = x1309 || x1335
val x1337 = x1283 && x1336
val x1495 = if (x1337) {
var x1338: java.lang.String = ""
var x1339: Int = 0
val x1352 = while ({val x1340 = x1339
val x1341 = x1340 < x1205
x1341}) {
val x1343 = x1338
val x1344 = x1339
val x1345 = x1151 + x1344
val x1346 = x489(x1345)
val x1347 = x1343+x1346
x1338 = x1347
val x1349 = x1344 + 1
x1339 = x1349
()
}
val x1353 = x1338
val x1354 = new Anon1323431030(x1222,x1223,x1353,x1225,x1226)
x1354
} else {
val x1358 = x1038 == x1357
val x1381 = if (x1358) {
var x1359: Int = 0
var x1360: Boolean = true
val x1378 = while ({val x1361 = x1359
val x1363 = x1360
val x1362 = x1361 < x1038
val x1364 = x1362 && x1363
x1364}) {
val x1366 = x1359
val x1367 = x1366 + x975
val x1368 = x489(x1367)
val x1369 = x1356(x1366)
val x1371 = x1368 == x1369
val x1374 = if (x1371) {
()
} else {
x1360 = false
()
}
val x1375 = x1366 + 1
x1359 = x1375
()
}
val x1379 = x1360
x1379
} else {
false
}
val x1494 = if (x1381) {
var x1382: java.lang.String = ""
var x1383: Int = 0
val x1396 = while ({val x1384 = x1383
val x1385 = x1384 < x1205
x1385}) {
val x1387 = x1382
val x1388 = x1383
val x1389 = x1151 + x1388
val x1390 = x489(x1389)
val x1391 = x1387+x1390
x1382 = x1391
val x1393 = x1388 + 1
x1383 = x1393
()
}
val x1397 = x1382
val x1398 = x1397.toInt
val x1399 = new Anon1323431030(x1222,x1398,x1224,x1225,x1226)
x1399
} else {
val x1403 = x1038 == x1402
val x1426 = if (x1403) {
var x1404: Int = 0
var x1405: Boolean = true
val x1423 = while ({val x1406 = x1404
val x1408 = x1405
val x1407 = x1406 < x1038
val x1409 = x1407 && x1408
x1409}) {
val x1411 = x1404
val x1412 = x1411 + x975
val x1413 = x489(x1412)
val x1414 = x1401(x1411)
val x1416 = x1413 == x1414
val x1419 = if (x1416) {
()
} else {
x1405 = false
()
}
val x1420 = x1411 + 1
x1404 = x1420
()
}
val x1424 = x1405
x1424
} else {
false
}
val x1429 = x1205 == x1428
val x1452 = if (x1429) {
var x1430: Int = 0
var x1431: Boolean = true
val x1449 = while ({val x1432 = x1430
val x1434 = x1431
val x1433 = x1432 < x1205
val x1435 = x1433 && x1434
x1435}) {
val x1437 = x1430
val x1438 = x1437 + x1151
val x1439 = x489(x1438)
val x1440 = x1427(x1437)
val x1442 = x1439 == x1440
val x1445 = if (x1442) {
()
} else {
x1431 = false
()
}
val x1446 = x1437 + 1
x1430 = x1446
()
}
val x1450 = x1431
x1450
} else {
false
}
val x1453 = x1426 && x1452
val x1488 = if (x1453) {
x1222
} else {
val x1457 = x1038 == x1456
val x1480 = if (x1457) {
var x1458: Int = 0
var x1459: Boolean = true
val x1477 = while ({val x1460 = x1458
val x1462 = x1459
val x1461 = x1460 < x1038
val x1463 = x1461 && x1462
x1463}) {
val x1465 = x1458
val x1466 = x1465 + x975
val x1467 = x489(x1466)
val x1468 = x1455(x1465)
val x1470 = x1467 == x1468
val x1473 = if (x1470) {
()
} else {
x1459 = false
()
}
val x1474 = x1465 + 1
x1458 = x1474
()
}
val x1478 = x1459
x1478
} else {
false
}
val x1482 = if (x1480) {
x1222
} else {
x1222
}
x1482
}
val x1489 = if (x1453) {
x1223
} else {
val x1457 = x1038 == x1456
val x1480 = if (x1457) {
var x1458: Int = 0
var x1459: Boolean = true
val x1477 = while ({val x1460 = x1458
val x1462 = x1459
val x1461 = x1460 < x1038
val x1463 = x1461 && x1462
x1463}) {
val x1465 = x1458
val x1466 = x1465 + x975
val x1467 = x489(x1466)
val x1468 = x1455(x1465)
val x1470 = x1467 == x1468
val x1473 = if (x1470) {
()
} else {
x1459 = false
()
}
val x1474 = x1465 + 1
x1458 = x1474
()
}
val x1478 = x1459
x1478
} else {
false
}
val x1483 = if (x1480) {
x1223
} else {
x1223
}
x1483
}
val x1490 = if (x1453) {
x1224
} else {
val x1457 = x1038 == x1456
val x1480 = if (x1457) {
var x1458: Int = 0
var x1459: Boolean = true
val x1477 = while ({val x1460 = x1458
val x1462 = x1459
val x1461 = x1460 < x1038
val x1463 = x1461 && x1462
x1463}) {
val x1465 = x1458
val x1466 = x1465 + x975
val x1467 = x489(x1466)
val x1468 = x1455(x1465)
val x1470 = x1467 == x1468
val x1473 = if (x1470) {
()
} else {
x1459 = false
()
}
val x1474 = x1465 + 1
x1458 = x1474
()
}
val x1478 = x1459
x1478
} else {
false
}
val x1484 = if (x1480) {
x1224
} else {
x1224
}
x1484
}
val x1491 = if (x1453) {
true
} else {
val x1457 = x1038 == x1456
val x1480 = if (x1457) {
var x1458: Int = 0
var x1459: Boolean = true
val x1477 = while ({val x1460 = x1458
val x1462 = x1459
val x1461 = x1460 < x1038
val x1463 = x1461 && x1462
x1463}) {
val x1465 = x1458
val x1466 = x1465 + x975
val x1467 = x489(x1466)
val x1468 = x1455(x1465)
val x1470 = x1467 == x1468
val x1473 = if (x1470) {
()
} else {
x1459 = false
()
}
val x1474 = x1465 + 1
x1458 = x1474
()
}
val x1478 = x1459
x1478
} else {
false
}
val x1485 = if (x1480) {
x1225
} else {
x1225
}
x1485
}
val x1492 = if (x1453) {
x1226
} else {
val x1457 = x1038 == x1456
val x1480 = if (x1457) {
var x1458: Int = 0
var x1459: Boolean = true
val x1477 = while ({val x1460 = x1458
val x1462 = x1459
val x1461 = x1460 < x1038
val x1463 = x1461 && x1462
x1463}) {
val x1465 = x1458
val x1466 = x1465 + x975
val x1467 = x489(x1466)
val x1468 = x1455(x1465)
val x1470 = x1467 == x1468
val x1473 = if (x1470) {
()
} else {
x1459 = false
()
}
val x1474 = x1465 + 1
x1458 = x1474
()
}
val x1478 = x1459
x1478
} else {
false
}
val x1486 = if (x1480) {
true
} else {
x1226
}
x1486
}
val x1493 = new Anon1323431030(x1488,x1489,x1490,x1491,x1492)
x1493
}
x1494
}
val x1497 = x1495.status
x957 = x1497
val x1499 = x1495.contentLength
x958 = x1499
val x1501 = x1495.connection
x959 = x1501
val x1503 = x1495.chunked
x960 = x1503
val x1505 = x1495.upgrade
x961 = x1505
x963 = false
val x1215 = x1207 + 1
x964 = x1215
x968 = x1215
()
} else {
x967 = false
()
}
x1513
}
x1515
}
x1517
} else {
x967 = false
()
}
x1521
}
x1523
}
x1525
} else {
x967 = false
()
}
x1529
}
x1531
}
val x1534 = x957
val x1535 = x958
val x1536 = x959
val x1537 = x960
val x1538 = x961
val x1540 = x963
val x1541 = x964
val x1546 = if (x1540) {
true
} else {
false
}
val x1585 = if (x1546) {
x492 = x490
x493 = true
val x1547 = if (x1540) {
0
} else {
x1541
}
x494 = x1547
()
} else {
val x1547 = if (x1540) {
0
} else {
x1541
}
val x1549 = x1547 >= x508
val x1583 = if (x1549) {
x492 = x490
x493 = true
x494 = 0
()
} else {
val x1551 = x489(x1547)
val x1552 = x1551 == '
'
val x1581 = if (x1552) {
val x1545 = if (x1540) {
val x583 = null.asInstanceOf[Tuple2IntAnon1323431030]
x583
} else {
val x1539 = new Anon1323431030(x1534,x1535,x1536,x1537,x1538)
val x1543 = new Tuple2IntAnon1323431030(x885,x1539)
x1543
}
val x1565 = x1545._1
val x1566 = x1545._2
val x1567 = x1566.contentLength
val x1568 = x1566.connection
val x1569 = x1566.chunked
val x1570 = x1566.upgrade
val x1571 = new Anon1323431030(x1565,x1567,x1568,x1569,x1570)
x492 = x1571
x493 = false
val x1553 = x1547 + 1
x494 = x1553
()
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1581
}
x1583
}
x1585
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1591
}
x1593
}
x1595
}
x1597
}
x1599
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1605
}
x1607
}
x1609
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1615
}
x1617
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1623
}
x1625
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1631
}
x1633
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1639
}
x1641
} else {
x492 = x490
x493 = true
x494 = 0
()
}
x1647
}
val x1650 = x492
val x1651 = x493
val x1652 = x494
val x1653 = new ParseResultAnon1323431030(x1650,x1651,x1652)
val x1654 = println(x1653)
x1654
()
}
}
/*****************************************
  End of Generated Code
*******************************************/