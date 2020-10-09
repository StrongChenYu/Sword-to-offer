package sword_to_offer;

import leetcode.tree.P297_Serialize_and_Deserialize_Binary_Tree;
import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
思路对了简简单单^^
 */
public class JZ61 {

    //这个题也是二叉树的序列化和反序列化，我们使用层序遍历实现

    public String Serialize(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder res = new StringBuilder("");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                res.append("#_");
                continue;
            }

            res.append(node.val + "_");

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return res.toString();
    }

    //反序列化也是使用队列来实现
    public TreeNode Deserialize(String str) {
        if (str == null || str.equals("")) return null;

        String[] nodeVals = str.split("_");
        TreeNode root = new TreeNode(Integer.valueOf(nodeVals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;

        while (cur < nodeVals.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) continue;

                String curLeft = nodeVals[cur++];
                String curRight = nodeVals[cur++];
                TreeNode left = null, right = null;

                if (!curLeft.equals("#")) left = new TreeNode(Integer.valueOf(curLeft));
                if (!curRight.equals("#")) right = new TreeNode(Integer.valueOf(curRight));

                node.left = left;
                node.right = right;

                queue.offer(left);
                queue.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        JZ61 p = new JZ61();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        String res = p.Serialize(root);

        System.out.println(res);
        p.Deserialize(res);

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(null);
    }
}
