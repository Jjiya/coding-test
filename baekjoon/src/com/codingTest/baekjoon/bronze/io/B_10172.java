package com.codingTest.baekjoon.bronze.io;

public class B_10172 {
  public static void test() {
    System.out.println("|\\_/|");
    System.out.println("|q p|   /}");
    System.out.println("( 0 )\"\"\"\\");
    System.out.println("|\"^\"`    |");
    System.out.print("||_/=\\\\__|");
  }

  public static void test4() {
    System.out.print(
        "|\\_/|\n" +
            "|q p|   /}\n" +
            "( 0 )\"\"\"\\\n" +
            "|\"^\"`    |\n" +
            "||_/=\\\\__|"
    );
  }

  public static void test2() {
    StringBuilder sb = new StringBuilder();
    sb.append("|\\_/|").append("\n")
        .append("|q p|   /}").append("\n")
        .append("( 0 )\"\"\"\\").append("\n")
        .append("|\"^\"`    |").append("\n")
        .append("||_/=\\\\__|");

    System.out.println(sb);
  }

  public static void test3() {
    StringBuilder sb = new StringBuilder();
    sb.append("|\\_/|\n" +
        "|q p|   /}\n" +
        "( 0 )\"\"\"\\\n" +
        "|\"^\"`    |\n" +
        "||_/=\\\\__|");

    System.out.println(sb);
  }
}
