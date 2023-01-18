package com.codingTest.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1449 {
  // https://www.acmicpc.net/problem/1449
  /*
    물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다. => 뭔 말이지
   */
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    if (l == 1) {
      System.out.print(n);
      return;
    }

    int[] pipe = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      pipe[i] = Integer.parseInt(st.nextToken());
    }

    if (n == 1) {
      System.out.print(1);
      return;
    }

    Arrays.sort(pipe);

    int count = 0;

    for (int i = 0; i < n - 1; i++) {
      int length = 0;
      int beforeLocation = pipe[i];

      for (int j = i + 1; j < n; j++) {
        length += (pipe[j] - beforeLocation);

        if (length < l) {
          beforeLocation = pipe[j];
        } else {
          count++;
          i = j - 1;
          break;
        }
      }
    }

    System.out.print(count + 1);
  }
}
/*
4 5
1 4 5 9
output : 2

1 1000
10
output : 1

4 3
1 2 3 4
output : 2

5 1
1 2 3 4 5
output : 5

5 2
1 2 3 4 5
output : 3

5 2
1 2 100 101 1000
output : 3

5 3
1 2 3 4 1000
output : 3

2 1
3 1
output : 2

2 3
1 1000
output : 2

4 2
4 3 2 1
output : 2

3 4
1 2 3
output : 1

4 2
1 2 100 101
output : 2

2 1000
1 1000
output : 1

 */