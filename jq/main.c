#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>
#include "compile.h"
#include "jv.h"
#include "jv_parse.h"
#include "execute.h"
#include "config.h"  /* Autoconf generated header file */
#include "jv_alloc.h"

// -------------------------------------------------
#include <sys/time.h>
static int cmp(const void* a, const void* b) {
  long aa=*((long*)a);
  long bb=*((long*)b);
  if (aa>bb) return 1; else if (aa<bb) return -1; else return 0;
}
// -------------------------------------------------

int jq_testsuite(int argc, char* argv[]);

static const char* progname;

static void usage() {
  fprintf(stderr, "\njq - commandline JSON processor [version %s]\n", PACKAGE_VERSION);
  fprintf(stderr, "Usage: %s [options] <jq filter> [file...]\n\n", progname);
  fprintf(stderr, "For a description of the command line options and\n");
  fprintf(stderr, "how to write jq filters (and why you might want to)\n");
  fprintf(stderr, "see the jq manpage, or the online documentation at\n");
  fprintf(stderr, "http://stedolan.github.com/jq\n\n");
  exit(1);
}

static void die() {
  fprintf(stderr, "Use %s --help for help with command-line options,\n", progname);
  fprintf(stderr, "or see the jq documentation at http://stedolan.github.com/jq\n");
  exit(1);
}




static int isoptish(const char* text) {
  return text[0] == '-' && (text[1] == '-' || isalpha(text[1]));
}

static int isoption(const char* text, char shortopt, const char* longopt) {
  if (text[0] != '-') return 0;
  if (strlen(text) == 2 && text[1] == shortopt) return 1;
  if (text[1] == '-' && !strcmp(text+2, longopt)) return 1;
  return 0;
}

enum {
  SLURP = 1,
  RAW_INPUT = 2,
  PROVIDE_NULL = 4,

  RAW_OUTPUT = 8,
  COMPACT_OUTPUT = 16,
  ASCII_OUTPUT = 32,
  COLOUR_OUTPUT = 64,
  NO_COLOUR_OUTPUT = 128,

  FROM_FILE = 256,

  /* debugging only */
  DUMP_DISASM = 2048,
};
static int options = 0;
static struct bytecode* bc;

static void process(jv value, int flags) {
  jq_state *jq = NULL;
  jq_init(bc, value, &jq, flags);
  jv result;
  while (jv_is_valid(result = jq_next(jq))) {
    if ((options & RAW_OUTPUT) && jv_get_kind(result) == JV_KIND_STRING) {
      fwrite(jv_string_value(result), 1, jv_string_length_bytes(jv_copy(result)), stdout);
      jv_free(result);
    } else {
      int dumpopts;
      /* Disable colour by default on Windows builds as Windows
         terminals tend not to display it correctly */
#ifdef WIN32
      dumpopts = 0;
#else
      dumpopts = isatty(fileno(stdout)) ? JV_PRINT_COLOUR : 0;
#endif
      if (!(options & COMPACT_OUTPUT)) dumpopts |= JV_PRINT_PRETTY;
      if (options & ASCII_OUTPUT) dumpopts |= JV_PRINT_ASCII;
      if (options & COLOUR_OUTPUT) dumpopts |= JV_PRINT_COLOUR;
      if (options & NO_COLOUR_OUTPUT) dumpopts &= ~JV_PRINT_COLOUR;
      jv_dump(result, dumpopts);
    }
    printf("\n");
  }
  jv_free(result);
  jq_teardown(&jq);
}

static jv slurp_file(const char* filename) {
  FILE* file = fopen(filename, "r");
  if (!file) {
    return jv_invalid_with_msg(jv_string_fmt("Could not open %s: %s",
                                             filename,
                                             strerror(errno)));
  }
  jv data = jv_string("");
  while (!feof(file) && !ferror(file)) {
    char buf[4096];
    size_t n = fread(buf, 1, sizeof(buf), file);
    data = jv_string_concat(data, jv_string_sized(buf, (int)n));
  }
  int badread = ferror(file);
  fclose(file);
  if (badread) {
    jv_free(data);
    return jv_invalid_with_msg(jv_string_fmt("Error reading from %s",
                                             filename));
  }
  return data;
}

FILE* current_input;
const char** input_filenames;
int ninput_files;
int next_input_idx;
static int read_more(char* buf, size_t size) {
  while (!current_input || feof(current_input)) {
    if (current_input) {
      fclose(current_input);
      current_input = 0;
    }
    if (next_input_idx == ninput_files) {
      return 0;
    }
    if (!strcmp(input_filenames[next_input_idx], "-")) {
      current_input = stdin;
    } else {
      current_input = fopen(input_filenames[next_input_idx], "r");
    }
    if (!current_input) {
      fprintf(stderr, "%s: %s: %s\n", progname, input_filenames[next_input_idx], strerror(errno));
    }
    next_input_idx++;
  }

  if (!fgets(buf, size, current_input)) buf[0] = 0;
  return 1;
}

int main2(int argc, char* argv[]) {
  int ret = 0;
  if (argc) progname = argv[0];

  if (argc > 1 && !strcmp(argv[1], "--run-tests")) {
    return jq_testsuite(argc - 1, argv + 1);
  }

  const char* program = 0;
  input_filenames = jv_mem_alloc(sizeof(const char*) * argc);
  ninput_files = 0;
  int further_args_are_files = 0;
  int jq_flags = 0;
  jv program_arguments = jv_array();
  for (int i=1; i<argc; i++) {
    if (further_args_are_files) {
      input_filenames[ninput_files++] = argv[i];
    } else if (!strcmp(argv[i], "--")) {
      if (!program) usage();
      further_args_are_files = 1;
    } else if (!isoptish(argv[i])) {
      if (program) {
        input_filenames[ninput_files++] = argv[i];
      } else {
        program = argv[i];
      }
    } else if (isoption(argv[i], 's', "slurp")) {
      options |= SLURP;
    } else if (isoption(argv[i], 'r', "raw-output")) {
      options |= RAW_OUTPUT;
    } else if (isoption(argv[i], 'c', "compact-output")) {
      options |= COMPACT_OUTPUT;
    } else if (isoption(argv[i], 'C', "color-output")) {
      options |= COLOUR_OUTPUT;
    } else if (isoption(argv[i], 'M', "monochrome-output")) {
      options |= NO_COLOUR_OUTPUT;
    } else if (isoption(argv[i], 'a', "ascii-output")) {
      options |= ASCII_OUTPUT;
    } else if (isoption(argv[i], 'R', "raw-input")) {
      options |= RAW_INPUT;
    } else if (isoption(argv[i], 'n', "null-input")) {
      options |= PROVIDE_NULL;
    } else if (isoption(argv[i], 'f', "from-file")) {
      options |= FROM_FILE;
    } else if (isoption(argv[i], 0, "arg")) {
      if (i >= argc - 2) {
        fprintf(stderr, "%s: --arg takes two parameters (e.g. -a varname value)\n", progname);
        die();
      }
      jv arg = jv_object();
      arg = jv_object_set(arg, jv_string("name"), jv_string(argv[i+1]));
      arg = jv_object_set(arg, jv_string("value"), jv_string(argv[i+2]));
      program_arguments = jv_array_append(program_arguments, arg);
      i += 2; // skip the next two arguments
    } else if (isoption(argv[i],  0,  "debug-dump-disasm")) {
      options |= DUMP_DISASM;
    } else if (isoption(argv[i],  0,  "debug-trace")) {
      jq_flags |= JQ_DEBUG_TRACE;
    } else if (isoption(argv[i], 'h', "help")) {
      usage();
    } else if (isoption(argv[i], 'V', "version")) {
      fprintf(stderr, "jq version %s\n", PACKAGE_VERSION);
      return 0;
    } else {
      fprintf(stderr, "%s: Unknown option %s\n", progname, argv[i]);
      die();
    }
  }
  if (!program) usage();
  if (ninput_files == 0) current_input = stdin;

  if ((options & PROVIDE_NULL) && (options & (RAW_INPUT | SLURP))) {
    fprintf(stderr, "%s: --null-input cannot be used with --raw-input or --slurp\n", progname);
    die();
  }

  if (options & FROM_FILE) {
    jv data = slurp_file(program);
    if (!jv_is_valid(data)) {
      data = jv_invalid_get_msg(data);
      fprintf(stderr, "%s: %s\n", progname, jv_string_value(data));
      jv_free(data);
      return 1;
    }
    bc = jq_compile_args(jv_string_value(data), program_arguments);
    jv_free(data);
  } else {
    bc = jq_compile_args(program, program_arguments);
  }
  if (!bc) return 1;

  if (options & DUMP_DISASM) {
    dump_disassembly(0, bc);
    printf("\n");
  }

  if (options & PROVIDE_NULL) {
    process(jv_null(), jq_flags);
  } else {
    jv slurped;
    if (options & SLURP) {
      if (options & RAW_INPUT) {
        slurped = jv_string("");
      } else {
        slurped = jv_array();
      }
    }
    struct jv_parser parser;
// --------------------------------------------------------
// gcc *.c -O3 -o jq && ./jq . tweet1j tweet2j tweet3j tweet4j tweet6j
// --------------------------------------------------------
int i,j;
//#define N_LOOPS 1
#define N_SAMPLES 25

for (int N_LOOPS=10; N_LOOPS<=100; N_LOOPS*=10) {
printf("Time (%d loops):\n",N_LOOPS);

long sample[N_SAMPLES];
for (i=0;i<N_SAMPLES;++i) {
  struct timeval t0,t1;
  gettimeofday(&t0,NULL);



  for (j=0;j<N_LOOPS;++j) {
    next_input_idx=0;
// --------------------------------------------------------
    jv_parser_init(&parser);
    char buf[4096];
    while (read_more(buf, sizeof(buf))) {
        jv_parser_set_buf(&parser, buf, strlen(buf), !feof(stdin));
        jv value;
        while (jv_is_valid((value = jv_parser_next(&parser)))) { /*process(value, jq_flags);*/ }
        if (jv_invalid_has_msg(jv_copy(value))) {
          jv msg = jv_invalid_get_msg(value);
          fprintf(stderr, "parse error: %s\n", jv_string_value(msg));
          jv_free(msg);
          ret = 1;
          break;
        } else {
          jv_free(value);
        }
    }
// --------------------------------------------------------
  }
  gettimeofday(&t1,NULL);
  long us=((t1.tv_sec - t0.tv_sec)*1000000L+t1.tv_usec) - t0.tv_usec;
  long ms=us/1000;
  sample[i]=ms;
  printf("%ld.%03ld\n",us/1000,us%1000);
}

//if (N_SAMPLES>2) qsort(sample,N_SAMPLES,sizeof(long),cmp);
//long med = N_SAMPLES%2 ? sample[N_SAMPLES/2] : (sample[N_SAMPLES/2]+sample[N_SAMPLES/2-1])/2;
//printf("seconds [%d loops], median = %ld ms\n",N_LOOPS,med);

}
// --------------------------------------------------------
    jv_parser_free(&parser);
    if (ret != 0) goto out;
  }
out:
  jv_mem_free(input_filenames);
  bytecode_free(bc);
  return ret;
}



// -----------------------------------------------------------------------------
// LOAD IN MEMORY

const char* read_file(const char* path, long* size) {
  FILE *fp;
  long lSize;
  char *buffer;
  fp = fopen(path,"rb");
  if(!fp) perror(path),exit(1);
  fseek(fp, 0L, SEEK_END);
  lSize = ftell(fp);
  rewind(fp);
  buffer = calloc( 1, lSize+1 );
  if( !buffer ) fclose(fp),fputs("memory alloc fails",stderr),exit(1);
  if( 1!=fread( buffer , lSize, 1 , fp) )
    fclose(fp),free(buffer),fputs("entire read fails",stderr),exit(1);
  fclose(fp);
  printf("Input size is %lu\n",lSize);
  if (size!=NULL) *size=lSize;
  return buffer;
}

int main(int argc, char* argv[]) {
  #define NUM_MSG 100
  const char* buf[NUM_MSG];
  long size[NUM_MSG];
  for (int i=0;i<NUM_MSG;++i) {
    char path[512]; snprintf(path,512,"../src/test/resources/just_tweet%d",i+1);
    buf[i]=read_file(path,&size[i]);
  }
  
  // In-memory parsing
  for(int iter = 1; iter <= 1000; iter*=10){
    for (int k=0;k<25;++k) {
      struct jv_parser parser;
      struct timeval start, stop;
      jv_parser_init(&parser);
      gettimeofday(&start, NULL);
      for(int j = 0; j < iter; j++) {
        for(int i = 0; i < NUM_MSG; i++) {
          jv_parser_set_buf(&parser, buf[i], size[i], 1);
          jv value;
          while (jv_is_valid((value = jv_parser_next(&parser)))) { jv_free(value); }
          jv_free(value);
          //assert(parser.curr_buf_pos==size[i]);
          //printf("%d %d\n",parser.curr_buf_pos,size[i]);
        }
      }
      gettimeofday(&stop, NULL);
      jv_parser_free(&parser);
      printf("%d: %lu\n", iter, (stop.tv_sec - start.tv_sec)*1000000UL + stop.tv_usec - start.tv_usec);
    }
  }

  for (int i=0;i<NUM_MSG;++i) free((char*)buf[i]);

}
