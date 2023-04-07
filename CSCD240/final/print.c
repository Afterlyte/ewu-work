#include <stdio.h>
void function(int array[]);
int main(){
 int x[] = {1,2,3,4,5,6,7,8,9};
 printf("size=%d\n", sizeof(x));
 printf("x[5]=%d\n", x[5]);
 function(x);
 return 0;
}
void function(int array[]){
   printf("size=%d\n", sizeof(array));
   printf("x[5] = %d\n", array[5]);
   array = array + 1;
   printf("x[5] = %d\n", array[5]);
}
