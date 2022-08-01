package com.codingTest.baekjoon.silver.string;

import java.io.*;
import java.util.Stack;

/*
  1. 열린 괄호면 스택에 push 한다.
  2. 닫힌 괄호면 스택에 있는 것을 하나 peek 한다.
    2-1. 만약 스택에 있는 괄호가 열린 괄호면 스택에서 pop 한다.
    2-2. 만약 스택에 있는 괄호가 닫힌 괄호면 스택에 push 한다.
    2-3. 만약 스택이 비어있으면 스택에 push 한다.
  3. read 해온 ps 길이 만큼 반복문을 반복한다.
  4. 반복문 종료 시
    4-1. 스택이 비어있지 않으면 NO
    4-2. 비어있으면 YES
  5. testcase 수 만큼 반복문을 반복한 후 종료한다.
 */
public class S_9012 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while (t-- > 0) {
      String ps = br.readLine();
      Stack<Character> psStack = new Stack<>();

      for (char parenthesis : ps.toCharArray()) {
        if (parenthesis == '(' || psStack.empty()) {
          psStack.push(parenthesis);
        } else if (psStack.peek() == '(') {
          psStack.pop();
        } else {
          psStack.push(parenthesis);
        }
      }

      sb.append(psStack.empty() ? "YES" : "NO").append("\n");
    }

    System.out.print(sb);
  }
}