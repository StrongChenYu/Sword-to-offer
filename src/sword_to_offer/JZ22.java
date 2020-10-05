package sword_to_offer;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            TreeNode r = nodes.poll();
            res.add(r.val);

            if (r.left != null) nodes.offer(r.left);
            if (r.right != null) nodes.offer(r.right);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        JZ22 jz22 = new JZ22();
        ArrayList<Integer> integers = jz22.PrintFromTopToBottom(root);

        for (int nums : integers) {
            System.out.println(nums);
        }

    }

}
