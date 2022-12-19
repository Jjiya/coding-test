package com.codingTest.baekjoon.gold.graph;

import java.io.*;
import java.util.*;

public class G_7569 {
  // https://www.acmicpc.net/problem/7569

  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  static int[][][] tomatoBox;
  static int m;
  static int n;
  static int h;

  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken()); // 열
    n = Integer.parseInt(st.nextToken()); // 행
    h = Integer.parseInt(st.nextToken()); // 면

    int totalCount = m * n * h;

    tomatoBox = new int[h][n][m];

    Queue<TomatoLocation> queue = new LinkedList<>();
    int tomatoCount = 0;

    for (int page = 0; page < h; page++) {
      for (int row = 0; row < n; row++) {
        st = new StringTokenizer(br.readLine());
        for (int col = 0; col < m; col++) {
          tomatoBox[page][row][col] = Integer.parseInt(st.nextToken());

          if (tomatoBox[page][row][col] == 1) {
            queue.offer(new TomatoLocation(page, row, col, 1));
            tomatoCount++;
          } else if (tomatoBox[page][row][col] == -1) {
            tomatoCount++;
          }
        }
      }
    } //상자에 토마토 넣기 끝

    int date = 0;

    if (tomatoCount == totalCount) {
      System.out.println(0);
      return;
    }

    while (!queue.isEmpty()) {
      TomatoLocation currentLocation = queue.poll();

      int count = 0;

      ArrayList<TomatoLocation> nextTomatoes = getNextTomatoes(currentLocation.page, currentLocation.row, currentLocation.col, currentLocation.date);

      if (nextTomatoes.size() == 0) continue;

      for (TomatoLocation next : nextTomatoes) {
        count++;

        next.ripe();
        queue.add(next);
      }

      tomatoCount += count;

      date = Math.max(currentLocation.date, date);
    }

    if (tomatoCount == totalCount) {
      System.out.print(date);
    } else {
      System.out.print(-1);
    }
  }

  public static ArrayList<TomatoLocation> getNextTomatoes(int page, int row, int col, int date) {
    ArrayList<TomatoLocation> tomatoLocations = new ArrayList<>(6);

    for (int i = -1; i <= 1; i++) {
      TomatoLocation nextLocation = new TomatoLocation(page + i, row, col, date + 1);

      if (nextLocation.isValidTomato()) {
        tomatoLocations.add(nextLocation);
      }
    }

    for (int j = 0; j < 4; j++) {
      TomatoLocation nextLocation = new TomatoLocation(page, row + rowDirection[j], col + columnDirection[j], date + 1);

      if (nextLocation.isValidTomato()) {
        tomatoLocations.add(nextLocation);
      }
    }

    return tomatoLocations;
  }

  static class TomatoLocation {
    int page;
    int row;
    int col;
    int date;

    public TomatoLocation(int page, int row, int col, int date) {
      this.page = page;
      this.row = row;
      this.col = col;
      this.date = date;
    }

    public boolean isValidTomato() {
      if (!(0 <= page && page < h)) {
        return false;
      }
      if (!(0 <= row && row < n)) {
        return false;
      }
      if (!(0 <= col && col < m)) {
        return false;
      }

      return tomatoBox[page][row][col] == 0;
    }

    void ripe() {
      tomatoBox[page][row][col] = 2;
    }
  }
}
