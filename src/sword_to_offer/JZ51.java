package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ51 {
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 1) return null;
        int[] B = new int[A.length];

        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        //因为B的第i位存储的是从0-i-1的乘积，所以从n-1开始计算
        for (int i = A.length - 2; i >= 0; i--) {
            temp = A[i + 1] * temp;
            B[i] = B[i] * temp;
        }

        return B;
    }


    @Test
    public void Test() {
        Assert.assertArrayEquals(new int[]{120,60,40,30,24},multiply(new int[]{1,2,3,4,5}));
        Assert.assertArrayEquals(new int[]{1,2},multiply(new int[]{2,1}));
    }
}
