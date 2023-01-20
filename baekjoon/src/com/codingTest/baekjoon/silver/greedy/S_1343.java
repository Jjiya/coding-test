package com.codingTest.baekjoon.silver.greedy;

import java.io.*;

public class S_1343 {
  // https://www.acmicpc.net/problem/1343
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String board = br.readLine();

    int saveX = 0;
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < board.length(); i++) {
      if (saveX == 4) {
        result.append("AAAA");
        saveX = 0;
      }

      if (board.charAt(i) == 'X') {
        saveX++;
        continue;
      }

      if (saveX % 2 != 0) {
        System.out.print(-1);
        return;
      }

      if (saveX == 2) {
        result.append("BB");
        saveX = 0;
      }

      result.append('.');
    }

    if (saveX % 2 != 0) {
      System.out.print(-1);
      return;
    }

    if (saveX == 4) {
      result.append("AAAA");
    } else if (saveX == 2) {  // 여기 그냥 else로 하니까 saveX가 0일때 BB가 저장되어서 틀리게 되었음!! 바보야
      result.append("BB");
    }

    System.out.print(result);
  }
}
/*
XXXX.XXXXXX...XXXXXXXXXX
 */