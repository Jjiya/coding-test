package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_23028 {
  // https://www.acmicpc.net/problem/23028
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

//    졸업 요건 130학점 (전공 66점 포함)
      int n = Integer.parseInt(st.nextToken()); // 이수한 학기 수
      int a = Integer.parseInt(st.nextToken()); // 이수한 전공 학점
      int b = Integer.parseInt(st.nextToken()); // 총 학점

      int[] remainCredit = {Math.max(0, 66 - a), Math.max(0, 130 - b)};

//    한 학기 최대 6과목(18학점) 수강 가능
      for (int i = 0; i < (8 - n); i++) {
        st = new StringTokenizer(br.readLine());

        int remain = 18;

        int x = Integer.parseInt(st.nextToken()); // 전공 과목 수
        int y = Integer.parseInt(st.nextToken()); // 비전공 과목 수

        int[] convertCredit = {x * 3, y * 3};

        for (int j = 0; j < 2; j++) {
          if (remainCredit[j] == 0) {
            continue;
          }

          int credit = Math.min(remain, Math.min(remainCredit[j], convertCredit[j]));

          remainCredit[j] -= credit;
          remain -= credit;

          if (j == 0) {
            remainCredit[j + 1] -= credit;
          }
        }
      }

      System.out.print((remainCredit[0] + remainCredit[1] == 0) ? "Nice" : "Nae ga wae");
    }
  }

  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

//    졸업 요건 130학점 (전공 66점 포함)
      int n = Integer.parseInt(st.nextToken()); // 이수한 학기 수
      int a = Integer.parseInt(st.nextToken()); // 이수한 전공 학점
      int b = Integer.parseInt(st.nextToken()); // 총 학점

      int remainA = 66 - a;
      int remainB = 130 - b;

//    한 학기 최대 6과목(18학점) 수강 가능
      for (int i = 0; i < (8 - n); i++) {
        if (remainA <= 0 && remainB <= 0) {
          break;
        }

        st = new StringTokenizer(br.readLine());

        int remain = 18;

        int x = Integer.parseInt(st.nextToken()); // 전공 과목 수
        int y = Integer.parseInt(st.nextToken()); // 비전공 과목 수

        int creditX = x * 3;
        int creditY = y * 3;

        int listonX = Math.max(0, Math.min(remainA, Math.min(creditX, remain)));  // 현재 reaminA가 음수라서 listonX가 음수가 나오게되는 경우를 고려 안해서 틀렸음...

        remainA -= listonX;
        remain -= listonX;
        remainB -= listonX;

        int listonY = Math.max(0, Math.min(remainB, Math.min(creditY, remain)));  // 현재 reaminB가 음수라서 listonY가 음수가 나오게되는 경우를 고려 안해서 틀렸음...

        remainB -= listonY;
      }

      System.out.println((remainA <= 0 && remainB <= 0) ? "Nice" : "Nae ga wae");
    }
  }
}