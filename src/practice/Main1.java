package practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            cnt[i] = scanner.nextInt();
        }

        System.out.println(minCost(cnt));
    }

    private static int minCost(int[] cnt) {
        int n = cnt.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + cnt[i - 1];
        }

        for (int len = 2; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                int left = start;
                int right = start + len - 1;

                // 区间为[left, right]
                int curSum = sum[right + 1] - sum[left];
                dp[left][right] = Integer.MAX_VALUE;
                for (int k = left; k < right; k++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k + 1][right] + curSum);
                }
            }
        }

        return dp[0][n - 1];
    }
}
