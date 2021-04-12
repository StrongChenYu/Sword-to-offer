package leetcode.dynamicproblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/12 10:01
 */
public class P131_Palindrome_Partitioning {

    boolean[][] dp = null;

    public List<List<String>> partition(String s) {

        int n = s.length();
        dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            //[i, i + len)
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    //[i + 1,j - 1]之间的长度是len-2, 之前已经被计算过了
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }

        List<List<String>> res = getPartitionPlan(s, 0, n);
        return res;
    }


    /**
     * 区间建议为[left,right)
     * @param s
     * @param left
     * @param right
     * @return
     */
    private List<List<String>> getPartitionPlan(String s, int left, int right) {
        List<List<String>> res = new LinkedList<>();
        //空串
        if (left >= right) {
            res.add(new LinkedList<>());
            return res;
        }

        for (int i = left + 1; i <= right; i++) {
            if (dp[left][i - 1]) {
                String leftPart = s.substring(left, i);
                List<List<String>> rightRes = getPartitionPlan(s, i, right);

                for (List<String> r : rightRes) {
                    r.add(0, leftPart);
                }

                res.addAll(rightRes);
            }
        }
        return res;
    }

    @Test
    public void Test() {
        partition("a");
    }
}
