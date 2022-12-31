package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.*;

public class S_1325 {
  // https://www.acmicpc.net/problem/1325

  static HashMap<Integer, ArrayList<Integer>> graph;
  static int[] visited;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new HashMap<>(n);
    visited = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      /*
        양방향 관계가 성립될 수 없음!
        a -> b 신뢰 = b 해킹 시 a 해킹 가능
        a -> b 신뢰 != a 해킹 시 b 해킹 가능 (b가 a를 신뢰하지 않는 이상 불가능함)
       */
      ArrayList<Integer> bList = graph.getOrDefault(b, new ArrayList<>());
      bList.add(a);

      graph.put(b, bList);
    }

    int max = 0;
    int[] result = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      result[i] = bfs(i, i);

      max = Math.max(max, result[i]);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      if (result[i] == max) {
        sb.append(i).append(" ");
      }
    }

    System.out.println(sb);
  }

  static int bfs(int start, int visitNumber) {
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = visitNumber;
    queue.offer(start);

    int count = 0;

    while (!queue.isEmpty()) {
      int current = queue.poll();

      if (!graph.containsKey(current)) continue;

      for (int connect : graph.get(current)) {
        if (visited[connect] != visitNumber) {
          visited[connect] = visitNumber;

          queue.offer(connect);
          count++;
        }
      }
    }

    return count;
  }
}
