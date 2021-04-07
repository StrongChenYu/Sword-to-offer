package leetcode.dynamicproblem;

/**
 * @Author Chen Yu
 * @Date 2021/4/7 8:46
 */
public class P97_Interleaving_String {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) return false;

        boolean[][]dp = new boolean[n1 + 1][n2 + 1];

        dp[0][0] = true;

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }

                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[n1][n2];
    }
}
