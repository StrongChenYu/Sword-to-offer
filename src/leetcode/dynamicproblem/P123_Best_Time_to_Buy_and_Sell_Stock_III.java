package leetcode.dynamicproblem;

/**
 * @Author Chen Yu
 * @Date 2021/4/9 8:42
 */
public class P123_Best_Time_to_Buy_and_Sell_Stock_III {

    /**
     * 思路没有任何问题，估计肯定会超时
     * 因为时间复杂度是O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit_TLE(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int left = maxProfit(prices, 0, i);
            int right = maxProfit(prices, i, prices.length);

            res = Math.max(left + right, res);
        }
        return res;
    }

    /**
     * [left,right)
     * @param prices
     * @param left
     * @param right
     * @return
     */
    public int maxProfit(int[] prices, int left, int right) {
        if (right - left <= 1) return 0;

        int min = prices[left];
        int res = 0;

        for (int i = left + 1; i < right; i++) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(min, prices[i]);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy1Max = -prices[0], sell1Max = 0;
        int buy2Max = -prices[0], sell2Max = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1Max = Math.max(buy1Max, -prices[i]);
            sell1Max = Math.max(sell1Max, prices[i] + buy1Max);
            buy2Max = Math.max(buy2Max, -prices[i] + sell1Max);
            sell2Max = Math.max(sell2Max, prices[i] + buy2Max);
            //buy3Max = Math.max(buy3Max, -prices[i] + sell2Max);
            //sell3Max = Math.max(sell3Max, prices[i] + buy3Max);
        }

        return sell2Max;
    }
}
