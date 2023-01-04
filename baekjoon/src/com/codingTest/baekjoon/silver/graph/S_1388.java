package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_1388 {
  // https://www.acmicpc.net/problem/1388
  static char[][] graph;
  static boolean[][] visited;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new char[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      graph[i] = br.readLine().toCharArray();
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;
          countingWoodenBoard(i, j, graph[i][j]);
          count++;
        }
      }
    }

    System.out.print(count);
  }

  static void countingWoodenBoard(int row, int column, char woodenBoard) {
    switch (woodenBoard) {
      case '-':
        if (isSameWoodenBoard(row, column + 1, woodenBoard)) {
          visited[row][column + 1] = true;
          countingWoodenBoard(row, column + 1, woodenBoard);
        }
        break;

      case '|':
        if (isSameWoodenBoard(row + 1, column, woodenBoard)) {
          visited[row + 1][column] = true;
          countingWoodenBoard(row + 1, column, woodenBoard);
        }
        break;
    }
  }

  static boolean isSameWoodenBoard(int row, int column, char woodenBoard) {
    return isValidCoordinate(row, column) && graph[row][column] == woodenBoard && !isVisited(row, column);
  }

  static boolean isVisited(int row, int column) {
    return visited[row][column];
  }

  static boolean isValidCoordinate(int row, int column) {
    return (0 <= row && row < graph.length) && (0 <= column && column < graph[0].length);
  }
}
