package leetcode.dynamicproblem;

/**
 * @Author Chen Yu
 * @Date 2021/4/9 8:30
 */
public class P121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(min, prices[i]);
        }

        return res;
    }
}
