#include <stdio.h>
#include <stdlib.h>

struct LinkedList{
        int data;
        struct LinkedList *next;
};
void insert(struct LinkedList *root, int item){
struct LinkedList *temp = malloc(sizeof(struct LinkedList));
        temp->data=item;
        temp->next=NULL;
        struct LinkedList *p = root;
        while(p->next!=NULL){
              p=p->next;
         }
        p->next=temp;
}
/* Function to print linked list */
void printList(struct LinkedList *head){
        struct LinkedList *temp = head;
        while (temp != NULL){
                printf("%d  ", temp->data);
                temp = temp->next;
        }
}
int main(){
        struct LinkedList *A = malloc(sizeof(struct LinkedList));
        A->data = 5;
        A->next = NULL;
        insert(A, 6);
        insert(A, 8);
        printList(A);
        return 0;
}

