package leetcode.dynamicproblem;

import org.junit.Test;

public class P392_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        int[][] dp = new int[sl + 1][tl + 1];

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[sl][tl] == sl;
    }

    @Test
    public void test() {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
