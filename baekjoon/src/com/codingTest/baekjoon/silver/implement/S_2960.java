package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.StringTokenizer;

public class S_2960 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    boolean[] isRemoved = new boolean[n + 1];

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j * i <= n; j++) {
        if (!isRemoved[j * i]) {
          isRemoved[j * i] = true;
          --k;
        }
        if (k == 0) {
          System.out.print(j * i);
          return;
        }
      }
    }
  }
}
