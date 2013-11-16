package lms.parsing

class TestInterleaved extends ((Array[Char])=>(Unit)) with Serializable {
var res: ParseResultInt = null
def apply(x1869:Array[Char]): Unit = {
var x1870: Int = 0
var x1871: Boolean = true
var x1872: Int = 0
var x1874: Int = 0
val x1876 = x1869.length
val x1877 = 0 >= x1876
val x6142 = if (x1877) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
val x1882 = x1869(0)
val x1883 = x1882 >= '0'
val x1884 = x1882 <= '9'
val x1885 = x1883 && x1884
val x1886 = x1882 >= 'A'
val x1887 = x1882 <= 'F'
val x1888 = x1886 && x1887
val x1889 = x1885 || x1888
val x1890 = x1882 >= 'a'
val x1891 = x1882 <= 'f'
val x1892 = x1890 && x1891
val x1893 = x1889 || x1892
val x6140 = if (x1893) {
val x1904 = if (x1885) {
val x1895 = x1882 - '0'
val x1896 = x1895.toInt
x1896
} else {
val x1903 = if (x1888) {
val x1897 = x1882 - 'A'
val x1898 = x1897.toInt
val x1899 = x1898 + 10
x1899
} else {
val x1900 = x1882 - 'a'
val x1901 = x1900.toInt
val x1902 = x1901 + 10
x1902
}
x1903
}
var x1906: Int = x1904
var x1907: Boolean = false
val x20 = 0 + 1
var x1908: Int = x20
var x1910: Int = -1
var x1911: Boolean = true
var x1912: Int = x20
val x1969 = while ({val x1913 = x1911
val x1914 = x1910
val x1915 = x1912
val x1916 = x1914 != x1915
val x1917 = x1913 && x1916
x1917}) {
val x1919 = x1912
x1910 = x1919
val x1921 = x1919 >= x1876
val x1967 = if (x1921) {
x1911 = false
()
} else {
val x1926 = x1869(x1919)
val x1927 = x1926 >= '0'
val x1928 = x1926 <= '9'
val x1929 = x1927 && x1928
val x1930 = x1926 >= 'A'
val x1931 = x1926 <= 'F'
val x1932 = x1930 && x1931
val x1933 = x1929 || x1932
val x1934 = x1926 >= 'a'
val x1935 = x1926 <= 'f'
val x1936 = x1934 && x1935
val x1937 = x1933 || x1936
val x1965 = if (x1937) {
val x1951 = x1906
val x1952 = x1907
val x1953 = x1908
val x1949 = if (x1929) {
val x1940 = x1926 - '0'
val x1941 = x1940.toInt
x1941
} else {
val x1948 = if (x1932) {
val x1942 = x1926 - 'A'
val x1943 = x1942.toInt
val x1944 = x1943 + 10
x1944
} else {
val x1945 = x1926 - 'a'
val x1946 = x1945.toInt
val x1947 = x1946 + 10
x1947
}
x1948
}
val x1955 = x1951 * 16
val x1956 = x1955 + x1949
x1906 = x1956
x1907 = false
val x1938 = x1919 + 1
x1908 = x1938
x1912 = x1938
()
} else {
x1911 = false
()
}
x1965
}
x1967
}
val x1970 = x1906
val x1971 = x1907
val x1972 = x1908
val x1975 = if (x1971) {
true
} else {
x1971
}
val x6134 = if (x1975) {
val x4052 = if (x1975) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
val x1974 = if (x1971) {
0
} else {
x1970
}
val x1982 = x1974 == 0
val x4050 = if (x1982) {
val x1976 = if (x1971) {
0
} else {
x1972
}
val x1983 = x1976 >= x1876
val x2005 = if (x1983) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
val x1990 = x1869(x1976)
val x1991 = x1990 == '\n'
val x2003 = if (x1991) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
x1870 = 0
x1871 = true
x1872 = 0
()
}
x2003
}
x2005
} else {
val x1976 = if (x1971) {
0
} else {
x1972
}
val x2008 = x1976 + x1974
x1874 = x2008
var x2011: Unit = ()
var x2012: Boolean = false
var x2013: Int = x1976
var x2015: Int = -1
var x2016: Boolean = true
var x2017: Int = x1976
val x2028 = {x2029: (Int) =>
var x2031: Int = 0
var x2032: Boolean = true
var x2033: Int = x2029
val x2035 = x2029 >= x1876
val x2249 = if (x2035) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
val x2041 = x1869(x2029)
val x2042 = x2041 == '\n'
val x2247 = if (x2042) {
val x2043 = x2029 + 1
val x2045 = x2043 >= x1876
val x2241 = if (x2045) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
val x2052 = x1869(x2043)
val x2053 = x2052 >= '0'
val x2054 = x2052 <= '9'
val x2055 = x2053 && x2054
val x2056 = x2052 >= 'A'
val x2057 = x2052 <= 'F'
val x2058 = x2056 && x2057
val x2059 = x2055 || x2058
val x2060 = x2052 >= 'a'
val x2061 = x2052 <= 'f'
val x2062 = x2060 && x2061
val x2063 = x2059 || x2062
val x2239 = if (x2063) {
val x2075 = if (x2055) {
val x2066 = x2052 - '0'
val x2067 = x2066.toInt
x2067
} else {
val x2074 = if (x2058) {
val x2068 = x2052 - 'A'
val x2069 = x2068.toInt
val x2070 = x2069 + 10
x2070
} else {
val x2071 = x2052 - 'a'
val x2072 = x2071.toInt
val x2073 = x2072 + 10
x2073
}
x2074
}
var x2077: Int = x2075
var x2078: Boolean = false
val x2064 = x2043 + 1
var x2079: Int = x2064
var x2081: Int = -1
var x2082: Boolean = true
var x2083: Int = x2064
val x2140 = while ({val x2084 = x2082
val x2085 = x2081
val x2086 = x2083
val x2087 = x2085 != x2086
val x2088 = x2084 && x2087
x2088}) {
val x2090 = x2083
x2081 = x2090
val x2092 = x2090 >= x1876
val x2138 = if (x2092) {
x2082 = false
()
} else {
val x2097 = x1869(x2090)
val x2098 = x2097 >= '0'
val x2099 = x2097 <= '9'
val x2100 = x2098 && x2099
val x2101 = x2097 >= 'A'
val x2102 = x2097 <= 'F'
val x2103 = x2101 && x2102
val x2104 = x2100 || x2103
val x2105 = x2097 >= 'a'
val x2106 = x2097 <= 'f'
val x2107 = x2105 && x2106
val x2108 = x2104 || x2107
val x2136 = if (x2108) {
val x2122 = x2077
val x2123 = x2078
val x2124 = x2079
val x2120 = if (x2100) {
val x2111 = x2097 - '0'
val x2112 = x2111.toInt
x2112
} else {
val x2119 = if (x2103) {
val x2113 = x2097 - 'A'
val x2114 = x2113.toInt
val x2115 = x2114 + 10
x2115
} else {
val x2116 = x2097 - 'a'
val x2117 = x2116.toInt
val x2118 = x2117 + 10
x2118
}
x2119
}
val x2126 = x2122 * 16
val x2127 = x2126 + x2120
x2077 = x2127
x2078 = false
val x2109 = x2090 + 1
x2079 = x2109
x2083 = x2109
()
} else {
x2082 = false
()
}
x2136
}
x2138
}
val x2141 = x2077
val x2142 = x2078
val x2143 = x2079
val x2146 = if (x2142) {
true
} else {
x2142
}
val x2233 = if (x2146) {
val x2187 = if (x2146) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
val x2145 = if (x2142) {
0
} else {
x2141
}
val x2153 = x2145 == 0
val x2185 = if (x2153) {
val x2147 = if (x2142) {
x2043
} else {
x2143
}
val x2154 = x2147 >= x1876
val x2176 = if (x2154) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
val x2161 = x1869(x2147)
val x2162 = x2161 == '\n'
val x2174 = if (x2162) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
x2031 = 0
x2032 = true
x2033 = x2029
()
}
x2174
}
x2176
} else {
val x2147 = if (x2142) {
x2043
} else {
x2143
}
val x2179 = x2147 + x2145
x1874 = x2179
x2031 = x2145
x2032 = false
x2033 = x2147
()
}
x2185
}
x2187
} else {
val x2147 = if (x2142) {
x2043
} else {
x2143
}
val x2154 = x2147 >= x1876
val x2231 = if (x2154) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
val x2161 = x1869(x2147)
val x2162 = x2161 == '\n'
val x2229 = if (x2162) {
val x2145 = if (x2142) {
0
} else {
x2141
}
val x2153 = x2145 == 0
val x2223 = if (x2153) {
val x2163 = x2147 + 1
val x2194 = x2163 >= x1876
val x2215 = if (x2194) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
val x2200 = x1869(x2163)
val x2201 = x2200 == '\n'
val x2213 = if (x2201) {
x2031 = 0
x2032 = true
x2033 = x2029
()
} else {
x2031 = 0
x2032 = true
x2033 = x2029
()
}
x2213
}
x2215
} else {
val x2163 = x2147 + 1
val x2217 = x2163 + x2145
x1874 = x2217
x2031 = x2145
x2032 = false
x2033 = x2163
()
}
x2223
} else {
x2031 = 0
x2032 = true
x2033 = x2029
()
}
x2229
}
x2231
}
x2233
} else {
x2031 = 0
x2032 = true
x2033 = x2029
()
}
x2239
}
x2241
} else {
x2031 = 0
x2032 = true
x2033 = x2029
()
}
x2247
}
val x2250 = x2031
val x2251 = x2032
val x2252 = x2033
val x2253 = new ParseResultInt(x2250,x2251,x2252)
x2253: ParseResultInt
}
val x2333 = while ({val x2018 = x2016
val x2019 = x2015
val x2020 = x2017
val x2021 = x2019 != x2020
val x2022 = x2018 && x2021
x2022}) {
val x2024 = x2017
x2015 = x2024
val x2026 = x1874
val x2027 = x2024 >= x2026
val x2331 = if (x2027) {
val x2255 = x2028(x2024)
val x2256 = x2255.empty
val x2296 = if (x2256) {
x2016 = false
()
} else {
val x2261 = x2255.next
val x2262 = x2261 >= x1876
val x2294 = if (x2262) {
x2016 = false
()
} else {
val x2266 = x1869(x2261)
val x2267 = x2266 == ' '
val x2268 = x2266 == ''
val x2269 = x2267 || x2268
val x2270 = x2266 == '\n'
val x2271 = x2269 || x2270
val x2272 = x2266 == '
'
val x2273 = x2271 || x2272
val x2274 = x2266 == '\t'
val x2275 = x2273 || x2274
val x2276 = x2266 == ''
val x2277 = x2275 || x2276
val x2292 = if (x2277) {
val x2280 = x2011
val x2281 = x2012
val x2282 = x2013
x2011 = ()
x2012 = false
val x2278 = x2261 + 1
x2013 = x2278
x2017 = x2278
()
} else {
x2016 = false
()
}
x2292
}
x2294
}
x2296
} else {
val x2298 = x2024 >= x1876
val x2329 = if (x2298) {
x2016 = false
()
} else {
val x2301 = x1869(x2024)
val x2302 = x2301 == ' '
val x2303 = x2301 == ''
val x2304 = x2302 || x2303
val x2305 = x2301 == '\n'
val x2306 = x2304 || x2305
val x2307 = x2301 == '
'
val x2308 = x2306 || x2307
val x2309 = x2301 == '\t'
val x2310 = x2308 || x2309
val x2311 = x2301 == ''
val x2312 = x2310 || x2311
val x2327 = if (x2312) {
val x2315 = x2011
val x2316 = x2012
val x2317 = x2013
x2011 = ()
x2012 = false
val x2313 = x2024 + 1
x2013 = x2313
x2017 = x2313
()
} else {
x2016 = false
()
}
x2327
}
x2329
}
x2331
}
val x2334 = x2011
val x2335 = x2012
val x2336 = x2013
val x4048 = if (x2335) {
x1870 = 0
x1871 = true
x1872 = x1976
()
} else {
var x2344: Int = 0
var x2345: Boolean = false
var x2346: Int = x2336
var x2348: Int = -1
var x2349: Boolean = true
var x2350: Int = x2336
val x2361 = {x2362: (Int) =>
var x2364: Int = 0
var x2365: Boolean = true
var x2366: Int = x2362
val x2368 = x2362 >= x1876
val x2582 = if (x2368) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
val x2374 = x1869(x2362)
val x2375 = x2374 == '\n'
val x2580 = if (x2375) {
val x2376 = x2362 + 1
val x2378 = x2376 >= x1876
val x2574 = if (x2378) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
val x2385 = x1869(x2376)
val x2386 = x2385 >= '0'
val x2387 = x2385 <= '9'
val x2388 = x2386 && x2387
val x2389 = x2385 >= 'A'
val x2390 = x2385 <= 'F'
val x2391 = x2389 && x2390
val x2392 = x2388 || x2391
val x2393 = x2385 >= 'a'
val x2394 = x2385 <= 'f'
val x2395 = x2393 && x2394
val x2396 = x2392 || x2395
val x2572 = if (x2396) {
val x2408 = if (x2388) {
val x2399 = x2385 - '0'
val x2400 = x2399.toInt
x2400
} else {
val x2407 = if (x2391) {
val x2401 = x2385 - 'A'
val x2402 = x2401.toInt
val x2403 = x2402 + 10
x2403
} else {
val x2404 = x2385 - 'a'
val x2405 = x2404.toInt
val x2406 = x2405 + 10
x2406
}
x2407
}
var x2410: Int = x2408
var x2411: Boolean = false
val x2397 = x2376 + 1
var x2412: Int = x2397
var x2414: Int = -1
var x2415: Boolean = true
var x2416: Int = x2397
val x2473 = while ({val x2417 = x2415
val x2418 = x2414
val x2419 = x2416
val x2420 = x2418 != x2419
val x2421 = x2417 && x2420
x2421}) {
val x2423 = x2416
x2414 = x2423
val x2425 = x2423 >= x1876
val x2471 = if (x2425) {
x2415 = false
()
} else {
val x2430 = x1869(x2423)
val x2431 = x2430 >= '0'
val x2432 = x2430 <= '9'
val x2433 = x2431 && x2432
val x2434 = x2430 >= 'A'
val x2435 = x2430 <= 'F'
val x2436 = x2434 && x2435
val x2437 = x2433 || x2436
val x2438 = x2430 >= 'a'
val x2439 = x2430 <= 'f'
val x2440 = x2438 && x2439
val x2441 = x2437 || x2440
val x2469 = if (x2441) {
val x2455 = x2410
val x2456 = x2411
val x2457 = x2412
val x2453 = if (x2433) {
val x2444 = x2430 - '0'
val x2445 = x2444.toInt
x2445
} else {
val x2452 = if (x2436) {
val x2446 = x2430 - 'A'
val x2447 = x2446.toInt
val x2448 = x2447 + 10
x2448
} else {
val x2449 = x2430 - 'a'
val x2450 = x2449.toInt
val x2451 = x2450 + 10
x2451
}
x2452
}
val x2459 = x2455 * 16
val x2460 = x2459 + x2453
x2410 = x2460
x2411 = false
val x2442 = x2423 + 1
x2412 = x2442
x2416 = x2442
()
} else {
x2415 = false
()
}
x2469
}
x2471
}
val x2474 = x2410
val x2475 = x2411
val x2476 = x2412
val x2479 = if (x2475) {
true
} else {
x2475
}
val x2566 = if (x2479) {
val x2520 = if (x2479) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
val x2478 = if (x2475) {
0
} else {
x2474
}
val x2486 = x2478 == 0
val x2518 = if (x2486) {
val x2480 = if (x2475) {
x2376
} else {
x2476
}
val x2487 = x2480 >= x1876
val x2509 = if (x2487) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
val x2494 = x1869(x2480)
val x2495 = x2494 == '\n'
val x2507 = if (x2495) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
x2364 = 0
x2365 = true
x2366 = x2362
()
}
x2507
}
x2509
} else {
val x2480 = if (x2475) {
x2376
} else {
x2476
}
val x2512 = x2480 + x2478
x1874 = x2512
x2364 = x2478
x2365 = false
x2366 = x2480
()
}
x2518
}
x2520
} else {
val x2480 = if (x2475) {
x2376
} else {
x2476
}
val x2487 = x2480 >= x1876
val x2564 = if (x2487) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
val x2494 = x1869(x2480)
val x2495 = x2494 == '\n'
val x2562 = if (x2495) {
val x2478 = if (x2475) {
0
} else {
x2474
}
val x2486 = x2478 == 0
val x2556 = if (x2486) {
val x2496 = x2480 + 1
val x2527 = x2496 >= x1876
val x2548 = if (x2527) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
val x2533 = x1869(x2496)
val x2534 = x2533 == '\n'
val x2546 = if (x2534) {
x2364 = 0
x2365 = true
x2366 = x2362
()
} else {
x2364 = 0
x2365 = true
x2366 = x2362
()
}
x2546
}
x2548
} else {
val x2496 = x2480 + 1
val x2550 = x2496 + x2478
x1874 = x2550
x2364 = x2478
x2365 = false
x2366 = x2496
()
}
x2556
} else {
x2364 = 0
x2365 = true
x2366 = x2362
()
}
x2562
}
x2564
}
x2566
} else {
x2364 = 0
x2365 = true
x2366 = x2362
()
}
x2572
}
x2574
} else {
x2364 = 0
x2365 = true
x2366 = x2362
()
}
x2580
}
val x2583 = x2364
val x2584 = x2365
val x2585 = x2366
val x2586 = new ParseResultInt(x2583,x2584,x2585)
x2586: ParseResultInt
}
val x2635 = {x2636: (Int) =>
var x2638: Int = 0
var x2639: Boolean = true
var x2640: Int = x2636
val x2642 = x2636 >= x1876
val x2856 = if (x2642) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
val x2648 = x1869(x2636)
val x2649 = x2648 == '\n'
val x2854 = if (x2649) {
val x2650 = x2636 + 1
val x2652 = x2650 >= x1876
val x2848 = if (x2652) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
val x2659 = x1869(x2650)
val x2660 = x2659 >= '0'
val x2661 = x2659 <= '9'
val x2662 = x2660 && x2661
val x2663 = x2659 >= 'A'
val x2664 = x2659 <= 'F'
val x2665 = x2663 && x2664
val x2666 = x2662 || x2665
val x2667 = x2659 >= 'a'
val x2668 = x2659 <= 'f'
val x2669 = x2667 && x2668
val x2670 = x2666 || x2669
val x2846 = if (x2670) {
val x2682 = if (x2662) {
val x2673 = x2659 - '0'
val x2674 = x2673.toInt
x2674
} else {
val x2681 = if (x2665) {
val x2675 = x2659 - 'A'
val x2676 = x2675.toInt
val x2677 = x2676 + 10
x2677
} else {
val x2678 = x2659 - 'a'
val x2679 = x2678.toInt
val x2680 = x2679 + 10
x2680
}
x2681
}
var x2684: Int = x2682
var x2685: Boolean = false
val x2671 = x2650 + 1
var x2686: Int = x2671
var x2688: Int = -1
var x2689: Boolean = true
var x2690: Int = x2671
val x2747 = while ({val x2691 = x2689
val x2692 = x2688
val x2693 = x2690
val x2694 = x2692 != x2693
val x2695 = x2691 && x2694
x2695}) {
val x2697 = x2690
x2688 = x2697
val x2699 = x2697 >= x1876
val x2745 = if (x2699) {
x2689 = false
()
} else {
val x2704 = x1869(x2697)
val x2705 = x2704 >= '0'
val x2706 = x2704 <= '9'
val x2707 = x2705 && x2706
val x2708 = x2704 >= 'A'
val x2709 = x2704 <= 'F'
val x2710 = x2708 && x2709
val x2711 = x2707 || x2710
val x2712 = x2704 >= 'a'
val x2713 = x2704 <= 'f'
val x2714 = x2712 && x2713
val x2715 = x2711 || x2714
val x2743 = if (x2715) {
val x2729 = x2684
val x2730 = x2685
val x2731 = x2686
val x2727 = if (x2707) {
val x2718 = x2704 - '0'
val x2719 = x2718.toInt
x2719
} else {
val x2726 = if (x2710) {
val x2720 = x2704 - 'A'
val x2721 = x2720.toInt
val x2722 = x2721 + 10
x2722
} else {
val x2723 = x2704 - 'a'
val x2724 = x2723.toInt
val x2725 = x2724 + 10
x2725
}
x2726
}
val x2733 = x2729 * 16
val x2734 = x2733 + x2727
x2684 = x2734
x2685 = false
val x2716 = x2697 + 1
x2686 = x2716
x2690 = x2716
()
} else {
x2689 = false
()
}
x2743
}
x2745
}
val x2748 = x2684
val x2749 = x2685
val x2750 = x2686
val x2753 = if (x2749) {
true
} else {
x2749
}
val x2840 = if (x2753) {
val x2794 = if (x2753) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
val x2752 = if (x2749) {
0
} else {
x2748
}
val x2760 = x2752 == 0
val x2792 = if (x2760) {
val x2754 = if (x2749) {
x2650
} else {
x2750
}
val x2761 = x2754 >= x1876
val x2783 = if (x2761) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
val x2768 = x1869(x2754)
val x2769 = x2768 == '\n'
val x2781 = if (x2769) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
x2638 = 0
x2639 = true
x2640 = x2636
()
}
x2781
}
x2783
} else {
val x2754 = if (x2749) {
x2650
} else {
x2750
}
val x2786 = x2754 + x2752
x1874 = x2786
x2638 = x2752
x2639 = false
x2640 = x2754
()
}
x2792
}
x2794
} else {
val x2754 = if (x2749) {
x2650
} else {
x2750
}
val x2761 = x2754 >= x1876
val x2838 = if (x2761) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
val x2768 = x1869(x2754)
val x2769 = x2768 == '\n'
val x2836 = if (x2769) {
val x2752 = if (x2749) {
0
} else {
x2748
}
val x2760 = x2752 == 0
val x2830 = if (x2760) {
val x2770 = x2754 + 1
val x2801 = x2770 >= x1876
val x2822 = if (x2801) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
val x2807 = x1869(x2770)
val x2808 = x2807 == '\n'
val x2820 = if (x2808) {
x2638 = 0
x2639 = true
x2640 = x2636
()
} else {
x2638 = 0
x2639 = true
x2640 = x2636
()
}
x2820
}
x2822
} else {
val x2770 = x2754 + 1
val x2824 = x2770 + x2752
x1874 = x2824
x2638 = x2752
x2639 = false
x2640 = x2770
()
}
x2830
} else {
x2638 = 0
x2639 = true
x2640 = x2636
()
}
x2836
}
x2838
}
x2840
} else {
x2638 = 0
x2639 = true
x2640 = x2636
()
}
x2846
}
x2848
} else {
x2638 = 0
x2639 = true
x2640 = x2636
()
}
x2854
}
val x2857 = x2638
val x2858 = x2639
val x2859 = x2640
val x2860 = new ParseResultInt(x2857,x2858,x2859)
x2860: ParseResultInt
}
val x2980 = {x2981: (Int) =>
var x2983: Int = 0
var x2984: Boolean = true
var x2985: Int = x2981
val x2987 = x2981 >= x1876
val x3201 = if (x2987) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
val x2993 = x1869(x2981)
val x2994 = x2993 == '\n'
val x3199 = if (x2994) {
val x2995 = x2981 + 1
val x2997 = x2995 >= x1876
val x3193 = if (x2997) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
val x3004 = x1869(x2995)
val x3005 = x3004 >= '0'
val x3006 = x3004 <= '9'
val x3007 = x3005 && x3006
val x3008 = x3004 >= 'A'
val x3009 = x3004 <= 'F'
val x3010 = x3008 && x3009
val x3011 = x3007 || x3010
val x3012 = x3004 >= 'a'
val x3013 = x3004 <= 'f'
val x3014 = x3012 && x3013
val x3015 = x3011 || x3014
val x3191 = if (x3015) {
val x3027 = if (x3007) {
val x3018 = x3004 - '0'
val x3019 = x3018.toInt
x3019
} else {
val x3026 = if (x3010) {
val x3020 = x3004 - 'A'
val x3021 = x3020.toInt
val x3022 = x3021 + 10
x3022
} else {
val x3023 = x3004 - 'a'
val x3024 = x3023.toInt
val x3025 = x3024 + 10
x3025
}
x3026
}
var x3029: Int = x3027
var x3030: Boolean = false
val x3016 = x2995 + 1
var x3031: Int = x3016
var x3033: Int = -1
var x3034: Boolean = true
var x3035: Int = x3016
val x3092 = while ({val x3036 = x3034
val x3037 = x3033
val x3038 = x3035
val x3039 = x3037 != x3038
val x3040 = x3036 && x3039
x3040}) {
val x3042 = x3035
x3033 = x3042
val x3044 = x3042 >= x1876
val x3090 = if (x3044) {
x3034 = false
()
} else {
val x3049 = x1869(x3042)
val x3050 = x3049 >= '0'
val x3051 = x3049 <= '9'
val x3052 = x3050 && x3051
val x3053 = x3049 >= 'A'
val x3054 = x3049 <= 'F'
val x3055 = x3053 && x3054
val x3056 = x3052 || x3055
val x3057 = x3049 >= 'a'
val x3058 = x3049 <= 'f'
val x3059 = x3057 && x3058
val x3060 = x3056 || x3059
val x3088 = if (x3060) {
val x3074 = x3029
val x3075 = x3030
val x3076 = x3031
val x3072 = if (x3052) {
val x3063 = x3049 - '0'
val x3064 = x3063.toInt
x3064
} else {
val x3071 = if (x3055) {
val x3065 = x3049 - 'A'
val x3066 = x3065.toInt
val x3067 = x3066 + 10
x3067
} else {
val x3068 = x3049 - 'a'
val x3069 = x3068.toInt
val x3070 = x3069 + 10
x3070
}
x3071
}
val x3078 = x3074 * 16
val x3079 = x3078 + x3072
x3029 = x3079
x3030 = false
val x3061 = x3042 + 1
x3031 = x3061
x3035 = x3061
()
} else {
x3034 = false
()
}
x3088
}
x3090
}
val x3093 = x3029
val x3094 = x3030
val x3095 = x3031
val x3098 = if (x3094) {
true
} else {
x3094
}
val x3185 = if (x3098) {
val x3139 = if (x3098) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
val x3097 = if (x3094) {
0
} else {
x3093
}
val x3105 = x3097 == 0
val x3137 = if (x3105) {
val x3099 = if (x3094) {
x2995
} else {
x3095
}
val x3106 = x3099 >= x1876
val x3128 = if (x3106) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
val x3113 = x1869(x3099)
val x3114 = x3113 == '\n'
val x3126 = if (x3114) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
x2983 = 0
x2984 = true
x2985 = x2981
()
}
x3126
}
x3128
} else {
val x3099 = if (x3094) {
x2995
} else {
x3095
}
val x3131 = x3099 + x3097
x1874 = x3131
x2983 = x3097
x2984 = false
x2985 = x3099
()
}
x3137
}
x3139
} else {
val x3099 = if (x3094) {
x2995
} else {
x3095
}
val x3106 = x3099 >= x1876
val x3183 = if (x3106) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
val x3113 = x1869(x3099)
val x3114 = x3113 == '\n'
val x3181 = if (x3114) {
val x3097 = if (x3094) {
0
} else {
x3093
}
val x3105 = x3097 == 0
val x3175 = if (x3105) {
val x3115 = x3099 + 1
val x3146 = x3115 >= x1876
val x3167 = if (x3146) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
val x3152 = x1869(x3115)
val x3153 = x3152 == '\n'
val x3165 = if (x3153) {
x2983 = 0
x2984 = true
x2985 = x2981
()
} else {
x2983 = 0
x2984 = true
x2985 = x2981
()
}
x3165
}
x3167
} else {
val x3115 = x3099 + 1
val x3169 = x3115 + x3097
x1874 = x3169
x2983 = x3097
x2984 = false
x2985 = x3115
()
}
x3175
} else {
x2983 = 0
x2984 = true
x2985 = x2981
()
}
x3181
}
x3183
}
x3185
} else {
x2983 = 0
x2984 = true
x2985 = x2981
()
}
x3191
}
x3193
} else {
x2983 = 0
x2984 = true
x2985 = x2981
()
}
x3199
}
val x3202 = x2983
val x3203 = x2984
val x3204 = x2985
val x3205 = new ParseResultInt(x3202,x3203,x3204)
x3205: ParseResultInt
}
val x3356 = {x3357: (Int) =>
var x3359: Int = 0
var x3360: Boolean = true
var x3361: Int = x3357
val x3363 = x3357 >= x1876
val x3577 = if (x3363) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
val x3369 = x1869(x3357)
val x3370 = x3369 == '\n'
val x3575 = if (x3370) {
val x3371 = x3357 + 1
val x3373 = x3371 >= x1876
val x3569 = if (x3373) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
val x3380 = x1869(x3371)
val x3381 = x3380 >= '0'
val x3382 = x3380 <= '9'
val x3383 = x3381 && x3382
val x3384 = x3380 >= 'A'
val x3385 = x3380 <= 'F'
val x3386 = x3384 && x3385
val x3387 = x3383 || x3386
val x3388 = x3380 >= 'a'
val x3389 = x3380 <= 'f'
val x3390 = x3388 && x3389
val x3391 = x3387 || x3390
val x3567 = if (x3391) {
val x3403 = if (x3383) {
val x3394 = x3380 - '0'
val x3395 = x3394.toInt
x3395
} else {
val x3402 = if (x3386) {
val x3396 = x3380 - 'A'
val x3397 = x3396.toInt
val x3398 = x3397 + 10
x3398
} else {
val x3399 = x3380 - 'a'
val x3400 = x3399.toInt
val x3401 = x3400 + 10
x3401
}
x3402
}
var x3405: Int = x3403
var x3406: Boolean = false
val x3392 = x3371 + 1
var x3407: Int = x3392
var x3409: Int = -1
var x3410: Boolean = true
var x3411: Int = x3392
val x3468 = while ({val x3412 = x3410
val x3413 = x3409
val x3414 = x3411
val x3415 = x3413 != x3414
val x3416 = x3412 && x3415
x3416}) {
val x3418 = x3411
x3409 = x3418
val x3420 = x3418 >= x1876
val x3466 = if (x3420) {
x3410 = false
()
} else {
val x3425 = x1869(x3418)
val x3426 = x3425 >= '0'
val x3427 = x3425 <= '9'
val x3428 = x3426 && x3427
val x3429 = x3425 >= 'A'
val x3430 = x3425 <= 'F'
val x3431 = x3429 && x3430
val x3432 = x3428 || x3431
val x3433 = x3425 >= 'a'
val x3434 = x3425 <= 'f'
val x3435 = x3433 && x3434
val x3436 = x3432 || x3435
val x3464 = if (x3436) {
val x3450 = x3405
val x3451 = x3406
val x3452 = x3407
val x3448 = if (x3428) {
val x3439 = x3425 - '0'
val x3440 = x3439.toInt
x3440
} else {
val x3447 = if (x3431) {
val x3441 = x3425 - 'A'
val x3442 = x3441.toInt
val x3443 = x3442 + 10
x3443
} else {
val x3444 = x3425 - 'a'
val x3445 = x3444.toInt
val x3446 = x3445 + 10
x3446
}
x3447
}
val x3454 = x3450 * 16
val x3455 = x3454 + x3448
x3405 = x3455
x3406 = false
val x3437 = x3418 + 1
x3407 = x3437
x3411 = x3437
()
} else {
x3410 = false
()
}
x3464
}
x3466
}
val x3469 = x3405
val x3470 = x3406
val x3471 = x3407
val x3474 = if (x3470) {
true
} else {
x3470
}
val x3561 = if (x3474) {
val x3515 = if (x3474) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
val x3473 = if (x3470) {
0
} else {
x3469
}
val x3481 = x3473 == 0
val x3513 = if (x3481) {
val x3475 = if (x3470) {
x3371
} else {
x3471
}
val x3482 = x3475 >= x1876
val x3504 = if (x3482) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
val x3489 = x1869(x3475)
val x3490 = x3489 == '\n'
val x3502 = if (x3490) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
x3359 = 0
x3360 = true
x3361 = x3357
()
}
x3502
}
x3504
} else {
val x3475 = if (x3470) {
x3371
} else {
x3471
}
val x3507 = x3475 + x3473
x1874 = x3507
x3359 = x3473
x3360 = false
x3361 = x3475
()
}
x3513
}
x3515
} else {
val x3475 = if (x3470) {
x3371
} else {
x3471
}
val x3482 = x3475 >= x1876
val x3559 = if (x3482) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
val x3489 = x1869(x3475)
val x3490 = x3489 == '\n'
val x3557 = if (x3490) {
val x3473 = if (x3470) {
0
} else {
x3469
}
val x3481 = x3473 == 0
val x3551 = if (x3481) {
val x3491 = x3475 + 1
val x3522 = x3491 >= x1876
val x3543 = if (x3522) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
val x3528 = x1869(x3491)
val x3529 = x3528 == '\n'
val x3541 = if (x3529) {
x3359 = 0
x3360 = true
x3361 = x3357
()
} else {
x3359 = 0
x3360 = true
x3361 = x3357
()
}
x3541
}
x3543
} else {
val x3491 = x3475 + 1
val x3545 = x3491 + x3473
x1874 = x3545
x3359 = x3473
x3360 = false
x3361 = x3491
()
}
x3551
} else {
x3359 = 0
x3360 = true
x3361 = x3357
()
}
x3557
}
x3559
}
x3561
} else {
x3359 = 0
x3360 = true
x3361 = x3357
()
}
x3567
}
x3569
} else {
x3359 = 0
x3360 = true
x3361 = x3357
()
}
x3575
}
val x3578 = x3359
val x3579 = x3360
val x3580 = x3361
val x3581 = new ParseResultInt(x3578,x3579,x3580)
x3581: ParseResultInt
}
val x3701 = {x3702: (Int) =>
var x3704: Int = 0
var x3705: Boolean = true
var x3706: Int = x3702
val x3708 = x3702 >= x1876
val x3922 = if (x3708) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
val x3714 = x1869(x3702)
val x3715 = x3714 == '\n'
val x3920 = if (x3715) {
val x3716 = x3702 + 1
val x3718 = x3716 >= x1876
val x3914 = if (x3718) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
val x3725 = x1869(x3716)
val x3726 = x3725 >= '0'
val x3727 = x3725 <= '9'
val x3728 = x3726 && x3727
val x3729 = x3725 >= 'A'
val x3730 = x3725 <= 'F'
val x3731 = x3729 && x3730
val x3732 = x3728 || x3731
val x3733 = x3725 >= 'a'
val x3734 = x3725 <= 'f'
val x3735 = x3733 && x3734
val x3736 = x3732 || x3735
val x3912 = if (x3736) {
val x3748 = if (x3728) {
val x3739 = x3725 - '0'
val x3740 = x3739.toInt
x3740
} else {
val x3747 = if (x3731) {
val x3741 = x3725 - 'A'
val x3742 = x3741.toInt
val x3743 = x3742 + 10
x3743
} else {
val x3744 = x3725 - 'a'
val x3745 = x3744.toInt
val x3746 = x3745 + 10
x3746
}
x3747
}
var x3750: Int = x3748
var x3751: Boolean = false
val x3737 = x3716 + 1
var x3752: Int = x3737
var x3754: Int = -1
var x3755: Boolean = true
var x3756: Int = x3737
val x3813 = while ({val x3757 = x3755
val x3758 = x3754
val x3759 = x3756
val x3760 = x3758 != x3759
val x3761 = x3757 && x3760
x3761}) {
val x3763 = x3756
x3754 = x3763
val x3765 = x3763 >= x1876
val x3811 = if (x3765) {
x3755 = false
()
} else {
val x3770 = x1869(x3763)
val x3771 = x3770 >= '0'
val x3772 = x3770 <= '9'
val x3773 = x3771 && x3772
val x3774 = x3770 >= 'A'
val x3775 = x3770 <= 'F'
val x3776 = x3774 && x3775
val x3777 = x3773 || x3776
val x3778 = x3770 >= 'a'
val x3779 = x3770 <= 'f'
val x3780 = x3778 && x3779
val x3781 = x3777 || x3780
val x3809 = if (x3781) {
val x3795 = x3750
val x3796 = x3751
val x3797 = x3752
val x3793 = if (x3773) {
val x3784 = x3770 - '0'
val x3785 = x3784.toInt
x3785
} else {
val x3792 = if (x3776) {
val x3786 = x3770 - 'A'
val x3787 = x3786.toInt
val x3788 = x3787 + 10
x3788
} else {
val x3789 = x3770 - 'a'
val x3790 = x3789.toInt
val x3791 = x3790 + 10
x3791
}
x3792
}
val x3799 = x3795 * 16
val x3800 = x3799 + x3793
x3750 = x3800
x3751 = false
val x3782 = x3763 + 1
x3752 = x3782
x3756 = x3782
()
} else {
x3755 = false
()
}
x3809
}
x3811
}
val x3814 = x3750
val x3815 = x3751
val x3816 = x3752
val x3819 = if (x3815) {
true
} else {
x3815
}
val x3906 = if (x3819) {
val x3860 = if (x3819) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
val x3818 = if (x3815) {
0
} else {
x3814
}
val x3826 = x3818 == 0
val x3858 = if (x3826) {
val x3820 = if (x3815) {
x3716
} else {
x3816
}
val x3827 = x3820 >= x1876
val x3849 = if (x3827) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
val x3834 = x1869(x3820)
val x3835 = x3834 == '\n'
val x3847 = if (x3835) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
x3704 = 0
x3705 = true
x3706 = x3702
()
}
x3847
}
x3849
} else {
val x3820 = if (x3815) {
x3716
} else {
x3816
}
val x3852 = x3820 + x3818
x1874 = x3852
x3704 = x3818
x3705 = false
x3706 = x3820
()
}
x3858
}
x3860
} else {
val x3820 = if (x3815) {
x3716
} else {
x3816
}
val x3827 = x3820 >= x1876
val x3904 = if (x3827) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
val x3834 = x1869(x3820)
val x3835 = x3834 == '\n'
val x3902 = if (x3835) {
val x3818 = if (x3815) {
0
} else {
x3814
}
val x3826 = x3818 == 0
val x3896 = if (x3826) {
val x3836 = x3820 + 1
val x3867 = x3836 >= x1876
val x3888 = if (x3867) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
val x3873 = x1869(x3836)
val x3874 = x3873 == '\n'
val x3886 = if (x3874) {
x3704 = 0
x3705 = true
x3706 = x3702
()
} else {
x3704 = 0
x3705 = true
x3706 = x3702
()
}
x3886
}
x3888
} else {
val x3836 = x3820 + 1
val x3890 = x3836 + x3818
x1874 = x3890
x3704 = x3818
x3705 = false
x3706 = x3836
()
}
x3896
} else {
x3704 = 0
x3705 = true
x3706 = x3702
()
}
x3902
}
x3904
}
x3906
} else {
x3704 = 0
x3705 = true
x3706 = x3702
()
}
x3912
}
x3914
} else {
x3704 = 0
x3705 = true
x3706 = x3702
()
}
x3920
}
val x3923 = x3704
val x3924 = x3705
val x3925 = x3706
val x3926 = new ParseResultInt(x3923,x3924,x3925)
x3926: ParseResultInt
}
val x4039 = while ({val x2351 = x2349
val x2352 = x2348
val x2353 = x2350
val x2354 = x2352 != x2353
val x2355 = x2351 && x2354
x2355}) {
val x2357 = x2350
x2348 = x2357
val x2359 = x1874
val x2360 = x2357 >= x2359
val x4037 = if (x2360) {
val x2588 = x2361(x2357)
val x2589 = x2588.empty
val x3316 = if (x2589) {
x2349 = false
()
} else {
val x2595 = x2588.next
val x2596 = x2595 >= x1876
val x3314 = if (x2596) {
x2349 = false
()
} else {
val x2600 = x1869(x2595)
val x2601 = x2600 == ' '
val x2602 = x2600 == ''
val x2603 = x2601 || x2602
val x2604 = x2600 == '\n'
val x2605 = x2603 || x2604
val x2606 = x2600 == '
'
val x2607 = x2605 || x2606
val x2608 = x2600 == '\t'
val x2609 = x2607 || x2608
val x2610 = x2600 == ''
val x2611 = x2609 || x2610
val x3312 = if (x2611) {
x2349 = false
()
} else {
var x2618: Unit = ()
var x2619: Boolean = false
val x2615 = x2595 + 1
var x2620: Int = x2615
var x2622: Int = -1
var x2623: Boolean = true
var x2624: Int = x2615
val x2942 = while ({val x2625 = x2623
val x2626 = x2622
val x2627 = x2624
val x2628 = x2626 != x2627
val x2629 = x2625 && x2628
x2629}) {
val x2631 = x2624
x2622 = x2631
val x2633 = x1874
val x2634 = x2631 >= x2633
val x2940 = if (x2634) {
val x2862 = x2635(x2631)
val x2863 = x2862.empty
val x2904 = if (x2863) {
x2623 = false
()
} else {
val x2868 = x2862.next
val x2869 = x2868 >= x1876
val x2902 = if (x2869) {
x2623 = false
()
} else {
val x2873 = x1869(x2868)
val x2874 = x2873 == ' '
val x2875 = x2873 == ''
val x2876 = x2874 || x2875
val x2877 = x2873 == '\n'
val x2878 = x2876 || x2877
val x2879 = x2873 == '
'
val x2880 = x2878 || x2879
val x2881 = x2873 == '\t'
val x2882 = x2880 || x2881
val x2883 = x2873 == ''
val x2884 = x2882 || x2883
val x2900 = if (x2884) {
x2623 = false
()
} else {
val x2890 = x2618
val x2891 = x2619
val x2892 = x2620
x2618 = ()
x2619 = false
val x2888 = x2868 + 1
x2620 = x2888
x2624 = x2888
()
}
x2900
}
x2902
}
x2904
} else {
val x2906 = x2631 >= x1876
val x2938 = if (x2906) {
x2623 = false
()
} else {
val x2909 = x1869(x2631)
val x2910 = x2909 == ' '
val x2911 = x2909 == ''
val x2912 = x2910 || x2911
val x2913 = x2909 == '\n'
val x2914 = x2912 || x2913
val x2915 = x2909 == '
'
val x2916 = x2914 || x2915
val x2917 = x2909 == '\t'
val x2918 = x2916 || x2917
val x2919 = x2909 == ''
val x2920 = x2918 || x2919
val x2936 = if (x2920) {
x2623 = false
()
} else {
val x2926 = x2618
val x2927 = x2619
val x2928 = x2620
x2618 = ()
x2619 = false
val x2924 = x2631 + 1
x2620 = x2924
x2624 = x2924
()
}
x2936
}
x2938
}
x2940
}
val x2943 = x2618
val x2944 = x2619
val x2945 = x2620
val x3310 = if (x2944) {
val x2960 = if (x2944) {
x2349 = false
()
} else {
val x2949 = x2344
val x2950 = x2345
val x2951 = x2346
val x2953 = x2949 + 1
x2344 = x2953
x2345 = false
x2346 = x2945
x2350 = x2945
()
}
x2960
} else {
var x2963: Unit = ()
var x2964: Boolean = false
var x2965: Int = x2945
var x2967: Int = -1
var x2968: Boolean = true
var x2969: Int = x2945
val x3285 = while ({val x2970 = x2968
val x2971 = x2967
val x2972 = x2969
val x2973 = x2971 != x2972
val x2974 = x2970 && x2973
x2974}) {
val x2976 = x2969
x2967 = x2976
val x2978 = x1874
val x2979 = x2976 >= x2978
val x3283 = if (x2979) {
val x3207 = x2980(x2976)
val x3208 = x3207.empty
val x3248 = if (x3208) {
x2968 = false
()
} else {
val x3213 = x3207.next
val x3214 = x3213 >= x1876
val x3246 = if (x3214) {
x2968 = false
()
} else {
val x3218 = x1869(x3213)
val x3219 = x3218 == ' '
val x3220 = x3218 == ''
val x3221 = x3219 || x3220
val x3222 = x3218 == '\n'
val x3223 = x3221 || x3222
val x3224 = x3218 == '
'
val x3225 = x3223 || x3224
val x3226 = x3218 == '\t'
val x3227 = x3225 || x3226
val x3228 = x3218 == ''
val x3229 = x3227 || x3228
val x3244 = if (x3229) {
val x3232 = x2963
val x3233 = x2964
val x3234 = x2965
x2963 = ()
x2964 = false
val x3230 = x3213 + 1
x2965 = x3230
x2969 = x3230
()
} else {
x2968 = false
()
}
x3244
}
x3246
}
x3248
} else {
val x3250 = x2976 >= x1876
val x3281 = if (x3250) {
x2968 = false
()
} else {
val x3253 = x1869(x2976)
val x3254 = x3253 == ' '
val x3255 = x3253 == ''
val x3256 = x3254 || x3255
val x3257 = x3253 == '\n'
val x3258 = x3256 || x3257
val x3259 = x3253 == '
'
val x3260 = x3258 || x3259
val x3261 = x3253 == '\t'
val x3262 = x3260 || x3261
val x3263 = x3253 == ''
val x3264 = x3262 || x3263
val x3279 = if (x3264) {
val x3267 = x2963
val x3268 = x2964
val x3269 = x2965
x2963 = ()
x2964 = false
val x3265 = x2976 + 1
x2965 = x3265
x2969 = x3265
()
} else {
x2968 = false
()
}
x3279
}
x3281
}
x3283
}
val x3286 = x2963
val x3287 = x2964
val x3288 = x2965
val x3292 = if (x3287) {
true
} else {
false
}
val x3308 = if (x3292) {
x2349 = false
()
} else {
val x3297 = x2344
val x3298 = x2345
val x3299 = x2346
val x3301 = x3297 + 1
x2344 = x3301
x2345 = false
val x3293 = if (x3287) {
x2357
} else {
x3288
}
x2346 = x3293
x2350 = x3293
()
}
x3308
}
x3310
}
x3312
}
x3314
}
x3316
} else {
val x3318 = x2357 >= x1876
val x4035 = if (x3318) {
x2349 = false
()
} else {
val x3321 = x1869(x2357)
val x3322 = x3321 == ' '
val x3323 = x3321 == ''
val x3324 = x3322 || x3323
val x3325 = x3321 == '\n'
val x3326 = x3324 || x3325
val x3327 = x3321 == '
'
val x3328 = x3326 || x3327
val x3329 = x3321 == '\t'
val x3330 = x3328 || x3329
val x3331 = x3321 == ''
val x3332 = x3330 || x3331
val x4033 = if (x3332) {
x2349 = false
()
} else {
var x3339: Unit = ()
var x3340: Boolean = false
val x3336 = x2357 + 1
var x3341: Int = x3336
var x3343: Int = -1
var x3344: Boolean = true
var x3345: Int = x3336
val x3663 = while ({val x3346 = x3344
val x3347 = x3343
val x3348 = x3345
val x3349 = x3347 != x3348
val x3350 = x3346 && x3349
x3350}) {
val x3352 = x3345
x3343 = x3352
val x3354 = x1874
val x3355 = x3352 >= x3354
val x3661 = if (x3355) {
val x3583 = x3356(x3352)
val x3584 = x3583.empty
val x3625 = if (x3584) {
x3344 = false
()
} else {
val x3589 = x3583.next
val x3590 = x3589 >= x1876
val x3623 = if (x3590) {
x3344 = false
()
} else {
val x3594 = x1869(x3589)
val x3595 = x3594 == ' '
val x3596 = x3594 == ''
val x3597 = x3595 || x3596
val x3598 = x3594 == '\n'
val x3599 = x3597 || x3598
val x3600 = x3594 == '
'
val x3601 = x3599 || x3600
val x3602 = x3594 == '\t'
val x3603 = x3601 || x3602
val x3604 = x3594 == ''
val x3605 = x3603 || x3604
val x3621 = if (x3605) {
x3344 = false
()
} else {
val x3611 = x3339
val x3612 = x3340
val x3613 = x3341
x3339 = ()
x3340 = false
val x3609 = x3589 + 1
x3341 = x3609
x3345 = x3609
()
}
x3621
}
x3623
}
x3625
} else {
val x3627 = x3352 >= x1876
val x3659 = if (x3627) {
x3344 = false
()
} else {
val x3630 = x1869(x3352)
val x3631 = x3630 == ' '
val x3632 = x3630 == ''
val x3633 = x3631 || x3632
val x3634 = x3630 == '\n'
val x3635 = x3633 || x3634
val x3636 = x3630 == '
'
val x3637 = x3635 || x3636
val x3638 = x3630 == '\t'
val x3639 = x3637 || x3638
val x3640 = x3630 == ''
val x3641 = x3639 || x3640
val x3657 = if (x3641) {
x3344 = false
()
} else {
val x3647 = x3339
val x3648 = x3340
val x3649 = x3341
x3339 = ()
x3340 = false
val x3645 = x3352 + 1
x3341 = x3645
x3345 = x3645
()
}
x3657
}
x3659
}
x3661
}
val x3664 = x3339
val x3665 = x3340
val x3666 = x3341
val x4031 = if (x3665) {
val x3681 = if (x3665) {
x2349 = false
()
} else {
val x3670 = x2344
val x3671 = x2345
val x3672 = x2346
val x3674 = x3670 + 1
x2344 = x3674
x2345 = false
x2346 = x3666
x2350 = x3666
()
}
x3681
} else {
var x3684: Unit = ()
var x3685: Boolean = false
var x3686: Int = x3666
var x3688: Int = -1
var x3689: Boolean = true
var x3690: Int = x3666
val x4006 = while ({val x3691 = x3689
val x3692 = x3688
val x3693 = x3690
val x3694 = x3692 != x3693
val x3695 = x3691 && x3694
x3695}) {
val x3697 = x3690
x3688 = x3697
val x3699 = x1874
val x3700 = x3697 >= x3699
val x4004 = if (x3700) {
val x3928 = x3701(x3697)
val x3929 = x3928.empty
val x3969 = if (x3929) {
x3689 = false
()
} else {
val x3934 = x3928.next
val x3935 = x3934 >= x1876
val x3967 = if (x3935) {
x3689 = false
()
} else {
val x3939 = x1869(x3934)
val x3940 = x3939 == ' '
val x3941 = x3939 == ''
val x3942 = x3940 || x3941
val x3943 = x3939 == '\n'
val x3944 = x3942 || x3943
val x3945 = x3939 == '
'
val x3946 = x3944 || x3945
val x3947 = x3939 == '\t'
val x3948 = x3946 || x3947
val x3949 = x3939 == ''
val x3950 = x3948 || x3949
val x3965 = if (x3950) {
val x3953 = x3684
val x3954 = x3685
val x3955 = x3686
x3684 = ()
x3685 = false
val x3951 = x3934 + 1
x3686 = x3951
x3690 = x3951
()
} else {
x3689 = false
()
}
x3965
}
x3967
}
x3969
} else {
val x3971 = x3697 >= x1876
val x4002 = if (x3971) {
x3689 = false
()
} else {
val x3974 = x1869(x3697)
val x3975 = x3974 == ' '
val x3976 = x3974 == ''
val x3977 = x3975 || x3976
val x3978 = x3974 == '\n'
val x3979 = x3977 || x3978
val x3980 = x3974 == '
'
val x3981 = x3979 || x3980
val x3982 = x3974 == '\t'
val x3983 = x3981 || x3982
val x3984 = x3974 == ''
val x3985 = x3983 || x3984
val x4000 = if (x3985) {
val x3988 = x3684
val x3989 = x3685
val x3990 = x3686
x3684 = ()
x3685 = false
val x3986 = x3697 + 1
x3686 = x3986
x3690 = x3986
()
} else {
x3689 = false
()
}
x4000
}
x4002
}
x4004
}
val x4007 = x3684
val x4008 = x3685
val x4009 = x3686
val x4013 = if (x4008) {
true
} else {
false
}
val x4029 = if (x4013) {
x2349 = false
()
} else {
val x4018 = x2344
val x4019 = x2345
val x4020 = x2346
val x4022 = x4018 + 1
x2344 = x4022
x2345 = false
val x4014 = if (x4008) {
x2357
} else {
x4009
}
x2346 = x4014
x2350 = x4014
()
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
}
val x4040 = x2344
val x4041 = x2345
val x4042 = x2346
x1870 = x4040
x1871 = x4041
x1872 = x4042
()
}
x4048
}
x4050
}
x4052
} else {
val x1976 = if (x1971) {
0
} else {
x1972
}
val x1983 = x1976 >= x1876
val x6132 = if (x1983) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
val x1990 = x1869(x1976)
val x1991 = x1990 == '\n'
val x6130 = if (x1991) {
val x1974 = if (x1971) {
0
} else {
x1970
}
val x1982 = x1974 == 0
val x6124 = if (x1982) {
val x1992 = x1976 + 1
val x4059 = x1992 >= x1876
val x4080 = if (x4059) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
val x4065 = x1869(x1992)
val x4066 = x4065 == '\n'
val x4078 = if (x4066) {
x1870 = 0
x1871 = true
x1872 = 0
()
} else {
x1870 = 0
x1871 = true
x1872 = 0
()
}
x4078
}
x4080
} else {
val x1992 = x1976 + 1
val x4082 = x1992 + x1974
x1874 = x4082
var x4085: Unit = ()
var x4086: Boolean = false
var x4087: Int = x1992
var x4089: Int = -1
var x4090: Boolean = true
var x4091: Int = x1992
val x4102 = {x4103: (Int) =>
var x4105: Int = 0
var x4106: Boolean = true
var x4107: Int = x4103
val x4109 = x4103 >= x1876
val x4323 = if (x4109) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
val x4115 = x1869(x4103)
val x4116 = x4115 == '\n'
val x4321 = if (x4116) {
val x4117 = x4103 + 1
val x4119 = x4117 >= x1876
val x4315 = if (x4119) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
val x4126 = x1869(x4117)
val x4127 = x4126 >= '0'
val x4128 = x4126 <= '9'
val x4129 = x4127 && x4128
val x4130 = x4126 >= 'A'
val x4131 = x4126 <= 'F'
val x4132 = x4130 && x4131
val x4133 = x4129 || x4132
val x4134 = x4126 >= 'a'
val x4135 = x4126 <= 'f'
val x4136 = x4134 && x4135
val x4137 = x4133 || x4136
val x4313 = if (x4137) {
val x4149 = if (x4129) {
val x4140 = x4126 - '0'
val x4141 = x4140.toInt
x4141
} else {
val x4148 = if (x4132) {
val x4142 = x4126 - 'A'
val x4143 = x4142.toInt
val x4144 = x4143 + 10
x4144
} else {
val x4145 = x4126 - 'a'
val x4146 = x4145.toInt
val x4147 = x4146 + 10
x4147
}
x4148
}
var x4151: Int = x4149
var x4152: Boolean = false
val x4138 = x4117 + 1
var x4153: Int = x4138
var x4155: Int = -1
var x4156: Boolean = true
var x4157: Int = x4138
val x4214 = while ({val x4158 = x4156
val x4159 = x4155
val x4160 = x4157
val x4161 = x4159 != x4160
val x4162 = x4158 && x4161
x4162}) {
val x4164 = x4157
x4155 = x4164
val x4166 = x4164 >= x1876
val x4212 = if (x4166) {
x4156 = false
()
} else {
val x4171 = x1869(x4164)
val x4172 = x4171 >= '0'
val x4173 = x4171 <= '9'
val x4174 = x4172 && x4173
val x4175 = x4171 >= 'A'
val x4176 = x4171 <= 'F'
val x4177 = x4175 && x4176
val x4178 = x4174 || x4177
val x4179 = x4171 >= 'a'
val x4180 = x4171 <= 'f'
val x4181 = x4179 && x4180
val x4182 = x4178 || x4181
val x4210 = if (x4182) {
val x4196 = x4151
val x4197 = x4152
val x4198 = x4153
val x4194 = if (x4174) {
val x4185 = x4171 - '0'
val x4186 = x4185.toInt
x4186
} else {
val x4193 = if (x4177) {
val x4187 = x4171 - 'A'
val x4188 = x4187.toInt
val x4189 = x4188 + 10
x4189
} else {
val x4190 = x4171 - 'a'
val x4191 = x4190.toInt
val x4192 = x4191 + 10
x4192
}
x4193
}
val x4200 = x4196 * 16
val x4201 = x4200 + x4194
x4151 = x4201
x4152 = false
val x4183 = x4164 + 1
x4153 = x4183
x4157 = x4183
()
} else {
x4156 = false
()
}
x4210
}
x4212
}
val x4215 = x4151
val x4216 = x4152
val x4217 = x4153
val x4220 = if (x4216) {
true
} else {
x4216
}
val x4307 = if (x4220) {
val x4261 = if (x4220) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
val x4219 = if (x4216) {
0
} else {
x4215
}
val x4227 = x4219 == 0
val x4259 = if (x4227) {
val x4221 = if (x4216) {
x4117
} else {
x4217
}
val x4228 = x4221 >= x1876
val x4250 = if (x4228) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
val x4235 = x1869(x4221)
val x4236 = x4235 == '\n'
val x4248 = if (x4236) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
x4105 = 0
x4106 = true
x4107 = x4103
()
}
x4248
}
x4250
} else {
val x4221 = if (x4216) {
x4117
} else {
x4217
}
val x4253 = x4221 + x4219
x1874 = x4253
x4105 = x4219
x4106 = false
x4107 = x4221
()
}
x4259
}
x4261
} else {
val x4221 = if (x4216) {
x4117
} else {
x4217
}
val x4228 = x4221 >= x1876
val x4305 = if (x4228) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
val x4235 = x1869(x4221)
val x4236 = x4235 == '\n'
val x4303 = if (x4236) {
val x4219 = if (x4216) {
0
} else {
x4215
}
val x4227 = x4219 == 0
val x4297 = if (x4227) {
val x4237 = x4221 + 1
val x4268 = x4237 >= x1876
val x4289 = if (x4268) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
val x4274 = x1869(x4237)
val x4275 = x4274 == '\n'
val x4287 = if (x4275) {
x4105 = 0
x4106 = true
x4107 = x4103
()
} else {
x4105 = 0
x4106 = true
x4107 = x4103
()
}
x4287
}
x4289
} else {
val x4237 = x4221 + 1
val x4291 = x4237 + x4219
x1874 = x4291
x4105 = x4219
x4106 = false
x4107 = x4237
()
}
x4297
} else {
x4105 = 0
x4106 = true
x4107 = x4103
()
}
x4303
}
x4305
}
x4307
} else {
x4105 = 0
x4106 = true
x4107 = x4103
()
}
x4313
}
x4315
} else {
x4105 = 0
x4106 = true
x4107 = x4103
()
}
x4321
}
val x4324 = x4105
val x4325 = x4106
val x4326 = x4107
val x4327 = new ParseResultInt(x4324,x4325,x4326)
x4327: ParseResultInt
}
val x4407 = while ({val x4092 = x4090
val x4093 = x4089
val x4094 = x4091
val x4095 = x4093 != x4094
val x4096 = x4092 && x4095
x4096}) {
val x4098 = x4091
x4089 = x4098
val x4100 = x1874
val x4101 = x4098 >= x4100
val x4405 = if (x4101) {
val x4329 = x4102(x4098)
val x4330 = x4329.empty
val x4370 = if (x4330) {
x4090 = false
()
} else {
val x4335 = x4329.next
val x4336 = x4335 >= x1876
val x4368 = if (x4336) {
x4090 = false
()
} else {
val x4340 = x1869(x4335)
val x4341 = x4340 == ' '
val x4342 = x4340 == ''
val x4343 = x4341 || x4342
val x4344 = x4340 == '\n'
val x4345 = x4343 || x4344
val x4346 = x4340 == '
'
val x4347 = x4345 || x4346
val x4348 = x4340 == '\t'
val x4349 = x4347 || x4348
val x4350 = x4340 == ''
val x4351 = x4349 || x4350
val x4366 = if (x4351) {
val x4354 = x4085
val x4355 = x4086
val x4356 = x4087
x4085 = ()
x4086 = false
val x4352 = x4335 + 1
x4087 = x4352
x4091 = x4352
()
} else {
x4090 = false
()
}
x4366
}
x4368
}
x4370
} else {
val x4372 = x4098 >= x1876
val x4403 = if (x4372) {
x4090 = false
()
} else {
val x4375 = x1869(x4098)
val x4376 = x4375 == ' '
val x4377 = x4375 == ''
val x4378 = x4376 || x4377
val x4379 = x4375 == '\n'
val x4380 = x4378 || x4379
val x4381 = x4375 == '
'
val x4382 = x4380 || x4381
val x4383 = x4375 == '\t'
val x4384 = x4382 || x4383
val x4385 = x4375 == ''
val x4386 = x4384 || x4385
val x4401 = if (x4386) {
val x4389 = x4085
val x4390 = x4086
val x4391 = x4087
x4085 = ()
x4086 = false
val x4387 = x4098 + 1
x4087 = x4387
x4091 = x4387
()
} else {
x4090 = false
()
}
x4401
}
x4403
}
x4405
}
val x4408 = x4085
val x4409 = x4086
val x4410 = x4087
val x6122 = if (x4409) {
x1870 = 0
x1871 = true
x1872 = x1992
()
} else {
var x4418: Int = 0
var x4419: Boolean = false
var x4420: Int = x4410
var x4422: Int = -1
var x4423: Boolean = true
var x4424: Int = x4410
val x4435 = {x4436: (Int) =>
var x4438: Int = 0
var x4439: Boolean = true
var x4440: Int = x4436
val x4442 = x4436 >= x1876
val x4656 = if (x4442) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
val x4448 = x1869(x4436)
val x4449 = x4448 == '\n'
val x4654 = if (x4449) {
val x4450 = x4436 + 1
val x4452 = x4450 >= x1876
val x4648 = if (x4452) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
val x4459 = x1869(x4450)
val x4460 = x4459 >= '0'
val x4461 = x4459 <= '9'
val x4462 = x4460 && x4461
val x4463 = x4459 >= 'A'
val x4464 = x4459 <= 'F'
val x4465 = x4463 && x4464
val x4466 = x4462 || x4465
val x4467 = x4459 >= 'a'
val x4468 = x4459 <= 'f'
val x4469 = x4467 && x4468
val x4470 = x4466 || x4469
val x4646 = if (x4470) {
val x4482 = if (x4462) {
val x4473 = x4459 - '0'
val x4474 = x4473.toInt
x4474
} else {
val x4481 = if (x4465) {
val x4475 = x4459 - 'A'
val x4476 = x4475.toInt
val x4477 = x4476 + 10
x4477
} else {
val x4478 = x4459 - 'a'
val x4479 = x4478.toInt
val x4480 = x4479 + 10
x4480
}
x4481
}
var x4484: Int = x4482
var x4485: Boolean = false
val x4471 = x4450 + 1
var x4486: Int = x4471
var x4488: Int = -1
var x4489: Boolean = true
var x4490: Int = x4471
val x4547 = while ({val x4491 = x4489
val x4492 = x4488
val x4493 = x4490
val x4494 = x4492 != x4493
val x4495 = x4491 && x4494
x4495}) {
val x4497 = x4490
x4488 = x4497
val x4499 = x4497 >= x1876
val x4545 = if (x4499) {
x4489 = false
()
} else {
val x4504 = x1869(x4497)
val x4505 = x4504 >= '0'
val x4506 = x4504 <= '9'
val x4507 = x4505 && x4506
val x4508 = x4504 >= 'A'
val x4509 = x4504 <= 'F'
val x4510 = x4508 && x4509
val x4511 = x4507 || x4510
val x4512 = x4504 >= 'a'
val x4513 = x4504 <= 'f'
val x4514 = x4512 && x4513
val x4515 = x4511 || x4514
val x4543 = if (x4515) {
val x4529 = x4484
val x4530 = x4485
val x4531 = x4486
val x4527 = if (x4507) {
val x4518 = x4504 - '0'
val x4519 = x4518.toInt
x4519
} else {
val x4526 = if (x4510) {
val x4520 = x4504 - 'A'
val x4521 = x4520.toInt
val x4522 = x4521 + 10
x4522
} else {
val x4523 = x4504 - 'a'
val x4524 = x4523.toInt
val x4525 = x4524 + 10
x4525
}
x4526
}
val x4533 = x4529 * 16
val x4534 = x4533 + x4527
x4484 = x4534
x4485 = false
val x4516 = x4497 + 1
x4486 = x4516
x4490 = x4516
()
} else {
x4489 = false
()
}
x4543
}
x4545
}
val x4548 = x4484
val x4549 = x4485
val x4550 = x4486
val x4553 = if (x4549) {
true
} else {
x4549
}
val x4640 = if (x4553) {
val x4594 = if (x4553) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
val x4552 = if (x4549) {
0
} else {
x4548
}
val x4560 = x4552 == 0
val x4592 = if (x4560) {
val x4554 = if (x4549) {
x4450
} else {
x4550
}
val x4561 = x4554 >= x1876
val x4583 = if (x4561) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
val x4568 = x1869(x4554)
val x4569 = x4568 == '\n'
val x4581 = if (x4569) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
x4438 = 0
x4439 = true
x4440 = x4436
()
}
x4581
}
x4583
} else {
val x4554 = if (x4549) {
x4450
} else {
x4550
}
val x4586 = x4554 + x4552
x1874 = x4586
x4438 = x4552
x4439 = false
x4440 = x4554
()
}
x4592
}
x4594
} else {
val x4554 = if (x4549) {
x4450
} else {
x4550
}
val x4561 = x4554 >= x1876
val x4638 = if (x4561) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
val x4568 = x1869(x4554)
val x4569 = x4568 == '\n'
val x4636 = if (x4569) {
val x4552 = if (x4549) {
0
} else {
x4548
}
val x4560 = x4552 == 0
val x4630 = if (x4560) {
val x4570 = x4554 + 1
val x4601 = x4570 >= x1876
val x4622 = if (x4601) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
val x4607 = x1869(x4570)
val x4608 = x4607 == '\n'
val x4620 = if (x4608) {
x4438 = 0
x4439 = true
x4440 = x4436
()
} else {
x4438 = 0
x4439 = true
x4440 = x4436
()
}
x4620
}
x4622
} else {
val x4570 = x4554 + 1
val x4624 = x4570 + x4552
x1874 = x4624
x4438 = x4552
x4439 = false
x4440 = x4570
()
}
x4630
} else {
x4438 = 0
x4439 = true
x4440 = x4436
()
}
x4636
}
x4638
}
x4640
} else {
x4438 = 0
x4439 = true
x4440 = x4436
()
}
x4646
}
x4648
} else {
x4438 = 0
x4439 = true
x4440 = x4436
()
}
x4654
}
val x4657 = x4438
val x4658 = x4439
val x4659 = x4440
val x4660 = new ParseResultInt(x4657,x4658,x4659)
x4660: ParseResultInt
}
val x4709 = {x4710: (Int) =>
var x4712: Int = 0
var x4713: Boolean = true
var x4714: Int = x4710
val x4716 = x4710 >= x1876
val x4930 = if (x4716) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
val x4722 = x1869(x4710)
val x4723 = x4722 == '\n'
val x4928 = if (x4723) {
val x4724 = x4710 + 1
val x4726 = x4724 >= x1876
val x4922 = if (x4726) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
val x4733 = x1869(x4724)
val x4734 = x4733 >= '0'
val x4735 = x4733 <= '9'
val x4736 = x4734 && x4735
val x4737 = x4733 >= 'A'
val x4738 = x4733 <= 'F'
val x4739 = x4737 && x4738
val x4740 = x4736 || x4739
val x4741 = x4733 >= 'a'
val x4742 = x4733 <= 'f'
val x4743 = x4741 && x4742
val x4744 = x4740 || x4743
val x4920 = if (x4744) {
val x4756 = if (x4736) {
val x4747 = x4733 - '0'
val x4748 = x4747.toInt
x4748
} else {
val x4755 = if (x4739) {
val x4749 = x4733 - 'A'
val x4750 = x4749.toInt
val x4751 = x4750 + 10
x4751
} else {
val x4752 = x4733 - 'a'
val x4753 = x4752.toInt
val x4754 = x4753 + 10
x4754
}
x4755
}
var x4758: Int = x4756
var x4759: Boolean = false
val x4745 = x4724 + 1
var x4760: Int = x4745
var x4762: Int = -1
var x4763: Boolean = true
var x4764: Int = x4745
val x4821 = while ({val x4765 = x4763
val x4766 = x4762
val x4767 = x4764
val x4768 = x4766 != x4767
val x4769 = x4765 && x4768
x4769}) {
val x4771 = x4764
x4762 = x4771
val x4773 = x4771 >= x1876
val x4819 = if (x4773) {
x4763 = false
()
} else {
val x4778 = x1869(x4771)
val x4779 = x4778 >= '0'
val x4780 = x4778 <= '9'
val x4781 = x4779 && x4780
val x4782 = x4778 >= 'A'
val x4783 = x4778 <= 'F'
val x4784 = x4782 && x4783
val x4785 = x4781 || x4784
val x4786 = x4778 >= 'a'
val x4787 = x4778 <= 'f'
val x4788 = x4786 && x4787
val x4789 = x4785 || x4788
val x4817 = if (x4789) {
val x4803 = x4758
val x4804 = x4759
val x4805 = x4760
val x4801 = if (x4781) {
val x4792 = x4778 - '0'
val x4793 = x4792.toInt
x4793
} else {
val x4800 = if (x4784) {
val x4794 = x4778 - 'A'
val x4795 = x4794.toInt
val x4796 = x4795 + 10
x4796
} else {
val x4797 = x4778 - 'a'
val x4798 = x4797.toInt
val x4799 = x4798 + 10
x4799
}
x4800
}
val x4807 = x4803 * 16
val x4808 = x4807 + x4801
x4758 = x4808
x4759 = false
val x4790 = x4771 + 1
x4760 = x4790
x4764 = x4790
()
} else {
x4763 = false
()
}
x4817
}
x4819
}
val x4822 = x4758
val x4823 = x4759
val x4824 = x4760
val x4827 = if (x4823) {
true
} else {
x4823
}
val x4914 = if (x4827) {
val x4868 = if (x4827) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
val x4826 = if (x4823) {
0
} else {
x4822
}
val x4834 = x4826 == 0
val x4866 = if (x4834) {
val x4828 = if (x4823) {
x4724
} else {
x4824
}
val x4835 = x4828 >= x1876
val x4857 = if (x4835) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
val x4842 = x1869(x4828)
val x4843 = x4842 == '\n'
val x4855 = if (x4843) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
x4712 = 0
x4713 = true
x4714 = x4710
()
}
x4855
}
x4857
} else {
val x4828 = if (x4823) {
x4724
} else {
x4824
}
val x4860 = x4828 + x4826
x1874 = x4860
x4712 = x4826
x4713 = false
x4714 = x4828
()
}
x4866
}
x4868
} else {
val x4828 = if (x4823) {
x4724
} else {
x4824
}
val x4835 = x4828 >= x1876
val x4912 = if (x4835) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
val x4842 = x1869(x4828)
val x4843 = x4842 == '\n'
val x4910 = if (x4843) {
val x4826 = if (x4823) {
0
} else {
x4822
}
val x4834 = x4826 == 0
val x4904 = if (x4834) {
val x4844 = x4828 + 1
val x4875 = x4844 >= x1876
val x4896 = if (x4875) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
val x4881 = x1869(x4844)
val x4882 = x4881 == '\n'
val x4894 = if (x4882) {
x4712 = 0
x4713 = true
x4714 = x4710
()
} else {
x4712 = 0
x4713 = true
x4714 = x4710
()
}
x4894
}
x4896
} else {
val x4844 = x4828 + 1
val x4898 = x4844 + x4826
x1874 = x4898
x4712 = x4826
x4713 = false
x4714 = x4844
()
}
x4904
} else {
x4712 = 0
x4713 = true
x4714 = x4710
()
}
x4910
}
x4912
}
x4914
} else {
x4712 = 0
x4713 = true
x4714 = x4710
()
}
x4920
}
x4922
} else {
x4712 = 0
x4713 = true
x4714 = x4710
()
}
x4928
}
val x4931 = x4712
val x4932 = x4713
val x4933 = x4714
val x4934 = new ParseResultInt(x4931,x4932,x4933)
x4934: ParseResultInt
}
val x5054 = {x5055: (Int) =>
var x5057: Int = 0
var x5058: Boolean = true
var x5059: Int = x5055
val x5061 = x5055 >= x1876
val x5275 = if (x5061) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
val x5067 = x1869(x5055)
val x5068 = x5067 == '\n'
val x5273 = if (x5068) {
val x5069 = x5055 + 1
val x5071 = x5069 >= x1876
val x5267 = if (x5071) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
val x5078 = x1869(x5069)
val x5079 = x5078 >= '0'
val x5080 = x5078 <= '9'
val x5081 = x5079 && x5080
val x5082 = x5078 >= 'A'
val x5083 = x5078 <= 'F'
val x5084 = x5082 && x5083
val x5085 = x5081 || x5084
val x5086 = x5078 >= 'a'
val x5087 = x5078 <= 'f'
val x5088 = x5086 && x5087
val x5089 = x5085 || x5088
val x5265 = if (x5089) {
val x5101 = if (x5081) {
val x5092 = x5078 - '0'
val x5093 = x5092.toInt
x5093
} else {
val x5100 = if (x5084) {
val x5094 = x5078 - 'A'
val x5095 = x5094.toInt
val x5096 = x5095 + 10
x5096
} else {
val x5097 = x5078 - 'a'
val x5098 = x5097.toInt
val x5099 = x5098 + 10
x5099
}
x5100
}
var x5103: Int = x5101
var x5104: Boolean = false
val x5090 = x5069 + 1
var x5105: Int = x5090
var x5107: Int = -1
var x5108: Boolean = true
var x5109: Int = x5090
val x5166 = while ({val x5110 = x5108
val x5111 = x5107
val x5112 = x5109
val x5113 = x5111 != x5112
val x5114 = x5110 && x5113
x5114}) {
val x5116 = x5109
x5107 = x5116
val x5118 = x5116 >= x1876
val x5164 = if (x5118) {
x5108 = false
()
} else {
val x5123 = x1869(x5116)
val x5124 = x5123 >= '0'
val x5125 = x5123 <= '9'
val x5126 = x5124 && x5125
val x5127 = x5123 >= 'A'
val x5128 = x5123 <= 'F'
val x5129 = x5127 && x5128
val x5130 = x5126 || x5129
val x5131 = x5123 >= 'a'
val x5132 = x5123 <= 'f'
val x5133 = x5131 && x5132
val x5134 = x5130 || x5133
val x5162 = if (x5134) {
val x5148 = x5103
val x5149 = x5104
val x5150 = x5105
val x5146 = if (x5126) {
val x5137 = x5123 - '0'
val x5138 = x5137.toInt
x5138
} else {
val x5145 = if (x5129) {
val x5139 = x5123 - 'A'
val x5140 = x5139.toInt
val x5141 = x5140 + 10
x5141
} else {
val x5142 = x5123 - 'a'
val x5143 = x5142.toInt
val x5144 = x5143 + 10
x5144
}
x5145
}
val x5152 = x5148 * 16
val x5153 = x5152 + x5146
x5103 = x5153
x5104 = false
val x5135 = x5116 + 1
x5105 = x5135
x5109 = x5135
()
} else {
x5108 = false
()
}
x5162
}
x5164
}
val x5167 = x5103
val x5168 = x5104
val x5169 = x5105
val x5172 = if (x5168) {
true
} else {
x5168
}
val x5259 = if (x5172) {
val x5213 = if (x5172) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
val x5171 = if (x5168) {
0
} else {
x5167
}
val x5179 = x5171 == 0
val x5211 = if (x5179) {
val x5173 = if (x5168) {
x5069
} else {
x5169
}
val x5180 = x5173 >= x1876
val x5202 = if (x5180) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
val x5187 = x1869(x5173)
val x5188 = x5187 == '\n'
val x5200 = if (x5188) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
x5057 = 0
x5058 = true
x5059 = x5055
()
}
x5200
}
x5202
} else {
val x5173 = if (x5168) {
x5069
} else {
x5169
}
val x5205 = x5173 + x5171
x1874 = x5205
x5057 = x5171
x5058 = false
x5059 = x5173
()
}
x5211
}
x5213
} else {
val x5173 = if (x5168) {
x5069
} else {
x5169
}
val x5180 = x5173 >= x1876
val x5257 = if (x5180) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
val x5187 = x1869(x5173)
val x5188 = x5187 == '\n'
val x5255 = if (x5188) {
val x5171 = if (x5168) {
0
} else {
x5167
}
val x5179 = x5171 == 0
val x5249 = if (x5179) {
val x5189 = x5173 + 1
val x5220 = x5189 >= x1876
val x5241 = if (x5220) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
val x5226 = x1869(x5189)
val x5227 = x5226 == '\n'
val x5239 = if (x5227) {
x5057 = 0
x5058 = true
x5059 = x5055
()
} else {
x5057 = 0
x5058 = true
x5059 = x5055
()
}
x5239
}
x5241
} else {
val x5189 = x5173 + 1
val x5243 = x5189 + x5171
x1874 = x5243
x5057 = x5171
x5058 = false
x5059 = x5189
()
}
x5249
} else {
x5057 = 0
x5058 = true
x5059 = x5055
()
}
x5255
}
x5257
}
x5259
} else {
x5057 = 0
x5058 = true
x5059 = x5055
()
}
x5265
}
x5267
} else {
x5057 = 0
x5058 = true
x5059 = x5055
()
}
x5273
}
val x5276 = x5057
val x5277 = x5058
val x5278 = x5059
val x5279 = new ParseResultInt(x5276,x5277,x5278)
x5279: ParseResultInt
}
val x5430 = {x5431: (Int) =>
var x5433: Int = 0
var x5434: Boolean = true
var x5435: Int = x5431
val x5437 = x5431 >= x1876
val x5651 = if (x5437) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
val x5443 = x1869(x5431)
val x5444 = x5443 == '\n'
val x5649 = if (x5444) {
val x5445 = x5431 + 1
val x5447 = x5445 >= x1876
val x5643 = if (x5447) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
val x5454 = x1869(x5445)
val x5455 = x5454 >= '0'
val x5456 = x5454 <= '9'
val x5457 = x5455 && x5456
val x5458 = x5454 >= 'A'
val x5459 = x5454 <= 'F'
val x5460 = x5458 && x5459
val x5461 = x5457 || x5460
val x5462 = x5454 >= 'a'
val x5463 = x5454 <= 'f'
val x5464 = x5462 && x5463
val x5465 = x5461 || x5464
val x5641 = if (x5465) {
val x5477 = if (x5457) {
val x5468 = x5454 - '0'
val x5469 = x5468.toInt
x5469
} else {
val x5476 = if (x5460) {
val x5470 = x5454 - 'A'
val x5471 = x5470.toInt
val x5472 = x5471 + 10
x5472
} else {
val x5473 = x5454 - 'a'
val x5474 = x5473.toInt
val x5475 = x5474 + 10
x5475
}
x5476
}
var x5479: Int = x5477
var x5480: Boolean = false
val x5466 = x5445 + 1
var x5481: Int = x5466
var x5483: Int = -1
var x5484: Boolean = true
var x5485: Int = x5466
val x5542 = while ({val x5486 = x5484
val x5487 = x5483
val x5488 = x5485
val x5489 = x5487 != x5488
val x5490 = x5486 && x5489
x5490}) {
val x5492 = x5485
x5483 = x5492
val x5494 = x5492 >= x1876
val x5540 = if (x5494) {
x5484 = false
()
} else {
val x5499 = x1869(x5492)
val x5500 = x5499 >= '0'
val x5501 = x5499 <= '9'
val x5502 = x5500 && x5501
val x5503 = x5499 >= 'A'
val x5504 = x5499 <= 'F'
val x5505 = x5503 && x5504
val x5506 = x5502 || x5505
val x5507 = x5499 >= 'a'
val x5508 = x5499 <= 'f'
val x5509 = x5507 && x5508
val x5510 = x5506 || x5509
val x5538 = if (x5510) {
val x5524 = x5479
val x5525 = x5480
val x5526 = x5481
val x5522 = if (x5502) {
val x5513 = x5499 - '0'
val x5514 = x5513.toInt
x5514
} else {
val x5521 = if (x5505) {
val x5515 = x5499 - 'A'
val x5516 = x5515.toInt
val x5517 = x5516 + 10
x5517
} else {
val x5518 = x5499 - 'a'
val x5519 = x5518.toInt
val x5520 = x5519 + 10
x5520
}
x5521
}
val x5528 = x5524 * 16
val x5529 = x5528 + x5522
x5479 = x5529
x5480 = false
val x5511 = x5492 + 1
x5481 = x5511
x5485 = x5511
()
} else {
x5484 = false
()
}
x5538
}
x5540
}
val x5543 = x5479
val x5544 = x5480
val x5545 = x5481
val x5548 = if (x5544) {
true
} else {
x5544
}
val x5635 = if (x5548) {
val x5589 = if (x5548) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
val x5547 = if (x5544) {
0
} else {
x5543
}
val x5555 = x5547 == 0
val x5587 = if (x5555) {
val x5549 = if (x5544) {
x5445
} else {
x5545
}
val x5556 = x5549 >= x1876
val x5578 = if (x5556) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
val x5563 = x1869(x5549)
val x5564 = x5563 == '\n'
val x5576 = if (x5564) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
x5433 = 0
x5434 = true
x5435 = x5431
()
}
x5576
}
x5578
} else {
val x5549 = if (x5544) {
x5445
} else {
x5545
}
val x5581 = x5549 + x5547
x1874 = x5581
x5433 = x5547
x5434 = false
x5435 = x5549
()
}
x5587
}
x5589
} else {
val x5549 = if (x5544) {
x5445
} else {
x5545
}
val x5556 = x5549 >= x1876
val x5633 = if (x5556) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
val x5563 = x1869(x5549)
val x5564 = x5563 == '\n'
val x5631 = if (x5564) {
val x5547 = if (x5544) {
0
} else {
x5543
}
val x5555 = x5547 == 0
val x5625 = if (x5555) {
val x5565 = x5549 + 1
val x5596 = x5565 >= x1876
val x5617 = if (x5596) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
val x5602 = x1869(x5565)
val x5603 = x5602 == '\n'
val x5615 = if (x5603) {
x5433 = 0
x5434 = true
x5435 = x5431
()
} else {
x5433 = 0
x5434 = true
x5435 = x5431
()
}
x5615
}
x5617
} else {
val x5565 = x5549 + 1
val x5619 = x5565 + x5547
x1874 = x5619
x5433 = x5547
x5434 = false
x5435 = x5565
()
}
x5625
} else {
x5433 = 0
x5434 = true
x5435 = x5431
()
}
x5631
}
x5633
}
x5635
} else {
x5433 = 0
x5434 = true
x5435 = x5431
()
}
x5641
}
x5643
} else {
x5433 = 0
x5434 = true
x5435 = x5431
()
}
x5649
}
val x5652 = x5433
val x5653 = x5434
val x5654 = x5435
val x5655 = new ParseResultInt(x5652,x5653,x5654)
x5655: ParseResultInt
}
val x5775 = {x5776: (Int) =>
var x5778: Int = 0
var x5779: Boolean = true
var x5780: Int = x5776
val x5782 = x5776 >= x1876
val x5996 = if (x5782) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
val x5788 = x1869(x5776)
val x5789 = x5788 == '\n'
val x5994 = if (x5789) {
val x5790 = x5776 + 1
val x5792 = x5790 >= x1876
val x5988 = if (x5792) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
val x5799 = x1869(x5790)
val x5800 = x5799 >= '0'
val x5801 = x5799 <= '9'
val x5802 = x5800 && x5801
val x5803 = x5799 >= 'A'
val x5804 = x5799 <= 'F'
val x5805 = x5803 && x5804
val x5806 = x5802 || x5805
val x5807 = x5799 >= 'a'
val x5808 = x5799 <= 'f'
val x5809 = x5807 && x5808
val x5810 = x5806 || x5809
val x5986 = if (x5810) {
val x5822 = if (x5802) {
val x5813 = x5799 - '0'
val x5814 = x5813.toInt
x5814
} else {
val x5821 = if (x5805) {
val x5815 = x5799 - 'A'
val x5816 = x5815.toInt
val x5817 = x5816 + 10
x5817
} else {
val x5818 = x5799 - 'a'
val x5819 = x5818.toInt
val x5820 = x5819 + 10
x5820
}
x5821
}
var x5824: Int = x5822
var x5825: Boolean = false
val x5811 = x5790 + 1
var x5826: Int = x5811
var x5828: Int = -1
var x5829: Boolean = true
var x5830: Int = x5811
val x5887 = while ({val x5831 = x5829
val x5832 = x5828
val x5833 = x5830
val x5834 = x5832 != x5833
val x5835 = x5831 && x5834
x5835}) {
val x5837 = x5830
x5828 = x5837
val x5839 = x5837 >= x1876
val x5885 = if (x5839) {
x5829 = false
()
} else {
val x5844 = x1869(x5837)
val x5845 = x5844 >= '0'
val x5846 = x5844 <= '9'
val x5847 = x5845 && x5846
val x5848 = x5844 >= 'A'
val x5849 = x5844 <= 'F'
val x5850 = x5848 && x5849
val x5851 = x5847 || x5850
val x5852 = x5844 >= 'a'
val x5853 = x5844 <= 'f'
val x5854 = x5852 && x5853
val x5855 = x5851 || x5854
val x5883 = if (x5855) {
val x5869 = x5824
val x5870 = x5825
val x5871 = x5826
val x5867 = if (x5847) {
val x5858 = x5844 - '0'
val x5859 = x5858.toInt
x5859
} else {
val x5866 = if (x5850) {
val x5860 = x5844 - 'A'
val x5861 = x5860.toInt
val x5862 = x5861 + 10
x5862
} else {
val x5863 = x5844 - 'a'
val x5864 = x5863.toInt
val x5865 = x5864 + 10
x5865
}
x5866
}
val x5873 = x5869 * 16
val x5874 = x5873 + x5867
x5824 = x5874
x5825 = false
val x5856 = x5837 + 1
x5826 = x5856
x5830 = x5856
()
} else {
x5829 = false
()
}
x5883
}
x5885
}
val x5888 = x5824
val x5889 = x5825
val x5890 = x5826
val x5893 = if (x5889) {
true
} else {
x5889
}
val x5980 = if (x5893) {
val x5934 = if (x5893) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
val x5892 = if (x5889) {
0
} else {
x5888
}
val x5900 = x5892 == 0
val x5932 = if (x5900) {
val x5894 = if (x5889) {
x5790
} else {
x5890
}
val x5901 = x5894 >= x1876
val x5923 = if (x5901) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
val x5908 = x1869(x5894)
val x5909 = x5908 == '\n'
val x5921 = if (x5909) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
x5778 = 0
x5779 = true
x5780 = x5776
()
}
x5921
}
x5923
} else {
val x5894 = if (x5889) {
x5790
} else {
x5890
}
val x5926 = x5894 + x5892
x1874 = x5926
x5778 = x5892
x5779 = false
x5780 = x5894
()
}
x5932
}
x5934
} else {
val x5894 = if (x5889) {
x5790
} else {
x5890
}
val x5901 = x5894 >= x1876
val x5978 = if (x5901) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
val x5908 = x1869(x5894)
val x5909 = x5908 == '\n'
val x5976 = if (x5909) {
val x5892 = if (x5889) {
0
} else {
x5888
}
val x5900 = x5892 == 0
val x5970 = if (x5900) {
val x5910 = x5894 + 1
val x5941 = x5910 >= x1876
val x5962 = if (x5941) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
val x5947 = x1869(x5910)
val x5948 = x5947 == '\n'
val x5960 = if (x5948) {
x5778 = 0
x5779 = true
x5780 = x5776
()
} else {
x5778 = 0
x5779 = true
x5780 = x5776
()
}
x5960
}
x5962
} else {
val x5910 = x5894 + 1
val x5964 = x5910 + x5892
x1874 = x5964
x5778 = x5892
x5779 = false
x5780 = x5910
()
}
x5970
} else {
x5778 = 0
x5779 = true
x5780 = x5776
()
}
x5976
}
x5978
}
x5980
} else {
x5778 = 0
x5779 = true
x5780 = x5776
()
}
x5986
}
x5988
} else {
x5778 = 0
x5779 = true
x5780 = x5776
()
}
x5994
}
val x5997 = x5778
val x5998 = x5779
val x5999 = x5780
val x6000 = new ParseResultInt(x5997,x5998,x5999)
x6000: ParseResultInt
}
val x6113 = while ({val x4425 = x4423
val x4426 = x4422
val x4427 = x4424
val x4428 = x4426 != x4427
val x4429 = x4425 && x4428
x4429}) {
val x4431 = x4424
x4422 = x4431
val x4433 = x1874
val x4434 = x4431 >= x4433
val x6111 = if (x4434) {
val x4662 = x4435(x4431)
val x4663 = x4662.empty
val x5390 = if (x4663) {
x4423 = false
()
} else {
val x4669 = x4662.next
val x4670 = x4669 >= x1876
val x5388 = if (x4670) {
x4423 = false
()
} else {
val x4674 = x1869(x4669)
val x4675 = x4674 == ' '
val x4676 = x4674 == ''
val x4677 = x4675 || x4676
val x4678 = x4674 == '\n'
val x4679 = x4677 || x4678
val x4680 = x4674 == '
'
val x4681 = x4679 || x4680
val x4682 = x4674 == '\t'
val x4683 = x4681 || x4682
val x4684 = x4674 == ''
val x4685 = x4683 || x4684
val x5386 = if (x4685) {
x4423 = false
()
} else {
var x4692: Unit = ()
var x4693: Boolean = false
val x4689 = x4669 + 1
var x4694: Int = x4689
var x4696: Int = -1
var x4697: Boolean = true
var x4698: Int = x4689
val x5016 = while ({val x4699 = x4697
val x4700 = x4696
val x4701 = x4698
val x4702 = x4700 != x4701
val x4703 = x4699 && x4702
x4703}) {
val x4705 = x4698
x4696 = x4705
val x4707 = x1874
val x4708 = x4705 >= x4707
val x5014 = if (x4708) {
val x4936 = x4709(x4705)
val x4937 = x4936.empty
val x4978 = if (x4937) {
x4697 = false
()
} else {
val x4942 = x4936.next
val x4943 = x4942 >= x1876
val x4976 = if (x4943) {
x4697 = false
()
} else {
val x4947 = x1869(x4942)
val x4948 = x4947 == ' '
val x4949 = x4947 == ''
val x4950 = x4948 || x4949
val x4951 = x4947 == '\n'
val x4952 = x4950 || x4951
val x4953 = x4947 == '
'
val x4954 = x4952 || x4953
val x4955 = x4947 == '\t'
val x4956 = x4954 || x4955
val x4957 = x4947 == ''
val x4958 = x4956 || x4957
val x4974 = if (x4958) {
x4697 = false
()
} else {
val x4964 = x4692
val x4965 = x4693
val x4966 = x4694
x4692 = ()
x4693 = false
val x4962 = x4942 + 1
x4694 = x4962
x4698 = x4962
()
}
x4974
}
x4976
}
x4978
} else {
val x4980 = x4705 >= x1876
val x5012 = if (x4980) {
x4697 = false
()
} else {
val x4983 = x1869(x4705)
val x4984 = x4983 == ' '
val x4985 = x4983 == ''
val x4986 = x4984 || x4985
val x4987 = x4983 == '\n'
val x4988 = x4986 || x4987
val x4989 = x4983 == '
'
val x4990 = x4988 || x4989
val x4991 = x4983 == '\t'
val x4992 = x4990 || x4991
val x4993 = x4983 == ''
val x4994 = x4992 || x4993
val x5010 = if (x4994) {
x4697 = false
()
} else {
val x5000 = x4692
val x5001 = x4693
val x5002 = x4694
x4692 = ()
x4693 = false
val x4998 = x4705 + 1
x4694 = x4998
x4698 = x4998
()
}
x5010
}
x5012
}
x5014
}
val x5017 = x4692
val x5018 = x4693
val x5019 = x4694
val x5384 = if (x5018) {
val x5034 = if (x5018) {
x4423 = false
()
} else {
val x5023 = x4418
val x5024 = x4419
val x5025 = x4420
val x5027 = x5023 + 1
x4418 = x5027
x4419 = false
x4420 = x5019
x4424 = x5019
()
}
x5034
} else {
var x5037: Unit = ()
var x5038: Boolean = false
var x5039: Int = x5019
var x5041: Int = -1
var x5042: Boolean = true
var x5043: Int = x5019
val x5359 = while ({val x5044 = x5042
val x5045 = x5041
val x5046 = x5043
val x5047 = x5045 != x5046
val x5048 = x5044 && x5047
x5048}) {
val x5050 = x5043
x5041 = x5050
val x5052 = x1874
val x5053 = x5050 >= x5052
val x5357 = if (x5053) {
val x5281 = x5054(x5050)
val x5282 = x5281.empty
val x5322 = if (x5282) {
x5042 = false
()
} else {
val x5287 = x5281.next
val x5288 = x5287 >= x1876
val x5320 = if (x5288) {
x5042 = false
()
} else {
val x5292 = x1869(x5287)
val x5293 = x5292 == ' '
val x5294 = x5292 == ''
val x5295 = x5293 || x5294
val x5296 = x5292 == '\n'
val x5297 = x5295 || x5296
val x5298 = x5292 == '
'
val x5299 = x5297 || x5298
val x5300 = x5292 == '\t'
val x5301 = x5299 || x5300
val x5302 = x5292 == ''
val x5303 = x5301 || x5302
val x5318 = if (x5303) {
val x5306 = x5037
val x5307 = x5038
val x5308 = x5039
x5037 = ()
x5038 = false
val x5304 = x5287 + 1
x5039 = x5304
x5043 = x5304
()
} else {
x5042 = false
()
}
x5318
}
x5320
}
x5322
} else {
val x5324 = x5050 >= x1876
val x5355 = if (x5324) {
x5042 = false
()
} else {
val x5327 = x1869(x5050)
val x5328 = x5327 == ' '
val x5329 = x5327 == ''
val x5330 = x5328 || x5329
val x5331 = x5327 == '\n'
val x5332 = x5330 || x5331
val x5333 = x5327 == '
'
val x5334 = x5332 || x5333
val x5335 = x5327 == '\t'
val x5336 = x5334 || x5335
val x5337 = x5327 == ''
val x5338 = x5336 || x5337
val x5353 = if (x5338) {
val x5341 = x5037
val x5342 = x5038
val x5343 = x5039
x5037 = ()
x5038 = false
val x5339 = x5050 + 1
x5039 = x5339
x5043 = x5339
()
} else {
x5042 = false
()
}
x5353
}
x5355
}
x5357
}
val x5360 = x5037
val x5361 = x5038
val x5362 = x5039
val x5366 = if (x5361) {
true
} else {
false
}
val x5382 = if (x5366) {
x4423 = false
()
} else {
val x5371 = x4418
val x5372 = x4419
val x5373 = x4420
val x5375 = x5371 + 1
x4418 = x5375
x4419 = false
val x5367 = if (x5361) {
x4431
} else {
x5362
}
x4420 = x5367
x4424 = x5367
()
}
x5382
}
x5384
}
x5386
}
x5388
}
x5390
} else {
val x5392 = x4431 >= x1876
val x6109 = if (x5392) {
x4423 = false
()
} else {
val x5395 = x1869(x4431)
val x5396 = x5395 == ' '
val x5397 = x5395 == ''
val x5398 = x5396 || x5397
val x5399 = x5395 == '\n'
val x5400 = x5398 || x5399
val x5401 = x5395 == '
'
val x5402 = x5400 || x5401
val x5403 = x5395 == '\t'
val x5404 = x5402 || x5403
val x5405 = x5395 == ''
val x5406 = x5404 || x5405
val x6107 = if (x5406) {
x4423 = false
()
} else {
var x5413: Unit = ()
var x5414: Boolean = false
val x5410 = x4431 + 1
var x5415: Int = x5410
var x5417: Int = -1
var x5418: Boolean = true
var x5419: Int = x5410
val x5737 = while ({val x5420 = x5418
val x5421 = x5417
val x5422 = x5419
val x5423 = x5421 != x5422
val x5424 = x5420 && x5423
x5424}) {
val x5426 = x5419
x5417 = x5426
val x5428 = x1874
val x5429 = x5426 >= x5428
val x5735 = if (x5429) {
val x5657 = x5430(x5426)
val x5658 = x5657.empty
val x5699 = if (x5658) {
x5418 = false
()
} else {
val x5663 = x5657.next
val x5664 = x5663 >= x1876
val x5697 = if (x5664) {
x5418 = false
()
} else {
val x5668 = x1869(x5663)
val x5669 = x5668 == ' '
val x5670 = x5668 == ''
val x5671 = x5669 || x5670
val x5672 = x5668 == '\n'
val x5673 = x5671 || x5672
val x5674 = x5668 == '
'
val x5675 = x5673 || x5674
val x5676 = x5668 == '\t'
val x5677 = x5675 || x5676
val x5678 = x5668 == ''
val x5679 = x5677 || x5678
val x5695 = if (x5679) {
x5418 = false
()
} else {
val x5685 = x5413
val x5686 = x5414
val x5687 = x5415
x5413 = ()
x5414 = false
val x5683 = x5663 + 1
x5415 = x5683
x5419 = x5683
()
}
x5695
}
x5697
}
x5699
} else {
val x5701 = x5426 >= x1876
val x5733 = if (x5701) {
x5418 = false
()
} else {
val x5704 = x1869(x5426)
val x5705 = x5704 == ' '
val x5706 = x5704 == ''
val x5707 = x5705 || x5706
val x5708 = x5704 == '\n'
val x5709 = x5707 || x5708
val x5710 = x5704 == '
'
val x5711 = x5709 || x5710
val x5712 = x5704 == '\t'
val x5713 = x5711 || x5712
val x5714 = x5704 == ''
val x5715 = x5713 || x5714
val x5731 = if (x5715) {
x5418 = false
()
} else {
val x5721 = x5413
val x5722 = x5414
val x5723 = x5415
x5413 = ()
x5414 = false
val x5719 = x5426 + 1
x5415 = x5719
x5419 = x5719
()
}
x5731
}
x5733
}
x5735
}
val x5738 = x5413
val x5739 = x5414
val x5740 = x5415
val x6105 = if (x5739) {
val x5755 = if (x5739) {
x4423 = false
()
} else {
val x5744 = x4418
val x5745 = x4419
val x5746 = x4420
val x5748 = x5744 + 1
x4418 = x5748
x4419 = false
x4420 = x5740
x4424 = x5740
()
}
x5755
} else {
var x5758: Unit = ()
var x5759: Boolean = false
var x5760: Int = x5740
var x5762: Int = -1
var x5763: Boolean = true
var x5764: Int = x5740
val x6080 = while ({val x5765 = x5763
val x5766 = x5762
val x5767 = x5764
val x5768 = x5766 != x5767
val x5769 = x5765 && x5768
x5769}) {
val x5771 = x5764
x5762 = x5771
val x5773 = x1874
val x5774 = x5771 >= x5773
val x6078 = if (x5774) {
val x6002 = x5775(x5771)
val x6003 = x6002.empty
val x6043 = if (x6003) {
x5763 = false
()
} else {
val x6008 = x6002.next
val x6009 = x6008 >= x1876
val x6041 = if (x6009) {
x5763 = false
()
} else {
val x6013 = x1869(x6008)
val x6014 = x6013 == ' '
val x6015 = x6013 == ''
val x6016 = x6014 || x6015
val x6017 = x6013 == '\n'
val x6018 = x6016 || x6017
val x6019 = x6013 == '
'
val x6020 = x6018 || x6019
val x6021 = x6013 == '\t'
val x6022 = x6020 || x6021
val x6023 = x6013 == ''
val x6024 = x6022 || x6023
val x6039 = if (x6024) {
val x6027 = x5758
val x6028 = x5759
val x6029 = x5760
x5758 = ()
x5759 = false
val x6025 = x6008 + 1
x5760 = x6025
x5764 = x6025
()
} else {
x5763 = false
()
}
x6039
}
x6041
}
x6043
} else {
val x6045 = x5771 >= x1876
val x6076 = if (x6045) {
x5763 = false
()
} else {
val x6048 = x1869(x5771)
val x6049 = x6048 == ' '
val x6050 = x6048 == ''
val x6051 = x6049 || x6050
val x6052 = x6048 == '\n'
val x6053 = x6051 || x6052
val x6054 = x6048 == '
'
val x6055 = x6053 || x6054
val x6056 = x6048 == '\t'
val x6057 = x6055 || x6056
val x6058 = x6048 == ''
val x6059 = x6057 || x6058
val x6074 = if (x6059) {
val x6062 = x5758
val x6063 = x5759
val x6064 = x5760
x5758 = ()
x5759 = false
val x6060 = x5771 + 1
x5760 = x6060
x5764 = x6060
()
} else {
x5763 = false
()
}
x6074
}
x6076
}
x6078
}
val x6081 = x5758
val x6082 = x5759
val x6083 = x5760
val x6087 = if (x6082) {
true
} else {
false
}
val x6103 = if (x6087) {
x4423 = false
()
} else {
val x6092 = x4418
val x6093 = x4419
val x6094 = x4420
val x6096 = x6092 + 1
x4418 = x6096
x4419 = false
val x6088 = if (x6082) {
x4431
} else {
x6083
}
x4420 = x6088
x4424 = x6088
()
}
x6103
}
x6105
}
x6107
}
x6109
}
x6111
}
val x6114 = x4418
val x6115 = x4419
val x6116 = x4420
x1870 = x6114
x1871 = x6115
x1872 = x6116
()
}
x6122
}
x6124
} else {
x1870 = 0
x1871 = true
x1872 = 0
()
}
x6130
}
x6132
}
x6134
} else {
x1870 = 0
x1871 = true
x1872 = 0
()
}
x6140
}
val x6143 = x1870
val x6144 = x1871
val x6145 = x1872
val x6146 = new ParseResultInt(x6143,x6144,x6145)
//val x6147 = println(x6146)
//x6147
res = x6146
}
}
