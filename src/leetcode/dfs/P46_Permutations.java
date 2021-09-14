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

    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int deep) {

        if (deep == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            path.add(num);
            visited.add(num);
            dfs(nums, deep + 1);

            int node = path.get(path.size() - 1);
            path.remove(path.size() - 1);
            visited.remove(node);
        }
    }

    @Test
    public void Test() {
        permute(new int[]{1});
    }
}
