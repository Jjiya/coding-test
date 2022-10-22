package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class S_1406 {
  /*
      linkedlist 시간 초과 이유
      https://www.acmicpc.net/board/view/95481

      스택 2개 힌트
      https://www.acmicpc.net/board/view/96726
   */
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<Character> beforeCursor = new Stack<>();
    Stack<Character> afterCursor = new Stack<>();

    String memo = br.readLine();

    for (char word : memo.toCharArray()) {
      beforeCursor.push(word);
    }

    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      String command = br.readLine();

      switch (command) {
        case "L":
          if (!beforeCursor.isEmpty()) {
            char word = beforeCursor.pop();
            afterCursor.push(word);
          }
          break;
        case "D":
          if (!afterCursor.isEmpty()) {
            char word = afterCursor.pop();
            beforeCursor.push(word);
          }
          break;
        case "B":
          if (!beforeCursor.isEmpty()) {
            beforeCursor.pop();
          }
          break;
        default:
          char word = command.charAt(2);
          beforeCursor.push(word);
          break;
      }
    }

    StringBuilder sb = new StringBuilder();
    beforeCursor.forEach(sb::append);

    StringBuilder sb2 = new StringBuilder();
    afterCursor.forEach(sb2::append);
    sb2.reverse();
    sb.append(sb2);

    System.out.print(sb);
  }

  //   시간 초과
  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<Character> memo = new LinkedList<>();

    String baseMemo = br.readLine();

    for (char word : baseMemo.toCharArray()) {
      memo.add(word);
    }

    int cursorIdx = baseMemo.length();
    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      String command = br.readLine();

      switch (command) {
        case "L":
          cursorIdx = Math.max(cursorIdx - 1, 0);
          break;
        case "D":
          cursorIdx = Math.min(cursorIdx + 1, memo.size());
          break;
        case "B":
          if (cursorIdx != 0) {
            memo.remove(cursorIdx - 1);
            cursorIdx--;
          }
          break;
        default:
          char word = command.charAt(2);
          memo.add(cursorIdx, word);
          cursorIdx++;
          break;
      }
    }

    StringBuilder sb = new StringBuilder();
    memo.forEach(sb::append);

    System.out.print(sb);
  }
}
