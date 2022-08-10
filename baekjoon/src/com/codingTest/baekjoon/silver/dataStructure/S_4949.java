package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.Stack;

public class S_4949 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    StringBuilder sb = new StringBuilder();

    while (!(input = br.readLine()).equals(".")) {
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < input.length(); i++) {
        char character = input.charAt(i);
        if (character == '(' || character == '[') {
          stack.push(character);
        } else if (character == ')' || character == ']') {
          if (stack.isEmpty()) {
            stack.push(character);
            break;
          } else {
            char pickChar = stack.peek();
            if (character == ')') {
              if (pickChar == '(') {
                stack.pop();
              } else {
                stack.push(character);
              }
            } else {
              if (pickChar == '[') {
                stack.pop();
              } else {
                stack.push(character);
              }
            }
          }
        }
      }

      sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
    }

    System.out.println(sb);
  }
}
