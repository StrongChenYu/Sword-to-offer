package sword_to_offer;

import structure.TreeNode;

public class JZ38 {

    public int TreeDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

}
