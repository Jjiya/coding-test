package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S_2644 {
  static boolean[] visited;
  static HashMap<Integer, ArrayList<Integer>> graph;
  static int findX;
  static int findY;
  static int familyDegree = -1;

  // https://www.acmicpc.net/problem/2644
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    visited = new boolean[n + 1];

    graph = new HashMap<>(n);

    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }

    StringTokenizer st = new StringTokenizer(br.readLine());

    findX = Integer.parseInt(st.nextToken());
    findY = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      ArrayList<Integer> xChildren = graph.get(x);
      xChildren.add(y);

      graph.put(x, xChildren);

      ArrayList<Integer> yList = graph.get(y);
      yList.add(x);

      graph.put(y, yList);
    }

    dfs(findX, 0);

    System.out.println(familyDegree);

  }

  static void dfs(int number, int degree) {
    if (visited[number] || graph.get(number).size() == 0) {
      return;
    } else if (number == findY) {
      familyDegree = degree;
      return;
    }

    visited[number] = true;

    for (int family : graph.get(number)) {
      if (family == findY) {
        familyDegree = degree + 1;
        return;
      }

      dfs(family, degree + 1);
    }
  }
}
