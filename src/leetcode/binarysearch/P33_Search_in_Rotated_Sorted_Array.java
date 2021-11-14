package leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class P33_Search_in_Rotated_Sorted_Array {
    @Test
    public void Test() {
        Assert.assertEquals(search(new int[]{1,2,3},1),0);
        Assert.assertEquals(search(new int[]{5,6,7,8,1,2,3},1),4);
        Assert.assertEquals(search(new int[]{7,5},5),1);
        Assert.assertEquals(search(new int[]{7,5},7),0);
        Assert.assertEquals(search(new int[]{1,2},1),0);
        Assert.assertEquals(search(new int[]{1,2},2),1);
        Assert.assertEquals(search(new int[]{1},1),0);


        Assert.assertEquals(search(new int[]{1,2,3},0),-1);
        Assert.assertEquals(search(new int[]{5,6,7,8,1,2,3},0),-1);
        Assert.assertEquals(search(new int[]{7,5},0),-1);
        Assert.assertEquals(search(new int[]{7,5},0),-1);
        Assert.assertEquals(search(new int[]{1,2},0),-1);
        Assert.assertEquals(search(new int[]{1,2},0),-1);
        Assert.assertEquals(search(new int[]{1},0),-1);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int n = nums.length;
        int right = n;

        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] <= nums[n - 1]) {
                right = middle;
            } else if (nums[middle] >= nums[0]) {
                left = middle + 1;
            }
        }

        int res = 0;
        if (target <= nums[n - 1]) {
            res = binarySearch(nums, left, n, target);
        } else {
            res = binarySearch(nums, 0, left, target);
        }

        return res < n ? (nums[res] == target ? res : -1) : -1;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = a + (a >> 1);
        System.out.println(b);
    }
}
