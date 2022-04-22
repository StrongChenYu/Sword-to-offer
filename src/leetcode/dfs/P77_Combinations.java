package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class P77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(n, k, 1, result, path);

        return result;
    }

    private void dfs(int n, int k, int startIdx, List<List<Integer>> result, List<Integer> path) {
        if (k == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 从[startIdx, n]选k个元素
        // 还需要多少个：left = k - path.size()
        // 那么从idx多少开始就表示元素不够了呢？
        // n - (k - path.size()) + 1
        for (int i = startIdx; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, result, path);
            path.remove(path.size() - 1);
        }

        return;
    }
}
