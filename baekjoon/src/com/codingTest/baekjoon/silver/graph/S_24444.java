package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.*;

public class S_24444 {
  // https://www.acmicpc.net/problem/24444
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    int[] visited = new int[n + 1];
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n + 2);

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int node = Integer.parseInt(st.nextToken());
      int connect = Integer.parseInt(st.nextToken());

      graph.get(node).add(connect);
      graph.get(connect).add(node);
    }

    for (int i = 1; i <= n; i++) {
      Collections.sort(graph.get(i));
    }


    Queue<Integer> queue = new LinkedList<>();
    queue.offer(r);

    int visitIndex = 1;
    visited[r] = visitIndex++;

    while (!queue.isEmpty()) {
      int current = queue.poll();

      for (int connect : graph.get(current)) {
        if (visited[connect] == 0) {
          queue.offer(connect);
          visited[connect] = visitIndex++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < visited.length; i++) {
      sb.append(visited[i]).append("\n");
    }

    System.out.print(sb);
  }
}
