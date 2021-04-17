package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Chen Yu
 * @Date 2021/4/16 8:53
 */
public class P188_Best_Time_to_Buy_and_Sell_Stock_IV {
    
//    public int maxProfit(int k, int[] prices) {
//        if (k == 0 || prices.length == 0) return 0;
//
//        int n = prices.length;
//        int[][] buy = new int[n][k + 1];
//        int[][] sell = new int[n][k + 1];
//
//        buy[0][0] = -prices[0];
//        for (int i = 1; i < k; i++) {
//            buy[0][i] = Math.max(-prices[i], buy[0][i - 1]);
//            sell[0][i] = 0;
//        }
//
//        int res = 0;
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < k; j++) {
//                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
//                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
//                res = Math.max(res, sell[i][j]);
//            }
//        }
//
//        return res;
//    }
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            k = Math.min(k, n / 2);
            int[][] buy = new int[n][k + 1];
            int[][] sell = new int[n][k + 1];

            buy[0][0] = -prices[0];
            sell[0][0] = 0;
            for (int i = 1; i <= k; ++i) {
                buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
            }

            for (int i = 1; i < n; ++i) {
                buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                    sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
                }
            }

            return Arrays.stream(sell[n - 1]).max().getAsInt();
        }



    @Test
    public void Test() {
        Assert.assertEquals(2, maxProfit(2, new int[]{2,4,1}));
    }
}
