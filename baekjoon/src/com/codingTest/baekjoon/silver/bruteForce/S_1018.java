package com.codingTest.baekjoon.silver.bruteForce;

import java.io.*;
import java.util.*;

public class S_1018 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int height = Integer.parseInt(st.nextToken()), width = Integer.parseInt(st.nextToken());

    String[][] chess = new String[height][width];

    for (int i = 0; i < height; i++) {
      chess[i] = Arrays.copyOf(br.readLine().split(""), width);
    }

    int minimum = Integer.MAX_VALUE;
    outer:
    for (int i = 0; i <= height - 8; i++) {
      for (int j = 0; j <= width - 8; j++) {
        int drawCount = 0;

        for (int h = i; h < i + 8; h++) {
          for (int w = j; w < j + 8; w++) {
            if (h % 2 == 0) { // 짝수 줄 W부터 시작
              if (w % 2 == 0 && "B".equals(chess[h][w])) drawCount++;
              else if (w % 2 == 1 && "W".equals(chess[h][w])) drawCount++;
            } else {  //홀수 줄 B부터 시작
              if (w % 2 == 0 && "W".equals(chess[h][w])) drawCount++;
              else if (w % 2 == 1 && "B".equals(chess[h][w])) drawCount++;
            }
          }
        }
        minimum = Math.min(minimum, Math.min(drawCount, 8 * 8 - drawCount));
        if (minimum == 0) break outer;
      }
    }

    System.out.print(minimum);
  }
}
/*

10 10
1234567890
abcdefghij
1234567890
abcdefghij
1234567890
abcdefghij
1234567890
abcdefghij
1234567890
abcdefghij
 */