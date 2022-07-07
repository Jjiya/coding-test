package com.codingTest.baekjoon.silver.recursive;

import java.io.*;

public class S_11729 {
  StringBuilder sb = new StringBuilder();
  int count = 0;

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    move(n, 1, 3, 2);
    System.out.println(count);
    System.out.print(sb);
  }

  void move(int disk, int from, int to, int other) {
    /* [n번째 원판을 목적지 3번 탑에 옮겨야 함]
     * 1. n번째 보다 1개 위에 있는 원판을 다른 탑에 옮긴다.
     *  >> from -> other / to
     * 2. n번째 원판을 목적지 탑에 옮긴다.
     *  >> from -> to / other
     * 3. n-1번째 원판을 목적지 탑으로 옮긴다.
     *  >> other -> to / from
     */
    count++;

    if (disk != 1) {
      move(disk - 1, from, other, to);
      sb.append(from).append(" ").append(to).append("\n");
      move(disk - 1, other, to, from);
    }else{
      sb.append(from).append(" ").append(to).append("\n");
    }
  }

}
