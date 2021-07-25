package leetcode.string;

import com.sun.security.jgss.GSSUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/7/25 22:16
 */
public class P8_String_to_Integer_atoi {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] numChars = s.toCharArray();

        int curIdx = 0;
        long num = 0;

        //消除首字符空格
        for (; curIdx < numChars.length && numChars[curIdx] == ' '; curIdx++);
        if (curIdx >= numChars.length) return 0;

        //读取第一个字符（正负号）
        boolean positive = true;
        if (numChars[curIdx] == '+') curIdx++;
        else if (numChars[curIdx] == '-') {
            positive = false;
            curIdx++;
        }

        //读数字
        while (curIdx < numChars.length) {
            char c = numChars[curIdx++];
            int curNum = c - '0';

            if (!(curNum <= 9 && curNum >=0)) {
                break;
            }

            num = num * 10 + curNum;

            //handle overflow
            if (positive && num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (!positive && num >= -(long)Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (positive ? num : -num);
    }

    @Test
    public void Test() {
        Assert.assertEquals(0, myAtoi(""));
        Assert.assertEquals(0, myAtoi("   "));
        Assert.assertEquals(0, myAtoi("+-12"));
        Assert.assertEquals(0, myAtoi("0"));
        Assert.assertEquals(1, myAtoi("1"));
        Assert.assertEquals(1, myAtoi("001"));
        Assert.assertEquals(1, myAtoi("       +0001"));
        Assert.assertEquals(12345, myAtoi("12345"));
        Assert.assertEquals(12345, myAtoi("0000012345"));
        Assert.assertEquals(12345, myAtoi("+12345"));
        Assert.assertEquals(12345, myAtoi("+12345A123"));
        Assert.assertEquals(-12345, myAtoi("-12345"));
        Assert.assertEquals(Integer.MAX_VALUE, myAtoi(String.valueOf(Integer.MAX_VALUE) + "1231"));
        Assert.assertEquals(Integer.MAX_VALUE, myAtoi(String.valueOf(Integer.MAX_VALUE)));
        Assert.assertEquals(Integer.MIN_VALUE, myAtoi(String.valueOf(Integer.MIN_VALUE)));
        Assert.assertEquals(Integer.MIN_VALUE, myAtoi(String.valueOf(Integer.MIN_VALUE) + "123"));
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        long b = -(long)Integer.MIN_VALUE;
        System.out.println(a * 10 + 8);
    }
}
