package com.codingTest.baekjoon.contest.wanted_22_third;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 도넛 행성 [성공]
public class B {
  //  https://showmethecode.acmicpc.net/contest/problem/940/2
  static int[][] map;
  static boolean[][] visited;
  static int n;
  static int m;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    visited = new boolean[n][m];

    Queue<Coordinate> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 0) {
          queue.add(new Coordinate(i, j));
        }
      }
    }

    int explorationAreaCount = 0;

    while (!queue.isEmpty()) {
      Coordinate nextExploration = queue.poll();

      if (nextExploration.canMove()) {
        nextExploration.checkVisit();
        exploration(nextExploration);

        explorationAreaCount++;
      }
    }

    System.out.println(explorationAreaCount);
  }

  static void exploration(Coordinate coordinate) {
    Queue<Coordinate> queue = new LinkedList<>();
    queue.add(coordinate);

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();

      for (int i = 0; i < 4; i++) {
        Coordinate next = new Coordinate(current.row + rowDirection[i], current.col + columnDirection[i]);

        if (next.canMove()) {
          next.checkVisit();
          queue.add(next);
        }
      }
    }
  }

  static class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;

      if (this.row < 0) this.row = n - 1;
      if (this.col < 0) this.col = m - 1;

      if (n - 1 < this.row) this.row = this.row % n;
      if (m - 1 < this.col) this.col = this.col % m;
    }

    void checkVisit() {
      visited[this.row][this.col] = true;
    }

    boolean canMove() {
      return !visited[this.row][this.col] && map[this.row][this.col] == 0;
    }
  }
}
