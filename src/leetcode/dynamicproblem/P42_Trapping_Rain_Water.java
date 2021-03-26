package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/3/25 20:56
 */
public class P42_Trapping_Rain_Water {

    /**
     * 双指针算法
     * 很巧妙
     * @param height
     * @return
     */
    public int trap_Two_Point(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0, rightMax = 0;

        int res = 0;

        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }

    /**
     * 其实就是先遍历一下存起来。。。。
     * @param height
     * @return
     */
    public int trap_DP(int[] height) {
        if (height == null || height.length <= 0) return 0;
        int n = height.length;
        int res = 0;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(rightMax[i],leftMax[i]) - height[i];
        }

        return res;
    }

    public int trap(int[] height) {
        int res = 0;

        for (int i = 1; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(trap_Two_Point(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
        Assert.assertEquals(trap_Two_Point(new int[]{4,2,7,2,5}), 5);
    }
}
