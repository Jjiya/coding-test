package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_2075 {
  // https://www.acmicpc.net/problem/2075
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;

    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        queue.offer(Integer.parseInt(st.nextToken()));
      }
    }

    for (int i = 0; i < n-1; i++) {
      queue.poll();
    }

    System.out.println(queue.poll());
  }
}
