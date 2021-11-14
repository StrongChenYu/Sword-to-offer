package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/9/14 19:37
 */
public class P39_Combination_Sum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        dfs(candidates, target);
        return res;
    }

    public void dfs(int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        boolean[] visited = new boolean[candidates.length];
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (target < candidates[i]) {
                count++;
                continue;
            }


            path.add(candidates[i]);
            dfs(candidates, target - candidates[i]);

            // 回溯
            path.remove(path.size() - 1);
            target += candidates[i];
            visited[i] = true;
        }
    }

    @Test
    public void Test() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
