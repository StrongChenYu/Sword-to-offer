package leetcode.stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class P739_Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < res.length; i++) {
            // 栈不为空，顶部元素小于当前元素，逐一出栈判断，然后入栈
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer top = stack.pop();
                // top是idx，判断和当前i的差值
                res[top] = i - top;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }

        return res;
    }

    @Test
    public void Test() {
        dailyTemperatures(new int[]{9,8});
    }
}
