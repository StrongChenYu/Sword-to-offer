package sword_to_offer;

import com.sun.source.tree.Tree;
import structure.TreeNode;

public class JZ26 {

    //反向思维，右->中->左
    TreeNode pre = null;

    //我偏不，我非要用另一种办法解决
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert1(pRootOfTree.right);
        pRootOfTree.right = pre;
        if (pre != null) {
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert1(pRootOfTree.left);
        return pre;
    }

    TreeNode last = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        ConvertHelp(pRootOfTree);

        TreeNode res = last;
        while (res.left != null) res = res.left;

        return res;
    }


    public void ConvertHelp(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        Convert(pRootOfTree.left);
        pRootOfTree.left = last;
        if (last != null) {
            last.right = pRootOfTree;
        }
        last = pRootOfTree;
        Convert(pRootOfTree.right);
        return;
    }

    public static void setInt(int a) {
        a = 10;
    }


    public static void main(String[] args) {
        JZ26 jz26 = new JZ26();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.left.left.left = new TreeNode(2);
        root1.left.left.left.left = new TreeNode(1);
        root1.right = new TreeNode(7);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(8);
//        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(10);
//        root1.left.left = new TreeNode(1);
//        root1.left.right = new TreeNode(5);
//        root1.left.right.left = new TreeNode(4);
//        root1.left.right.right = new TreeNode(7);

        jz26.Convert(root1);

//        int a = 5;
//        setInt(a);
//        System.out.println(a);
    }
}
