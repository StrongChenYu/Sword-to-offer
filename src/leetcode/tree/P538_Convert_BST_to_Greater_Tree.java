package leetcode.tree;

import org.junit.Test;
import structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Chen Yu
 * @Date 2022/3/3 22:36
 */
public class P538_Convert_BST_to_Greater_Tree {

    Deque<TreeNode> stack = new LinkedList<>();
    public TreeNode convertBST(TreeNode root) {
        preVisit(root);

        int preSum = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            pop.val += preSum;
            preSum = pop.val;
        }

        return root;
    }

    public void preVisit(TreeNode node) {
        if (node.left == null && node.right == null) {
            stack.push(node);
            return;
        }
        if (node.left != null) {
            preVisit(node.left);
        }
        stack.push(node);
        if (node.right != null) {
            preVisit(node.right);
        }
    }

    @Test
    public void Test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);

    }
}
