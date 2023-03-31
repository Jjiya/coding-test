package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_3448 {
  // https://www.acmicpc.net/problem/3448
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String input;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int tcLength = 0;
      int unrecognizedCount = 0;

      while (!(input = br.readLine()).isEmpty()) {
        tcLength += input.length();

        for (char letter : input.toCharArray()) {
          if (letter == '#') {
            unrecognizedCount++;
          }
        }
      }
      double recognized = 100 - (((double) unrecognizedCount / tcLength) * 100);
      String result = String.format("%.1f", recognized);
//       String result = Math.round(recognized * 10) / 10.0; 으로해도 되는데, 소수점 0이면 버리려고 String형식으로 바꿈

      if (result.contains(".0")) {
        StringTokenizer st = new StringTokenizer(result, ".");
        result = st.nextToken();
      }

      sb.append("Efficiency ratio is ").append(result).append("%.\n");
    }

    System.out.print(sb);
  }
}
