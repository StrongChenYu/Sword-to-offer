package leetcode.stack;

import structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Chen Yu
 * @Date 2021/4/20 9:11
 */
public class P173_Binary_Search_Tree_Iterator {
}

class BSTIterator {

    TreeNode root = null;
    Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    public int next() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode node = stack.pop();
        if (node.right != null) root = node.right;
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || root != null;
    }
}