package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.StringTokenizer;

public class S_2563 {
  // https://www.acmicpc.net/problem/2563
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int colorPaperCount = Integer.parseInt(br.readLine());

    int[][] paper = new int[100][100];

    StringTokenizer st;
    for (int i = 0; i < colorPaperCount; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int j = y; j < y + 10; j++) {
        for (int k = x; k < x + 10; k++) {
          paper[j][k] = 1;
        }
      }
    }

    int area = 0;
    for (int[] line : paper) {
      for (int point : line) {
        if (point == 1) area++;
      }
    }

    System.out.print(area);
  }
}
