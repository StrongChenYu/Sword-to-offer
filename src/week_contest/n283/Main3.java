package week_contest.n283;

import org.junit.Test;
import structure.TreeNode;

import java.util.*;

public class Main3 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int node = descriptions[i][1];
            boolean isLeft = descriptions[i][2] == 1;

            rootSet.add(parent);

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(node, new TreeNode(node));

            if (isLeft) {
                map.get(parent).left = map.get(node);
            } else {
                map.get(parent).right = map.get(node);
            }
        }

        for (int i = 0; i < descriptions.length; i++) {
            int node = descriptions[i][1];
            rootSet.remove(node);
        }

        // 随便找个节点往上遍历
        Iterator<Integer> iterator = rootSet.iterator();
        return map.get(iterator.next());

    }

    int[][] data = {
            {20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}
    };

    @Test
    public void test() {
        TreeNode a = createBinaryTree(data);
        System.out.println("a");
    }
}
