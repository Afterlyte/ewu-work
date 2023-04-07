#include <stdio.h>

int main() {
	int i = 0;
	int grade;
	double sum = 0.0;
	double avg;
	printf("Please input a number of grades:\n");
	scanf("%d", &grade);
	while(grade != -1000) {
		i++;
		sum += grade;
		avg = sum/i;
		printf("Sum is %f\n", sum);
		printf("Average is %f\n", avg);
		scanf("%d", &grade);
	}
	return 0;
}
