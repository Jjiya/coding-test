package com.codingTest.leetcode.problems.Easy;

import java.util.HashMap;

public class June22 {
  //  https://leetcode.com/problems/roman-to-integer/
  public int romanToInt(String s) {
    HashMap<String, Integer> romanNumerals = new HashMap<>();
    romanNumerals.put("I", 1);
    romanNumerals.put("V", 5);
    romanNumerals.put("X", 10);
    romanNumerals.put("L", 50);
    romanNumerals.put("C", 100);
    romanNumerals.put("D", 500);
    romanNumerals.put("M", 1000);

    String[] chars = s.split("");

    int answer = 0;
    int[] numeric = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      numeric[i] = romanNumerals.get(chars[i]);
    }

    int sum = 0;
    for (int j = 0; j < numeric.length; j++) {
      if (j != numeric.length - 1) {
        int division = numeric[j + 1] / numeric[j];
        if (division == 5 || division == 10) {
          sum += (numeric[j + 1] - numeric[j]);
          j++;
          continue;
        }
      }
      sum += numeric[j];
    }

    return sum;
  }

  public boolean isPalindrome1(int x) {
    if (x < 0) return false;

    int reverse = 0;
    while (reverse < x) {
      System.out.printf("-- reverse < x => %d < %d --\n\n", reverse, x);
      System.out.printf("reverse = (%d * 10) + (%d %% 10) == %d + %d = ", reverse, x, (reverse * 10), (x % 10));
      reverse = reverse * 10 + x % 10;
      System.out.printf("%d \n", reverse);
      x = x / 10;
      System.out.printf("x = %d / 10 = %d\n\n", x, x / 10);
    }

    System.out.printf("x == reverse (%d == %d) || x == reverse / 10 (%d == %d)\n", x, reverse, x, reverse / 10);
    return (x == reverse || x == reverse / 10);
  }

  public boolean isPalindrome(int x) {
    return (x + "").contentEquals(new StringBuilder().append(x).reverse());
  }

  //  O(n)
  public int[] twoSum1(int[] nums, int target) {
//    numsValue, numsIndex
    HashMap<Integer, Integer> numsMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (numsMap.containsKey(target - nums[i])) return new int[]{i, numsMap.get(target - nums[i])};
      else numsMap.put(nums[i], i);
    }
    return null;
  }

  //  O(n²)
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) return new int[]{i, j};
      }
    }
    return null;
  }

}
