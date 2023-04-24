package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.*;

public class S_1021 {
  // https://www.acmicpc.net/problem/1021
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Deque<Integer> queue = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    st = new StringTokenizer(br.readLine());

    int count = 0;
    while (m-- > 0) {
      int needNumber = Integer.parseInt(st.nextToken());

      int firstCount = 0;
      int lastCount = 0;

      int frontPeek = queue.peekFirst();

      while (queue.peek() != needNumber) {
        firstCount++;
        queue.offer(queue.pollFirst());
      }

      if (firstCount == 0) {
        queue.poll();
        continue;
      }

      while (queue.peek() != frontPeek) { // 원상태로
        queue.offer(queue.pollFirst());
      }


      while (queue.peek() != needNumber) {
        lastCount++;
        queue.offerFirst(queue.pollLast());
      }

      queue.poll();

      count += Math.min(firstCount, lastCount);
    }

    System.out.print(count);
  }
}
