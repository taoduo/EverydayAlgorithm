package SolvedFirstTime;
import java.util.Arrays;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-38/problems/maximum-product-of-three-numbers/
 */
public class MaximumProduct {
    public static void main(String...args) {
        System.out.println(solve(new int[]{1,-2,-3,2,4}));
    }

    public static int solve(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        if (nums[0] < 0 && nums[1] < 0) {
            return Math.max(nums[l - 1] * nums[l - 2] * nums[l - 3], nums[l - 1] * nums[0] * nums[1]);
        }
        return nums[l - 1] * nums[l - 2] * nums[l - 3];
    }

}
