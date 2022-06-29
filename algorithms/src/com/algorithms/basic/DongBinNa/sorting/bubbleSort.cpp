#include <stdio.h>

int main(void){
	int i, j, temp;
  	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
  	
  	for(i=0; i<10; i++){
  		for(j=0; j<9-i; j++){
  			if(array[j] > array[j+1]){
  				temp = array[j];
  				array[j] = array[j+1];
  				array[j+1] = temp;
			  }
		}
	}

	for(i=0; i<10; i++){
		printf("%d ", array[i]);
	}
	return 0;
}
/* Big O ?
반복문이 10번 반복 + 9 번 반복 ...
	10 + 9 + 8 + 7 + ... + 2 + 1 의 반복 = 등차수열을 이룸 
	N * (N+1) / 2
	N * N
	O(N^2)
	
	selection sort 보다 bubble sort 가 더 느림
	why? 선택 정렬은 특정 조건이 만족 될 때 
	변수 1개에 값을  가지고 있다가 마지막 값을 변경해주지만
	버블정렬은 매번 값을 바꿔주기 때문에
	시간복잡도는 동일해도 버블 정렬이 더 비효율적이다. 
*/ 

int myself(void){
  int i, j, temp;
  int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
  
  printf("%d\n", array[10]);

  for(i=0; i<10; i++){
  	printf("%d ", array[i]);
  }
  printf("\n");
  
  for(i=1; i<=10; i++){
  	printf("\n%d\n", i);
  	for(j=0; j<10-i; j++){
  		printf(" j>%d = %d\n", j, array[j]);
  		if(array[j]>array[j+1]){
  			printf("%d보다 %d가 더 크다.--- \n\n", array[j+1], array[j]);
  			temp = array[j];
  			array[j] = array[j+1];
  			array[j+1] = temp;
		  }
	  }
  }
  
  printf("\n");
  for(i=0; i<10; i++){
  	printf("%d ", array[i]);
  }
  
  return 0;
}
