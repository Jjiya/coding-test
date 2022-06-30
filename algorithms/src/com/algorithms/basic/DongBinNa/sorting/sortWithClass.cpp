#include <iostream>
#include <algorithm>

using namespace std;

class Student {
public:
	string name;
	int score;
	
	Student(string name, int score){
		this->name = name;
		this->score = score;
	}
	
	bool operator < (Student &student){
		return this->score > student.score;
	}
};

int main(void){
	
	Student students[] = {
		Student("A", 90),
		Student("B", 93),
		Student("C", 97),
		Student("D", 83),
		Student("E", 70)
	};
	
	sort(students, students+5);
	
	for(int i=0; i<5; i++){
		cout << students[i].name << '_' << students[i].score << ' ';
	}
	
	return 0;
}
