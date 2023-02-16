package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_16174 {
  // https://www.acmicpc.net/problem/16174
  static int[][] graph;
  static boolean[][] visited;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    graph = new int[n][n];
    visited = new boolean[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Queue<Coordinate> queue = new LinkedList<>();

    Coordinate start = new Coordinate(0, 0);
    start.visit();

    queue.add(start);

    int[][] direction = {{0, 1}, {1, 0}};

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();

      int movingCount = graph[current.row][current.col];

      for (int[] moving : direction) {
        int nextRow = current.row + (moving[0] * movingCount);
        int nextCol = current.col + (moving[1] * movingCount);

        Coordinate next = new Coordinate(nextRow, nextCol);

        if (!next.isValid()) {
          continue;
        }

        if (next.isArrived()) {
          System.out.print("HaruHaru");
          return;
        }

        next.visit();
        queue.add(next);
      }
    }

    System.out.print("Hing");
  }

  static class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }

    boolean isValid() {
      return isValidCoordinate() && !isVisited();
    }

    void visit() {
      visited[row][col] = true;
    }

    boolean isVisited() {
      return visited[row][col];
    }

    boolean isValidCoordinate() {
      return (0 <= row && row < graph.length) && (0 <= col && col < graph[0].length);
    }

    boolean isArrived() {
      return graph[row][col] == -1;
    }
  }
}
