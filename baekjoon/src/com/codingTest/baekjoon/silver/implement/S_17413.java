package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.Stack;

public class S_17413 {
  static Stack<Character> stack;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char character = s.charAt(i);
      if (character == '<') {
        sb.append(getWordInStack());

        int endTagIdx = s.indexOf('>', i);
        sb.append(s, i, endTagIdx + 1);
        i = endTagIdx;

      } else {
        if (character == ' ') {
          sb.append(getWordInStack()).append(character);
        } else {
          stack.push(character);
        }
      }
    }

    sb.append(getWordInStack());

    System.out.print(sb);
  }

  static String getWordInStack() {
    StringBuilder subSb = new StringBuilder();

    while (!stack.isEmpty()) {
      subSb.append(stack.pop());
    }

    return subSb.toString();
  }
}
//<ab cd> ef gh<ij kl>
//<ab cd> ef gh <ij kl>