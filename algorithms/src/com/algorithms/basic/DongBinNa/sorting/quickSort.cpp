#include <stdio.h>

int number = 10;
int data[10] = {1, 4, 5, 10, 2, 6, 8, 9, 3, 7};
//					  p	 i				 j  e
//1. pivot에서 -> 방향으로 pivot보다 큰 값을 찾음
//2. 끝에서 pivot으로 오게끔 pivot <- 끝 이런 방향으로 오게끔 진행하여 pivot보다 작은 값을 찾음
//4. 그런데, pivot보다 작은 값이 2의 범위를 지나치면 1.과 기존 pivot값을 바꿔야한다.
//5. 정렬한 값을 기준으로 기존의 start에서 2. 보다 1칸 작게
//	 기존의 2. 보다 오른쪽에서 마지막까지 또 퀵정렬 반복 >> 재귀
//6. 만약 pivot값이 end보다 크거나 같으면 그만~~
void mySelf(int *data, int start, int end){
	if(start >= end){	// 원소가 1개인 경우
		return; 
	}
	
	int pivot = start;
	int i = start + 1;	// move -> && find a value that is bigger than pivot
	int j = end;	//move <-	&& find a value that is smaller than pivot
	int temp;
	
	while(i <= j){
		while(i <= end && data[i] <= data[pivot]){
			i++;
		}
		while(j > start && data[j] >= data[pivot]){
			j--;
		}
	
		if(i > j){
			temp = data[j];
			data[j] = data[pivot];
			data[pivot] = temp;
		}else{
			temp = data[j];
			data[j] = data[i];
			data[i] = temp;
		}
	}
	mySelf(data, start, j-1);
	mySelf(data, j+1, end);
}

void quickSort(int *data, int start, int end){
	if(start >= end){	// 원소가 1개인 경우
		return; 
	}
	int key = start;	//key는 첫번째 요소
	int i = start+1;	//왼쪽부터 출발해 key값보다 큰 값을 찾기 위해
	int j = end;	// 오른쪽부터 출발해 key보다 작은 값을 찾기 위해
	int temp;
	
	while(i <= j){	//엇갈릴 때까지 반복 
		while(i <= end && data[i] <= data[key]){	//키 값보다 큰 값을 만날 때까지 오른쪽으로 이동 
			i++;
		}
		while(j > start && data[j] >= data[key]){	//키 값보다 작은 값을 만날 때까지 왼쪽으로 이동 && start보다 클 때까지만 진행(이 조건을 달지 않으면 범위를 벗어나기 때문에) 
			j--;
		}
		
		if(i > j){	//엇갈린 상태면 키 값과 교체 
			temp = data[j];
			data[j] = data[key];
			data[key] = temp;
		}else{
			temp = data[j];
			data[j] = data[i];
			data[i] = temp;
		}
	}
	
	quickSort(data, start, j-1);
	quickSort(data, j+1, end);
}

int main(void){
	mySelf(data, 0, number-1);
//	quickSort(data, 0, number-1);
	
	for(int i=0; i<number; i++){
		printf("%d ", data[i]);
	}
	return 0;
}
