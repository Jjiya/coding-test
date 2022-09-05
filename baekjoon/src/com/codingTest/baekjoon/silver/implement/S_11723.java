package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_11723 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    boolean[] s = new boolean[21];

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      String command = st.nextToken();
      int x;

      switch (command) {
        case "add":
          x = Integer.parseInt(st.nextToken());
          s[x] = true;
          break;
        case "remove":
          x = Integer.parseInt(st.nextToken());
          s[x] = false;
          break;
        case "check":
          x = Integer.parseInt(st.nextToken());
          sb.append(s[x] ? 1 : 0).append("\n");
          break;
        case "toggle":
          x = Integer.parseInt(st.nextToken());
          s[x] = !s[x];
          break;
        case "all":
          Arrays.fill(s, true);
          break;
        case "empty":
          Arrays.fill(s, false);
          break;
      }
    }

    System.out.print(sb);
  }
}
