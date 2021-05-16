package leetcode.array;

import org.junit.Test;

public class P27_Remove_Element {

    public int removeElement(int[] nums, int val) {

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[idx++] = nums[i];
        }
        return idx;
    }

    @Test
    public void Test() {
        int[] a = new int[]{1,1,1,1,1,2,3,4,5,6,6,6,6,6,6};
        int len = removeElement(a,1);

        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
