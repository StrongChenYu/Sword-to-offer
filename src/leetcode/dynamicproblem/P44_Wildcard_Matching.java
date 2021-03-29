package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/3/29 9:16
 */
public class P44_Wildcard_Matching {
    /**
     * 与P10不一样的地方在于
     * P10中的*符号只考虑后面的内容即可，即只关注后面的内容匹不匹配
     * 而此题中的*符号也可以与后面的内容匹配
     * 所以这就是区别，这种情况下不太一样，所以不能使用同样的自底向上的方式进行解决
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];

        /**
         * 1. 空串p和不空串s必不匹配
         * 2. 空串p和空串s必匹配
         * 3. 不空串p和空串s 不一定（*）
         * 4. 不空串p和不空串s 不一定
         */

        //1,2
        /**
         * ""
         * "********"
         */
        dp[0][0] = true;
        for (int i = 1; i <= pl; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        //3,4
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {

                /**
                 * 当前的索引s : i - 1
                 * p : j - 1
                 */
                if (i > 0 && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //忽视当前的*号
                    dp[i][j] |= dp[i][j - 1];

                    //不忽视当前的*号
                    dp[i][j] |= dp[i - 1][j];

                }
            }
        }

        return dp[sl][pl];
    }

    @Test
    public void Test() {
        Assert.assertFalse(isMatch("aa", "a"));
        Assert.assertFalse(isMatch("cb", "?a"));
        Assert.assertFalse(isMatch("acdcb", "a*c?b"));
        Assert.assertFalse(isMatch("aab", "c*a*b"));

        Assert.assertTrue(isMatch("adceb", "a*b"));
        Assert.assertTrue(isMatch("aa", "*"));
        Assert.assertTrue(isMatch("aaaaaaaa", "**"));
        Assert.assertTrue(isMatch("aaa", "???"));
        Assert.assertTrue(isMatch("", "******"));


        Assert.assertFalse(isMatchRecursion("aa", "a"));
        Assert.assertFalse(isMatchRecursion("cb", "?a"));
        Assert.assertFalse(isMatchRecursion("acdcb", "a*c?b"));
        Assert.assertFalse(isMatchRecursion("aab", "c*a*b"));

        Assert.assertTrue(isMatchRecursion("adceb", "a*b"));
        Assert.assertTrue(isMatchRecursion("aa", "*"));
        Assert.assertTrue(isMatchRecursion("aaaaaaaa", "**"));
        Assert.assertTrue(isMatchRecursion("aaa", "???"));
        Assert.assertTrue(isMatchRecursion("", "******"));
    }

    /**
     * 递归就是反着来
     *
     * !!!!!!!!!!思路正确但是会超时
     * 感觉递归都不可行
     *
     * @param s
     * @param p
     * @return
     */
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatchRecursion(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        /**
         * 1. 空串p和不空串s必不匹配
         * 2. 空串p和空串s必匹配
         * 3. 不空串p和空串s 不一定（*）
         * 4. 不空串p和不空串s 不一定
         */

        //1
        if (sl == 0 && pl == 0) return true;
        //2
        if (pl == 0) return false;

        String key = s + "," + p;
        if (map.containsKey(key)) return map.get(key);

        //p 必不是空串
        //但s可能是空串
        boolean res = false;
        if (p.charAt(pl - 1) != '*') {
            if (sl == 0) return false;

            if (p.charAt(pl - 1) == '?' || p.charAt(pl - 1) == s.charAt(sl - 1)) {
                res = isMatchRecursion(s.substring(0, sl - 1), p.substring(0, pl - 1));
            }
        } else if (p.charAt(pl - 1) == '*') {

            //不看*号
            res = isMatchRecursion(s.substring(0, sl), p.substring(0, pl - 1));

            //看*号
            if(sl > 0) res |= isMatchRecursion(s.substring(0, sl - 1), p.substring(0, pl));
        }

        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(s.substring(0,0).length());
    }
}
