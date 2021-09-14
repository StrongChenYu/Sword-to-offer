package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Chen Yu
 * @Date 2021/9/14 15:14
 */
public class P47_Permutations_II {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        visited = new boolean[nums.length];

        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int deep) {
        if (deep == nums.length) {
            res.add(new ArrayList<>(path));
        }

        Set<Integer> mem = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (!mem.contains(nums[i])) {
                    path.add(nums[i]);
                    visited[i] = true;

                    dfs(nums, deep + 1);

                    int lastIdx = path.size() - 1;
                    visited[i] = false;
                    path.remove(lastIdx);
                }
                mem.add(nums[i]);
            }
        }
    }

    @Test
    public void Test() {
        permuteUnique(new int[]{1,1});
    }
}
