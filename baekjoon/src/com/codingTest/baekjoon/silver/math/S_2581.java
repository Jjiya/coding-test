package com.codingTest.baekjoon.silver.math;

import java.io.*;

public class S_2581 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int minimum = Integer.parseInt(br.readLine());
    int maximum = Integer.parseInt(br.readLine());

    int sum = 0, min = Integer.MAX_VALUE;
    for (int i = minimum; i <= maximum; i++) {
      if (isPrime(i)) {
        sum += i;
        min = Math.min(min, i);
      }
    }

    if (sum == 0) {
      System.out.print(-1);
      return;
    }

    System.out.print(sum + "\n" + min);
  }

  static boolean isPrime(int num) {
    if (num == 1) return false;
    if (num == 2 || num == 3) return true;

    boolean isPrimeCheck = false;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
      else isPrimeCheck = true;
    }
    return isPrimeCheck;
  }
}
