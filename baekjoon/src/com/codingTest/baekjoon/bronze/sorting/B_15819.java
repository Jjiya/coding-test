package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class B_15819 {
  // https://www.acmicpc.net/problem/15819
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int i = Integer.parseInt(st.nextToken());

    PriorityQueue<String> queue = new PriorityQueue<>();

    for (int j = 0; j < n; j++) {
      queue.offer(br.readLine());
    }

    for (int j = 0; j < i - 1; j++) {
      queue.poll();
    }

    System.out.print(queue.poll());
  }
}
