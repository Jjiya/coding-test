package com.codingTest.baekjoon.silver.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class S_15649 {
  static int[] list;
  static int[] sequence;
  static boolean[] isVisited;
  static StringBuilder sb = new StringBuilder();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    list = new int[n];
    isVisited = new boolean[n];
    sequence = new int[m];

    for (int i = 0; i < n; i++) {
      list[i] = i + 1;
    }

    bt(m, 0);

    System.out.print(sb);
  }

  static void bt(int max, int depth) {
    if (max == depth) {
      for (int num : sequence) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < list.length; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;

        sequence[depth] = i + 1;
        bt(max, depth + 1);

        isVisited[i] = false;
      }
    }
  }
}
