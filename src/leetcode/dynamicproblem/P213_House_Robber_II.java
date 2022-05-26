package leetcode.dynamicproblem;

import org.junit.Test;

public class P213_House_Robber_II {


    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int a = rob_help(nums, 1, nums.length - 1);
        int b = rob_help(nums, 0, nums.length - 2);
        System.out.println(a + " " + b);
        return Math.max(a, b);
    }

    public int rob_help(int[] nums, int start, int end) {
        int pre = 0;
        int cnt = nums[start];

        for (int i = start + 1; i <= end; i++) {
            int temp = cnt;
            cnt = Math.max(cnt, pre + nums[i]);
            pre = temp;
        }

        return cnt;
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1}));
    }
}
