package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashSet;

public class S_14425 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split("\\s");

    HashSet<String> sList = new HashSet<>();

    for (int i = 0; i < Integer.parseInt(nm[0]); i++) {
      sList.add(br.readLine());
    }

    int count = 0;

    for (int i = 0; i < Integer.parseInt(nm[1]); i++) {
      if (sList.contains(br.readLine())) {
        count++;
      }
    }
    System.out.print(count);
  }
}
