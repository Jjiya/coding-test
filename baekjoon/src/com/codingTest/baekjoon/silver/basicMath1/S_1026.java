package com.codingTest.baekjoon.silver.basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class S_1026 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < n; j++) {
      a[j] = Integer.parseInt(st.nextToken());
    }

    int[] b = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < n; j++) {
      b[j] = Integer.parseInt(st.nextToken());
    }



  }
}