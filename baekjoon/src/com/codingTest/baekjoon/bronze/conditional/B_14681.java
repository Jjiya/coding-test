package com.codingTest.baekjoon.bronze.conditional;

import java.io.*;
import java.util.ArrayList;

public class B_14681 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String tmp = "";
    String input = "";

    while ((tmp = br.readLine()) != null) {
      if(tmp.equals("s")) break;
      input += tmp;
    }

    int x = Integer.parseInt(input.split("")[0]);
    int y = Integer.parseInt(input.split("")[1]);

    if (x < 0) {
      System.out.print(y < 0 ? 3 : 2);
    } else if (x > 0) {
      System.out.print(y < 0 ? 4 : 1);
    }
  }
}

/**
 * while (true) {
 * String input = br.readLine().trim();
 * if (input.equals("s")) break;
 * int xDist = input.indexOf("-");
 * int yDist = input.indexOf("-", 1);
 * <p>
 * if(xDist == yDist) System.out.print(1);
 * <p>
 * }
 */
