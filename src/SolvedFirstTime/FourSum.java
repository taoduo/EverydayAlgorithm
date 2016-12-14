package SolvedFirstTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
  public static void main(String... args) {
    List<List<Integer>> res = solve(new int[]{-4, -1, -1, 0, 1, 2}, -1);
    for (List<Integer> r : res) {
      for (Integer i : r) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> solve(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int subTar = target - nums[i] - nums[j];
        int left = j + 1;
        int right = nums.length - 1;
        while (left < right) {
          if (nums[left] + nums[right] < subTar) {
            left++;
          } else if (nums[left] + nums[right] > subTar) {
            right--;
          } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
            temp.add(nums[left]);
            temp.add(nums[right]);
            res.add(temp);
            left++;
            while (left < right && nums[left] == nums[left - 1]) {
              left++;
            }
            right--;
            while (left < right && nums[right] == nums[right + 1]) {
              right--;
            }
          }
        }
      }
    }
    return res;
  }
}
