package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class G_16946 {
  // https://www.acmicpc.net/problem/16946

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};
  static int[][] graph;
  static int[][][] visited; // [0][][] 에는 연결된 장소의 개수, [1][][] 에는 탐색한 index를 저장해 중복 counting 하지 않도록 한다.
  static int searchIdx = 0;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    visited = new int[2][n][m];

    ArrayList<Coordinate> validPlaces = new ArrayList<>();
    ArrayList<Coordinate> wallPlaces = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = line.charAt(j) - 48;

        if (graph[i][j] == 0) {
          validPlaces.add(new Coordinate(i, j));
        } else {
          wallPlaces.add(new Coordinate(i, j));
        }
      }
    }

    for (Coordinate valid : validPlaces) {
      if (!valid.isVisit()) {
        ++searchIdx;
        valid.checkVisit();

        canMoveCount(valid);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (Coordinate wall : wallPlaces) {
      int count = 1;

      HashSet<Integer> addingSearchIndex = new HashSet<>();

      for (int i = 0; i < 4; i++) {
        Coordinate next = new Coordinate(wall.row + rowDirection[i], wall.col + columnDirection[i]);

        if (next.isValidCoordinate()) {
          int canMoveCount = visited[0][next.row][next.col];
          int searchIndex = visited[1][next.row][next.col];

          if (!next.isWall() && !addingSearchIndex.contains(searchIndex)) {
            addingSearchIndex.add(searchIndex);
            count += canMoveCount;
          }
        }
      }

      graph[wall.row][wall.col] = count % 10;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(graph[i][j]);
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static void canMoveCount(Coordinate coordinate) {
    ArrayList<Coordinate> visitedCoordinate = new ArrayList<>();
    visitedCoordinate.add(coordinate);

    Queue<Coordinate> queue = new LinkedList<>();
    queue.add(coordinate);

    int count = 1;

    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();

      for (int i = 0; i < 4; i++) {
        Coordinate next = new Coordinate(current.row + rowDirection[i], current.col + columnDirection[i]);

        if (next.isValid()) {
          next.checkVisit();

          visitedCoordinate.add(next);
          queue.offer(next);
          count++;
        }
      }
    }

    for (Coordinate visit : visitedCoordinate) {
      visit.checkCount(count);
    }
  }

  static class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }

    /**
     * 좌표가 유효한지
     *
     * @return 좌표의 유효 여부
     */
    public boolean isValidCoordinate() {
      return (0 <= row && row < graph.length) && (0 <= col && col < graph[0].length);
    }

    /**
     * 탐색할 수 있는지
     *
     * @return 탐색 가능 여부
     */
    public boolean isValid() {
      return isValidCoordinate() && !isVisit() && !isWall();
    }

    public boolean isVisit() {
      return visited[1][row][col] != 0;
    }

    public boolean isWall() {
      return graph[row][col] == 1;
    }

    public void checkVisit() {
      visited[1][row][col] = searchIdx;
    }

    public void checkCount(int count) {
      visited[0][row][col] = count;
    }
  }

  /*
  벽인 곳을 기준으로 탐색을 했으나 시간 초과 발생
  (visited 초기화를 2중 for문 안에 해서 그런가 싶어 searchIdx 를 만들어 해결했으나 근본적인 원인이 아니었음)
  어쩐지 골드 2 치고는 쉬운데 싶었다..

  https://www.acmicpc.net/board/view/78670
  위의 게시글을 보고 구현 방법을 바꿔보기로 함.

   */
//  public static void test1() throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    StringTokenizer st = new StringTokenizer(br.readLine());
//
//    int n = Integer.parseInt(st.nextToken());
//    int m = Integer.parseInt(st.nextToken());
//
//    graph = new int[n][m];
//    visited = new int[n][m];
//
//    for (int i = 0; i < n; i++) {
//      String line = br.readLine();
//      for (int j = 0; j < m; j++) {
//        graph[i][j] = line.charAt(j) - 48;
//      }
//    }
//
//    StringBuilder sb = new StringBuilder();
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < m; j++) {
//        if (graph[i][j] == 1) {
//          ++searchIdx;
//          Coordinate wall = new Coordinate(i, j);
//
//          sb.append(breakWall(wall) % 10);
//        } else {
//          sb.append("0");
//        }
//      }
//      sb.append("\n");
//    }
//
//    System.out.print(sb);
//  }
//
//  static long breakWall(Coordinate firstCoordinate) {
//    Queue<Coordinate> queue = new LinkedList<>();
//
//    firstCoordinate.checkVisit();
//
//    queue.offer(firstCoordinate);
//
//    long count = 1L;
//
//    while (!queue.isEmpty()) {
//      Coordinate current = queue.poll();
//
//      for (int i = 0; i < 4; i++) {
//        Coordinate next = new Coordinate(current.row + rowDirection[i], current.col + columnDirection[i]);
//
//        if (next.isValidCoordinate()) {
//          next.checkVisit();
//
//          queue.offer(next);
//          count++;
//        }
//      }
//    }
//
//    return count;
//  }
}
