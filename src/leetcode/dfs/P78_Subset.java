package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P78_Subset {
    public List<List<Integer>> subsets_list(int[] nums) {
        int max = (int) Math.pow(2, nums.length);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {

            List<Integer> temp = new ArrayList<>();
            int idx = 0;
            int num = i;
            while (num != 0) {
                if ((num & 1) == 1) {
                    temp.add(nums[idx]);
                }
                idx++;
                num = num >> 1;
            }

            res.add(temp);
        }

        return res;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(res, path, nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int startIdx) {
        res.add(new ArrayList<>(path));
        System.out.println(Arrays.toString(path.toArray()));
        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        subsets(new int[]{1,2,3});
    }
}
