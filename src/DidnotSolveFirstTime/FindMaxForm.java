package DidnotSolveFirstTime;

/**
 * Leetcode Contest Problem.
 * https://leetcode.com/contest/leetcode-weekly-contest-12/problems/ones-and-zeroes/
 * I used a BF method but I learned the DP algorithm from another person
 * I thought DP does not work here but for this, I learned that DP can be useful even
 * when the sequence matters
 */
public class FindMaxForm {
  public static void main(String ...args) {
    System.out.println(solve(new String[]{"10", "0", "1"}, 1, 1));
  }

  public static int solve(String[] strs, int m, int n) {
    int[][] pre = preprocess(strs);
    int[][] dp = new int[m + 1][n + 1]; // dp[i][j] means the max count with i 0 and j 1
    for (int i = 0; i < pre.length; i++) {
      for (int j = dp.length - 1; j >= 0; j--) {
        for (int k = dp[0].length - 1; k >= 0; k--) {
          if (j >= pre[i][0] && k >= pre[i][1]) {
            dp[j][k] = Math.max(dp[j][k], dp[j - pre[i][0]][k - pre[i][1]] + 1);
          }
        }
      }
    }
    return dp[m][n];
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
