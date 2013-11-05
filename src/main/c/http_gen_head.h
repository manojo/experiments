#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


typedef struct{
int res;
bool empty;
int next;
} ParseResultInt;

void httpNumStatusParse(char* x0) {
const int x1 = (int) 0;
int x3 = x1;
bool x4 = true;
int x5 = -1;
const int x7 = strlen(x0);
const bool x8 = 0 >= x7;
if (x8) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x24 = x0[0];
const bool x25 = x24 == 'H';
if (x25) {
const int x26 = 0 + 1;
const bool x28 = x26 >= x7;
if (x28) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x36 = x0[x26];
const bool x37 = x36 == 'T';
if (x37) {
const int x38 = x26 + 1;
const bool x40 = x38 >= x7;
if (x40) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x48 = x0[x38];
const bool x49 = x48 == 'T';
if (x49) {
const int x50 = x38 + 1;
const bool x52 = x50 >= x7;
if (x52) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x60 = x0[x50];
const bool x61 = x60 == 'P';
if (x61) {
const int x62 = x50 + 1;
const bool x64 = x62 >= x7;
if (x64) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x72 = x0[x62];
const bool x73 = x72 == '/';
if (x73) {
const int x74 = x62 + 1;
const bool x97 = x74 >= x7;
if (x97) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x106 = x0[x74];
const bool x107 = x106 >= '0';
const bool x108 = x106 <= '9';
const bool x109 = x107 && x108;
if (x109) {
const char x112 = x106 - '0';
const int x113 = (int)x112;
int x115 = x113;
bool x116 = false;
const int x110 = x74 + 1;
int x117 = x110;
int x119 = -1;
bool x120 = true;
int x121 = x110;
for (;;) {
const bool x122 = x120;
const int x123 = x119;
const int x124 = x121;
const bool x125 = x123 != x124;
const bool x126 = x122 && x125;
if (!x126) break;
const int x128 = x121;
x119 = x128;
const bool x130 = x128 >= x7;
if (x130) {
x120 = false;
} else {
const char x135 = x0[x128];
const bool x136 = x135 >= '0';
const bool x137 = x135 <= '9';
const bool x138 = x136 && x137;
if (x138) {
const int x144 = x115;
const bool x145 = x116;
const int x146 = x117;
const char x141 = x135 - '0';
const int x142 = (int)x141;
const int x148 = x144 * 10;
const int x149 = x148 + x142;
x115 = x149;
x116 = false;
const int x139 = x128 + 1;
x117 = x139;
x121 = x139;
} else {
x120 = false;
}
}
}
const int x163 = x115;
const bool x164 = x116;
const int x165 = x117;
bool x168;
if (x164) {
x168 = true;
} else {
x168 = x164;
}
if (x168) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
int x169;
if (x164) {
x169 = x74;
} else {
x169 = x165;
}
const bool x175 = x169 >= x7;
if (x175) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x182 = x0[x169];
const bool x183 = x182 == '.';
if (x183) {
const int x184 = x169 + 1;
const bool x186 = x184 >= x7;
if (x186) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
const char x193 = x0[x184];
const bool x194 = x193 >= '0';
const bool x195 = x193 <= '9';
const bool x196 = x194 && x195;
if (x196) {
const char x199 = x193 - '0';
const int x200 = (int)x199;
int x202 = x200;
bool x203 = false;
const int x197 = x184 + 1;
int x204 = x197;
int x206 = -1;
bool x207 = true;
int x208 = x197;
for (;;) {
const bool x209 = x207;
const int x210 = x206;
const int x211 = x208;
const bool x212 = x210 != x211;
const bool x213 = x209 && x212;
if (!x213) break;
const int x215 = x208;
x206 = x215;
const bool x217 = x215 >= x7;
if (x217) {
x207 = false;
} else {
const char x222 = x0[x215];
const bool x223 = x222 >= '0';
const bool x224 = x222 <= '9';
const bool x225 = x223 && x224;
if (x225) {
const int x231 = x202;
const bool x232 = x203;
const int x233 = x204;
const char x228 = x222 - '0';
const int x229 = (int)x228;
const int x235 = x231 * 10;
const int x236 = x235 + x229;
x202 = x236;
x203 = false;
const int x226 = x215 + 1;
x204 = x226;
x208 = x226;
} else {
x207 = false;
}
}
}
const int x250 = x202;
const bool x251 = x203;
const int x252 = x204;
bool x255;
if (x251) {
x255 = true;
} else {
x255 = x251;
}
bool x261;
if (x255) {
x261 = true;
} else {
x261 = false;
}
bool x267;
if (x261) {
x267 = true;
} else {
x267 = false;
}
if (x267) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
char* x275 = "";
bool x276 = false;
int x268;
if (x261) {
x268 = 0;
} else {
int x262;
if (x255) {
x262 = x74;
} else {
int x256;
if (x251) {
x256 = x184;
} else {
x256 = x252;
}
x262 = x256;
}
x268 = x262;
}
int x277 = x268;
int x279 = -1;
bool x280 = true;
int x281 = x268;
for (;;) {
const bool x282 = x280;
const int x283 = x279;
const int x284 = x281;
const bool x285 = x283 != x284;
const bool x286 = x282 && x285;
if (!x286) break;
const int x288 = x281;
x279 = x288;
const bool x290 = x288 >= x7;
if (x290) {
x280 = false;
} else {
const char x294 = x0[x288];
const bool x295 = x294 == ' ';
if (x295) {
const char* x298 = x275;
const bool x299 = x276;
const int x300 = x277;
x275 = x298;
x276 = false;
const int x296 = x288 + 1;
x277 = x296;
x281 = x296;
} else {
x280 = false;
}
}
}
const char* x315 = x275;
const bool x316 = x276;
const int x317 = x277;
bool x322;
if (x316) {
x322 = true;
} else {
x322 = false;
}
if (x322) {
x3 = x1;
x4 = true;
x5 = 0;
} else {
int x323;
if (x316) {
x323 = 0;
} else {
x323 = x317;
}
const bool x329 = x323 >= x7;
if (x329) {
x3 = x1;
x4 = true;
x5 = x323;
} else {
const char x336 = x0[x323];
const bool x337 = x336 >= '0';
const bool x338 = x336 <= '9';
const bool x339 = x337 && x338;
if (x339) {
const char x342 = x336 - '0';
const int x343 = (int)x342;
int x345 = x343;
bool x346 = false;
const int x340 = x323 + 1;
int x347 = x340;
int x349 = -1;
bool x350 = true;
int x351 = x340;
for (;;) {
const bool x352 = x350;
const int x353 = x349;
const int x354 = x351;
const bool x355 = x353 != x354;
const bool x356 = x352 && x355;
if (!x356) break;
const int x358 = x351;
x349 = x358;
const bool x360 = x358 >= x7;
if (x360) {
x350 = false;
} else {
const char x365 = x0[x358];
const bool x366 = x365 >= '0';
const bool x367 = x365 <= '9';
const bool x368 = x366 && x367;
if (x368) {
const int x374 = x345;
const bool x375 = x346;
const int x376 = x347;
const char x371 = x365 - '0';
const int x372 = (int)x371;
const int x378 = x374 * 10;
const int x379 = x378 + x372;
x345 = x379;
x346 = false;
const int x369 = x358 + 1;
x347 = x369;
x351 = x369;
} else {
x350 = false;
}
}
}
const int x393 = x345;
const bool x394 = x346;
const int x395 = x347;
int x397;
if (x394) {
x397 = x1;
} else {
x397 = x393;
}
x3 = x397;
bool x398;
if (x394) {
x398 = true;
} else {
x398 = x394;
}
x4 = x398;
int x399;
if (x394) {
x399 = x323;
} else {
x399 = x395;
}
x5 = x399;
} else {
x3 = x1;
x4 = true;
x5 = x323;
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
const int x482 = x3;
const bool x483 = x4;
const int x484 = x5;
const ParseResultInt x485 = {x482,x483,x484};

printf("%d %d %d\n",x485.res,x485.empty,x485.next);
}
/*****************************************
  End of C Generated Code
*******************************************/
