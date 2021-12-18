package leetcode.dynamicproblem;

import org.junit.Test;

public class P338_Counting_Bits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                // 偶数
                res[i] = res[i >> 1];
            } else {
                // 奇数
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }

    @Test
    public void Test() {
        countBits(10);
    }
}
