package leetcode.tree;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;



//二叉树的的序列化和反序列化
//剑指offer61题
public class P297_Serialize_and_Deserialize_Binary_Tree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("#");
            } else {
                res.append(node.val);
            }
            res.append("_");
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeVals = data.split("_");
        if (nodeVals.length == 1 && nodeVals[0].equals("#")) return null;

        int curIdx = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && curIdx < nodeVals.length) {
            TreeNode node = queue.poll();
            if (!nodeVals[curIdx].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodeVals[curIdx]));
                queue.offer(node.left);
            }
            curIdx++;

            if (!nodeVals[curIdx].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodeVals[curIdx]));
                queue.offer(node.right);
            }
            curIdx++;
        }

        return root;
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

        String res = "1_";
        TreeNode deserialize = p.deserialize(res);
        System.out.println(deserialize);
    }

}
