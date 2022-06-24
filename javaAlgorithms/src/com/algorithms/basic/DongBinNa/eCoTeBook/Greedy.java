package com.algorithms.basic.DongBinNa.eCoTeBook;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy {
  public static void main(String[] args) throws IOException {
    new Greedy().greedy1();
  }

  //  https://youtu.be/2zjoKjt97vQ
//  아직 확실히 이해 못함...
  public void greedy1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

    int result = 0;
    while (true) {
      int target = (n / k) * k;
      result += (n - target);
      n = target;
      if (n < k) break;
      result += 1;
      n /= k;
    }
    result += (n - 1);
    System.out.print(result);
  }

  public void greedy1_MySolution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

    int count = 0;
    while (n != 1) {
      n = (n % k == 0) ? n / k : n - 1;
      count++;
    }
    System.out.print(count);
  }

}