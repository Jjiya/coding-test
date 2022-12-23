package com.codingTest.baekjoon.silver.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class S_14888 {
  // https://www.acmicpc.net/problem/14888
  static int minValue = Integer.MAX_VALUE;
  static int maxValue = Integer.MIN_VALUE;
  static String[] arithmetic;
  static boolean[] isUse;
  static int[] numeric;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    numeric = new int[n];
    arithmetic = new String[n - 1];
    isUse = new boolean[n - 1];

    for (int i = 0; i < n; i++) {
      numeric[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    int idx = 0;
    for (String symbol : new String[]{"+", "-", "*", "/"}) {
      int count = Integer.parseInt(st.nextToken());

      for (int i = 0; i < count; i++) {
        arithmetic[idx++] = symbol;
      }
    }

    dfs(0, numeric[0]);

    System.out.println(maxValue);
    System.out.print(minValue);
  }

  static void dfs(int count, int result) {
    if (count == arithmetic.length) {
      minValue = Math.min(minValue, result);
      maxValue = Math.max(maxValue, result);

      return;
    }

    for (int i = 0; i < arithmetic.length; i++) {
      if (!isUse[i]) {
        isUse[i] = true;
        dfs(count + 1, calculator(arithmetic[i], result, numeric[count + 1]));
        isUse[i] = false;
      }
    }
  }

  static int calculator(String symbol, int a, int b) {
    switch (symbol) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        boolean isMinusValue = false;
        if (a < 0) {
          a *= -1;
          isMinusValue = true;
        }

        int result = (int) Math.floor((double) a / b);

        return isMinusValue ? result * -1 : result;
    }

    return 0;
  }
}
