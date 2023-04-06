package com.codingTest.baekjoon.bronze.implement;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class B_16205 {
  // https://www.acmicpc.net/problem/16205
//  넘 빡구현 문제인듯ㅋㅋㅋ
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    ArrayList<String> separateVariable = separateVariableName(Integer.parseInt(st.nextToken()), st.nextToken());

    StringBuilder[] sbList = new StringBuilder[3];
    for (int i = 0; i < 3; i++) {
      sbList[i] = new StringBuilder();
    }

    for (int i = 0; i < separateVariable.size(); i++) {
      String variable = separateVariable.get(i);

      if (variable.isEmpty()) {
        continue;
      }

      String lowercase = makeLowerCase(variable);
      String uppercase = makeUpperCase(variable);

      if (i == 0) {
        sbList[0].append(lowercase);
        sbList[1].append(lowercase);
        sbList[2].append(uppercase);
      } else {
        sbList[0].append(uppercase);
        sbList[1].append("_").append(lowercase);
        sbList[2].append(uppercase);
      }
    }

    for (StringBuilder sb : sbList) {
      System.out.println(sb);
    }
  }

  static String makeUpperCase(String variable) {
    return String.valueOf(variable.charAt(0)).toUpperCase(Locale.ROOT) + variable.substring(1);
  }

  static String makeLowerCase(String variable) {
    return String.valueOf(variable.charAt(0)).toLowerCase(Locale.ROOT) + variable.substring(1);
  }

  static ArrayList<String> separateVariableName(int variableNum, String variable) {
    ArrayList<String> result = new ArrayList<>();

    StringBuilder sb = new StringBuilder();
    for (char letter : variable.toCharArray()) {
      if (isSeparateLetter(variableNum, letter)) {
        if (sb.length() != 0) {
          result.add(sb.toString());
          sb = new StringBuilder();
        }
      }

      if (letter == '_') {
        continue;
      }
      sb.append(letter);
    }

    result.add(sb.toString());

    return result;
  }

  static boolean isSeparateLetter(int variableNum, char letter) {
    return (variableNum == 2) ? letter == '_' : ('A' <= letter && letter <= 'Z');
  }
}