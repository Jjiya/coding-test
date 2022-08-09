package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1920 {
  static int[] a;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    a = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int findNum = Integer.parseInt(st.nextToken());

      sb.append(findNumInA(findNum) ? "1\n" : "0\n");
    }

    System.out.print(sb);
  }

  static boolean findNumInA(int findNum) {
    int start = 0;
    int end = a.length - 1;
    int middle = (start + end) / 2;
    /*
      0   2   4
      1 3 5 7 9

      [7]
      5 < [7]
      현재 middle number가 findNum보다 작으면 start를 증가시켜야함
      start => mid + 1;
    */

    while (end - start >= 0) {
      if (a[middle] > findNum) {
        end = middle - 1;
      } else if (a[middle] < findNum) {
        start = middle + 1;
      } else {
        return true;
      }

      middle = (start + end) / 2;
    }

    return false;
  }

  //  시간 초과
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[] a = new boolean[(int) Math.pow(2, 31)];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[Integer.parseInt(st.nextToken())] = true;
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      sb.append(a[Integer.parseInt(st.nextToken())] ? "1\n" : "0\n");
    }

    System.out.print(sb);
  }
}
