package leetcode.dfs;

import org.junit.Test;

import java.util.*;

public class P40_Combination_Sum_II {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int begin) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        int i = begin;
        for (; i < candidates.length; i++) {

            path.add(candidates[i]);
            int left = target - candidates[i];

            if (left >= 0) {
                dfs(candidates, left, i + 1);
            }

            path.remove(path.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        }
    }

    @Test
    public void Test() {
        combinationSum2(new int[]{1,1,2,2,2,2,3,4,4,5,5}, 8);
    }
}
