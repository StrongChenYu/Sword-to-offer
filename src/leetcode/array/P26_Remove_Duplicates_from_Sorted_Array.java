package leetcode.array;

import org.junit.Test;

public class P26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            nums[idx++] = nums[i];
        }

        return idx;
    }

    @Test
    public void Test() {
        int[] a = new int[]{1};
        int len = removeDuplicates(a);

        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
