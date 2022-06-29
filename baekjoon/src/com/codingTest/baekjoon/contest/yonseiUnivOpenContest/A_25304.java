package com.codingTest.baekjoon.contest.yonseiUnivOpenContest;

import java.io.*;
import java.util.StringTokenizer;

public class A_25304 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int total = Integer.parseInt(br.readLine());
    int count = Integer.parseInt(br.readLine());

    for (int i = 0; i < count; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      total -= (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
      if (total < 0) break;
    }

    System.out.print(total == 0 ? "Yes" : "No");
  }
}
