package SolvedFirstTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem
 */
public class ContainsDuplicate {
    public static void main(String...args) {
        System.out.println(solve(new int[]{1,2,3}));
        System.out.println(solve(new int[]{1,2,2}));
    }

    public static boolean solve(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], true);
            }
        }
        return false;
    }
}
