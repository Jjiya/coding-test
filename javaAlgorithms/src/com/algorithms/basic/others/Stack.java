package com.algorithms.basic.others;

import java.util.EmptyStackException;

public class Stack {
  private int top = -1;
  private int[] stack;
  private int capacity;

  public Stack(int capacity) {
    this.capacity = capacity;
    this.stack = new int[capacity];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public int push(int number) {
    if (top == capacity - 1) {
      throw new IllegalStateException();
    }

    stack[++top] = number;

    return number;
  }

  public int pop() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    }

    return stack[top--];
  }

  public int peek() {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    }

    return stack[top];
  }
}
