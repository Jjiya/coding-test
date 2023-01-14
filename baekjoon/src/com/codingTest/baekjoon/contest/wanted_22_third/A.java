package com.codingTest.baekjoon.contest.wanted_22_third;

import java.io.*;
import java.util.StringTokenizer;

//  신을 모시는 사당
public class A {
//  https://showmethecode.acmicpc.net/contest/problem/940/1
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] painting = new int[n + 1];
    int[] result = new int[3];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      painting[i] = Integer.parseInt(st.nextToken());
    }

    int[] continuous = new int[3];

    continuous[painting[0]] = 1;

    for (int i = 1; i <= n; i++) {
      int current = painting[i];
      int before = painting[i - 1];

      if (current == before) {
        continuous[current]++;
      } else {
        if (1 < continuous[before]) {
          result[before] = Math.max(result[before], continuous[before]);
        }

        continuous[before] = 0;
        continuous[current] = 1;
      }
    }

    if (result[1] == 0 && result[2] == 0) {
      System.out.print(1);
    } else {
      System.out.print(Math.abs(result[1] - result[2]));
    }
  }
}
