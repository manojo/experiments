#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "http_parser.h"

int header_field_cb (http_parser *p, const char *buf, size_t len){
  for(int i = 0; i < len; i++){
    printf("%c", buf[p->index + i]);
  }
  printf("\n");
  return 0;
}

int header_value_cb (http_parser *p, const char *buf, size_t len){
  for(int i = 0; i < len; i++){
    printf("%c", buf[p->index + i]);
  }
  printf("\n");
  return 0;
}

static http_parser_settings my_settings = {
  .on_message_begin = 0,
  .on_header_field = 0, //header_field_cb,
  .on_header_value = 0, //header_value_cb,
  .on_url = 0,
  .on_body = 0,
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

// icc http_parser.c http_test.c -O3 -std=c99 -o h && ./h
int main(int argc, char **argv){
  #define NUM_MSG 100
  void* data[NUM_MSG];
  long sizes[NUM_MSG];
  for (int i=0;i<NUM_MSG;++i) {
    char path[512]; snprintf(path,512,"../../test/resources/tweet%d",i+1);
    data[i]=read_file(path,&sizes[i]);
  }

  /* do your work here, buffer is a string contains the whole text */
  printf("Greetings Lion!\n");

  http_parser* my_parser = malloc(sizeof (http_parser));
  http_parser_init(my_parser, HTTP_RESPONSE);
  //1,10,100,1000,10000
  for (int k=0;k<25;++k) {
    for(int iter = 1; iter <= 1000; iter*=10){
      struct timeval start, stop;
  
      gettimeofday(&start, NULL);
  
      for(int i = 0; i < NUM_MSG; i++){
        my_parser->data = data[i];
  
        for(int j = 0; j < iter; j++){
          http_parser_execute(my_parser, &my_settings, (void*)data[i], sizes[i]);
        }
      }
      gettimeofday(&stop, NULL);
      printf("Parameters(size -> %d): %lu microsec\n", iter, (stop.tv_sec - start.tv_sec)*1000000UL + stop.tv_usec - start.tv_usec);
    }
  }
  for(int i=0; i < NUM_MSG; i++) free(data[i]);
  free(my_parser);

  //  http_parser_settings settings;
  //  settings.on_url = my_url_callback;
  //  settings.on_header_field = my_header_field_callback;

  return 1;
}
