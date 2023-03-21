package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S_11279 {
  // https://www.acmicpc.net/problem/11279
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> queue = new PriorityQueue<>(n, Comparator.reverseOrder());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());

      queue.offer(x);

      if (x == 0) {
        sb.append(queue.poll()).append("\n");
      }
    }

    System.out.print(sb);
  }
}
