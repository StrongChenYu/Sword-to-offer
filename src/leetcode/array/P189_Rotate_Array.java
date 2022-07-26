package leetcode.array;

import org.junit.Test;

import java.util.Arrays;

public class P189_Rotate_Array {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int splitIdx = n - k;
        reverse(nums, 0, splitIdx);
        reverse(nums, splitIdx, n);
        reverse(nums, 0, n);
    }

    //[start, end)
    public void reverse(int[] nums, int start, int end) {

        int left = start;
        int right = end - 1;

        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
