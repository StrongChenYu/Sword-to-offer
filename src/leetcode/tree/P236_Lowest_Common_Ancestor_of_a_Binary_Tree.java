package leetcode.tree;

import structure.TreeNode;

public class P236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode resL = lowestCommonAncestor(root.left, p, q);
        TreeNode resR = lowestCommonAncestor(root.right, p, q);
        if (resL == null) return resR;
        if (resR == null) return resL;
        return root;
    }
}
