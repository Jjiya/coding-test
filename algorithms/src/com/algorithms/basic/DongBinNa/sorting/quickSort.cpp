#include <stdio.h>

int number = 10;
int data[10] = {1, 4, 5, 10, 2, 6, 8, 9, 3, 7};
//					  p	 i				 j  e
//1. pivot���� -> �������� pivot���� ū ���� ã��
//2. ������ pivot���� ���Բ� pivot <- �� �̷� �������� ���Բ� �����Ͽ� pivot���� ���� ���� ã��
//4. �׷���, pivot���� ���� ���� 2�� ������ ����ġ�� 1.�� ���� pivot���� �ٲ���Ѵ�.
//5. ������ ���� �������� ������ start���� 2. ���� 1ĭ �۰�
//	 ������ 2. ���� �����ʿ��� ���������� �� ������ �ݺ� >> ���
//6. ���� pivot���� end���� ũ�ų� ������ �׸�~~
void mySelf(int *data, int start, int end){
	if(start >= end){	// ���Ұ� 1���� ���
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
	if(start >= end){	// ���Ұ� 1���� ���
		return; 
	}
	int key = start;	//key�� ù��° ���
	int i = start+1;	//���ʺ��� ����� key������ ū ���� ã�� ����
	int j = end;	// �����ʺ��� ����� key���� ���� ���� ã�� ����
	int temp;
	
	while(i <= j){	//������ ������ �ݺ� 
		while(i <= end && data[i] <= data[key]){	//Ű ������ ū ���� ���� ������ ���������� �̵� 
			i++;
		}
		while(j > start && data[j] >= data[key]){	//Ű ������ ���� ���� ���� ������ �������� �̵� && start���� Ŭ �������� ����(�� ������ ���� ������ ������ ����� ������) 
			j--;
		}
		
		if(i > j){	//������ ���¸� Ű ���� ��ü 
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
