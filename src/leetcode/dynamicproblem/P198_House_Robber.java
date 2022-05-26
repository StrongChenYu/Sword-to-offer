package leetcode.dynamicproblem;

import org.junit.Test;

public class P198_House_Robber {

    public int rob(int[] nums) {
        int pre = 0;
        int cnt = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = cnt;
            cnt = Math.max(cnt, pre + nums[i]);
            pre = temp;
        }

        return cnt;
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
