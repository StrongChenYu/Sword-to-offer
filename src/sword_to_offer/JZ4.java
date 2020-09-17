package sword_to_offer;

/*
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class JZ4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) return null;
        if (pre.length != in.length) return null;
        if (pre.length == 0) return null;

        int pl = 0, pr = pre.length - 1;
        int il = 0, ir = pr;
        return helpRecursionFun(pre, pl, pr, in, il, ir);
    }

    public TreeNode helpRecursionFun(int[] pre, int pl, int pr, int[] in, int il, int ir) {
        if (pl > pr || il > ir) return null;
        if (pl >= pre.length || pr >= pre.length || il >= in.length || ir >= in.length) return null;

        //pr == pl  只有一个节点存在，in数组里也只有一个节点存在
        if (pl == pr) return new TreeNode(pre[pl]);


        int rootVal = pre[pl];
        int rootIndex = 0;
        for (int i = il; i <= ir; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(pre[pl]);
        int leftL = rootIndex - il;
        root.left = helpRecursionFun(pre, pl + 1, pl + leftL, in, il, rootIndex - 1);
        root.right = helpRecursionFun(pre, pl + leftL + 1, pr, in, rootIndex + 1, ir);

        return root;
    }
}
