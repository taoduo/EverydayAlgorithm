package SolvedFirstTime;

/**
 * Leetcode problem
 * https://leetcode.com/problems/trapping-rain-water/
 * It is important to get from a concept to math
 */
public class TrappingRainWater {
  public static void main(String...args) {
    System.out.println(solve(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
  }

  public static int solve(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    leftMax[0] = 0;
    rightMax[height.length - 1] = 0;
    for (int i = 0; i < height.length - 1; i++) {
      leftMax[i + 1] = Math.max(leftMax[i], height[i]);
    }
    for (int i = height.length - 1; i >= 1; i--) {
      rightMax[i - 1] = Math.max(rightMax[i], height[i]);
    }
    int sum = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int water = Math.min(leftMax[i], rightMax[i]) - height[i];
      sum += water > 0 ? water : 0;
    }
    return sum;
  }
}
