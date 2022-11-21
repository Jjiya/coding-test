package com.codingTest.baekjoon.silver.backTracking;

import java.io.*;
import java.util.StringTokenizer;

public class S_15650 {
  static int[] sequence;
  static boolean[] isVisited;
  static int n;
  static int m;
  static StringBuilder sb = new StringBuilder();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    isVisited = new boolean[n + 1];
    sequence = new int[m];

    bt(1, 0);

    System.out.print(sb);
  }

  static void bt(int start, int depth) {
    if (depth == m) {
      for (int num : sequence) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = start; i < isVisited.length; i++) {
        if (!isVisited[i]) {
          isVisited[i] = true;
          sequence[depth] = i;
          bt(i, depth + 1);
          isVisited[i] = false;
        }
      }
    }
  }
}
