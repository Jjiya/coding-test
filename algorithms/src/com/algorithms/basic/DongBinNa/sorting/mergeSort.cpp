#include <stdio.h>

int number = 8;
int sorted[8]; // ������ ���� ������ ���� ���� ���� 

/*
array = ���� �迭 
startIdx = ���� ù��° �迭�� ���� index (������) 
middleIdx = ���� �迭 ���� ��(�߰���) 
endIdx = ���� �ι�° �迭�� ������ index (����) 
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
			
//	ù��° �迭�� ���� ���� �� �־��� �� 
	if(i > middleIdx){	// i�� ���� ���� �� ���� 
//		j�� �ִ� �� �� �ֱ�
		for(int t=j; t<=endIdx; t++) {
			sorted[k] = array[t];
			k++;
		}
	}else{
//		i�� �ִ� �� �� �ֱ� 
		for(int t=i; t<=middleIdx; t++){
			sorted[k] = array[t];
			k++;
		}
	}
//	���ĵ� �迭(sorted)�� ���� �迭(array)�� �ű�� 
	for(int t=startIdx; t<=endIdx; t++){
		array[t] = sorted[t];
	}
}

/* 
����Լ��� ���� ������ ������ ���߿� ��ġ�� ���� 
������ ������ ���� ���� = ��� 
*/
void mergeSort(int array[], int startIdx, int endIdx){
//	ũ�Ⱑ 1���� ū ��� 
	if(startIdx < endIdx){
//		�ݰ� 
		int middleIdx = (startIdx + endIdx) / 2;
//		�����ɷ� ���� ����(�� ������ ����) 
//		ó������ ~ �߾ӱ��� 
		mergeSort(array, startIdx, middleIdx);
//		�߾Ӻ��� ~ ������ 
		mergeSort(array, middleIdx+1, endIdx);		
		
//		���� �迭�� ������
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
