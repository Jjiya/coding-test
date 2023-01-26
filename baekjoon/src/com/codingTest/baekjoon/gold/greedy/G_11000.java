package com.codingTest.baekjoon.gold.greedy;

import java.io.*;
import java.util.*;

public class G_11000 {
  // https://www.acmicpc.net/problem/11000
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[][] time = new int[n][2];

      StringTokenizer st;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());

        time[i][0] = Integer.parseInt(st.nextToken());
        time[i][1] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(time, (int[] a, int[] b) -> {
        if (a[0] == b[0]) {
          return a[1] - b[1];
        }
        return a[0] - b[0];
      });

      PriorityQueue<Integer> queue = new PriorityQueue<>();

      queue.offer(time[0][1]);

      for (int i = 1; i < n; i++) {
        if (queue.peek() <= time[i][0]) {
          queue.poll();
        }
        queue.add(time[i][1]);
      }

      System.out.print(queue.size());
    }
  }

  static class M1 {
    //    시간 초과
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[][] time = new int[n][2];

      StringTokenizer st;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());

        time[i][0] = Integer.parseInt(st.nextToken());
        time[i][1] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(time, (int[] a, int[] b) -> {
        if (a[0] < b[0]) {
          return -1;
        } else if (a[0] > b[0]) {
          return 1;
        }
        return 0;
      });

      int[] lastTime = new int[n];
      int max = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (lastTime[j] <= time[i][0]) {
            max = Math.max(max, j);
            lastTime[j] = time[i][1];
            break;
          }
        }
      }

      System.out.print(max + 1);
    }
  }
}
/*
5
1 7
2 3
3 4
4 8
7 10

답: 2
 */
