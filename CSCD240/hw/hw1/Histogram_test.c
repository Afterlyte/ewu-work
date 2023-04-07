#include <stdio.h>

#define MAXROWS 100
#define NUM_ALPHABETS 26

int main(){

	int count, i, j, k;

	char sentence[MAXROWS];
	char alphabets[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	int frequency[NUM_ALPHABETS] = {0};

	
// step 1:Write a function that reads a sentence from the keyboard (2 pts)
	printf("Please type a sentence with max length 99 characters: ");
	fgets(sentence, 100, stdin);
        
// step 2:Find out the frequency of the alphabets  in the sentence, ignore uppercase or lowercase in the sentence(4 pts)
	for(int i = 0; sentence[i] != '\0'; i++) {
		for(int j = 0; j < 26; j++) {
			if(tolower(sentence[i]) == tolower(alphabets[j])) {
				frequency[j]++;
			}
		}
	}

// step 3: Print the histogram as shown in the screenshot(4 pts)
	printf("Alphabets\tFrequency\tHistogram\n");
	for(int i = 0; i < 26; i++) {
		printf("%c\t\t%d\t\t", alphabets[i], frequency[i]);
		for(int j = 0; j < frequency[i]; j++) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
