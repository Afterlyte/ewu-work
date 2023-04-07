#include <stdio.h>
#include <string.h>

int main() {
	struct Person {
		char name[BUFSIZ];
		char ssn[BUFSIZ];
		int age;
		float height;
		float weight;
	};
	struct Person p1;
	
	strcpy(p1.name, "Alfred Morino");
	strcpy(p1.ssn, "496-50-2260");
	p1.age = 50;
	p1.height = 170.5;
	p1.weight = 70.5;
	
	struct Person *ptr = &p1;
	
	printf("Name = %s\nSSN = %s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", p1.name , p1.ssn , p1.age , p1.height , p1.weight);
	printf("Name = %s\nSSN = %s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", ptr->name, ptr->ssn, ptr->age, ptr->height, ptr->weight);
	printf("Name = %s\nSSN = %s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", (*ptr).name, (*ptr).ssn, (*ptr).age, (*ptr).height, (*ptr).weight);
	printf("Name = %s\nSSN = %s\nAge = %d\nHeight(cm) = %g\nWeight(kg) = %g\n", (&p1)->name , (&p1)->ssn , (&p1)->age , (&p1)->height , (&p1)->weight);
}