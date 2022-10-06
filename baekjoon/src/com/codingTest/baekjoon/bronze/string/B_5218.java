package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.StringTokenizer;

public class B_5218 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCaseCount = Integer.parseInt(br.readLine());
    StringTokenizer st;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < testCaseCount; i++) {
      sb.append("Distances:");
      st = new StringTokenizer(br.readLine());
      String x = st.nextToken();
      String y = st.nextToken();

      for (int j = 0; j < x.length(); j++) {
        int charX = x.charAt(j);
        int chary = y.charAt(j);

        sb.append(" ");
        if (charX > chary) {
          sb.append((chary + 26) - charX);
        } else {
          sb.append(chary - charX);
        }
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
