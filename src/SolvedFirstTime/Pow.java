package SolvedFirstTime;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {
    public static void main(String...args) {
        System.out.println(solve(2, -2));
    }

    public static double solve(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 0) {
            return 1;
        }
        double d = solve(x, n / 2);
        if (n > 0) {
            return n % 2 == 0 ? d * d : d * d * x;
        } else {
            return n % 2 == 0 ? d * d : d * d / x;
        }
    }
}
