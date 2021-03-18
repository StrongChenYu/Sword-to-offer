package sword_to_offer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structure.TreeNode;

import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/3/17 20:23
 */
public class JZ62 {

    /**
     * 递归实现遍历
     */
    public void preOrder_Recursion(TreeNode root) {
        if (root == null) return;
        preOrder_Recursion(root.left);

        if (--outSideK == 0) {
            res = root;
            return;
        }
        preOrder_Recursion(root.right);
    }

    int outSideK = 0;
    TreeNode res = null;

    public TreeNode KthNode_Recursion(TreeNode pRoot, int k) {
        if (k <= 0) return null;
        outSideK = k;
        preOrder_Recursion(pRoot);
        return res;
    }

    /**
     * 用栈实现中序遍历
     */
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pCur = root;
        while (pCur != null || !stack.isEmpty()) {
            while (pCur != null) {
                stack.push(pCur);
                pCur = pCur.left;
            }

            TreeNode res = stack.pop();
            System.out.println(res.val);
            pCur = res.right;

        }
    }


    /**
     * 前序遍历的第k个节点
     * 用栈模拟递归的过程
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pCur = pRoot;
        while (pCur != null || !stack.isEmpty()) {
            while (pCur != null) {
                stack.push(pCur);
                pCur = pCur.left;
            }

            TreeNode res = stack.pop();

            if (--k == 0) return res;

            pCur = res.right;

        }

        return null;
    }

    TreeNode testRoot;

    @Before
    public void generateTree() {
        testRoot = new TreeNode(5);
        testRoot.left = new TreeNode(3);
        testRoot.right = new TreeNode(7);

        testRoot.left.left = new TreeNode(2);
        testRoot.left.right = new TreeNode(4);

        testRoot.right.left = new TreeNode(6);
        testRoot.right.right = new TreeNode(8);
    }

    @Test
    public void Test() {
        //
        int[] array = {2,3,4,5,6,7,8};
        for (int i = 1; i <= 7; i++) {
            Assert.assertEquals(KthNode_Recursion(testRoot, i), new TreeNode(array[i - 1]));

        }

//        TreeNode node = KthNode_Recursion(testRoot, 10);
//        System.out.println(node.val);
        Assert.assertNull(KthNode_Recursion(testRoot, 10));
        Assert.assertNull(KthNode_Recursion(testRoot, 0));
    }
}
