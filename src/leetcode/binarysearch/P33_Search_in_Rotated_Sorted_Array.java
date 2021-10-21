package leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/10/19 23:12
 */
public class P33_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        // 先找最小值的值
        int l = 0;
        int r = nums.length - 1;
        while (l < r - 1) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[l]) {
                l = mid; /// 说明mid所在的位置是在第一个非递减子数组中
            } else if (nums[mid] <= nums[r]) {
                r = mid; /// 说明mid所在的位置是在第二个非递减子数组中
            }
        }

        int res = 0;
        if (target >= nums[0]) {
            res = binarySearch(nums, 0, r, target);
        } else {
            res = binarySearch(nums, r, nums.length, target);
        }

        return res < nums.length ? (nums[res] == target ? res : -1) : -1;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    @Test
    public void Test() {
        Assert.assertEquals(search(new int[]{4,5,6,7,0,1,2}, 0), 4);
        Assert.assertEquals(search(new int[]{4,5,6,7,0,1,2}, 100), -1);
        Assert.assertEquals(search(new int[]{4,5,6,0,1,2}, 4), 0);
        Assert.assertEquals(search(new int[]{0,1,2}, 0), 0);
        Assert.assertEquals(search(new int[]{456,0,1,2}, 0), 1);

        Assert.assertEquals(search(new int[]{0}, 0), 0);
        Assert.assertEquals(search(new int[]{456,0,1,2}, 2), 3);
        Assert.assertEquals(search(new int[]{0,1}, 2), -1);
        Assert.assertEquals(search(new int[]{0,1}, 1), 1);
        Assert.assertEquals(search(new int[]{3,1}, 1), 1);


        System.out.println(binarySearch(new int[]{1,4}, 0, 2, 4));

    }
}
