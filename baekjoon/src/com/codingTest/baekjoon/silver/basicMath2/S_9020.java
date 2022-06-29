package com.codingTest.baekjoon.silver.basicMath2;

import java.io.*;

public class S_9020 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while (0 < t) {
      int n = Integer.parseInt(br.readLine());
      int min = 10001, candidate = 0;

      for (int i = 2; i < n; i++) {
        if (isPrime(i) && isPrime(n - i)) {
          int interval = Math.abs((n - i) - i); // 두 소수의 차이
          if (interval < min) {
            min = interval;
            candidate = i;
          }
        }
      }
      sb.append(candidate).append(" ").append(n - candidate).append("\n");

      t--;
    }
    System.out.print(sb);
  }

  static boolean isPrime(int num) {
    if (num == 1) return false;
    if (num == 2 || num == 3) return true;

    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }

    return true;
  }
}
