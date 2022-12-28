package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_7562 {
  // https://www.acmicpc.net/problem/7562
  static int[][] visited;
  static Coordinate destination;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCase = Integer.parseInt(br.readLine());

    int[][] moving = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    StringBuilder sb = new StringBuilder();

    while (testCase-- > 0) {
      int l = Integer.parseInt(br.readLine());
      visited = new int[l][l];

      StringTokenizer st = new StringTokenizer(br.readLine());
      Coordinate start = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

      st = new StringTokenizer(br.readLine());

      destination = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

      Queue<Coordinate> queue = new LinkedList<>();

      start.checkVisit(1);
      queue.offer(start);

      while (!queue.isEmpty()) {
        Coordinate current = queue.poll();

        if (current.isDestination()) {
          sb.append(current.currentCount() - 1).append("\n");
          break;
        }

        for (int[] nextMoving : moving) {
          Coordinate next = new Coordinate(current.row + nextMoving[0], current.col + nextMoving[1]);

          if (next.isValid()) {
            next.checkVisit(current.currentCount() + 1);
            queue.offer(next);
          }
        }
      }
    }

    System.out.print(sb);
  }

  static class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }

    public boolean isValid() {
      return (0 <= row && row < visited.length) && (0 <= col && col < visited[0].length) && unvisited();
    }

    public boolean unvisited() {
      return visited[row][col] == 0;
    }

    public void checkVisit(int count) {
      visited[row][col] = count;
    }

    public int currentCount() {
      return visited[row][col];
    }

    public boolean isDestination() {
      return destination.row == row && destination.col == col;
    }
  }
}
/*
2
4
0 0
0 3
4
0 0
2 1
 */
