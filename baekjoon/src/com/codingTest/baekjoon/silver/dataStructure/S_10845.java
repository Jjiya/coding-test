package com.codingTest.baekjoon.silver.dataStructure;

import java.io.*;

public class S_10845 {
  /*
    0 1 2 3 4 5 6 7 8 9
    0 0 5 7 6 2 1 7 5 6
    n = 10 / count = 8

    i = n-count;
 */
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] queue = new int[n];
    int count = 0;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      switch (input) {
        case "pop": //큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          if (count == 0) {
            sb.append(-1);
          } else {
            sb.append(queue[n - 1]);
            for (int j = n - 1; j > n - count - 1; j--) {
              queue[j] = queue[j - 1];
            }
            count--;
          }
          break;
        case "size":  //큐에 들어있는 정수의 개수를 출력한다.
          sb.append(count);
          break;
        case "empty": //큐가 비어있으면 1, 아니면 0을 출력한다.
          sb.append(count == 0 ? 1 : 0);
          break;
        case "front": //큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          sb.append(count == 0 ? -1 : queue[n - 1]);
          break;
        case "back":  //큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
          sb.append(count == 0 ? -1 : queue[n - count]);
          break;
        default:  //push X: 정수 X를 큐에 넣는 연산이다.
          queue[n - count - 1] = Integer.parseInt(input.split("\\s")[1]);
          count++;
          break;
      }

      sb.append("\n");
    }

    System.out.print(sb);
  }
}
