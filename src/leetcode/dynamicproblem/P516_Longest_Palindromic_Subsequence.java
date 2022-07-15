package leetcode.dynamicproblem;

import org.junit.Test;

public class P516_Longest_Palindromic_Subsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 0; len <= n; len++) {
            //[startIdx, len)
            for (int startIdx = 0; startIdx + len <= n; startIdx++) {
                int left = startIdx;
                int right = startIdx + len - 1;

                if (len == 1) {
                    dp[left][right] = 1;
                } else if (len > 1) {
                    if (s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = dp[left + 1][right - 1] + 2;
                    } else {
                        dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("a"));
    }

}
