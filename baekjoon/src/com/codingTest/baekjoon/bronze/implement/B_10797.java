package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

/* 원래 2023 Mar 24일 제출용이였으나
 * 너무 피곤해서 그랬는지 제출을 안하고 commit만 함...
 * 그래서 boj에 제츨은 26일에 한것으로 되었음 ㅠㅠ
 */
public class B_10797 {
  // https://www.acmicpc.net/problem/10797
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int count = 0;

    for (int i = 0; i < 5; i++) {
      if (n == Integer.parseInt(st.nextToken())) {
        count++;
      }
    }

    System.out.print(count);
  }
}
