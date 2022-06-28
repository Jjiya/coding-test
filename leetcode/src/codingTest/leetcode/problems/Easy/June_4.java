package codingTest.leetcode.problems.Easy;

import java.util.HashMap;

public class June_4 {
  //  https://leetcode.com/problems/roman-to-integer/
  /** 9. Palindrome Number **/

  public int romanToInt1(String s) {
    int sum = 0, i = 0;

    while (i < s.length() - 1) {
      int num = convertRomanToNum(s.charAt(i));
      int nextNum = convertRomanToNum(s.charAt(i + 1));
      if (num < nextNum) {
        sum += nextNum - num;
        i++;
      } else {
        sum += num;
      }
      i++;
    }

//    끝 두자리가 계산 된 경우면 sum 반환, 아니면 sum에 마지막 1글자 더해줘야함.
    return i == s.length() ? sum : sum + convertRomanToNum(s.charAt(s.length() - 1));
  }

  int convertRomanToNum(char romanChar) {
    switch (romanChar) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
    /*
     * java 15일 경우
     * return switch(romanChar){
     *       case 'I'-> 1;
     *       case 'V'-> 5;
     *       case 'X'-> 10;
     *       case 'L'-> 50;
     *       case 'C'-> 100;
     *       case 'D'-> 500;
     *       case 'M'-> 1000;
     *       default -> 0;
     *     };
     */
  }

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

  /** 9. Palindrome Number **/

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


  /** 1. Two Sum **/
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
