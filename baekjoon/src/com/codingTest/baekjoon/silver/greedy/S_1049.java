package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1049 {
  // https://www.acmicpc.net/problem/1049

  //  11612kb / 80ms
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 끊어진 줄 개수
    int m = Integer.parseInt(st.nextToken());  // 브랜드 개수

    int minPackagePrice = 1001;
    int minIndividualPrice = 1001;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      minPackagePrice = Math.min(minPackagePrice, Integer.parseInt(st.nextToken()));
      minIndividualPrice = Math.min(minIndividualPrice, Integer.parseInt(st.nextToken()));
    }

    int totalPrice = 0;

    if (6 <= n) {
      totalPrice += (n / 6) * Math.min(minPackagePrice, minIndividualPrice * 6);

      n %= 6;
    }

    totalPrice += Math.min(minPackagePrice, minIndividualPrice * n);

    System.out.print(totalPrice);
  }

  //  아래 방식으로 풀었다가 굳이 다른 정보를 저장할 필요가 있나 싶어서 위의 방법으로 변경함!
  //  18260kb / 236ms
  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 끊어진 줄 개수
    int m = Integer.parseInt(st.nextToken());  // 브랜드 개수

    int[][] list = new int[m][2];

    int minIndividualPrice = 1001;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      list[i][0] = Integer.parseInt(st.nextToken());
      list[i][1] = Integer.parseInt(st.nextToken());

      minIndividualPrice = Math.min(minIndividualPrice, list[i][1]);
    }

    Arrays.sort(list, (l1, l2) -> {
      if (l1[0] > l2[0]) {
        return 1;
      } else if (l1[0] < l2[0]) {
        return -1;
      } else {
        if (l1[1] > l2[1]) {
          return 1;
        } else if (l1[1] < l2[1]) {
          return -1;
        }
        return 0;
      }
    });

    int totalPrice = 0;

    while (0 < n) {
      if (6 <= n) {
        int packagePrice = Math.min(list[0][0], minIndividualPrice * 6);
        totalPrice += (n / 6) * packagePrice;

        n %= 6;
      } else {
        totalPrice += Math.min(list[0][0], minIndividualPrice * n);
        n = 0;
      }
    }

    System.out.print(totalPrice);
  }
}
