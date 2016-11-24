package SolvedFirstTime;

import java.util.Scanner;

/**
 * Edit Distance
 * DP algorithm wrote for fun
 */
public class EditDistance {
  public final static int SUBCOST = 1;
  public final static int INSCOST = 1;
  public final static int DELCOST = 1;

  public static void main(String... args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    System.out.println(solve(s1, s2));
  }

  public static int solve(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    // init
    for (int i = 0; i <= s1.length(); i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= s2.length(); i++) {
      dp[0][i] = i;
    }

    // fill in the table
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        // if the end chars are the same, match / delete / insert
        // else substitute / delete / insert
        dp[i][j] = Math.min((s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : SUBCOST) + dp[i - 1][j - 1],
            Math.min(dp[i - 1][j] + INSCOST, dp[i][j - 1] + DELCOST));
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
