package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S_11931 {
  // https://www.acmicpc.net/problem/11931
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n =Integer.parseInt(br.readLine());

    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {
      queue.offer(Integer.parseInt(br.readLine()));
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      sb.append(queue.poll()).append("\n");
    }

    System.out.print(sb);
  }
}
