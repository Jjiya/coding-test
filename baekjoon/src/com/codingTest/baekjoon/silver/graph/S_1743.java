package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1743 {
  // https://www.acmicpc.net/problem/1743

  static int n;
  static int m;
  static int[][] graph;
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken()); // 행
    m = Integer.parseInt(st.nextToken()); // 열
    int k = Integer.parseInt(st.nextToken()); // 음쓰 개수

    graph = new int[n + 1][m + 1];
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph[r][c] = 1;

      queue.offer(new int[]{r, c});
    }

    int bigFoodWaste = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      bigFoodWaste = Math.max(bigFoodWaste, foodWasteSize(current[0], current[1]));
    }


    System.out.print(bigFoodWaste);
  }

  static int foodWasteSize(int row, int col) {
    if (isValid(row, col)) {
      graph[row][col] = -1;

      int count = 1;

      for (int i = 0; i < 4; i++) {
        count += foodWasteSize(row + rowDirection[i], col + columnDirection[i]);
      }

      return count;
    } else {
      return 0;
    }
  }

  static boolean isValid(int row, int col) {
    return (0 <= row && row <= n) && (0 <= col && col <= m) && graph[row][col] == 1;
  }
}
