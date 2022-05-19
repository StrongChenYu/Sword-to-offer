package leetcode.dynamicproblem.kp_01;

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
        boolean[] dp = new boolean[sum + 1];

        // 默认是0的时候
        if (nums[0] <= sum) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] |= dp[j - nums[i]];
                }
            }
        }

        return dp[sum];
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1,1,1,1,1,1,1,1,1}));
    }
}
