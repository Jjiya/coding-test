package com.algorithms.basic.DerekBanas.JavaAlgorithms;

import java.util.Arrays;
import java.util.StringTokenizer;

// referred this site: https://youtu.be/JvGZh_BdF-8
//  Stack is LIFO (Last In First Out)
public class TheStack {
  private String[] stackArray;
  private int stackSize;
  private int topOfStack = -1;

  TheStack(int size) {
    this.stackSize = size;
    this.stackArray = new String[size];
    Arrays.fill(stackArray, "-1");
  }

  public void push(String input) {
    if (topOfStack + 1 < stackSize) {
      topOfStack++;
      stackArray[topOfStack] = input;
    } else {
      System.out.println("Sorry, But the stack is Full");
    }
    displayTheStack();

    System.out.println("PUSH " + input + " was Added to the Stack");
  }

  public void pushManyOriginal(String multipleValues) {
    String[] tmpString = multipleValues.split("\\s");
    for (int i = 0; i < tmpString.length; i++) {
      if (topOfStack < stackSize - 1) break;
      push(tmpString[i]);
    }
  }

  //  this is using StringTokenizer (make myself)
  public void pushMany(String multipleValues) {
    StringTokenizer st = new StringTokenizer(multipleValues);

    while (st.hasMoreElements() && topOfStack < stackSize - 1) {
      push(st.nextToken());
    }
  }

  public String pop() {
    if (0 <= topOfStack) {
      System.out.println("POP " + stackArray[topOfStack] + " was Removed from the Stack");

      stackArray[topOfStack] = "-1";

      displayTheStack();
      return stackArray[topOfStack--];
    } else {
      displayTheStack();
      System.out.println("Sorry, But the stack is Empty");

      return "-1";
    }
  }

  public void popAll() {
    for (int i = topOfStack; i >= 0; i--) {
      pop();
    }
  }

  public String peek() {
    displayTheStack();
    System.out.println("PEEK " + stackArray[topOfStack] + " is at the Top of the Stack");

    displayTheStack();
    return stackArray[topOfStack];
  }

  public static void main(String[] args) {
    TheStack theStack = new TheStack(10);

    theStack.push("10");
    theStack.push("15");

    theStack.peek();
    theStack.pop();

    theStack.pushMany("1 2 3 4 5 6 7 8 9 10 11 12");

    theStack.popAll();
  }

  /********* print Stack *********/
  public void displayTheStack() {

    for (int n = 0; n < 61; n++) System.out.print("-");

    System.out.println();

    for (int n = 0; n < stackSize; n++) {
      System.out.format("| %2s " + " ", n);
    }

    System.out.println("|");

    for (int n = 0; n < 61; n++) System.out.print("-");

    System.out.println();

    for (int n = 0; n < stackSize; n++) {
      if (stackArray[n].equals("-1")) System.out.print("|     ");
      else System.out.print(String.format("| %2s " + " ", stackArray[n]));
    }
    System.out.println("|");

    for (int n = 0; n < 61; n++) System.out.print("-");

    System.out.println();
  }
}
