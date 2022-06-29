#include <stdio.h>

int data[1000001];

void quickSort(int *data, int start, int end){
	if(start >= end){
		return;
	}
	int key, i, j, temp;
	
	key = start;
	i = start + 1;
	j = end;
	while(i <= j){
		while(i <= end && data[key] >= data[i]){
			i++;
		}
		while(start < j && data[key] <= data[j]){
			j--;
		}

		if(i > j){
			temp = data[key];
			data[key] = data[j];
			data[j] = temp;
		}else{
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}
	
	quickSort(data, start, j-1);
	quickSort(data, j+1, end);
}

int main(void){
	int number, i;
	scanf("%d", &number);
	
	for(i=0; i<number; i++){
		scanf("%d", &data[i]);
	}

	quickSort(data, 0, number-1);
	
	for(int i=0; i<number; i++){
		printf("%d ", data[i]);
	}
	
	return 0;
}
