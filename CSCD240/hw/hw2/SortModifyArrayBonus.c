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

	int n, *x, i = 0;
    double mean = 0.0, median = 0.0, stdDev = 0.0;

	printf("Bonus version of the program. This program can read as many integers as the user types and keeps on displaying the cumulative mean, median and average of the numbers typed so far. Lastly, the allocated memory needs to be freed.\n");
	/*****************************************************************/

	//x is not automatically assigned a memory block when it is defined as a pointer variable, you need to allocate a block
	//of memory large enough to hold 'n' integers
        // Write the function that allocates memory to hold 'n' integers
	x = malloc(sizeof(int));
	/***********************************************************************/
	//Read in the list of numbers 'n' into the allocated block using scanf
	printf("Typing the number:\n");
	scanf("%d", &n);
	while(!feof(stdin)) {
		i++;
		x = realloc(x, sizeof(int)*i);
		x[i-1] = n;
        	printf("Displaying the numbers:\n");

       // Call printArray to display the integers      
		printArray(x, i);
        // Find the mean of integers using findMean function
		mean = findMean(x, i);
       		printf("Mean of the numbers is: %f\n", mean);
        // Fidn the median of integers using findMedian function
		int xCopy[i];
		for(int j = 0; j < i; j++) {
			xCopy[j] = *(x+j);
		}
		sortArray(xCopy, i);
		median = findMedian(xCopy, i);
        	printf("Median of the numbers is: %f\n", median);
        // Find the standard deviation of integers using findStandardDeviation function
		stdDev = findStandardDeviation(x, i, mean);
		if(stdDev == -1) {
			printf("Number list too small to calculate standard deviation.\n");
		}
		else {
         		printf("Standard deviation of the numbers is: %f\n", stdDev);
		}

		printf("Typing the number:\n");
		scanf("%d", &n);
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
