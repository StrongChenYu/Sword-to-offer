package sword_to_offer;

import org.junit.Before;
import org.junit.Test;
import structure.TreeNode;

/**
 * @Author Chen Yu
 * @Date 2021/3/17 20:23
 */
public class JZ62 {

    /**
     * 前序遍历的第k个节点
     * 用栈模拟递归的过程
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
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

        KthNode(testRoot, 3);
    }
}
