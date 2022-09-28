package com.codingTest.baekjoon.bronze.basicMath1;

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class B_10156 {
  public void test() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int diff = (k * n) - m;

    System.out.print(Math.max(diff, 0));
  }

  public void test1() {
    Scanner scanner = new Scanner(System.in);

    int k = scanner.nextInt();
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    int diff = (k * n) - m;

    System.out.print(Math.max(diff, 0));
  }
}
