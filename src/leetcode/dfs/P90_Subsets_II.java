package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, res, path, 0);

        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int startIdx) {
        res.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        subsetsWithDup(new int[]{1,2,2});
    }

}
