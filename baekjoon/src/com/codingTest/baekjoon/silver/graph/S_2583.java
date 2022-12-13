package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S_2583 {
  // https://www.acmicpc.net/problem/2583
  static int[][] graphPaper;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken()); // 세로 길이
    int n = Integer.parseInt(st.nextToken()); // 가로 길이
    int k = Integer.parseInt(st.nextToken()); // 직사각형 개수

    graphPaper = new int[m][n];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

//      직사각형 모눈종이에 표시
      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          graphPaper[y][x] = 1;
        }
      }
    }

    int count = 0;
    ArrayList<Integer> emptyArea = new ArrayList<>();

    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (graphPaper[y][x] == 0) {
          int result = dfs(x, y);

          if (result != 0) {
            count++;
            emptyArea.add(result);
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    Collections.sort(emptyArea); // stream 보다 속도가 훨씬 빠르네? 228ms -> 84ms : 속도 약 60% 감소

    for (int area : emptyArea) {
      sb.append(area).append(" ");
    }

    System.out.println(count);
    System.out.print(sb);
  }

  static int dfs(int x, int y) {
    if ((0 <= x && x < graphPaper[0].length) && (0 <= y && y < graphPaper.length) && graphPaper[y][x] == 0) {
      graphPaper[y][x] = -1;

      return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
    }

    return 0;
  }
}
