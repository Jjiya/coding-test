package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S_10867 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashSet<Integer> list = new HashSet<>(n);
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    StringBuilder sb = new StringBuilder();

    list.stream().sorted().forEach(num -> sb.append(num).append(" "));
    
    System.out.print(sb);
  }
}
