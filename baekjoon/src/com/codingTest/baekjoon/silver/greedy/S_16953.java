package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class S_16953 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    int count = 1;
    while (b != a) {
      if (b < a) {
        count = -1;
        break;
      }

      String strB = b + "";
      if (strB.charAt(strB.length() - 1) == '1') {
        b /= 10;
      }
      /*
        String strB = b + "";
        if (strB.charAt(strB.length() - 1) == '1') {
          b /= 10;
        }
        이 부분은

        if(b % 10 == 1){
          b /= 10;
        }
        으로 바꾸어도 되네...
       */
      else {
//         아래 if 문 추가해주니 풀렸음... 반례를 찾는 것이 어렵네ㅠㅠ
        if (b % 2 == 1) {
          count = -1;
          break;
        }
        b /= 2;
      }

      count++;
    }

    System.out.print(count);
  }
}
