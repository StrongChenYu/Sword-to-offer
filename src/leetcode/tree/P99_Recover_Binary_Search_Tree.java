package leetcode.tree;

import structure.TreeNode;

import java.util.*;

/**
 * @Author Chen Yu
 * @Date 2021/5/3 9:04
 */
public class P99_Recover_Binary_Search_Tree {

    public void recoverTree(TreeNode root) {
        TreeNode pRoot = root;
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> nodesList = new ArrayList<>();

        /**
         * 遍历得到序列
         */
        while (!stack.isEmpty() || pRoot != null) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }

            TreeNode node = stack.pop();
            nodesList.add(node);
            if (node.right != null) pRoot = node.right;
        }

        /**
         * 交换顺序
         */
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < nodesList.size() - 1; i++) {
            TreeNode node1 = nodesList.get(i);
            TreeNode node2 = nodesList.get(i + 1);
            if (node2.val < node1.val) {
                y = node2;
                if (x == null) {
                    x = node1;
                }
            }
        }

        /**
         * swap
         */
        if (x != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
}
