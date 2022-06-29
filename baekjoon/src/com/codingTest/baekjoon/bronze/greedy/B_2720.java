package com.codingTest.baekjoon.bronze.greedy;

import java.io.*;

public class B_2720 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int quarter = 25, dime = 10, nickel = 5, penny = 1;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int cent = Integer.parseInt(br.readLine());

      sb.append(cent / quarter).append(" ");
      cent %= quarter;

      sb.append(cent / dime).append(" ");
      cent %= dime;

      sb.append(cent / nickel).append(" ");
      cent %= nickel;

      sb.append(cent / penny).append("\n");
    }

    System.out.print(sb);
  }
}
