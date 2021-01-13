package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ52 {

    public boolean match(char[] str, char[] pattern){
        if (pattern == null || pattern.length == 0) return false;
        return matchRecursion(str, pattern, 0, 0);
    }

    /**
     * 判断[strStart,length] 是否匹配 [patternStart,length]
     * @param str
     * @param pattern
     * @param strStart
     * @param patternStart
     * @return
     */
    public boolean matchRecursion(char[] str, char[] pattern, int strStart, int patternStart) {
        if (patternStart == pattern.length && strStart < str.length) return false;

        if (strStart == str.length) {
            //判断最后是否为*，如果是*，那么循环到没有*的地方，如果还有其他字符存在，返回false
            while (patternStart < pattern.length) {
                if (pattern[patternStart] != '*') return false;
                patternStart++;
            }
            return true;
        }

        //在这里，strStart < str.length && patternStart < pattern.length
        //是 . 的情况和两个字符相等的情况
        if (pattern[patternStart] == '.' || pattern[patternStart] == str[strStart]) {
            return matchRecursion(str, pattern, strStart + 1, patternStart + 1);
        }

        //如果当前是*号


        //如果两个字符不相等，就去看后面有没有一个*号
        if (patternStart + 1 < pattern.length && pattern[patternStart + 1] == '*') {

        }

        return false;
    }

    @Test
    public void Test() {
        Assert.assertTrue(match("aaa".toCharArray(),"a.a".toCharArray()));
        Assert.assertTrue(match("aaa".toCharArray(),"...".toCharArray()));
        Assert.assertTrue(match("aaa".toCharArray(),"ab*ac*a".toCharArray()));
        Assert.assertFalse(match("aaa".toCharArray(),"aa.a".toCharArray()));
        Assert.assertFalse(match("aaa".toCharArray(),"ab*a".toCharArray()));
        Assert.assertTrue(match("cdffdfdddddddd".toCharArray(),"cdffdfd*".toCharArray()));
        Assert.assertFalse(match("cdffdfdddddddd".toCharArray(),"cdffdf*".toCharArray()));
        Assert.assertTrue(match("".toCharArray(),"".toCharArray()));
        Assert.assertFalse(match("abc".toCharArray(),"".toCharArray()));
        Assert.assertFalse(match("".toCharArray(),"abc".toCharArray()));
    }
}
