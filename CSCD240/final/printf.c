#include <stdio.h>
int main(){
  int *ptr[10];
  int a[10] = {0,1,2,3,4,5,6,7,8,9};
  ptr[0] = a;
  printf("%d\n", *ptr[2]);
  return 0;
}
