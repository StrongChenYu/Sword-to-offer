package leetcode.tree;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P297_Serialize_and_Deserialize_Binary_Tree {

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("");
        preOrderTravel(root, res);
        return res.toString();
    }

    public void preOrderTravel(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("#_");
            return;
        }
        res.append(root.val + "_");
        preOrderTravel(root.left, res);
        preOrderTravel(root.right, res);
    }

    public TreeNode deserialize(String data) {
        //1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_
        //会把下划线都去掉
        String[] datas = data.split("_");
        Queue<String> tempData = new LinkedList<>();
        for (String s : datas) {
            tempData.offer(s);
        }

        TreeNode root = deserializeHelp(tempData);
        return root;
    }


    public TreeNode deserializeHelp(Queue<String> data) {
        String val = data.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeHelp(data);
        node.right = deserializeHelp(data);

        return node;
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

        String res = "1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_";

        p.deserialize(res);
    }

}
