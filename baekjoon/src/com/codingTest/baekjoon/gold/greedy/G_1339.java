package com.codingTest.baekjoon.gold.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class G_1339 {
  // https://www.acmicpc.net/problem/1339
  public static void test() throws IOException {
    M3.test();
  }

  static class M3 {
    // 참고: https://www.acmicpc.net/source/7749773
    /*
      순서를 알파벳에 숫자를 더하는 방식으로 풀지 않아도 된다는 것을 알게 됨!!
      알파벳 별로 나온 값을 저장한 후, 제일 많이 나온 값에 9부터 차례대로 부여하면 되는거였음
      단어가 ㄱ: "ABC", ㄴ: "BAA"이면
      ㄱ에서 A가 100의 자리에 나왔으니 배열 A 값 +=100
      B는 10의 자리이니 배열 B += 10
      C는 1의 자리 배열 C += 1

      ㄴ에서 B가 100의 자리 -> 배열 B의 값 += 100
      A가 10의 자리, 1의자리 -> 배열 A의 값 += 10, += 1

      이런식으로 한 후 배열을 sorting한 후 9~1까지 대입...
     */

    /* 얘는 나오지 않은 알파벳을 alphabetList에서 filter로 제거한 후 채점하는것.. 시간 차이가 얼마나 나려나
        => filter로 전체 탐색을 하고, 배열을 새로 만드는 등... 역시 시간이 더 든다!
        메모리
        11548 -> 18628  kb
        시간
        80 -> 232 ms
     */
    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] alphabetList = new int[26];

      for (int i = 0; i < n; i++) {
        String input = br.readLine();
        for (int j = 0; j < input.length(); j++) {
          alphabetList[input.charAt(j) - 65] += (int) Math.pow(10, input.length() - j - 1);
        }
      }

      alphabetList = Arrays.stream(alphabetList).filter(num -> num != 0).toArray();

      Arrays.sort(alphabetList);

      int sum = 0;
      int num = 9;

      for (int i = alphabetList.length - 1; i >= 0; i--) {
        sum += alphabetList[i] * num--;
      }

      System.out.print(sum);
    }

    public static void test1() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] alphabetList = new int[26];

      for (int i = 0; i < n; i++) {
        String input = br.readLine();
        for (int j = 0; j < input.length(); j++) {
          alphabetList[input.charAt(j) - 65] += (int) Math.pow(10, input.length() - j - 1);
        }
      }

      Arrays.sort(alphabetList);

      int sum = 0;
      int num = 9;

      for (int i = 25; i >= 0; i--) {
        if (alphabetList[i] == 0) continue;
        sum += alphabetList[i] * num--;
      }

      System.out.print(sum);
    }
  }

  static class M2 {
    /*
      백 트래킹 방식
      시간 초과는 안나는데, 시간이 역시 많이 듦...
      메모리 301952KB 시간 4300ms
    */
    static String[] wordList;
    static HashSet<Character> alphabetList;
    static int[] alphabetNum = new int[26];
    static int maximumSum = 0;

    public static void test() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      wordList = new String[n];
      alphabetList = new HashSet<>();

      for (int i = 0; i < n; i++) {
        wordList[i] = br.readLine();

        for (char alphabet : wordList[i].toCharArray()) {
          alphabetList.add(alphabet);
        }
      }

      add(9);

      System.out.print(maximumSum);
    }

    static void add(int num) {
      if (num == 9 - alphabetList.size()) {
        int sum = 0;

        for (String word : wordList) {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < word.length(); i++) {
            sb.append(alphabetNum[word.charAt(i) - 65]);
          }

          sum += Integer.parseInt(sb.toString());
        }

        maximumSum = Math.max(maximumSum, sum);
        return;
      }

      for (char alphabet : alphabetList) {
        int idx = alphabet - 65;

        if (alphabetNum[idx] == 0) {
          alphabetNum[idx] = num;
          add(num - 1);
          alphabetNum[idx] = 0;
        }
      }
    }
  }

  static class M_1 {
    /*
  반례
  2
  AB
  BB

  A = 9, B = 8
  98 + 88 = 186

  A = 8, B = 9
  89 + 99 = 188

  A의 자리가 높지만 B가 여러개라서....
  */
    public static void test1() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      ArrayList<ArrayList<Character>> alphabetDigit = new ArrayList<>(8);

      for (int i = 0; i < 8; i++) {
        alphabetDigit.add(i, new ArrayList<>());
      }

//    단어의 각 알파벳을 자릿수를 구한 뒤 자릿수 index에 알파벳을 저장한다. (=자릿수 별 알파벳 저장)
      for (int i = 0; i < n; i++) {
        String input = br.readLine();
        for (int j = 0; j < input.length(); j++) {
          int digit = input.length() - j - 1;

          alphabetDigit.get(digit).add(input.charAt(j));
        }
      }

      int[] alphabetToNum = new int[26];
      int totalSum = 0;
      int num = 9;

//    자릿수가 큰 순서대로 번호를 대입한다.
      for (int i = 7; i >= 0; i--) {
        if (alphabetDigit.get(i).size() == 0) continue;

        int sum = 0;

        for (Character alphabet : alphabetDigit.get(i)) {
          int idx = alphabet - 65;

          if (alphabetToNum[idx] == 0) {  // 만약 해당 알파벳에 번호가 대입되지 않았다면 번호 대입
            alphabetToNum[idx] = num--;
          }

          sum += alphabetToNum[idx];
        }

        totalSum += sum * Math.pow(10, i);
      }

      System.out.print(totalSum);
    }
  }
}

    /*
      알파벳이 2개만 나오는 것이 아니라 n개 나오네...
      최대 8자리의 수, 최대 알파벳 개수는 10개

      그럼 한 단어 read할 때마다 자릿수에 어떤 알파벳이 있는지 저장해준 뒤
      자릿수가 높은 순서대로 숫자를 대입해주기!

      알파벳이 중복으로 나오므로 알파벳 별 대입한 숫자 값을 별도로 저장해주기.

     */

    /* 처음에 단어가 2개만 나오는 줄 알았을 때 찾았던 방법

        ㄱ + ㄴ
        1. 가장 높은 자리의 숫자부터 숫자 대입
        2. ㄱ와 ㄴ의 자리수가 같아진다면 순서대로 높은 숫자 대입
        3. 더하기
    
        ex) ㄱ: GCF / ㄴ: ACDEB
        1. ㄴ의 자리수가 2개 더 많으므로 A와 C에 9와 8을 대입
        2. ㄱ과 ㄴ이 각각 3자리가 되었으므로 순서대로 7~1까지 숫자를 대입
        3. 더하기
    
        -> ㄱ: 783 / ㄴ: 98654
    
        각 알파벳에 숫자가 대입되었는지 확인하기 위해 배열을 선언한다
        알파벳의 index는 차례대로 A = [0] ~ Z = [25] 으로 함.
        
     */
