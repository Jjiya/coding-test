package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class S_10866 {
  // https://www.acmicpc.net/problem/10866
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Deque<Integer> deque = new ArrayDeque<>();

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String command = st.nextToken();

      switch (command) {
        case "push_front":
          deque.addFirst(Integer.parseInt(st.nextToken()));
          break;

        case "push_back":
          deque.addLast(Integer.parseInt(st.nextToken()));
          break;

        case "pop_front":
          try {
            sb.append(deque.removeFirst()).append("\n");
          } catch (NoSuchElementException e) {
            sb.append("-1\n");
          }
          break;
        case "pop_back":
          try {
            sb.append(deque.removeLast()).append("\n");
          } catch (NoSuchElementException e) {
            sb.append("-1\n");
          }
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          sb.append(deque.isEmpty() ? 1 : 0).append("\n");
          break;
        case "front":
          try {
            sb.append(deque.getFirst()).append("\n");
          } catch (NoSuchElementException e) {
            sb.append("-1\n");
          }
          break;
        case "back":
          try {
            sb.append(deque.getLast()).append("\n");
          } catch (NoSuchElementException e) {
            sb.append("-1\n");
          }
          break;
      }
    }

    System.out.print(sb);
  }
}
