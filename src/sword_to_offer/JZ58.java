package sword_to_offer;

import structure.TreeNode;

public class JZ58 {

    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null) return true;
        return isFlip(pRoot.left, pRoot.right);
    }

    private boolean isFlip(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return isFlip(node1.left, node2.right) && isFlip(node1.right, node2.left);
            }
        }
        return false;
    }
}
