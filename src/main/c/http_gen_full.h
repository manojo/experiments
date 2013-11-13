#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>



typedef struct{
int status;
int contentLength;
char* connection;
bool chunked;
bool upgrade;
} Anon1323431030;

typedef struct{
char* input;
int start;
int length;
} Anon1680061013;

typedef struct{
int res;
bool empty;
int next;
} ParseResultInt;

typedef struct{
Anon1323431030 _1;
Anon1680061013 _2;
} Tuple2Anon1323431030Anon1680061013;

typedef struct{
Tuple2Anon1323431030Anon1680061013 res;
bool empty;
int next;
} ParseResultTuple2Anon1323431030Anon1680061013;

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
ParseResultTuple2Anon1323431030Anon1680061013 respAndMessageParse(char* x0) {
Tuple2Anon1323431030Anon1680061013 x2 = (Tuple2Anon1323431030Anon1680061013){};
bool x3 = true;
int x4 = -1;
const int x7 = strlen(x0);
const bool x8 = 0 >= x7;
if (x8) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x22 = x0[0];
const bool x23 = x22 == 'H';
if (x23) {
const int x24 = 0 + 1;
const bool x26 = x24 >= x7;
if (x26) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x34 = x0[x24];
const bool x35 = x34 == 'T';
if (x35) {
const int x36 = x24 + 1;
const bool x38 = x36 >= x7;
if (x38) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x46 = x0[x36];
const bool x47 = x46 == 'T';
if (x47) {
const int x48 = x36 + 1;
const bool x50 = x48 >= x7;
if (x50) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x58 = x0[x48];
const bool x59 = x58 == 'P';
if (x59) {
const int x60 = x48 + 1;
const bool x62 = x60 >= x7;
if (x62) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x70 = x0[x60];
const bool x71 = x70 == '/';
if (x71) {
const int x72 = x60 + 1;
const bool x95 = x72 >= x7;
if (x95) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x103 = x0[x72];
const bool x104 = x103 >= '0';
const bool x105 = x103 <= '9';
const bool x106 = x104 && x105;
if (x106) {
const char x109 = x103 - '0';
const int x110 = (int)x109;
int x112 = x110;
bool x113 = false;
const int x107 = x72 + 1;
int x114 = x107;
int x116 = -1;
bool x117 = true;
int x118 = x107;
for (;;) {
const bool x119 = x117;
const int x120 = x116;
const int x121 = x118;
const bool x122 = x120 != x121;
const bool x123 = x119 && x122;
if (!x123) break;
const int x125 = x118;
x116 = x125;
const bool x127 = x125 >= x7;
if (x127) {
x117 = false;
} else {
const char x132 = x0[x125];
const bool x133 = x132 >= '0';
const bool x134 = x132 <= '9';
const bool x135 = x133 && x134;
if (x135) {
const int x141 = x112;
const bool x142 = x113;
const int x143 = x114;
const char x138 = x132 - '0';
const int x139 = (int)x138;
const int x145 = x141 * 10;
const int x146 = x145 + x139;
x112 = x146;
x113 = false;
const int x136 = x125 + 1;
x114 = x136;
x118 = x136;
} else {
x117 = false;
}
}
}
const int x160 = x112;
const bool x161 = x113;
const int x162 = x114;
bool x165;
if (x161) {
x165 = true;
} else {
x165 = x161;
}
if (x165) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
int x166;
if (x161) {
x166 = x72;
} else {
x166 = x162;
}
const bool x172 = x166 >= x7;
if (x172) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x179 = x0[x166];
const bool x180 = x179 == '.';
if (x180) {
const int x181 = x166 + 1;
const bool x183 = x181 >= x7;
if (x183) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x190 = x0[x181];
const bool x191 = x190 >= '0';
const bool x192 = x190 <= '9';
const bool x193 = x191 && x192;
if (x193) {
const char x196 = x190 - '0';
const int x197 = (int)x196;
int x199 = x197;
bool x200 = false;
const int x194 = x181 + 1;
int x201 = x194;
int x203 = -1;
bool x204 = true;
int x205 = x194;
for (;;) {
const bool x206 = x204;
const int x207 = x203;
const int x208 = x205;
const bool x209 = x207 != x208;
const bool x210 = x206 && x209;
if (!x210) break;
const int x212 = x205;
x203 = x212;
const bool x214 = x212 >= x7;
if (x214) {
x204 = false;
} else {
const char x219 = x0[x212];
const bool x220 = x219 >= '0';
const bool x221 = x219 <= '9';
const bool x222 = x220 && x221;
if (x222) {
const int x228 = x199;
const bool x229 = x200;
const int x230 = x201;
const char x225 = x219 - '0';
const int x226 = (int)x225;
const int x232 = x228 * 10;
const int x233 = x232 + x226;
x199 = x233;
x200 = false;
const int x223 = x212 + 1;
x201 = x223;
x205 = x223;
} else {
x204 = false;
}
}
}
const int x247 = x199;
const bool x248 = x200;
const int x249 = x201;
bool x252;
if (x248) {
x252 = true;
} else {
x252 = x248;
}
bool x258;
if (x252) {
x258 = true;
} else {
x258 = false;
}
bool x264;
if (x258) {
x264 = true;
} else {
x264 = false;
}
if (x264) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
char* x272 = "";
bool x273 = false;
int x265;
if (x258) {
x265 = 0;
} else {
int x259;
if (x252) {
x259 = x72;
} else {
int x253;
if (x248) {
x253 = x181;
} else {
x253 = x249;
}
x259 = x253;
}
x265 = x259;
}
int x274 = x265;
int x276 = -1;
bool x277 = true;
int x278 = x265;
for (;;) {
const bool x279 = x277;
const int x280 = x276;
const int x281 = x278;
const bool x282 = x280 != x281;
const bool x283 = x279 && x282;
if (!x283) break;
const int x285 = x278;
x276 = x285;
const bool x287 = x285 >= x7;
if (x287) {
x277 = false;
} else {
const char x291 = x0[x285];
const bool x292 = x291 == ' ';
if (x292) {
const char* x295 = x272;
const bool x296 = x273;
const int x297 = x274;
x272 = (char*)x295;
x273 = false;
const int x293 = x285 + 1;
x274 = x293;
x278 = x293;
} else {
x277 = false;
}
}
}
const char* x312 = x272;
const bool x313 = x273;
const int x314 = x274;
bool x319;
if (x313) {
x319 = true;
} else {
x319 = false;
}
if (x319) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
int x320;
if (x313) {
x320 = 0;
} else {
x320 = x314;
}
const bool x326 = x320 >= x7;
if (x326) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x333 = x0[x320];
const bool x334 = x333 >= '0';
const bool x335 = x333 <= '9';
const bool x336 = x334 && x335;
if (x336) {
const char x339 = x333 - '0';
const int x340 = (int)x339;
int x342 = x340;
bool x343 = false;
const int x337 = x320 + 1;
int x344 = x337;
int x346 = -1;
bool x347 = true;
int x348 = x337;
for (;;) {
const bool x349 = x347;
const int x350 = x346;
const int x351 = x348;
const bool x352 = x350 != x351;
const bool x353 = x349 && x352;
if (!x353) break;
const int x355 = x348;
x346 = x355;
const bool x357 = x355 >= x7;
if (x357) {
x347 = false;
} else {
const char x362 = x0[x355];
const bool x363 = x362 >= '0';
const bool x364 = x362 <= '9';
const bool x365 = x363 && x364;
if (x365) {
const int x371 = x342;
const bool x372 = x343;
const int x373 = x344;
const char x368 = x362 - '0';
const int x369 = (int)x368;
const int x375 = x371 * 10;
const int x376 = x375 + x369;
x342 = x376;
x343 = false;
const int x366 = x355 + 1;
x344 = x366;
x348 = x366;
} else {
x347 = false;
}
}
}
const int x390 = x342;
const bool x391 = x343;
const int x392 = x344;
bool x395;
if (x391) {
x395 = true;
} else {
x395 = x391;
}
if (x395) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
int x403 = 0;
bool x404 = false;
int x396;
if (x391) {
x396 = x320;
} else {
x396 = x392;
}
int x405 = x396;
int x407 = -1;
bool x408 = true;
int x409 = x396;
for (;;) {
const bool x410 = x408;
const int x411 = x407;
const int x412 = x409;
const bool x413 = x411 != x412;
const bool x414 = x410 && x413;
if (!x414) break;
const int x416 = x409;
x407 = x416;
const bool x418 = x416 >= x7;
if (x418) {
x408 = false;
} else {
const char x422 = x0[x416];
const bool x424 = x422 == '\n';
if (x424) {
x408 = false;
} else {
const int x429 = x403;
const bool x430 = x404;
const int x431 = x405;
const int x433 = x429 + 1;
x403 = x433;
x404 = false;
const int x427 = x416 + 1;
x405 = x427;
x409 = x427;
}
}
}
const int x445 = x403;
const bool x446 = x404;
const int x447 = x405;
const bool x451 = x447 >= x7;
if (x451) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x458 = x0[x447];
const bool x459 = x458 == '\n';
if (x459) {
int x466 = 200;
int x467 = 0;
char* x468 = "close";
bool x469 = false;
bool x470 = false;
bool x472 = false;
const int x460 = x447 + 1;
int x473 = x460;
int x475 = -1;
bool x476 = true;
int x477 = x460;
ParseResultInt x529(int x492) {
int x494 = 0;
bool x495 = true;
int x496 = x492;
const bool x498 = x492 >= x7;
if (x498) {
x494 = 0;
x495 = true;
x496 = x492;
} else {
const char x503 = x0[x492];
const bool x504 = x503 >= 'a';
const bool x505 = x503 <= 'z';
const bool x506 = x504 && x505;
const bool x507 = x503 >= 'A';
const bool x508 = x503 <= 'Z';
const bool x509 = x507 && x508;
const bool x510 = x506 || x509;
if (x510) {
x494 = x492;
x495 = false;
const int x511 = x492 + 1;
x496 = x511;
} else {
x494 = 0;
x495 = true;
x496 = x492;
}
}
const int x524 = x494;
const bool x525 = x495;
const int x526 = x496;
const ParseResultInt x527 = {x524,x525,x526};
return x527;
}
ParseResultInt x565(int x486) {
int x488 = 0;
bool x489 = true;
int x490 = x486;
const ParseResultInt x530 = x529(x486);
const bool x531 = x530.empty;
if (x531) {
const bool x532 = x486 >= x7;
if (x532) {
x488 = 0;
x489 = true;
x490 = x486;
} else {
const char x537 = x0[x486];
const bool x538 = x537 == '-';
if (x538) {
x488 = x486;
x489 = false;
const int x539 = x486 + 1;
x490 = x539;
} else {
x488 = 0;
x489 = true;
x490 = x486;
}
}
} else {
const int x553 = x530.res;
x488 = x553;
x489 = x531;
const int x556 = x530.next;
x490 = x556;
}
const int x560 = x488;
const bool x561 = x489;
const int x562 = x490;
const ParseResultInt x563 = {x560,x561,x562};
return x563;
}
const char* x811 = "connection";
const int x812 = strlen(x811);
const char* x840 = "proxy-connection";
const int x841 = strlen(x840);
const char* x870 = "keep-alive";
const int x871 = strlen(x870);
const char* x899 = "close";
const int x900 = strlen(x899);
const char* x932 = "content-length";
const int x933 = strlen(x932);
const char* x963 = "transfer-encoding";
const int x964 = strlen(x963);
const char* x992 = "chunked";
const int x993 = strlen(x992);
const char* x1023 = "upgrade";
const int x1024 = strlen(x1023);
for (;;) {
const bool x478 = x476;
const int x479 = x475;
const int x480 = x477;
const bool x481 = x479 != x480;
const bool x482 = x478 && x481;
if (!x482) break;
const int x484 = x477;
x475 = x484;
const bool x566 = x484 >= x7;
if (x566) {
x476 = false;
} else {
const char x573 = x0[x484];
const bool x574 = x573 >= 'a';
const bool x575 = x573 <= 'z';
const bool x576 = x574 && x575;
const bool x577 = x573 >= 'A';
const bool x578 = x573 <= 'Z';
const bool x579 = x577 && x578;
const bool x580 = x576 || x579;
if (x580) {
int x584 = 0;
bool x585 = false;
const int x581 = x484 + 1;
int x586 = x581;
int x588 = -1;
bool x589 = true;
int x590 = x581;
for (;;) {
const bool x591 = x589;
const int x592 = x588;
const int x593 = x590;
const bool x594 = x592 != x593;
const bool x595 = x591 && x594;
if (!x595) break;
const int x597 = x590;
x588 = x597;
const ParseResultInt x599 = x565(x597);
const bool x600 = x599.empty;
if (x600) {
x589 = false;
} else {
const int x603 = x584;
const bool x604 = x585;
const int x605 = x586;
const int x607 = x603 + 1;
x584 = x607;
x585 = false;
const int x608 = x599.next;
x586 = x608;
x590 = x608;
}
}
const int x618 = x584;
const bool x619 = x585;
const int x620 = x586;
char* x630 = "";
bool x631 = false;
int x632 = x620;
int x634 = -1;
bool x635 = true;
int x636 = x620;
for (;;) {
const bool x637 = x635;
const int x638 = x634;
const int x639 = x636;
const bool x640 = x638 != x639;
const bool x641 = x637 && x640;
if (!x641) break;
const int x643 = x636;
x634 = x643;
const bool x645 = x643 >= x7;
if (x645) {
x635 = false;
} else {
const char x649 = x0[x643];
const bool x650 = x649 == ' ';
if (x650) {
const char* x653 = x630;
const bool x654 = x631;
const int x655 = x632;
x630 = (char*)x653;
x631 = false;
const int x651 = x643 + 1;
x632 = x651;
x636 = x651;
} else {
x635 = false;
}
}
}
const char* x670 = x630;
const bool x671 = x631;
const int x672 = x632;
if (x671) {
x476 = false;
} else {
const bool x677 = x672 >= x7;
if (x677) {
x476 = false;
} else {
const char x683 = x0[x672];
const bool x684 = x683 == ':';
if (x684) {
char* x695 = "";
bool x696 = false;
const int x685 = x672 + 1;
int x697 = x685;
int x699 = -1;
bool x700 = true;
int x701 = x685;
for (;;) {
const bool x702 = x700;
const int x703 = x699;
const int x704 = x701;
const bool x705 = x703 != x704;
const bool x706 = x702 && x705;
if (!x706) break;
const int x708 = x701;
x699 = x708;
const bool x710 = x708 >= x7;
if (x710) {
x700 = false;
} else {
const char x714 = x0[x708];
const bool x715 = x714 == ' ';
if (x715) {
const char* x718 = x695;
const bool x719 = x696;
const int x720 = x697;
x695 = (char*)x718;
x696 = false;
const int x716 = x708 + 1;
x697 = x716;
x701 = x716;
} else {
x700 = false;
}
}
}
const char* x735 = x695;
const bool x736 = x696;
const int x737 = x697;
if (x736) {
x476 = false;
} else {
int x743 = 0;
bool x744 = false;
int x745 = x737;
int x747 = -1;
bool x748 = true;
int x749 = x737;
for (;;) {
const bool x750 = x748;
const int x751 = x747;
const int x752 = x749;
const bool x753 = x751 != x752;
const bool x754 = x750 && x753;
if (!x754) break;
const int x756 = x749;
x747 = x756;
const bool x758 = x756 >= x7;
if (x758) {
x748 = false;
} else {
const char x762 = x0[x756];
const bool x764 = x762 == '\n';
if (x764) {
x748 = false;
} else {
const int x769 = x743;
const bool x770 = x744;
const int x771 = x745;
const int x773 = x769 + 1;
x743 = x773;
x744 = false;
const int x767 = x756 + 1;
x745 = x767;
x749 = x767;
}
}
}
const int x785 = x743;
const bool x786 = x744;
const int x787 = x745;
const bool x791 = x787 >= x7;
if (x791) {
x476 = false;
} else {
const char x795 = x0[x787];
const bool x796 = x795 == '\n';
if (x796) {
const int x802 = x466;
const int x803 = x467;
const char* x804 = x468;
const bool x805 = x469;
const bool x806 = x470;
const bool x808 = x472;
const int x809 = x473;
const int x626 = x618 + 1;
const bool x813 = x626 == x812;
bool x839;
if (x813) {
int x814 = 0;
bool x815 = true;
for (;;) {
const int x816 = x814;
const bool x818 = x815;
const bool x817 = x816 < x626;
const bool x819 = x817 && x818;
if (!x819) break;
const int x821 = x814;
const int x822 = x821 + x484;
const char x823 = x0[x822];
const int x824 = (int)x823;
const int x825 = x824 | 32;
const char x826 = (char)x825;
const char x827 = x811[x821];
const bool x829 = x826 == x827;
if (x829) {
} else {
x815 = false;
}
const int x833 = x821 + 1;
x814 = x833;
}
const bool x837 = x815;
x839 = x837;
} else {
x839 = false;
}
const bool x842 = x626 == x841;
bool x868;
if (x842) {
int x843 = 0;
bool x844 = true;
for (;;) {
const int x845 = x843;
const bool x847 = x844;
const bool x846 = x845 < x626;
const bool x848 = x846 && x847;
if (!x848) break;
const int x850 = x843;
const int x851 = x850 + x484;
const char x852 = x0[x851];
const int x853 = (int)x852;
const int x854 = x853 | 32;
const char x855 = (char)x854;
const char x856 = x840[x850];
const bool x858 = x855 == x856;
if (x858) {
} else {
x844 = false;
}
const int x862 = x850 + 1;
x843 = x862;
}
const bool x866 = x844;
x868 = x866;
} else {
x868 = false;
}
const bool x869 = x839 || x868;
const bool x872 = x785 == x871;
bool x898;
if (x872) {
int x873 = 0;
bool x874 = true;
for (;;) {
const int x875 = x873;
const bool x877 = x874;
const bool x876 = x875 < x785;
const bool x878 = x876 && x877;
if (!x878) break;
const int x880 = x873;
const int x881 = x880 + x737;
const char x882 = x0[x881];
const int x883 = (int)x882;
const int x884 = x883 | 32;
const char x885 = (char)x884;
const char x886 = x870[x880];
const bool x888 = x885 == x886;
if (x888) {
} else {
x874 = false;
}
const int x892 = x880 + 1;
x873 = x892;
}
const bool x896 = x874;
x898 = x896;
} else {
x898 = false;
}
const bool x901 = x785 == x900;
bool x927;
if (x901) {
int x902 = 0;
bool x903 = true;
for (;;) {
const int x904 = x902;
const bool x906 = x903;
const bool x905 = x904 < x785;
const bool x907 = x905 && x906;
if (!x907) break;
const int x909 = x902;
const int x910 = x909 + x737;
const char x911 = x0[x910];
const int x912 = (int)x911;
const int x913 = x912 | 32;
const char x914 = (char)x913;
const char x915 = x899[x909];
const bool x917 = x914 == x915;
if (x917) {
} else {
x903 = false;
}
const int x921 = x909 + 1;
x902 = x921;
}
const bool x925 = x903;
x927 = x925;
} else {
x927 = false;
}
const bool x928 = x898 || x927;
const bool x929 = x869 && x928;
int x1071;
if (x929) {
x1071 = x802;
} else {
const bool x934 = x626 == x933;
bool x960;
if (x934) {
int x935 = 0;
bool x936 = true;
for (;;) {
const int x937 = x935;
const bool x939 = x936;
const bool x938 = x937 < x626;
const bool x940 = x938 && x939;
if (!x940) break;
const int x942 = x935;
const int x943 = x942 + x484;
const char x944 = x0[x943];
const int x945 = (int)x944;
const int x946 = x945 | 32;
const char x947 = (char)x946;
const char x948 = x932[x942];
const bool x950 = x947 == x948;
if (x950) {
} else {
x936 = false;
}
const int x954 = x942 + 1;
x935 = x954;
}
const bool x958 = x936;
x960 = x958;
} else {
x960 = false;
}
int x1065;
if (x960) {
x1065 = x802;
} else {
const bool x965 = x626 == x964;
bool x991;
if (x965) {
int x966 = 0;
bool x967 = true;
for (;;) {
const int x968 = x966;
const bool x970 = x967;
const bool x969 = x968 < x626;
const bool x971 = x969 && x970;
if (!x971) break;
const int x973 = x966;
const int x974 = x973 + x484;
const char x975 = x0[x974];
const int x976 = (int)x975;
const int x977 = x976 | 32;
const char x978 = (char)x977;
const char x979 = x963[x973];
const bool x981 = x978 == x979;
if (x981) {
} else {
x967 = false;
}
const int x985 = x973 + 1;
x966 = x985;
}
const bool x989 = x967;
x991 = x989;
} else {
x991 = false;
}
const bool x994 = x785 == x993;
bool x1020;
if (x994) {
int x995 = 0;
bool x996 = true;
for (;;) {
const int x997 = x995;
const bool x999 = x996;
const bool x998 = x997 < x785;
const bool x1000 = x998 && x999;
if (!x1000) break;
const int x1002 = x995;
const int x1003 = x1002 + x737;
const char x1004 = x0[x1003];
const int x1005 = (int)x1004;
const int x1006 = x1005 | 32;
const char x1007 = (char)x1006;
const char x1008 = x992[x1002];
const bool x1010 = x1007 == x1008;
if (x1010) {
} else {
x996 = false;
}
const int x1014 = x1002 + 1;
x995 = x1014;
}
const bool x1018 = x996;
x1020 = x1018;
} else {
x1020 = false;
}
const bool x1021 = x991 && x1020;
int x1059;
if (x1021) {
x1059 = x802;
} else {
const bool x1025 = x626 == x1024;
bool x1051;
if (x1025) {
int x1026 = 0;
bool x1027 = true;
for (;;) {
const int x1028 = x1026;
const bool x1030 = x1027;
const bool x1029 = x1028 < x626;
const bool x1031 = x1029 && x1030;
if (!x1031) break;
const int x1033 = x1026;
const int x1034 = x1033 + x484;
const char x1035 = x0[x1034];
const int x1036 = (int)x1035;
const int x1037 = x1036 | 32;
const char x1038 = (char)x1037;
const char x1039 = x1023[x1033];
const bool x1041 = x1038 == x1039;
if (x1041) {
} else {
x1027 = false;
}
const int x1045 = x1033 + 1;
x1026 = x1045;
}
const bool x1049 = x1027;
x1051 = x1049;
} else {
x1051 = false;
}
int x1053;
if (x1051) {
x1053 = x802;
} else {
x1053 = x802;
}
x1059 = x1053;
}
x1065 = x1059;
}
x1071 = x1065;
}
x466 = x1071;
int x1072;
if (x929) {
x1072 = x803;
} else {
const bool x934 = x626 == x933;
bool x960;
if (x934) {
int x935 = 0;
bool x936 = true;
for (;;) {
const int x937 = x935;
const bool x939 = x936;
const bool x938 = x937 < x626;
const bool x940 = x938 && x939;
if (!x940) break;
const int x942 = x935;
const int x943 = x942 + x484;
const char x944 = x0[x943];
const int x945 = (int)x944;
const int x946 = x945 | 32;
const char x947 = (char)x946;
const char x948 = x932[x942];
const bool x950 = x947 == x948;
if (x950) {
} else {
x936 = false;
}
const int x954 = x942 + 1;
x935 = x954;
}
const bool x958 = x936;
x960 = x958;
} else {
x960 = false;
}
int x1066;
if (x960) {
const Anon1680061013 x789 = {x0,x737,x785};

/* BAD FIX:
const char* x930 = ({ char* r=(char*)malloc(x789.length+1); memcpy(r,x789.input+x789.start,x789.length); r[x789.length]=0; printf("Malloc1 -> %s\n",r); r; });
const int x961 = atoi(x930);
*/
const int x961 = atoi(x789.input+x789.start);

x1066 = x961;
} else {
const bool x965 = x626 == x964;
bool x991;
if (x965) {
int x966 = 0;
bool x967 = true;
for (;;) {
const int x968 = x966;
const bool x970 = x967;
const bool x969 = x968 < x626;
const bool x971 = x969 && x970;
if (!x971) break;
const int x973 = x966;
const int x974 = x973 + x484;
const char x975 = x0[x974];
const int x976 = (int)x975;
const int x977 = x976 | 32;
const char x978 = (char)x977;
const char x979 = x963[x973];
const bool x981 = x978 == x979;
if (x981) {
} else {
x967 = false;
}
const int x985 = x973 + 1;
x966 = x985;
}
const bool x989 = x967;
x991 = x989;
} else {
x991 = false;
}
const bool x994 = x785 == x993;
bool x1020;
if (x994) {
int x995 = 0;
bool x996 = true;
for (;;) {
const int x997 = x995;
const bool x999 = x996;
const bool x998 = x997 < x785;
const bool x1000 = x998 && x999;
if (!x1000) break;
const int x1002 = x995;
const int x1003 = x1002 + x737;
const char x1004 = x0[x1003];
const int x1005 = (int)x1004;
const int x1006 = x1005 | 32;
const char x1007 = (char)x1006;
const char x1008 = x992[x1002];
const bool x1010 = x1007 == x1008;
if (x1010) {
} else {
x996 = false;
}
const int x1014 = x1002 + 1;
x995 = x1014;
}
const bool x1018 = x996;
x1020 = x1018;
} else {
x1020 = false;
}
const bool x1021 = x991 && x1020;
int x1060;
if (x1021) {
x1060 = x803;
} else {
const bool x1025 = x626 == x1024;
bool x1051;
if (x1025) {
int x1026 = 0;
bool x1027 = true;
for (;;) {
const int x1028 = x1026;
const bool x1030 = x1027;
const bool x1029 = x1028 < x626;
const bool x1031 = x1029 && x1030;
if (!x1031) break;
const int x1033 = x1026;
const int x1034 = x1033 + x484;
const char x1035 = x0[x1034];
const int x1036 = (int)x1035;
const int x1037 = x1036 | 32;
const char x1038 = (char)x1037;
const char x1039 = x1023[x1033];
const bool x1041 = x1038 == x1039;
if (x1041) {
} else {
x1027 = false;
}
const int x1045 = x1033 + 1;
x1026 = x1045;
}
const bool x1049 = x1027;
x1051 = x1049;
} else {
x1051 = false;
}
int x1054;
if (x1051) {
x1054 = x803;
} else {
x1054 = x803;
}
x1060 = x1054;
}
x1066 = x1060;
}
x1072 = x1066;
}
x467 = x1072;
char* x1073;
if (x929) {
const Anon1680061013 x789 = {x0,x737,x785};
const char* x930 = ({ char* r=(char*)malloc(x789.length+1); memcpy(r,x789.input+x789.start,x789.length); r[x789.length]=0; printf("Malloc2 -> %s\n",r); r; });
x1073 = (char*)x930;
} else {
const bool x934 = x626 == x933;
bool x960;
if (x934) {
int x935 = 0;
bool x936 = true;
for (;;) {
const int x937 = x935;
const bool x939 = x936;
const bool x938 = x937 < x626;
const bool x940 = x938 && x939;
if (!x940) break;
const int x942 = x935;
const int x943 = x942 + x484;
const char x944 = x0[x943];
const int x945 = (int)x944;
const int x946 = x945 | 32;
const char x947 = (char)x946;
const char x948 = x932[x942];
const bool x950 = x947 == x948;
if (x950) {
} else {
x936 = false;
}
const int x954 = x942 + 1;
x935 = x954;
}
const bool x958 = x936;
x960 = x958;
} else {
x960 = false;
}
char* x1067;
if (x960) {
x1067 = (char*)x804;
} else {
const bool x965 = x626 == x964;
bool x991;
if (x965) {
int x966 = 0;
bool x967 = true;
for (;;) {
const int x968 = x966;
const bool x970 = x967;
const bool x969 = x968 < x626;
const bool x971 = x969 && x970;
if (!x971) break;
const int x973 = x966;
const int x974 = x973 + x484;
const char x975 = x0[x974];
const int x976 = (int)x975;
const int x977 = x976 | 32;
const char x978 = (char)x977;
const char x979 = x963[x973];
const bool x981 = x978 == x979;
if (x981) {
} else {
x967 = false;
}
const int x985 = x973 + 1;
x966 = x985;
}
const bool x989 = x967;
x991 = x989;
} else {
x991 = false;
}
const bool x994 = x785 == x993;
bool x1020;
if (x994) {
int x995 = 0;
bool x996 = true;
for (;;) {
const int x997 = x995;
const bool x999 = x996;
const bool x998 = x997 < x785;
const bool x1000 = x998 && x999;
if (!x1000) break;
const int x1002 = x995;
const int x1003 = x1002 + x737;
const char x1004 = x0[x1003];
const int x1005 = (int)x1004;
const int x1006 = x1005 | 32;
const char x1007 = (char)x1006;
const char x1008 = x992[x1002];
const bool x1010 = x1007 == x1008;
if (x1010) {
} else {
x996 = false;
}
const int x1014 = x1002 + 1;
x995 = x1014;
}
const bool x1018 = x996;
x1020 = x1018;
} else {
x1020 = false;
}
const bool x1021 = x991 && x1020;
char* x1061;
if (x1021) {
x1061 = (char*)x804;
} else {
const bool x1025 = x626 == x1024;
bool x1051;
if (x1025) {
int x1026 = 0;
bool x1027 = true;
for (;;) {
const int x1028 = x1026;
const bool x1030 = x1027;
const bool x1029 = x1028 < x626;
const bool x1031 = x1029 && x1030;
if (!x1031) break;
const int x1033 = x1026;
const int x1034 = x1033 + x484;
const char x1035 = x0[x1034];
const int x1036 = (int)x1035;
const int x1037 = x1036 | 32;
const char x1038 = (char)x1037;
const char x1039 = x1023[x1033];
const bool x1041 = x1038 == x1039;
if (x1041) {
} else {
x1027 = false;
}
const int x1045 = x1033 + 1;
x1026 = x1045;
}
const bool x1049 = x1027;
x1051 = x1049;
} else {
x1051 = false;
}
char* x1055;
if (x1051) {
x1055 = (char*)x804;
} else {
x1055 = (char*)x804;
}
x1061 = x1055;
}
x1067 = x1061;
}
x1073 = x1067;
}
x468 = x1073;
bool x1074;
if (x929) {
x1074 = x805;
} else {
const bool x934 = x626 == x933;
bool x960;
if (x934) {
int x935 = 0;
bool x936 = true;
for (;;) {
const int x937 = x935;
const bool x939 = x936;
const bool x938 = x937 < x626;
const bool x940 = x938 && x939;
if (!x940) break;
const int x942 = x935;
const int x943 = x942 + x484;
const char x944 = x0[x943];
const int x945 = (int)x944;
const int x946 = x945 | 32;
const char x947 = (char)x946;
const char x948 = x932[x942];
const bool x950 = x947 == x948;
if (x950) {
} else {
x936 = false;
}
const int x954 = x942 + 1;
x935 = x954;
}
const bool x958 = x936;
x960 = x958;
} else {
x960 = false;
}
bool x1068;
if (x960) {
x1068 = x805;
} else {
const bool x965 = x626 == x964;
bool x991;
if (x965) {
int x966 = 0;
bool x967 = true;
for (;;) {
const int x968 = x966;
const bool x970 = x967;
const bool x969 = x968 < x626;
const bool x971 = x969 && x970;
if (!x971) break;
const int x973 = x966;
const int x974 = x973 + x484;
const char x975 = x0[x974];
const int x976 = (int)x975;
const int x977 = x976 | 32;
const char x978 = (char)x977;
const char x979 = x963[x973];
const bool x981 = x978 == x979;
if (x981) {
} else {
x967 = false;
}
const int x985 = x973 + 1;
x966 = x985;
}
const bool x989 = x967;
x991 = x989;
} else {
x991 = false;
}
const bool x994 = x785 == x993;
bool x1020;
if (x994) {
int x995 = 0;
bool x996 = true;
for (;;) {
const int x997 = x995;
const bool x999 = x996;
const bool x998 = x997 < x785;
const bool x1000 = x998 && x999;
if (!x1000) break;
const int x1002 = x995;
const int x1003 = x1002 + x737;
const char x1004 = x0[x1003];
const int x1005 = (int)x1004;
const int x1006 = x1005 | 32;
const char x1007 = (char)x1006;
const char x1008 = x992[x1002];
const bool x1010 = x1007 == x1008;
if (x1010) {
} else {
x996 = false;
}
const int x1014 = x1002 + 1;
x995 = x1014;
}
const bool x1018 = x996;
x1020 = x1018;
} else {
x1020 = false;
}
const bool x1021 = x991 && x1020;
bool x1062;
if (x1021) {
x1062 = true;
} else {
const bool x1025 = x626 == x1024;
bool x1051;
if (x1025) {
int x1026 = 0;
bool x1027 = true;
for (;;) {
const int x1028 = x1026;
const bool x1030 = x1027;
const bool x1029 = x1028 < x626;
const bool x1031 = x1029 && x1030;
if (!x1031) break;
const int x1033 = x1026;
const int x1034 = x1033 + x484;
const char x1035 = x0[x1034];
const int x1036 = (int)x1035;
const int x1037 = x1036 | 32;
const char x1038 = (char)x1037;
const char x1039 = x1023[x1033];
const bool x1041 = x1038 == x1039;
if (x1041) {
} else {
x1027 = false;
}
const int x1045 = x1033 + 1;
x1026 = x1045;
}
const bool x1049 = x1027;
x1051 = x1049;
} else {
x1051 = false;
}
bool x1056;
if (x1051) {
x1056 = x805;
} else {
x1056 = x805;
}
x1062 = x1056;
}
x1068 = x1062;
}
x1074 = x1068;
}
x469 = x1074;
bool x1075;
if (x929) {
x1075 = x806;
} else {
const bool x934 = x626 == x933;
bool x960;
if (x934) {
int x935 = 0;
bool x936 = true;
for (;;) {
const int x937 = x935;
const bool x939 = x936;
const bool x938 = x937 < x626;
const bool x940 = x938 && x939;
if (!x940) break;
const int x942 = x935;
const int x943 = x942 + x484;
const char x944 = x0[x943];
const int x945 = (int)x944;
const int x946 = x945 | 32;
const char x947 = (char)x946;
const char x948 = x932[x942];
const bool x950 = x947 == x948;
if (x950) {
} else {
x936 = false;
}
const int x954 = x942 + 1;
x935 = x954;
}
const bool x958 = x936;
x960 = x958;
} else {
x960 = false;
}
bool x1069;
if (x960) {
x1069 = x806;
} else {
const bool x965 = x626 == x964;
bool x991;
if (x965) {
int x966 = 0;
bool x967 = true;
for (;;) {
const int x968 = x966;
const bool x970 = x967;
const bool x969 = x968 < x626;
const bool x971 = x969 && x970;
if (!x971) break;
const int x973 = x966;
const int x974 = x973 + x484;
const char x975 = x0[x974];
const int x976 = (int)x975;
const int x977 = x976 | 32;
const char x978 = (char)x977;
const char x979 = x963[x973];
const bool x981 = x978 == x979;
if (x981) {
} else {
x967 = false;
}
const int x985 = x973 + 1;
x966 = x985;
}
const bool x989 = x967;
x991 = x989;
} else {
x991 = false;
}
const bool x994 = x785 == x993;
bool x1020;
if (x994) {
int x995 = 0;
bool x996 = true;
for (;;) {
const int x997 = x995;
const bool x999 = x996;
const bool x998 = x997 < x785;
const bool x1000 = x998 && x999;
if (!x1000) break;
const int x1002 = x995;
const int x1003 = x1002 + x737;
const char x1004 = x0[x1003];
const int x1005 = (int)x1004;
const int x1006 = x1005 | 32;
const char x1007 = (char)x1006;
const char x1008 = x992[x1002];
const bool x1010 = x1007 == x1008;
if (x1010) {
} else {
x996 = false;
}
const int x1014 = x1002 + 1;
x995 = x1014;
}
const bool x1018 = x996;
x1020 = x1018;
} else {
x1020 = false;
}
const bool x1021 = x991 && x1020;
bool x1063;
if (x1021) {
x1063 = x806;
} else {
const bool x1025 = x626 == x1024;
bool x1051;
if (x1025) {
int x1026 = 0;
bool x1027 = true;
for (;;) {
const int x1028 = x1026;
const bool x1030 = x1027;
const bool x1029 = x1028 < x626;
const bool x1031 = x1029 && x1030;
if (!x1031) break;
const int x1033 = x1026;
const int x1034 = x1033 + x484;
const char x1035 = x0[x1034];
const int x1036 = (int)x1035;
const int x1037 = x1036 | 32;
const char x1038 = (char)x1037;
const char x1039 = x1023[x1033];
const bool x1041 = x1038 == x1039;
if (x1041) {
} else {
x1027 = false;
}
const int x1045 = x1033 + 1;
x1026 = x1045;
}
const bool x1049 = x1027;
x1051 = x1049;
} else {
x1051 = false;
}
bool x1057;
if (x1051) {
x1057 = true;
} else {
x1057 = x806;
}
x1063 = x1057;
}
x1069 = x1063;
}
x1075 = x1069;
}
x470 = x1075;
x472 = false;
const int x797 = x787 + 1;
x473 = x797;
x477 = x797;
} else {
x476 = false;
}
}
}
} else {
x476 = false;
}
}
}
} else {
x476 = false;
}
}
}
const int x1110 = x466;
const int x1111 = x467;
const char* x1112 = x468;
const bool x1113 = x469;
const bool x1114 = x470;
const bool x1116 = x472;
const int x1117 = x473;
bool x1122;
if (x1116) {
x1122 = true;
} else {
x1122 = false;
}
if (x1122) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
int x1123;
if (x1116) {
x1123 = 0;
} else {
x1123 = x1117;
}
const bool x1130 = x1123 >= x7;
if (x1130) {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
} else {
const char x1136 = x0[x1123];
const bool x1137 = x1136 == '\n';
if (x1137) {
const int x1138 = x1123 + 1;
Tuple2IntAnon1323431030 x1121;
if (x1116) {
x1121 = (Tuple2IntAnon1323431030){};
} else {
int x394;
if (x391) {
x394 = 0;
} else {
x394 = x390;
}
const Anon1323431030 x1115 = {x1110,x1111,x1112,x1113,x1114};
const Tuple2IntAnon1323431030 x1119 = {x394,x1115};
x1121 = x1119;
}
const Anon1323431030 x1142 = x1121._2;
const int x1143 = x1142.contentLength;
const int x1149 = x1138 + x1143;
const bool x1150 = x1149 < x7;
if (x1150) {
const int x1141 = x1121._1;
const char* x1144 = x1142.connection;
const bool x1145 = x1142.chunked;
const bool x1146 = x1142.upgrade;
const Anon1323431030 x1147 = {x1141,x1143,x1144,x1145,x1146};
const Anon1680061013 x1151 = {x0,x1138,x1143};
const Tuple2Anon1323431030Anon1680061013 x1153 = {x1147,x1151};
x2 = x1153;
x3 = false;
x4 = x1149;
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
} else {
x2 = (Tuple2Anon1323431030Anon1680061013){};
x3 = true;
x4 = 0;
}
}
const Tuple2Anon1323431030Anon1680061013 x1264 = x2;
const bool x1265 = x3;
const int x1266 = x4;
const ParseResultTuple2Anon1323431030Anon1680061013 x1267 = {x1264,x1265,x1266};
//printf("%d\n",x1267.res._1.contentLength);
return x1267;
}
/*****************************************
  End of C Generated Code                  
*******************************************/
