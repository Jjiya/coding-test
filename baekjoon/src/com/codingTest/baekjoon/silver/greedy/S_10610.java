package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;

public class S_10610 {
  // https://www.acmicpc.net/problem/10610
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] n = br.readLine().toCharArray();

    boolean zero = false;
    int sumOfDigit = 0;

    for (char num : n) {
      if (num == '0') zero = true;

      sumOfDigit += (num - 48);
    }

    if (!zero || sumOfDigit % 3 != 0) {
      System.out.print("-1");
      return;
    }

    Arrays.sort(n);
    
    System.out.print(new StringBuilder(String.valueOf(n)).reverse());
  }

  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String n = br.readLine();

    if (n.indexOf("0") == -1) {
      System.out.print("-1");
      return;
    }

    int[] numbers = new int[n.length()];
    int sumOfDigit = 0;

    for (int i = 0; i < n.length(); i++) {
      numbers[i] = Character.getNumericValue(n.charAt(i));
      sumOfDigit += numbers[i];
    }

    if (sumOfDigit % 3 != 0) {
      System.out.print("-1");
      return;
    }

    Arrays.sort(numbers);

    StringBuilder sb = new StringBuilder();

    for (int i = n.length() - 1; i >= 0; i--) {
      sb.append(numbers[i]);
    }

    System.out.print(sb);
  }
}
