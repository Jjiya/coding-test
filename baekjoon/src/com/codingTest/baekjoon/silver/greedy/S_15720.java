package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 세트 할인이 적용된 후의 최소 가격 => 세트가 적용될 수 있는 최대 수량만큼 각 항목의 비싼 금액만 10% 할인해주기.
 */
public class S_15720 {
  // https://www.acmicpc.net/problem/15720
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] counting = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    int minimumCount = 1001;

    for (int count : counting) {
      minimumCount = Math.min(minimumCount, count);
    }

    ArrayList<PriorityQueue<Integer>> buggerList = new ArrayList<>();

    int nonSet = 0;

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

      for (int j = 0; j < counting[i]; j++) {
        int money = Integer.parseInt(st.nextToken());
        queue.offer(money);
        nonSet += money;
      }

      buggerList.add(queue);
    }

    int set = 0;

    for (int i = 0; i < minimumCount; i++) {
      for (int j = 0; j < 3; j++) {
        set += (buggerList.get(j).poll() * 0.9);
      }
    }

    for (int i = 0; i < 3; i++) {
      while (!buggerList.get(i).isEmpty()) {
        set += buggerList.get(i).poll();
      }
    }

    System.out.println(nonSet);
    System.out.print(set);
  }
}
