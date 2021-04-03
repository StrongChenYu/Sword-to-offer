package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/3/31 19:31
 */
public class P84_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea_bad(int[] heights) {
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                res = Math.max(res, min * (j - i + 1));
            }
        }

        return res;
    }


    int[][] heights = {
            {2,3,4,1,5},
            {2,4},
            {5},
            {1,2},
            {}
    };

    int[] want = {
            6,
            4,
            5,
            2,
            0
    };

    @Test
    public void Test() {
        int size = heights.length;
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(want[i], largestRectangleArea(heights[i]));
            System.out.println("test:" + i + " pass!");
        }
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

}
