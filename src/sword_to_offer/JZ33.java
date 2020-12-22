package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JZ33 {

    private final int[] UGLYARRAY = new int[]{2,3,5};

    /**
     * up-to-bottom的方法，基本前面可以跑出来
     * 但到了后面就跑不出来了
     * 超时，所以使用bottom-to-up的办法
     * 80%的用例大概可以过
     * @param index
     * @return
     */
    public int GetUglyNumber_Bad_Solution(int index) {
        if (index == 1) return 1;

        Set<Integer> uglySet = new HashSet<>();
        uglySet.add(1);

        int cur = 1;
        int number = 2;
        while (cur < index) {
            boolean flag = false;
            for (int base : UGLYARRAY) {
                if (number % base == 0 && uglySet.contains(number / base)) {
                    flag = true;
                }
            }
            System.out.println(number);
            if (flag){
                cur++;
                uglySet.add(number);
            }
            number++;
        }

        return number - 1;
    }

    @Test
    public void Test() {
        JZ33 jz33 = new JZ33();

        Assert.assertEquals(jz33.GetUglyNumber_Solution(1), 1);
        Assert.assertEquals(jz33.GetUglyNumber_Solution(2), 2);
        Assert.assertEquals(jz33.GetUglyNumber_Solution(3), 3);
        Assert.assertEquals(jz33.GetUglyNumber_Solution(4), 4);
        Assert.assertEquals(jz33.GetUglyNumber_Solution(5), 5);
        Assert.assertEquals(jz33.GetUglyNumber_Solution(11), 15);
        Assert.assertEquals(jz33.GetUglyNumber_Solution(1352), 51200000);
    }

}
