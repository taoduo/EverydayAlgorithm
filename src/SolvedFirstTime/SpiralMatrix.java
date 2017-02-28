package SolvedFirstTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode
 * https://leetcode.com/problems/spiral-matrix/?tab=Description
 */
public class SpiralMatrix {
    public static void main(String... args) {
        int[][] matrix = {
        };
        spiralOrder(matrix).forEach((i)->System.out.print(i + " "));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length != 0) {
            for (int d = 0; d < Math.min((matrix.length + 1) / 2, (matrix[0].length + 1) / 2); d++) {
                spiralHelper(matrix, d, ret);
            }
        }
        return ret;
    }

    private static void spiralHelper(int[][] matrix, int d, List<Integer> ret) {
        int h = matrix.length - 2 * d;
        int w = matrix[0].length - 2 * d;
        for (int i = 0; i < w; i++) {
            ret.add(matrix[d][d + i]);
        }
        for (int i = 1; i < h; i++) {
            ret.add(matrix[d + i][matrix[0].length - d - 1]);
        }
        if (h != 1) {
            for (int i = 1; i < w; i++) {
                ret.add(matrix[matrix.length - d - 1][matrix[0].length - d - 1 - i]);
            }
        }
        if (w != 1) {
            for (int i = 1; i < h - 1; i++) {
                ret.add(matrix[matrix.length - d - 1 - i][d]);
            }
        }
    }
}
