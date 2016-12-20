package SolvedFirstTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> res = solve(new int[]{1, 1, 2});
        for (List<Integer> r : res) {
            for (Integer i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> solve(int[] nums) {
        List<Integer> nl = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int n : nums) {
            nl.add(n);
        }
        helper(nl, res, new ArrayList<>(), nl.size());
        return res;
    }

    public static void helper(List<Integer> nums, List<List<Integer>> res, List<Integer> temp, int left) {
        if (left == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != null && (i == 0 || nums.get(i) != nums.get(i - 1))) {
                Integer t = nums.get(i);
                temp.add(t);
                nums.set(i, null);
                helper(nums, res, temp, left - 1);
                temp.remove(temp.size() - 1);
                nums.set(i, t);
            }
        }
    }

}
