package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/6 9:30
 */
public class P96_Unique_Binary_Search_Trees {

    public int numTrees(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }

        return dp[n];
    }


    @Test
    public void Test() {
        Assert.assertEquals(5, numTrees(3));
        Assert.assertEquals(1, 1);
    }
}
