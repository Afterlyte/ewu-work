#include <stdio.h>

int(*pFcn)(int, int);
int Add(int x, int y);
int Subtract(int x, int y);
int Multiply(int x, int y);
int Divide(int x, int y);

int main() {
	int x, y, op;
	printf("Enter a number: ");
	scanf(" %d", &x);
	printf("Enter another number: ");
	scanf(" %d", &y);
	printf("Enter an operation (0=add, 1=subtract, 2=multiply, 3=divide): ");
	scanf(" %d", &op);
	switch(op) {
		case 0: pFcn = Add;
		break;
		case 1: pFcn = Subtract;
		break;
		case 2: pFcn = Multiply;
		break;
		case 3: pFcn = Divide;
		break;
	}
	printf("The answer is %d\n", pFcn(x, y));
	return 0;
}

int Add(int x, int y) {
	return x + y;
}

int Subtract(int x, int y) {
	return x - y;
}

int Multiply(int x, int y) {
	return x * y;
}

int Divide(int x, int y) {
	return x / y;
}