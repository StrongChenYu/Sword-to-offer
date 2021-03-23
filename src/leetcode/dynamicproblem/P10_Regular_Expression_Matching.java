package leetcode.dynamicproblem;

/**
 * @Author Chen Yu
 * @Date 2021/3/23 19:06
 */
public class P10_Regular_Expression_Matching {

    public boolean isMatch(String str, String pattern) {
        /**
         * 1. 空的匹配表达式和空串匹配
         * 2. 空的匹配表达式和不空串不匹配
         * 3. 非空的匹配表达式和空串不一定，比如p为“*”
         * 4. 非空的匹配表达式和非空串不一定
         */

        int strL = str.length();
        int patternL = pattern.length();

        /**
         * 表示0-sl和0-pl之间是否匹配
         * 数组大一倍是因为0位置表示空串
         */
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
}
