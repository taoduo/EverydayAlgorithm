package StillWaitToBeSolved;

/**
 * Leetcode Contest Problem.
 * https://leetcode.com/contest/leetcode-weekly-contest-12/problems/ones-and-zeroes/
 * This is a BF method and got TLE. Can not DP, can not greedy. Do know how to solve yet.
 */
public class FindMaxForm {
  public static void main(String ...args) {
    System.out.println(solve(new String[]{"10", "0001", "111001", "1", "0"}, 4, 3));
  }

  public static int solve(String[] strs, int m, int n) {
    int[][] pre = preprocess(strs);
    return helper(pre, m, n, 0);
  }

  public static int helper(int[][] pre, int m, int n, int start) {
    if ((m == 0 && n == 0) || start > pre.length - 1) {
      return 0;
    }
    int max = 0;
    for (int i = start; i < pre.length; i++) {
      if (m - pre[i][0] >= 0 && n - pre[i][1] >= 0) {
        max = Math.max(max, helper(pre, m - pre[i][0], n - pre[i][1], i + 1) + 1);
      }
    }
    return max;
  }

  public static int[][] preprocess(String[] strs) {
    int[][] res = new int[strs.length][2];
    for (int i = 0; i < strs.length; i++) {
      res[i] = countZerosAndOnes(strs[i]);
    }
    return res;
  }

  public static int[] countZerosAndOnes(String s) {
    int z = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        z++;
      }
    }
    return new int[]{z, s.length() - z};
  }
}
