package leetcode.dfs;

import org.junit.Test;

import java.util.*;

public class P39_Combination_Sum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int begin) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {

            path.add(candidates[i]);
            int left = target - candidates[i];

            if (left >= 0) {
                dfs(candidates, left, i);
            }

            path.remove(path.size() - 1);
        }
    }



    @Test
    public void Test() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
