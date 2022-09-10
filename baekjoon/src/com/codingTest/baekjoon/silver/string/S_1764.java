package com.codingTest.baekjoon.silver.string;

import java.io.*;
import java.util.HashSet;

public class S_1764 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split("\\s");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    HashSet<String> nSet = new HashSet<>();

    for (int i = 0; i < n; i++) {
      nSet.add(br.readLine());
    }
    int count = 0;

    HashSet<String> list = new HashSet<>();
    for (int j = 0; j < m; j++) {
      String name = br.readLine();
      if (nSet.contains(name)) {
        count++;
        list.add(name);
      }
    }

    System.out.println(count);
    list.stream().sorted().forEach(System.out::println);
  }
}
