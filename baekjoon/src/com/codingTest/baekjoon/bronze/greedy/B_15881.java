package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_15881 {
  // https://www.acmicpc.net/problem/15881
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String PPAP = "pPAp";

    int idx = 0;
    int count = 0;

    for (char alphabet : br.readLine().toCharArray()) {
      if (alphabet != PPAP.charAt(idx)) {
        idx = alphabet == 'p' ? 1 : 0;
        continue;
      }

      idx++;

      if (idx == PPAP.length()) {
        idx = 0;
        count++;
      }
    }

    System.out.print(count);
  }
}
