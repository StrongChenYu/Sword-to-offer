package leetcode.dynamicproblem;

import org.junit.Test;

public class P376_Wiggle_Subsequence {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] dpAbove = new int[n];
        int[] dpBelow = new int[n];

        dpAbove[0] = 1;
        dpBelow[1] = 1;

        for (int i = 1; i < n; i++) {
            int cur = nums[i] - nums[i - 1];
            if (cur > 0) {
                dpAbove[i] = Math.max(dpBelow[i - 1] + 1, dpAbove[i - 1]);
            } else if (cur < 0) {
                dpBelow[i] = Math.max(dpAbove[i - 1] + 1, dpBelow[i - 1]);
            }
        }

        return Math.max(dpAbove[n - 1], dpBelow[n - 1]);
    }

    @Test
    public void test() {
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
}
