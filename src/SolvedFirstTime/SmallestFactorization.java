package SolvedFirstTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-factorization/#/description
 */
public class SmallestFactorization {

    public static void main(String...args) {
        System.out.print(solve(150));
    }

    public static int solve(int a) {
        if (a == 1) {
            return 1;
        }
        List<Integer> l = new ArrayList<>();
        while (a != 1) {
            int d = tryDivide(a);
            if (d == 0) {
                return 0;
            }
            a /= d;
            l.add(d);
        }
        Collections.sort(l);
        try {
            return Integer.parseInt(l.toString().replaceAll("[\\[,\\s\\]]", ""));
        } catch (Exception e) {
            return 0;
        }
    }

    public static int tryDivide(int a) {
        for (int i = 9; i > 1; i--) {
            if (a % i == 0) {
                return i;
            }
        }
        return 0;
    }
}
