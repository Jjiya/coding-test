package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.*;

public class S_1389 {
  // https://www.acmicpc.net/problem/1389
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    static int[][] graph; // 관계 저장
    static int[][] depth; // 결과 저장

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      graph = new int[n + 1][n + 1];
      depth = new int[n + 1][n + 1];

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph[a][b] = graph[b][a] = 1;
      }
      
      int minValue = 101;
      int minNumber = -1;

      for (int i = 1; i <= n; i++) {
        int result = 0;

        for (int j = 1; j <= n; j++) {
          if (i == j) {
            continue;
          }

          getRelationDepth(i, j);
          result += depth[i][j];
        }

        if (result < minValue) {
          minNumber = i;
          minValue = result;
        }
      }

      System.out.print(minNumber);
    }

    static void getRelationDepth(int a, int b) {
      if (depth[a][b] != 0) {
        return;
      }

      boolean[] visited = new boolean[graph.length];

//      최단 거리를 구하기 위해 bfs 사용
      Queue<User> queue = new LinkedList<>();

      queue.offer(new User(a, 0));

      while (!queue.isEmpty()) {
        User current = queue.poll();

        for (int i = 1; i < graph.length; i++) {
          if (a == i || graph[current.number][i] != 1 || visited[i]) {
            continue;
          }

          int relationDepth = current.depth + 1;

          visited[i] = true;

          if (i == b) {
            depth[a][b] = depth[b][a] = relationDepth;
            return;
          }

          if (depth[a][i] == 0) {
//            현재 목적인 b가 아니더라도 케빈 베이컨의 수가 도출되었다면 바로 저장하기
            depth[a][i] = depth[i][a] = relationDepth;
          }

          queue.add(new User(i, relationDepth));
        }
      }
    }

    static class User {
      int number;
      int depth;

      public User(int number, int depth) {
        this.number = number;
        this.depth = depth;
      }
    }
  }

  static class M1 {
    //  플로이드 와샬 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=ndb796&logNo=221234427842
    static HashMap<Integer, HashSet<Integer>> graph;
    static int[] relationScore;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      graph = new HashMap<>(n);
      relationScore = new int[n + 1];

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashSet<Integer> aList = graph.getOrDefault(a, new HashSet<>());
        aList.add(b);

        HashSet<Integer> bList = graph.getOrDefault(b, new HashSet<>());
        bList.add(a);

        graph.put(a, aList);
        graph.put(b, bList);
      }

      int minRelationShipSum = 5002;
      int minRelationShipNumber = -1;

      for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
          getRelationDepth(i, j);
        }

        if (relationScore[i] < minRelationShipSum) {
          minRelationShipSum = relationScore[i];
          minRelationShipNumber = i;
        }
      }

      System.out.print(minRelationShipNumber);
    }

    static void getRelationDepth(int number, int findNumber) {
      boolean[] visited = new boolean[relationScore.length + 1];
      Queue<User> queue = new LinkedList<>();

      visited[number] = true;
      queue.offer(new User(number, 0));

      while (!queue.isEmpty()) {
        User current = queue.poll();

        if (!graph.containsKey(current.number)) {
          continue;
        }

        for (int friend : graph.get(current.number)) {
          if (friend == findNumber) {
            relationScore[number] += current.depth + 1;
            relationScore[findNumber] += current.depth + 1;

            return;
          }

          if (!visited[friend]) {
            visited[friend] = true;

            queue.add(new User(friend, current.depth + 1));
          }
        }
      }
    }

    static class User {
      int number;
      int depth;

      public User(int number, int depth) {
        this.number = number;
        this.depth = depth;
      }
    }
  }
}

/*
5 6
1 3
1 3
1 4
4 5
4 3
3 2
ans -> 3  (틀리지 않음..)

5 5
1 2
2 3
3 4
4 5
5 3
=> 3
 */