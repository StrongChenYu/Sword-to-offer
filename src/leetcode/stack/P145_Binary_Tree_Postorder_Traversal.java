package leetcode.stack;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/19 9:17
 */
public class P145_Binary_Tree_Postorder_Traversal {


    /**
     * 前序遍历和后序遍历很好解决
     * 前序遍历是中->左->右
     * 后序遍历是左->右->中
     * 中->右->左  反过来正好是后序遍历的顺序
     *
     * 所以
     * 中->左->右
     * 中->右->左
     * 只需要直接放到栈里面即可
     * 都是先中，所以放栈之前都可以输出
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> resTemp = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            resTemp.push(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        while (!resTemp.isEmpty()) {
            res.add(resTemp.pop());
        }

        return res;
    }
}
