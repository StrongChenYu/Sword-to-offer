package leetcode.dynamicproblem;

import org.junit.Test;

public class P300_Longest_Increasing_Subsequence {
    // O(N^2) solution
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                dp[i] = nums[j] < nums[i] ? Math.max(dp[i], dp[j] + 1) : dp[i];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    @Test
    public void Test() {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
