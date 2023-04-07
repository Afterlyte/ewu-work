#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "fileTest.h"

void convertLower(char *str) {
	int len = strlen(str);
	for(int i = 0; i < len; i++) {
		str[i] = tolower(str[i]);
	}
}
	

int countString(const char* fileName, char *str){
    
    int word_count = 0;

    // insert your code here!
	char buffer[100];
	FILE *f = fopen(fileName, "r");
	if(f == NULL) {
		perror("Errors occurred: ");
		exit(EXIT_FAILURE);
	}
	convertLower(str);
	while(fscanf(f, "%s", buffer) != -1) {
		convertLower(buffer);
		if(strstr(buffer, str) != NULL) {
			word_count++;
		}
	}
    return word_count;
}

int countEmptyLines(const char *fileName){
    
    int emptyLine = 0;
    
    // Insert your code here!
	char buffer[100];
	FILE *f = fopen(fileName, "r");
	if(f == NULL) {
		perror("Errors occurred: ");
		exit(EXIT_FAILURE);
	}
	while(fgets(buffer, sizeof(buffer), f)) {
		if(strcmp(buffer, "\n") == 0) {
			emptyLine++;
		}
	}
    return emptyLine;
}