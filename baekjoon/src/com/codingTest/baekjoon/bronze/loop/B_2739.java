package com.codingTest.baekjoon.bronze.loop;

import java.io.*;

public class B_2739 {
  public static void test() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer input = Integer.parseInt(br.readLine().trim());

    String output = "";
    for(int i=1; i < 10; i++){
      output += input + " * " + i + " = " + input * i + "\n";
    }

    System.out.print(output);
  }
}
