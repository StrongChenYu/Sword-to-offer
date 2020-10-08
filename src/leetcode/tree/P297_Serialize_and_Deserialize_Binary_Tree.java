package leetcode.tree;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P297_Serialize_and_Deserialize_Binary_Tree {

    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res += node.val + "_";

            if (node.left != null) {
                queue.offer(node.left);
            } else {
                res += "#_";
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                res += "#_";
            }

        }

        return res;
    }

    public static void main(String[] args) {
        P297_Serialize_and_Deserialize_Binary_Tree p = new P297_Serialize_and_Deserialize_Binary_Tree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(p.serialize(root));
    }

}
