package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_2210 {
  // https://www.acmicpc.net/problem/2210
  static String[][] graph;
  static HashSet<String> result;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    graph = new String[5][5];
    result = new HashSet<>();
    StringTokenizer st;

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        graph[i][j] = st.nextToken();
      }
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        bt(i, j, 0, new StringBuilder());
      }
    }

    System.out.print(result.size());
  }

  static void bt(int row, int col, int count, StringBuilder rs) {
    if (count == 6) {
      result.add(rs.toString());
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nextRow = row + rowDirection[i];
      int nextCol = col + columnDirection[i];

      if (!(0 <= nextRow && nextRow < 5) || !(0 <= nextCol && nextCol < 5)) {
        continue;
      }

      rs.append(graph[nextRow][nextCol]);
      bt(nextRow, nextCol, count + 1, rs);
      rs.deleteCharAt(count);
    }
  }
}
