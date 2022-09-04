package com.codingTest.baekjoon.silver.sorting;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class S_10814 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<Integer, ArrayList<String>> members = new HashMap<>(n);
    HashSet<Integer> ageList = new HashSet<>(n);
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int age = Integer.parseInt(st.nextToken());
      ageList.add(age);

      ArrayList<String> nameList = members.getOrDefault(age, new ArrayList<>());
      nameList.add(st.nextToken());

      members.put(age, nameList);
    }
    StringBuilder sb = new StringBuilder();

    ageList.stream().sorted().forEach(age ->
      members.get(age).forEach(name ->
        sb.append(age).append(" ").append(name).append("\n")
      )
    );

    System.out.print(sb);
  }
}
