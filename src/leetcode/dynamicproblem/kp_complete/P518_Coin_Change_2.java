package leetcode.dynamicproblem.kp_complete;

import org.junit.Test;

/**
 * 完全背包
 */
public class P518_Coin_Change_2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }

        return dp[amount];
    }

    @Test
    public void test() {
        change(3, new int[]{2});
    }
}
