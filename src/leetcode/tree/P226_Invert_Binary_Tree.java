package leetcode.tree;

import structure.TreeNode;

public class P226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
