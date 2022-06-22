#include <stdio.h>

int main(void){
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
