package leetcode.dynamicproblem;

import org.junit.Test;

public class P583_Delete_Operation_for_Two_Strings {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return (n1 - dp[n1][n2]) + (n2 - dp[n1][n2]);
    }

    @Test
    public void test() {
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("leetcode", "etco"));
        System.out.println(minDistance("", ""));
        System.out.println(minDistance("a", ""));
    }

}
