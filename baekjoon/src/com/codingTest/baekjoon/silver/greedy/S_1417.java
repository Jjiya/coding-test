package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S_1417 {
  // https://www.acmicpc.net/problem/1417
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.print(0);
      return;
    }

    int dasom = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> list = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n - 1; i++) {
      list.offer(Integer.parseInt(br.readLine()));
    }

    int count = 0;

    while (!list.isEmpty()) {
      Integer next = list.poll();

      if (dasom <= next) {
        list.offer(next - 1);
        dasom++;
        count++;
      }
    }

    System.out.print(count);
  }
}
/*
3
0
1
5

ans
3 (3번 후보에서만 3명 매수하면 3, 1, 2로 당선)

wrong output
4

---

4
2
10
10
10

# Answer
7

---

4
2
100
100
100

# Output
87

# Answer
75
 */