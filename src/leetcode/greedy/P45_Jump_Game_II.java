package leetcode.greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/22 9:58
 */
public class P45_Jump_Game_II {

    public int jump(int[] nums) {
        int left = 0;
        int right = 0;

        int jumpCnt = 0;
        while (right < nums.length - 1) {

            int max = right;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
            }


            right = max;
            left++;
            jumpCnt++;
        }

        return jumpCnt;
    }

    @Test
    public void Test() {
        Assert.assertEquals(2, jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(4, jump(new int[]{3,2,1,1,4,100,1,1,1,1,1}));
        Assert.assertEquals(0, jump(new int[]{3}));
        Assert.assertEquals(1, jump(new int[]{1,1}));
    }
}
