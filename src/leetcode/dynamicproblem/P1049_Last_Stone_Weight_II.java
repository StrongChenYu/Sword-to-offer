package leetcode.dynamicproblem;

import org.junit.Test;

public class P1049_Last_Stone_Weight_II {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int temp = (sum >> 1);
        boolean[] dp = new boolean[temp + 1];

        dp[0] = true;

        int maxJ = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = temp; j >= 0; j--) {
                if (j - stones[i] >= 0) {
                    dp[j] |= dp[j - stones[i]];
                    if (dp[j]) {
                        maxJ = Math.max(maxJ, j);
                    }
                }
            }
        }

        return sum - 2 * maxJ;
    }

    @Test
    public void test() {
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}
