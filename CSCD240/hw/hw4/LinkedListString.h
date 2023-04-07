/* Link list node */
struct node
{
        char data[40];
        struct node* next;
};

// Function Declarations
void push(struct node** head_ref, char* new_data);
void printList(struct node *head);
int listCount(struct node *head);
void reverseList(struct node** head_ref);
void listAllDelete(struct node **currP);
void deleteElement(struct node **currP, char *value);