package leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/21 8:52
 */
public class P55_Jump_Game {

    public boolean canJump(int[] nums) {
        // 倒着往回判断
        int targetIdx = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= targetIdx) {
                // 说明从i位置可以跳跃到targetIdx
                // 接下来只需要判断是否可以跳跃到位置i即可
                targetIdx = i;
            }

            if (targetIdx == 0) {
                return true;
            }
        }

        return false;
    }


    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                // 看j位置能不能跳跃到
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[nums.length - 1];
    }

    @Test
    public void Test() {
//        Assert.assertTrue(canJump(new int[]{2,3,1,1,4}));
//        Assert.assertTrue(canJump(new int[]{3,2,1,5,4}));
//        Assert.assertTrue(canJump(new int[]{3,2,1,5,0}));

        jump(new int[]{2,3,0,1,4});

        Assert.assertFalse(canJump(new int[]{3,0,0,0,0}));
        Assert.assertFalse(canJump(new int[]{3,2,1,0,4}));
    }
}
