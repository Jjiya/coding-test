package com.codingTest.baekjoon.silver.basicMath2;

import java.io.*;
import java.util.ArrayList;

public class S_11653 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1) return;

    StringBuilder sb = new StringBuilder();
    int division = 2;
    while (1 < n) {
      if (n % division == 0) {
        n /= division;
        sb.append(division).append("\n");
      } else {
        division++;
      }
    }

    System.out.print(sb);
  }

  static ArrayList<Integer> primeFactorization(int num) {
    ArrayList<Integer> primeList = new ArrayList<>();
    int division = 2;
    while (1 < num) {
      if (num % division == 0) {
        primeList.add(division);
      } else {
        division++;
      }
    }
    return primeList;
  }

  static boolean isPrime(int num) {
    if (num == 2 || num == 3) return true;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
}
