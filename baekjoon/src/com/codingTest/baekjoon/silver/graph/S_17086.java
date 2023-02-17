package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_17086 {
  // https://www.acmicpc.net/problem/17086
  static int[][] graph;
  //  동 동남 남 남서 서 서북 북 북동 순서 탐색
  static int[] rowDirection = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] columnDirection = {1, 1, 0, -1, -1, -1, 0, 1};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int max = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j] == 1) {
          continue;
        }

        max = Math.max(max, getSafetyArea(i, j));
      }
    }

    System.out.print(max);
  }

  static int getSafetyArea(int row, int column) {
    boolean[][] visited = new boolean[graph.length][graph[0].length];

    Coordinate start = new Coordinate(row, column);
    visited[row][column] = true;

    Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();

      int currentRow = current.row;
      int currentColumn = current.column;
      int currentDistance = current.distance;

      for (int i = 0; i < rowDirection.length; i++) {
        int nextRow = currentRow + rowDirection[i];
        int nextColumn = currentColumn + columnDirection[i];

        Coordinate next = new Coordinate(nextRow, nextColumn, currentDistance + 1);

        if (!next.isValid(visited)) {
          continue;
        }

        if (next.isShark()) {
          return next.distance;
        }

        visited[nextRow][nextColumn] = true;
        queue.offer(next);
      }
    }

    return -1;
  }

  static class Coordinate {
    int row;
    int column;
    int distance;

    public Coordinate(int row, int column) {
      this.row = row;
      this.column = column;
      this.distance = 0;
    }

    public Coordinate(int row, int column, int distance) {
      this.row = row;
      this.column = column;
      this.distance = distance;
    }

    boolean isValid(boolean[][] visited) {
      return isValidCoordinate() && !isVisited(visited);
    }

    boolean isVisited(boolean[][] visited) {
      return visited[row][column];
    }

    boolean isValidCoordinate() {
      return (0 <= row && row < graph.length) && (0 <= column && column < graph[0].length);
    }

    boolean isShark() {
      return graph[row][column] == 1;
    }
  }
}
