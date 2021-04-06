package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/6 13:27
 */
public class P264_Ugly_Number_II {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];

        dp[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            int num1 = dp[idx2] * 2;
            int num2 = dp[idx3] * 3;
            int num3 = dp[idx5] * 5;

            dp[i] = Math.min(num1, Math.min(num2, num3));

            if (num1 == dp[i]) idx2++;
            if (num2 == dp[i]) idx3++;
            if (num3 == dp[i]) idx5++;
        }

        return dp[n - 1];
    }

    @Test
    public void Test() {
        Assert.assertEquals(12, nthUglyNumber(10));
    }
}
