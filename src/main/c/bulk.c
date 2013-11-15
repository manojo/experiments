#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "http_parser.h"

int header_field_cb (http_parser *p, const char *buf, size_t len) {
  for(int i = 0; i < len; i++){
    printf("%c", buf[p->index + i]);
  }
  printf("\n");
  return 0;
}

int header_value_cb(http_parser *p, const char *buf, size_t len) {
  for(int i = 0; i < len; i++){
    printf("%c", buf[p->index + i]);
  }
  printf("\n");
  return 0;
}

int body_chunk(http_parser *p, const char *buf, size_t len);

int ev_hdr(http_parser *p) { printf("Headers completed\n"); return 0; }
int ev_msg(http_parser *p) { printf("Message started\n"); return 0; }
int ev_end(http_parser *p) { printf("Message completed\n"); return 0; }


static http_parser_settings my_settings = {
  .on_message_begin = 0,
  .on_header_field = 0, //header_field_cb,
  .on_header_value = 0, //header_value_cb,
  .on_url = 0,
  .on_body = body_chunk,
  .on_headers_complete = 0,
  .on_message_complete = 0
};

char* read_file(const char* path, long* size) {
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


#include "compile.h"
#include "jv.h"
#include "jv_parse.h"
#include "execute.h"
#include "config.h"  /* Autoconf generated header file */
#include "jv_alloc.h"

struct jv_parser parser;

int body_chunk(http_parser *p, const char *buf, size_t len) {
  jv_parser_set_buf(&parser, buf, len, 1);
  jv value;
  while (jv_is_valid((value = jv_parser_next(&parser)))) { jv_free(value); }
  jv_free(value);
}

// /usr/local/gcc/bin/gcc bulk.c http_parser.c -I../../../jq/ ../../../jq/[^m]*.c -O3 -std=c99 -o bulk && ./bulk

// number of messages, if not defined, then use the bulk (JSON array of all messages)
//#define COUNT 100

int main(int argc, char **argv){
#ifdef COUNT
  long size[COUNT];
  char* data[COUNT];
  for (int i=0;i<COUNT;++i) {
    char path[64]; snprintf(path,64,"../../test/resources/chunked/msg%d",i+1);
    data[i]=read_file(path,&size[i]);
  }
#else
  long size;
  char* data=read_file("../../test/resources/chunked/bulk",&size);
#endif
  http_parser* my_parser = malloc(sizeof (http_parser));

  struct timeval start, stop;

  for (int num=1;num<=100;num*=10) { // loops
    for (int i=0;i<25;++i) { // samples
      gettimeofday(&start, NULL);
      for (int j=0;j<num;++j) {
#ifdef COUNT
        for (int k=0;k<COUNT;++k) {
          http_parser_init(my_parser, HTTP_RESPONSE);
          my_parser->data = data[i];
          jv_parser_init(&parser);
          http_parser_execute(my_parser, &my_settings, (void*)data[k], size[k]);
          jv_parser_free(&parser);
        }
#else
        http_parser_init(my_parser, HTTP_RESPONSE);
        my_parser->data = data;
        jv_parser_init(&parser);
        http_parser_execute(my_parser, &my_settings, (void*)data, size);
        jv_parser_free(&parser);
#endif
      }
      gettimeofday(&stop, NULL);
      printf("- %d: %lu\n",num,(stop.tv_sec - start.tv_sec)*1000000UL + stop.tv_usec - start.tv_usec);
    }
  }
  free(my_parser);
#ifdef COUNT
  for (int i=0;i<COUNT;++i) free(data[i]);
#else
  free(data);
#endif
  return 0;
}
