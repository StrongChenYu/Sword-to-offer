package leetcode.tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P437_Path_Sum_III {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        return dfs(root, 0, targetSum, cntMap);
    }

    public int dfs(TreeNode root, int lastSum, int targetSum, Map<Integer, Integer> cntMap) {
        if (root == null) {
            return 0;
        }

        int curSum = lastSum + root.val;
        int curCnt = cntMap.getOrDefault(curSum - targetSum, 0);

        cntMap.put(curSum, cntMap.getOrDefault(curSum, 0) + 1);
        curCnt += dfs(root.left, curSum, targetSum, cntMap);
        curCnt += dfs(root.right, curSum, targetSum, cntMap);
        cntMap.put(curSum, cntMap.getOrDefault(curSum, 0) - 1);

        return curCnt;
    }
}
