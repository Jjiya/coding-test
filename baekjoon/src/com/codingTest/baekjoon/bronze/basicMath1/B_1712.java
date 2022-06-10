package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class B_1712 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int sales1 = (c - (a + b));
    if (0 < sales1) {
      System.out.print(1);
      return;
    }

    int sales2 = (c * 2 - (a + (b * 2)));

    System.out.print(sales1 < sales2 ? (sales1 / (sales1 - sales2)) + 2 : -1);

//    다른 답안 보니까 더 간단함 >> (A / (C - B) + 1)
  }
}