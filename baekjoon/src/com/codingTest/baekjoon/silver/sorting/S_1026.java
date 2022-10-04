package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1026 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] a = new int[n];
    int[] b = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(b);

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (a[i] * b[n - i - 1]);
    }

    System.out.print(sum);
  }
}
