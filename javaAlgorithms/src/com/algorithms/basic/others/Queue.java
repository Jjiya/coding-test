package com.algorithms.basic.others;

import java.util.NoSuchElementException;

public class Queue {
  private int[] queue;
  private int capacity;
  private int front = 0;
  private int rear = 0;

  public Queue(int size) {
    this.queue = new int[size + 1];
    capacity = size + 1;
  }

  public int size() {
    if (this.isEmpty()) {
      return 0;
    }

    return front - rear;
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public boolean push(int number) {
    if ((rear + 1) % capacity == front) {
      throw new IllegalStateException();
    }

    rear = (rear + 1) % capacity;
    queue[rear] = number;

    return true;
  }

  public int pop() {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }

    front = (front + 1) % capacity;

    return queue[front];
  }

  public int peek() {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }

    return queue[(front + 1) % capacity];
  }
}
