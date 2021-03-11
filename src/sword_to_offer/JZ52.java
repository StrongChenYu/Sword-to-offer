package sword_to_offer;

import org.junit.Assert;
import org.junit.Test;

public class JZ52 {

    public boolean match(String str, String pattern){
        int strL = str.length();
        int patternL = pattern.length();
        boolean[][] dp = new boolean[strL + 1][patternL + 1];

        for (int j = 0; j < patternL; j++) dp[0][j] = false;
        dp[0][0] = true;

        for (int i = 0; i <= strL; i++) {
            for (int j = 1; j <= patternL; j++) {

                //这个题所有的状态都依赖于后面的状态吗？
                if (pattern.charAt(j - 1) != '*') {
                    if (i >= 1 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    //假装*不存在
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }

                    //假装存在
                    if (i >= 1 && j >= 2 && (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == str.charAt(i - 1))) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[strL][patternL];
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
        Assert.assertTrue(match("aaa","a.a"));
        Assert.assertTrue(match("aaa","..."));
        Assert.assertTrue(match("aaa","ab*ac*a"));
        Assert.assertFalse(match("aaa","aa.a"));
        Assert.assertFalse(match("aaa","ab*a"));
        Assert.assertTrue(match("cdffdfdddddddd","cdffdfd*"));
        Assert.assertFalse(match("cdffdfdddddddd","cdffdf*"));
        Assert.assertTrue(match("",""));
        Assert.assertFalse(match("abc",""));
        Assert.assertFalse(match("","abc"));
    }
}
