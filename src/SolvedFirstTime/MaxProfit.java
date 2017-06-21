package SolvedFirstTime;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 */
public class MaxProfit {
    public static void main(String...args) {
        System.out.println(solve(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solve(new int[]{7, 6, 4, 3, 1}));
    }

    public static int solve(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int prevMin = prices[0];
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prevMin) {
                maxDiff = Math.max(maxDiff, prices[i] - prevMin);
            } else {
                prevMin = prices[i];
            }
        }
        return maxDiff;
    }
}
