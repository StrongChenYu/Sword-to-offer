package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/3/31 19:31
 */
public class P84_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    int[][] heights = {
            {2,1,5,6,2,3},
            {2,4},
            {5},
            {1,2},
            {}
    };

    int[] want = {
            10,
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
}
