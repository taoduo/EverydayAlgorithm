package StillWaitToBeSolved;

import java.util.Scanner;

/**
 * Google Code Jam
 */
public class XSquared {
    public static void main(String... args) {
        boolean[][] board;
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            board = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                String row = scanner.nextLine();
                for (int k = 0; k < n; k++) {
                    if (row.charAt(k) == 'X') {
                        board[j][k] = true;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + boolToStr(XSquared(board)));
        }
    }

    public static String boolToStr(boolean b) {
        return b ? "POSSIBLE" : "IMPOSSIBLE";
    }
    public static boolean XSquared(boolean[][] board) {
        int l = board.length;
        int[] rows = new int[l];
        int[] cols = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (board[i][j]) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int rc = 0;
        int cc = 0;
        for (int n : rows) {
            if (n == 1) {
                rc++;
                if (rc > 1) {
                    return false;
                }
            } else if (n != 2) {
                return false;
            }
        }
        for (int n : cols) {
            if (n == 1) {
                cc++;
                if (cc > 1) {
                    return false;
                }
            } else if (n != 2) {
                return false;
            }
        }
        return true;
    }
}
