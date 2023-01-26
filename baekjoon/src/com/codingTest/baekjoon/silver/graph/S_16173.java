package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_16173 {
  // https://www.acmicpc.net/problem/16173
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

    int[][] direction = {{1, 0}, {0, 1}};

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();
      int movingCount = current.getMovingCount();

      for (int i = 0; i < 2; i++) {
//        하드코딩 안하고 곱하기를 이용하면 반복문으로 대체 가능하네...
//        대신 메모리는 20KB 더 사용되긴 함
        Coordinate next = new Coordinate(current.row + (direction[i][0] * movingCount), current.col + (direction[i][1] * movingCount));

        if (next.isValid()) {
          if (next.isGoal()) {
            System.out.print("HaruHaru");
            return;
          }
          next.visit();
          queue.add(next);
        }
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
      return 0 <= row && row < graph.length && 0 <= col && col < graph.length && !isVisited();
    }

    boolean isVisited() {
      return visited[row][col];
    }

    void visit() {
      visited[row][col] = true;
    }

    boolean isGoal() {
      return graph[row][col] == -1;
    }

    int getMovingCount() {
      return graph[row][col];
    }
  }
}
