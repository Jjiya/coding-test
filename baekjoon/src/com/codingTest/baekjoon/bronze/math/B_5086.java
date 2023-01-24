package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_5086 {
  // https://www.acmicpc.net/problem/5086
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0) { // a == b로 변경 가능. 조건에 두 수가 같은 경우가 없다고 되어있음
        break;
      }

      if (b % a == 0) {
        sb.append("factor\n");
      } else if (a % b == 0) {
        sb.append("multiple\n");
      } else {
        sb.append("neither\n");
      }
    }

    System.out.print(sb);
  }
}
