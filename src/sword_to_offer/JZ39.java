package sword_to_offer;

import structure.TreeNode;

public class JZ39 {

    class ResHelp {
        boolean isBalance;
        int height;

        public ResHelp(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }

        public ResHelp(){this.isBalance = false; this.height = 0;}
    }

    public boolean IsBalanced_Solution(TreeNode root) {
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
