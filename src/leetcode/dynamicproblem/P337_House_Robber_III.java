package leetcode.dynamicproblem;

import structure.TreeNode;

public class P337_House_Robber_III {


    public int rob(TreeNode root) {
        int[] res = robHelp(root);
        return Math.max(res[0], res[1]);
    }

    // result 中的第一个元素代表偷
    //           第二个元素代表不偷
    public int[] robHelp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftStatus = robHelp(root.left);
        int[] rightStates = robHelp(root.right);

        // 偷
        int rob = root.val + leftStatus[1] + rightStates[1];

        // 不偷
        int notRob = Math.max(Math.max(leftStatus[0] + rightStates[0],
                                       leftStatus[0] + rightStates[1]),
                              Math.max(leftStatus[1] + rightStates[0],
                                       leftStatus[1] + rightStates[1]));

        return new int[]{rob, notRob};
    }
}
