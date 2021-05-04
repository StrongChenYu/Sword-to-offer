package leetcode.tree;

import structure.TreeNode;

/**
 * @Author Chen Yu
 * @Date 2021/5/4 8:59
 */
public class P104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
