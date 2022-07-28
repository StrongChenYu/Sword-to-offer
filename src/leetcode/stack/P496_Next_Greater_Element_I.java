package leetcode.stack;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class P496_Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> resMap = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            resMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = resMap.get(nums1[i]);
        }

        return res;
    }

    @Test
    public void test() {
        nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }
}
