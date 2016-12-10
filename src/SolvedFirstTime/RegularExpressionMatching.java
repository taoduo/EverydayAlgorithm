package SolvedFirstTime;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
  public static void main(String... args) {
    System.out.println(solve("a", "ab*"));
  }

  // s string, p pattern
  public static boolean solve(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

    // initialization
    dp[0][0] = true;
    for (int i = 1; i <= s.length(); i++) {
        dp[i][0] = false;
    }
    for (int i = 1; i <= p.length(); i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 2];
      } else {
        dp[0][i] = false;
      }
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        if (p.charAt(j - 1) == '*') {
          char c = p.charAt(j - 2);
          int k = i;
          dp[i][j] = false;
          while (k != 0 && (s.charAt(k - 1) == c || c == '.')) {
            if (dp[k - 1][j - 2]) {
              dp[i][j] = true;
              break;
            }
            k--;
          }
          if (dp[i][j - 2]) {
            dp[i][j] = true;
          }
        } else {
          dp[i][j] = false;
          if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
