package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.*;

public class S_18352 {
  // https://www.acmicpc.net/problem/18352
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 도시 개수
    int m = Integer.parseInt(st.nextToken()); // 도로 개수
    int k = Integer.parseInt(st.nextToken()); // 최단 거리 목적 값
    int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호

    boolean[] visited = new boolean[n + 1];
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      graph.get(Integer.parseInt(st.nextToken()))
          .add(Integer.parseInt(st.nextToken()));
    }

    Queue<City> queue = new LinkedList<>();

    queue.add(new City(x, 0));
    visited[x] = true;  // 처음 방문한 노드 방문처리하는 것 잊지 말기!!!!

    PriorityQueue<Integer> kList = new PriorityQueue<>();
    while (!queue.isEmpty()) {
      City current = queue.poll();

      if (k < current.distance) {
        break;
      }

      if (k == current.distance) {
        kList.add(current.number);
      }

      if (graph.get(current.number).size() == 0) {
        continue;
      }

      for (int connect : graph.get(current.number)) {
        if (!visited[connect]) {
          visited[connect] = true;
          queue.add(new City(connect, current.distance + 1));
        }
      }
    }

    if (kList.isEmpty()) {  // 예외처리 까먹어서 한번 틀림
      System.out.print(-1);
      return;
    }

    StringBuilder sb = new StringBuilder();

    while (!kList.isEmpty()) {
      sb.append(kList.poll()).append("\n");
    }

    System.out.print(sb);
  }

  static class City {
    int number;
    int distance;

    public City(int number, int distance) {
      this.number = number;
      this.distance = distance;
    }
  }
}
/* 반례
https://www.acmicpc.net/board/view/110122

3 2 1 2
1 2
1 3

# Answer
-1

////////////////////////////

7 6 2 1
1 2
1 3
2 4
2 5
3 6
3 7

# Answer
4
5
6
7

아래 예제보고 visited[x] = true; 추가...
2 2 2 1
1 2
2 1

# Answer
-1
 */
