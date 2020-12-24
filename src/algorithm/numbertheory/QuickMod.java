package algorithm.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class QuickMod {

    /**
     * 求(base^power)%1000的结果
     * @param base
     * @param power
     * @return
     */
    public int method1(int base, int power) {
        int res = 1;

        for (int i = 0; i < power; i++) {
            res = res * base;
            res = res % 1000;
        }

        return res % 1000;
    }


    @Test
    public void Test() {
        QuickMod quickMod = new QuickMod();

        Assert.assertEquals(quickMod.method1(1024, 1), 24);
        Assert.assertEquals(quickMod.method1(2,100),376);
    }
}
