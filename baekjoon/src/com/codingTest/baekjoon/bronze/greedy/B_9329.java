package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9329 {
  // https://www.acmicpc.net/problem/9329
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int tc = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (tc-- > 0) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 상금 개수
      int m = Integer.parseInt(st.nextToken()); // 스티커 종류

      int[][] prize = new int[n][];
      int[] money = new int[n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        prize[i] = new int[k];

        for (int j = 0; j < k; j++) {
          prize[i][j] = Integer.parseInt(st.nextToken());  // 필요 쿠폰 번호 저장
        }

        money[i] = Integer.parseInt(st.nextToken());  // 상금 저장
      }

      int[] coupon = new int[m + 1];

      st = new StringTokenizer(br.readLine());

      for (int i = 1; i <= m; i++) {  // 보유 쿠폰 저장
        coupon[i] = Integer.parseInt(st.nextToken());
      }

      int totalPrice = 0;

      outer:
      for (int i = 0; i < n; i++) {
        int couponCount = 101;
        for (int couponNumber : prize[i]) {
          if (0 < coupon[couponNumber]) { // 현재 상금을 최대 몇번 받을 수 있는지
            couponCount = Math.min(couponCount, coupon[couponNumber]);
          } else {
            continue outer;
          }
        }

        totalPrice += (money[i] * couponCount);
      }

      sb.append(totalPrice).append("\n");
    }

    System.out.print(sb);
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int tc = Integer.parseInt(br.readLine());
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();

      while (tc-- > 0) {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] prizeMoney = new int[n][];

        for (int i = 0; i < n; i++) {
          st = new StringTokenizer(br.readLine());
          int k = Integer.parseInt(st.nextToken());

          prizeMoney[i] = new int[k + 1];

          for (int j = 1; j <= k; j++) {
            prizeMoney[i][j] = Integer.parseInt(st.nextToken());  // 필요 쿠폰 번호 저장
          }

          prizeMoney[i][0] = Integer.parseInt(st.nextToken());  // 상금 저장
        }

        Arrays.sort(prizeMoney, (pm1, pm2) -> pm2[0] - pm1[0]); // 상금 높은 순으로 정렬

        int[] coupon = new int[m + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= m; i++) {
          coupon[i] = Integer.parseInt(st.nextToken());
        }

        int prizeIdx = 0;
        int totalMoney = 0;
        for (int i = 0; i < n; i++) {
          int maxCount = 101; // 최대로 사용할 수 있는 쿠폰 개수

          for (; prizeIdx < n; prizeIdx++) {
            Queue<Integer> queue = new LinkedList<>();  // 사용할 쿠폰 번호
            boolean canUse = true;

            for (int j = 1; j < prizeMoney[prizeIdx].length; j++) {
              int couponNumber = prizeMoney[prizeIdx][j];

              if (0 < coupon[couponNumber]) {
                maxCount = Math.min(maxCount, coupon[couponNumber]);  // 필요한 쿠폰을 최대 몇개나 쓸 수 있는지 (가지고 있는 카드 중 가장 적은 개수만큼 쓸 수 있음)
                queue.offer(couponNumber);
              } else {
                canUse = false;
                break;
              }
            }

            if (canUse) { // 해당 가게에서 상금을 받을 수 있다면
              while (!queue.isEmpty()) {  // 쿠폰 사용해주고
                int couponNumber = queue.poll();
                coupon[couponNumber] -= maxCount;
              }

              totalMoney += (prizeMoney[prizeIdx][0] * maxCount); // 상금 더해주기
              break;
            }
          }
        }

        sb.append(totalMoney).append("\n");
      }

      System.out.print(sb);
    }
  }
}
