package com.codingTest.baekjoon.silver.tree;

import java.io.*;
import java.util.*;

public class S_11725 {
  static HashMap<Integer, ArrayList<Integer>> graph;
  static boolean[] isVisited;
  static int[] rootNum;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    isVisited = new boolean[n + 1];
    rootNum = new int[n + 1];

    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());

      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      ArrayList<Integer> n1List = graph.getOrDefault(n1, new ArrayList<>(3));
      n1List.add(n2);

      graph.put(n1, n1List);

      ArrayList<Integer> n2List = graph.getOrDefault(n2, new ArrayList<>(3));
      n2List.add(n1);

      graph.put(n2, n2List);
    }

    getRootNode(1, 1);

    StringBuilder sb = new StringBuilder();

    for (int j = 2; j < rootNum.length; j++) {
      sb.append(rootNum[j]).append("\n");
    }

    System.out.print(sb);
  }

  static void getRootNode(int root, int current) {
    if (current == 0 || isVisited[current]) {
      return;
    }

    isVisited[current] = true;
    rootNum[current] = root;

    for (int node : graph.get(current)) {
      getRootNode(current, node);
    }
  }

}
