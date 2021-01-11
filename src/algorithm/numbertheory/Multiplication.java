package algorithm.numbertheory;

import org.junit.Assert;
import org.junit.Test;

public class Multiplication {

    public int multiply(int x, int y) {
        if (y == 0) return 0;
        int z = multiply(x, y / 2);
        if ((y & 1) == 0) {
            return 2 * z;
        } else {
            //这里少乘了一个x，所以要加上去
            return x + 2 * z;
        }
    }

    @Test
    public void Test() {
        Assert.assertEquals(5, multiply(1,5));
        Assert.assertEquals(100,multiply(1,100));
        Assert.assertEquals(0, multiply(0, 1000));
    }
}
