package com.codingTest.baekjoon.bronze.conditional;

import java.io.*;
import java.util.ArrayList;

public class B_2525 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String tmp = "";
    ArrayList<Integer> inputs = new ArrayList<>();

    while ((tmp = br.readLine()) != null) {
      if (tmp.equals("s")) break;  //지워라 올릴때

      if (inputs.isEmpty()) {
        String[] nowTime = tmp.split("\\s");
        inputs.add(Integer.parseInt(nowTime[0]));
        inputs.add(Integer.parseInt(nowTime[1]));
      } else {
        inputs.add(Integer.parseInt(tmp));
      }
    }

    int hour = inputs.get(0);
    int minute = inputs.get(1) + inputs.get(2);

    while (60 <= minute) {
      hour += 1;
      minute -= 60;
    }
    if (24 <= hour) hour -= 24;

    System.out.printf("%d %d", hour, minute);
  }
}
