package DidnotSolveFirstTime;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/first-missing-positive/
 * Did not solve it the first time.
 * I should remember this way of sorting things
 * I think this goes to some sort of linear sorting
 */
public class FirstMissingPositive {
  public static void main(String... args) {
    System.out.println(solve(new int[]{1, 1}));
  }

  public static int solve(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
        int temp = nums[i];
        nums[i] = nums[temp - 1];
        nums[temp - 1] = temp;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }
}
