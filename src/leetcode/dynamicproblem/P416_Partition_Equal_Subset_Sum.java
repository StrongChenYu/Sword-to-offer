package leetcode.dynamicproblem;

import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2022/1/12 18:21
 */
public class P416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            // sum 为奇数，所以不可能有结果
            return false;
        }

        // 取一半
        sum = sum >> 1;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];

        // 初始化第一列
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // 初始化第一行
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 不选取当前元素
                dp[i][j] |= dp[i - 1][j];
                // 选取当前元素
                if (j - nums[i] >= 0) {
                    // 这里不能是i
                    // 原因是因为如果是i的表示的是当前的行，当前的行会包括当前的元素，也就不满足只能用一次的条件
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n - 1][sum];
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1,2,5}));
    }
}
