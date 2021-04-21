package leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/21 8:52
 */
public class P55_Jump_Game {

    public boolean canJump(int[] nums) {
        int n = nums.length;

        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxPos) return false;
            maxPos = Math.max(maxPos, nums[i] + i);
            if (maxPos >= n - 1) return true;
        }

        return true;
    }


    @Test
    public void Test() {
        Assert.assertTrue(canJump(new int[]{2,3,1,1,4}));
        Assert.assertTrue(canJump(new int[]{3,2,1,5,4}));
        Assert.assertTrue(canJump(new int[]{3,2,1,5,0}));


        Assert.assertFalse(canJump(new int[]{3,0,0,0,0}));
        Assert.assertFalse(canJump(new int[]{3,2,1,0,4}));
    }
}
