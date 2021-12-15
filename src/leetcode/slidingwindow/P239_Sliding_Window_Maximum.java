package leetcode.slidingwindow;

import org.junit.Test;

import java.util.*;

public class P239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);

            // 主要判断队首元素在不在范围内
            if (queue.peekFirst() <= i - k) {
                queue.removeFirst();
            }

            // 主要判断窗口是不是k
            if (i - k >= -1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void Test() {
        maxSlidingWindow(new int[]{1,2,3,4,5,6,7}, 6);
    }
}
