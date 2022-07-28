package leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class P503_Next_Greater_Element_II {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();

        int n = nums.length;
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
                stack.pop();
            }
            res[idx] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[idx]);
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }

}
