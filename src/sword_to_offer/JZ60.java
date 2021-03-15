package sword_to_offer;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;

        bfsQueue.offer(pRoot);

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            ArrayList<Integer> curLayer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = bfsQueue.poll();

                curLayer.add(node.val);

                if (node.left != null) bfsQueue.add(node.left);
                if (node.right != null) bfsQueue.add(node.right);
            }
            res.add(curLayer);
        }

        return res;
    }

}
