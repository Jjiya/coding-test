package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class G_14502 {
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};
  static Queue<Node> spreadNodes = new LinkedList<>();
  static ArrayList<Node> virusNodes = new ArrayList<>();
  static int[][] map;
  static int maxSafetyAreaCount = 0;
  static int n;
  static int m;
  static int notSpreadCount = -3; // 0 3개는 벽으로 변경할 것이기 때문에 count - 3

  // https://www.acmicpc.net/problem/14502
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken()); // 세로
    m = Integer.parseInt(st.nextToken()); // 가로

    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num;

        if (num == 0) {
          notSpreadCount++;
        } else if (num == 2) {
          virusNodes.add(new Node(i, j));
        }
      }
    }

    backTracking(0);

    System.out.print(maxSafetyAreaCount);
  }

  static void backTracking(int count) {
    if (count == 3) {
      getSafetyCount();
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 3;
          backTracking(count + 1);
          map[i][j] = 0;
        }
      }
    }
  }

//  1. 바이러스 감염 -> 2로 만들기
//  2. 0의 개수 세기
//  3. 안전 구역 개수 max 비교하기

  static void getSafetyCount() {
    for (Node virusNode : virusNodes) {
      spreadVirus(virusNode.rowIdx, virusNode.colIdx);
    }

//    기존 0의 개수 (-3 => 벽으로 변환시킨 0의 개수) - 감염된 0의 개수
    maxSafetyAreaCount = Math.max(maxSafetyAreaCount, notSpreadCount - spreadNodes.size());

    while (!spreadNodes.isEmpty()) {
      Node spreadNode = spreadNodes.poll();
      map[spreadNode.rowIdx][spreadNode.colIdx] = 0;
    }
  }

  static void spreadVirus(int rowIdx, int colIdx) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(rowIdx, colIdx));

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      for (int i = 0; i < 4; i++) {
        new Node(current.rowIdx + rowDirection[i], current.colIdx + columnDirection[i]).addQueue(queue);
      }
    }
  }

  static class Node {
    int rowIdx;
    int colIdx;

    public Node(int rowIdx, int colIdx) {
      this.rowIdx = rowIdx;
      this.colIdx = colIdx;
    }

    public void addQueue(Queue<Node> queue) {
      if (this.isValidNode()) {
        map[rowIdx][colIdx] = 2;
        spreadNodes.offer(this);
        queue.offer(this);
      }
    }

    boolean isValidNode() {
      return (0 <= rowIdx && rowIdx < n) && (0 <= colIdx && colIdx < m) && map[rowIdx][colIdx] == 0;
    }
  }
}
