package com.codingTest.baekjoon.silver.backTracking;

import java.io.*;
import java.util.StringTokenizer;

// TODO: 백트래킹 다시 공부해볼 것
public class S_6603 {
  static int[] lottoList;
  static boolean[] isVisited;
  static int[] pickLotto;
  static StringBuilder sb = new StringBuilder();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input;
    StringTokenizer st;

    while (!(input = br.readLine()).equals("0")) {
      st = new StringTokenizer(input);

      int k = Integer.parseInt(st.nextToken());
      pickLotto = new int[6];
      lottoList = new int[k];
      isVisited = new boolean[k];

      for (int i = 0; i < k; i++) {
        lottoList[i] = Integer.parseInt(st.nextToken());
      }

      bt(0, 0);

      sb.append("\n");
    }

    System.out.print(sb);
  }

  /**
   * 백트래킹 backtracking
   *
   * @param start 탐색 시작 index
   * @param depth 최대 탐색 깊이
   */
  static void bt(int start, int depth) {
    if (depth == 6) {
      for (int lotto : pickLotto) {
        sb.append(lotto).append(" ");
      }
      sb.append("\n");

      return;
    }
    for (int i = start; i < lottoList.length; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        pickLotto[depth] = lottoList[i];
        bt(i, depth + 1);
        isVisited[i] = false;
      }
    }
  }
}
