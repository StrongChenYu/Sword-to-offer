package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/4/8 10:06
 */
public class P115_Distinct_Subsequences {

    /**
     * 这种做法应该没有什么问题
     * 但是超时了
     */
    Map<String, Integer> resMap = new HashMap<>();
    public int numDistinct_Recursion(String s, String t) {
        //如果t为空，那么s只能是都删了一种方法
        if (t.length() == 0) return 1;

        //t不为空，s为空，这种情况说明t不是s的子串，所以直接返回0
        if (s.length() == 0) return 0;

        /**
         * 下面即为s和t都不为空的情况
         */

        //如果两个相等，那么肯定是1
        if (s.equals(t)) return 1;
        String key = s + "_" + t;
        if (resMap.containsKey(key)) return resMap.get(key);

            //递归
        int sl = s.length();
        int tl = t.length();
        int res = numDistinct_Recursion(s.substring(1, sl), t);

        if (s.charAt(0) == t.charAt(0)) {
            res += numDistinct_Recursion(s.substring(1, sl), t.substring(1, tl));
        }

        resMap.put(key, res);
        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(3, numDistinct("rabbbit", "rabbit"));
        Assert.assertEquals(5, numDistinct("babgbag", "bag"));
        Assert.assertEquals(1, numDistinct("ABCDE", "ACE"));
    }

    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        int[][] dp = new int[sl + 1][tl + 1];

        //边界条件，t为空的时候
        for (int i = 0; i <= sl; i++) dp[i][0] = 1;
        //边界条件，s为空的时候, dp[0][0]为1，所以从1开始,由于初始化的时候全是0了，所以没有必要
        //for (int i = 1; i <= tl; i++) dp[0][i] = 0;

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                dp[i][j] = dp[i - 1][j];
                /**
                 * 索引
                 * i-1
                 * j-1
                 */
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[sl][tl];
    }
}
