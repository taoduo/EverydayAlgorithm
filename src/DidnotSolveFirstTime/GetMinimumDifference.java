package DidnotSolveFirstTime;

/**
 * Leetcode contest problem
 */
public class GetMinimumDifference {
    static TreeNode prev = null;
    static int minDiff = Integer.MAX_VALUE;
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private static int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minDiff;
    }

    private static void traverse(TreeNode root) {
        if (root.left != null) {
            traverse(root.left);
        }
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
        }
        prev = root;
        if (root.right != null) {
            traverse(root.right);
        }

    }
}
