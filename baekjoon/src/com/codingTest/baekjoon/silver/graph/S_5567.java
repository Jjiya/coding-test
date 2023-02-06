package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_5567 {
  // https://www.acmicpc.net/problem/5567
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    static int[][] graph;
    static boolean[] invited;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());

      graph = new int[n + 1][n + 1];
      invited = new boolean[n + 1];

      StringTokenizer st;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph[a][b] = graph[b][a] = 1;
      }

      Queue<Integer> queue = new LinkedList<>();

      queue.add(1);

      int inviteCount = 0;

      while (!queue.isEmpty()) {
        Integer current = queue.poll();

        for (int i = 2; i < n + 1; i++) {
          if (!invited[i] && graph[current][i] == 1) {
            invited[i] = true;
            inviteCount++;

            if (current == 1) {
              queue.offer(i);
            }
          }
        }
      }

      System.out.println(inviteCount);
    }
  }

  static class M1 {
    static int[][] graph;
    static boolean[] invited;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());

      graph = new int[n + 1][n + 1];
      invited = new boolean[n + 1];

      StringTokenizer st;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph[a][b] = graph[b][a] = 1;
      }

      System.out.println(counting(1));
    }

    static int counting(int idx) {
      int count = 0;
// 1의 친구들부터 먼저 체크하고 함수를 후 출해야 친구의 친구까지 초대할 수 있음...
      for (int i = 2; i < graph.length; i++) {
        if (!invited[i] && graph[idx][i] == 1) {
          invited[i] = true;
          count++;

          if (idx == 1) {
            count += counting(i);
          }
        }
      }
      return count;
    }
  }

  /*
3
2
2 1
3 2
=> 2

10
10
4 10
7 10
3 7
6 8
1 7
1 6
1 5
1 9
2 4
3 8
=> 7
   */
}
