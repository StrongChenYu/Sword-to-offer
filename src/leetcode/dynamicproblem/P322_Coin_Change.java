package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

public class P322_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] status = new int[amount + 1];
        status[0] = 0;

        for (int cur = 1; cur <= amount; cur++) {

            int minCoin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int leftAmount = cur - coins[j];
                if (leftAmount >= 0 && status[leftAmount] != -1)
                    minCoin = Math.min(minCoin, 1 + status[leftAmount]);
            }
            status[cur] = minCoin == Integer.MAX_VALUE ? -1 : minCoin;
        }

        return status[amount];
    }


    @Test
    public void Test() {
        Assert.assertEquals(coinChange(new int[]{2,4}, 11), -1);
        Assert.assertEquals(coinChange(new int[]{1,2,5}, 11), 3);
        Assert.assertEquals(coinChange(new int[]{1}, 2), 2);
        Assert.assertEquals(coinChange(new int[]{1}, 1), 1);
    }
}
