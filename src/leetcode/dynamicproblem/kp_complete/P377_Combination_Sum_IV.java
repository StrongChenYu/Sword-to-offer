package leetcode.dynamicproblem.kp_complete;

import org.junit.Test;

public class P377_Combination_Sum_IV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        combinationSum4(new int[]{1,2,3}, 4);
    }
}
