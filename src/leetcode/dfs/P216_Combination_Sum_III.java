package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class P216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(k, n, 1, result, path, 0);

        return result;
    }


    public void dfs(int k, int n, int startIdx, List<List<Integer>> result, List<Integer> path, int sum) {
        if (k == path.size() && n == sum) {
            result.add(new ArrayList<>(path));
            return;
        }


        // 如果后面的元素不够k个： 剪枝
        // 还需要多少个：leftCnt = k - path.size()
        // min = leftCnt * n 后面能选到的最大值
        // max = leftCnt * startIdx 后面能选择到的最小值
        // 需要的值：
        //
        int end = Math.min(9, n);
        for (int i = startIdx; i <= end; i++) {

            int leftCnt = k - path.size();
            if (end - i + 1 < leftCnt) {
                continue;
            }

            int min = i * leftCnt;
            int max = end * leftCnt;

            if (n - sum < min || n - sum > max) {
                return;
            }

            path.add(i);
            dfs(k, n, i + 1, result, path, sum + i);
            path.remove(path.size() - 1);
        }

    }
}
