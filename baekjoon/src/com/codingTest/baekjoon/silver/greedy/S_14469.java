package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_14469 {
  // https://www.acmicpc.net/problem/14469
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Cow> queue = new PriorityQueue<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      queue.offer(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    int endTime = 0;

    while (!queue.isEmpty()) {
      Cow current = queue.poll();

      endTime = Math.max(endTime, current.arrive) + current.time;
    }

    System.out.println(endTime);
  }

  static class Cow implements Comparable<Cow> {
    int arrive;
    int time;

    public Cow(int arrive, int time) {
      this.arrive = arrive;
      this.time = time;
    }

    @Override
    public int compareTo(Cow o) {
      return arrive - o.arrive;
    }
  }
}
