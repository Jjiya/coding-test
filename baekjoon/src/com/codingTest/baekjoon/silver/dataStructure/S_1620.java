package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class S_1620 {
  // https://www.acmicpc.net/problem/1620
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<Integer, String> pokemonKey = new HashMap<>(n);
    HashMap<String, Integer> pokemonName = new HashMap<>(n);
    Hashtable<Integer, String> p = new Hashtable<>();

    for (int i = 1; i <= n; i++) {
      String name = br.readLine();

      pokemonKey.put(i, name);
      pokemonName.put(name, i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String key = br.readLine();

      if ('0' <= key.charAt(0) && key.charAt(0) <= '9') {
        sb.append(pokemonKey.get(Integer.parseInt(key)));
      } else {
        sb.append(pokemonName.get(key));
      }

      sb.append("\n");
    }

    System.out.print(sb);
  }
}
