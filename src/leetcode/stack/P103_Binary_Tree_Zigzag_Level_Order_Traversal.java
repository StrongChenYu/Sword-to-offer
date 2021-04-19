package leetcode.stack;

import structure.TreeNode;

import java.util.*;

/**
 * @Author Chen Yu
 * @Date 2021/4/19 9:52
 */
public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> levelRes = new ArrayList<>();
            if (reverse) {
                Deque<Integer> stack = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    stack.push(node.val);

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

                while (!stack.isEmpty()) {
                    levelRes.add(stack.pop());
                }

                reverse = false;

            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelRes.add(node.val);

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                reverse = true;
            }

            res.add(levelRes);
        }

        return res;
    }
}
