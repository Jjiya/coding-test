package com.codingTest.baekjoon.contest.yonseiUnivOpenContest;

import java.io.*;
import java.util.StringTokenizer;

public class B_25305 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] scores = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (scores[i] > scores[j]) {
          int temp = scores[i];
          scores[i] = scores[j];
          scores[j] = temp;
        }
      }
    }

    System.out.print(scores[k - 1]);
  }
}
