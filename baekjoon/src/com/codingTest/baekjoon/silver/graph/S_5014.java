package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_5014 {
  // https://www.acmicpc.net/problem/5014
  static boolean[] visited;
  static int f;
  static int u;
  static int d;
  static int g;
  static int count = -1;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    f = Integer.parseInt(st.nextToken()); // 최고 층
    int s = Integer.parseInt(st.nextToken()); // 현재 위치
    g = Integer.parseInt(st.nextToken()); // 목적지 위치
    u = Integer.parseInt(st.nextToken()); // 위로 u층
    d = Integer.parseInt(st.nextToken()); // 아래로 d층

    visited = new boolean[f + 1];

    visited[s] = true;
    Queue<Floor> queue = new LinkedList<>();

    queue.add(new Floor(s, 0));

    while (!queue.isEmpty()) {
      Floor current = queue.poll();

      if (current.floor == g) {
        count = current.movingCount;
        break;
      }

      for (int next : new int[]{current.floor + u, current.floor - d}) {
        if (0 < next && next <= f && !visited[next]) {
          visited[next] = true;
          queue.add(new Floor(next, current.movingCount + 1));
        }
      }
    }

    System.out.print(count == -1 ? "use the stairs" : count);
  }

  static class Floor {
    int floor;
    int movingCount;

    public Floor(int floor, int movingCount) {
      this.floor = floor;
      this.movingCount = movingCount;
    }
  }

  //  최단 거리 찾는건데 dfs로 찾으니까 최단 거리를 보장 못함... bfs로 변경함
  static void go(int floor, int moveCount) {
    if (floor == g) {
      count = Math.min(moveCount, count);
      return;
    }

    for (int next : new int[]{floor + u, floor - d}) {
      if (0 < next && next <= f && !visited[next]) {
        visited[next] = true;
        go(next, moveCount + 1);
      }
    }
  }
}
