package leetcode.tree;

import org.junit.Test;
import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P1161_Maximum_Level_Sum_of_a_Binary_Tree {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int minLevel = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (sum > maxSum) {
                minLevel = level;
                maxSum = sum;
            }

            level++;
        }

        return minLevel;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        System.out.println(maxLevelSum(root));
    }
}
