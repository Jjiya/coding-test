package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_11399 {

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    long[] list = new long[n];


    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(list);

    long sum = list[0];
    for (int i = 1; i < n; i++) {
      list[i] += list[i - 1];
      sum += list[i];
    }

    System.out.print(sum);
  }

  //  내 풀이 아님 -> https://www.acmicpc.net/source/5971263
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] a = new int[n];


    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    Arrays.sort(a);

    for (int i = 0; i < n; ++i) {
      int p = n - i;  // 제일 작은 숫자가 p번 반복되어서 저장될거니까!!! 이해 ㅇㅋ
      ans += a[i] * p;
    }

    System.out.print(ans);
  }
}
