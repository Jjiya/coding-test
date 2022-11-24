package com.codingTest.baekjoon.silver.graph;

import java.io.*;
import java.util.StringTokenizer;

public class S_1012 {
  static int[][] cabbage;
  //  동 남 서 북 순서 탐색
  static int[] rowDirection = {0, 1, 0, -1};
  static int[] columnDirection = {1, 0, -1, 0};

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    outer:
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());

      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      cabbage = new int[n][m];

      int k = Integer.parseInt(st.nextToken());

//      배추 위치 저장
      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        cabbage[y][x] = 1;
      }

/*
  원래 k변수 할당하는 곳에 아래 if문 나뒀는데,
  br.readLine()을 안한채로 넘어가서 런타임 에러 (NoSuchElement) 발생
  (다음 testcase 실행 시 이전 testcase 입력 값이 저장됨)
 */
      if (k == 1) {
        sb.append("1\n");
        continue;
      }

      int area = 0;
      int cabbageCount = 0;
      for (int j = 0; j < n; j++) {
        for (int l = 0; l < m; l++) {
//          배추가 심어져 있을때만 탐색
          if (cabbage[j][l] != 0) {
            cabbageCount += adjoiningCount(j, l);
            area++;

//            배추의 위치를 모두 탐색했다면 반복문 종료 시킴
            if (cabbageCount == k) {
              sb.append(area).append("\n");
              continue outer;
            }
          }
        }
      }

      sb.append(area).append("\n");
    } // end outer for

    System.out.print(sb);
  }

  /**
   * 인접한 배추의 개수를 구한다.
   *
   * @param rowIdx    몇번째 행인지
   * @param columnIdx 몇번째 열인지
   * @return 현재 값과 이어져있는 배추의 개수
   */

  static int adjoiningCount(int rowIdx, int columnIdx) {
    if (isCanCounting(rowIdx, columnIdx)) {
      int count = cabbage[rowIdx][columnIdx];
      cabbage[rowIdx][columnIdx] = 0;

      for (int i = 0; i < 4; i++) {
        count += adjoiningCount(rowIdx + rowDirection[i], columnIdx + columnDirection[i]);
      }

      return count;
    } else {
      return 0;
    }
  }

  static boolean isCanCounting(int row, int column) {
    return (0 <= row && row < cabbage.length) && (0 <= column && column < cabbage[0].length) && cabbage[row][column] == 1;
  }
}
