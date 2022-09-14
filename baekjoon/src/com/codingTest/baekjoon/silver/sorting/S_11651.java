package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_11651 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<Integer, ArrayList<Integer>> coordinates = new HashMap<>();
    HashSet<Integer> ySet = new HashSet<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      ySet.add(y);

      ArrayList<Integer> xList = coordinates.getOrDefault(y, new ArrayList<>());

      xList.add(x);
      coordinates.put(y, xList);
    }
    StringBuilder sb = new StringBuilder();

    ySet.stream().sorted().forEach(y -> {
      ArrayList<Integer> xList = coordinates.get(y);
      xList.sort((x1, x2) -> {
        if (x1 > x2) return 1;
        if (x1 < x2) return -1;
        return 0;
      });
      xList.forEach(x -> sb.append(x).append(" ").append(y).append("\n"));
    });

    System.out.print(sb);
  }

  //   x 좌표 증가 순
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<Integer, ArrayList<Integer>> coordinates = new HashMap<>();
    HashSet<Integer> xSet = new HashSet<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      xSet.add(x);

      ArrayList<Integer> yList = coordinates.getOrDefault(x, new ArrayList<>());

      yList.add(y);
      coordinates.put(x, yList);
    }

    xSet.stream().sorted().forEach(x -> {
      ArrayList<Integer> y = coordinates.get(x);
      y.sort((y1, y2) -> {
        if (y1 > y2) return 1;
        if (y1 < y2) return -1;
        return 0;
      });
    });
  }
}
