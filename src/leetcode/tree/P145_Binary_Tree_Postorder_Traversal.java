package leetcode.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145_Binary_Tree_Postorder_Traversal {


    //递归版本
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }


    //非递归版本
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackRes = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            stackRes.push(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        while (!stackRes.isEmpty()) {
            res.add(stackRes.pop());
        }

        return res;
    }
}
