package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S_20126 {
  // https://www.acmicpc.net/problem/20126
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken()); // 강의실 이용 가능 시간

    int[][] classTime = new int[n][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      classTime[i][0] = Integer.parseInt(st.nextToken());
      classTime[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(classTime, Comparator.comparingInt(beforeClass -> beforeClass[0]));

    if (classTime[0][0] != 0 && m <= classTime[0][0]) {
      System.out.print(0);
      return;
    }

    for (int i = 0; i < n - 1; i++) {
      int currentTime = classTime[i][0] + classTime[i][1];
      int timeDiff = classTime[i + 1][0] - currentTime;

      if (m <= timeDiff && currentTime + m <= s) {
        System.out.print(currentTime);
        return;
      }
    }

    int lastTime = classTime[n - 1][0] + classTime[n - 1][1];

    if (lastTime + m <= s) {
      System.out.print(lastTime);
    } else {
      System.out.print(-1);
    }
  }
}
