package SolvedFirstTime;

import java.util.Arrays;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public static void main(String...args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1,2,3,4}};
        solve(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void solve(int[][] matrix) {
        int halfx = (matrix.length + 1) / 2;
        int halfy = matrix.length % 2 == 0 ? halfx : halfx - 1;
        for (int i = 0; i < halfx; i++) {
            for (int j = 0; j < halfy; j++) {
                int tl = matrix[i][j];
                int tr = matrix[j][matrix.length - 1 - i];
                int bl = matrix[matrix.length - 1 - j][i];
                int br = matrix[matrix.length - 1 - i][matrix.length - 1- j];
                matrix[i][j] = bl;
                matrix[j][matrix.length - 1 - i] = tl;
                matrix[matrix.length - 1 - j][i] = br;
                matrix[matrix.length - 1 - i][matrix.length - 1- j] = tr;
            }
        }
    }
}
