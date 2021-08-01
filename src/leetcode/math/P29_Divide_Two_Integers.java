package leetcode.math;

import org.junit.Assert;
import org.junit.Test;

public class P29_Divide_Two_Integers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += (1 << i);
                t -= (d << i);
            }
        }

        return negative ? -result : result;
    }

    @Test
    public void Test() {
//        Assert.assertEquals(3, divide(10,3));
//        Assert.assertEquals(1, divide(10,10));
//        Assert.assertEquals(0, divide(0,3));
//        Assert.assertEquals(4, divide(12,3));
//        Assert.assertEquals(-33, divide(-100,3));
//        Assert.assertEquals(-10, divide(-100,10));
//        Assert.assertEquals(10, divide(-100,-10));
//        Assert.assertEquals(3, divide(-100,-33));
//        Assert.assertEquals(3, divide(100,33));
//        Assert.assertEquals(3, divide(100,33));
//        Assert.assertEquals(2147483647, divide(2147483647,1));
        Assert.assertEquals(2147483647, divide(-2147483648,-1));
        Assert.assertEquals(-2147483648, divide(-2147483648,1));
    }
}
