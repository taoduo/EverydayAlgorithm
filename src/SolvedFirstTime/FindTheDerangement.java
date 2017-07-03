package SolvedFirstTime;

/**
 *
 */
public class FindTheDerangement {
    final int x = (int) (Math.pow(10, 9) + 7);
    public int findDerangement(int n) {
        if (n < 2) {
            return n - 1;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            long big = dp[i - 1] + dp[i - 2];
            dp[i] = (int) ((big * i) % x);
        }
        return dp[n - 1];
    }
}
