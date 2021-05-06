package leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/5/6 21:16
 */
public class P58_Length_of_Last_Word {

    public int lengthOfLastWord1(String s) {
        String[] split = s.split(" ");
        return split.length == 0 ? 0 : split[split.length - 1].length();
    }

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int res = 0;

        int i = n - 1;
        for (; i >= 0 && s.charAt(i) == ' '; i--);

        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            res++;
        }

        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(lengthOfLastWord(" "), 0);
        Assert.assertEquals(lengthOfLastWord("abc"),3);
        Assert.assertEquals(lengthOfLastWord("abc abc"), 3);
        Assert.assertEquals(lengthOfLastWord("a "), 1);
    }

    public static void main(String[] args) {
        String[] split = " ".split(" ");
        System.out.println(split.length);
    }
}
