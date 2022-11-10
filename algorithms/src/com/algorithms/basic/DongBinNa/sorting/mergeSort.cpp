#include <stdio.h>

int number = 8;
int sorted[8]; // 정렬한 값을 저장할 전역 변수 생성 

/*
array = 실제 배열 
startIdx = 비교할 첫번째 배열의 시작 index (시작점) 
middleIdx = 비교할 배열 사이 값(중간점) 
endIdx = 비교할 두번째 배열의 마지막 index (끝점) 
*/
void merge(int array[], int startIdx, int middleIdx, int endIdx) {
	int i = startIdx;
	int j = middleIdx + 1;
	int k = startIdx;
	
	while(i <= middleIdx && j <= endIdx){
		if(array[i] <= array[j]){
			sorted[k] = array[i];
			i++;
		}else{
			sorted[k] = array[j];
			j++;
		}
		k++;
	}
			
//	첫번째 배열의 값을 먼저 다 넣었을 때 
	if(i > middleIdx){	// i의 값을 먼저 다 넣음 
//		j에 있는 값 다 넣기
		for(int t=j; t<=endIdx; t++) {
			sorted[k] = array[t];
			k++;
		}
	}else{
//		i에 있는 값 다 넣기 
		for(int t=i; t<=middleIdx; t++){
			sorted[k] = array[t];
			k++;
		}
	}
//	정렬된 배열(sorted)를 실제 배열(array)에 옮기기 
	for(int t=startIdx; t<=endIdx; t++){
		array[t] = sorted[t];
	}
}

/* 
재귀함수는 먼저 반으로 나누고 나중에 합치는 것임 
반으로 나눠서 정렬 진행 = 재귀 
*/
void mergeSort(int array[], int startIdx, int endIdx){
//	크기가 1보다 큰 경우 
	if(startIdx < endIdx){
//		반갈 
		int middleIdx = (startIdx + endIdx) / 2;
//		나눈걸로 각각 실행(또 반으로 나눔) 
//		처음부터 ~ 중앙까지 
		mergeSort(array, startIdx, middleIdx);
//		중앙부터 ~ 끝까지 
		mergeSort(array, middleIdx+1, endIdx);		
		
//		나눈 배열을 합쳐줌
 		merge(array, startIdx, middleIdx, endIdx);
	}
}

int main(void){
	int array[number] = {7 ,6, 5, 8, 3, 5, 9, 1};
	
	mergeSort(array, 0, number-1);
	
	for(int i=0; i<number; i++){
		printf("%d ", array[i]);
	}
	
	return 0;
}
