package leetcode.bitoperation;

import org.junit.Test;

public class P201_Bitwise_AND_of_Numbers_Range {

    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = (1 << i);

            if ((mask & left) == (mask & right)) {
                cnt += (mask & left);
            } else {
                break;
            }
        }
        return cnt;
    }

    @Test
    public void Test() {
        rangeBitwiseAnd(5,7);
    }

    public static void main(String[] args) {
    }
}
