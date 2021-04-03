package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/4/3 11:18
 */
public class P85_Maximal_Rectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;

        int[] heights = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                    if (i > 0 && matrix[i - 1][j] == '0') {
                        heights[j] = 1;
                    }
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }

        return res;
    }

    char[][] testCase = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1', '1','1'},
            {'1','0','0','1','0'}
    };

    public void printArray(int[] arrays) {
        for (int num : arrays) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Test
    public void Test() {
        Assert.assertEquals(6, maximalRectangle(testCase));
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
