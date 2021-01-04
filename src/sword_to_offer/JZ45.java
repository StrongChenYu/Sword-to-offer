package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JZ45 {

    /**
     * 好叭，大小王原来不止两张
     * 注意细节！！！！！！！！！！ 即边界条件
     * 1. 大小王不止有两张
     * 2. 没有考虑相同的数字
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) return false;

        Arrays.sort(numbers);

        int count0 = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count0++;
                continue;
            }

            if (numbers[i + 1] - numbers[i] == 0) return false;
            if (numbers[i + 1] - numbers[i] == 1) continue;

            //这里就是不等于1的情况
            //如果中间差一张牌，但是有0存在的话，说明可以进入下一步，但是要消耗一个0
            int gap = numbers[i + 1] - numbers[i] - 1;
            count0 = count0 - gap;

            if (count0 < 0) return false;
        }

        return true;
    }

    @Test
    public void Test() {
        Assert.assertFalse(isContinuous(new int[]{1,3,4,5,6}));
        Assert.assertTrue(isContinuous(new int[]{0,3,2,6,4}));
        Assert.assertFalse(isContinuous(new int[]{}));
        Assert.assertTrue(isContinuous(new int[]{0,0,2,3,5}));
        Assert.assertTrue(isContinuous(new int[]{0,0,2,4,6}));
        Assert.assertTrue(isContinuous(new int[]{1,0,0,5,0}));
        Assert.assertFalse(isContinuous(new int[]{1,0,0,1,0}));

    }

}
