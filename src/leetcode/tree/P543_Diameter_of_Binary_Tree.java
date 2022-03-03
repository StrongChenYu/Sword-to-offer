package leetcode.tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2022/3/3 23:05
 */
public class P543_Diameter_of_Binary_Tree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 其实就是求左右子树的高度之和
        return max;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftH = height(node.left);
        int rightH = height(node.right);
        max = Math.max(max, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}
