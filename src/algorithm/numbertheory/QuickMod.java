package algorithm.numbertheory;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode P50
 */
public class QuickMod {

    /**
     * 求(base^power)%1000的结果
     * @param base
     * @param power
     * @return
     */
    public int normalPower(int base, int power) {
        int res = 1;
        for (int i = 0; i < power; i++) {
            res = res * base;
            res = res % 1000;
        }
        return res % 1000;
    }

    public int quickPower(int base, int power) {
        int res = 1;
        int positive = Math.abs(power);
        while (positive > 0) {
            if ((positive & 1) == 1) {
                res = res * base % 1000;
            }
            positive = positive >> 1;
            base = base * base % 1000;
        }
        return res;
    }




    @Test
    public void Test() {
        QuickMod quickMod = new QuickMod();

        Assert.assertEquals(quickMod.normalPower(1024, 1), 24);
        Assert.assertEquals(quickMod.normalPower(2,100),376);

        Assert.assertEquals(quickMod.quickPower(1024, 1), 24);
        Assert.assertEquals(quickMod.quickPower(2,100),376);
    }
}
