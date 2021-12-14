package leetcode.array;

import org.junit.Test;

public class P238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p = p * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * q;
            q = q * nums[i];
        }

        return res;
    }

    @Test
    public void Test() {
        productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}
