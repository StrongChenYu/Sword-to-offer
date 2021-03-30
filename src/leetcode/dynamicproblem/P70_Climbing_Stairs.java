package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/3/30 8:37
 */
public class P70_Climbing_Stairs {
    public int climbStairs(int n) {

        int a1 = 1;
        int a2 = 1;

        for (int i = 2; i <= n; i++) {
            int a3 = a1 + a2;

            a1 = a2;
            a2 = a3;
        }

        return a2;
    }

    @Test
    public void Test() {
        Assert.assertEquals(climbStairs(2), 2);
        Assert.assertEquals(climbStairs(1), 1);
        Assert.assertEquals(climbStairs(3),3);
        Assert.assertEquals(climbStairs(4),5);
    }
}
