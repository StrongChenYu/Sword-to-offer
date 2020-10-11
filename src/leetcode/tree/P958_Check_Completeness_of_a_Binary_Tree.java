package leetcode.tree;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是不是完全二叉树
 * 分四种情况讨论就可以了
 * 1.left，right都为null
 * 2.left，right都不为null
 * 3.left，right只有一个为null
 * 使用层序遍历
 */
public class P958_Check_Completeness_of_a_Binary_Tree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeafFlag = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left != null) queue.offer(left);
            if (right != null) queue.offer(right);

            if (isLeafFlag) {
                if (isLeaf(node)){
                    return false;
                } else {
                    continue;
                }
            }

            if (left != null && right != null) continue;
            if (left == null && right != null) return false;
            if ((left != null && right == null) || isLeaf(node)) isLeafFlag = true;

        }

        return true;
    }


    public boolean isLeaf(TreeNode node) {
        if (node == null) return true;
        return node.left == null && node.right == null;
    }
}
