package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://infodon.tistory.com/96
public class S_1260 {
  static StringBuilder sb = new StringBuilder();
  //  정점,    간선,  시작 지점
  static int vertex, edge, start;
  static int[][] graph;      //그래프
  static boolean[] visited;  //방문 정보

  static Queue<Integer> queue = new LinkedList<>();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    vertex = Integer.parseInt(st.nextToken());
    edge = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    graph = new int[1001][1001];
    visited = new boolean[1001];


    for (int i = 0; i < edge; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph[x][y] = graph[y][x] = 1;
    }

    dfs(start);

    sb.append("\n");
    visited = new boolean[1001];

    bfs(start);


    System.out.print(sb);
  }

  //  너비 우선 탐색법
  static void bfs(int start) {
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      start = queue.poll();
      sb.append(start).append(" ");

      for (int i = 1; i <= vertex; i++) {
//      연결 되어있고, 방문한 적이 없는 정점이라면
        if (graph[start][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }

  //  깊이 우선 탐색법
  static void dfs(int start) {
    visited[start] = true;

    sb.append(start).append(" ");

    for (int i = 0; i <= vertex; i++) {
//      연결 되어있고, 방문한 적이 없는 정점이라면
      if (graph[start][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

}
