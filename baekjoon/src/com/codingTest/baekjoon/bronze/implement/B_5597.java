package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.HashSet;

public class B_5597 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<Integer> student = new HashSet<>();

    for (int i = 1; i <= 30; i++) {
      student.add(i);
    }

    for (int i = 0; i < 28; i++) {
      student.remove(Integer.parseInt(br.readLine()));
    }

    student.forEach(System.out::println);
  }
}
