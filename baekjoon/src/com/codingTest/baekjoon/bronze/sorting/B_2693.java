package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2693 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    int[] a;
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      a = new int[10];
      for (int j = 0; j < a.length; j++) {
        a[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(a);
      sb.append(a[7]).append("\n");
    }
    System.out.println(sb);
  }
}
