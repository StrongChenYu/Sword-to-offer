package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P93_Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(s, 0, path, res);
        return res;
    }

    private void dfs(String s, int startIdx, List<String> path, List<String> res) {
        if (path.size() == 4 && s.length() == startIdx) {
            res.add(String.join(".", path));
            return;
        }

        int num = 0;
        for (int i = startIdx; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            num = num * 10 + cur;

            if (i > startIdx && s.charAt(startIdx) == '0') {
                return;
            }

            if (num > 255) {
                return;
            }

            if (path.size() <= 3) {
                path.add(String.valueOf(num));
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }

        }
    }

    @Test
    public void test() {
        restoreIpAddresses("023");
    }
}
