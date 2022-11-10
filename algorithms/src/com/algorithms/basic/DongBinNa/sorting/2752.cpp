#include <stdio.h>

int array[3];

int main(void){
	int i, j, min, temp, index;
	
	for(i=0; i<3; i++){
		scanf("%d", &array[i]);
	}
	
	for(i=0; i<3; i++){
		int min = 1000001;
		for(j=i; j<3; j++){
			if(array[j] < min){
				min = array[j];
				index = j;
			}
		}
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
	
	for(i=0; i<3; i++){
		printf("%d ", array[i]);
	}
	
	return 0;	
}
