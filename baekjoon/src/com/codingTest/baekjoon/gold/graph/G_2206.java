package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO 다시 풀어보기!
public class G_2206 {
  // https://www.acmicpc.net/problem/2206
  // 참고: https://kscodebase.tistory.com/66
  static int[][] graph;
  static int[][][] visited;
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};
  static int n;
  static int m;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    visited = new int[2][n][m];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = Character.getNumericValue(line.charAt(j));
      }
    }

    visited[0][0][0] = 1;
    visited[1][0][0] = 1;

    System.out.print(bfs());
  }

  static int bfs() {
    Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(new Coordinate(0, 0));

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();
      int currentRow = current.row;
      int currentCol = current.col;
      int currentBreakWall = current.breakWall;

      if (currentRow == n - 1 && currentCol == m - 1) {
        return visited[currentBreakWall][currentRow][currentCol];
      }

      for (int i = 0; i < 4; i++) {
        Coordinate next = new Coordinate(currentRow + rowDirection[i], currentCol + columnDirection[i], currentBreakWall);

        if (next.isValidCoordinate()) {
          int nextRow = next.row;
          int nextCol = next.col;


          if (next.isCanGo()) { // 벽이 아니면 탐색 진행
            queue.offer(next);
            visited[next.breakWall][nextRow][nextCol] = visited[currentBreakWall][currentRow][currentCol] + 1;
          } else if (currentBreakWall == 0) {
            next.breakWall = 1;
            visited[next.breakWall][nextRow][nextCol] = visited[currentBreakWall][currentRow][currentCol] + 1;

            queue.offer(next);
          }
        }
      }
    }

    return -1;
  }

  static class Coordinate {
    int row;
    int col;
    int breakWall;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
      this.breakWall = 0;
    }

    public Coordinate(int row, int col, int breakWall) {
      this.row = row;
      this.col = col;
      this.breakWall = breakWall;
    }

    public boolean isValidCoordinate() {
      return (0 <= row && row < n) && (0 <= col && col < m) && visited[breakWall][row][col] == 0;
    }

    public boolean isCanGo() {
      return graph[row][col] == 0;
    }
  }

}