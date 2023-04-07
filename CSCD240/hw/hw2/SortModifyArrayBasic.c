#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void swapElements(int *a, int *b);
void sortArray(int *array, const int size);
void printArray(int *array, const int size);
double findMean(int *array, const int size);
double findMedian(int *array, const int size);
double findStandardDeviation( int *array, const int size, double average);

int main(){

	int n, *x;
    double mean = 0.0, median = 0.0, stdDev = 0.0;

	printf("This is the basic part of the program that asks the user to type the number of integers, i.e., 'n'. Next, allocate memory for 'n' integers, read the values of 'n' integers into the allocated memory using scanf, next, find the mean, median and average of 'n' integers. Lastly, the allocated memory needs to be freed.\n");
	/*****************************************************************/

	//x is not automatically assigned a memory block when it is defined as a pointer variable, you need to allocate a block
	//of memory large enough to hold 'n' integers
        // Write the function that allocates memory to hold 'n' integers
	printf("Read using scanf how many integers you would like to type:\n");
	scanf("%d", &n);
	x = malloc(sizeof(int)*n);
	/***********************************************************************/
	//Read in the list of numbers 'n' into the allocated block using scanf
	printf("Please type 'n' integers:\n");
	for(int i = 0; i < n; i++) {
		scanf("%d", &x[i]);
	}
    printf("Displaying the numbers:\n");

    // Call printArray to display the integers      
	printArray(x, n);
	
    // Find the mean of integers using findMean function
	mean = findMean(x, n);
    printf("Mean of the numbers is: %f\n", mean);
	
    // Find the median of integers using findMedian function
	int xCopy[n];
	for(int j = 0; j < n; j++) {
		xCopy[j] = x[j];
	}
	sortArray(xCopy, n);
	median = findMedian(xCopy, n);
    printf("Median of the numbers is: %f\n", median);
	
    // Find the standard deviation of integers using findStandardDeviation function
	stdDev = findStandardDeviation(x, n, mean);
	if(stdDev == -1) {
		printf("Number list too small to calculate standard deviation.\n");
	}
	else {
		printf("Standard deviation of the numbers is: %f\n", stdDev);
	}
    //Deallocate the memory ;
	
	free(x);
    
    return 0;
}





void printArray( int *array, const int size){

     // Complete this function
	for(int i = 0; i < size; i++) {
		printf("%d ", *(array+i));
	}
	printf("\n");
}

void sortArray(int *array, const int size){

     //Complete this function
	for(int i = 0; i < size; i++) {
		for(int j = i; j < size; j++) {
			if(array[j] < array[i]) {
				swapElements(&array[i], &array[j]);
			}
		}
	}
}

void swapElements( int *x, int *y){

     // Complete this function
	int temp = *x;
	*x = *y;
	*y = temp;
}



double findMean(int *array, const int size){

    // COmplete this function
	double sum = 0;
	for(int i = 0; i < size; i++) {
		sum += array[i];
	}
	return (sum / size);
}

double findMedian(int *array, const int size){

   //Complete this function;
	double median = 0.0;
	if(size % 2 == 0) {
		median = (array[size/2 - 1] + array[size/2]) / 2.0;
	}
	else {
		median = array[(int)(floor(size / 2.0))];
	}
	return median;
}


double findStandardDeviation( int *array, const int size, double average){

       // Complete this function
	if(size < 2) {
		return -1;
	}
	else {
		double devs[size];
		double sum = 0;
		for(int i = 0; i < size; i++) {
			sum += (array[i] - average)*(array[i] - average);
		}
		double stDev = sqrt(sum/(size-1));
		return stDev;
	}
}
