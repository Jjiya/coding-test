package com.codingTest.baekjoon.bronze.conditional;

import java.io.*;
import java.util.*;

public class B_2480 {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().trim().split("\\s");

//    key 중복 없이 결과 담을 hashmap
    HashMap<String, Integer> resultCountList = new HashMap<>();

//    가장 큰 눈의 값
    String maxValueKey = input[0];

    for (int i = 0; i < input.length; i++) {
      String key = input[i];
//      눈이 가장 큰 것 저장
      if (maxValueKey.compareTo(key) < 0) maxValueKey = key;

//      주사위 눈과 해당 눈이 나온 개수를 저장
      Integer value = resultCountList.get(key);
      if (value == null) value = 0;

      resultCountList.put(key, value + 1);
    }

//    같은 눈이 최대 몇번 나왔는지
    Integer maxCount = Collections.max(resultCountList.values());

    if (2 <= maxCount) {  // 2회 이상이라면
//      가장 많이 나온 눈이 무엇인지 찾기
      String maxCountKey = "";
      for (Map.Entry<String, Integer> entry : resultCountList.entrySet()) {
        if (entry.getValue() == maxCount) {
          maxCountKey = entry.getKey();
          break;
        }
      }
      if (maxCount == 3) System.out.print(10000 + (Integer.parseInt(maxCountKey) * 1000));
      else System.out.print(1000 + (Integer.parseInt(maxCountKey) * 100));
    } else {  // 1회씩만 나옴
      System.out.print(Integer.parseInt(maxValueKey) * 100);
    }
  }
}
