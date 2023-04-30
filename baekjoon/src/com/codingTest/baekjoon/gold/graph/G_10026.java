package com.codingTest.baekjoon.gold.graph;

import java.io.*;

public class G_10026 {
  // https://www.acmicpc.net/problem/10026

  static char[][] graph;
  static boolean[][][] visited;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    graph = new char[n][n];
    visited = new boolean[2][n][n];

    for (int i = 0; i < n; i++) {
      graph[i] = br.readLine().toCharArray();
    }

    int[] count = new int[2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < visited.length; k++) {
          if (!visited[k][i][j]) {
            count[k]++;
            visited[k][i][j] = true;

            dfs(k, i, j);
          }
        }
      }
    }

    System.out.print(count[0] + " " + count[1]);
  }

  static void dfs(int visitedIndex, int row, int column) {
    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = column + columnDirection[i];

      if (!(0 <= nextRow && nextRow < graph.length) || !(0 <= nextColumn && nextColumn < graph[0].length)) {
        continue;
      }

      if (visited[visitedIndex][nextRow][nextColumn]) {
        continue;
      }

      if (graph[row][column] == graph[nextRow][nextColumn]) {
        visited[visitedIndex][nextRow][nextColumn] = true;
        dfs(visitedIndex, nextRow, nextColumn);
      } else if (visitedIndex == 1 && (((graph[row][column] == 'R') && (graph[nextRow][nextColumn] == 'G')) || ((graph[row][column] == 'G') && (graph[nextRow][nextColumn] == 'R')))) {
        visited[visitedIndex][nextRow][nextColumn] = true;
        dfs(visitedIndex, nextRow, nextColumn);
      }
    }
  }
}
