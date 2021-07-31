package leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class P28_Implement_strStr {

    public int strStr(String haystack, String needle) {
        if (needle.equals("") || needle.equals(haystack)) {
            return 0;
        }

        char[] hayChars = haystack.toCharArray();
        char[] needChars = needle.toCharArray();
        for (int i = 0; i < hayChars.length; i++) {
            char h = hayChars[i];
            char n = needChars[0];

            if (h != n) {
                continue;
            }


            int idx = 0;
            for (; idx < needChars.length && i + idx < hayChars.length && hayChars[i + idx] == needChars[idx]; idx++);

            if (idx == needChars.length) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void Test() {
        Assert.assertEquals(0, strStr("",""));
        Assert.assertEquals(-1, strStr("feafa","feafd"));
        Assert.assertEquals(0, strStr("he","he"));
        Assert.assertEquals(0, strStr("hello","he"));
        Assert.assertEquals(2, strStr("hello","ll"));
        Assert.assertEquals(5, strStr("helldllo","llo"));
        Assert.assertEquals(-1, strStr("aaa","aaaaaa"));
    }
}
