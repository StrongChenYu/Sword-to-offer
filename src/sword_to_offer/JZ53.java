package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ53 {

    public boolean isNumeric(String str) {
        int ePos = -1;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                ePos = i;
                break;
            }
        }
        if (ePos == 0 || ePos == n - 1) return false;
        if (ePos == -1) {
            return isNumberWithOutE(str, 0, str.length(), false);
        } else {
            return isNumberWithOutE(str,0, ePos, false) && isNumberWithOutE(str, ePos + 1, n, true);
        }
    }

    private boolean isNumberWithOutE(String str, int start, int end, boolean notAllowPoint) {

        if (str.charAt(start) == '+' || str.charAt(start) == '-') {
            start++;
        }

        for (int i = start; i < end; i++) {
            char cur = str.charAt(i);
            if (!isCharNum(cur)) {
                if (!notAllowPoint && cur == '.') {
                    notAllowPoint = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCharNum(char c) {
        return c <= '9' && c >= '0';
    }

    @Test
    public void Test() {
        Assert.assertTrue(isNumeric("123"));
        Assert.assertTrue(isNumeric("+100"));
        Assert.assertTrue(isNumeric("5e2"));
        Assert.assertTrue(isNumeric("-123"));
        Assert.assertTrue(isNumeric("3.1416"));
        Assert.assertTrue(isNumeric("-1E-16"));


        Assert.assertFalse(isNumeric("12e"));
        Assert.assertFalse(isNumeric("1a3.14"));
        Assert.assertFalse(isNumeric("1.2.3"));
        Assert.assertFalse(isNumeric("+-5"));
        Assert.assertFalse(isNumeric("12e+4.3"));
    }

}
