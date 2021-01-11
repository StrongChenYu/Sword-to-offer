package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ51 {
    public int[] multiply(int[] A) {
        //or return new int[]{}
        if (A == null || A.length <= 1) return null;

        //让B[i]保存除了i之外的所有元素的乘积
        int[] B = new int[A.length];

        B[0] = 1;
        //第一步是计算i位置前的所有的乘积
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        //第二步就是得把数组构建出来
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp = temp * A[i + 1];
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
