package leetcode.dynamicproblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/8 10:45
 */
public class P120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        int[] dp = new int[m];

        for (int i = 0; i < n; i++) {
            List<Integer> curRow = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                int curNum = curRow.get(j);

                if (j == 0) {
                    dp[j] = dp[j] + curNum;
                    continue;
                }

                if (j == i) {
                    dp[j] = dp[j - 1] + curNum;
                    continue;
                }

                dp[j] = Math.min(dp[j] + curNum, dp[j - 1] + curNum);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i : dp) {
            res = Math.min(res, i);
        }

        return res;
    }

    @Test
    public void test() {
        List<List<Integer>> data = new ArrayList<>();

        data.add(Arrays.asList(2));
        data.add(Arrays.asList(3,4));
        data.add(Arrays.asList(6,5,7));
        data.add(Arrays.asList(4,1,8,3));

        minimumTotal(data);
    }
}
