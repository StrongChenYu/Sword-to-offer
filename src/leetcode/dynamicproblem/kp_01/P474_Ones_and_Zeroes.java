package leetcode.dynamicproblem.kp_01;

public class P474_Ones_and_Zeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

//        dp[0]的维度不需要初始化
        int[][] cnt = cnt0AndCnt1(strs);

        for (int i = 1; i <= strs.length; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    int cnt0 = cnt[i - 1][0];
                    int cnt1 = cnt[i - 1][1];

                    if (j - cnt0 >= 0 && k - cnt1 >= 0) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - cnt0][k - cnt1] + 1);
                    }
                }
            }
        }

        return dp[m][n];
    }


    public int[][] cnt0AndCnt1(String[] strs) {
        int[][] res = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int cnt0 = 0;
            int cnt1 = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                cnt0 += strs[i].charAt(j) == '0' ? 1 : 0;
                cnt1 += strs[i].charAt(j) == '1' ? 1 : 0;
            }
            res[i][0] = cnt0;
            res[i][1] = cnt1;
        }

        return res;
    }

}
