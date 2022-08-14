package com.codingTest.baekjoon.contest.DKSH;

import java.io.*;

public class C {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();

    int count = 0;
    int startIdx = s.indexOf("D");

    if (startIdx != -1) {

      for (int i = startIdx; i < n; i++) {
        if (s.charAt(i) == 'D') {
          int kIdx = s.indexOf("K", i);

          if (kIdx == -1) {
            break;
          }

          for (int j = kIdx; j < n; j++) {
            int sIdx = s.indexOf("S", kIdx);
            if (sIdx == -1) {
              break;
            }

            int hIdx = s.indexOf("H", sIdx);
            if (hIdx == -1) {
              break;
            }

            count++;
          }
        }
      }

    }
    System.out.print(count);
  }
}
