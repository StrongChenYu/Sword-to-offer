package leetcode.dynamicproblem;

/**
 * @Author Chen Yu
 * @Date 2022/1/12 18:21
 */
public class P416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = (sum >> 1);
        boolean[][] dp = new boolean[n][target + 1];
        dp[0][0] = false;

        // 设置第一个元素
        if (target >= nums[0]) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (j >= nums[i]) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n - 1][target];
    }
}
