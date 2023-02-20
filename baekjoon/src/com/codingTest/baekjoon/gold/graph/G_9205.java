package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_9205 {
  // https://www.acmicpc.net/problem/9205
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    //    TODO 다시 해보기... 최적화할 수 있을 것 같은데
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int t = Integer.parseInt(br.readLine());

      StringBuilder sb = new StringBuilder();

      while (t-- > 0) {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] graph = new int[n + 2][2];
        boolean[] visited = new boolean[n + 2];

        graph[0] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

//        편의점 위치 저장
        for (int i = 1; i <= n; i++) {
          st = new StringTokenizer(br.readLine());

          graph[i][0] = Integer.parseInt(st.nextToken());
          graph[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        graph[n + 1] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

//        연결 그래프 만들기
        boolean[][] connect = new boolean[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
          int x1 = graph[i][0];
          int y1 = graph[i][1];
          for (int j = 0; j < n + 2; j++) {
            if (i == j) {
              continue;
            }

            int x2 = graph[j][0];
            int y2 = graph[j][1];

            if (getDistance(x1, x2, y1, y2) <= 1000) {
              connect[i][j] = connect[j][i] = true;
            }
          }
        }

        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(graph[0][0], graph[0][1], 0));
        visited[0] = true;

        queueWhile:
        while (!queue.isEmpty()) {
          Coordinate current = queue.poll();
          int idx = current.graphIdx;

          for (int i = 0; i < n + 2; i++) {
            if (!connect[idx][i] || visited[i]) {
              continue;
            }

            Coordinate next = new Coordinate(graph[i][0], graph[i][1], i);

            if (current.canMove(next)) {
              queue.offer(next);
              visited[i] = true;

              if (i == n + 1) {
                break queueWhile;
              }
            }
          }
        }

        sb.append(visited[n + 1] ? "happy" : "sad").append("\n");
      }

      System.out.print(sb);
    }

    static class Coordinate {
      int row;
      int colum;
      int graphIdx;

      public Coordinate(int row, int colum, int graphIdx) {
        this.row = row;
        this.colum = colum;
        this.graphIdx = graphIdx;
      }

      boolean canMove(Coordinate next) {
        return getDistance(row, next.row, colum, next.colum) <= 1000;
      }
    }

    static int getDistance(int x1, int x2, int y1, int y2) {
      return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
  }

  static class M1 {
    /*
      딱 100단위로 좌표가 주어진다는 보장도 없을뿐더러
      중간 편의점에서 목적지까지 도달할 수도 있지 않으려나...
      
      bfs 사용해보자
      플로이드 와샬 알고리즘도 사용가능하다곤 함
     */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int t = Integer.parseInt(br.readLine());

      StringBuilder sb = new StringBuilder();

      outer:
      while (t-- > 0) {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int[][] graph = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());

          graph[i][0] = Integer.parseInt(st.nextToken());
          graph[i][1] = Integer.parseInt(st.nextToken());
          graph[i][2] = 0;
        }

        st = new StringTokenizer(br.readLine());
        graph[n] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1};

        Arrays.sort(graph, (a, b) -> {
          return a[0] - b[0];
        });

        int currentX = start[0];
        int currentY = start[1];
        int bottle = 20;

        for (int[] coordinate : graph) {
          int x = coordinate[0];
          int y = coordinate[1];
          boolean isArrive = coordinate[2] == 1;

          int distance = Math.abs(x - currentX) + Math.abs(y - currentY);
          if (distance <= (bottle * 50)) {
            if (isArrive) {
              sb.append("happy").append("\n");
              continue outer;
            }

            currentX = x;
            currentY = y;
          } else {
            sb.append("sad").append("\n");
            continue outer;
          }
        }
      }

      System.out.print(sb);
    }
  }
}

/* 반례
1
2
0 0
1000 5
2000 10
3000 15

answer : sad

1
2
0 0
1000 0
2000 1000
1000 1000
=> happy
 */