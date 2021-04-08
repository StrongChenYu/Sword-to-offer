package leetcode.dynamicproblem;

import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/8 10:45
 */
public class P120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int[] dp = new int[cols];

        dp[0] = triangle.get(0).get(0);

        int res = dp[0];
        for (int i = 1; i < rows; i++) {
            List<Integer> curLevel = triangle.get(i);
            int curSize = curLevel.size();

            int tempMin = Integer.MAX_VALUE;
            for (int j = curSize - 1; j >= 0; j--) {
                int curValue = curLevel.get(j);

                if (j == 0) {
                    dp[j] = dp[j] + curValue;
                } else if(j == curSize - 1) {
                    dp[j] = dp[j - 1] + curValue;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + curValue;
                }

                tempMin = Math.min(tempMin, dp[j]);
            }
            res = tempMin;
        }

        return res;
    }
}
