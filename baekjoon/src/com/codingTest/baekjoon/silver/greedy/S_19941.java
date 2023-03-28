package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_19941 {
  // https://www.acmicpc.net/problem/19941
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    boolean[] isEat = new boolean[n];

    int eatCount = 0;
    String list = br.readLine();

    for (int i = 0; i < n; i++) {
      if (list.charAt(i) == 'H') {
        continue;
      }

      for (int j = Math.max(0, i - k); j <= Math.min(i + k, n - 1); j++) {
        if (!isEat[j] && list.charAt(j) != 'P') {
          isEat[j] = true;
          eatCount++;
          break;
        }
      }
    }

    System.out.println(eatCount);
  }
}
