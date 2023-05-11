package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_16212 {
  // https://www.acmicpc.net/problem/16212
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      queue.offer(Integer.parseInt(st.nextToken()));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(queue.poll()).append(" ");
    }

    System.out.print(sb);
  }
}
