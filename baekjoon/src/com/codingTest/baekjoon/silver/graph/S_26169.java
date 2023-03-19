package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_26169 {
  // https://www.acmicpc.net/problem/26169
  static int[][] graph = new int[5][5];
  static boolean[][] isVisited = new boolean[5][5];
  static boolean canEat2Apples = false;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());

    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    isVisited[r][c] = true;

    dfs(r, c, 0, graph[r][c] == 1 ? 1 : 0);

    System.out.print(canEat2Apples ? 1 : 0);
  }

  static void dfs(int row, int column, int movingCount, int eatCount) {
    if (canEat2Apples) {
      return;
    } else if (2 <= eatCount) {
      canEat2Apples = true;
    }

    if (movingCount == 3) {
      return;
    }

    for (int i = 0; i < rowDirection.length; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = column + columnDirection[i];

      if (nextRow < 0 || 5 <= nextRow || nextColumn < 0 || 5 <= nextColumn) {
        continue;
      }

      if (graph[nextRow][nextColumn] != -1 && !isVisited[nextRow][nextColumn]) {
        isVisited[nextRow][nextColumn] = true;
        dfs(nextRow, nextColumn, movingCount + 1, graph[nextRow][nextColumn] == 1 ? eatCount + 1 : eatCount);
        isVisited[nextRow][nextColumn] = false; // 방문 초기화를 해주지않아서 백트래킹을 못하게 되어 틀렸었음!
      }
    }
  }
}
