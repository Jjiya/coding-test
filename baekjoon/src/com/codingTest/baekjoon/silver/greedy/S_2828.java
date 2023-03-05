package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_2828 {
  // https://www.acmicpc.net/problem/2828
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 스크린 칸
    int m = Integer.parseInt(st.nextToken()); // 바구니 길이

    int j = Integer.parseInt(br.readLine());

    int basketStartPoint = 1;
    int basketEndPoint = basketStartPoint + m - 1;
    int movingSum = 0;

    for (int i = 0; i < j; i++) {
      int currentDrop = Integer.parseInt(br.readLine());

      if (currentDrop < basketStartPoint) { // 사과가 바구니보다 왼쪽에 떨어질 때
        movingSum += (basketStartPoint - currentDrop);

        basketStartPoint = currentDrop;
        basketEndPoint = basketStartPoint + m - 1;
      }else if (basketEndPoint < currentDrop) { // 사과가 바구니보다 오른쪽에 떨어질 때
        movingSum += (currentDrop - basketEndPoint);

        basketEndPoint = currentDrop;
        basketStartPoint = basketEndPoint - m + 1;
      }
    }

    System.out.print(movingSum);
  }

  static class M1 {
    /*
    무조건 사과가 떨어지는 위치를 기준으로 바구니를 옮기려고 해서
    바구니를 최소로 움직이지 못함...

    현재 위치보다 왼쪽에 떨어질 때와 오른쪽에 떨어질 때를 분기로 나누어 계산해야한다.
    https://dheldh77.tistory.com/entry/%EB%B0%B1%EC%A4%80-2828%EB%B2%88-%EC%82%AC%EA%B3%BC-%EB%8B%B4%EA%B8%B0-%EA%B2%8C%EC%9E%84
     */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken()); // 스크린 칸
      int m = Integer.parseInt(st.nextToken()); // 바구니 길이

      int j = Integer.parseInt(br.readLine());

      int basketStartPoint = 1;
      int basketEndPoint = basketStartPoint + m - 1;
      int movingSum = 0;

      for (int i = 0; i < j; i++) {
        int currentDrop = Integer.parseInt(br.readLine());

        if (basketStartPoint <= currentDrop && currentDrop <= basketEndPoint) {
          continue;
        }

        int movingEndPoint = currentDrop + m - 1;

        if (n < movingEndPoint) {
          currentDrop = (movingEndPoint - m);
          movingEndPoint = n;
        }

        movingSum += Math.abs(currentDrop - basketStartPoint);  // 기존 위치에서 움직인 위치 거리 구하기
        basketStartPoint = currentDrop; // 바구니 시작 지점 갱신
        basketEndPoint = movingEndPoint;  // 바구니 끝 점 갱신
      }

      System.out.print(movingSum);
    }
  }

/*  반례
입력값
5 2
2
5
1

기대값
6

input
5 2
4
1
5
1
5

answer
9

9 1
4
5
6
1
7

정답: 16

10 2
7
5
6
9
4
5
9
9

정답: 15

7 4
7
1
7
5
1
3
5
2

정답: 7
 */
}
/*
  a
l 1 l 2 l 3 l 4 l 5 l
[       ]
                 a
l 1 l 2 l 3 l 4 l 5 l
                [       ]

1 - 2

5 - 6 => 4 - 5
튀어나간 길이 - 바구니 길이
 */
