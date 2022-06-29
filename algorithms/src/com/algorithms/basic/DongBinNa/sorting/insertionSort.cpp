#include <stdio.h>

int main(void){	
	int i, j, temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	
	for(i=0; i<9; i++){
		j=i;
		while(array[j] > array[j+1]){
			temp = array[j];
			array[j] = array[j+1];
			array[j+1] = temp;
			j--;
		}
	}

	for(i=0; i<10; i++){
		printf("%d ", array[i]);
	}
	
	return 0;
}

/*
데이터가 어느정도 정렬된 상태라면
N^2 복잡도를 가진 정렬 중에서 빠른 경우가 많다.
그나마 제일 효율적이라고 함 
*/
