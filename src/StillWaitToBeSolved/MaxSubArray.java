package StillWaitToBeSolved;

/**
 * Need O(n) DC solution
 * https://leetcode.com/problems/maximum-subarray/?tab=Description
 */
public class MaxSubArray {
    public static void main(String...args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{-1}));
        System.out.println(maxSubArray(new int[]{-2,3,0,2,-2,3}));
    }

    private static class Wrapper {
        int maxLeft;
        int maxRight;
        int max;
        int sum;
        Wrapper(int maxLeft, int maxRight, int max, int sum) {
            this.maxLeft = maxLeft;
            this.maxRight = maxRight;
            this.max = max;
            this.sum = sum;
        }

        Wrapper() {}
    }
//    private static int maxSubArray(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int prev = nums[0];
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > prev + nums[i]) {
//                max = Math.max(max, nums[i]);
//                prev = nums[i];
//            } else {
//                max = Math.max(max, prev + nums[i]);
//                prev += nums[i];
//            }
//        }
//        return max;
//    }
    private static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1).max;
    }

    private static Wrapper helper(int[] nums, int left, int right) {
        if (left == right) {
            return new Wrapper(nums[left], nums[left], nums[left], nums[left]);
        }
        int m = left + (right - left) / 2;
        Wrapper l = helper(nums, left, m);
        Wrapper r = helper(nums, m + 1, right);
        Wrapper ret = new Wrapper();
        ret.maxLeft = Math.max(l.maxLeft, l.sum + r.maxLeft);
        ret.maxRight = Math.max(r.maxRight, r.sum + l.maxRight);
        ret.max = Math.max(Math.max(l.max, r.max), r.maxLeft + l.maxRight);
        ret.sum = l.sum + r.sum;
        return ret;
    }
}
