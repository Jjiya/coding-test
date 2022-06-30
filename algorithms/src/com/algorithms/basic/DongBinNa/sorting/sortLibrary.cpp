#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int a, int b){
	return a > b;
}

int main(void){
	int a[10] = {9, 3, 5, 4, 1, 10, 8, 6, 7, 2};
	
//	sort(정렬할 정렬의 메모리 주소, 정렬 범위 [, 정렬 기준])  
	sort(a, a+10, compare);
	
	for(int i=0; i<10; i++){
		cout << a[i] << ' ' ;
	}
	
	return 0;
}
