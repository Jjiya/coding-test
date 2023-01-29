package com.codingTest.baekjoon.contest.MatKorCup_2023WinterOpenContest;

import java.util.*;

public class A {
  //  https://www.acmicpc.net/contest/problem/931/1
  public static void test() {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    int s = scanner.nextInt();

    System.out.print((s == 1 || !(11 < t && t < 17)) ? 280 : 320);
  }
}
