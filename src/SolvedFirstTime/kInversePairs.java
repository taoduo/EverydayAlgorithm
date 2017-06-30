package SolvedFirstTime;

/**
 * https://leetcode.com/problems/k-inverse-pairs-array/
 */
public class kInversePairs {
    final static int divisor = (int) Math.pow(10, 9) + 7;
    public static void main(String...args) {
        System.out.println(solve(100, 100));
    }

    public static int solve(int n, int k) {
        if (k == 0) {
            return 1;
        }
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = 0;
                if (j > i * (i + 1) / 2) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i >= j) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - i - 1];
                    if (dp[i][j] < 0) {
                        dp[i][j] += divisor;
                    }
                }
//                if (dp[i][j] < 0) {
//                    System.out.println(i + " " + j);
//                }
                dp[i][j] %= divisor;
            }
        }
        return dp[n - 1][k];
    }
}
