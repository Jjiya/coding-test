package com.codingTest.baekjoon.gold.dataStructure;

import java.io.*;
import java.util.Stack;

public class G_9935 {
  public void test() throws IOException {
//    음...ㅎㅎ
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String bomb = br.readLine();

    Stack<Character> bombResult = new Stack<>();

    StringBuilder sbStack = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sbStack.append(str.charAt(i));
      if (sbStack.length() == bomb.length()) {
        if (sbStack.toString().equals(bomb)) {
          
        } else {

        }
      }
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
