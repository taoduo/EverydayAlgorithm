package SolvedFirstTime;

import java.util.Arrays;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildCardMatching {
  public static void main(String ...args) {
    System.out.println(solve("ab", "*"));
  }

  public static boolean solve(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    int ind = 0;
    while (ind < p.length() && p.charAt(ind) == '*') {
      dp[0][ind + 1] = true;
      ind++;
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (p.charAt(j - 1) == '*') {
          for (int k = 0; k <= i; k++) {
            if (dp[k][j - 1]) {
              dp[i][j] = true;
              break;
            }
          }
        } else if (p.charAt(j - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          if (p.charAt(j - 1) != s.charAt(i - 1)) {
            dp[i][j] = false;
          } else {
            dp[i][j] = dp[i - 1][j - 1];
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
