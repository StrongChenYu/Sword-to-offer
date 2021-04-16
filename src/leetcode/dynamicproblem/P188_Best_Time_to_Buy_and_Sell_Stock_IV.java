package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/16 8:53
 */
public class P188_Best_Time_to_Buy_and_Sell_Stock_IV {
    
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;

        int n = prices.length;
        int[][] buyMaxDp = new int[k][n];
        int[][] sellMaxDp = new int[k][n];

        for (int i = 0; i < k; i++) {
            buyMaxDp[i][0] = -prices[0];
            sellMaxDp[i][0] = 0;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                System.out.println("j = " + j + " i = " + i);
                buyMaxDp[j][i] = Math.max(buyMaxDp[j][i], -prices[i] + sellMaxDp[j - 1][i]);
                sellMaxDp[j][i] = Math.max(sellMaxDp[j][i], buyMaxDp[j - 1][i] + prices[i]);
                res = Math.max(res, sellMaxDp[j][i]);
            }
        }

        return sellMaxDp[k - 1][n - 1];
    }


    @Test
    public void Test() {
        Assert.assertEquals(2, maxProfit(3, new int[]{2,4,1,6,5,3}));
    }
}
