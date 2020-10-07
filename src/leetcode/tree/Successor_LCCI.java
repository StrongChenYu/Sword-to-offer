package leetcode.tree;

import structure.TreeNode;

//衍生题目，寻找中序遍历的下一个节点
//还有一道题是寻找中序遍历的前一个节点
//in-order是中序遍历
//https://leetcode-cn.com/problems/successor-lcci/
public class Successor_LCCI {
    /**
     * 这个题目还不太一样，因为他是二叉搜索树，所以是有序的
     * 然后由于他没有parent节点，所以还不能用一种比较简单点的思想去做。
     *
     * 1. 如果这个点的值大于或者等于root，那么，这个后继节点必定在root的右子树中
     * 2. 如果这个点的值小于root，那么必定是root，或者在左子树中
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessorRecursion(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
    }

    /**
     * 使用非递归的思想做
     * 如果这种情况就需要使用有parent点思想去找他parent
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /**
         * 先去判断右子树是不是空的，如果不为空，就去找右子树的最左节点
         */
        if (p!= null && p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        TreeNode res = null;
        /**
         * 如果右子树为空，就往上找，由于没有parent节点，所以需要从上往下遍历
         * 由于是二叉搜索树，所以还是有规律可循
         */
        while (root != p) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return res;
    }

}
