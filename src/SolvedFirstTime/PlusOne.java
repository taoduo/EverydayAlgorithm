package SolvedFirstTime;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public static void main(String...args) {
        Integer[] arr = new Integer[]{1,2,3};
        Integer[] arr1 = new Integer[]{9,9,9};
        System.out.println(Arrays.deepToString(solve(arr)));
        System.out.println(Arrays.deepToString(solve(arr1)));
    }

    public static Integer[] solve(Integer[] digits) {
        int cur = digits.length - 1;
        Integer[] res;
        while(cur >= 0 && digits[cur] == 9) {
            digits[cur] = 0;
            cur--;
        }
        if (cur >= 0) {
            digits[cur]++;
            res = digits;
        } else {
            res = new Integer[digits.length + 1];
            Arrays.fill(res, 0);
            res[0] = 1;
        }
        return res;
    }
}
