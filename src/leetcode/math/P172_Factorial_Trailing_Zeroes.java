package leetcode.math;

import org.junit.Test;

public class P172_Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n / 5;
            n = n / 5;
        }
        return cnt;
    }

    @Test
    public void Test() {
        System.out.println(trailingZeroes(3));
    }
}
