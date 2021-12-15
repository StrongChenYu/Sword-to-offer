package leetcode.array;

public class P283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int p1 = 0, p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] == 0) {
                p2++;
            } else {
                nums[p1++] = nums[p2++];
            }
        }

        for (int i = p1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
