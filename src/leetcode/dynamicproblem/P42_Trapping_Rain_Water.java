package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/3/25 20:56
 */
public class P42_Trapping_Rain_Water {


    /**
     * 使用单调递减栈来解决
     * @param height
     * @return
     */
    public int trap_Descending_Stack(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        int curIdx = 0;
        while (curIdx < height.length) {
            /**
             * 大于往出取
             * 直到计算出结果来
             */
            while (!stack.isEmpty() && height[stack.peek()] < height[curIdx]) {
                int minIdx = stack.pop();
                int minHeight = height[minIdx];

                /**
                 * 因为还需要再看一个位置
                 * 如果这个时候栈空了，说明是第一个
                 * 直接跳出
                 */
                if (stack.isEmpty()) break;

                int leftIdx = stack.peek();
                int leftHeight = height[leftIdx];

                /**
                 * 因为leftIndex和minIdx并不一直是挨着的
                 */
                res += (Math.min(height[curIdx], leftHeight) - minHeight) * (curIdx - leftIdx - 1);
            }

            /**
             * 小于往进放
             */
            stack.push(curIdx++);
        }

        return res;
    }

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
     * 其实就是先遍历一下存起来。。。。也勉强算是动态规划吧
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
        Assert.assertEquals(trap_Descending_Stack(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
        Assert.assertEquals(trap_Descending_Stack(new int[]{3,2,1,1,3,4}), 5);
    }

    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

}
