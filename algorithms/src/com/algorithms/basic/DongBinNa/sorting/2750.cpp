#include <stdio.h>

int array[1001];

void print(int number){
	for(int i=0; i<number; i++){
		printf("%d ", array[i]);
	}
}

void selectionSort(int number){
	int i, j, temp, min, index;
	
	for(i=0; i<number; i++){
		int min = 1001;
		for(j=i; j<number; j++){
			if(array[j] < min){
				min = array[j];
				index = j;
			}
		}
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
	
}

int main(void){
	int number;
	
	scanf("%d", &number);
	
	for(int i=0; i<number; i++){
		scanf("%d", &array[i]);
	}
	
	selectionSort(number);
	
	print(number);
	return 0;
}
