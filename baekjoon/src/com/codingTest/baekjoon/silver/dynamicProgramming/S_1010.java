package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
https://st-lab.tistory.com/194

조합론 문제
조합론: b가 n개 있을 때 r개를 뽑는 경우

(n)    =    n!
(r)     --------
        r!(n-r)!
        
TODO: 다시 풀어볼 것
 */
public class S_1010 {
  static HashMap<Integer, Double> factorial = new HashMap<>();

  static int[][] dp = new int[30][30];

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());


    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      sb.append(getNumberCase(m, n)).append("\n");
    }

    System.out.print(sb);
  }

  static int getNumberCase(int m, int n) {
    if (dp[m][n] > 0) {
      return dp[m][n];
    }

    if (m == n || n == 0) {
      return 1;
    }

    return dp[m][n] = getNumberCase(m - 1, n - 1) + getNumberCase(m - 1, n);
  }

  static double getFactorial(int num) {
    if (num <= 1) {
      return 1L;
    }

    if (factorial.containsKey(num)) {
      return factorial.get(num);
    } else {
      double result = num * getFactorial(num - 1);
      factorial.put(num, result);
      return result;
    }
  }
}
