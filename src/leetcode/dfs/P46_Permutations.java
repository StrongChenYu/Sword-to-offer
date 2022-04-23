package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Chen Yu
 * @Date 2021/9/13 21:50
 */
public class P46_Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, res, path, visited);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;

            dfs(nums, res, path, visited);

            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }


    @Test
    public void Test() {
        permute(new int[]{1,2});
    }
}
