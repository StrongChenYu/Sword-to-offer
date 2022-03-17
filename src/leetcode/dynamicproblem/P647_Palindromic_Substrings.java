package leetcode.dynamicproblem;

import org.junit.Test;

public class P647_Palindromic_Substrings {

    public int countSubstrings(String s) {

        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];

        // 边界条件就是对角线上都是true
        int cnt = 0;

        // 用i表示区间长度
        // 用j表示开始位置
        for (int i = 1; i <= chars.length; i++) {
            for (int j = 0; j + i - 1 < chars.length; j++) {
                if (i == 1) {
                    // 如果区间长度为1
                    dp[j][j] = true;
                } else if (i == 2) {
                    // 区间长度为2
                    dp[j][j + i - 1] = chars[j] == chars[j + i - 1];
                } else {
                    // 区间长度 > 2
                    dp[j][j + i - 1] = dp[j + 1][j + i - 2] && chars[j] == chars[j + i - 1];
                }
                if (dp[j][j + i - 1]) {
                    System.out.println(s.substring(j, j + i));
                    cnt++;
                }
            }
        }

        return cnt;
    }


    @Test
    public void Test() {
        System.out.println(countSubstrings("aba"));
    }
}
