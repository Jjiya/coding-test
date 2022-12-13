package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_2468 {
  static int[][] graph;
  static boolean[][] isVisited;
  static int n;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    graph = new int[n][n];
    isVisited = new boolean[n][n];
    int maxHeight = 0;  // 최대 강수량
    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, graph[i][j]);
      }
    }

    int maxSafeArea = 0;

    while (0 < maxHeight--) {
      int areaCount = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (0 < searchSafeArea(i, j, maxHeight)) {
            areaCount++;
          }
        }
      }

      maxSafeArea = Math.max(maxSafeArea, areaCount);
      isVisited = new boolean[n][n];
    }

    System.out.print(maxSafeArea);
  }

  static int searchSafeArea(int x, int y, int precipitation) {
    if ((0 <= x && x < n) && (0 <= y && y < n) && precipitation < graph[x][y] && !isVisited[x][y]) {
      isVisited[x][y] = true;
      return 1 + searchSafeArea(x + 1, y, precipitation) + searchSafeArea(x - 1, y, precipitation) + searchSafeArea(x, y + 1, precipitation) + searchSafeArea(x, y - 1, precipitation);
    } else {
      return 0;
    }
  }

  /*
    시간 초과
   */
  static int searchSafeArea2(int x, int y, int precipitation) {
    Node node;
    try {
      node = new Node(x, y);

      if (isVisited[x][y] || node.isFlooded(precipitation)) {
        return 0;
      }

      node.saveVisited();

      return 1 + searchSafeArea2(x + 1, y, precipitation) + searchSafeArea2(x - 1, y, precipitation) + searchSafeArea2(x, y + 1, precipitation) + searchSafeArea2(x, y - 1, precipitation);
    } catch (ArrayIndexOutOfBoundsException e) {
      return 0;
    }
  }

  static class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
      if ((0 <= x && x < n) && (0 <= y && y < n)) {
        this.x = x;
        this.y = y;
      } else {
        throw new ArrayIndexOutOfBoundsException();
      }
    }

    public boolean isFlooded(int precipitation) {
      return graph[this.x][this.y] <= precipitation;
    }

    public void saveVisited() {
      isVisited[this.x][this.y] = true;
    }
  }
}
