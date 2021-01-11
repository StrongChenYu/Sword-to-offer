package algorithm.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class EuclidAlgorithm {

    /**
     * 递归解决问题
     * 保证输入的m>n
     * @param m
     * @param n
     * @return
     */
    public int gcdRecursion(int m, int n) {
        int result = 1;
        result = gcd(m,n);
        return result;
    }

    private int gcd(int m, int n) {
        if (m % n == 0)
            return n;
        else return gcd(n, m % n);
    }

    /**
     * 使用循环实现，不使用递归的空间
     * 辗转相除法
     * a / b = c + d
     * 核心思想  f(被除数,除数)=f(除数,余数)
     * @param m
     * @param n
     * @return
     */
    public int gcdLoop(int m, int n) {
        if (n == 0) return 0;
        while (m % n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return n;
    }


    /**
     * 更相减损术
     * 使用递归来实现
     * @param m
     * @param n
     * @return
     */
    public int gcdIRARecursion(int m, int n) {
        if (n == 0) return 0;
        if (m == n) return m;

        if (m > n) {
            return gcdIRARecursion(n, m - n);
        } else {
            return gcdIRARecursion(m, n - m);
        }
    }


    /**
     * 不使用递归来实现
     * @param m
     * @param n
     * @return
     */
    public int gcdIRA(int m, int n) {
        if (n == 0) return 0;
        if (m % n == 0) return n;

        while (m != n) {
            int greater = Math.max(m,n);
            int less = Math.min(m,n);

            m = less;
            n = greater - less;
        }
        return m;
    }


    @Test
    public void Test() {
        Assert.assertEquals(1, gcdIRA(20,3));
        Assert.assertEquals(20, gcdIRA(100,20));
        Assert.assertEquals(33, gcdIRA(99,66));
        Assert.assertEquals(1, gcdIRA(1,1));
        Assert.assertEquals(1, gcdIRA(11,17));
    }
}
