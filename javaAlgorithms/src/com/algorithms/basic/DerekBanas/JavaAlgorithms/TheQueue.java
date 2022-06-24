package com.algorithms.basic.DerekBanas.JavaAlgorithms;

import java.util.Arrays;

// referred this site: https://youtu.be/JvGZh_BdF-8
// Queue is FIFO(First in First OUt)
public class TheQueue {
  private String[] queueArray;
  private int queueSize;
  private int front, rear, numberOfItems = 0;
  // rear = 뒤쪽

  TheQueue(int size) {
    this.queueArray = new String[size];
    this.queueSize = size;

    Arrays.fill(queueArray, "-1");
  }

  public void insert(String input) {
    if (numberOfItems + 1 <= queueSize) {
      queueArray[rear] = input;

      rear++;
      numberOfItems++;

      System.out.println("INSERT " + input + "Was Added to the Queue");
    } else {
      System.out.println("Sorry, But the queue is Full");
    }
  }

  public void priorityInsert(String input) {
    if (numberOfItems == 0) {
      insert(input);
    } else {
      int i;
      for (i = numberOfItems - 1; i >= 0; i--) {
        if (Integer.parseInt(queueArray[i]) < Integer.parseInt(input)) {
          queueArray[i + 1] = queueArray[i];
        } else {
          break;
        }
      }
      queueArray[i + 1] = input;
      rear++;
      numberOfItems++;
    }
  }

  public void remove() {
    if (0 < numberOfItems) {
      System.out.println("REMOVE " + queueArray[front] + "was removed");

      queueArray[front] = "-1";

      front++;
      numberOfItems--;
    } else {
      System.out.println("Sorry, But the queue is Empty");
    }
  }

  public void peek() {
    System.out.println("The First Element is " + queueArray[front]);
  }

  public static void main(String[] args) {
    TheQueue theQueue = new TheQueue(10);
//    theQueue.insert("10");
//    theQueue.insert("15");
//    theQueue.insert("11");

    theQueue.priorityInsert("15");
    theQueue.priorityInsert("10");
    theQueue.priorityInsert("19");
    theQueue.priorityInsert("11");

    theQueue.displayTheQueue();

    theQueue.remove();
    theQueue.remove();
    theQueue.remove();

    theQueue.displayTheQueue();
  }

  public void displayTheQueue() {

    for (int n = 0; n < 61; n++) System.out.print("-");

    System.out.println();

    for (int n = 0; n < queueSize; n++) {
      System.out.format("| %2s " + " ", n);
    }

    System.out.println("|");

    for (int n = 0; n < 61; n++) System.out.print("-");

    System.out.println();

    for (int n = 0; n < queueSize; n++) {
      if (queueArray[n].equals("-1")) System.out.print("|     ");
      else System.out.print(String.format("| %2s " + " ", queueArray[n]));
    }
    System.out.println("|");

    for (int n = 0; n < 61; n++) System.out.print("-");

    System.out.println();
  }
}
