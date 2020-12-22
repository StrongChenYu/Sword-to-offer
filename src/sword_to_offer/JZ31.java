package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cur = 1;
        int highNum = n / (cur * 10);
        int lowNum = n % cur;
        int curNum = n % (cur * 10);

        int res = 0;
        while (cur <= n) {
            if (curNum == 1) {
                res += highNum * cur + (lowNum + 1);
            } else if (curNum > 1) {
                res += (highNum + 1) * cur;
            } else {
                res += highNum * cur;
            }

            cur = cur * 10;
            highNum = n /(cur * 10);
            lowNum = n % cur;
            curNum = (n  / cur) % 10;
        }
        return res;
    }

    @Test
    public void Test() {
        JZ31 jz31 = new JZ31();

        Assert.assertSame(jz31.NumberOf1Between1AndN_Solution(6), 1);
        Assert.assertSame(jz31.NumberOf1Between1AndN_Solution(1),1);
        Assert.assertSame(jz31.NumberOf1Between1AndN_Solution(13), 6);
        Assert.assertSame(jz31.NumberOf1Between1AndN_Solution(1),1);
        //Assert.assertSame();
        Assert.assertEquals(jz31.NumberOf1Between1AndN_Solution(10000), 4001);
        //Assert.
    }

    public static void main(String[] args) {

    }
}
