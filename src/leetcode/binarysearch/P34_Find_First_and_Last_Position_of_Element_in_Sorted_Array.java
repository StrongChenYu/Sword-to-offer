package leetcode.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        int leftBound = binarySearch(nums, target);
        if (leftBound >= nums.length || nums[leftBound] != target) {
            return res;
        }

        int rightBound = binarySearch(nums, target + 1);
        res[0] = leftBound;
        res[1] = rightBound - 1;

        return res;
    }

    //return >=target first index
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

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


    @Test
    public void Test() {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2, 2, 2, 2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2, 2, 2, 2, 2}, 2)));

//        System.out.println(binarySearch2(new int[]{1, 2, 2,2,2,2, 3, 4}, 2));
//        System.out.println(binarySearch2(new int[]{1, 2, 2,2,2,2, 3, 4}, 2));
//        System.out.println(binarySearch2(new int[]{1, 2, 2,2,2,2, 3, 4}, 2));
//        System.out.println(binarySearch2(new int[]{1, 2, 2,2,2,2, 3, 4}, 4));
    }
}
