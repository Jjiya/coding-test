package com.codingTest.baekjoon.silver.greedy;

import java.io.*;

public class S_1213 {
  // https://www.acmicpc.net/problem/1213
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    int length = input.length();
    int[] count = new int[26];

    for (char alphabet : input.toCharArray()) {
      count[alphabet - 65]++;
    }

    char[] result = new char[length];

    int idx = 0;

    for (int i = 0; i < 26; i++) {
      char alphabet = (char) (i + 65);

//      알파벳이 2개 이상 남았다면 2개씩 짝지어서 앞 뒤로 대칭 배치 
      while (2 <= count[i]) {
        result[idx] = result[length - idx - 1] = alphabet;
        count[i] -= 2;

        idx++;
      }

      if (count[i] == 1) {  // 아직 할당안된 알파벳이 남아있음
        if (length % 2 == 1 && !Character.isLetter(result[length / 2])) {
//          글자의 길이가 홀수이면서 아직 할당 기회가 남았으면 할당해주고
          result[length / 2] = alphabet;
        } else {
//          아니면 바로 종료
          System.out.print("I'm Sorry Hansoo");
          return;
        }
      }
    }

    System.out.print(result);
  }
}
