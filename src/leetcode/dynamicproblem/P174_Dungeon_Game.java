package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Chen Yu
 * @Date 2021/4/15 10:13
 */
public class P174_Dungeon_Game {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 1;

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];

        /**
         * 边界
         */
        Arrays.fill(dp[m], Integer.MAX_VALUE);
        for (int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }

        dp[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                    dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j],1);
            }
        }

        return dp[0][0];
    }

    int[][] testData = {
            {0,0}
    };

    @Test
    public void Test() {
        Assert.assertEquals(1, calculateMinimumHP(testData));
    }

}
