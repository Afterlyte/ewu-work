#include <stdio.h>
void main() {
	printf("The size of short is %zu\n", sizeof(short));
	printf("The size of int is %zu\n", sizeof(int));
	printf("The size of char is %zu\n", sizeof(char));
	printf("The size of double is %zu\n", sizeof(double));
	printf("The size of long is %zu\n", sizeof(long));
	printf("The size of long double is %zu\n", sizeof(long double));
	printf("%d\n", sizeof(short) < sizeof(int));
	printf("%d\n", sizeof(char) < sizeof(short));
	printf("%d\n", sizeof(long) > sizeof(int));
	printf("%d\n", sizeof(long double) > sizeof(double));
}
