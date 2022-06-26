package com.codingTest.baekjoon.yonseiUnivOpenContest;

import java.io.*;
import java.util.StringTokenizer;

public class C_25306 {

  //  문제 이해 잘못해서 다시 ㅎㅎ
//  두 수의 xor이 아닌 두 수 사이의 xor이였음
  public void test() throws IOException {
//    런타임에러 >> 최대 10^18자리까지 나오므로 String을 int로 변환 시 에러 발생
//    Exception in thread "main" java.lang.NumberFormatException: For input string: "1000000000000000000"
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

    String firstBinary = Integer.toBinaryString(a);
    String secondBinary = Integer.toBinaryString(Math.min(a + 1, b));

    StringBuilder firstXOR = new StringBuilder();

    firstXOR.append(getXOR(firstBinary, secondBinary));

    a += 2;

    StringBuilder resultXOR = firstXOR;
    for (int i = a; i <= b; i++) {
      resultXOR = new StringBuilder();
      secondBinary = Integer.toBinaryString(i);

      resultXOR.append(getXOR(firstXOR.toString(), secondBinary));

      firstXOR = resultXOR;
    }
    System.out.print(Integer.parseInt(resultXOR.toString(), 2));
  }

  String getXOR(String binary_1, String binary_2) {
    StringBuilder resultXOR = new StringBuilder();

    int maxLength = Math.max(binary_1.length(), binary_2.length());

    int firstLengthDiff = maxLength - binary_1.length();
    int secondLengthDiff = maxLength - binary_2.length();

    for (int i = 0; i < maxLength; i++) {
      char aBinary = (i < firstLengthDiff) ? '0' : binary_1.charAt(i - firstLengthDiff);
      char bBinary = (i < secondLengthDiff) ? '0' : binary_2.charAt(i - secondLengthDiff);

      resultXOR.append(aBinary == bBinary ? '0' : '1');
    }

    return resultXOR.toString();
  }

  public void test1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] strs = br.readLine().split("\\s");

    String a = Integer.toBinaryString(Integer.parseInt(strs[0]));
    String b = Integer.toBinaryString(Integer.parseInt(strs[1]));

    System.out.println(a + " " + b);
    int maxLength = Math.max(a.length(), b.length());
/*
xor 연산
011
100
===
111
같으면 0 다르면 0
 */

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxLength; i++) {
//    5 3
//    i a[i]
//    0 x
//    1 x >>5-3 2번째까지는 0이다 이말이여~~
//    2 0 >>max-length-i
//    3 1
//    4 2

//    3 2
//    0 x >> 3-2인 한가지는 0반환
//    1 0
//    2 1
      char aBinary = (i < maxLength - a.length()) ? '0' : a.charAt(i - (maxLength - a.length()));
      char bBinary = (i < maxLength - b.length()) ? '0' : b.charAt(i - (maxLength - b.length()));
      System.out.printf("%c == %c (%b) => %c %n", aBinary, bBinary, aBinary == bBinary, (aBinary == bBinary ? '0' : '1'));
      sb.append(aBinary == bBinary ? '0' : '1');
    }

    System.out.println(sb);
    System.out.println(Integer.parseInt(sb.toString(), 2));
  }
}
