package com.codingTest.baekjoon.bronze.basicMath1;

import java.io.*;

public class B_5532 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    방학 총 일수
    int l = Integer.parseInt(br.readLine());
//    국어는 총 A페이지
    float a = Float.parseFloat(br.readLine());
//    수학은 총 B페이지
    float b = Float.parseFloat(br.readLine());
//     하루에 국어를 최대 C페이지
    float c = Float.parseFloat(br.readLine());
//     하루에 수학을 최대 D페이지
    float d = Float.parseFloat(br.readLine());

    int completeADay = (int) Math.ceil(a / c);
    int completeBDay = (int) Math.ceil(b / d);
    
    System.out.println(l - Math.max(completeADay, completeBDay));
  }
}
