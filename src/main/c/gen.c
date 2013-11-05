//#include "http_gen.h"
//#include "http_gen_head.h"
#include "http_gen_full.h"
/*
TODO: "const char*" in structures
NULL initialization -> 0 (int) or {} (struct);
*/

#define pHead(H) printf("Status=%d, contentLength=%d, connection=%s, chunked=%d, upgrade=%d\n",(H).status,(H).contentLength,(H).connection,(H).chunked,(H).upgrade)
#define pRes(RES) printf("Empty=%d, next=%d\n",(RES).empty,(RES).next)

char* read_file(const char* path) {
  FILE *fp;
  long lSize;
  char *buffer;
  fp = fopen(path,"rb");
  if(!fp) perror(path),exit(1);
  fseek(fp, 0L, SEEK_END);
  lSize = ftell(fp);
  rewind(fp);

  /* allocate memory for entire content */
  buffer = calloc( 1, lSize+1 );
  if( !buffer ) fclose(fp),fputs("memory alloc fails",stderr),exit(1);

  /* copy the file into the buffer */
  if( 1!=fread( buffer , lSize, 1 , fp) )
    fclose(fp),free(buffer),fputs("entire read fails",stderr),exit(1);

  fclose(fp);

  printf("Input size is %lu\n",lSize);
  return buffer;
}

int main() {
  char* buf = read_file("tweet1");
  /*
  char* buf =
"HTTP/1.1 200 OK\n"
"content-length: 3\n"
"cache-control: no-cache, no-store, must-revalidate, pre-check=0, post-check=0\n"
"content-type: application/json;charset=utf-8\n"
"date: Wed, 04 Sep 2013 13:08:12 GMT\n"
"expires: Tue, 31 Mar 1981 05:00:00 GMT\n"
"last-modified: Wed, 04 Sep 2013 13:08:12 GMT\n"
"pragma: no-cache\n"
"server: tfe\n"
"set-cookie: lang=en\n"
"set-cookie: guest_id=v1%3A137830009237796868; Domain=.twitter.com; Path=/; Expires=Fri, 04-Sep-2015 13:08:12 UTC\n"
"status: 200 OK\n"
"x-access-level: read\n"
"x-frame-options: SAMEORIGIN\n"
"x-rate-limit-limit: 180\n"
"x-rate-limit-remaining: 179\n"
"x-rate-limit-reset: 1378300992\n"
"x-transaction: e3a68f5346dfd762\n"
"\n{}\n";
  //httpNumStatusParse(buf);
  printf("%s\n",buf);
  */
  ParseResultTuple2Anon1323431030String r = respAndMessageParse(buf);
  pRes(r);
  pHead(r.res._1);
  printf("Body = '%s'\n",r.res._2);

  free(buf);
  return 0;
}
