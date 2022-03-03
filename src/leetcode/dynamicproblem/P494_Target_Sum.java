package leetcode.dynamicproblem;

import org.junit.Test;

public class P494_Target_Sum {

    public int findTargetSumWaysRecursive(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num);
        }

        if (sum < Math.abs(target)) {
            // 如果所有和的绝对值都无法大于target，说明无论怎么组合都没办法得到想要的结果，所以返回0
            return 0;
        }


        // 根据计算得到的sum设置dp数组
        int row = nums.length;
        int col = (sum << 1) + 1;
        int[][] dp = new int[row][col];

        // 设置dp初始条件
        if (nums[0] == 0) {
            // nums为0的话就会有两种情况，这两种情况就会合在一起
            dp[0][sum] = 2;
        } else {
            dp[0][+nums[0] + sum] = 1;
            dp[0][-nums[0] + sum] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j + nums[i] < col) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
                if (j - nums[i] >= 0) {
                    // dp[i-1][j - sum - nums[i] + sum]
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[row - 1][target + sum];
    }


    @Test
    public void Test() {
        System.out.println(findTargetSumWaysRecursive(new int[]{0,0,0,0,0,0,0,0,1}, 1));
        System.out.println(findTargetSumWaysRecursive(new int[]{}, 1));
        System.out.println(findTargetSumWaysRecursive(new int[]{100}, -200));
    }
}
