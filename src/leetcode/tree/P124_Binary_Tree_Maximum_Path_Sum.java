package leetcode.tree;

import structure.TreeNode;

/**
 * @Author Chen Yu
 * @Date 2021/5/5 8:55
 */
public class P124_Binary_Tree_Maximum_Path_Sum {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right), 0);

        max = Math.max(max, left + root.val + right);

        return Math.max(left, right) + root.val;
    }

}
