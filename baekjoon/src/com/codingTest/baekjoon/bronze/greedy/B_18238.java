package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_18238 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String ZOACString = br.readLine().trim();

    int index = 'A', time = 0;

    for (int i = 0; i < ZOACString.length(); i++) {
      int next = ZOACString.charAt(i), distance = Math.abs(index - next);
      time += Math.min(distance, 25 - distance + 1);
      index = next;
    }

    System.out.print(time);
  }
}
