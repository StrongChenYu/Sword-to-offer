package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Chen Yu
 * @Date 2021/3/30 8:44
 */
public class P72_Edit_Distance {

    public int minDistance(String word1, String word2) {
        int wl1 = word1.length();
        int wl2 = word2.length();

        int[][] dp = new int[wl1 + 1][wl2 + 1];

        for (int i = 0; i <= wl1; i++) {
            for (int j = 0; j <= wl2; j++) {
                /**
                 * 边界条件
                 */
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                /**
                 * dp公式
                 * word1索引: i - 1
                 * word2索引：j - 1
                 * https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
                 */

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /**
                     * 替换操作：dp[i - 1][j - 1]
                     * 删除操作：dp[i - 1][j]
                     * 添加操作：dp[i][j - 1]
                     */
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[wl1][wl2];
    }

    @Test
    public void Test() {
        Assert.assertEquals(3, minDistance_Recursion("horse","ros"));
        Assert.assertEquals(1, minDistance_Recursion("","a"));
        Assert.assertEquals(1, minDistance_Recursion("a","ba"));
        Assert.assertEquals(1, minDistance_Recursion("a","aa"));
        Assert.assertEquals(10, minDistance_Recursion("","aaaaaaaaaa"));
        Assert.assertEquals(5, minDistance_Recursion("intention","execution"));
    }

    /**
     * 递归写法
     * 比较简单
     * 思路清晰即可
     * 保存个结果用空间就可以了
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_Recursion(String word1, String word2) {
        int wl1 = word1.length();
        int wl2 = word2.length();

        if (wl1 == 0) return wl2;
        if (wl2 == 0) return wl1;

        String s1 = word1.substring(0, wl1 - 1);
        String s2 = word2.substring(0, wl2 - 1);
        if (word1.charAt(wl1 - 1) == word2.charAt(wl2 - 1)) {
            return minDistance_Recursion(s1 ,s2);
        } else {
            int replace = minDistance_Recursion(s1, s2);
            int insert = minDistance_Recursion(word1, s2);
            int delete = minDistance_Recursion(s1, word2);

            return Math.min(Math.min(replace, insert), delete) + 1;
        }
    }

}
