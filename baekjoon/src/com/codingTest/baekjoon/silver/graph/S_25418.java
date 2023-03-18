package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_25418 {
  // https://www.acmicpc.net/problem/25418
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    boolean[] isCheck = new boolean[k + 1];

    Queue<K_value> queue = new LinkedList<>();
    queue.offer(new K_value(a, 0));

    while (!queue.isEmpty()) {
      K_value current = queue.poll();

      if (current.num == k) {
        System.out.print(current.count);
        break;
      }

      if (current.num + 1 <= k && !isCheck[current.num + 1]) {
        isCheck[current.num + 1] = true;
        queue.offer(new K_value(current.num + 1, current.count + 1));
      }

      if (current.num * 2 <= k && !isCheck[current.num * 2]) {
        isCheck[current.num * 2] = true;
        queue.offer(new K_value(current.num * 2, current.count + 1));
      }
    }
  }

  static class K_value {
    int num;
    int count;

    public K_value(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }
}
