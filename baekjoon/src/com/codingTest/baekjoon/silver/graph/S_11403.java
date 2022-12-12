package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_11403 {
  // https://www.acmicpc.net/problem/11403
  static int[][] map;
  static boolean[] isVisited;
  static int[][] connectStatusMap;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    connectStatusMap = new int[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (connectStatusMap[i][j] == 0) {
          isVisited = new boolean[n];
          bfs(i, j);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int[] row : connectStatusMap) {
      for (int connect : row) {
        sb.append(connect).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static void bfs(int start, int target) {
    Queue<Integer> queue = new LinkedList<>();

    queue.offer(start);

    while (!queue.isEmpty()) {
      int current = queue.poll();

      for (int i = 0; i < map.length; i++) {
        if (map[current][i] == 1 && !isVisited[i]) {
          if (i == target) {
            connectStatusMap[start][target] = 1;
            return;
          }

          queue.offer(i);
          isVisited[i] = true;
        }
      }
    }
  }
}
