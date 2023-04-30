package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.StringTokenizer;

public class G_1987 {
  // https://www.acmicpc.net/problem/1987
  static char[][] graph;
  static boolean[][] visited;
  static int max = 0;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    graph = new char[r][c];
    visited = new boolean[r][c];


    for (int i = 0; i < r; i++) {
      graph[i] = br.readLine().toCharArray();
    }

    visited[0][0] = true;
    bt(0, 0, String.valueOf(graph[0][0]));

    System.out.print(max);
  }

  static void bt(int row, int column, String visit) {
    max = Math.max(max, visit.length());

    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextColumn = column + columnDirection[i];

      if (!(0 <= nextRow && nextRow < graph.length) || !(0 <= nextColumn && nextColumn < graph[0].length)) {
        continue;
      }

      if (!visited[nextRow][nextColumn] && (visit.indexOf(graph[nextRow][nextColumn]) == -1)) {
        visited[nextRow][nextColumn] = true;
        bt(nextRow, nextColumn, visit + graph[nextRow][nextColumn]);
        visited[nextRow][nextColumn] = false;
      }
    }
  }
}
