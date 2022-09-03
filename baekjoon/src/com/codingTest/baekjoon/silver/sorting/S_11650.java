package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S_11650 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;

    int[][] xy = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      xy[i][0] = x;
      xy[i][1] = y;
    }

    Arrays.sort(xy, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int y : xy[i]) {
        sb.append(y).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  public void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, ArrayList<Integer>> xy = new HashMap<>();

    StringTokenizer st;
    int[] xList = new int[n];
    ArrayList<Integer> yList;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      yList = xy.getOrDefault(x, new ArrayList<>());
      yList.add(y);
      xy.put(x, yList);
    }

    StringBuilder sb = new StringBuilder();

  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] xy = new int[n + 1][2];

    int min = 100001;
    int max = -100001;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      xy[x + 100000][y + 100000] = 1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < xy.length; i++) {
      for (int j = 0; j < xy[i].length; j++) {
        if (xy[i][j] == 1) {
          sb.append(i - 100000).append(" ").append(j - 100000).append("\n");
        }
      }
    }
  }
}
