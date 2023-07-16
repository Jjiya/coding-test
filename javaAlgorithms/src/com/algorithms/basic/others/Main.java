package com.algorithms.basic.others;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    runQueue();

  }

  static void runQueue() {
    Queue sampleQueue = new Queue(5);

    sampleQueue.push(1);
    sampleQueue.push(2);
    sampleQueue.push(3);

    sampleQueue.pop();
    sampleQueue.pop();
    sampleQueue.pop();

    sampleQueue.push(4);
    sampleQueue.push(5);
    sampleQueue.push(6);
    sampleQueue.push(7);
    sampleQueue.push(8);
  }
}
