#include <stdio.h>
int main(){
int a = 2, b=3, c =4, d = 5;

int (*p)[5];
int *pOne[5];
int arr[5] = {1,2,3,4,5};

p = &arr;
pOne[0] = arr;
pOne[1] = &a;
pOne[2] = &b;
pOne[3] = &c;
pOne[4] = &d;

             printf("**p is %d\n", **p);
             printf("(*p)[4] is %d\n", (*p)[4]);
             printf("**pOne is %d\n", **pOne);
             printf("*pOne[4] is %d\n", *pOne[4]);
return 0;
}
