package leetcode.math;

import org.junit.Test;

public class P461_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        return countBit(x ^ y);
    }

    private int countBit(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    @Test
    public void test() {
        System.out.println(0 ^ 0);
    }
}
