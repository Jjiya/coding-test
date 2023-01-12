package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TODO: 아무래도 다시 푸는 것이 좋을 듯 하다
public class G_13460 {
  // https://www.acmicpc.net/problem/13460
  static char[][] graph;
  static boolean[][][][] visited;
  /*
    visited
    -> 3차원도 아니고 4차원으로 체크해야함. (빨간 공의 위치와 파란 공의 위치) 결과를 세트로 보고 해당 세트를 실행한 적이 있는지를 판별해야하나봄...
    각 공의 개별 위치를 판별하고 움직이다보면 끝까지 안가고, 방문하기 전의 경로에서 공이 멈추게 됨..
    다른 참고: https://minhamina.tistory.com/191
   */
  static Coordinate hole;
  static Coordinate redBall;
  static Coordinate blueBall;

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new char[n][m];
    visited = new boolean[n][m][n][m];

    Queue<Coordinate> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      String line = br.readLine();

      if (line.indexOf('B') != 0 || line.indexOf('O') != 0 || line.indexOf('R') != 0) {
        for (int j = 0; j < m; j++) {
          graph[i][j] = line.charAt(j);
          switch (graph[i][j]) {
            case 'B':
              blueBall = new Coordinate(i, j, 0);
              break;
            case 'O':
              hole = new Coordinate(i, j, 0);
              break;
            case 'R':
              redBall = new Coordinate(i, j, 0);
              break;
          }
        }
      } else {
        graph[i] = line.toCharArray();
      }
    }

    redBall.setBlueBall(blueBall);
    redBall.checkVisit();
    queue.add(redBall);

    while (!queue.isEmpty()) {
      redBall = queue.poll();
      blueBall = redBall.blueBall;

      if (10 < redBall.count) {
        System.out.println(-1);
        return;
      }

      for (int i = 0; i < 4; i++) {
        Coordinate nextRedBall = new Coordinate(redBall.row, redBall.column, redBall.count + 1);
        int redBallMovingCount = movingBall(nextRedBall, i);

        Coordinate nextBlueBall = new Coordinate(blueBall.row, blueBall.column, blueBall.count + 1);
        int blueBallMovingCount = movingBall(nextBlueBall, i);

        /*
        얘를 하나로 합치면 파란공이 구멍에 빠졌을 때의 경우도 queue에 넣게돼서 실패함...
         */
        if (blueBallMovingCount == -1) {
          continue;
        } else if (redBallMovingCount == -1 && nextRedBall.count < 11) {
          System.out.println(nextRedBall.count);
          return;
        }

//        공이 겹쳤을 경우 뒤에 있었던 공을 한칸 뒤로 옮긴다.
//        이동 거리가 멂 == 뒤에 있던 공이다.
        if (isSameCoordinate(nextRedBall, nextBlueBall)) {
          if (redBallMovingCount < blueBallMovingCount) {
            nextBlueBall.moveBack(i);
          } else {
            nextRedBall.moveBack(i);
          }
        }

        nextRedBall.setBlueBall(nextBlueBall);

        if (!nextRedBall.isVisited()) {
          nextRedBall.checkVisit();
          queue.add(nextRedBall);
        }
      }
    }

    System.out.println(-1);
  }

  static int movingBall(Coordinate ball, int movingIdx) {
    int count = 0;

    while (true) {
      ball.move(movingIdx);
      if (ball.isHole()) {
        return -1;
      } else if (ball.isValid()) {
        count++;
      } else {
        ball.moveBack(movingIdx);
        break;
      }
    }

    return count;
  }

  static boolean isSameCoordinate(Coordinate nextRedBall, Coordinate nextBlueBall) {
    return nextRedBall.row == nextBlueBall.row && nextRedBall.column == nextBlueBall.column;
  }

  static class Coordinate {
    int row;
    int column;
    int count;
    Coordinate blueBall;

    public Coordinate(int row, int column, int count) {
      this.row = row;
      this.column = column;
      this.count = count;
    }

    void setBlueBall(Coordinate blueBall) {
      this.blueBall = blueBall;
    }

    boolean isValid() {
      return isValidCoordinate() && canMove();
    }

    boolean canMove() {
      return graph[row][column] != '#';
    }

    boolean isValidCoordinate() {
      return (0 <= row && row < graph.length) && (0 <= column && column < graph[0].length);
    }

    boolean isVisited() {
      return visited[row][column][this.blueBall.row][this.blueBall.column];
    }

    void checkVisit() {
      visited[row][column][this.blueBall.row][this.blueBall.column] = true;
    }

    boolean isHole() {
      return row == hole.row && column == hole.column;
    }

    void moveBack(int movingIdx) {
      this.row -= rowDirection[movingIdx];
      this.column -= columnDirection[movingIdx];
    }

    void move(int movingIdx) {
      this.row += rowDirection[movingIdx];
      this.column += columnDirection[movingIdx];
    }
  }
}

/* 반례

7 8
########
#.#O.#R#
#....#B#
#.#....#
#......#
#......#
########
=> 9

10 10
##########
#RB....#.#
#..#.....#
#........#
#.O......#
#...#....#
#........#
#........#
#.......##
##########
=> 10

------------
https://www.acmicpc.net/board/view/76574
6 7
#######
#R....#
#.....#
#..O..#
#..B..#
#######
답:3

3 5
#####
#OBR#
#####
answer=-1

5 7
#######
#.RB###
#.#.#O#
#.....#
#######
answer=4

<아래 테케에서 실패. 11번인데 왜 출력되노)
11 13
#############
#.RB#########
#.#.........#
#.#.#######.#
#.#.#.....#.#
#.#.#..O#.#.#
#.#.#####.#.#
#.#.......#.#
#.#########.#
#...........#
#############
answer=-1 (11번)

------------
https://www.acmicpc.net/board/view/76729

3 6
######
#.ORB#
######
ANS:-1

8 8
########
#.####.#
#...#B##
#.##.R.#
######.#
##.##O.#
###.##.#
########
ANS:7

4 6
######
#R####
#B..O#
######
ANS:-1

4 6
######
#R#O##
#B...#
######
ANS:4
*/