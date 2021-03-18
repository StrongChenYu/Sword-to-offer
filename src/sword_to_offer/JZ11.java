package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 统计二进制中1的个数
 * @Author Chen Yu
 * @Date 2021/3/18 11:00
 */
public class JZ11 {
    public int NumberOf1(int n) {

        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
        n = ((n * 0x01010101) >> 24);

        return n;
    }

    @Test
    public void Test() {
        Assert.assertEquals(NumberOf1(10), 2);
        Assert.assertEquals(NumberOf1(0),0);
        Assert.assertEquals(NumberOf1(Integer.MAX_VALUE), 31);
        Assert.assertEquals(NumberOf1(Integer.MIN_VALUE), 1);
        Assert.assertEquals(NumberOf1(-1),32);
    }

    public static void main(String[] args) {
        int a = 0x3A70F21B;
        System.out.printf("%x\n",(a & 0x55555555) + ((a >> 1) & 0x55555555));
    }
}
