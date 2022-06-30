package codingTest.leetcode.problems.Easy.definition;

import java.util.HashSet;

public class July_1 {
  /**
   * 26. Remove Duplicates from Sorted Array
   **/
//  removeDuplicates2보다 1ms 느림... if 분기에서
  public int removeDuplicates(int[] nums) {
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i == nums.length - 1 || nums[i] < nums[i + 1]) {
        nums[index++] = nums[i];
      }
    }

    return index;
  }

  public int removeDuplicates2(int[] nums) {
    int index = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        nums[index++] = nums[i];
      }
    }

    nums[index++] = nums[nums.length - 1];

    return index;
  }

  public int removeDuplicates1(int[] nums) {
    HashSet<Integer> saveNumList = new HashSet<>();

    int index = 0;

    for (int num : nums) {
      if (!saveNumList.contains(num)) {
        saveNumList.add(num);
        nums[index++] = num;
      }
    }

    return index;
  }
}
