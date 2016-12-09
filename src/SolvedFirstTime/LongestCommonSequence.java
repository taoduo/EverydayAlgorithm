package SolvedFirstTime;

/**
 * Implementation of CS252 final take home exam algorithm
 * Wrote on flight, boring code
 */

public class LongestCommonSequence {
  public static void main(String...args) {
    System.out.println(solve("haha", "asdfahahdsdf"));
  }

  public static int solve(String x, String y) {
    int[][] dp = new int[x.length() + 1][y.length() + 1];
    for (int i = 0; i < dp.length; i++){
      dp[i][0] = 0;
    }
    for (int i = 0; i < dp[0].length; i++){
      dp[0][i] = 0;
    }
    int global_max = 0;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        dp[i][j] = x.charAt(i - 1) == y.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : 0;
        global_max = Math.max(global_max, dp[i][j]);
      }
    }
    return global_max;
  }
}
