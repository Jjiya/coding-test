package com.codingTest.baekjoon.bronze.string;

import java.io.*;
import java.util.HashMap;

public class B_2754 {
  public void test() throws IOException {
    HashMap<String, Double> grade = new HashMap<>();
    grade.put("A+", 4.3);
    grade.put("A0", 4.0);
    grade.put("A-", 3.7);

    grade.put("B+", 3.3);
    grade.put("B0", 3.0);
    grade.put("B-", 2.7);

    grade.put("C+", 2.3);
    grade.put("C0", 2.0);
    grade.put("C-", 1.7);

    grade.put("D+", 1.3);
    grade.put("D0", 1.0);
    grade.put("D-", 0.7);

    grade.put("F", 0.0);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print(grade.get(br.readLine()));
  }
}
