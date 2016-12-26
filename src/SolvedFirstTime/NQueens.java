package SolvedFirstTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    private static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isConflict(Position another) {
            return this.x == another.x || this.y == another.y || this.x + this.y == another.x + another.y
                    || this.x - this.y == another.x - another.y;
        }
    }

    public static void main(String...args) {
        List<List<String>> res = solve(4);
        for (List<String> l : res) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solve(int n) {
        boolean[][] state = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        helper(0, n, state, new ArrayList<>(), res);
        return res;
    }

    public static void helper(int i, int n, boolean[][] state, List<Position> qs, List<List<String>> res) {
        if (i == n) {
            res.add(stringifier(state));
            return;
        }
        for (int j = 0; j < n; j++) {
            boolean v = true;
            Position t = new Position(i, j);
            for (Position q : qs) {
                if (q.isConflict(t)) {
                    v = false;
                    break;
                }
            }
            if (v) {
                state[i][j] = true;
                qs.add(t);
                helper(i + 1, n, state, qs, res);
                state[i][j] = false;
                qs.remove(qs.size() - 1);
            }
        }
    }

    public static List<String> stringifier(boolean[][] state) {
        List<String> res = new ArrayList<>();
        for (boolean[] bol : state) {
            String s = "";
            for (boolean b : bol) {
                if (b) {
                    s += "Q";
                } else {
                    s += ".";
                }
            }
            res.add(s);
        }
        return res;
    }
}
