package com.codingTest.baekjoon.gold.dataStructure;

import java.io.*;
import java.util.Stack;

public class G_9935 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String bomb = br.readLine();

    Stack<Character> bombResult = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);

      if (bombResult.isEmpty()) {
        if (!(bomb.length() == 1 && bomb.equals(String.valueOf(current)))) {
          bombResult.push(current);
        }
      } else if (current == bomb.charAt(bomb.length() - 1) && bombResult.size() >= bomb.length() - 1) {
//        현재 글자가 폭발 문자열의 마지막 문자와 동일할 때
        StringBuilder bombSb = new StringBuilder();
        bombSb.append(current);

        Stack<Character> subStack = new Stack<>();

        for (int j = 0; j < bomb.length() - 1; j++) {
          char getOne = bombResult.pop();
          subStack.push(getOne);
          bombSb.append(getOne);
        }

        if (!bomb.equals(bombSb.reverse().toString())) {
          while (!subStack.isEmpty()) {
            bombResult.push(subStack.pop());
          }
          bombResult.push(current);
        }
      } else {
        bombResult.push(current);
      }
    }

    if (bombResult.isEmpty()) {
      System.out.print("FRULA");
    } else {
      StringBuilder sb = new StringBuilder();
      bombResult.forEach(sb::append);

      System.out.print(sb);
    }
  }

  //   시간 초과는 안나는데, 메모리 초과 남
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String bomb = br.readLine();

    while (str.contains(bomb)) {
      str = str.replaceAll(bomb, "");
    }

    if (str.equals("")) {
      System.out.print("FRULA");
    } else {
      System.out.print(str);
    }
  }
}
