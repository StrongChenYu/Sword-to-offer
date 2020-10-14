package leetcode.tree;

import structure.TreeNode;

public class P98_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelp(root, null, null);
    }

    public boolean isValidBSTHelp(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!isValidBSTHelp(root.left, lower, val)) return false;
        if (!isValidBSTHelp(root.right, val, upper)) return false;

        return true;

    }

}
