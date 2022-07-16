package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

// 참고: https://sihyungyou.github.io/baekjoon-1463/
public class S_1463 {

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];

    dp[0] = -1;
    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }
    }

    System.out.print(dp[n]);
  }
}
/*
 다른 풀이  https://www.acmicpc.net/source/11835772
 * public static void main(String[] args) throws NumberFormatException, IOException {
 * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 		int n = Integer.parseInt(br.readLine());
 * 		System.out.print(recursive(n, 0));
 *         br.close();
 *    }
 * 	public static int recursive(int value, int count) {
 * 		if(value==1 || value==0)
 * 			return count;
 * 		else {
 * 			int cal2 = recursive(value/2, count+1 + (value%2));
 * 			int cal3 = recursive(value/3, count+1 + (value%3));
 * 			return Math.min(cal2, cal3);
 *    }
 *  }
 */