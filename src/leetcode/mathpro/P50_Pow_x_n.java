package leetcode.mathpro;

import org.junit.Assert;
import org.junit.Test;

public class P50_Pow_x_n {

    /**
     * 使用迭代的方法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        long tempN = Math.abs((long)n);
        while (tempN > 0) {
            if (tempN % 2 != 0) {
                res = res * x;
                tempN = tempN - 1;
            }
            x = x * x;
            tempN = tempN / 2;
        }
        return n >= 0 ? res : 1 / res;
    }

    public double myPow_Recursion(double x, int n) {
        //这里不能使用math.abs函数，因为测试用例里面会使用-最大值，去绝对值后会越界
        double res = myPowHelp(x, n);
        return n >= 0 ? res : 1 / res;
    }

    /**
     * 使用递归和循环两种方法
     * @param x
     * @param n
     * @return
     */
    public double myPowHelp(double x, int n) {
        if (n == 0) return 1.0;
        double tempRes = myPowHelp(x, n / 2);
        System.out.println(tempRes);
        double res = 1.0;
        if (n % 2 == 0) {
            res =  tempRes * tempRes;
        } else {
            res = x * tempRes * tempRes;
        }
        return res;
    }

    @Test
    public void Test() {
        //Assert.assertEquals(4.0, myPow(2,2),0.00);
        Assert.assertEquals(1024.0, myPow(2, 10),0.00);
        Assert.assertEquals(1.0, myPow(2, 0),0.00);
        Assert.assertEquals(0.0, myPow(0,1000),0.00);
        Assert.assertEquals(2.0, myPow(2, 1),0.00);
        //可能为负值
        Assert.assertEquals(0.25, myPow(2, -2), 0.00001);
        Assert.assertEquals(0.00, myPow(2, -2147483648), 0.00001);
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(-2147483648));
        System.out.println("hello world!");
    }
}
