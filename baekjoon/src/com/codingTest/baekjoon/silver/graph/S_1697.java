package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1697 {
  static int[] visited = new int[100_002];
  static int k;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치 
    k = Integer.parseInt(st.nextToken()); // 동생의 위치

    bfs(n);

    System.out.print(visited[k]);
  }

  static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();

    queue.offer(node);

    while (!queue.isEmpty()) {
      int current = queue.poll();

      /*
      처음에 아래 if문을 next를 설정한 다음에 k와 비교하였음
      그렇게 하면 처음부터 같은 위치에 있을 때 next가 실행되고 비교하게 되므로
      0초가 아닌 2초가 나옴 (-1 -> +1) 잡음
       */
      if (current == k) {
        return;
      }

      int next;
      for (int i = 0; i < 3; i++) {
        switch (i) {
          case 0:
            next = current + 1;
            break;
          case 1:
            next = current - 1;
            break;
          default:
            next = current * 2;
        }

        if (canMove(next)) {
          visited[next] = visited[current] + 1;
          queue.offer(next);
        }
      }
    }
  }

  static boolean canMove(int next) {
    return (-1 < next && next < 100_002) && visited[next] == 0;
  }
}
