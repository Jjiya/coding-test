package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.PriorityQueue;

public class S_1927 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> queue = new PriorityQueue<>(n);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        if (queue.isEmpty()) {
          sb.append(0);
        } else {
          sb.append(queue.poll());
        }
        sb.append("\n");
      } else {
        queue.add(x);
      }
    }
    System.out.print(sb);
  }
}