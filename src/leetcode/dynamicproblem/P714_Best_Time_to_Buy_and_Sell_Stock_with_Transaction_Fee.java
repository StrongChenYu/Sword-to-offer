package leetcode.dynamicproblem;

import org.junit.Test;

public class P714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public int maxProfit(int[] prices, int fee) {
        int[] dpOwn = new int[prices.length];
        int[] dpNotOwn = new int[prices.length];

        // 拥有和不拥有状态更好理解
        dpOwn[0] = -prices[0];
        dpNotOwn[0] = 0;

        int n = prices.length;
        for (int i = 1; i < n; i++) {
            dpOwn[i] = Math.max(dpOwn[i - 1], dpNotOwn[i - 1] - prices[i]);
            dpNotOwn[i] = Math.max(dpNotOwn[i - 1], dpOwn[i - 1] + prices[i] - fee);
        }

        return Math.max(dpNotOwn[n - 1], dpOwn[n - 1]);
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
