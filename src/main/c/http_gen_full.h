#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


typedef struct{
int status;
int contentLength;
const char* connection;
bool chunked;
bool upgrade;
} Anon1323431030;

typedef struct{
const char* input;
int start;
int length;
} Anon1680061013;

typedef struct{
Anon1323431030 _1;
const char* _2;
} Tuple2Anon1323431030String;

typedef struct{
int res;
bool empty;
int next;
} ParseResultInt;

typedef struct{
Tuple2Anon1323431030String res;
bool empty;
int next;
} ParseResultTuple2Anon1323431030String;

typedef struct{
int _1;
Anon1323431030 _2;
} Tuple2IntAnon1323431030;
/*****************************************
  Emitting C Generated Code
*******************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
ParseResultTuple2Anon1323431030String respAndMessageParse(char* x0) {
const Tuple2Anon1323431030String x1 = {};
Tuple2Anon1323431030String x3 = x1;
bool x4 = true;
int x5 = -1;
const int x8 = strlen(x0);
const bool x9 = 0 >= x8;
if (x9) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x31 = x0[0];
const bool x32 = x31 == 'H';
if (x32) {
const int x33 = 0 + 1;
const bool x35 = x33 >= x8;
if (x35) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x43 = x0[x33];
const bool x44 = x43 == 'T';
if (x44) {
const int x45 = x33 + 1;
const bool x47 = x45 >= x8;
if (x47) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x55 = x0[x45];
const bool x56 = x55 == 'T';
if (x56) {
const int x57 = x45 + 1;
const bool x59 = x57 >= x8;
if (x59) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x67 = x0[x57];
const bool x68 = x67 == 'P';
if (x68) {
const int x69 = x57 + 1;
const bool x71 = x69 >= x8;
if (x71) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x79 = x0[x69];
const bool x80 = x79 == '/';
if (x80) {
const int x81 = x69 + 1;
const bool x104 = x81 >= x8;
if (x104) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x113 = x0[x81];
const bool x114 = x113 >= '0';
const bool x115 = x113 <= '9';
const bool x116 = x114 && x115;
if (x116) {
const char x119 = x113 - '0';
const int x120 = (int)x119;
int x122 = x120;
bool x123 = false;
const int x117 = x81 + 1;
int x124 = x117;
int x126 = -1;
bool x127 = true;
int x128 = x117;
for (;;) {
const bool x129 = x127;
const int x130 = x126;
const int x131 = x128;
const bool x132 = x130 != x131;
const bool x133 = x129 && x132;
if (!x133) break;
const int x135 = x128;
x126 = x135;
const bool x137 = x135 >= x8;
if (x137) {
x127 = false;
} else {
const char x142 = x0[x135];
const bool x143 = x142 >= '0';
const bool x144 = x142 <= '9';
const bool x145 = x143 && x144;
if (x145) {
const int x151 = x122;
const bool x152 = x123;
const int x153 = x124;
const char x148 = x142 - '0';
const int x149 = (int)x148;
const int x155 = x151 * 10;
const int x156 = x155 + x149;
x122 = x156;
x123 = false;
const int x146 = x135 + 1;
x124 = x146;
x128 = x146;
} else {
x127 = false;
}
}
}
const int x170 = x122;
const bool x171 = x123;
const int x172 = x124;
bool x175;
if (x171) {
x175 = true;
} else {
x175 = x171;
}
if (x175) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
int x176;
if (x171) {
x176 = x81;
} else {
x176 = x172;
}
const bool x182 = x176 >= x8;
if (x182) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x189 = x0[x176];
const bool x190 = x189 == '.';
if (x190) {
const int x191 = x176 + 1;
const bool x193 = x191 >= x8;
if (x193) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x200 = x0[x191];
const bool x201 = x200 >= '0';
const bool x202 = x200 <= '9';
const bool x203 = x201 && x202;
if (x203) {
const char x206 = x200 - '0';
const int x207 = (int)x206;
int x209 = x207;
bool x210 = false;
const int x204 = x191 + 1;
int x211 = x204;
int x213 = -1;
bool x214 = true;
int x215 = x204;
for (;;) {
const bool x216 = x214;
const int x217 = x213;
const int x218 = x215;
const bool x219 = x217 != x218;
const bool x220 = x216 && x219;
if (!x220) break;
const int x222 = x215;
x213 = x222;
const bool x224 = x222 >= x8;
if (x224) {
x214 = false;
} else {
const char x229 = x0[x222];
const bool x230 = x229 >= '0';
const bool x231 = x229 <= '9';
const bool x232 = x230 && x231;
if (x232) {
const int x238 = x209;
const bool x239 = x210;
const int x240 = x211;
const char x235 = x229 - '0';
const int x236 = (int)x235;
const int x242 = x238 * 10;
const int x243 = x242 + x236;
x209 = x243;
x210 = false;
const int x233 = x222 + 1;
x211 = x233;
x215 = x233;
} else {
x214 = false;
}
}
}
const int x257 = x209;
const bool x258 = x210;
const int x259 = x211;
bool x262;
if (x258) {
x262 = true;
} else {
x262 = x258;
}
bool x268;
if (x262) {
x268 = true;
} else {
x268 = false;
}
bool x274;
if (x268) {
x274 = true;
} else {
x274 = false;
}
if (x274) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
char* x282 = "";
bool x283 = false;
int x275;
if (x268) {
x275 = 0;
} else {
int x269;
if (x262) {
x269 = x81;
} else {
int x263;
if (x258) {
x263 = x191;
} else {
x263 = x259;
}
x269 = x263;
}
x275 = x269;
}
int x284 = x275;
int x286 = -1;
bool x287 = true;
int x288 = x275;
for (;;) {
const bool x289 = x287;
const int x290 = x286;
const int x291 = x288;
const bool x292 = x290 != x291;
const bool x293 = x289 && x292;
if (!x293) break;
const int x295 = x288;
x286 = x295;
const bool x297 = x295 >= x8;
if (x297) {
x287 = false;
} else {
const char x301 = x0[x295];
const bool x302 = x301 == ' ';
if (x302) {
const char* x305 = x282;
const bool x306 = x283;
const int x307 = x284;
x282 = (char*)x305;
x283 = false;
const int x303 = x295 + 1;
x284 = x303;
x288 = x303;
} else {
x287 = false;
}
}
}
const char* x322 = x282;
const bool x323 = x283;
const int x324 = x284;
bool x329;
if (x323) {
x329 = true;
} else {
x329 = false;
}
if (x329) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
int x330;
if (x323) {
x330 = 0;
} else {
x330 = x324;
}
const bool x336 = x330 >= x8;
if (x336) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x343 = x0[x330];
const bool x344 = x343 >= '0';
const bool x345 = x343 <= '9';
const bool x346 = x344 && x345;
if (x346) {
const char x349 = x343 - '0';
const int x350 = (int)x349;
int x352 = x350;
bool x353 = false;
const int x347 = x330 + 1;
int x354 = x347;
int x356 = -1;
bool x357 = true;
int x358 = x347;
for (;;) {
const bool x359 = x357;
const int x360 = x356;
const int x361 = x358;
const bool x362 = x360 != x361;
const bool x363 = x359 && x362;
if (!x363) break;
const int x365 = x358;
x356 = x365;
const bool x367 = x365 >= x8;
if (x367) {
x357 = false;
} else {
const char x372 = x0[x365];
const bool x373 = x372 >= '0';
const bool x374 = x372 <= '9';
const bool x375 = x373 && x374;
if (x375) {
const int x381 = x352;
const bool x382 = x353;
const int x383 = x354;
const char x378 = x372 - '0';
const int x379 = (int)x378;
const int x385 = x381 * 10;
const int x386 = x385 + x379;
x352 = x386;
x353 = false;
const int x376 = x365 + 1;
x354 = x376;
x358 = x376;
} else {
x357 = false;
}
}
}
const int x400 = x352;
const bool x401 = x353;
const int x402 = x354;
bool x405;
if (x401) {
x405 = true;
} else {
x405 = x401;
}
if (x405) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
int x413 = 0;
bool x414 = false;
int x406;
if (x401) {
x406 = x330;
} else {
x406 = x402;
}
int x415 = x406;
int x417 = -1;
bool x418 = true;
int x419 = x406;
for (;;) {
const bool x420 = x418;
const int x421 = x417;
const int x422 = x419;
const bool x423 = x421 != x422;
const bool x424 = x420 && x423;
if (!x424) break;
const int x426 = x419;
x417 = x426;
const bool x428 = x426 >= x8;
if (x428) {
x418 = false;
} else {
const char x432 = x0[x426];
const bool x434 = x432 == '\n';
if (x434) {
x418 = false;
} else {
const int x439 = x413;
const bool x440 = x414;
const int x441 = x415;
const int x443 = x439 + 1;
x413 = x443;
x414 = false;
const int x437 = x426 + 1;
x415 = x437;
x419 = x437;
}
}
}
const int x455 = x413;
const bool x456 = x414;
const int x457 = x415;
const bool x461 = x457 >= x8;
if (x461) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x469 = x0[x457];
const bool x470 = x469 == '\n';
if (x470) {
int x477 = 200;
int x478 = 0;
char* x479 = "close";
bool x480 = false;
bool x481 = false;
bool x483 = false;
const int x471 = x457 + 1;
int x484 = x471;
int x486 = -1;
bool x487 = true;
int x488 = x471;
const int x20 = (int) 0;
ParseResultInt x540(int x503) {
int x505 = x20;
bool x506 = true;
int x507 = x503;
const bool x509 = x503 >= x8;
if (x509) {
x505 = x20;
x506 = true;
x507 = x503;
} else {
const char x514 = x0[x503];
const bool x515 = x514 >= 'a';
const bool x516 = x514 <= 'z';
const bool x517 = x515 && x516;
const bool x518 = x514 >= 'A';
const bool x519 = x514 <= 'Z';
const bool x520 = x518 && x519;
const bool x521 = x517 || x520;
if (x521) {
x505 = x503;
x506 = false;
const int x522 = x503 + 1;
x507 = x522;
} else {
x505 = x20;
x506 = true;
x507 = x503;
}
}
const int x535 = x505;
const bool x536 = x506;
const int x537 = x507;
const ParseResultInt x538 = {x535,x536,x537};
return x538;
}
ParseResultInt x576(int x497) {
int x499 = x20;
bool x500 = true;
int x501 = x497;
const ParseResultInt x541 = x540(x497);
const bool x542 = x541.empty;
if (x542) {
const bool x543 = x497 >= x8;
if (x543) {
x499 = x20;
x500 = true;
x501 = x497;
} else {
const char x548 = x0[x497];
const bool x549 = x548 == '-';
if (x549) {
x499 = x497;
x500 = false;
const int x550 = x497 + 1;
x501 = x550;
} else {
x499 = x20;
x500 = true;
x501 = x497;
}
}
} else {
const int x564 = x541.res;
x499 = x564;
x500 = x542;
const int x567 = x541.next;
x501 = x567;
}
const int x571 = x499;
const bool x572 = x500;
const int x573 = x501;
const ParseResultInt x574 = {x571,x572,x573};
return x574;
}
const char* x824 = "connection";
const int x825 = strlen(x824);
const char* x850 = "proxy-connection";
const int x851 = strlen(x850);
const char* x877 = "keep-alive";
const int x878 = strlen(x877);
const char* x903 = "close";
const int x904 = strlen(x903);
const char* x949 = "content-length";
const int x950 = strlen(x949);
const char* x994 = "transfer-encoding";
const int x995 = strlen(x994);
const char* x1020 = "chunked";
const int x1021 = strlen(x1020);
const char* x1048 = "upgrade";
const int x1049 = strlen(x1048);
for (;;) {
const bool x489 = x487;
const int x490 = x486;
const int x491 = x488;
const bool x492 = x490 != x491;
const bool x493 = x489 && x492;
if (!x493) break;
const int x495 = x488;
x486 = x495;
const bool x577 = x495 >= x8;
if (x577) {
x487 = false;
} else {
const char x585 = x0[x495];
const bool x586 = x585 >= 'a';
const bool x587 = x585 <= 'z';
const bool x588 = x586 && x587;
const bool x589 = x585 >= 'A';
const bool x590 = x585 <= 'Z';
const bool x591 = x589 && x590;
const bool x592 = x588 || x591;
if (x592) {
int x596 = 0;
bool x597 = false;
const int x593 = x495 + 1;
int x598 = x593;
int x600 = -1;
bool x601 = true;
int x602 = x593;
for (;;) {
const bool x603 = x601;
const int x604 = x600;
const int x605 = x602;
const bool x606 = x604 != x605;
const bool x607 = x603 && x606;
if (!x607) break;
const int x609 = x602;
x600 = x609;
const ParseResultInt x611 = x576(x609);
const bool x612 = x611.empty;
if (x612) {
x601 = false;
} else {
const int x615 = x596;
const bool x616 = x597;
const int x617 = x598;
const int x619 = x615 + 1;
x596 = x619;
x597 = false;
const int x620 = x611.next;
x598 = x620;
x602 = x620;
}
}
const int x630 = x596;
const bool x631 = x597;
const int x632 = x598;
char* x642 = "";
bool x643 = false;
int x644 = x632;
int x646 = -1;
bool x647 = true;
int x648 = x632;
for (;;) {
const bool x649 = x647;
const int x650 = x646;
const int x651 = x648;
const bool x652 = x650 != x651;
const bool x653 = x649 && x652;
if (!x653) break;
const int x655 = x648;
x646 = x655;
const bool x657 = x655 >= x8;
if (x657) {
x647 = false;
} else {
const char x661 = x0[x655];
const bool x662 = x661 == ' ';
if (x662) {
const char* x665 = x642;
const bool x666 = x643;
const int x667 = x644;
x642 = (char*)x665;
x643 = false;
const int x663 = x655 + 1;
x644 = x663;
x648 = x663;
} else {
x647 = false;
}
}
}
const char* x682 = x642;
const bool x683 = x643;
const int x684 = x644;
if (x683) {
x487 = false;
} else {
const bool x690 = x684 >= x8;
if (x690) {
x487 = false;
} else {
const char x696 = x0[x684];
const bool x697 = x696 == ':';
if (x697) {
char* x708 = "";
bool x709 = false;
const int x698 = x684 + 1;
int x710 = x698;
int x712 = -1;
bool x713 = true;
int x714 = x698;
for (;;) {
const bool x715 = x713;
const int x716 = x712;
const int x717 = x714;
const bool x718 = x716 != x717;
const bool x719 = x715 && x718;
if (!x719) break;
const int x721 = x714;
x712 = x721;
const bool x723 = x721 >= x8;
if (x723) {
x713 = false;
} else {
const char x727 = x0[x721];
const bool x728 = x727 == ' ';
if (x728) {
const char* x731 = x708;
const bool x732 = x709;
const int x733 = x710;
x708 = (char*)x731;
x709 = false;
const int x729 = x721 + 1;
x710 = x729;
x714 = x729;
} else {
x713 = false;
}
}
}
const char* x748 = x708;
const bool x749 = x709;
const int x750 = x710;
if (x749) {
x487 = false;
} else {
int x756 = 0;
bool x757 = false;
int x758 = x750;
int x760 = -1;
bool x761 = true;
int x762 = x750;
for (;;) {
const bool x763 = x761;
const int x764 = x760;
const int x765 = x762;
const bool x766 = x764 != x765;
const bool x767 = x763 && x766;
if (!x767) break;
const int x769 = x762;
x760 = x769;
const bool x771 = x769 >= x8;
if (x771) {
x761 = false;
} else {
const char x775 = x0[x769];
const bool x777 = x775 == '\n';
if (x777) {
x761 = false;
} else {
const int x782 = x756;
const bool x783 = x757;
const int x784 = x758;
const int x786 = x782 + 1;
x756 = x786;
x757 = false;
const int x780 = x769 + 1;
x758 = x780;
x762 = x780;
}
}
}
const int x798 = x756;
const bool x799 = x757;
const int x800 = x758;
const bool x804 = x800 >= x8;
if (x804) {
x487 = false;
} else {
const char x808 = x0[x800];
const bool x809 = x808 == '\n';
if (x809) {
const int x815 = x477;
const int x816 = x478;
const char* x817 = x479;
const bool x818 = x480;
const bool x819 = x481;
const bool x821 = x483;
const int x822 = x484;
const int x638 = x630 + 1;
const bool x826 = x638 == x825;
bool x849;
if (x826) {
int x827 = 0;
bool x828 = true;
for (;;) {
const int x829 = x827;
const bool x831 = x828;
const bool x830 = x829 < x638;
const bool x832 = x830 && x831;
if (!x832) break;
const int x834 = x827;
const int x835 = x834 + x495;
const char x836 = x0[x835];
const char x837 = x824[x834];
const bool x839 = x836 == x837;
if (x839) {
} else {
x828 = false;
}
const int x843 = x834 + 1;
x827 = x843;
}
const bool x847 = x828;
x849 = x847;
} else {
x849 = false;
}
const bool x852 = x638 == x851;
bool x875;
if (x852) {
int x853 = 0;
bool x854 = true;
for (;;) {
const int x855 = x853;
const bool x857 = x854;
const bool x856 = x855 < x638;
const bool x858 = x856 && x857;
if (!x858) break;
const int x860 = x853;
const int x861 = x860 + x495;
const char x862 = x0[x861];
const char x863 = x850[x860];
const bool x865 = x862 == x863;
if (x865) {
} else {
x854 = false;
}
const int x869 = x860 + 1;
x853 = x869;
}
const bool x873 = x854;
x875 = x873;
} else {
x875 = false;
}
const bool x876 = x849 || x875;
const bool x879 = x798 == x878;
bool x902;
if (x879) {
int x880 = 0;
bool x881 = true;
for (;;) {
const int x882 = x880;
const bool x884 = x881;
const bool x883 = x882 < x798;
const bool x885 = x883 && x884;
if (!x885) break;
const int x887 = x880;
const int x888 = x887 + x750;
const char x889 = x0[x888];
const char x890 = x877[x887];
const bool x892 = x889 == x890;
if (x892) {
} else {
x881 = false;
}
const int x896 = x887 + 1;
x880 = x896;
}
const bool x900 = x881;
x902 = x900;
} else {
x902 = false;
}
const bool x905 = x798 == x904;
bool x928;
if (x905) {
int x906 = 0;
bool x907 = true;
for (;;) {
const int x908 = x906;
const bool x910 = x907;
const bool x909 = x908 < x798;
const bool x911 = x909 && x910;
if (!x911) break;
const int x913 = x906;
const int x914 = x913 + x750;
const char x915 = x0[x914];
const char x916 = x903[x913];
const bool x918 = x915 == x916;
if (x918) {
} else {
x907 = false;
}
const int x922 = x913 + 1;
x906 = x922;
}
const bool x926 = x907;
x928 = x926;
} else {
x928 = false;
}
const bool x929 = x902 || x928;
const bool x930 = x876 && x929;
Anon1323431030 x1088;
if (x930) {
char* x931 = "";
int x932 = 0;
for (;;) {
const int x933 = x932;
const bool x934 = x933 < x798;
if (!x934) break;
const char* x936 = x931;
const int x937 = x932;
const int x938 = x750 + x937;
const char x939 = x0[x938];
const char* x940 = ({ int l1=strlen(x936); char* r=(char*)malloc2(l1+2); memcpy(r,x936,l1); r[l1]=x939; r[l1+2]=0; r; });
x931 = (char*)x940;
const int x942 = x937 + 1;
x932 = x942;
}
const char* x946 = x931;
const Anon1323431030 x947 = {x815,x816,x946,x818,x819};
x1088 = x947;
} else {
const bool x951 = x638 == x950;
bool x974;
if (x951) {
int x952 = 0;
bool x953 = true;
for (;;) {
const int x954 = x952;
const bool x956 = x953;
const bool x955 = x954 < x638;
const bool x957 = x955 && x956;
if (!x957) break;
const int x959 = x952;
const int x960 = x959 + x495;
const char x961 = x0[x960];
const char x962 = x949[x959];
const bool x964 = x961 == x962;
if (x964) {
} else {
x953 = false;
}
const int x968 = x959 + 1;
x952 = x968;
}
const bool x972 = x953;
x974 = x972;
} else {
x974 = false;
}
Anon1323431030 x1087;
if (x974) {
char* x975 = "";
int x976 = 0;
for (;;) {
const int x977 = x976;
const bool x978 = x977 < x798;
if (!x978) break;
const char* x980 = x975;
const int x981 = x976;
const int x982 = x750 + x981;
const char x983 = x0[x982];
const char* x984 = ({ int l1=strlen(x980); char* r=(char*)malloc2(l1+2); memcpy(r,x980,l1); r[l1]=x983; r[l1+2]=0; r; });
x975 = (char*)x984;
const int x986 = x981 + 1;
x976 = x986;
}
const char* x990 = x975;
const int x991 = atoi(x990);
const Anon1323431030 x992 = {x815,x991,x817,x818,x819};
x1087 = x992;
} else {
const bool x996 = x638 == x995;
bool x1019;
if (x996) {
int x997 = 0;
bool x998 = true;
for (;;) {
const int x999 = x997;
const bool x1001 = x998;
const bool x1000 = x999 < x638;
const bool x1002 = x1000 && x1001;
if (!x1002) break;
const int x1004 = x997;
const int x1005 = x1004 + x495;
const char x1006 = x0[x1005];
const char x1007 = x994[x1004];
const bool x1009 = x1006 == x1007;
if (x1009) {
} else {
x998 = false;
}
const int x1013 = x1004 + 1;
x997 = x1013;
}
const bool x1017 = x998;
x1019 = x1017;
} else {
x1019 = false;
}
const bool x1022 = x798 == x1021;
bool x1045;
if (x1022) {
int x1023 = 0;
bool x1024 = true;
for (;;) {
const int x1025 = x1023;
const bool x1027 = x1024;
const bool x1026 = x1025 < x798;
const bool x1028 = x1026 && x1027;
if (!x1028) break;
const int x1030 = x1023;
const int x1031 = x1030 + x750;
const char x1032 = x0[x1031];
const char x1033 = x1020[x1030];
const bool x1035 = x1032 == x1033;
if (x1035) {
} else {
x1024 = false;
}
const int x1039 = x1030 + 1;
x1023 = x1039;
}
const bool x1043 = x1024;
x1045 = x1043;
} else {
x1045 = false;
}
const bool x1046 = x1019 && x1045;
int x1081;
if (x1046) {
x1081 = x815;
} else {
const bool x1050 = x638 == x1049;
bool x1073;
if (x1050) {
int x1051 = 0;
bool x1052 = true;
for (;;) {
const int x1053 = x1051;
const bool x1055 = x1052;
const bool x1054 = x1053 < x638;
const bool x1056 = x1054 && x1055;
if (!x1056) break;
const int x1058 = x1051;
const int x1059 = x1058 + x495;
const char x1060 = x0[x1059];
const char x1061 = x1048[x1058];
const bool x1063 = x1060 == x1061;
if (x1063) {
} else {
x1052 = false;
}
const int x1067 = x1058 + 1;
x1051 = x1067;
}
const bool x1071 = x1052;
x1073 = x1071;
} else {
x1073 = false;
}
int x1075;
if (x1073) {
x1075 = x815;
} else {
x1075 = x815;
}
x1081 = x1075;
}
int x1082;
if (x1046) {
x1082 = x816;
} else {
const bool x1050 = x638 == x1049;
bool x1073;
if (x1050) {
int x1051 = 0;
bool x1052 = true;
for (;;) {
const int x1053 = x1051;
const bool x1055 = x1052;
const bool x1054 = x1053 < x638;
const bool x1056 = x1054 && x1055;
if (!x1056) break;
const int x1058 = x1051;
const int x1059 = x1058 + x495;
const char x1060 = x0[x1059];
const char x1061 = x1048[x1058];
const bool x1063 = x1060 == x1061;
if (x1063) {
} else {
x1052 = false;
}
const int x1067 = x1058 + 1;
x1051 = x1067;
}
const bool x1071 = x1052;
x1073 = x1071;
} else {
x1073 = false;
}
int x1076;
if (x1073) {
x1076 = x816;
} else {
x1076 = x816;
}
x1082 = x1076;
}
char* x1083;
if (x1046) {
x1083 = (char*)x817;
} else {
const bool x1050 = x638 == x1049;
bool x1073;
if (x1050) {
int x1051 = 0;
bool x1052 = true;
for (;;) {
const int x1053 = x1051;
const bool x1055 = x1052;
const bool x1054 = x1053 < x638;
const bool x1056 = x1054 && x1055;
if (!x1056) break;
const int x1058 = x1051;
const int x1059 = x1058 + x495;
const char x1060 = x0[x1059];
const char x1061 = x1048[x1058];
const bool x1063 = x1060 == x1061;
if (x1063) {
} else {
x1052 = false;
}
const int x1067 = x1058 + 1;
x1051 = x1067;
}
const bool x1071 = x1052;
x1073 = x1071;
} else {
x1073 = false;
}
char* x1077;
if (x1073) {
x1077 = (char*)x817;
} else {
x1077 = (char*)x817;
}
x1083 = x1077;
}
bool x1084;
if (x1046) {
x1084 = true;
} else {
const bool x1050 = x638 == x1049;
bool x1073;
if (x1050) {
int x1051 = 0;
bool x1052 = true;
for (;;) {
const int x1053 = x1051;
const bool x1055 = x1052;
const bool x1054 = x1053 < x638;
const bool x1056 = x1054 && x1055;
if (!x1056) break;
const int x1058 = x1051;
const int x1059 = x1058 + x495;
const char x1060 = x0[x1059];
const char x1061 = x1048[x1058];
const bool x1063 = x1060 == x1061;
if (x1063) {
} else {
x1052 = false;
}
const int x1067 = x1058 + 1;
x1051 = x1067;
}
const bool x1071 = x1052;
x1073 = x1071;
} else {
x1073 = false;
}
bool x1078;
if (x1073) {
x1078 = x818;
} else {
x1078 = x818;
}
x1084 = x1078;
}
bool x1085;
if (x1046) {
x1085 = x819;
} else {
const bool x1050 = x638 == x1049;
bool x1073;
if (x1050) {
int x1051 = 0;
bool x1052 = true;
for (;;) {
const int x1053 = x1051;
const bool x1055 = x1052;
const bool x1054 = x1053 < x638;
const bool x1056 = x1054 && x1055;
if (!x1056) break;
const int x1058 = x1051;
const int x1059 = x1058 + x495;
const char x1060 = x0[x1059];
const char x1061 = x1048[x1058];
const bool x1063 = x1060 == x1061;
if (x1063) {
} else {
x1052 = false;
}
const int x1067 = x1058 + 1;
x1051 = x1067;
}
const bool x1071 = x1052;
x1073 = x1071;
} else {
x1073 = false;
}
bool x1079;
if (x1073) {
x1079 = true;
} else {
x1079 = x819;
}
x1085 = x1079;
}
const Anon1323431030 x1086 = {x1081,x1082,x1083,x1084,x1085};
x1087 = x1086;
}
x1088 = x1087;
}
const int x1090 = x1088.status;
x477 = x1090;
const int x1092 = x1088.contentLength;
x478 = x1092;
const char* x1094 = x1088.connection;
x479 = (char*)x1094;
const bool x1096 = x1088.chunked;
x480 = x1096;
const bool x1098 = x1088.upgrade;
x481 = x1098;
x483 = false;
const int x810 = x800 + 1;
x484 = x810;
x488 = x810;
} else {
x487 = false;
}
}
}
} else {
x487 = false;
}
}
}
} else {
x487 = false;
}
}
}
const int x1127 = x477;
const int x1128 = x478;
const char* x1129 = x479;
const bool x1130 = x480;
const bool x1131 = x481;
const bool x1133 = x483;
const int x1134 = x484;
bool x1139;
if (x1133) {
x1139 = true;
} else {
x1139 = false;
}
if (x1139) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
int x1140;
if (x1133) {
x1140 = 0;
} else {
x1140 = x1134;
}
const bool x1147 = x1140 >= x8;
if (x1147) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x1153 = x0[x1140];
const bool x1154 = x1153 == '\n';
if (x1154) {
const int x1155 = x1140 + 1;
Tuple2IntAnon1323431030 x1138;
if (x1133) {
const Tuple2IntAnon1323431030 x22 = {};
x1138 = x22;
} else {
int x404;
if (x401) {
x404 = x20;
} else {
x404 = x400;
}
const Anon1323431030 x1132 = {x1127,x1128,x1129,x1130,x1131};
const Tuple2IntAnon1323431030 x1136 = {x404,x1132};
x1138 = x1136;
}
const Anon1323431030 x1159 = x1138._2;
const int x1160 = x1159.contentLength;
const int x1166 = x1155 + x1160;
const bool x1167 = x1166 < x8;
if (x1167) {
const int x1158 = x1138._1;
const char* x1161 = x1159.connection;
const bool x1162 = x1159.chunked;
const bool x1163 = x1159.upgrade;
const Anon1323431030 x1164 = {x1158,x1160,x1161,x1162,x1163};
const Anon1680061013 x1168 = {x0,x1155,x1166};
const char* x1169 = ({ char* r=(char*)malloc2(x1168.length+1); memcpy(r,x1168.input+x1168.start,x1168.length); r[x1168.length]=0; r; });
const Tuple2Anon1323431030String x1171 = {x1164,x1169};
x3 = x1171;
x4 = false;
x5 = x1160;
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
} else {
x3 = x1;
x4 = true;
x5 = 0;
}
}
const Tuple2Anon1323431030String x1282 = x3;
const bool x1283 = x4;
const int x1284 = x5;
const ParseResultTuple2Anon1323431030String x1285 = {x1282,x1283,x1284};
//printf("%s\n",x1285);
return x1285;
}
/*****************************************
  End of C Generated Code
*******************************************/
