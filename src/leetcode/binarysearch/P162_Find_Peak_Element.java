package leetcode.binarysearch;

import org.junit.Test;

public class P162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;

        // [0, left)
        // [right, num.length]
        // [left, right) 搜索区间
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (middle + 1 < nums.length && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{2,1}));
    }
}
