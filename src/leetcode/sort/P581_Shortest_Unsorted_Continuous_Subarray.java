package leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Chen Yu
 * @Date 2022/3/9 23:13
 */
public class P581_Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int left = 0;
        int right = nums.length - 1;

        for (; left < nums.length && nums[left] == copy[left]; left++);
        for (; right >= 0 && nums[right] == copy[right]; right--);

        if (left > right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

    @Test
    public void Test() {
        System.out.println(findUnsortedSubarray(new int[]{1,2}));
    }

}
