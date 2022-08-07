package com.codingTest.baekjoon.silver.dataStructure;

import java.util.Arrays;
import java.io.*;

public class S_10828 {
  static StringBuilder sb = new StringBuilder();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack stack = new Stack(n);

    for (int i = 0; i < n; i++) {
      stack.run(br.readLine());
    }

    System.out.println(sb);
  }

  static class Stack {
    int[] stackValue;
    int size; // 스택 총 사이즈
    int lastIndex; //제일 마지막 값이 있는 인덱스

    Stack(int size) {
      this.stackValue = new int[size];
      Arrays.fill(stackValue, -1);
      this.size = size;
      this.lastIndex = -1;
    }

    public void run(String runValue) {
      String[] value = runValue.split("\\s");
      switch (value[0]) {
        case "push":
          int x = Integer.parseInt(value[1]);
          push(x);
          break;
        case "pop":
          saveResult(pop());
          break;
        case "size":
          saveResult(size());
          break;
        case "empty":
          saveResult(empty());
          break;
        case "top":
          saveResult(top());
          break;
        default:
          break;
      }
    }

    private void saveResult(int result) {
      sb.append(result).append("\n");
    }

    //    정수 X를 스택에 넣는 연산이다.
    private void push(int x) {
      ++lastIndex;
      stackValue[lastIndex] = x;
    }

    //    스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    private int pop() {
      int lastNum;

      if (lastIndex == -1) {
        lastNum = -1;
      } else {
        lastNum = stackValue[lastIndex];
        lastIndex = Math.max(-1, lastIndex - 1);
      }

      return lastNum;
    }

    //    스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    private int top() {
      return lastIndex == -1 ? -1 : stackValue[lastIndex];
    }

    //    스택에 들어있는 정수의 개수를 출력한다.
    private int size() {
      return lastIndex + 1;
    }

    //    스택이 비어있으면 1, 아니면 0을 출력한다.
    private int empty() {
      return lastIndex == -1 ? 1 : 0;
    }
  }
}
