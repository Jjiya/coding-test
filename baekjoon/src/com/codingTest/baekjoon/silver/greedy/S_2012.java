package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;

public class S_2012 {
  // https://www.acmicpc.net/problem/2012
  public static void test() throws IOException {
    M4.test();
  }

  static class M4 {
    //  참고: https://velog.io/@seongwon97/BaekJoon-2012-%EB%93%B1%EC%88%98-%EB%A7%A4%EA%B8%B0%EA%B8%B0-Java
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] expectationGrade = new int[n];

      for (int i = 0; i < n; i++) {
        expectationGrade[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(expectationGrade);

      long totalComplaint = 0;  // 자료형 바꿔줌

      for (int i = 0; i < n; i++) {
        totalComplaint += Math.abs(expectationGrade[i] - (i + 1));
      }

      System.out.print(totalComplaint);
    }
  }

  static class M3 { // 시간 초과
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] expectationGrade = new int[500_001];

      int maxGrade = 0;
      for (int i = 0; i < n; i++) {
        int expectation = Integer.parseInt(br.readLine());
        expectationGrade[expectation]++;

        maxGrade = Math.max(maxGrade, expectation);
      }

      int totalComplaint = 0;
      int min = 1;

      for (int i = 1; i <= maxGrade; i++) {
        while (expectationGrade[i] != 1) {
          for (; min <= maxGrade; min++) {
            if (expectationGrade[min] == 0) {
              expectationGrade[min]++;
              expectationGrade[i]--;

              totalComplaint += Math.abs(i - min);
              break;
            }
          }
        }
      }

      System.out.print(totalComplaint);
    }
  }

  static class M2 { // 시간 초과
    public static void test() throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] expectationGrade = new int[500_001];

      int maxGrade = 0;
      for (int i = 0; i < n; i++) {
        int expectation = Integer.parseInt(br.readLine());
        expectationGrade[expectation]++;

        maxGrade = Math.max(maxGrade, expectation);
      }

      int totalComplaint = 0;

      for (int i = 1; i <= maxGrade; i++) {
        while (expectationGrade[i] != 1) {
          for (int j = 1; j <= maxGrade; j++) {
            if (expectationGrade[j] == 0) {
              expectationGrade[j]++;
              expectationGrade[i]--;

              totalComplaint += Math.abs(i - j);
              break;
            }
          }
        }
      }

      System.out.print(totalComplaint);
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] expectationGrade = new int[n + 1];

      for (int i = 0; i < n; i++) {
        expectationGrade[Integer.parseInt(br.readLine())]++;
      }

      int totalComplaint = 0;

      for (int i = 1; i <= n; i++) {
        int j = i + 1;
        while (expectationGrade[i] != 1) {
          if (expectationGrade[j] == 0) {
            expectationGrade[j]++;
            expectationGrade[i]--;

            totalComplaint += Math.abs(i - j);
          } else {
            j++;
          }
        }
      }

      System.out.print(totalComplaint);
    }
  }
}
