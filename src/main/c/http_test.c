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

int main(int argc, char **argv){

  const char* files[5] = {"tweet1","tweet2","tweet3","tweet4","tweet6"};
  long sizes[5];
  char * data[5];

  //Reading the file
  FILE *fp;
  long lSize;

  for(int i = 0; i < 5; i++){
    char *buffer;

    fp = fopen ( files[i] , "rb" );
    if( !fp ) perror(files[i]),exit(1);

    fseek( fp , 0L , SEEK_END);
    lSize = ftell( fp );
    rewind( fp );

    /* allocate memory for entire content */
    buffer = calloc( 1, lSize+1 );
    if( !buffer ) fclose(fp),fputs("memory alloc fails",stderr),exit(1);

    /* copy the file into the buffer */
    if( 1!=fread( buffer , lSize, 1 , fp) )
      fclose(fp),free(buffer),fputs("entire read fails",stderr),exit(1);

    fclose(fp);

    sizes[i] = lSize;
    data[i] = buffer;

    printf("The length is %lu\n",lSize);
  }

  /* do your work here, buffer is a string contains the whole text */
  printf("Greetings Lion!\n");

  http_parser* my_parser = malloc(sizeof (http_parser));
  http_parser_init(my_parser, HTTP_RESPONSE);
  //1,10,100,1000,10000
  for(int iter = 1; iter < 100000; iter*=10){
    struct timeval start, stop;

    gettimeofday(&start, NULL);

    for(int i = 0; i < 5; i++){
      my_parser->data = data[i];

      for(int j = 0; j < iter; j++){
        http_parser_execute(my_parser, &my_settings, data[i], sizes[i]);
      }
    }
    gettimeofday(&stop, NULL);
    printf("Parameters(size -> %d): %u microsec\n", iter, stop.tv_usec - start.tv_usec);
  }

  for(int i = 0; i < 5; i++){
    free(data[i]);
  }
  free(my_parser);

  //  http_parser_settings settings;
  //  settings.on_url = my_url_callback;
  //  settings.on_header_field = my_header_field_callback;

  return 1;
}
