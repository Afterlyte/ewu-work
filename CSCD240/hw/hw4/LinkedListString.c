#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "LinkedListString.h"

/* Function to push a node */
void push(struct node** head_ref, char* new_data)
{
        /* allocate node */
        struct node* new_node = malloc(sizeof(struct node));

        /* put in the data  */

        strcpy(new_node->data, new_data);


        /* link the old list off the new node */
        new_node->next = (*head_ref);

        /* move the head to point to the new node */
        (*head_ref) = new_node;
}

/* Function to print linked list */
void printList(struct node *head)
{
        struct node *temp = head;
        while (temp != NULL)
        {
                printf("%s  ", temp->data);
                temp = temp->next;
        }
}

/* Function to count the number of elements in the linked list */
int listCount(struct node *head) {
	int count = 0;
	while(head != NULL) {
		count++;
		head = head -> next;
	}
	return count;
}


/* Function to reverse the linked list */

/**/

void reverseList(struct node** head_ref){
	struct node *curr = *head_ref, *next = NULL, *prev = NULL;
	while(curr != NULL) {
		next = curr -> next;
		curr -> next = prev;
		prev = curr;
		curr = next;
	}
	*head_ref = prev;
}
/*Function to delete all elements in a Linked List */
/**/

void listAllDelete(struct node **currP){
	while (*currP != NULL) {
		struct node *temp = *currP;
		*currP = (*currP) -> next;
		free(temp);
	}
}

/***Function to delete a particular element in a linked list**/
void deleteElement(struct node **currP, char *value){
	struct node *temp = *currP;
	while(temp != NULL && strcmp(temp -> data, value) == 0) {
		*currP = (*currP) -> next;
		free(temp);
		temp = *currP;
	}
	struct node *prev = *currP;
	while (temp != NULL) {
		while(temp != NULL && strcmp(temp -> data, value) != 0) {
			prev = temp;
			temp = temp -> next;
		}
		if(temp == NULL) {
			return;
		}
		prev -> next = temp -> next;
		free(temp);
		temp = prev -> next;
	}
}
