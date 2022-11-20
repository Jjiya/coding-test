package com.codingTest.baekjoon.silver.backTracking;

import java.io.*;
import java.util.Arrays;

public class S_16922 {
  /*
    int[] sum = new int[50 * 20 + 1];

    rome 의 최대 값 50, 최대 사용 가능한 문자의 개수의 최대 값 n은 20
    50을 20번 더하면 1000이라서 범위를 이렇게 잡는듯?
    => L이 20번 나오는 경우가 최대 값임

    그럼 생성할 때 new int[50 * n + 1]로 해줘도 될 듯?
   */

  static int[] rome = {1, 5, 10, 50};
  static int[] sumList;
  static int n;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    sumList = new int[50 * n + 1];  // rome 숫자의 최대 값 50이 n번 나왔을 때의 경우(= 나올 수 있는 가장 큰 값)를 배열 길이로 잡는다.

    bt(0, 0, 0);

//    값이 0이 아니다 = 합계의 경우의 수에 포함됨 (따로 count 변수 만들지 않고, stream 이용)
    System.out.print(Arrays.stream(sumList).sum());
  }

  static void bt(int start, int depth, int sum) {
    if (depth == n) {
      if (sumList[sum] == 0) {
        sumList[sum] = 1;
      }
      return;
    }

    /* sum에 값을 저장하면 다시 빼줘야하고
      for (int i = start; i < rome.length; i++) {
        sum += rome[i];
        bt(i, depth + 1, sum);
        sum -= rome[i]; // sum을 현재 rome[i]을 더하지 않았던 상태로 원복
      }

      아니라면 아래처럼 하면 되네..
      
      제출은 위의 주석 처리한 코드로 했음
     */
    for (int i = start; i < rome.length; i++) {
      bt(i, depth + 1, sum + rome[i]);
    }
  }

  /*


  static int n;
  static char[] rome = {4, 3, 2, 1};


  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    if (n == 1) {
      System.out.print(4);
      return;
    }
    System.out.println(bt(0, 0));
  }



    n = 10일때
    정답: 244
    출력: 286
    >> 알파벳 조합은 unique하게 나올지 몰라도 각 숫자의 합은 겹치는 경우가 생기기때문에 이렇게 풀면 안된다고 함..
  static int bt(int idx, int depth) {
    if (depth + 1 == n) {
      return rome[idx];
    }

    int rs = 0;

    for (int i = idx; i < 4; i++) {
      rs += bt(i, depth + 1);
    }

    return rs;
  }
   */
}
