package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16497 {
  // https://www.acmicpc.net/problem/16497
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] monthly = new int[32];
    int maxCount = 0;

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int borrowDate = Integer.parseInt(st.nextToken());
      int returnDate = Integer.parseInt(st.nextToken());

      for (int j = borrowDate; j < returnDate; j++) {
        ++monthly[j];

        maxCount = Math.max(maxCount, monthly[j]);
      }
    }

    int k = Integer.parseInt(br.readLine());

    System.out.print(maxCount <= k ? 1 : 0);
  }

  static class M2 {
    //    TODO 왜 안되는지 확인해볼 것
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[][] borrowRequestList = new int[n][2];

      StringTokenizer st;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        borrowRequestList[i][0] = Integer.parseInt(st.nextToken());
        borrowRequestList[i][1] = Integer.parseInt(st.nextToken());
      }

      int k = Integer.parseInt(br.readLine());

      int[] returnDateList = new int[k];

      for (int[] requestData : borrowRequestList) {
        boolean canBorrow = false;

        for (int i = 0; i < k; i++) {
          if (returnDateList[i] <= requestData[0]) {
            returnDateList[i] = requestData[1];
            canBorrow = true;
            break;
          }
        }

        if (!canBorrow) {
          System.out.print(0);
          return;
        }
      }

      System.out.print(1);
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[][] borrowList = new int[n][2];

      StringTokenizer st;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        borrowList[i][0] = Integer.parseInt(st.nextToken());
        borrowList[i][1] = Integer.parseInt(st.nextToken());
      }

      int bookCount = Integer.parseInt(br.readLine());

      Arrays.sort(borrowList, (b1, b2) -> b1[0] - b2[0]);

      int returnDate = borrowList[0][1];

      bookCount--;

      for (int i = 1; i < n; i++) {
        int borrowDate = borrowList[i][0];

        if (borrowDate < returnDate) {
          if (bookCount == 0) {
            System.out.print(0);
            return;
          } else {
            bookCount--;
          }
        } else {
          returnDate = borrowList[i][1];
        }
      }

      System.out.print(1);
    }
  }
}
