package DidnotSolveFirstTime;

/**
 * Leetcode Problem
 * https://discuss.leetcode.com/topic/5962/accepted-java-solution
 * Did not come up with the great method to track diagonal occupancy at first
 * I have always been trying to track it with one array of length n
 * but this method tracks it with two arrays with lengths 2n
 */
public class NQueensII {
    public static void main(String...args) {
        System.out.println(solve(4));
    }

    public static int solve(int n) {
        boolean[] col = new boolean[n];
        boolean[] dr = new boolean[2 * n - 1];
        boolean[] dl = new boolean[2 * n - 1];
        return helper(n, 0, col, dr, dl);
    }

    public static int helper(int n, int row, boolean[] col, boolean[] dr, boolean[] dl) {
        if (row == n) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int dri = row - i + (n - 1);
            int dli = row + i;
            if (!dr[dri] && !col[i] && !dl[dli]) {
                dr[dri] = true;
                col[i] = true;
                dl[dli] = true;
                sum += helper(n, row + 1, col, dr, dl);
                dr[dri] = false;
                col[i] = false;
                dl[dli] = false;
            }
        }
        return sum;
    }

}
