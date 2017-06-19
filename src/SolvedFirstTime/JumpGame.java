package SolvedFirstTime;

import java.util.Arrays;

/**
 * Leetcode Problems
 * https://leetcode.com/problems/jump-game-ii/
 * https://leetcode.com/problems/jump-game/
 * At first I got a DP solution, but got TLE. Latter I thought really hard about the
 * greedy side of the problem and solved it.
 */
public class JumpGame {
  public static void main(String...args) {
    System.out.println(solve(new int[]{3,2,1,0,4}));
  }

  public static boolean solve(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[0] = true;
    for (int i = 1; i < nums.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (dp[j] && nums[j] >= i - j) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[nums.length - 1];
  }


  public static int solve2(int[] nums) {
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
