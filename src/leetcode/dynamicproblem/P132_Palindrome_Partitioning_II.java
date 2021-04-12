package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Chen Yu
 * @Date 2021/4/12 15:05
 */
public class P132_Palindrome_Partitioning_II {

    boolean[][] dp = null;
    public int minCut(String s) {
        if (s.length() == 0) return 0;

        int n = s.length();
        dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            //[i, i + len)
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    //[i + 1,j - 1]之间的长度是len-2, 之前已经被计算过了
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }

        int[] dpMin = new int[n];
        Arrays.fill(dpMin, Integer.MAX_VALUE);

        dpMin[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    if (j > 0) {
                        dpMin[i] = Math.min(dpMin[j - 1] + 1, dpMin[i]);
                    } else {
                        dpMin[i] = 0;
                    }
                }
            }
        }

        return dpMin[n - 1];
    }


    @Test
    public void Test() {
        Assert.assertEquals(0 ,minCut("abccba"));
        Assert.assertEquals(0 ,minCut(""));
        Assert.assertEquals(0 ,minCut("a"));
        Assert.assertEquals(1, minCut("abacnc"));
    }
}
