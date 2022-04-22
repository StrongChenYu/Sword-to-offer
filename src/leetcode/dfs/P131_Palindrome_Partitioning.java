package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(s, 0, res, path);

        return res;
    }

    private void dfs(String s, int startIdx, List<List<String>> res, List<String> path) {
        if (s.length() == startIdx) {
            res.add(new ArrayList<>(path));
            return;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = startIdx; i < s.length(); i++) {
            builder.append(s.charAt(i));

            if (isHuiWen(s, startIdx, i)) {
                path.add(builder.toString());
                dfs(s, i + 1, res, path);
                path.remove(path.size() - 1);
            }

        }
    }

    private boolean isHuiWen(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        partition("aab");
    }
}
