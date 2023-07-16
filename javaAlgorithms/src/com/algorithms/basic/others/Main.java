package com.algorithms.basic.others;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    runStack(5);
  }

  static void runQueue(int size) {
    Queue sampleQueue = new Queue(size);

    sampleQueue.push(1);
    sampleQueue.push(2);
    sampleQueue.push(3);

    System.out.println(sampleQueue.pop());
    System.out.println(sampleQueue.pop());
    System.out.println(sampleQueue.pop());

    sampleQueue.push(4);
    sampleQueue.push(5);
    sampleQueue.push(6);
    sampleQueue.push(7);
    sampleQueue.push(8);
  }

  static void runStack(int size) {
    Stack sampleStack = new Stack(size);

    sampleStack.push(1);
    sampleStack.push(2);
    sampleStack.push(3);

    System.out.println(sampleStack.pop());
    System.out.println(sampleStack.pop());
    System.out.println(sampleStack.pop());

    sampleStack.push(4);
    sampleStack.push(5);
    sampleStack.push(6);
    sampleStack.push(7);
    sampleStack.push(8);
  }
}
