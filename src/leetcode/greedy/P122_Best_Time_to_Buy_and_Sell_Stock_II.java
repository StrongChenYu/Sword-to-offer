package leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/9 8:52
 */
public class P122_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[i - 1]) {
                //递增序列continue
                res += prices[i - 1] - min;
                min = prices[i];
            }
        }

        /**
         * 处理一下最后一个值
         */
        res += prices[prices.length - 1] - min;

        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(3, maxProfit(new int[]{7,6,5,4,5,6,7}));
        Assert.assertEquals(7, maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
