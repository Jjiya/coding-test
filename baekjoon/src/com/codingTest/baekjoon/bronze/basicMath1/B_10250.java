package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10250 {
  /** 풀이를 찾아봐야할 듯... 수학적 접근이 필요함 흑흑 **/
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int t = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      short h = Short.parseShort(st.nextToken());
      short w = Short.parseShort(st.nextToken());
      short n = Short.parseShort(st.nextToken());

      int count = 1;
      while (h < n && count <= w) {
        n -= h;
        count++;
      }
      sb.append(String.format("%d%02d\n", n, count));
    }

    System.out.print(sb);

  }
}
