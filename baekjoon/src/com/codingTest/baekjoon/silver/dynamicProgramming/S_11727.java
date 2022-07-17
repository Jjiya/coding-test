package com.codingTest.baekjoon.silver.dynamicProgramming;

import java.io.*;

//참고: https://jaemin8852.tistory.com/158
public class S_11727 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] tiles = new int[n];
    tiles[0] = 1;
    tiles[1] = 3;

    for (int i = 2; i <= n; i++) {
      tiles[i] = (tiles[i - 1] + (2 * tiles[i - 2])) % 10007;
    }
    System.out.print(tiles[n - 1]);
  }
}
