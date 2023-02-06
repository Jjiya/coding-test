package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.StringTokenizer;

public class B_23841 {
  // https://www.acmicpc.net/problem/23841
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    char[][] drawing = new char[n][m];

    for (int i = 0; i < n; i++) {
      drawing[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m / 2; j++) {
        int symmetryIdx = m - j - 1;

        if (drawing[i][j] != '.') {
          drawing[i][symmetryIdx] = drawing[i][j];
        } else if (drawing[i][symmetryIdx] != '.') {
          drawing[i][j] = drawing[i][symmetryIdx];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char[] line : drawing) {
      sb.append(line).append("\n");
    }

    System.out.print(sb);
  }
}
