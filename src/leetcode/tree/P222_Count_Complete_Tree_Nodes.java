package leetcode.tree;

import structure.TreeNode;

/**
 * 计算一颗完全二叉树的节点个数
 * O(logN)时间范围内解决问题
 * 假设是完全二叉树的全部子树全部都是二叉树
 */
public class P222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int cnt1 = 1;
        int cnt2 = 1;

        TreeNode nodeL = root.left;
        TreeNode nodeR = root.right;

        //左节点遍历直到底，然后计算深度
        while (nodeL != null) {
            nodeL = nodeL.left;
            cnt1++;
        }

        //遍历右子树的左边
        if (nodeR != null) {
            cnt2 ++;
            TreeNode tempRL = nodeR.left;
            while (tempRL != null) {
                tempRL = tempRL.left;
                cnt2++;
            }
        }
        //左移运算符
        if (cnt1 == 1 && cnt2 == 1) return 1;
        if (cnt1 == cnt2) return ((1 << (cnt1 - 1)) - 1) + countNodes(root.right) + 1;
        if (cnt1 > cnt2) return ((1 << (cnt2 - 1)) - 1) + countNodes(root.left) + 1;

        return 0;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        //root.left.left = new TreeNode(0);
        //root.left.right = new TreeNode(0);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(0);

//        root.left.left.left = new TreeNode(0);

        P222_Count_Complete_Tree_Nodes p = new P222_Count_Complete_Tree_Nodes();

        System.out.println(p.countNodes(null));

    }
}
