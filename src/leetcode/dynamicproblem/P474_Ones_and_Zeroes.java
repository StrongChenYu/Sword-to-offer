package leetcode.dynamicproblem;

public class P474_Ones_and_Zeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

//        dp[0]的维度不需要初始化

        for (int i = 1; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];

                    int[] cnt = cnt0AndCnt1(strs[i - 1]);
                    int cnt0 = cnt[0];
                    int cnt1 = cnt[1];

                    if (j - cnt0 >= 0 && k - cnt1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - cnt0][k - cnt1] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }


    public int[] cnt0AndCnt1(String str) {
        int cnt0 = 0;
        int cnt1 = 1;
        for (int i = 0; i < str.length(); i++) {
            cnt0 += str.charAt(i) == '0' ? 1 : 0;
            cnt1 += str.charAt(i) == '1' ? 1 : 0;
        }
        return new int[]{cnt0, cnt1};
    }

}
