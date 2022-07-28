package leetcode.math;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P556_Next_Greater_Element_III {

    public int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();
        for (int i = s.length - 1; i > 0; i--) {
            // 找到第一个升序对
            if (s[i] > s[i - 1]) {
                Arrays.sort(s, i, s.length);

                for (int j = i; j < s.length; j++) {
                    if (s[j] > s[i - 1]) {
                        swap(s, j, i - 1);
                        long newNum = Long.parseLong(String.valueOf(s));
                        if (newNum > Integer.MAX_VALUE) {
                            return -1;
                        }
                        return (int) newNum;
                    }
                }
            }
        }
        return -1;
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    @Test
    public void test() {
        Assert.assertEquals(nextGreaterElement(12), 21);
        Assert.assertEquals(nextGreaterElement(21), -1);
    }
}
