package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO 다시 풀어볼 것
public class G_2573 {
  // https://www.acmicpc.net/problem/2573
  static int[][] graph;
  static boolean[][] visited;
  static int[][] melt;
  static Queue<Coordinate> queue;
  static int n;
  static int m;
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  static int unMeltCount = 0;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    melt = new int[n][m];

    queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());

        if (graph[i][j] != 0) {
          unMeltCount++;
          queue.add(new Coordinate(i, j, 0));
        }
      }
    }

    int year = 0;

    while (!queue.isEmpty()) {
      Coordinate current = queue.peek();

      if (year < current.years) { // 1년 경과 시
        melt();
        year++;

        if (queue.isEmpty()) {
          System.out.println(0);
          return;
        }

        current = queue.poll();

        visited = new boolean[n][m];
        visited[current.row][current.column] = true;

        int iceberg = icebergCount(current.row, current.column);

        if (iceberg == 1 && unMeltCount == 1) {
          System.out.println(0);
          return;
        } else if (iceberg != unMeltCount) {
          break;
        }
      } else {
        current = queue.poll();
      }

      melt[current.row][current.column] = getSeaCount(current.row, current.column);

      current.years += 1;

      queue.add(current);
    }

    System.out.println(year);
  }

  static void melt() {
    Queue<Coordinate> subQueue = new LinkedList<>();

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();
      int row = current.row;
      int column = current.column;

      graph[row][column] -= melt[row][column];

      melt[row][column] = 0;

      if (graph[row][column] <= 0) {
        unMeltCount--;
      } else {
        subQueue.add(current);
      }
    }

    queue = subQueue;
  }

  static class Coordinate {
    int row;
    int column;
    int years;

    public Coordinate(int row, int column, int years) {
      this.row = row;
      this.column = column;
      this.years = years;
    }
  }

  static int icebergCount(int row, int col) {
    int count = 1;

    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = col + columnDirection[i];

      if (isValidCoordinate(nextRow, nextColumn) && !isVisited(nextRow, nextColumn) && !isSeaCoordinate(nextRow, nextColumn)) {
        visited[nextRow][nextColumn] = true;

        count += icebergCount(nextRow, nextColumn);
      }
    }

    return count;
  }

  static int getSeaCount(int row, int col) {
    int count = 0;

    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = col + columnDirection[i];

      if (isValidCoordinate(nextRow, nextColumn) && isSeaCoordinate(nextRow, nextColumn)) {
        count++;
      }
    }

    return count;
  }

  static boolean isValidCoordinate(int row, int col) {
    return (0 <= row && row < graph.length) && (0 <= col && col < graph[0].length);
  }

  static boolean isVisited(int row, int col) {
    return visited[row][col];
  }

  static boolean isSeaCoordinate(int row, int col) {
    return graph[row][col] <= 0;
  }
}

/*
5 5
0 0 0 0 0
0 2 2 2 0
0 2 2 2 0
0 2 2 2 0
0 0 0 0 0
=> 0

5 5
0 0 0 0 0
0 0 10 10 0
0 10 0 10 0
0 0 10 10 0
0 0 0 0 0
=> 0

5 5
0 0 0 0 0
0 0 9 0 0
0 0 3 1 0
0 0 9 0 0
0 0 0 0 0
=> 2
 */