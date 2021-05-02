package leetcode.bitoperation;

import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/5/2 20:12
 */
public class P190_Reverse_Bits {

    public int reverseBits(int n) {
        int M1 = 0x55555555;
        int M2 = 0x33333333;
        int M4 = 0x0F0F0F0F;
        int M8 = 0x00FF00FF;

        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;

        return n >>> 16 | n << 16;
    }

    public int reverseBits_Bad(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1);
            res |= ((n >> i) & 1);
        }
        return res;
    }

    @Test
    public void Test() {
        int i = reverseBits(1);
        System.out.println(i);
    }
}
