package sword_to_offer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JZ59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean reverse = false;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (pRoot == null) return res;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Stack<Integer> reverseStack = new Stack<>();

        nodeQueue.add(pRoot);

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            if (reverse) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = nodeQueue.poll();
                    if (node.left != null) nodeQueue.add(node.left);
                    if (node.right != null) nodeQueue.add(node.right);
                    reverseStack.push(node.val);
                }
                while (!reverseStack.isEmpty()) levelNodes.add(reverseStack.pop());
                reverse = false;
            } else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = nodeQueue.poll();
                    if (node.left != null) nodeQueue.add(node.left);
                    if (node.right != null) nodeQueue.add(node.right);
                    levelNodes.add(node.val);
                }
                reverse = true;
            }

            res.add(levelNodes);
        }
        return res;
    }


    /**
     * test
     */
    private TreeNode pRoot;

    private int[][] wantedDataArray = {
            {8},
            {10,6},
            {5,7,9,11}
    };

    @Before
    public void generateTree() {
        pRoot = new TreeNode(8);
        pRoot.left = new TreeNode(6);
        pRoot.right = new TreeNode(10);
        pRoot.left.left = new TreeNode(5);
        pRoot.left.right = new TreeNode(7);
        pRoot.right.left = new TreeNode(9);
        pRoot.right.right = new TreeNode(11);
    }

    @Test
    public void Test() {
        ArrayList<ArrayList<Integer>> wantedData = new ArrayList<>();
        wantedData = new ArrayList<>();
        for (int i = 0; i < wantedDataArray.length; i++) {
            ArrayList<Integer> tempData = new ArrayList<>();
            for (int j = 0; j < wantedDataArray[i].length; j++) {
                tempData.add(wantedDataArray[i][j]);
            }
            wantedData.add(tempData);
        }

        ArrayList<ArrayList<Integer>> print = Print(pRoot);
        assertResEqual(print, wantedData);

    }

    private void assertResEqual(ArrayList<ArrayList<Integer>> got, ArrayList<ArrayList<Integer>> want) {
        Assert.assertEquals(got.size(), want.size());

        for (int i = 0; i < got.size(); i++) {
            ArrayList<Integer> integers = got.get(i);
            ArrayList<Integer> integers1 = want.get(i);
            Assert.assertEquals(integers.size(), integers1.size());

            for (int j = 0; j < integers.size(); j++) {
                Assert.assertEquals(integers.get(j), integers1.get(j));
            }
        }
    }
}
