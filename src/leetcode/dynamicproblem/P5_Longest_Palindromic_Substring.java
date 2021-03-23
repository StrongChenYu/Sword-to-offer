package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/3/23 17:03
 */
public class P5_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String res = "";

        /**
         * 字符串区间为
         * [i, i + len) 左闭右开
         */
        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
                }

                if (dp[i][j] && res.length() < len) {
                    res = s.substring(i, i + len);
                }
            }
        }

        return res;
    }


    @Test
    public void Test() {
        Assert.assertEquals(longestPalindrome("a"), "a");
        Assert.assertEquals(longestPalindrome("abc"), "a");
        Assert.assertEquals(longestPalindrome("aba"), "aba");
        Assert.assertEquals(longestPalindrome("abcbcb"), "bcbcb");
        Assert.assertEquals(longestPalindrome(""), "");
        Assert.assertEquals(longestPalindrome("abcbabbbba"), "abbbba");
    }
}
