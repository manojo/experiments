//#include "http_gen.h"
//#include "http_gen_head.h"
#include <stdlib.h>

// mini-GC
struct _mem { void* data; struct _mem* next; };
struct _mem* gc=NULL;
#define malloc2(SIZE) ({ void* data=malloc(SIZE); struct _mem* m=malloc(sizeof(struct _mem)); m->data=data; m->next=gc; gc=m; data; })
#define free2 while (gc!=NULL) { free(gc->data); gc=gc->next; }
//#define malloc2 malloc
//#define free2

#include "http_gen_full.h"
#include <sys/time.h>
/*
TODO:
- "const char*" in structures
- NULL initialization -> 0 (int) or {} (struct);
- Treat constant strings as strings (and not arrays)
*/

// /usr/local/gcc/bin/gcc -O3 -std=c99 gen.c -o gen && ./gen

#define pHead(H) printf("Status=%d, contentLength=%d, connection=%s, chunked=%d, upgrade=%d\n",(H).status,(H).contentLength,(H).connection,(H).chunked,(H).upgrade)
#define pRes(RES) printf("Empty=%d, next=%d\n",(RES).empty,(RES).next)

const char* read_file(const char* path, long* size) {
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
  if (size!=NULL) *size=lSize;
  return buffer;
}

// /usr/local/gcc/bin/gcc -O3 gen.c -o gen -std=c99 && ./gen
int main() {
  #define NUM_MSG 100
  char* buf[NUM_MSG];
  for (int i=0;i<NUM_MSG;++i) {
    char path[512]; snprintf(path,512,"../../test/resources/tweet%d",i+1);
    buf[i]=read_file(path,NULL);
  }

/*
  char* buf[5] = {};
  buf[0]=read_file("../../test/resources/tweet1",NULL);
  buf[1]=read_file("../../test/resources/tweet2",NULL);
  buf[2]=read_file("../../test/resources/tweet3",NULL);
  buf[3]=read_file("../../test/resources/tweet4",NULL);
  buf[4]=read_file("../../test/resources/tweet6",NULL);
*/
  
  for(int iter = 1; iter < 100000; iter*=10){
    for (int k=0;k<25;++k) {
      struct timeval start, stop;
      gettimeofday(&start, NULL);
      for(int j = 0; j < iter; j++) {
        for(int i = 0; i<NUM_MSG; i++) {
          ParseResultTuple2Anon1323431030Anon1680061013 r = respAndMessageParse(buf[i]);
          //free2
        }
      }
      gettimeofday(&stop, NULL);
      printf("Parameters(size -> %d): %lu microsec\n", iter, (stop.tv_sec - start.tv_sec)*1000000UL + stop.tv_usec - start.tv_usec);
    }
  }

  for (int i=0;i<NUM_MSG;++i) free(buf[i]);
  return 0;
}
