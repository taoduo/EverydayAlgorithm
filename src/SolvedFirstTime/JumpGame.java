package SolvedFirstTime;

import java.util.Arrays;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/jump-game-ii/
 * At first I got a DP solution, but got TLE. Latter I thought really hard about the
 * greedy side of the problem and solved it.
 */
public class JumpGame {
  public static void main(String...args) {
    System.out.println(solve(new int[]{3, 1, 1 ,1}));
  }

  public static int solve(int[] nums) {
    int[] minSource = new int[nums.length];
    Arrays.fill(minSource, -1);
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] < nums.length) {
        minSource[i + nums[i]] = i;
      } else {
        minSource[nums.length - 1] = i;
      }
    }
    int minRight = Integer.MAX_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (minSource[i] == -1 || minSource[i] > minRight) {
        minSource[i] = minRight;
      } else if (minRight > minSource[i]) {
        minRight = minSource[i];
      }
    }
    int stepCount = 0;
    int pos = nums.length - 1;
    while (pos != 0) {
      pos = minSource[pos];
      stepCount++;
    }
    return stepCount;
  }
}
