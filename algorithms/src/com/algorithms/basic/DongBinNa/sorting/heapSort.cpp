#include <stdio.h>

int number = 9;
int heap[9] = {7, 6, 5, 8, 3, 5, 9, 1, 6};

int main(void){
//	전체 트리 구조를 최대 힙 구조로 변경 
	for(int i=1; i<number; i++){
		int c = i;
		do{
			int root = (c-1) / 2;
			if(heap[root] < heap[c]){
				int temp = heap[c];
				heap[c] = heap[root];
				heap[root] = temp;
			}
//			부모로 이동 
			c = root;
		}while(c != 0);
	}
	
//	크기를 줄여가며 반복적으로 힙을 구성
	for(int i=number-1; i>=0; i--){
//		가장 큰 값을 마지막으로 보낸다.
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		
		int root = 0;
		int c = 1;
		do{
			c = (2 * root) + 1;
//			자식 중 더 큰 값을 찾기
			if(heap[c] < heap[c+1] && c < i-1){
				c++;
			}
//			루트보다 자식이 더 크면 교환 && c가 범위를 벗어나지 않았다면 
			if(heap[root] < heap[c] && c < i){
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
//			다시 c를 root로 이동시켜서 재귀적으로 반복
			root = c;
		}while(c < i);
	}
	
	for(int i=0; i<number; i++){
		printf("%d ", heap[i]);
	}
	return 0;
}
