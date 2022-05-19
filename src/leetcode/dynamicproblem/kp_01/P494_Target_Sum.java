package leetcode.dynamicproblem.kp_01;

import org.junit.Test;

public class P494_Target_Sum {

    public int findTargetSumWaysRecursive(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num);
        }

        if (sum < Math.abs(target)) {
            return 0;
        }

        // 大概是这么个意思
        // <0 ==0 >0
        // 三个区间
        int n = (sum << 1) + 1;
        int[][] dp = new int[nums.length + 1][n];

        dp[0][sum] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < n; j++) {
                int num = nums[i - 1];
                if (j - num >= 0) {
                    dp[i][j] += dp[i - 1][j - num];
                }

                if (j + num < n) {
                    dp[i][j] += dp[i - 1][j + num];
                }
            }
        }

        return dp[nums.length][target + sum];
    }


    @Test
    public void Test() {
        System.out.println(findTargetSumWaysRecursive(new int[]{1,1,1,1,1}, 3));
        System.out.println(findTargetSumWaysRecursive(new int[]{0,0,0,0,0,0,0,0,1}, 1));
        System.out.println(findTargetSumWaysRecursive(new int[]{}, 1));
        System.out.println(findTargetSumWaysRecursive(new int[]{100}, -200));
    }
}
