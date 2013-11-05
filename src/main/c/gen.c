//#include "http_gen.h"
//#include "http_gen_head.h"
#include "http_gen_full.h"
/*
TODO:
- "const char*" in structures
- NULL initialization -> 0 (int) or {} (struct);
- Treat constant strings as strings (and not arrays)
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

  //responseParse(buf);

  ParseResultTuple2Anon1323431030String r = respAndMessageParse(buf);
  pRes(r);
  pHead(r.res._1);
  printf("Body = '%s'\n",r.res._2);

  free(buf);
  return 0;
}
