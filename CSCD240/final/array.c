#include <stdio.h>
#define SIZE 10
int main(){
        int i;
        int array[SIZE];
        for (i = 0; i < SIZE; i++)
             array[i] = i;

        int *ptr;
        ptr = &array[5];
        ptr++;
        printf("%d ", ptr[0]);
        putchar('\n');

        return 0;
}
