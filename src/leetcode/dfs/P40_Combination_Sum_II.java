package leetcode.dfs;

import org.junit.Test;

import java.util.*;

public class P40_Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, res, path);

        return res;
    }

    private void dfs(int[] candidates, int startIdx, int target, List<List<Integer>> res, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {

            if (i > startIdx && candidates[i - 1] == candidates[i]) {
                continue;
            }

            if (candidates[i] > target) {
                return;
            }


            path.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], res, path);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void Test() {
        combinationSum2(new int[]{1,1,2,2,2,2,3,4,4,5,5}, 8);
    }
}
