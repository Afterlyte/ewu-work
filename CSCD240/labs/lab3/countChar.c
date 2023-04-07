#include <stdio.h>
#include <ctype.h>

int main() {
	char sentence[100];
	int count;
	char c;

	printf("Type a sentence:\n");
	fgets(sentence, 100, stdin);

	printf("Type a character that you'd like to find the number of occurrences in a sentence:\n");
	while((c = getchar()) == '\n');

	for(int i = 0; sentence[i] != '\n'; i++) {
		if(tolower(sentence[i]) == tolower(c)) {
			count++;
		}
	}

	printf("Alphabet %c has a frequency %d\n", c, count);
	return 0;
}
