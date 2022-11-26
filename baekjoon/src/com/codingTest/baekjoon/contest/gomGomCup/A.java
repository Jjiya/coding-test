package com.codingTest.baekjoon.contest.gomGomCup;

import java.io.*;
import java.util.StringTokenizer;

public class A {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int count = 0;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), "D-");

      if (Integer.parseInt(st.nextToken()) <= 90) {
        count++;
      }
    }

    System.out.print(count);
  }
}
