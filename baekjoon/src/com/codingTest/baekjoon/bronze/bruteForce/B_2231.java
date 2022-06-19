package com.codingTest.baekjoon.bronze.bruteForce;

import java.io.*;

public class B_2231 {
//  풀이 도움: https://itadventure.tistory.com/158
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int digit = 0;

    for (int i = n; i > 0; i /= 10) digit++;

    for (int i = n - (digit * 9); i <= n; i++) {
      int sum = i;
      for (int j = i; j > 0; j /= 10) sum += j % 10;
      if (sum == n) {
        System.out.print(i);
        return;
      }
    }
    System.out.print(0);
  }
}
