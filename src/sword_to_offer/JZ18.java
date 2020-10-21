package sword_to_offer;

import structure.TreeNode;

public class JZ18 {

    public void Mirror(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.right);
        Mirror(root.left);
    }



}
