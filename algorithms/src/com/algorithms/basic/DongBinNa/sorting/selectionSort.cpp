#include <stdio.h>

/* 
selection sort
1 10 5 8 7 6 4 3 2 9
1 2 5 8 7 6 4 3 10 9
1 2 3 8 7 6 4 5 10 9
1 2 3 4 7 6 8 5 10 9
... 
제일 작은 것을 선택해 앞으로 보내는 것이 핵심 
*/
int main(void){
	int i, j, min, index, temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	 
	 printf("before \n");
	 for(i=0; i<10; i++){
		printf("%d ", array[i]);
	}
	 
	for(i=0; i<10; i++){
		min = 9999;
		for(j=i; j<10; j++) {
			if(array[j] < min){
				min = array[j];
				index = j;
			}
		}
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
	
	printf("\nafter\n");
	for(i=0; i<10; i++){
		printf("%d ", array[i]);
	}
	return 0;
}
/* 시간 복잡도

반복문을 진행할 때 마다
0~9까지 > 1~9까지 >  2~9까지
(for 실행 횟수) 10 + 9 + 8... + 1 번
등차수열에서는 => 10 * (10 + 1) /2 로 경우의 수를 구할 수 있다. >> 55번
수열 개수 * (맨 앞 + 맨 뒤) / 2 -> 총 개수를 2개로 묶어서 계산하니까 2로 나눠줌 
=> N * (N+1)/2 
=> N이 굉장히 크다는 가정 하에 시간복잡도를 계산함.
+1이나 /2와 같은 연산들은 제외한 다음 복잡도를 측정하게 됨
=> N * N = N^2 = 시간 복잡도는 O(N^2)

ex) N이 10,000개라면 억번 가량 계산하게 되므로 비효율 적인 알고리즘이다. 
*/
