package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ49 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        long res = 0;
        boolean isNeg = false;
        int startIndex = 0;

        int signChar = str.charAt(0);
        if (signChar == '+') startIndex++;
        else if (signChar == '-') {
            startIndex++;
            isNeg = true;
        }

        int base = 1;
        for (int i = str.length() - 1; i >= startIndex; i--) {
            char a = str.charAt(i);
            if (a < '0' || a > '9') return 0;
            int num = a - '0';

            res += (long) num * base;
            base =  base * 10;
        }
        return isNeg ? (int)-res : (int)res;
    }


    @Test
    public void Test() {
        Assert.assertEquals(1234, StrToInt("1234"));
        Assert.assertEquals(1234, StrToInt("+1234"));
        Assert.assertEquals(1, StrToInt("1"));
        Assert.assertEquals(-1, StrToInt("-1"));
        Assert.assertEquals(Integer.MAX_VALUE, StrToInt("" + Integer.MAX_VALUE));
        Assert.assertEquals(Integer.MIN_VALUE, StrToInt("" + Integer.MIN_VALUE));
        System.out.println(StrToInt("123123"));
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + "");
        System.out.println(Integer.MIN_VALUE + "");
    }
}
