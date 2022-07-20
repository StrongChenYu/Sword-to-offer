package practice;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(count(input));
    }

    public static int count(String input) {
        int n = input.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int cnt = 0;

        for (int len = 0; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                int left = start;
                int right = start + len - 1;

                if (len == 0) {
                    dp[left][right] = true;
                } else if (len == 1) {
                    dp[left][right] = input.charAt(left) == input.charAt(right);
                } else {
                    dp[left][right] = input.charAt(left) == input.charAt(right) && dp[left + 1][right - 1];
                }
                cnt = dp[left][right] ? cnt + 1 : cnt;
            }
        }
        return cnt;
    }
}
