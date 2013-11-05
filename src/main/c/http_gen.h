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
  int res;
  bool empty;
  int next;
} ParseResultInt;

typedef struct{
  Anon1323431030 res;
  bool empty;
  int next;
} ParseResultAnon1323431030;

typedef struct{
  int _1;
  Anon1323431030 _2;
} Tuple2IntAnon1323431030;

typedef struct{
  char* res;
  bool empty;
  int next;
} ParseResultString;

/*****************************************
 Emitting C Generated Code
 *******************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
void responseParse(char* x0) {
  const Anon1323431030 x1 = (Anon1323431030){};
  Anon1323431030 x3 = x1;
  bool x4 = true;
  int x5 = -1;
  const int x8 = strlen(x0);
  const bool x9 = 0 >= x8;
  if (x9) {
    x3 = x1;
    x4 = true;
    x5 = 0;
  } else {
    const char x29 = x0[0];
    const bool x30 = x29 == 'H';
    if (x30) {
      const int x31 = 0 + 1;
      const bool x33 = x31 >= x8;
      if (x33) {
        x3 = x1;
        x4 = true;
        x5 = 0;
      } else {
        const char x41 = x0[x31];
        const bool x42 = x41 == 'T';
        if (x42) {
          const int x43 = x31 + 1;
          const bool x45 = x43 >= x8;
          if (x45) {
            x3 = x1;
            x4 = true;
            x5 = 0;
          } else {
            const char x53 = x0[x43];
            const bool x54 = x53 == 'T';
            if (x54) {
              const int x55 = x43 + 1;
              const bool x57 = x55 >= x8;
              if (x57) {
                x3 = x1;
                x4 = true;
                x5 = 0;
              } else {
                const char x65 = x0[x55];
                const bool x66 = x65 == 'P';
                if (x66) {
                  const int x67 = x55 + 1;
                  const bool x69 = x67 >= x8;
                  if (x69) {
                    x3 = x1;
                    x4 = true;
                    x5 = 0;
                  } else {
                    const char x77 = x0[x67];
                    const bool x78 = x77 == '/';
                    if (x78) {
                      const int x79 = x67 + 1;
                      const bool x102 = x79 >= x8;
                      if (x102) {
                        x3 = x1;
                        x4 = true;
                        x5 = 0;
                      } else {
                        const char x111 = x0[x79];
                        const bool x112 = x111 >= '0';
                        const bool x113 = x111 <= '9';
                        const bool x114 = x112 && x113;
                        if (x114) {
                          const char x117 = x111 - '0';
                          const int x118 = (int)x117;
                          int x120 = x118;
                          bool x121 = false;
                          const int x115 = x79 + 1;
                          int x122 = x115;
                          int x124 = -1;
                          bool x125 = true;
                          int x126 = x115;
                          for (;;) {
                            const bool x127 = x125;
                            const int x128 = x124;
                            const int x129 = x126;
                            const bool x130 = x128 != x129;
                            const bool x131 = x127 && x130;
                            if (!x131) break;
                            const int x133 = x126;
                            x124 = x133;
                            const bool x135 = x133 >= x8;
                            if (x135) {
                              x125 = false;
                            } else {
                              const char x140 = x0[x133];
                              const bool x141 = x140 >= '0';
                              const bool x142 = x140 <= '9';
                              const bool x143 = x141 && x142;
                              if (x143) {
                                const int x149 = x120;
                                const bool x150 = x121;
                                const int x151 = x122;
                                const char x146 = x140 - '0';
                                const int x147 = (int)x146;
                                const int x153 = x149 * 10;
                                const int x154 = x153 + x147;
                                x120 = x154;
                                x121 = false;
                                const int x144 = x133 + 1;
                                x122 = x144;
                                x126 = x144;
                              } else {
                                x125 = false;
                              }
                            }
                          }
                          const int x168 = x120;
                          const bool x169 = x121;
                          const int x170 = x122;
                          bool x173;
                          if (x169) {
                            x173 = true;
                          } else {
                            x173 = x169;
                          }
                          if (x173) {
                            x3 = x1;
                            x4 = true;
                            x5 = 0;
                          } else {
                            int x174;
                            if (x169) {
                              x174 = x79;
                            } else {
                              x174 = x170;
                            }
                            const bool x180 = x174 >= x8;
                            if (x180) {
                              x3 = x1;
                              x4 = true;
                              x5 = 0;
                            } else {
                              const char x187 = x0[x174];
                              const bool x188 = x187 == '.';
                              if (x188) {
                                const int x189 = x174 + 1;
                                const bool x191 = x189 >= x8;
                                if (x191) {
                                  x3 = x1;
                                  x4 = true;
                                  x5 = 0;
                                } else {
                                  const char x198 = x0[x189];
                                  const bool x199 = x198 >= '0';
                                  const bool x200 = x198 <= '9';
                                  const bool x201 = x199 && x200;
                                  if (x201) {
                                    const char x204 = x198 - '0';
                                    const int x205 = (int)x204;
                                    int x207 = x205;
                                    bool x208 = false;
                                    const int x202 = x189 + 1;
                                    int x209 = x202;
                                    int x211 = -1;
                                    bool x212 = true;
                                    int x213 = x202; // TCK fix
                                    for (;;) {
                                      const bool x214 = x212;
                                      const int x215 = x211;
                                      const int x216 = x213;
                                      const bool x217 = x215 != x216;
                                      const bool x218 = x214 && x217;
                                      if (!x218) break;
                                      const int x220 = x213;
                                      x211 = x220;
                                      const bool x222 = x220 >= x8;
                                      if (x222) {
                                        x212 = false;
                                      } else {
                                        const char x227 = x0[x220];
                                        const bool x228 = x227 >= '0';
                                        const bool x229 = x227 <= '9';
                                        const bool x230 = x228 && x229;
                                        if (x230) {
                                          const int x236 = x207;
                                          const bool x237 = x208;
                                          const int x238 = x209;
                                          const char x233 = x227 - '0';
                                          const int x234 = (int)x233;
                                          const int x240 = x236 * 10;
                                          const int x241 = x240 + x234;
                                          x207 = x241;
                                          x208 = false;
                                          const int x231 = x220 + 1;
                                          x209 = x231;
                                          x213 = x231;
                                        } else {
                                          x212 = false;
                                        }
                                      }
                                    }

                                    const int x255 = x207;
                                    const bool x256 = x208;
                                    const int x257 = x209;
                                    bool x260;
                                    if (x256) {
                                      x260 = true;
                                    } else {
                                      x260 = x256;
                                    }
                                    bool x266;
                                    if (x260) {
                                      x266 = true;
                                    } else {
                                      x266 = false;
                                    }
                                    bool x272;
                                    if (x266) {
                                      x272 = true;
                                    } else {
                                      x272 = false;
                                    }
                                    if (x272) {
                                      x3 = x1;
                                      x4 = true;
                                      x5 = 0;
                                    } else {
                                      char* x280 = "";
                                      bool x281 = false;
                                      int x273;
                                      if (x266) {
                                        x273 = 0;
                                      } else {
                                        int x267;
                                        if (x260) {
                                          x267 = x79;
                                        } else {
                                          int x261;
                                          if (x256) {
                                            x261 = x189;
                                          } else {
                                            x261 = x257;
                                          }
                                          x267 = x261;
                                        }
                                        x273 = x267;
                                      }
                                      int x282 = x273;
                                      int x284 = -1;
                                      bool x285 = true;
                                      int x286 = x273;
                                      for (;;) {
                                        const bool x287 = x285;
                                        const int x288 = x284;
                                        const int x289 = x286;
                                        const bool x290 = x288 != x289;
                                        const bool x291 = x287 && x290;
                                        if (!x291) break;
                                        const int x293 = x286;
                                        x284 = x293;
                                        const bool x295 = x293 >= x8;
                                        if (x295) {
                                          x285 = false;
                                        } else {
                                          const char x299 = x0[x293];
                                          const bool x300 = x299 == ' ';
                                          if (x300) {
                                            const char* x303 = x280;
                                            const bool x304 = x281;
                                            const int x305 = x282;
                                            x280 = (char*)x303;
                                            x281 = false;
                                            const int x301 = x293 + 1;
                                            x282 = x301;
                                            x286 = x301;
                                          } else {
                                            x285 = false;
                                          }
                                        }
                                      }
                                      const char* x320 = x280;
                                      const bool x321 = x281;
                                      const int x322 = x282;
                                      bool x327;
                                      if (x321) {
                                        x327 = true;
                                      } else {
                                        x327 = false;
                                      }
                                      if (x327) {
                                        x3 = x1;
                                        x4 = true;
                                        x5 = 0;
                                      } else {
                                        int x328;
                                        if (x321) {
                                          x328 = 0;
                                        } else {
                                          x328 = x322;
                                        }
                                        const bool x334 = x328 >= x8;
                                        if (x334) {
                                          x3 = x1;
                                          x4 = true;
                                          x5 = 0;
                                        } else {
                                          const char x341 = x0[x328];
                                          const bool x342 = x341 >= '0';
                                          const bool x343 = x341 <= '9';
                                          const bool x344 = x342 && x343;
                                          if (x344) {
                                            const char x347 = x341 - '0';
                                            const int x348 = (int)x347;
                                            int x350 = x348;
                                            bool x351 = false;
                                            const int x345 = x328 + 1;
                                            int x352 = x345;
                                            int x354 = -1;
                                            bool x355 = true;
                                            int x356 = x345;
                                            for (;;) {
                                              const bool x357 = x355;
                                              const int x358 = x354;
                                              const int x359 = x356;
                                              const bool x360 = x358 != x359;
                                              const bool x361 = x357 && x360;
                                              if (!x361) break;
                                              const int x363 = x356;
                                              x354 = x363;
                                              const bool x365 = x363 >= x8;
                                              if (x365) {
                                                x355 = false;
                                              } else {
                                                const char x370 = x0[x363];
                                                const bool x371 = x370 >= '0';
                                                const bool x372 = x370 <= '9';
                                                const bool x373 = x371 && x372;
                                                if (x373) {
                                                  const int x379 = x350;
                                                  const bool x380 = x351;
                                                  const int x381 = x352;
                                                  const char x376 = x370 - '0';
                                                  const int x377 = (int)x376;
                                                  const int x383 = x379 * 10;
                                                  const int x384 = x383 + x377;
                                                  x350 = x384;
                                                  x351 = false;
                                                  const int x374 = x363 + 1;
                                                  x352 = x374;
                                                  x356 = x374;
                                                } else {
                                                  x355 = false;
                                                }
                                              }
                                            }
                                            const int x398 = x350;
                                            const bool x399 = x351;
                                            const int x400 = x352;
                                            bool x403;
                                            if (x399) {
                                              x403 = true;
                                            } else {
                                              x403 = x399;
                                            }
                                            if (x403) {
                                              x3 = x1;
                                              x4 = true;
                                              x5 = 0;
                                            } else {
                                              int x411 = 0;
                                              bool x412 = false;
                                              int x404;
                                              if (x399) {
                                                x404 = x328;
                                              } else {
                                                x404 = x400;
                                              }
                                              int x413 = x404;
                                              int x415 = -1;
                                              bool x416 = true;
                                              int x417 = x404;
                                              for (;;) {
                                                const bool x418 = x416;
                                                const int x419 = x415;
                                                const int x420 = x417;
                                                const bool x421 = x419 != x420;
                                                const bool x422 = x418 && x421;
                                                if (!x422) break;
                                                const int x424 = x417;
                                                x415 = x424;
                                                const bool x426 = x424 >= x8;
                                                if (x426) {
                                                  x416 = false;
                                                } else {
                                                  const char x430 = x0[x424];
                                                  const bool x432 = x430 == '\n';
                                                  if (x432) {
                                                    x416 = false;
                                                  } else {
                                                    const int x437 = x411;
                                                    const bool x438 = x412;
                                                    const int x439 = x413;
                                                    const int x441 = x437 + 1;
                                                    x411 = x441;
                                                    x412 = false;
                                                    const int x435 = x424 + 1;
                                                    x413 = x435;
                                                    x417 = x435;
                                                  }
                                                }
                                              }
                                              const int x453 = x411;
                                              const bool x454 = x412;
                                              const int x455 = x413;
                                              const bool x459 = x455 >= x8;
                                              if (x459) {
                                                x3 = x1;
                                                x4 = true;
                                                x5 = 0;
                                              } else {
                                                const char x467 = x0[x455];
                                                const bool x468 = x467 == '\n';
                                                if (x468) {
                                                  int x475 = 200;
                                                  int x476 = 0;
                                                  char* x477 = "close";
                                                  bool x478 = false;
                                                  bool x479 = false;
                                                  bool x481 = false;
                                                  const int x469 = x455 + 1;
                                                  int x482 = x469;
                                                  int x484 = -1;
                                                  bool x485 = true;
                                                  int x486 = x469;
                                                  const int x20 = (int)0;
                                                  ParseResultInt x538(int x501) {
                                                    int x503 = x20;
                                                    bool x504 = true;
                                                    int x505 = x501;
                                                    const bool x507 = x501 >= x8;
                                                    if (x507) {
                                                      x503 = x20;
                                                      x504 = true;
                                                      x505 = x501;
                                                    } else {
                                                      const char x512 = x0[x501];
                                                      const bool x513 = x512 >= 'a';
                                                      const bool x514 = x512 <= 'z';
                                                      const bool x515 = x513 && x514;
                                                      const bool x516 = x512 >= 'A';
                                                      const bool x517 = x512 <= 'Z';
                                                      const bool x518 = x516 && x517;
                                                      const bool x519 = x515 || x518;
                                                      if (x519) {
                                                        x503 = x501;
                                                        x504 = false;
                                                        const int x520 = x501 + 1;
                                                        x505 = x520;
                                                      } else {
                                                        x503 = x20;
                                                        x504 = true;
                                                        x505 = x501;
                                                      }
                                                    }
                                                    const int x533 = x503;
                                                    const bool x534 = x504;
                                                    const int x535 = x505;
                                                    const ParseResultInt x536 = {x533,x534,x535};
                                                    return x536;
                                                  }
                                                  ParseResultInt x574(int x495) {
                                                    int x497 = x20;
                                                    bool x498 = true;
                                                    int x499 = x495;
                                                    const ParseResultInt x539 = x538(x495);
                                                    const bool x540 = x539.empty;
                                                    if (x540) {
                                                      const bool x541 = x495 >= x8;
                                                      if (x541) {
                                                        x497 = x20;
                                                        x498 = true;
                                                        x499 = x495;
                                                      } else {
                                                        const char x546 = x0[x495];
                                                        const bool x547 = x546 == '-';
                                                        if (x547) {
                                                          x497 = x495;
                                                          x498 = false;
                                                          const int x548 = x495 + 1;
                                                          x499 = x548;
                                                        } else {
                                                          x497 = x20;
                                                          x498 = true;
                                                          x499 = x495;
                                                        }
                                                      }
                                                    } else {
                                                      const int x562 = x539.res;
                                                      x497 = x562;
                                                      x498 = x540;
                                                      const int x565 = x539.next;
                                                      x499 = x565;
                                                    }
                                                    const int x569 = x497;
                                                    const bool x570 = x498;
                                                    const int x571 = x499;
                                                    const ParseResultInt x572 = {x569,x570,x571};
                                                    return x572;
                                                  }
                                                  const char* x822 = "connection";
                                                  const int x823 = strlen(x822);
                                                  const char* x848 = "proxy-connection";
                                                  const int x849 = strlen(x848);
                                                  const char* x875 = "keep-alive";
                                                  const int x876 = strlen(x875);
                                                  const char* x901 = "close";
                                                  const int x902 = strlen(x901);
                                                  const char* x947 = "content-length";
                                                  const int x948 = strlen(x947);
                                                  const char* x992 = "transfer-encoding";
                                                  const int x993 = strlen(x992);
                                                  const char* x1018 = "chunked";
                                                  const int x1019 = strlen(x1018);
                                                  const char* x1046 = "upgrade";
                                                  const int x1047 = strlen(x1046);
                                                  for (;;) {
                                                    const bool x487 = x485;
                                                    const int x488 = x484;
                                                    const int x489 = x486;
                                                    const bool x490 = x488 != x489;
                                                    const bool x491 = x487 && x490;
                                                    if (!x491) break;
                                                    const int x493 = x486;
                                                    x484 = x493;
                                                    const bool x575 = x493 >= x8;
                                                    if (x575) {
                                                      x485 = false;
                                                    } else {
                                                      const char x583 = x0[x493];
                                                      const bool x584 = x583 >= 'a';
                                                      const bool x585 = x583 <= 'z';
                                                      const bool x586 = x584 && x585;
                                                      const bool x587 = x583 >= 'A';
                                                      const bool x588 = x583 <= 'Z';
                                                      const bool x589 = x587 && x588;
                                                      const bool x590 = x586 || x589;
                                                      if (x590) {
                                                        int x594 = 0;
                                                        bool x595 = false;
                                                        const int x591 = x493 + 1;
                                                        int x596 = x591;
                                                        int x598 = -1;
                                                        bool x599 = true;
                                                        int x600 = x591;
                                                        for (;;) {
                                                          const bool x601 = x599;
                                                          const int x602 = x598;
                                                          const int x603 = x600;
                                                          const bool x604 = x602 != x603;
                                                          const bool x605 = x601 && x604;
                                                          if (!x605) break;
                                                          const int x607 = x600;
                                                          x598 = x607;
                                                          const ParseResultInt x609 = x574(x607);
                                                          const bool x610 = x609.empty;
                                                          if (x610) {
                                                            x599 = false;
                                                          } else {
                                                            const int x613 = x594;
                                                            const bool x614 = x595;
                                                            const int x615 = x596;
                                                            const int x617 = x613 + 1;
                                                            x594 = x617;
                                                            x595 = false;
                                                            const int x618 = x609.next;
                                                            x596 = x618;
                                                            x600 = x618;
                                                          }
                                                        }
                                                        const int x628 = x594;
                                                        const bool x629 = x595;
                                                        const int x630 = x596;
                                                        char* x640 = "";
                                                        bool x641 = false;
                                                        int x642 = x630;
                                                        int x644 = -1;
                                                        bool x645 = true;
                                                        int x646 = x630;
                                                        for (;;) {
                                                          const bool x647 = x645;
                                                          const int x648 = x644;
                                                          const int x649 = x646;
                                                          const bool x650 = x648 != x649;
                                                          const bool x651 = x647 && x650;
                                                          if (!x651) break;
                                                          const int x653 = x646;
                                                          x644 = x653;
                                                          const bool x655 = x653 >= x8;
                                                          if (x655) {
                                                            x645 = false;
                                                          } else {
                                                            const char x659 = x0[x653];
                                                            const bool x660 = x659 == ' ';
                                                            if (x660) {
                                                              const char* x663 = x640;
                                                              const bool x664 = x641;
                                                              const int x665 = x642;
                                                              x640 = (char*)x663;
                                                              x641 = false;
                                                              const int x661 = x653 + 1;
                                                              x642 = x661;
                                                              x646 = x661;
                                                            } else {
                                                              x645 = false;
                                                            }
                                                          }
                                                        }
                                                        const char* x680 = x640;
                                                        const bool x681 = x641;
                                                        const int x682 = x642;
                                                        if (x681) {
                                                          x485 = false;
                                                        } else {
                                                          const bool x688 = x682 >= x8;
                                                          if (x688) {
                                                            x485 = false;
                                                          } else {
                                                            const char x694 = x0[x682];
                                                            const bool x695 = x694 == ':';
                                                            if (x695) {
                                                              char* x706 = "";
                                                              bool x707 = false;
                                                              const int x696 = x682 + 1;
                                                              int x708 = x696;
                                                              int x710 = -1;
                                                              bool x711 = true;
                                                              int x712 = x696;
                                                              for (;;) {
                                                                const bool x713 = x711;
                                                                const int x714 = x710;
                                                                const int x715 = x712;
                                                                const bool x716 = x714 != x715;
                                                                const bool x717 = x713 && x716;
                                                                if (!x717) break;
                                                                const int x719 = x712;
                                                                x710 = x719;
                                                                const bool x721 = x719 >= x8;
                                                                if (x721) {
                                                                  x711 = false;
                                                                } else {
                                                                  const char x725 = x0[x719];
                                                                  const bool x726 = x725 == ' ';
                                                                  if (x726) {
                                                                    const char* x729 = x706;
                                                                    const bool x730 = x707;
                                                                    const int x731 = x708;
                                                                    x706 = (char*)x729;
                                                                    x707 = false;
                                                                    const int x727 = x719 + 1;
                                                                    x708 = x727;
                                                                    x712 = x727;
                                                                  } else {
                                                                    x711 = false;
                                                                  }
                                                                }
                                                              }
                                                              const char* x746 = x706;
                                                              const bool x747 = x707;
                                                              const int x748 = x708;
                                                              if (x747) {
                                                                x485 = false;
                                                              } else {
                                                                int x754 = 0;
                                                                bool x755 = false;
                                                                int x756 = x748;
                                                                int x758 = -1;
                                                                bool x759 = true;
                                                                int x760 = x748;
                                                                for (;;) {
                                                                  const bool x761 = x759;
                                                                  const int x762 = x758;
                                                                  const int x763 = x760;
                                                                  const bool x764 = x762 != x763;
                                                                  const bool x765 = x761 && x764;
                                                                  if (!x765) break;
                                                                  const int x767 = x760;
                                                                  x758 = x767;
                                                                  const bool x769 = x767 >= x8;
                                                                  if (x769) {
                                                                    x759 = false;
                                                                  } else {
                                                                    const char x773 = x0[x767];
                                                                    const bool x775 = x773 == '\n';
                                                                    if (x775) {
                                                                      x759 = false;
                                                                    } else {
                                                                      const int x780 = x754;
                                                                      const bool x781 = x755;
                                                                      const int x782 = x756;
                                                                      const int x784 = x780 + 1;
                                                                      x754 = x784;
                                                                      x755 = false;
                                                                      const int x778 = x767 + 1;
                                                                      x756 = x778;
                                                                      x760 = x778;
                                                                    }
                                                                  }
                                                                }
                                                                const int x796 = x754;
                                                                const bool x797 = x755;
                                                                const int x798 = x756;
                                                                const bool x802 = x798 >= x8;
                                                                if (x802) {
                                                                  x485 = false;
                                                                } else {
                                                                  const char x806 = x0[x798];
                                                                  const bool x807 = x806 == '\n';
                                                                  if (x807) {
                                                                    const int x813 = x475;
                                                                    const int x814 = x476;
                                                                    const char* x815 = x477;
                                                                    const bool x816 = x478;
                                                                    const bool x817 = x479;
                                                                    const bool x819 = x481;
                                                                    const int x820 = x482;
                                                                    const int x636 = x628 + 1;
                                                                    const bool x824 = x636 == x823;
                                                                    bool x847;
                                                                    if (x824) {
                                                                      int x825 = 0;
                                                                      bool x826 = true;
                                                                      for (;;) {
                                                                        const int x827 = x825;
                                                                        const bool x829 = x826;
                                                                        const bool x828 = x827 < x636;
                                                                        const bool x830 = x828 && x829;
                                                                        if (!x830) break;
                                                                        const int x832 = x825;
                                                                        const int x833 = x832 + x493;
                                                                        const char x834 = x0[x833];
                                                                        const char x835 = x822[x832];
                                                                        const bool x837 = x834 == x835;
                                                                        if (x837) {
                                                                        } else {
                                                                          x826 = false;
                                                                        }
                                                                        const int x841 = x832 + 1;
                                                                        x825 = x841;
                                                                      }
                                                                      const bool x845 = x826;
                                                                      x847 = x845;
                                                                    } else {
                                                                      x847 = false;
                                                                    }
                                                                    const bool x850 = x636 == x849;
                                                                    bool x873;
                                                                    if (x850) {
                                                                      int x851 = 0;
                                                                      bool x852 = true;
                                                                      for (;;) {
                                                                        const int x853 = x851;
                                                                        const bool x855 = x852;
                                                                        const bool x854 = x853 < x636;
                                                                        const bool x856 = x854 && x855;
                                                                        if (!x856) break;
                                                                        const int x858 = x851;
                                                                        const int x859 = x858 + x493;
                                                                        const char x860 = x0[x859];
                                                                        const char x861 = x848[x858];
                                                                        const bool x863 = x860 == x861;
                                                                        if (x863) {
                                                                        } else {
                                                                          x852 = false;
                                                                        }
                                                                        const int x867 = x858 + 1;
                                                                        x851 = x867;
                                                                      }
                                                                      const bool x871 = x852;
                                                                      x873 = x871;
                                                                    } else {
                                                                      x873 = false;
                                                                    }
                                                                    const bool x874 = x847 || x873;
                                                                    const bool x877 = x796 == x876;
                                                                    bool x900;
                                                                    if (x877) {
                                                                      int x878 = 0;
                                                                      bool x879 = true;
                                                                      for (;;) {
                                                                        const int x880 = x878;
                                                                        const bool x882 = x879;
                                                                        const bool x881 = x880 < x796;
                                                                        const bool x883 = x881 && x882;
                                                                        if (!x883) break;
                                                                        const int x885 = x878;
                                                                        const int x886 = x885 + x748;
                                                                        const char x887 = x0[x886];
                                                                        const char x888 = x875[x885];
                                                                        const bool x890 = x887 == x888;
                                                                        if (x890) {
                                                                        } else {
                                                                          x879 = false;
                                                                        }
                                                                        const int x894 = x885 + 1;
                                                                        x878 = x894;
                                                                      }
                                                                      const bool x898 = x879;
                                                                      x900 = x898;
                                                                    } else {
                                                                      x900 = false;
                                                                    }
                                                                    const bool x903 = x796 == x902;
                                                                    bool x926;
                                                                    if (x903) {
                                                                      int x904 = 0;
                                                                      bool x905 = true;
                                                                      for (;;) {
                                                                        const int x906 = x904;
                                                                        const bool x908 = x905;
                                                                        const bool x907 = x906 < x796;
                                                                        const bool x909 = x907 && x908;
                                                                        if (!x909) break;
                                                                        const int x911 = x904;
                                                                        const int x912 = x911 + x748;
                                                                        const char x913 = x0[x912];
                                                                        const char x914 = x901[x911];
                                                                        const bool x916 = x913 == x914;
                                                                        if (x916) {
                                                                        } else {
                                                                          x905 = false;
                                                                        }
                                                                        const int x920 = x911 + 1;
                                                                        x904 = x920;
                                                                      }
                                                                      const bool x924 = x905;
                                                                      x926 = x924;
                                                                    } else {
                                                                      x926 = false;
                                                                    }
                                                                    const bool x927 = x900 || x926;
                                                                    const bool x928 = x874 && x927;
                                                                    Anon1323431030 x1086;
                                                                    if (x928) {
                                                                      char* x929 = "";
                                                                      int x930 = 0;
                                                                      for (;;) {
                                                                        const int x931 = x930;
                                                                        const bool x932 = x931 < x796;
                                                                        if (!x932) break;
                                                                        const char* x934 = x929;
                                                                        const int x935 = x930;
                                                                        const int x936 = x748 + x935;
                                                                        const char x937 = x0[x936];
                                                                        const char* x938 = ({ int l1=strlen(x934); char* r=(char*)malloc(l1+2); memcpy(r,x934,l1); r[l1]=x937; r[l1+2]=0; r; });
                                                                        x929 = (char*)x938;
                                                                        const int x940 = x935 + 1;
                                                                        x930 = x940;
                                                                      }
                                                                      const char* x944 = x929;
                                                                      Anon1323431030 x945 = {x813,x814,(char*)x944,x816,x817};
                                                                      x1086 = x945;
                                                                    } else {
                                                                      const bool x949 = x636 == x948;
                                                                      bool x972;
                                                                      if (x949) {
                                                                        int x950 = 0;
                                                                        bool x951 = true;
                                                                        for (;;) {
                                                                          const int x952 = x950;
                                                                          const bool x954 = x951;
                                                                          const bool x953 = x952 < x636;
                                                                          const bool x955 = x953 && x954;
                                                                          if (!x955) break;
                                                                          const int x957 = x950;
                                                                          const int x958 = x957 + x493;
                                                                          const char x959 = x0[x958];
                                                                          const char x960 = x947[x957];
                                                                          const bool x962 = x959 == x960;
                                                                          if (x962) {
                                                                          } else {
                                                                            x951 = false;
                                                                          }
                                                                          const int x966 = x957 + 1;
                                                                          x950 = x966;
                                                                        }
                                                                        const bool x970 = x951;
                                                                        x972 = x970;
                                                                      } else {
                                                                        x972 = false;
                                                                      }
                                                                      Anon1323431030 x1085;
                                                                      if (x972) {
                                                                        char* x973 = "";
                                                                        int x974 = 0;
                                                                        for (;;) {
                                                                          const int x975 = x974;
                                                                          const bool x976 = x975 < x796;
                                                                          if (!x976) break;
                                                                          const char* x978 = x973;
                                                                          const int x979 = x974;
                                                                          const int x980 = x748 + x979;
                                                                          const char x981 = x0[x980];
                                                                          const char* x982 = ({ int l1=strlen(x978); char* r=(char*)malloc(l1+2); memcpy(r,x978,l1); r[l1]=x981; r[l1+2]=0; r; });
                                                                          x973 = (char*)x982;
                                                                          const int x984 = x979 + 1;
                                                                          x974 = x984;
                                                                        }
                                                                        const char* x988 = x973;
                                                                        const int x989 = atoi(x988);
                                                                        const Anon1323431030 x990 = {x813,x989,(char*)x815,x816,x817};
                                                                        x1085 = x990;
                                                                      } else {
                                                                        const bool x994 = x636 == x993;
                                                                        bool x1017;
                                                                        if (x994) {
                                                                          int x995 = 0;
                                                                          bool x996 = true;
                                                                          for (;;) {
                                                                            const int x997 = x995;
                                                                            const bool x999 = x996;
                                                                            const bool x998 = x997 < x636;
                                                                            const bool x1000 = x998 && x999;
                                                                            if (!x1000) break;
                                                                            const int x1002 = x995;
                                                                            const int x1003 = x1002 + x493;
                                                                            const char x1004 = x0[x1003];
                                                                            const char x1005 = x992[x1002];
                                                                            const bool x1007 = x1004 == x1005;
                                                                            if (x1007) {
                                                                            } else {
                                                                              x996 = false;
                                                                            }
                                                                            const int x1011 = x1002 + 1;
                                                                            x995 = x1011;
                                                                          }
                                                                          const bool x1015 = x996;
                                                                          x1017 = x1015;
                                                                        } else {
                                                                          x1017 = false;
                                                                        }
                                                                        const bool x1020 = x796 == x1019;
                                                                        bool x1043;
                                                                        if (x1020) {
                                                                          int x1021 = 0;
                                                                          bool x1022 = true;
                                                                          for (;;) {
                                                                            const int x1023 = x1021;
                                                                            const bool x1025 = x1022;
                                                                            const bool x1024 = x1023 < x796;
                                                                            const bool x1026 = x1024 && x1025;
                                                                            if (!x1026) break;
                                                                            const int x1028 = x1021;
                                                                            const int x1029 = x1028 + x748;
                                                                            const char x1030 = x0[x1029];
                                                                            const char x1031 = x1018[x1028];
                                                                            const bool x1033 = x1030 == x1031;
                                                                            if (x1033) {
                                                                            } else {
                                                                              x1022 = false;
                                                                            }
                                                                            const int x1037 = x1028 + 1;
                                                                            x1021 = x1037;
                                                                          }
                                                                          const bool x1041 = x1022;
                                                                          x1043 = x1041;
                                                                        } else {
                                                                          x1043 = false;
                                                                        }
                                                                        const bool x1044 = x1017 && x1043;
                                                                        int x1079;
                                                                        if (x1044) {
                                                                          x1079 = x813;
                                                                        } else {
                                                                          const bool x1048 = x636 == x1047;
                                                                          bool x1071;
                                                                          if (x1048) {
                                                                            int x1049 = 0;
                                                                            bool x1050 = true;
                                                                            for (;;) {
                                                                              const int x1051 = x1049;
                                                                              const bool x1053 = x1050;
                                                                              const bool x1052 = x1051 < x636;
                                                                              const bool x1054 = x1052 && x1053;
                                                                              if (!x1054) break;
                                                                              const int x1056 = x1049;
                                                                              const int x1057 = x1056 + x493;
                                                                              const char x1058 = x0[x1057];
                                                                              const char x1059 = x1046[x1056];
                                                                              const bool x1061 = x1058 == x1059;
                                                                              if (x1061) {
                                                                              } else {
                                                                                x1050 = false;
                                                                              }
                                                                              const int x1065 = x1056 + 1;
                                                                              x1049 = x1065;
                                                                            }
                                                                            const bool x1069 = x1050;
                                                                            x1071 = x1069;
                                                                          } else {
                                                                            x1071 = false;
                                                                          }
                                                                          int x1073;
                                                                          if (x1071) {
                                                                            x1073 = x813;
                                                                          } else {
                                                                            x1073 = x813;
                                                                          }
                                                                          x1079 = x1073;
                                                                        }
                                                                        int x1080;
                                                                        if (x1044) {
                                                                          x1080 = x814;
                                                                        } else {
                                                                          const bool x1048 = x636 == x1047;
                                                                          bool x1071;
                                                                          if (x1048) {
                                                                            int x1049 = 0;
                                                                            bool x1050 = true;
                                                                            for (;;) {
                                                                              const int x1051 = x1049;
                                                                              const bool x1053 = x1050;
                                                                              const bool x1052 = x1051 < x636;
                                                                              const bool x1054 = x1052 && x1053;
                                                                              if (!x1054) break;
                                                                              const int x1056 = x1049;
                                                                              const int x1057 = x1056 + x493;
                                                                              const char x1058 = x0[x1057];
                                                                              const char x1059 = x1046[x1056];
                                                                              const bool x1061 = x1058 == x1059;
                                                                              if (x1061) {
                                                                              } else {
                                                                                x1050 = false;
                                                                              }
                                                                              const int x1065 = x1056 + 1;
                                                                              x1049 = x1065;
                                                                            }
                                                                            const bool x1069 = x1050;
                                                                            x1071 = x1069;
                                                                          } else {
                                                                            x1071 = false;
                                                                          }
                                                                          int x1074;
                                                                          if (x1071) {
                                                                            x1074 = x814;
                                                                          } else {
                                                                            x1074 = x814;
                                                                          }
                                                                          x1080 = x1074;
                                                                        }
                                                                        char* x1081;
                                                                        if (x1044) {
                                                                          x1081 = (char*)x815;
                                                                        } else {
                                                                          const bool x1048 = x636 == x1047;
                                                                          bool x1071;
                                                                          if (x1048) {
                                                                            int x1049 = 0;
                                                                            bool x1050 = true;
                                                                            for (;;) {
                                                                              const int x1051 = x1049;
                                                                              const bool x1053 = x1050;
                                                                              const bool x1052 = x1051 < x636;
                                                                              const bool x1054 = x1052 && x1053;
                                                                              if (!x1054) break;
                                                                              const int x1056 = x1049;
                                                                              const int x1057 = x1056 + x493;
                                                                              const char x1058 = x0[x1057];
                                                                              const char x1059 = x1046[x1056];
                                                                              const bool x1061 = x1058 == x1059;
                                                                              if (x1061) {
                                                                              } else {
                                                                                x1050 = false;
                                                                              }
                                                                              const int x1065 = x1056 + 1;
                                                                              x1049 = x1065;
                                                                            }
                                                                            const bool x1069 = x1050;
                                                                            x1071 = x1069;
                                                                          } else {
                                                                            x1071 = false;
                                                                          }
                                                                          char* x1075;
                                                                          if (x1071) {
                                                                            x1075 = (char*)x815;
                                                                          } else {
                                                                            x1075 = (char*)x815;
                                                                          }
                                                                          x1081 = x1075;
                                                                        }
                                                                        bool x1082;
                                                                        if (x1044) {
                                                                          x1082 = true;
                                                                        } else {
                                                                          const bool x1048 = x636 == x1047;
                                                                          bool x1071;
                                                                          if (x1048) {
                                                                            int x1049 = 0;
                                                                            bool x1050 = true;
                                                                            for (;;) {
                                                                              const int x1051 = x1049;
                                                                              const bool x1053 = x1050;
                                                                              const bool x1052 = x1051 < x636;
                                                                              const bool x1054 = x1052 && x1053;
                                                                              if (!x1054) break;
                                                                              const int x1056 = x1049;
                                                                              const int x1057 = x1056 + x493;
                                                                              const char x1058 = x0[x1057];
                                                                              const char x1059 = x1046[x1056];
                                                                              const bool x1061 = x1058 == x1059;
                                                                              if (x1061) {
                                                                              } else {
                                                                                x1050 = false;
                                                                              }
                                                                              const int x1065 = x1056 + 1;
                                                                              x1049 = x1065;
                                                                            }
                                                                            const bool x1069 = x1050;
                                                                            x1071 = x1069;
                                                                          } else {
                                                                            x1071 = false;
                                                                          }
                                                                          bool x1076;
                                                                          if (x1071) {
                                                                            x1076 = x816;
                                                                          } else {
                                                                            x1076 = x816;
                                                                          }
                                                                          x1082 = x1076;
                                                                        }
                                                                        bool x1083;
                                                                        if (x1044) {
                                                                          x1083 = x817;
                                                                        } else {
                                                                          const bool x1048 = x636 == x1047;
                                                                          bool x1071;
                                                                          if (x1048) {
                                                                            int x1049 = 0;
                                                                            bool x1050 = true;
                                                                            for (;;) {
                                                                              const int x1051 = x1049;
                                                                              const bool x1053 = x1050;
                                                                              const bool x1052 = x1051 < x636;
                                                                              const bool x1054 = x1052 && x1053;
                                                                              if (!x1054) break;
                                                                              const int x1056 = x1049;
                                                                              const int x1057 = x1056 + x493;
                                                                              const char x1058 = x0[x1057];
                                                                              const char x1059 = x1046[x1056];
                                                                              const bool x1061 = x1058 == x1059;
                                                                              if (x1061) {
                                                                              } else {
                                                                                x1050 = false;
                                                                              }
                                                                              const int x1065 = x1056 + 1;
                                                                              x1049 = x1065;
                                                                            }
                                                                            const bool x1069 = x1050;
                                                                            x1071 = x1069;
                                                                          } else {
                                                                            x1071 = false;
                                                                          }
                                                                          bool x1077;
                                                                          if (x1071) {
                                                                            x1077 = true;
                                                                          } else {
                                                                            x1077 = x817;
                                                                          }
                                                                          x1083 = x1077;
                                                                        }
                                                                        const Anon1323431030 x1084 = {x1079,x1080,x1081,x1082,x1083};
                                                                        x1085 = x1084;
                                                                      }
                                                                      x1086 = x1085;
                                                                    }
                                                                    const int x1088 = x1086.status;
                                                                    x475 = x1088;
                                                                    const int x1090 = x1086.contentLength;
                                                                    x476 = x1090;
                                                                    const char* x1092 = x1086.connection;
                                                                    x477 = (char*)x1092;
                                                                    const bool x1094 = x1086.chunked;
                                                                    x478 = x1094;
                                                                    const bool x1096 = x1086.upgrade;
                                                                    x479 = x1096;
                                                                    x481 = false;
                                                                    const int x808 = x798 + 1;
                                                                    x482 = x808;
                                                                    x486 = x808;
                                                                  } else {
                                                                    x485 = false;
                                                                  }
                                                                }
                                                              }
                                                            } else {
                                                              x485 = false;
                                                            }
                                                          }
                                                        }
                                                      } else {
                                                        x485 = false;
                                                      }
                                                    }
                                                  }
                                                  const int x1125 = x475;
                                                  const int x1126 = x476;
                                                  const char* x1127 = x477;
                                                  const bool x1128 = x478;
                                                  const bool x1129 = x479;
                                                  const bool x1131 = x481;
                                                  const int x1132 = x482;
                                                  bool x1137;
                                                  if (x1131) {
                                                    x1137 = true;
                                                  } else {
                                                    x1137 = false;
                                                  }
                                                  if (x1137) {
                                                    x3 = x1;
                                                    x4 = true;
                                                    int x1138;
                                                    if (x1131) {
                                                      x1138 = 0;
                                                    } else {
                                                      x1138 = x1132;
                                                    }
                                                    x5 = x1138;
                                                  } else {
                                                    int x1138;
                                                    if (x1131) {
                                                      x1138 = 0;
                                                    } else {
                                                      x1138 = x1132;
                                                    }
                                                    const bool x1145 = x1138 >= x8;
                                                    if (x1145) {
                                                      x3 = x1;
                                                      x4 = true;
                                                      x5 = 0;
                                                    } else {
                                                      const char x1151 = x0[x1138];
                                                      const bool x1152 = x1151 == '\n';
                                                      if (x1152) {
                                                        Tuple2IntAnon1323431030 x1136;
                                                        if (x1131) {
                                                          const Tuple2IntAnon1323431030 x22 = {};
                                                          x1136 = x22;
                                                        } else {
                                                          int x402;
                                                          if (x399) {
                                                            x402 = x20;
                                                          } else {
                                                            x402 = x398;
                                                          }
                                                          const Anon1323431030 x1130 = {x1125,x1126,(char*)x1127,x1128,x1129};
                                                          const Tuple2IntAnon1323431030 x1134 = {x402,x1130};
                                                          x1136 = x1134;
                                                        }
                                                        const int x1156 = x1136._1;
                                                        const Anon1323431030 x1157 = x1136._2;
                                                        const int x1158 = x1157.contentLength;
                                                        const char* x1159 = x1157.connection;
                                                        const bool x1160 = x1157.chunked;
                                                        const bool x1161 = x1157.upgrade;
                                                        const Anon1323431030 x1162 = {x1156,x1158,(char*)x1159,x1160,x1161};
                                                        x3 = x1162;
                                                        x4 = false;
                                                        const int x1153 = x1138 + 1;
                                                        x5 = x1153;
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
  const Anon1323431030 x1265 = x3;
  const bool x1266 = x4;
  const int x1267 = x5;
  const ParseResultAnon1323431030 x1268 = {x1265,x1266,x1267};
  //printf("%s\n",x1268);
  printf("Empty=%d, next=%d\n",x1268.empty,x1268.next);
  Anon1323431030 r = x1268.res;
  printf("Status=%d, contentLength=%d, connection=%s, chunked=%d, upgrade=%d\n",r.status,r.contentLength,r.connection,r.chunked,r.upgrade);
}
/*****************************************
 End of C Generated Code
 *******************************************/
/*****************************************
 Emitting C Generated Code
 *******************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
void bodyParse(char* x1271) {
  const char* x14 = (char*) NULL;
  char* x1273 = (char*)x14;
  bool x1274 = true;
  int x1275 = -1;
  char* x1278 = "";
  bool x1279 = false;
  int x1280 = 0;
  int x1282 = -1;
  bool x1283 = true;
  int x1284 = 0;
  int x1285 = 0;
  const int x1297 = strlen(x1271);
  for (;;) {
    const int x1286 = x1285;
    const int x1288 = x1282;
    const int x1289 = x1284;
    const bool x1292 = x1283;
    const bool x1287 = x1286 < 14;
    const bool x1290 = x1288 != x1289;
    const bool x1291 = x1287 && x1290;
    const bool x1293 = x1291 && x1292;
    if (!x1293) break;
    const int x1295 = x1284;
    x1282 = x1295;
    const bool x1298 = x1295 >= x1297;
    if (x1298) {
      x1283 = false;
    } else {
      const char* x1305 = x1278;
      const bool x1306 = x1279;
      const int x1307 = x1280;
      const char x1302 = x1271[x1295];
      const char* x1309 = ({ int l1=strlen(x1305); char* r=(char*)malloc(l1+2); memcpy(r,x1305,l1); r[l1]=x1302; r[l1+2]=0; r; });
      x1278 = (char*)x1309;
      x1279 = false;
      const int x1303 = x1295 + 1;
      x1280 = x1303;
      x1284 = x1303;
      const int x1315 = x1285;
      const int x1316 = x1315 + 1;
      x1285 = x1316;
    }
  }
  const char* x1322 = x1278;
  const bool x1323 = x1279;
  const int x1324 = x1280;
  x1273 = (char*)x1322;
  x1274 = x1323;
  x1275 = x1324;
  const char* x1329 = x1273;
  const bool x1330 = x1274;
  const int x1331 = x1275;
  const ParseResultString x1332 = {(char*)x1329,x1330,x1331};
  printf("%s\n",x1332);
}
/*****************************************
 End of C Generated Code
 *******************************************/
