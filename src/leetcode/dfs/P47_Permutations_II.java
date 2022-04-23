package leetcode.dfs;

import org.junit.Test;

import java.util.*;

/**
 * @Author Chen Yu
 * @Date 2021/9/14 15:14
 */
public class P47_Permutations_II {

    public List<List<Integer>> permuteUnique(int[] nums) {

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

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            path.add(nums[i]);
            visited[i] = true;

            dfs(nums, res, path, visited);

            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }


    @Test
    public void Test() {
    }
}
