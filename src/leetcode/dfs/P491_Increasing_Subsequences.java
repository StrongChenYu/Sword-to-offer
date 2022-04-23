package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P491_Increasing_Subsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, res, path, 0);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int startIdx) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (path.size() == 0 || path.get(path.size() - 1) <= nums[i]) {
                path.add(nums[i]);
                dfs(nums, res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        findSubsequences(new int[]{4,4,3,2,1});
    }
}
