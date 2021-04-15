package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/4/14 19:42
 */
public class P152_Maximum_Product_Subarray {

    /**
     * 为什么要用两个dp数组
     * dpMax保存以i结尾的最大值，
     * 由于最大值可由以下几种计算方式得到：
     * 1. 前i-1个的负最小值乘以一个负数
     * 2. 前i-1个的负最小值乘以正数，（当前值）
     * 3. 前i-1个的正最大值乘以正数
     *
     * 所以需要保存以i-1结尾的负最小值，然后判断
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        int res = Integer.MIN_VALUE;
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]), nums[i]);
            dpMin[i] = Math.min(Math.min(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]), nums[i]);
            res = Math.max(res, dpMax[i]);
        }

        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(0, maxProduct(new int[]{2,3,-2,4}));
    }
}
