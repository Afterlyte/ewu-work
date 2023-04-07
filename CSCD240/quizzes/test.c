#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node {
	int data;
	struct node *next;
};

void push(struct node** head, int data){
		struct node x;
         struct node* newnode = malloc(sizeof(struct node));
         newnode->data=data;
		 (&x)->next = *head;
         newnode->next= *head;
         (*head) = newnode; 
}
 int main(){
       struct node* A = NULL;
       push(&A, 5);
       push(&A, 6);
	   struct node *temp = A;
   while (temp != NULL){
          printf("%d\n", temp->data);
          temp = temp->next;
  }

       return 0;
}
