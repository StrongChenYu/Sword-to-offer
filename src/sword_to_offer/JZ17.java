package sword_to_offer;

import structure.TreeNode;

public class JZ17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;

        //这种情况下root2必不为空，所以只需判断root1就可以了
        if (root1 == null) return false;

        if (root1.val == root2.val) {
            boolean res = isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);

            if (res) return true;
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (root1.val == root2.val)
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);

        return false;
    }


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);


        TreeNode root2 = new TreeNode(9);
        //root2.left = new TreeNode(4);
        //root2.right = new TreeNode(7);

        JZ17 jz17 = new JZ17();

        System.out.println(jz17.HasSubtree(root1, root2));
    }
}
