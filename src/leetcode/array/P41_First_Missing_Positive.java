package leetcode.array;

import org.junit.Test;

public class P41_First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //[1,n]
        for (int i = 0; i < n; i++) {
            while (nums[i] <= n && nums[i] >= 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        int i = 0;
        for (i = 0; i < n; i++) {
            int wantedIdx = nums[i] - 1;
            if (wantedIdx < 0 || wantedIdx >= n || i != wantedIdx) {
                return i + 1;
            }
        }

        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{-1,-1,-1,-1,-1}));
        System.out.println(firstMissingPositive(new int[]{1,1,2,2,4,4}));
    }

}
