package com.codingTest.baekjoon.silver.graph;

//깊이 우선 탐색
public class Dfs {
  public void test() {
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
//    array 대신 2차원 arraylist 사용 가능
//    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    boolean[] visited = new boolean[9];

    dfs(graph, 1, visited);
  }

  /**
   * 깊이 우선 탐색
   *
   * @param graph   node 연결된 상태
   * @param v       현재 node 번호
   * @param visited 방문 여부
   */
  void dfs(int[][] graph, int v, boolean[] visited) {
    visited[v] = true;
    System.out.println(v + "번 node 방문 완료");

    for (int currentNode : graph[v]) {
      if (!visited[currentNode]) { // 방문한 적이 없는 node라면
        dfs(graph, currentNode, visited);
      }
    }
  }
}
