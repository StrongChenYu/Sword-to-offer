package leetcode.greedy;

import org.junit.Test;

public class P738_Monotone_Increasing_Digits {

    public int monotoneIncreasingDigits(int n) {
        int[] mem = new int[10];

        int cnt = 0;
        while (n != 0) {
            mem[cnt++] = n % 10;
            n = n / 10;
        }

        for (int i = 1; i < cnt; i++) {
            if (mem[i] > mem[i - 1]) {
                mem[i] = mem[i] - 1;
                // 把后面的数全置为9
                for (int j = 0; j < i; j++) {
                    mem[j] = 9;
                }
            }
        }

        for (int i = cnt - 1; i >= 0; i--) {
            n = n * 10 + mem[i];
        }

        return n;
    }

    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(33333331));
    }
}
