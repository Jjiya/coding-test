package com.codingTest.baekjoon.silver.implement;

import java.io.*;
import java.util.Arrays;

public class S_1475 {
  public void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    0 ~ 8까지만
    int[] roomNumberCount = new int[9];

    String roomNumber = br.readLine();
    for (int roomNum : roomNumber.toCharArray()) {
      roomNum -= 48;
      if (roomNum == 9) {
        roomNumberCount[6]++;
      } else {
        roomNumberCount[roomNum]++;
      }
    }

//    반레: 699 => 2가 나와야하는데, 올림을 안해주면 1이 나오게 됨...
    roomNumberCount[6] = (int) Math.ceil(roomNumberCount[6] / 2.0);

    System.out.print(Arrays.stream(roomNumberCount).max().getAsInt());
  }
}
