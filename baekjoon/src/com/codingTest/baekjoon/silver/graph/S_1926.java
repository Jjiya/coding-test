package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_1926 {
  // https://www.acmicpc.net/problem/1926
  static int[][] paper;
  static boolean[][] isVisited;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    paper = new int[n][m];
    isVisited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (paper[i][j] == 0 || isVisited[i][j]) {
          continue;
        }

        count++;
        isVisited[i][j] = true; // 얘 누락했었음
        maxArea = Math.max(maxArea, dfs(i, j));
      }
    }

    System.out.println(count);
    System.out.print(maxArea);
  }

  static int dfs(int row, int column) {
    int area = 1;

    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = column + columnDirection[i];

      if (!(0 <= nextRow && nextRow < paper.length) || !(0 <= nextColumn && nextColumn < paper[0].length)) {
        continue;
      }

      if (paper[nextRow][nextColumn] == 0 || isVisited[nextRow][nextColumn]) {
        continue;
      }

      isVisited[nextRow][nextColumn] = true;
      area += dfs(nextRow, nextColumn);
    }

    return area;
  }
}
