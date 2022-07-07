package codingTest.leetcode.problems.Easy;

import java.util.Arrays;
import java.util.HashSet;

public class July_1 {

  /**
   * 28. Implement strStr()
   **/

  public int strStr(String haystack, String needle) {
    int startIdx = -1;
    int sameCount = 0;

    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(sameCount)) {
        sameCount++;

        if (startIdx == -1) {
          startIdx = i;
        }
      } else if (sameCount != 0) {
        sameCount = 0;
        i = startIdx;
        startIdx = -1;
      }

      if (sameCount >= needle.length()) {
        break;
      }
    }

    return sameCount == needle.length() ? startIdx : -1;
  }

  /**
   * 27. Remove Element
   **/
  public int removeElement(int[] nums, int val) {
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        nums[i] = 101;
        count++;
      }
    }

    Arrays.sort(nums);

    return nums.length - count;
  }


  /**
   * 26. Remove Duplicates from Sorted Array
   **/
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
