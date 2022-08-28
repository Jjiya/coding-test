package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.Stack;

public class S_1874 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int[] list = new int[n];
    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(br.readLine());
    }

    int listIdx = 0;
    int i = 1;
    StringBuilder sb = new StringBuilder();


    while (listIdx < n) {
      while (i <= list[listIdx]) {
        stack.push(i++);
        sb.append("+\n");
      }
      int pop = stack.pop();

      if (pop == list[listIdx++]) {
        sb.append("-\n");
      } else {
        System.out.print("NO");
        return;
      }
    }

    System.out.print(sb);
  }

  public void wrong() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int[] list = new int[n];
    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(br.readLine());
    }

    int listIdx = 0;
    int i = 1;
    StringBuilder sb = new StringBuilder();

    stack.push(1);

    while (listIdx < n) {
      if (!stack.isEmpty() && stack.peek() == list[listIdx]) {
        listIdx++;
        stack.pop();
        sb.append("-");
      } else {
        if (n < i + 1) {
          System.out.print("NO");
          return;
        } else {
          stack.push(++i);
          sb.append("+");
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
