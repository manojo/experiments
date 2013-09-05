/* Based on src/http/ngx_http_parse.c from NGINX copyright Igor Sysoev
 *
 * Additional changes are licensed under the same terms as NGINX and
 * copyright Joyent, Inc. and other Node contributors. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *
 *
 * Author: Tiark Rompf <tiark.rompf@epfl.ch>
 */

package done;

final class HttpParserLL {


  // ---------------------------------- interface


  static final int HTTP_PARSER_VERSION_MAJOR = 1;
  static final int HTTP_PARSER_VERSION_MINOR = 0;

  /* Compile with -DHTTP_PARSER_STRICT=0 to make less checks, but run
   * faster
   */
/*
  #ifndef HTTP_PARSER_STRICT
  # define HTTP_PARSER_STRICT 1
  #else
  # define HTTP_PARSER_STRICT 0
  #endif
*/

  /* Maximium header size allowed */
  static final int HTTP_MAX_HEADER_SIZE = (80*1024);


  /* Callbacks should return non-zero to indicate an error. The parser will
   * then halt execution.
   *
   * The one exception is on_headers_complete. In a HTTP_RESPONSE parser
   * returning '1' from on_headers_complete will tell the parser that it
   * should not expect a body. This is used when receiving a response to a
   * HEAD request which may contain 'Content-Length' or 'Transfer-Encoding:
   * chunked' headers that indicate the presence of a body.
   *
   * http_data_cb does not return data chunks. It will be call arbitrarally
   * many times for each string. E.G. you might get 10 callbacks for "on_path"
   * each providing just a few characters more data.
   */

/*
  static interface http_data_cb {
    int apply(http_parser parser, char[] at, int length);
  }

  static interface http_cb {
    int apply(http_parser parser);
  }
*/

//  typedef int (*http_data_cb) (http_parser*, const char *at, size_t length);
//  typedef int (*http_cb) (http_parser*);


  /* Request Methods */
  //enum http_method
    static final int HTTP_DELETE      =  0;
    static final int HTTP_GET         =  1;
    static final int HTTP_HEAD        =  2;
    static final int HTTP_POST        =  3;
    static final int HTTP_PUT         =  4;
    /* pathological */
    static final int HTTP_CONNECT     =  5;
    static final int HTTP_OPTIONS     =  6;
    static final int HTTP_TRACE       =  7;
    /* webdav */
    static final int HTTP_COPY        =  8;
    static final int HTTP_LOCK        =  9;
    static final int HTTP_MKCOL       = 10;
    static final int HTTP_MOVE        = 11;
    static final int HTTP_PROPFIND    = 12;
    static final int HTTP_PROPPATCH   = 13;
    static final int HTTP_UNLOCK      = 14;
    /* subversion */
    static final int HTTP_REPORT      = 15;
    static final int HTTP_MKACTIVITY  = 16;
    static final int HTTP_CHECKOUT    = 17;
    static final int HTTP_MERGE       = 18;
    /* upnp */
    static final int HTTP_MSEARCH     = 19;
    static final int HTTP_NOTIFY      = 20;
    static final int HTTP_SUBSCRIBE   = 21;
    static final int HTTP_UNSUBSCRIBE = 22;


  //enum http_parser_type
  static final int HTTP_REQUEST   = 0;
  static final int HTTP_RESPONSE  = 1;
  static final int HTTP_BOTH      = 2;


  static class http_parser implements java.io.Serializable {
    /** PRIVATE **/
    /*unsigned char*/ int type; // : 2;
    /*unsigned char*/ int flags; // : 6;
    /*unsigned char*/ int state;
    /*unsigned char*/ int header_state;
    /*unsigned char*/ int index;

    int nread;
    int content_length; // was long...

    /** READ-ONLY **/
    /*unsigned short*/ int http_major;
    /*unsigned short*/ int http_minor;
    /*unsigned short*/ int status_code; /* responses only */
    /*unsigned char*/  int method;    /* requests only */
    /*
    /* 1 = Upgrade header was present and the parser has exited because of that.
     * 0 = No upgrade header present.
     * Should be checked when http_parser_execute() returns in addition to
     * error checking.
     */
    boolean upgrade;

    /** PUBLIC **/
    Object data; /* A pointer to get hook to the "connection" or "socket" object */
  };


  static interface http_parser_settings {
    int on_message_begin(http_parser parser);
    int on_path(http_parser parser, char[] at, int p, int length);
    int on_query_string(http_parser parser, char[] at, int p, int length);
    int on_url(http_parser parser, char[] at, int p, int length);
    int on_fragment(http_parser parser, char[] at, int p, int length);
    int on_header_field(http_parser parser, char[] at, int p, int length);
    int on_header_value(http_parser parser, char[] at, int p, int length);
    int on_headers_complete(http_parser parser);
    int on_body(http_parser parser, char[] at, int p, int length);
    int on_message_complete(http_parser parser);
  };

/*
  void http_parser_init(http_parser parser, http_parser_type type);


  size_t http_parser_execute(http_parser parser,
                             const http_parser_settings *settings,
                             const char *data,
                             size_t len);
*/

  /* If http_should_keep_alive() in the on_headers_complete or
   * on_message_complete callback returns true, then this will be should be
   * the last message on the connection.
   * If you are the server, respond with the "Connection: close" header.
   * If you are the client, close the connection.
   */
//  int http_should_keep_alive(http_parser parser);

  /* Returns a string version of the HTTP method. */
//  char[] http_method_str(enum http_method);

// ---------------------------------- code



static final int MIN(int a, int b) {
  return ((a) < (b) ? (a) : (b));
}


/*
#define CALLBACK2(FOR)                                               \
do {                                                                 \
  if (settings.on_##FOR) {                                          \
    if (0 != settings.on_##FOR(parser)) return (p - data);          \
  }                                                                  \
} while (0)


#define MARK(FOR)                                                    \
do {                                                                 \
  FOR##_mark = p;                                                    \
} while (0)

#define CALLBACK_NOCLEAR(FOR)                                        \
do {                                                                 \
  if (FOR##_mark) {                                                  \
    if (settings.on_##FOR) {                                        \
      if (0 != settings.on_##FOR(parser,                            \
                                 FOR##_mark,                         \
                                 p - FOR##_mark))                    \
      {                                                              \
        return (p - data);                                           \
      }                                                              \
    }                                                                \
  }                                                                  \
} while (0)


#define CALLBACK(FOR)                                                \
do {                                                                 \
  CALLBACK_NOCLEAR(FOR);                                             \
  FOR##_mark = NULL;                                                 \
} while (0)


#define PROXY_CONNECTION "proxy-connection"
#define CONNECTION "connection"
#define CONTENT_LENGTH "content-length"
#define TRANSFER_ENCODING "transfer-encoding"
#define UPGRADE "upgrade"
#define CHUNKED "chunked"
#define KEEP_ALIVE "keep-alive"
#define CLOSE "close"

*/

static int sizeof(char[] array) { return array.length+1; } // account for null terminator!


static final char[] PROXY_CONNECTION = "proxy-connection".toCharArray();
static final char[] CONNECTION = "connection".toCharArray();
static final char[] CONTENT_LENGTH = "content-length".toCharArray();
static final char[] TRANSFER_ENCODING = "transfer-encoding".toCharArray();
static final char[] UPGRADE = "upgrade".toCharArray();
static final char[] CHUNKED = "chunked".toCharArray();
static final char[] KEEP_ALIVE = "keep-alive".toCharArray();
static final char[] CLOSE = "close".toCharArray();


static final String method_strings0[] =
  { "DELETE"
  , "GET"
  , "HEAD"
  , "POST"
  , "PUT"
  , "CONNECT"
  , "OPTIONS"
  , "TRACE"
  , "COPY"
  , "LOCK"
  , "MKCOL"
  , "MOVE"
  , "PROPFIND"
  , "PROPPATCH"
  , "UNLOCK"
  , "REPORT"
  , "MKACTIVITY"
  , "CHECKOUT"
  , "MERGE"
  , "M-SEARCH"
  , "NOTIFY"
  , "SUBSCRIBE"
  , "UNSUBSCRIBE"
  };

static final char[] method_strings[] =
  { "DELETE".toCharArray()
  , "GET".toCharArray()
  , "HEAD".toCharArray()
  , "POST".toCharArray()
  , "PUT".toCharArray()
  , "CONNECT".toCharArray()
  , "OPTIONS".toCharArray()
  , "TRACE".toCharArray()
  , "COPY".toCharArray()
  , "LOCK".toCharArray()
  , "MKCOL".toCharArray()
  , "MOVE".toCharArray()
  , "PROPFIND".toCharArray()
  , "PROPPATCH".toCharArray()
  , "UNLOCK".toCharArray()
  , "REPORT".toCharArray()
  , "MKACTIVITY".toCharArray()
  , "CHECKOUT".toCharArray()
  , "MERGE".toCharArray()
  , "M-SEARCH".toCharArray()
  , "NOTIFY".toCharArray()
  , "SUBSCRIBE".toCharArray()
  , "UNSUBSCRIBE".toCharArray()
  };


/* Tokens as defined by rfc 2616. Also lowercases them.
 *        token       = 1*<any CHAR except CTLs or separators>
 *     separators     = "(" | ")" | "<" | ">" | "@"
 *                    | "," | ";" | ":" | "\" | <">
 *                    | "/" | "[" | "]" | "?" | "="
 *                    | "{" | "}" | SP | HT
 */
static final char[] tokens = { // 256
/*   0 nul    1 soh    2 stx    3 etx    4 eot    5 enq    6 ack    7 bel  */
        0,       0,       0,       0,       0,       0,       0,       0,
/*   8 bs     9 ht    10 nl    11 vt    12 np    13 cr    14 so    15 si   */
        0,       0,       0,       0,       0,       0,       0,       0,
/*  16 dle   17 dc1   18 dc2   19 dc3   20 dc4   21 nak   22 syn   23 etb */
        0,       0,       0,       0,       0,       0,       0,       0,
/*  24 can   25 em    26 sub   27 esc   28 fs    29 gs    30 rs    31 us  */
        0,       0,       0,       0,       0,       0,       0,       0,
/*  32 sp    33  !    34  "    35  #    36  $    37  %    38  &    39  '  */
       ' ',      '!',     '"',     '#',     '$',     '%',     '&',    '\'',
/*  40  (    41  )    42  *    43  +    44  ,    45  -    46  .    47  /  */
        0,       0,      '*',     '+',      0,      '-',     '.',     '/',
/*  48  0    49  1    50  2    51  3    52  4    53  5    54  6    55  7  */
       '0',     '1',     '2',     '3',     '4',     '5',     '6',     '7',
/*  56  8    57  9    58  :    59  ;    60  <    61  =    62  >    63  ?  */
       '8',     '9',      0,       0,       0,       0,       0,       0,
/*  64  @    65  A    66  B    67  C    68  D    69  E    70  F    71  G  */
        0,      'a',     'b',     'c',     'd',     'e',     'f',     'g',
/*  72  H    73  I    74  J    75  K    76  L    77  M    78  N    79  O  */
       'h',     'i',     'j',     'k',     'l',     'm',     'n',     'o',
/*  80  P    81  Q    82  R    83  S    84  T    85  U    86  V    87  W  */
       'p',     'q',     'r',     's',     't',     'u',     'v',     'w',
/*  88  X    89  Y    90  Z    91  [    92  \    93  ]    94  ^    95  _  */
       'x',     'y',     'z',      0,       0,       0,      '^',     '_',
/*  96  `    97  a    98  b    99  c   100  d   101  e   102  f   103  g  */
       '`',     'a',     'b',     'c',     'd',     'e',     'f',     'g',
/* 104  h   105  i   106  j   107  k   108  l   109  m   110  n   111  o  */
       'h',     'i',     'j',     'k',     'l',     'm',     'n',     'o',
/* 112  p   113  q   114  r   115  s   116  t   117  u   118  v   119  w  */
       'p',     'q',     'r',     's',     't',     'u',     'v',     'w',
/* 120  x   121  y   122  z   123  {   124  |   125  }   126  ~   127 del */
       'x',     'y',     'z',      0,      '|',     '}',     '~',       0 };


static final byte unhex[] = // 256
  {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
  ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
  ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
  , 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,-1,-1,-1,-1,-1,-1
  ,-1,10,11,12,13,14,15,-1,-1,-1,-1,-1,-1,-1,-1,-1
  ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
  ,-1,10,11,12,13,14,15,-1,-1,-1,-1,-1,-1,-1,-1,-1
  ,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
  };


static final byte normal_url_char[] = { // 256
/*   0 nul    1 soh    2 stx    3 etx    4 eot    5 enq    6 ack    7 bel  */
        0,       0,       0,       0,       0,       0,       0,       0,
/*   8 bs     9 ht    10 nl    11 vt    12 np    13 cr    14 so    15 si   */
        0,       0,       0,       0,       0,       0,       0,       0,
/*  16 dle   17 dc1   18 dc2   19 dc3   20 dc4   21 nak   22 syn   23 etb */
        0,       0,       0,       0,       0,       0,       0,       0,
/*  24 can   25 em    26 sub   27 esc   28 fs    29 gs    30 rs    31 us  */
        0,       0,       0,       0,       0,       0,       0,       0,
/*  32 sp    33  !    34  "    35  #    36  $    37  %    38  &    39  '  */
        0,       1,       1,       0,       1,       1,       1,       1,
/*  40  (    41  )    42  *    43  +    44  ,    45  -    46  .    47  /  */
        1,       1,       1,       1,       1,       1,       1,       1,
/*  48  0    49  1    50  2    51  3    52  4    53  5    54  6    55  7  */
        1,       1,       1,       1,       1,       1,       1,       1,
/*  56  8    57  9    58  :    59  ;    60  <    61  =    62  >    63  ?  */
        1,       1,       1,       1,       1,       1,       1,       0,
/*  64  @    65  A    66  B    67  C    68  D    69  E    70  F    71  G  */
        1,       1,       1,       1,       1,       1,       1,       1,
/*  72  H    73  I    74  J    75  K    76  L    77  M    78  N    79  O  */
        1,       1,       1,       1,       1,       1,       1,       1,
/*  80  P    81  Q    82  R    83  S    84  T    85  U    86  V    87  W  */
        1,       1,       1,       1,       1,       1,       1,       1,
/*  88  X    89  Y    90  Z    91  [    92  \    93  ]    94  ^    95  _  */
        1,       1,       1,       1,       1,       1,       1,       1,
/*  96  `    97  a    98  b    99  c   100  d   101  e   102  f   103  g  */
        1,       1,       1,       1,       1,       1,       1,       1,
/* 104  h   105  i   106  j   107  k   108  l   109  m   110  n   111  o  */
        1,       1,       1,       1,       1,       1,       1,       1,
/* 112  p   113  q   114  r   115  s   116  t   117  u   118  v   119  w  */
        1,       1,       1,       1,       1,       1,       1,       1,
/* 120  x   121  y   122  z   123  {   124  |   125  }   126  ~   127 del */
        1,       1,       1,       1,       1,       1,       1,       0,

/* Remainder of non-ASCII range are accepted as-is to support implicitly UTF-8
   encoded paths. This is out of spec, but clients generate this and most other
   HTTP servers support it. We should, too. */

        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1,
        1,       1,       1,       1,       1,       1,       1,       1 };


//enum state
  static final int s_dead = 1; /* important that this is > 0 */

  static final int s_start_req_or_res             =  2;
  static final int s_res_or_resp_H                =  3;
  static final int s_start_res                    =  4;
  static final int s_res_H                        =  5;
  static final int s_res_HT                       =  6;
  static final int s_res_HTT                      =  7;
  static final int s_res_HTTP                     =  8;
  static final int s_res_first_http_major         =  9;
  static final int s_res_http_major               = 10;
  static final int s_res_first_http_minor         = 11;
  static final int s_res_http_minor               = 12;
  static final int s_res_first_status_code        = 13;
  static final int s_res_status_code              = 14;
  static final int s_res_status                   = 15;
  static final int s_res_line_almost_done         = 16;

  static final int s_start_req                    = 17;
  static final int s_start_req2                   = 55; // FIXME

  static final int s_req_method                   = 18;
  static final int s_req_spaces_before_url        = 19;
  static final int s_req_schema                   = 20;
  static final int s_req_schema_slash             = 21;
  static final int s_req_schema_slash_slash       = 22;
  static final int s_req_host                     = 23;
  static final int s_req_port                     = 24;
  static final int s_req_path                     = 25;
  static final int s_req_query_string_start       = 26;
  static final int s_req_query_string             = 27;
  static final int s_req_fragment_start           = 28;
  static final int s_req_fragment                 = 29;
  static final int s_req_http_start               = 30;
  static final int s_req_http_H                   = 31;
  static final int s_req_http_HT                  = 32;
  static final int s_req_http_HTT                 = 33;
  static final int s_req_http_HTTP                = 34;
  static final int s_req_first_http_major         = 35;
  static final int s_req_http_major               = 36;
  static final int s_req_first_http_minor         = 37;
  static final int s_req_http_minor               = 38;
  static final int s_req_line_almost_done         = 39;

  static final int s_header_field_start           = 40;
  static final int s_header_field                 = 41;
  static final int s_header_value_start           = 42;
  static final int s_header_value                 = 43;

  static final int s_header_almost_done           = 44;

  static final int s_chunk_size_start             = 45;
  static final int s_chunk_size                   = 46;
  static final int s_chunk_parameters             = 47;
  static final int s_chunk_size_almost_done       = 48;

  static final int s_headers_almost_done          = 49;
  /* Important: 's_headers_almost_done' must be the last 'header' state. All
   * states beyond this must be 'body' states. It is used for overflow
   * checking. See the PARSING_HEADER() macro.
   */

  static final int s_chunk_data                   = 50;
  static final int s_chunk_data_almost_done       = 51;
  static final int s_chunk_data_done              = 52;

  static final int s_body_identity                = 53;
  static final int s_body_identity_eof            = 54;


static boolean PARSING_HEADER(int state) {
  return (state <= s_headers_almost_done);
}


//enum header_states
  static final int h_general                              =  0;
  static final int h_C                                    =  1;
  static final int h_CO                                   =  2;
  static final int h_CON                                  =  3;

  static final int h_matching_connection                  =  4;
  static final int h_matching_proxy_connection            =  5;
  static final int h_matching_content_length              =  6;
  static final int h_matching_transfer_encoding           =  7;
  static final int h_matching_upgrade                     =  8;

  static final int h_connection                           =  9;
  static final int h_content_length                       = 10;
  static final int h_transfer_encoding                    = 11;
  static final int h_upgrade                              = 12;

  static final int h_matching_transfer_encoding_chunked   = 13;
  static final int h_matching_connection_keep_alive       = 14;
  static final int h_matching_connection_close            = 15;

  static final int h_transfer_encoding_chunked            = 16;
  static final int h_connection_keep_alive                = 17;
  static final int h_connection_close                     = 18;


//enum flags
  static final int F_CHUNKED               = 1 << 0;
  static final int F_CONNECTION_KEEP_ALIVE = 1 << 1;
  static final int F_CONNECTION_CLOSE      = 1 << 2;
  static final int F_TRAILING              = 1 << 3;
  static final int F_UPGRADE               = 1 << 4;
  static final int F_SKIPBODY              = 1 << 5;


  static final char CR = '\r';
  static final char LF = '\n';

//#define LOWER(c) (unsigned char)(c | 0x20)
//#define TOKEN(c) tokens[(unsigned char)c]

  static char LOWER(int c) { return (char)(c | 0x20); }
  static char TOKEN(int c) { return tokens[c]; }


//#define start_state (parser->type == HTTP_REQUEST ? s_start_req : s_start_res)
  static int start_state(http_parser parser) { return (parser.type == HTTP_REQUEST ? s_start_req : s_start_res); }

/*
#if HTTP_PARSER_STRICT
# define STRICT_CHECK(cond) if (cond) break error
# define NEW_MESSAGE() (http_should_keep_alive(parser) ? start_state : s_dead)
#else
# define STRICT_CHECK(cond)
# define NEW_MESSAGE() start_state
#endif
*/

  static void STRICT_CHECK(boolean cond) { }
  static int NEW_MESSAGE(http_parser parser) { return start_state(parser); }

  static class FailException extends RuntimeException { };

  static final FailException error = new FailException();



static int http_parser_execute (http_parser parser,
                            http_parser_settings settings,
                            char[] data,
                            int off,
                            int len)
{
  char c, ch;
  //const char *p = data, *pe;
  int p = off, pe;
  int to_read; // was long..

  /*enum state*/int state = parser.state;
  /*enum header_states*/int header_state = parser.header_state;
  int index = parser.index; // was long...
  int nread = parser.nread; // was long...

  try {
  if (len == 0) {
    switch (state) {
      case s_body_identity_eof:
        if (0 != settings.on_message_complete(parser)) return p;
        return 0;

      case s_dead:
      case s_start_req_or_res:
      case s_start_res:
      case s_start_req:
        return 0;

      default:
        return 1; // error
    }
  }

  /* technically we could combine all of these (except for url_mark) into one
     variable, saving stack space, but it seems more clear to have them
     separated. */
/*
  const char *header_field_mark = -1;
  const char *header_value_mark = -1;
  const char *fragment_mark = -1;
  const char *query_string_mark = -1;
  const char *path_mark = -1;
  const char *url_mark = -1;
*/
  int header_field_mark = -1;
  int header_value_mark = -1;
  int fragment_mark = -1;
  int query_string_mark = -1;
  int path_mark = -1;
  int url_mark = -1;

  if (state == s_header_field)
    header_field_mark = -1;
  if (state == s_header_value)
    header_value_mark = -1;
  if (state == s_req_fragment)
    fragment_mark = -1;
  if (state == s_req_query_string)
    query_string_mark = -1;
  if (state == s_req_path)
    path_mark = -1;
  if (state == s_req_path || state == s_req_schema || state == s_req_schema_slash
      || state == s_req_schema_slash_slash || state == s_req_port
      || state == s_req_query_string_start || state == s_req_query_string
      || state == s_req_host
      || state == s_req_fragment_start || state == s_req_fragment)
    url_mark = -1;

  for (p=off, pe=off+len; p != pe; p++) {
    ch = data[p];

    if (PARSING_HEADER(state)) {
      ++nread;
      /* Buffer overflow attack */
      if (nread > HTTP_MAX_HEADER_SIZE) throw error;
    }

    //System.out.println("--state "+state+" "+ch+" "+p);

    outerswitch: do { switch (state) {

      case s_dead:
        /* this state is used after a 'Connection: close' message
         * the parser will error out if it reads another message
         */
        throw error;

      case s_start_req_or_res:
      {
        if (ch == CR || ch == LF)
          break;
        parser.flags = 0;
        parser.content_length = -1;

        if (0 != settings.on_message_begin(parser)) return p;

        if (ch == 'H')
          state = s_res_or_resp_H;
        else {
          parser.type = HTTP_REQUEST;
          //continue start_req_method_assign;
          state = s_start_req2;
          continue outerswitch;
        }
        break;
      }

      case s_res_or_resp_H:
        if (ch == 'T') {
          parser.type = HTTP_RESPONSE;
          state = s_res_HT;
        } else {
          if (ch != 'E') throw error;
          parser.type = HTTP_REQUEST;
          parser.method = HTTP_HEAD;
          index = 2;
          state = s_req_method;
        }
        break;

      case s_start_res:
      {
        parser.flags = 0;
        parser.content_length = -1;

        if (0 != settings.on_message_begin(parser)) return p;

        switch (ch) {
          case 'H':
            state = s_res_H;
            break;

          case CR:
          case LF:
            break;

          default:
            throw error;
        }
        break;
      }

      case s_res_H:
        STRICT_CHECK(ch != 'T');
        state = s_res_HT;
        break;

      case s_res_HT:
        STRICT_CHECK(ch != 'T');
        state = s_res_HTT;
        break;

      case s_res_HTT:
        STRICT_CHECK(ch != 'P');
        state = s_res_HTTP;
        break;

      case s_res_HTTP:
        STRICT_CHECK(ch != '/');
        state = s_res_first_http_major;
        break;

      case s_res_first_http_major:
        if (ch < '1' || ch > '9') throw error;
        parser.http_major = ch - '0';
        state = s_res_http_major;
        break;

      /* major HTTP version or dot */
      case s_res_http_major:
      {
        if (ch == '.') {
          state = s_res_first_http_minor;
          break;
        }

        if (ch < '0' || ch > '9') throw error;

        parser.http_major *= 10;
        parser.http_major += ch - '0';

        if (parser.http_major > 999) throw error;
        break;
      }

      /* first digit of minor HTTP version */
      case s_res_first_http_minor:
        if (ch < '0' || ch > '9') throw error;
        parser.http_minor = ch - '0';
        state = s_res_http_minor;
        break;

      /* minor HTTP version or end of request line */
      case s_res_http_minor:
      {
        if (ch == ' ') {
          state = s_res_first_status_code;
          break;
        }

        if (ch < '0' || ch > '9') throw error;

        parser.http_minor *= 10;
        parser.http_minor += ch - '0';

        if (parser.http_minor > 999) throw error;
        break;
      }

      case s_res_first_status_code:
      {
        if (ch < '0' || ch > '9') {
          if (ch == ' ') {
            break;
          }
          throw error;
        }
        parser.status_code = ch - '0';
        state = s_res_status_code;
        break;
      }

      case s_res_status_code:
      {
        if (ch < '0' || ch > '9') {
          switch (ch) {
            case ' ':
              state = s_res_status;
              break;
            case CR:
              state = s_res_line_almost_done;
              break;
            case LF:
              state = s_header_field_start;
              break;
            default:
              throw error;
          }
          break;
        }

        parser.status_code *= 10;
        parser.status_code += ch - '0';

        if (parser.status_code > 999) throw error;
        break;
      }

      case s_res_status:
        /* the human readable status. e.g. "NOT FOUND"
         * we are not humans so just ignore this */
        if (ch == CR) {
          state = s_res_line_almost_done;
          break;
        }

        if (ch == LF) {
          state = s_header_field_start;
          break;
        }
        break;

      case s_res_line_almost_done:
        STRICT_CHECK(ch != LF);
        state = s_header_field_start;
        break;

      case s_start_req:
      {
        if (ch == CR || ch == LF)
          break;
        parser.flags = 0;
        parser.content_length = -1;

        if (0 != settings.on_message_begin(parser)) return p;

        if (ch < 'A' || 'Z' < ch) throw error;
      }
      case s_start_req2:
      start_req_method_assign:
      {
        parser.method = /*(enum http_method)*/ 0;
        index = 1;
        switch (ch) {
          case 'C': parser.method = HTTP_CONNECT; /* or COPY, CHECKOUT */ break;
          case 'D': parser.method = HTTP_DELETE; break;
          case 'G': parser.method = HTTP_GET; break;
          case 'H': parser.method = HTTP_HEAD; break;
          case 'L': parser.method = HTTP_LOCK; break;
          case 'M': parser.method = HTTP_MKCOL; /* or MOVE, MKACTIVITY, MERGE, M-SEARCH */ break;
          case 'N': parser.method = HTTP_NOTIFY; break;
          case 'O': parser.method = HTTP_OPTIONS; break;
          case 'P': parser.method = HTTP_POST; /* or PROPFIND or PROPPATCH or PUT */ break;
          case 'R': parser.method = HTTP_REPORT; break;
          case 'S': parser.method = HTTP_SUBSCRIBE; break;
          case 'T': parser.method = HTTP_TRACE; break;
          case 'U': parser.method = HTTP_UNLOCK; /* or UNSUBSCRIBE */ break;
          default: throw error;
        }
        state = s_req_method;
        break;
      }

      case s_req_method:
      {
        if (ch == '\0')
          throw error;

        char[] matcher = method_strings[parser.method];

        if (ch == ' ' && index == matcher.length/*matcher[(int)index] == '\0'*/) {
          state = s_req_spaces_before_url;
        } else if (index >= matcher.length) {
          throw error;
        } else if (ch == matcher[(int)index]) {
          ; /* nada */
        } else if (parser.method == HTTP_CONNECT) {
          if (index == 1 && ch == 'H') {
            parser.method = HTTP_CHECKOUT;
          } else if (index == 2  && ch == 'P') {
            parser.method = HTTP_COPY;
          }
        } else if (parser.method == HTTP_MKCOL) {
          if (index == 1 && ch == 'O') {
            parser.method = HTTP_MOVE;
          } else if (index == 1 && ch == 'E') {
            parser.method = HTTP_MERGE;
          } else if (index == 1 && ch == '-') {
            parser.method = HTTP_MSEARCH;
          } else if (index == 2 && ch == 'A') {
            parser.method = HTTP_MKACTIVITY;
          }
        } else if (index == 1 && parser.method == HTTP_POST && ch == 'R') {
          parser.method = HTTP_PROPFIND; /* or HTTP_PROPPATCH */
        } else if (index == 1 && parser.method == HTTP_POST && ch == 'U') {
          parser.method = HTTP_PUT;
        } else if (index == 2 && parser.method == HTTP_UNLOCK && ch == 'S') {
          parser.method = HTTP_UNSUBSCRIBE;
        } else if (index == 4 && parser.method == HTTP_PROPFIND && ch == 'P') {
          parser.method = HTTP_PROPPATCH;
        } else {
          throw error;
        }

        ++index;
        break;
      }
      case s_req_spaces_before_url:
      {
        if (ch == ' ') break;

        if (ch == '/' || ch == '*') {
          url_mark = p;
          path_mark = p;
          state = s_req_path;
          break;
        }

        c = LOWER(ch);

        if (c >= 'a' && c <= 'z') {
          url_mark = p;
          state = s_req_schema;
          break;
        }

        throw error;
      }

      case s_req_schema:
      {
        c = LOWER(ch);

        if (c >= 'a' && c <= 'z') break;

        if (ch == ':') {
          state = s_req_schema_slash;
          break;
        } else if (ch == '.') {
          state = s_req_host;
          break;
        } else if ('0' <= ch && ch <= '9') {
          state = s_req_host;
          break;
        }

        throw error;
      }

      case s_req_schema_slash:
        STRICT_CHECK(ch != '/');
        state = s_req_schema_slash_slash;
        break;

      case s_req_schema_slash_slash:
        STRICT_CHECK(ch != '/');
        state = s_req_host;
        break;

      case s_req_host:
      {
        c = LOWER(ch);
        if (c >= 'a' && c <= 'z') break;
        if ((ch >= '0' && ch <= '9') || ch == '.' || ch == '-') break;
        switch (ch) {
          case ':':
            state = s_req_port;
            break;
          case '/':
            path_mark = p;
            state = s_req_path;
            break;
          case ' ':
            /* The request line looks like:
             *   "GET http://foo.bar.com HTTP/1.1"
             * That is, there is no path.
             */
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            state = s_req_http_start;
            break;
          case '?':
            state = s_req_query_string_start;
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_port:
      {
        if (ch >= '0' && ch <= '9') break;
        switch (ch) {
          case '/':
            path_mark = p;
            state = s_req_path;
            break;
          case ' ':
            /* The request line looks like:
             *   "GET http://foo.bar.com:1234 HTTP/1.1"
             * That is, there is no path.
             */
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            state = s_req_http_start;
            break;
          case '?':
            state = s_req_query_string_start;
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_path:
      {
        if (normal_url_char[ch] != 0) break;

        switch (ch) {
          case ' ':
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            if (path_mark >= 0 && 0 != settings.on_path(parser, data, path_mark, p - path_mark)) return p;
            url_mark = -1;
            path_mark = -1;
            state = s_req_http_start;
            break;
          case CR:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            if (path_mark >= 0 && 0 != settings.on_path(parser, data, path_mark, p - path_mark)) return p;
            url_mark = -1;
            path_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_req_line_almost_done;
            break;
          case LF:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            if (path_mark >= 0 && 0 != settings.on_path(parser, data, path_mark, p - path_mark)) return p;
            url_mark = -1;
            path_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_header_field_start;
            break;
          case '?':
            if (path_mark >= 0 && 0 != settings.on_path(parser, data, path_mark, p - path_mark)) return p;
            path_mark = -1;
            state = s_req_query_string_start;
            break;
          case '#':
            if (path_mark >= 0 && 0 != settings.on_path(parser, data, path_mark, p - path_mark)) return p;
            path_mark = -1;
            state = s_req_fragment_start;
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_query_string_start:
      {
        if (normal_url_char[ch] != 0) {
          query_string_mark = p;
          state = s_req_query_string;
          break;
        }

        switch (ch) {
          case '?':
            break; /* XXX ignore extra '?' ... is this right? */
          case ' ':
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            state = s_req_http_start;
            break;
          case CR:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_req_line_almost_done;
            break;
          case LF:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_header_field_start;
            break;
          case '#':
            state = s_req_fragment_start;
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_query_string:
      {
        if (normal_url_char[ch] != 0) break;

        switch (ch) {
          case '?':
            /* allow extra '?' in query string */
            break;
          case ' ':
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            if (query_string_mark >= 0 && 0 != settings.on_query_string(parser, data, query_string_mark, p - query_string_mark)) return p;
            url_mark = -1;
            query_string_mark = -1;
            state = s_req_http_start;
            break;
          case CR:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            if (query_string_mark >= 0 && 0 != settings.on_query_string(parser, data, query_string_mark, p - query_string_mark)) return p;
            url_mark = -1;
            query_string_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_req_line_almost_done;
            break;
          case LF:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            if (query_string_mark >= 0 && 0 != settings.on_query_string(parser, data, query_string_mark, p - query_string_mark)) return p;
            url_mark = -1;
            query_string_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_header_field_start;
            break;
          case '#':
            if (query_string_mark >= 0 && 0 != settings.on_query_string(parser, data, query_string_mark, p - query_string_mark)) return p;
            query_string_mark = -1;
            state = s_req_fragment_start;
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_fragment_start:
      {
        if (normal_url_char[ch] != 0) {
          fragment_mark = p;
          state = s_req_fragment;
          break;
        }

        switch (ch) {
          case ' ':
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            state = s_req_http_start;
            break;
          case CR:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_req_line_almost_done;
            break;
          case LF:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_header_field_start;
            break;
          case '?':
            fragment_mark = p;
            state = s_req_fragment;
            break;
          case '#':
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_fragment:
      {
        if (normal_url_char[ch] != 0) break;

        switch (ch) {
          case ' ':
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            if (fragment_mark >= 0 && 0 != settings.on_fragment(parser, data, fragment_mark, p - fragment_mark)) return p;
            fragment_mark = -1;
            state = s_req_http_start;
            break;
          case CR:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            if (fragment_mark >= 0 && 0 != settings.on_fragment(parser, data, fragment_mark, p - fragment_mark)) return p;
            fragment_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_req_line_almost_done;
            break;
          case LF:
            if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;
            url_mark = -1;
            if (fragment_mark >= 0 && 0 != settings.on_fragment(parser, data, fragment_mark, p - fragment_mark)) return p;
            fragment_mark = -1;
            parser.http_major = 0;
            parser.http_minor = 9;
            state = s_header_field_start;
            break;
          case '?':
          case '#':
            break;
          default:
            throw error;
        }
        break;
      }

      case s_req_http_start:
        switch (ch) {
          case 'H':
            state = s_req_http_H;
            break;
          case ' ':
            break;
          default:
            throw error;
        }
        break;

      case s_req_http_H:
        STRICT_CHECK(ch != 'T');
        state = s_req_http_HT;
        break;

      case s_req_http_HT:
        STRICT_CHECK(ch != 'T');
        state = s_req_http_HTT;
        break;

      case s_req_http_HTT:
        STRICT_CHECK(ch != 'P');
        state = s_req_http_HTTP;
        break;

      case s_req_http_HTTP:
        STRICT_CHECK(ch != '/');
        state = s_req_first_http_major;
        break;

      /* first digit of major HTTP version */
      case s_req_first_http_major:
        if (ch < '1' || ch > '9') throw error;
        parser.http_major = ch - '0';
        state = s_req_http_major;
        break;

      /* major HTTP version or dot */
      case s_req_http_major:
      {
        if (ch == '.') {
          state = s_req_first_http_minor;
          break;
        }

        if (ch < '0' || ch > '9') throw error;

        parser.http_major *= 10;
        parser.http_major += ch - '0';

        if (parser.http_major > 999) throw error;
        break;
      }

      /* first digit of minor HTTP version */
      case s_req_first_http_minor:
        if (ch < '0' || ch > '9') throw error;
        parser.http_minor = ch - '0';
        state = s_req_http_minor;
        break;

      /* minor HTTP version or end of request line */
      case s_req_http_minor:
      {
        if (ch == CR) {
          state = s_req_line_almost_done;
          break;
        }

        if (ch == LF) {
          state = s_header_field_start;
          break;
        }

        /* XXX allow spaces after digit? */

        if (ch < '0' || ch > '9') throw error;

        parser.http_minor *= 10;
        parser.http_minor += ch - '0';

        if (parser.http_minor > 999) throw error;
        break;
      }

      /* end of request line */
      case s_req_line_almost_done:
      {
        if (ch != LF) throw error;
        state = s_header_field_start;
        break;
      }

      case s_header_field_start:
      {
        if (ch == CR) {
          state = s_headers_almost_done;
          break;
        }

        if (ch == LF) {
          /* they might be just sending \n instead of \r\n so this would be
           * the second \n to denote the end of headers*/
          state = s_headers_almost_done;
          //continue headers_almost_done;
          continue outerswitch;
        }

        c = TOKEN(ch);

        if (c == 0) throw error;

        header_field_mark = p;

        index = 0;
        state = s_header_field;

        switch (c) {
          case 'c':
            header_state = h_C;
            break;

          case 'p':
            header_state = h_matching_proxy_connection;
            break;

          case 't':
            header_state = h_matching_transfer_encoding;
            break;

          case 'u':
            header_state = h_matching_upgrade;
            break;

          default:
            header_state = h_general;
            break;
        }
        break;
      }

      case s_header_field:
      {
        c = TOKEN(ch);

        if (c != 0) {
          //System.out.println("---- header state " + header_state);
          switch (header_state) {
            case h_general:
              break;

            case h_C:
              index++;
              header_state = (c == 'o' ? h_CO : h_general);
              break;

            case h_CO:
              index++;
              header_state = (c == 'n' ? h_CON : h_general);
              break;

            case h_CON:
              index++;
              switch (c) {
                case 'n':
                  header_state = h_matching_connection;
                  break;
                case 't':
                  header_state = h_matching_content_length;
                  break;
                default:
                  header_state = h_general;
                  break;
              }
              break;

            /* connection */

            case h_matching_connection:
              index++;
              if (index > sizeof(CONNECTION)-1
                  || c != CONNECTION[index]) {
                header_state = h_general;
              } else if (index == sizeof(CONNECTION)-2) {
                header_state = h_connection;
              }
              break;

            /* proxy-connection */

            case h_matching_proxy_connection:
              index++;
              if (index > sizeof(PROXY_CONNECTION)-1
                  || c != PROXY_CONNECTION[index]) {
                header_state = h_general;
              } else if (index == sizeof(PROXY_CONNECTION)-2) {
                header_state = h_connection;
              }
              break;

            /* content-length */

            case h_matching_content_length:
              index++;
              if (index > sizeof(CONTENT_LENGTH)-1
                  || c != CONTENT_LENGTH[index]) {
                header_state = h_general;
              } else if (index == sizeof(CONTENT_LENGTH)-2) {
                header_state = h_content_length;
              }
              break;

            /* transfer-encoding */

            case h_matching_transfer_encoding:
              index++;
              if (index > sizeof(TRANSFER_ENCODING)-1
                  || c != TRANSFER_ENCODING[index]) {
                header_state = h_general;
              } else if (index == sizeof(TRANSFER_ENCODING)-2) {
                header_state = h_transfer_encoding;
              }
              break;

            /* upgrade */

            case h_matching_upgrade:
              index++;
              if (index > sizeof(UPGRADE)-1
                  || c != UPGRADE[index]) {
                header_state = h_general;
              } else if (index == sizeof(UPGRADE)-2) {
                header_state = h_upgrade;
              }
              break;

            case h_connection:
            case h_content_length:
            case h_transfer_encoding:
            case h_upgrade:
              if (ch != ' ') header_state = h_general;
              break;

            default:
              assert(false): "Unknown header_state";
              break;
          }
          break;
        }

        if (ch == ':') {
          if (header_field_mark >= 0 && 0 != settings.on_header_field(parser, data, header_field_mark, p - header_field_mark)) return p;
          header_field_mark = -1;
          state = s_header_value_start;
          break;
        }

        if (ch == CR) {
          state = s_header_almost_done;
          if (header_field_mark >= 0 && 0 != settings.on_header_field(parser, data, header_field_mark, p - header_field_mark)) return p;
          header_field_mark = -1;
          break;
        }

        if (ch == LF) {
          if (header_field_mark >= 0 && 0 != settings.on_header_field(parser, data, header_field_mark, p - header_field_mark)) return p;
          header_field_mark = -1;
          state = s_header_field_start;
          break;
        }

        throw error;
      }

      case s_header_value_start:
      {
        if (ch == ' ') break;

        header_value_mark = p;

        state = s_header_value;
        index = 0;

        c = LOWER(ch);

        if (ch == CR) {
          if (header_value_mark >= 0 && 0 != settings.on_header_value(parser, data, header_value_mark, p - header_value_mark)) return p;
          header_value_mark = -1;
          header_state = h_general;
          state = s_header_almost_done;
          break;
        }

        if (ch == LF) {
          if (header_value_mark >= 0 && 0 != settings.on_header_value(parser, data, header_value_mark, p - header_value_mark)) return p;
          header_value_mark = -1;
          state = s_header_field_start;
          break;
        }

        //System.out.println("---- header state " + header_state);

        switch (header_state) {
          case h_upgrade:
            parser.flags |= F_UPGRADE;
            header_state = h_general;
            break;

          case h_transfer_encoding:
            /* looking for 'Transfer-Encoding: chunked' */
            if ('c' == c) {
              header_state = h_matching_transfer_encoding_chunked;
            } else {
              header_state = h_general;
            }
            break;

          case h_content_length:
            if (ch < '0' || ch > '9') throw error;
            parser.content_length = ch - '0';
            break;

          case h_connection:
            /* looking for 'Connection: keep-alive' */
            if (c == 'k') {
              header_state = h_matching_connection_keep_alive;
            /* looking for 'Connection: close' */
            } else if (c == 'c') {
              header_state = h_matching_connection_close;
            } else {
              header_state = h_general;
            }
            break;

          default:
            header_state = h_general;
            break;
        }
        break;
      }

      case s_header_value:
      {
        c = LOWER(ch);

        if (ch == CR) {
          if (header_value_mark >= 0 && 0 != settings.on_header_value(parser, data, header_value_mark, p - header_value_mark)) return p;
          header_value_mark = -1;
          state = s_header_almost_done;
          break;
        }

        if (ch == LF) {
          if (header_value_mark >= 0 && 0 != settings.on_header_value(parser, data, header_value_mark, p - header_value_mark)) return p;
          header_value_mark = -1;
          //continue header_almost_done;
          state = s_header_almost_done;
          continue outerswitch;
        }

        //System.out.println("---- header state " + header_state);

        switch (header_state) {
          case h_general:
            break;

          case h_connection:
          case h_transfer_encoding:
            assert(false): "Shouldn't get here.";
            break;

          case h_content_length:
            if (ch == ' ') break;
            if (ch < '0' || ch > '9') throw error;
            parser.content_length *= 10;
            parser.content_length += ch - '0';
            break;

          /* Transfer-Encoding: chunked */
          case h_matching_transfer_encoding_chunked:
            index++;
            if (index > sizeof(CHUNKED)-1
                || c != CHUNKED[index]) {
              header_state = h_general;
            } else if (index == sizeof(CHUNKED)-2) {
              header_state = h_transfer_encoding_chunked;
            }
            break;

          /* looking for 'Connection: keep-alive' */
          case h_matching_connection_keep_alive:
            index++;
            if (index > sizeof(KEEP_ALIVE)-1
                || c != KEEP_ALIVE[index]) {
              header_state = h_general;
            } else if (index == sizeof(KEEP_ALIVE)-2) {
              header_state = h_connection_keep_alive;
            }
            break;

          /* looking for 'Connection: close' */
          case h_matching_connection_close:
            index++;
            if (index > sizeof(CLOSE)-1 || c != CLOSE[index]) {
              header_state = h_general;
            } else if (index == sizeof(CLOSE)-2) {
              header_state = h_connection_close;
            }
            break;

          case h_transfer_encoding_chunked:
          case h_connection_keep_alive:
          case h_connection_close:
            if (ch != ' ') header_state = h_general;
            break;

          default:
            state = s_header_value;
            header_state = h_general;
            break;
        }
        break;
      }

      case s_header_almost_done:
      header_almost_done:
      {
        STRICT_CHECK(ch != LF);

        state = s_header_field_start;

        switch (header_state) {
          case h_connection_keep_alive:
            parser.flags |= F_CONNECTION_KEEP_ALIVE;
            break;
          case h_connection_close:
            parser.flags |= F_CONNECTION_CLOSE;
            break;
          case h_transfer_encoding_chunked:
            parser.flags |= F_CHUNKED;
            break;
          default:
            break;
        }
        break;
      }

      case s_headers_almost_done:
      headers_almost_done:
      {
        //System.out.println("headers_almost_done. content-length: " + parser.content_length);

        STRICT_CHECK(ch != LF);

        if ((parser.flags & F_TRAILING) != 0) {
          /* End of a chunked request */
          if (0 != settings.on_message_complete(parser)) return p;
          state = NEW_MESSAGE(parser);
          break;
        }

        nread = 0;

        if ((parser.flags & F_UPGRADE) != 0 || parser.method == HTTP_CONNECT) {
          parser.upgrade = true;
        }

        /* Here we call the headers_complete callback. This is somewhat
         * different than other callbacks because if the user returns 1, we
         * will interpret that as saying that this message has no body. This
         * is needed for the annoying case of recieving a response to a HEAD
         * request.
         */
        /*if (settings.on_headers_complete)*/ {
          switch (settings.on_headers_complete(parser)) {
            case 0:
              break;

            case 1:
              parser.flags |= F_SKIPBODY;
              break;

            default:
              parser.state = state;
              return p;/*p - data;*/ /* Error */
          }
        }

        /* Exit, the rest of the connect is in a different protocol. */
        if (parser.upgrade) {
          if (0 != settings.on_message_complete(parser)) return p;
          return p;//(p - data);
        }

        if ((parser.flags & F_SKIPBODY) != 0) {
          if (0 != settings.on_message_complete(parser)) return p;
          state = NEW_MESSAGE(parser);
        } else if ((parser.flags & F_CHUNKED) != 0) {
          /* chunked encoding - ignore Content-Length header */
          state = s_chunk_size_start;
        } else {
          if (parser.content_length == 0) {
            /* Content-Length header given but zero: Content-Length: 0\r\n */
            if (0 != settings.on_message_complete(parser)) return p;
            state = NEW_MESSAGE(parser);
          } else if (parser.content_length > 0) {
            /* Content-Length header given and non-zero */
            state = s_body_identity;
          } else {
            if (parser.type == HTTP_REQUEST || http_should_keep_alive(parser)) {
              /* Assume content-length 0 - read the next */
              if (0 != settings.on_message_complete(parser)) return p;
              state = NEW_MESSAGE(parser);
            } else {
              /* Read body until EOF */
              state = s_body_identity_eof;
            }
          }
        }

        break;
      }

      case s_body_identity:
        to_read = MIN(pe - p, parser.content_length);
        if (to_read > 0) {
          /*if (settings.on_body)*/ settings.on_body(parser, data, p, to_read);
          p += to_read - 1;
          parser.content_length -= to_read;
          if (parser.content_length == 0) {
            if (0 != settings.on_message_complete(parser)) return p;
            state = NEW_MESSAGE(parser);
          }
        }
        break;

      /* read until EOF */
      case s_body_identity_eof:
        to_read = pe - p;
        if (to_read > 0) {
          /*if (settings.on_body)*/ settings.on_body(parser, data, p, to_read);
          p += to_read - 1;
        }
        break;

      case s_chunk_size_start:
      {
        assert(nread == 1);
        assert((parser.flags & F_CHUNKED) != 0);

        c = (char)unhex[ch];
        if (c == -1) throw error;
        parser.content_length = c;
        state = s_chunk_size;
        break;
      }

      case s_chunk_size:
      {
        assert((parser.flags & F_CHUNKED) != 0);

        if (ch == CR) {
          state = s_chunk_size_almost_done;
          break;
        }

        c = (char)unhex[ch];

        if (c == -1) {
          if (ch == ';' || ch == ' ') {
            state = s_chunk_parameters;
            break;
          }
          throw error;
        }

        parser.content_length *= 16;
        parser.content_length += c;
        break;
      }

      case s_chunk_parameters:
      {
        assert((parser.flags & F_CHUNKED) != 0);
        /* just ignore this shit. TODO check for overflow */
        if (ch == CR) {
          state = s_chunk_size_almost_done;
          break;
        }
        break;
      }

      case s_chunk_size_almost_done:
      {
        assert((parser.flags & F_CHUNKED) != 0);
        STRICT_CHECK(ch != LF);

        nread = 0;

        if (parser.content_length == 0) {
          parser.flags |= F_TRAILING;
          state = s_header_field_start;
        } else {
          state = s_chunk_data;
        }
        break;
      }

      case s_chunk_data:
      {
        assert((parser.flags & F_CHUNKED) != 0);

        to_read = MIN(pe - p, (parser.content_length));

        if (to_read > 0) {
          /*if (settings.on_body)*/ settings.on_body(parser, data, p, to_read);
          p += to_read - 1;
        }

        if (to_read == parser.content_length) {
          state = s_chunk_data_almost_done;
        }

        parser.content_length -= to_read;
        break;
      }

      case s_chunk_data_almost_done:
        assert((parser.flags & F_CHUNKED) != 0);
        STRICT_CHECK(ch != CR);
        state = s_chunk_data_done;
        break;

      case s_chunk_data_done:
        assert((parser.flags & F_CHUNKED) != 0);
        STRICT_CHECK(ch != LF);
        state = s_chunk_size_start;
        break;

      default:
        assert(false): "unhandled state";
        throw error;
    } break; } while (true);
  }

  if (header_field_mark >= 0 && 0 != settings.on_header_field(parser, data, header_field_mark, p - header_field_mark)) return p;
  if (header_value_mark >= 0 && 0 != settings.on_header_value(parser, data, header_value_mark, p - header_value_mark)) return p;
  if (fragment_mark >= 0 && 0 != settings.on_fragment(parser, data, fragment_mark, p - fragment_mark)) return p;
  if (query_string_mark >= 0 && 0 != settings.on_query_string(parser, data, query_string_mark, p - query_string_mark)) return p;
  if (path_mark >= 0 && 0 != settings.on_path(parser, data, path_mark, p - path_mark)) return p;
  if (url_mark >= 0 && 0 != settings.on_url(parser, data, url_mark, p - url_mark)) return p;

  parser.state = state;
  parser.header_state = header_state;
  parser.index = index;
  parser.nread = nread;

  return len;
  } catch (RuntimeException e) {
    if (e != error) throw e;
    //System.out.println("FAIL");
    parser.state = s_dead;
    return p;
  }
}


static boolean
http_should_keep_alive (http_parser parser)
{
  if (parser.http_major > 0 && parser.http_minor > 0) {
    /* HTTP/1.1 */
    if ((parser.flags & F_CONNECTION_CLOSE) != 0) {
      return false;
    } else {
      return true;
    }
  } else {
    /* HTTP/1.0 or earlier */
    if ((parser.flags & F_CONNECTION_KEEP_ALIVE) != 0) {
      return true;
    } else {
      return false;
    }
  }
}


static char[] http_method_str (/*enum http_method*/ int m)
{
  return method_strings[m];
}


static http_parser
http_parser_init (/*enum http_parser_type*/ int t)
{
  http_parser parser = new http_parser();
  parser.type = t;
  parser.state = (t == HTTP_REQUEST ? s_start_req : (t == HTTP_RESPONSE ? s_start_res : s_start_req_or_res));
  parser.nread = 0;
  parser.upgrade = false;
  parser.flags = 0;
  parser.method = 0;
  return parser;
}

}