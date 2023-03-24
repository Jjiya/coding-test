package com.codingTest.baekjoon.bronze.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class B_19523 {
  // https://www.acmicpc.net/problem/19523
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] valueList = new int[6];

    for (int i = 0; i < valueList.length; i++) {
      valueList[i] = Integer.parseInt(st.nextToken());
    }

    int a = valueList[0];
    int b = valueList[1];
    int c = valueList[2];
    int d = valueList[3];
    int e = valueList[4];
    int f = valueList[5];

    for (int x = -999; x < 1000; x++) {
      for (int y = -999; y < 1000; y++) {
        if ((a * x) + (b * y) == c && (d * x) + (e * y) == f) {
          System.out.print(x + " " + y);
          return;
        }
      }
    }

    /* 다른 사람 풀이
      x = (c * e - f * b) / (a * e - d * b)
		  y = (c * d - f * a) / (b * d - e * a)
     */
  }
}
