package com.codingTest.baekjoon.silver.graph;

import java.util.LinkedList;
import java.util.Queue;

//너비 우선 탐색
public class Bfs {
  int[][] graph = {
      {}, // 0은 node 연결 정보를 편히 구현하기 위해 비워둔다. 1~8번 node만 있다고 가정
      {2, 3, 8},
      {1, 7},
      {1, 4, 5},
      {3, 5},
      {3, 4},
      {7},
      {2, 6, 8},
      {1, 7}
  };
  boolean[] visited = new boolean[9];

  public void test() {
    bfs(1);
  }

  /**
   * 너비 우선 탐색
   *
   * @param v 현재 node 번호
   */
  void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int currentNode = queue.poll();
      System.out.println(currentNode + "번 노드 방문 완료");
      for (int node : graph[currentNode]) { // 현재 node와 연결되었으나 아직 방문하지 않은 node들을 queue에 넣고 방문 처리함
        if (!visited[node]) {
          queue.offer(node);
          visited[node] = true;
        }
      }
    }
  }
}
