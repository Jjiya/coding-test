package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class S_11052 {
  // https://www.acmicpc.net/problem/11052
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    /*
      read와 동시에 비교해서 조금이나마 빠를 줄 알았는데 메모리도 더차지하네.. 시간은 동일함
      상수가 동일해서 그런가
     */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[] p = new int[n + 1];

      StringTokenizer st = new StringTokenizer(br.readLine());
      p[1] = Integer.parseInt(st.nextToken());

      for (int i = 2; i <= n; i++) {
        p[i] = Integer.parseInt(st.nextToken());

        for (int j = 1; j < i; j++) {
          p[i] = Math.max(p[i], p[j] + p[i-j]);
        }
      }

      System.out.print(p[n]);
    }
  }
  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[] p = new int[n + 1];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 1; i <= n; i++) {
        p[i] = Integer.parseInt(st.nextToken());
      }

      int[] dp = new int[n + 1];


      dp[1] = p[1];
      dp[2] = Math.max(p[1] * 2, p[2]);

      for (int i = 3; i <= n; i++) {
        dp[i] = p[i];

        for (int j = 1; j < i; j++) {
          dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
        }
      }

      System.out.print(dp[n]);
    }
  }
}

/*
    1개를 살 때의 최대 금액
    = 낱개 1개 금액

    2개를 살 때의 최대 금액
    = 낱개 1개 * 2 || 낱개 2개

    3개를 살 때의 최대 금액
    = 낱 1 * 3 || 낱 1 + 낱 2 || 낱 3
      -> 낱개 2개의 최대 값을 구했기 때문에 이 경우는 2번째 경우와 겹침
      그러므로 무조건 i-1 + i-2의 값 || 현재 i의 값이 그 카드를 살 때의 최대 값이 된다.
    = 낱 1 * 3 ||  낱 3

    첫번째 예제 돌리니까 틀림
    4
    1 5 6 7
    일때
    4개를 사기 위한 최대 비용이 2개를 2번 사는거네..

    4개를 살 때의 최대 금액
    = 낱 1개 * 4 || 낱 2개 * 2 || 낱 2 + 낱 1 * 2 || 낱 3 + 낱 1 || 낱 4
    -> 1, 2 경우는 동일함, 3의 경우는 최대값을 보장할 수 없음
    결국 낱 2 * 2 || 낱 3 + 낱 1 || 낱 4

    5개를 살 때의 최대 금액
    (동일 경우 빼고 계산해보자)
    =  낱 1 + 낱 4 || 낱 2 + 낱 3 || 낱 5

    6개를 살 때의 최대 금액
    = 낱 1 + 낱 5 || 낱 3 * 2 || 낱 4 + 낱 2 || 낱 6

    풀이 찾아보니까 2중 반복문 돌려야하네... 카드 최대값이 1000이라서 1초 내로 가능한가보다ㅠㅜㅠ
   */
