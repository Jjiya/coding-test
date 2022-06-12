package com.codingTest.baekjoon.silver.basicMath2;

import java.io.*;
import java.util.StringTokenizer;

public class S_1929 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int min = Integer.parseInt(st.nextToken());
    int max = Integer.parseInt(st.nextToken());

    for (int i = min; i <= max; i++) {
      if (isPrime(i)) sb.append(i + "\n");
    }
    System.out.print(sb);
  }

  static boolean isPrime(int checkNum) {
    if (checkNum == 1) return false;
    if (checkNum == 2 || checkNum == 3) return true;
    for (int i = 2; i * i <= checkNum; i++) {
      if (checkNum % i == 0) return false;
    }
    return true;
  }
}
