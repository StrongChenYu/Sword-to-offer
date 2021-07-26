package leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class P4_Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;

        if ((sum & 1) == 1) {
            return findKthElement(nums1, nums2, sum / 2 + 1);
        } else {
            double d1 = findKthElement(nums1, nums2, sum / 2);
            double d2 = findKthElement(nums1, nums2, sum / 2 + 1);
            return (d1 + d2) / 2;
        }
    }
    
    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            int length = k >> 1;

            if (length == 0) return Math.min(nums1[l1], nums2[l2]);

            int tryL1 = Math.min(l1 + length, nums1.length);
            int tryL2 = Math.min(l2 + length, nums2.length);

            if (nums1[tryL1 - 1] < nums2[tryL2 -1]) {
                //update k
                k -= tryL1 - l1;
                l1 += length;
            } else {
                k -= tryL2 - l2;
                l2 += length;
            }
        }

        if (l1 < nums1.length) return nums1[l1 + k - 1];
        if (l2 < nums2.length) return nums2[l2 + k - 1];

        return 0;
    }

    @Test
    public void Test() {
        for (int i = 1; i <= 7; i++) {
            Assert.assertEquals(i, findKthElement(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7}, i));
        }

        Assert.assertEquals(4, findKthElement(new int[]{1}, new int[]{4}, 2));
        Assert.assertEquals(1, findKthElement(new int[]{1}, new int[]{}, 1));
        Assert.assertEquals(3, findKthElement(new int[]{1,2,3}, new int[]{}, 3));
        Assert.assertEquals(2, findKthElement(new int[]{1,2,3}, new int[]{1,2,3}, 4));
        Assert.assertEquals(0, findKthElement(new int[]{}, new int[]{}, 0));

        for (int i = 1; i <= 8; i++) {
            Assert.assertEquals(1, findKthElement(new int[]{1,1,1,1}, new int[]{1,1,1,1}, i));
        }

        for(int i = 1; i <= 8; i++) {
            Assert.assertEquals(i, findKthElement(new int[]{1,3,5,7}, new int[]{2,4,6,8}, i));
        }

        Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 0.00001);
        Assert.assertEquals(2.5, findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}), 0.00001);
        Assert.assertEquals(1.0, findMedianSortedArrays(new int[]{}, new int[]{1}), 0.00001);
        Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{2}, new int[]{}), 0.00001);
        Assert.assertEquals(0.0, findMedianSortedArrays(new int[]{}, new int[]{}), 0.00001);
        Assert.assertEquals(0.0, findMedianSortedArrays(new int[]{0}, new int[]{}), 0.00001);
        Assert.assertEquals(0.0, findMedianSortedArrays(new int[]{}, new int[]{0}), 0.00001);
        Assert.assertEquals(4.5, findMedianSortedArrays(new int[]{1,3,5,7}, new int[]{2,4,6,8}), 0.00001);
    }
}