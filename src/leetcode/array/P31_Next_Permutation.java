package leetcode.array;

import org.junit.Test;

public class P31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        int j = nums.length - 1;

        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i != -1) {
            int k = nums.length - 1;
            for (; k >= j && nums[k] <= nums[i]; k--);
            swap(nums, k, i);
        }

        for (int left = j, right = nums.length - 1; left < right; left++, right--) {
            swap(nums, left, right);
        }

    }

    public void swap(int[] nums, int j, int k) {
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
    }

    @Test
    public void Test() {
        //nextPermutation(new int[]{1,2,3});
        //nextPermutation(new int[]{5,1,1});
        nextPermutation(new int[]{5,1,3});
        nextPermutation(new int[]{3,2,1});
        nextPermutation(new int[]{1,3,2});
        nextPermutation(new int[]{1});
        nextPermutation(new int[]{1,2});
        nextPermutation(new int[]{1,2,3,4,6,5});
        nextPermutation(new int[]{1,2,3,6,3,1});
    }

    public static void main(String[] args) {
        int[] nums = new int[12];
        System.out.println(nums);
    }
}
