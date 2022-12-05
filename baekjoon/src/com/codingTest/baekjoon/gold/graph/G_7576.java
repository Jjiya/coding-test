package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_7576 {
  static int[][] tomato;

  /*
    1번 방법보다 100ms나 더 걸림...
   */
  public void test() throws IOException {
    //  동 남 서 북 순서 탐색
    int[] rowDirection = {0, 1, 0, -1};
    int[] columnDirection = {1, 0, -1, 0};
    Queue<Tomato> ripeTomato = new LinkedList<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    tomato = new int[n][m];

    int tomatoCount = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());

        if (tomato[i][j] == -1) {
          tomatoCount++;
        } else if (tomato[i][j] == 1) {
          ripeTomato.offer(new Tomato(i, j));
          tomatoCount++;
        }
      }
    }

    if (tomatoCount == (m * n)) {
      System.out.println(0);
      return;
    }

    int day = 0;

    while (!ripeTomato.isEmpty()) {
      Tomato currentTomato = ripeTomato.poll();
      int currentX = currentTomato.x;
      int currentY = currentTomato.y;

      for (int i = 0; i < 4; i++) {
        int nextX = currentX + rowDirection[i];
        int nextY = currentY + columnDirection[i];
        Tomato nextTomato = new Tomato(nextX, nextY);

        if (nextTomato.isTomato()) {
          ripeTomato.offer(nextTomato);
          tomato[nextX][nextY] = tomato[currentX][currentY] + 1;
          day = Math.max(tomato[nextX][nextY], day);
          tomatoCount++;
        }
      }
    }

    if (tomatoCount == (m * n)) {
      System.out.print(day - 1);
    } else {
      System.out.print(-1);
    }
  }

  static class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean isTomato() {
      return (0 <= x && x < tomato.length) && (0 <= y && y < tomato[0].length) && tomato[x][y] == 0;
    }
  }
  /* 1번 방법
  static int[][] tomato;
  static Queue<Tomato> ripeTomato = new LinkedList<>();
  static Queue<Tomato> willRipe = new LinkedList<>();
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    tomato = new int[n][m];

    int tomatoCount = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());

        if (tomato[i][j] == -1) {
          tomatoCount++;
        } else if (tomato[i][j] == 1) {
          ripeTomato.offer(new Tomato(i, j));
          tomatoCount++;
        }
      }
    }

    if (tomatoCount == (m * n)) {
      System.out.println(0);
      return;
    }

    int day = 0;
    while (!ripeTomato.isEmpty()) {
      tomatoCount += ripe();

      if (willRipe.isEmpty()) {
        break;
      }

      ripeTomato = willRipe;
      willRipe = new LinkedList<>();

      day++;
    }

    if (tomatoCount == (m * n)) {
      System.out.print(day);
    } else {
      System.out.print(-1);
    }
  }

  static int ripe() {
    int count = 0;
    while (!ripeTomato.isEmpty()) {
      Tomato currentTomato = ripeTomato.poll();
      int currentX = currentTomato.x;
      int currentY = currentTomato.y;

      for (int i = 0; i < 4; i++) {
        int nextX = currentX + rowDirection[i];
        int nextY = currentY + columnDirection[i];
        Tomato nextTomato = new Tomato(nextX, nextY);

        if (nextTomato.isTomato()) {
          willRipe.offer(nextTomato);
          tomato[nextX][nextY] = 1;
          count++;
        }
      }
    }

    return count;
  }

  static class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean isTomato() {
      return (0 <= x && x < tomato.length) && (0 <= y && y < tomato[0].length) && tomato[x][y] == 0;
    }
  }
*/
}
