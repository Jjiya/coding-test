package com.codingTest.baekjoon.bronze.math;

import java.io.*;
import java.util.StringTokenizer;

public class B_13458 {
  // https://www.acmicpc.net/problem/13458
//  참고: https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-13458-%EC%8B%9C%ED%97%98-%EA%B0%90%EB%8F%85
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] aList = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      aList[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    long supervisorCount = 0;

    for (int a : aList) {
      a -= b;
      supervisorCount++;

      if (a <= 0) { // a가 음수가 되는 경우를 고려안해서 틀렸었음
        continue;
      }

      supervisorCount += (a / c);

      if (a % c != 0) {
        supervisorCount++;
      }
    }

    System.out.print(supervisorCount);
  }
}
