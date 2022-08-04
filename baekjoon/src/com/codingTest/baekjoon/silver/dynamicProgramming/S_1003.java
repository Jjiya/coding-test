package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

public class S_1003 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] fibonacciCount = new int[41][2];
    fibonacciCount[0][0] = 1;
    fibonacciCount[1][1] = 1;

    for (int i = 2; i < fibonacciCount.length; i++) {
      fibonacciCount[i][0] = fibonacciCount[i - 1][0] + fibonacciCount[i - 2][0];
      fibonacciCount[i][1] = fibonacciCount[i - 1][1] + fibonacciCount[i - 2][1];
    }

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while (t-- > 0) {
      int tc = Integer.parseInt(br.readLine());
      sb.append(fibonacciCount[tc][0]).append(" ").append(fibonacciCount[tc][1]).append("\n");
    }

    System.out.print(sb);
  }
}
/** 문제 풀이 규칙
 *  tc( 0 )
 * 0 |	1
 * -------
 * 1 |	0
 *
 * tc( 1 )
 * 0 |	1
 * -------
 * 0 |	1
 *
 * tc( 2 )
 * 0 |	1
 * -------
 * 1 |	1
 *
 * tc( 3 )
 * 0 |	1
 * -------
 * 1 |	2
 *
 * tc( 4 )
 * 0 |	1
 * -------
 * 2 |	3
 *
 * tc( 5 )
 * 0 |	1
 * -------
 * 3 |	5
 *
 * tc( 6 )
 * 0 |	1
 * -------
 * 5 |	8
 */