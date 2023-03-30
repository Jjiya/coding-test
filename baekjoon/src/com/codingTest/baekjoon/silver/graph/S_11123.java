package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_11123 {
  // https://www.acmicpc.net/problem/11123
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  static char[][] grid;
  static boolean[][] isVisit;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());

      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      grid = new char[h][w];
      isVisit = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        grid[i] = br.readLine().toCharArray();
      }

      int count = 0;

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (grid[i][j] == '.') {
            continue;
          }

          Coordinate current = new Coordinate(i, j);

          if (current.isValid()) {
            current.visit();
            dfs(current);
            count++;
          }
        }
      }

      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }

  static void dfs(Coordinate current) {
    for (int i = 0; i < 4; i++) {
      Coordinate next = new Coordinate(current.row + rowDirection[i], current.column + columnDirection[i]);

      if (next.isValid()) {
        next.visit();
        dfs(next);
      }
    }
  }

  static class Coordinate {
    int row;
    int column;

    public Coordinate(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public boolean isValid() {
      return isValidCoordinate() && !isVisited() && isSheep();
    }

    boolean isVisited() {
      return isVisit[row][column];
    }

    boolean isValidCoordinate() {
      return (0 <= row && row < grid.length) && (0 <= column && column < grid[0].length);
    }

    boolean isSheep() {
      return grid[row][column] == '#';
    }

    void visit() {
      isVisit[row][column] = true;
    }
  }
}
