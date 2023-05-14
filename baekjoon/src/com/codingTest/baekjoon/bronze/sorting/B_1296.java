package com.codingTest.baekjoon.bronze.sorting;

import java.io.*;

public class B_1296 {
  // https://www.acmicpc.net/problem/1296
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String yeondoName = br.readLine();

    int L = getLetterCount(yeondoName, "L");
    int O = getLetterCount(yeondoName, "O");
    int V = getLetterCount(yeondoName, "V");
    int E = getLetterCount(yeondoName, "E");

    int n = Integer.parseInt(br.readLine());

    int max = 0;
    String result = "ZZZZZZZZZZZZZZZZZZZZ";

    for (int i = 0; i < n; i++) {
      String teamName = br.readLine();

      int teamL = getLetterCount(teamName, "L");
      int teamO = getLetterCount(teamName, "O");
      int teamV = getLetterCount(teamName, "V");
      int teamE = getLetterCount(teamName, "E");

      int total = sum(L + teamL, O + teamO, V + teamV, E + teamE);

      if (max < total) {
        max = total;
        result = teamName;
      } else if (max == total) {
        if (result.compareTo(teamName) > 0) {
          result = teamName;
        }
      }
    }

    System.out.print(result);
  }

  static int getLetterCount(String name, String findLetter) {
    return name.length() - name.replaceAll(findLetter, "").length();
  }

  static int sum(int L, int O, int V, int E) {
    return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
  }
}
