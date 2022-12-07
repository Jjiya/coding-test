package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_4963 {
  static int[][] map;
  //  동 동남 남 남서 서 서북 북 북동 순서 탐색
  static int[] rowDirection = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] columnDirection = {1, 1, 0, -1, -1, -1, 0, 1};

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (!(input = br.readLine()).equals("0 0")) {
      st = new StringTokenizer(input);

      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());


      map = new int[h][w];

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int islandCount = 0;


      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          Node node = new Node(j, i);

          if (node.isValidNode() && (getIslandCount(node) != 0)) {
            islandCount++;
          }
        }
      }

      sb.append(islandCount).append("\n");
    }

    System.out.print(sb);
  }

  static int getIslandCount(Node node) {
    Queue<Node> queue = new LinkedList<>();

    queue.offer(node);

    int count = node.isValidNode() ? 1 : 0;
    node.checkVisit();

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      int curW = current.w;
      int curH = current.h;

      for (int i = 0; i < rowDirection.length; i++) {
        Node next = new Node(curW + rowDirection[i], curH + columnDirection[i]);

        if (next.isValidNode()) {
          next.checkVisit();
          queue.offer(next);
          count++;
        }
      }
    }

    return count;
  }

  static class Node {
    int w;
    int h;

    public Node(int w, int h) {
      this.w = w;
      this.h = h;
    }

    boolean isValidNode() {
      return (0 <= w && w < map[0].length && 0 <= h && h < map.length) && map[h][w] == 1;
    }

    void checkVisit() {
      map[h][w] = 2;
    }

    void checkVisit(int value) {
      map[h][w] = value;
    }

    int getMapValue() {
      return map[h][w];
    }
  }
}
