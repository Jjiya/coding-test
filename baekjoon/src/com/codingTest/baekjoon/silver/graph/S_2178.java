package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S_2178 {
  static int[][] maze;
  //  동 서 남 북 순으로 탐색
  static int[] movingX = {1, -1, 0, 0};
  static int[] movingY = {0, 0, 1, -1};

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split("\\s");
    int n = Integer.parseInt(input[0]); // 세로
    int m = Integer.parseInt(input[1]); // 가로

    maze = new int[n][m];

//    1. 미로 경로 저장
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        maze[i][j] = line.charAt(j) - 48;
      }
    }

    maze[0][0] = -1;
    bfs(0, 0);

    System.out.print(maze[n - 1][m - 1] * -1);
  }

  /**
   * 너비 우선 탐색
   *
   * @param x 탐색 시작 x 좌표
   * @param y 탐색 시작 y 좌표
   */
  static void bfs(int x, int y) {
    //    방문 여부는 해당 경로를 음수로 표기할 예정(현재 몇 칸 왔는지 * -1)
    Queue<Coordinate> queue = new LinkedList<>();

    queue.offer(new Coordinate(x, y));

    outer:
    while (!queue.isEmpty()) {
      Coordinate current = queue.poll();

//      동서남북 방향으로 이동할 수 있는지 확인
      for (int i = 0; i < movingX.length; i++) {
        int nextX = (current.x + movingX[i]);
        int nextY = (current.y + movingY[i]);

        Coordinate next = new Coordinate(nextX, nextY);

        if (isCanMove(next)) {
          queue.offer(next);
          maze[nextX][nextY] = maze[current.x][current.y] - 1;

//          출구에 도달 시 반복문 종료
          if (nextX == maze.length - 1 && nextY == maze[0].length) {
            break outer;
          }
        }
      }
    }
  }

  /**
   * param으로 들어온 좌표로 이동할 수 있는지 확인한다.
   *
   * @param coordinate 다음으로 이동할 좌표
   * @return 이동 가능 여부
   */
  static boolean isCanMove(Coordinate coordinate) {
    int x = coordinate.x;
    int y = coordinate.y;

//    1. x축이 미로 범위를 벗어나지 않는지
//    2. y축이 미로 범위를 벗어나지 않는지
//    3. 해당 경로를 방문한 적이 없는지 || 벽은 아닌지
    return (0 <= x && x < maze.length) && (0 <= y && y < maze[x].length) && 0 < maze[x][y];
  }

  //  좌표 저장
  static class Coordinate {
    public int x;
    public int y;

    Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
