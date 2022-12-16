package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S_24479 {
  // https://www.acmicpc.net/problem/24479

  //  인접 행렬로 구했더니 메모리 초과남 왠지 dfs for 반복문 때문인듯한데..
  static HashMap<Integer, ArrayList<Integer>> graph;
  static int[] visited;
  static int visitIndex = 1;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // node 개수
    int m = Integer.parseInt(st.nextToken()); // 간선 개수
    int r = Integer.parseInt(st.nextToken()); // 시작 node

    graph = new HashMap<>(n);
    visited = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int node = Integer.parseInt(st.nextToken());
      int connectNode = Integer.parseInt(st.nextToken());

      ArrayList<Integer> nodeGraph = graph.getOrDefault(node, new ArrayList<>());
      ArrayList<Integer> connectNodeGraph = graph.getOrDefault(connectNode, new ArrayList<>());

      nodeGraph.add(connectNode);
      connectNodeGraph.add(node);

      graph.put(node, nodeGraph);
      graph.put(connectNode, connectNodeGraph);
    }

    visited[r] = visitIndex++;

    dfs(r);

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < n + 1; i++) {
      sb.append(visited[i]).append("\n");
    }

    System.out.print(sb);
  }

  static void dfs(int node) {
    if (graph.containsKey(node)) {
      Collections.sort(graph.get(node));

      for (int connect : graph.get(node)) {
        if (visited[connect] == 0) {
          visited[connect] = visitIndex++;

          dfs(connect);
        }
      }
    }
  }
}
