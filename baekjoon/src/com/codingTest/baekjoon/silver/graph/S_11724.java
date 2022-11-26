package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_11724 {
  static int[][] graph;
  static boolean[] isVisited;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n + 1][n + 1];
    isVisited = new boolean[n + 1];
    int count = 0;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u][v] = graph[v][u] = 1;
    }

    for (int i = 1; i <= n; i++) {
      if (!isVisited[i]) {
        dfs(i);
        count++;
      }
    }

    System.out.print(count);
  }

  static void dfs(int idx) {
    for (int i = 1; i < graph[idx].length; i++) {
      if (graph[idx][i] == 1 && !isVisited[i]) {
        isVisited[i] = true;
        dfs(i);
      }
    }
  }
}
