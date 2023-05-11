package com.codingTest.baekjoon.bronze.implement;

import java.io.*;

public class B_16944 {
  // https://www.acmicpc.net/problem/16944
  public static void test() throws IOException {
    M2.test();
  }

  //  11656KB 84ms 더 느림. 의외로 메모리는 더 적음
  static class M2 {
    static String[] patterns = {".*[0-9]+.*", ".*[a-z]+.*", ".*[A-Z]+.*", ".*[!@#$%^&*()-+]+.*"};
    static int minLength = 6;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();

      int addCount = 0;

      for (String regex : patterns) {
        if (!s.matches(regex)) {
          addCount++;
        }
      }

      System.out.print(addCount + Math.max(0, minLength - (n + addCount)));
    }
  }

  //  11668KB 76ms 하드코딩
  static class M1 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();

      int addCount = 0;

      if (!s.matches(".*[0-9]+.*")) {
        addCount++;
      }
      if (!s.matches(".*[a-z]+.*")) {
        addCount++;
      }
      if (!s.matches(".*[A-Z]+.*")) {
        addCount++;
      }
      if (!s.matches(".*[!@#$%^&*()-+]+.*")) {
        addCount++;
      }

      System.out.print(addCount + Math.max(0, 6 - (n + addCount)));
    }
  }
}
