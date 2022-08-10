package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다시 읽어보기: https://st-lab.tistory.com/145
public class S_1931 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] time = new int[n][2];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      time[i][0] = Integer.parseInt(st.nextToken());
      time[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(time, (meeting1, meeting2) -> {
      if (meeting1[1] == meeting2[1]) {
        return meeting1[0] - meeting2[0];
      }

      return meeting1[1] - meeting2[1];
    });

    int maxCount = 0;
    int prevEndTime = 0;

    for (int i = 0; i < n; i++) {
      if (prevEndTime <= time[i][0]) {
        prevEndTime = time[i][1];
        maxCount++;
      }
    }

    System.out.print(maxCount);
  }
}
