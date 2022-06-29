package com.codingTest.baekjoon.silver.bruteForce;

import java.io.*;
import java.util.*;
import java.util.function.BiPredicate;

public class S_7568 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] list = new int[n][2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      list[i][0] = Integer.parseInt(st.nextToken());
      list[i][1] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.length; i++) {
      int rank = 1;
      for (int j = 0; j < list.length; j++) {
        if (i != j && list[i][0] < list[j][0] && list[i][1] < list[j][1]) rank++;
      }
      sb.append(rank).append(" ");
    }
    System.out.print(sb);
  }

  /*
   * wrong case
   * reason: SQL RANK()처럼 짰음
   * 기존의 문제는 나보다 덩치가 큰 사람의 수 +1 이 rank인 반면
   * 내가 푼 방식은 덩치가 큰 순서를 rank로 매겼기 때문에 결과가 다르게 나온다.
   *
   * ex) 3
   * 55 185
   * 56 190
   * 60 179
   *
   * answer: 2 1 1
   * in wrong case: 3 1 1
   *
   **/
  public static void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      ArrayList<Integer> info = new ArrayList<>(2);
      info.add(Integer.parseInt(st.nextToken()));
      info.add(Integer.parseInt(st.nextToken()));
      list.add(info);
    }

    int[] rank = new int[n];
    for (int i = 0; i < list.size(); i++) {
      int score = 0;
      for (int j = 0; j < list.size(); j++) {
        if (i != j && compare.test(list.get(i), list.get(j))) score++;
      }
      rank[i] = score;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rank.length; i++) {
      int count = 0;
      for (int j = 0; j < rank.length; j++) {
        if (i != j && rank[i] > rank[j]) count++;
      }
      sb.append(count + 1).append(" ");
    }
    System.out.print(sb);
  }

//  test1()을 고친 것
  public static void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      ArrayList<Integer> info = new ArrayList<>(2);
      info.add(Integer.parseInt(st.nextToken()));
      info.add(Integer.parseInt(st.nextToken()));
      list.add(info);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      int score = 0;
      for (int j = 0; j < list.size(); j++) {
        if (i != j && compare.test(list.get(i), list.get(j))) score++;
      }
      sb.append(score + 1).append(" ");
    }

    System.out.print(sb);
  }

  static BiPredicate<ArrayList<Integer>, ArrayList<Integer>> compare = (a, b) -> a.get(0) < b.get(0) && a.get(1) < (b.get(1));
}
