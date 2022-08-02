package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_10815 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int maxNum = 10000000;
    int[] card = new int[maxNum * 2];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int cardNum = Integer.parseInt(st.nextToken()) + 10000000;
      card[cardNum] = 1;
    }

    int t = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int cardNum = Integer.parseInt(st.nextToken()) + 10000000;
      sb.append(card[cardNum]).append(" ");
    }

    System.out.print(sb);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<Integer> card = new HashSet<>();

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int cardNum = Integer.parseInt(st.nextToken());
      card.add(cardNum);
    }

    int t = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int cardNum = Integer.parseInt(st.nextToken());
      sb.append(card.contains(cardNum) ? "1 " : "0 ");
    }

    System.out.print(sb);
  }
}
