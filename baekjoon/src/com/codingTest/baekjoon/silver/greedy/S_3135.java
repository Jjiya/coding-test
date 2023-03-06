package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_3135 {
  // https://www.acmicpc.net/problem/3135
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int n = Integer.parseInt(br.readLine());

    int min = Math.abs(a - b);

    for (int i = 0; i < n; i++) {
      min = Math.min(min, Math.abs(b - Integer.parseInt(br.readLine())) + 1);
    }

    System.out.print(min);
  }
}
/*
88 17
3
1
42
18

# Answer
2 (예제에서 버튼 순서만 바꾼 것입니다.)

////////////////////////////////

1 100
4
2
3
4
5

# Answer
96
*/
