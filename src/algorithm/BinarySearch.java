package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

    /**
     * search target of nums
     * @param nums array
     * @param target search goal
     * @return index of target, if target is not part of nums,
     * will return index of first element greater than target
     */
    public int binarySearch_lower_bound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int middle = ((r - l) >> 1) + l;
            if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }

    public int binarySearch_upper_bound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int middle = ((r - l) >> 1) + l;
            if (nums[middle] <= target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }

    @Test
    public void Test() {
        int[] num = new int[]{1,1,3,5,6,6,6,8};
        int idx = binarySearch_upper_bound(num, 7);
        System.out.println(idx);
        System.out.println(num[idx]);
        // regular case
//        Assert.assertEquals(6, binarySearch(new int[]{1,2,3,4,5,6,7}, 7));
//        Assert.assertEquals(5, binarySearch(new int[]{1,2,3,4,5,6,7}, 6));
//        Assert.assertEquals(0, binarySearch(new int[]{1,2,3,4,5,6,7}, 1));
//
//        // bound case
//        Assert.assertEquals(0, binarySearch(new int[]{1}, 1));
//        Assert.assertEquals(0, binarySearch(new int[]{0,1}, 0));
//        Assert.assertEquals(1, binarySearch(new int[]{0,1}, 1));
//
//        // not exist case
//        Assert.assertEquals(2, binarySearch(new int[]{1,2,4,5,6,7}, 3));
//        Assert.assertEquals(0, binarySearch(new int[]{2,3,4,5,6,7}, 1));
//        Assert.assertEquals(6, binarySearch(new int[]{1,2,3,4,5,6}, 7));
//
//        // bound case
//        Assert.assertEquals(0, binarySearch(new int[]{1}, 0));
//        Assert.assertEquals(1, binarySearch(new int[]{0,2}, 1));
//        Assert.assertEquals(0, binarySearch(new int[]{0,1}, -1));
    }
}
