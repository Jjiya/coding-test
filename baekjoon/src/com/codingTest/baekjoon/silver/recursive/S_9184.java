package com.codingTest.baekjoon.silver.recursive;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//4번은 틀림...
public class S_9184 {
  static HashMap<String, Integer> result = new HashMap<>();

  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;
    while (!(input = br.readLine()).equals("-1 -1 -1")) {
      st = new StringTokenizer(input);

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
          .append(w(a, b, c)).append("\n");
    }

    System.out.print(sb);
  }

  static int w(int a, int b, int c) {
    String key = a + "," + b + "," + c;

    int rs;

    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    } else if (a > 20 || b > 20 || c > 20) {
      return w(20, 20, 20);
    }

    /*
    처음에 아래  if (result.containsKey(key)) 코드를 맨 위에 적어놨었다.
    계속 틀렸습니다가 떴는데 제출하고 생각해보니 알 것 같다.

    a,b,c가 0 이하일 때와 a,b,c가 20을 초과할 때에도 key는 받아온 숫자 그대로 하고 value만 바꿔줌...
    위의 경우에는 map에 저장할 것이 아니라 값을 변경해서 재귀를 돌리든 값을 return하든 했어야 한 것 같다.
     */
    if (result.containsKey(key)) {
      return result.get(key);
    }

    if (a < b && b < c) {
      rs = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
    } else {
      rs = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    result.put(key, rs);

    return rs;
  }

  /* ************************************ */
  static StringBuilder sb;
  static int[] kList;

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String n = st.nextToken();
    int k = Integer.parseInt(st.nextToken());

    sb = new StringBuilder(n.length());
    kList = new int[k];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      kList[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(kList);

    saveMaxValue(n, 0);

    System.out.print(sb);
  }

  static void saveMaxValue(String n, int index) {
    if (index >= kList.length) {
      return;
    }

    if (index == 0) {
      int nValue = n.charAt(index) - 48;

      for (int i = kList.length - 1; i >= 0; i--) {
        if (kList[i] <= nValue) {
          sb.append(kList[i]);
          break;
        }
      }
      saveMaxValue(n, index + 1);
    } else {
      sb.append(kList[kList.length - 1]);
      saveMaxValue(n, index + 1);
    }
  }
}

