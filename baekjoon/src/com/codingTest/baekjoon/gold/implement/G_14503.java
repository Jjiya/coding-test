package com.codingTest.baekjoon.gold.implement;

import java.io.*;
import java.util.StringTokenizer;

public class G_14503 {
  // https://www.acmicpc.net/problem/14503
  static int[][] graph;
  static int[][] directionMoveValue = { // 현재 방향 기준 한칸 이동 시 변하는 위치 값
//      북쪽     동쪽     남쪽     서쪽
      {-1, 0}, {0, 1}, {1, 0}, {0, -1}
  };
  static int cleanCount = 0;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 세로
    int m = Integer.parseInt(st.nextToken()); // 가로

    st = new StringTokenizer(br.readLine());

    int r = Integer.parseInt(st.nextToken()); // 청소기 세로 방향
    int c = Integer.parseInt(st.nextToken()); // 청소기 가로 방향
    int d = Integer.parseInt(st.nextToken()); // 청소기가 바라보고 있는 방향

    graph = new int[n][m];


    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    cleanUp(new Coordinate(r, c, d));

    System.out.println(cleanCount);
  }

  static void cleanUp(Coordinate current) {
    if (current.canCleanUp()) {
      current.cleanUp();
    }

    Coordinate next;

    int remainingRotatableCount = 4;  // 방향 회전 남은 수

    while (remainingRotatableCount-- > 0) {
      next = current.getLeftCoordinate();

      if (next.canCleanUp()) {
        current.turnLeft();
        current.goForward();

        cleanUp(current);

        return;
      } else {
        current.turnLeft();
      }

      if (remainingRotatableCount == 0) {
        current.goBackWard();

        if (current.canMove()) {
          remainingRotatableCount = 4;
        }
      }
    }
  }

  static class Coordinate {
    int row;
    int col;
    int direction;

    public Coordinate(int row, int col, int direction) {
      this.row = row;
      this.col = col;
      this.direction = direction;
    }

    public void turnLeft() {
      this.direction = turnLeftDirection();
    }

    public int turnLeftDirection() {
//      다른 분 코드 보니 이렇게도 계산 됨... 이걸 못찾았었음! direction = (direction + 3) % 4;
      return direction == 0 ? 3 : direction - 1;
    }

    public Coordinate getLeftCoordinate() {
      int nextLeftDirection = turnLeftDirection();

      return new Coordinate(row + directionMoveValue[nextLeftDirection][0], col + directionMoveValue[nextLeftDirection][1], nextLeftDirection);
    }

    public boolean canCleanUp() {
      return isValidCoordinate() && graph[row][col] == 0;
    }

    public boolean canMove() {
      return isValidCoordinate() && graph[row][col] != 1;
    }

    public boolean isValidCoordinate() {
      return (0 <= row && row < graph.length) && (0 <= col && col < graph[0].length);
    }

    public void goForward() {
      row += directionMoveValue[direction][0];
      col += directionMoveValue[direction][1];
    }

    public void goBackWard() {
      row -= directionMoveValue[direction][0];
      col -= directionMoveValue[direction][1];
    }

    public void cleanUp() {
      graph[row][col] = 2;
      cleanCount++;
    }
  }
}