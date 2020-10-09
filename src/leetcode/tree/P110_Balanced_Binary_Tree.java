package leetcode.tree;

import structure.TreeNode;

public class P110_Balanced_Binary_Tree {

    private class ResHelp {
        boolean isBalance;
        int height;

        public ResHelp(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }

        public ResHelp(){this.isBalance = false; this.height = 0;}
    }

    public boolean isBalanced(TreeNode root) {
        //三个条件
        //1. 左子树为平衡二叉树
        //2. 右子树为平衡二叉树
        //3. 两者高度相差不大于1

        return rescurionFun(root).isBalance;
    }

    public ResHelp rescurionFun(TreeNode root) {
        if (root == null) return new ResHelp(true, 0);

        ResHelp res = new ResHelp();

        ResHelp resL = rescurionFun(root.left);
        ResHelp resR = rescurionFun(root.right);

        if (resL.isBalance && resR.isBalance && Math.abs(resL.height - resR.height) <= 1) {
            res.isBalance = true;
            res.height = Math.max(resL.height, resR.height) + 1;
        }

        return res;
    }
}
