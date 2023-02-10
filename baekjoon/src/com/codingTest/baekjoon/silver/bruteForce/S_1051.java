package com.codingTest.baekjoon.silver.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class S_1051 {
  // https://www.acmicpc.net/problem/1051
  public static void test() throws IOException {
    M2.test();
  }

  static class M2 {
    /*
      for문 돌리면서
      각 방향으로 뻗어나가면서 숫자가 같은지 체크하면 될 듯
      42101
      22100
      22101
      의 경우
      4를 꼭지점으로 잡고
      오른쪽, 아래쪽, 대각선 오른쪽으로 +1씩 뻗어나가며 최개 개수를 체크한다.

      역시.. 브루트포스였음
      제한 시간 2초에서 힌트 얻음. 최대 값이 50인데 2초길래 O(N^2)구나 싶어서 위의 방법을 생각해내었음
      dp치곤 모든 경우의 수를 탐색하였기에 브루트포스인듯
    */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int min = Math.min(n, m);

      if (min == 1) {
        System.out.print(1);
        return;
      }

      char[][] rectangle = new char[n][m];

      for (int i = 0; i < n; i++) {
        rectangle[i] = br.readLine().toCharArray();
      }

      int[][] counting = new int[n][m];
      int maxArea = 1;

      for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < m - 1; j++) {
          char left = rectangle[i][j];

          for (int k = 1; k <= min; k++) {
            try {
              char right = rectangle[i][j + k];
              char rightDiagonal = rectangle[i + k][j];
              char bottom = rectangle[i + k][j + k];

              if ((left == right && right == rightDiagonal && rightDiagonal == bottom)) {
                counting[i][j] = k + 1;
              }
            } catch (IndexOutOfBoundsException e) {
              break;
            }
          }

          maxArea = Math.max(maxArea, (int) Math.pow(counting[i][j], 2));
        }
      }

      System.out.print(maxArea);
    }
  }

  static class M1 {
    // 뭘 하려고 했던 건지 기억이 안남
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

//    int[][] rectangle = new int[m][n];
      String[] rectangle = new String[n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        rectangle[i] = st.nextToken();
      }
      int max = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int num = rectangle[i].charAt(j) - 48;
        }
      }
    }
  }
}
