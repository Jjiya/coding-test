package com.codingTest.baekjoon.silver.function;

import java.io.*;

// 문제 이해 도움: https://www.acmicpc.net/board/view/25689
public class S_1065 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int count = 0;

    for (int i = 1; i <= n; i++) {
      if (i < 100) {
        count++;
      } else {
        char[] iCollections = (i + "").toCharArray();
        if ((iCollections[0] - iCollections[1]) == (iCollections[1] - iCollections[2])) count++;
      }
    }

    System.out.print(count);
  }
}
