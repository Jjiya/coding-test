package com.codingTest.leetcode.problems.Easy;

import java.util.HashMap;

public class June22 {

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
