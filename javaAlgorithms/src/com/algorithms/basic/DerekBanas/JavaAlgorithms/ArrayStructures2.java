package com.algorithms.basic.DerekBanas.JavaAlgorithms;

// referred this site: https://youtu.be/JUOyKSZScW0
public class ArrayStructures2 {
  private int[] theArray = new int[50];
  private int arraySize = 10;

  public void generateRandomArray() {
    for (int i = 0; i < arraySize; i++) {
      theArray[i] = (int) (Math.random() * 10) + 10;
    }
  }

  public void printArray() {
    System.out.println("----------");
    for (int i = 0; i < arraySize; i++) {
      System.out.printf("| %d | %d |\n", i, theArray[i]);
    }
    System.out.println("----------");
  }

  public void bubbleSort() {
    for (int i = arraySize - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (theArray[j] > theArray[j + 1]) {
          swapValue(j, j + 1);
        }
      }
    }
  }

  public void binarySearchForValue(int value) {
    int lowIndex = 0;
    int highIndex = arraySize / 2;

    while (lowIndex < highIndex) {
      int middleIndex = (lowIndex + highIndex) / 2;
      if (theArray[middleIndex] > value) highIndex = middleIndex;
      else if (theArray[middleIndex] < value) lowIndex = middleIndex;
      else {
        System.out.println("Found a Match for " + value + " at Index " + middleIndex);
        lowIndex = highIndex + 1;
      }
    }

  }

  public void binarySearchForValueMySolution(int value) {
    /**
     * 현재 찾으려는 범위를 반으로 줄인다.
     * ㄴ 중간에 있는 값이 찾으려는 값보다 크면 범위를 아래 절반으로 변경한다.
     * ㄴ 중간에 있는 값이 찾으려는 값보다 작으면 범위를 위 절반으로 변경한다.
     * 다시 줄인 범위의 반으로 나눈다.
     * ㄴ 중간에 있는 값이 찾으려는 값보다 크면 범위를 아래 절반으로 변경한다.
     * ㄴ 중간에 있는 값이 찾으려는 값보다 작으면 범위를 위 절반으로 변경한다.
     * 값 나올때까지 반복
     */
    int i = arraySize / 2;
    int idx = -1;
    while (-1 < i && i < arraySize + 1) {
      if (value < theArray[i]) i /= 2;
      else if (theArray[i] < value) i *= 2;
      else if (theArray[i] == value) {
        idx = i;
        break;
      }
    }

    System.out.println("this value in " + idx + " index");
  }

  public void selectionSort() {
    for (int i = 0; i < arraySize; i++) {
      int minimum = i;
      for (int j = i; j < arraySize; j++) {
        if (theArray[j] < theArray[minimum]) minimum = j;
      }
      swapValue(i, minimum);
    }
  }

  public void insertionSort() {
    for (int i = 1; i <= arraySize; i++) {
      int j = i;
      int toInsert = theArray[i];

      while ((0 < j) && (toInsert < theArray[j - 1])) {
        theArray[j] = theArray[j - 1];
        j--;
      }
      theArray[j] = toInsert;

    }
  }

  public void swapValue(int indexOne, int indexTwo) {
    int temp = theArray[indexOne];
    theArray[indexOne] = theArray[indexTwo];
    theArray[indexTwo] = temp;
  }

  public static void main(String[] args) {
    ArrayStructures2 arrayStructures = new ArrayStructures2();
    arrayStructures.generateRandomArray();
    arrayStructures.printArray();

//    arrayStructures.bubbleSort();
//    arrayStructures.printArray();

//    arrayStructures.binarySearchForValue(10);

//    arrayStructures.selectionSort();
//    arrayStructures.printArray();

    arrayStructures.insertionSort();
    arrayStructures.printArray();
  }
}
