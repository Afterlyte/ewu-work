#include <stdio.h>

void main() {
int a = 3;
printf("%d\n", a); // final value 3
int b = 4;
printf("%d\n", b); // final value 4
double c = ++a + b++;
printf("%f\n", c); // final value 8.0
size_t size = sizeof(c/a);
printf("%ld\n", size); // final value 8
}
