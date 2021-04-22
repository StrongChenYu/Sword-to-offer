package leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/22 9:58
 */
public class P45_Jump_Game_II {

    public int jump(int[] nums) {
        int n = nums.length - 1;

        int jumpCount = 0;
        int startPos = 0;
        int endPos = 0;
        while (endPos < n) {
            int maxPos = 0;

            for (int i = startPos; i <= endPos; i++) {
                maxPos = Math.max(nums[i] + i, maxPos);
            }

            startPos = endPos + 1;
            endPos = maxPos;
            jumpCount++;
        }

        return jumpCount;
    }

    @Test
    public void Test() {
        Assert.assertEquals(2, jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(4, jump(new int[]{3,2,1,1,4,100,1,1,1,1,1}));
        Assert.assertEquals(0, jump(new int[]{3}));
        Assert.assertEquals(1, jump(new int[]{1,1}));
    }
}
