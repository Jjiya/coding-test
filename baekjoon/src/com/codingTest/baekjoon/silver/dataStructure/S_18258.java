package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S_18258 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();

    int lastValue = -1;
    for (int i = 0; i < n; i++) {
      String command = br.readLine();

      if (6 <= command.length()) {
        int pushValue = Integer.parseInt(command.split("\\s")[1]);
        queue.add(pushValue);
        lastValue = pushValue;
      } else {
        switch (command) {
          case "pop":
            if (!queue.isEmpty()) {
              sb.append(queue.poll()).append("\n");
            } else {
              sb.append(-1).append("\n");
            }
            break;

          case "size":
            sb.append(queue.size()).append("\n");
            break;
          case "empty":
            sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            break;
          case "front":
            if (!queue.isEmpty()) {
              sb.append(queue.peek()).append("\n");
            } else {
              sb.append(-1).append("\n");
            }
            break;
          case "back":
            if (!queue.isEmpty()) {
              sb.append(lastValue).append("\n");
            } else {
              sb.append(-1).append("\n");
            }
            break;
        }
      }
    }
    System.out.print(sb);
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    int[] queue = new int[2000001];
    boolean isEmpty = true;
    int startIdx = 0;
    int lastIdx = 0;
    for (int i = 0; i < n; i++) {
      String command = br.readLine();

      if (6 <= command.length()) {
        int pushValue = Integer.parseInt(command.split("\\s")[1]);
        queue[lastIdx] = pushValue;
        lastIdx++;
        isEmpty = false;
      } else {
        switch (command) {
          case "pop":
            if (isEmpty) {
              sb.append(queue[startIdx]).append("\n");

              for (int j = 1; j < lastIdx; j++) {
                queue[j - 1] = queue[j];
              }
              lastIdx--;
              if (lastIdx == 0) {
                isEmpty = true;
              }
            } else {
              sb.append(-1).append("\n");
            }
            break;

          case "size":
            sb.append(lastIdx).append("\n");
            break;
          case "empty":
            sb.append(isEmpty ? 1 : 0).append("\n");
            break;
          case "front":
            if (isEmpty) {
              sb.append(queue[0]).append("\n");
            } else {
              sb.append(-1).append("\n");
            }
            break;
          case "back":
            if (isEmpty) {
              sb.append(queue[lastIdx - 1]).append("\n");
            } else {
              sb.append(-1).append("\n");
            }
            break;
        }
      }
    }
    System.out.print(sb);
  }
}
