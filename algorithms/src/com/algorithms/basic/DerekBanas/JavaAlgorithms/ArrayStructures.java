package com.algorithms.basic.DerekBanas.JavaAlgorithms;

// referred this site: https://youtu.be/f5OD9CKrZEw
public class ArrayStructures {
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

  public int getValueAtIndex(int index) {
    if (index < arraySize) return theArray[index];

    return -1;
  }

  public boolean doesArrayContainThisValue(int searchValue) {
    boolean valueInArray = false;
    for (int i = 0; i < arraySize; i++) {
      if (theArray[i] == searchValue) {
        valueInArray = true;
        break;
      }
    }

    return valueInArray;
  }

  public void deleteIndex(int index) {
    if (arraySize < index) return;

    //    for (int i = 0; i < arraySize; i++) { // ERROR: copy array has less index than original array
    for (int i = index; i < arraySize - 1; i++) {
      theArray[i] = theArray[i + 1];
    }
    arraySize--;

    System.out.println("delete complete on" + index + "th value");
  }

  public void insertValue(int value) {
    if (arraySize < 50) {
      theArray[arraySize] = value;
      arraySize++;

      System.out.println("insert complete " + value);
    }
  }

  public String linearSearchForValue(int value) {
    boolean valueInArray = false;
    String indexWithValue = "";

    for (int i = 0; i < arraySize; i++) {
      if (theArray[i] == value) {
        valueInArray = true;
        indexWithValue += i + " ";
      }
    }

    if (valueInArray) {
      System.out.println("The value was Found in the Followings: " + indexWithValue);
    } else {
      indexWithValue = "None";
      System.out.println("The value wasn't Found in theArray");
    }

    return indexWithValue;
  }

  public static void main(String[] args) {
    ArrayStructures arrayStructures = new ArrayStructures();
    arrayStructures.generateRandomArray();
    arrayStructures.printArray();

    System.out.println(arrayStructures.getValueAtIndex(4));

    System.out.println(arrayStructures.doesArrayContainThisValue(3));

    arrayStructures.deleteIndex(3);
    arrayStructures.printArray();

    arrayStructures.insertValue(30);
    arrayStructures.printArray();

    arrayStructures.linearSearchForValue(17);
  }
}
