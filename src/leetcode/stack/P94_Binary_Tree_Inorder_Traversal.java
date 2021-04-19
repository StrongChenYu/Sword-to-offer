package leetcode.stack;

import org.junit.Before;
import org.junit.Test;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/18 21:11
 */
public class P94_Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //先把左子树一直往进放
                stack.push(root);
                root = root.left;
            }

            TreeNode left = stack.pop();
            res.add(left.val);
            root = left.right;
        }

        return res;
    }

    TreeNode root = null;

    @Before
    public void generateTree() {
        root = new TreeNode(1);
        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(3);
        //root.right.right = new TreeNode(7);
    }

    @Test
    public void Test() {
        inorderTraversal(root);
    }
}
