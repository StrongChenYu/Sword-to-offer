package leetcode.greedy;

import org.junit.Test;

public class P376_Wiggle_Subsequence {

    public int wiggleMaxLength(int[] nums) {
        int before = 0;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] - nums[i - 1];
            if ((before == 0 && cur != 0) || (before < 0 && cur > 0) || (before > 0 && cur < 0)) {
                before = cur;
                cnt++;
            }
        }

        return cnt;
    }

    @Test
    public void test() {
        System.out.println(wiggleMaxLength(new int[]{0,0}));
    }
}
