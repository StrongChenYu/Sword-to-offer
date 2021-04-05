package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Chen Yu
 * @Date 2021/4/4 9:24
 */
public class P87_Scramble_String {

    /**
     * dp 解法
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 != n2) return false;
        if (n1 == 0) return true;

        boolean[][][] dp = new boolean[n1][n2][n1 + 1];

        // 初始化单个字符的情况
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }


        for (int len = 2; len <= n1; len++) {
            for (int i = 0; i <= n1 - len; i++) {
                for (int j = 0; j <= n2 - len; j++) {
//                    if (len == 0) {
//                        dp[i][j][len] = true;
//                    } else if (len == 1) {
//                        if(s1.charAt(i) == s2.charAt(j)){
//                            dp[i][j][len] = true;
//                        }
//                    } else {
                    for (int k = 1; k <= len - 1; k++) {
//                            dp[i][j][len] |= (dp[i][j][k] && dp[i + k][j + k][len - k]);
//                            dp[i][j][len] |= (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][n1];
    }


    HashMap<String, Boolean> resMap = new HashMap<>();
    public boolean isScramble_Recursion(String s1, String s2) {
        if (resMap.containsKey(s1 + "_" + s2)) return resMap.get(s1 + "_" + s2);

        int sl1 = s1.length();
        int sl2 = s2.length();

        if (sl1 != sl2) return false;
        if (sl1 == 0) return true;
        if (s1.equals(s2)) return true;

        /**
         * s1中出现的字符串如何s2中没有，直接返回false
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sl1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);

        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        for (int i = 1; i < sl1; i++) {
            boolean plan1 = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, sl1), s2.substring(i, sl2));
            boolean plan2 = isScramble(s1.substring(0, i), s2.substring(sl2 - i, sl2)) && isScramble(s1.substring(i, sl1), s2.substring(0, sl2 - i));

            if (plan1 || plan2) {
                resMap.put(s1 + "_" + s2, true);
                return true;
            }
        }

        resMap.put(s1 + "_" + s2, false);
        return false;
    }

    @Test
    public void Test() {
        Assert.assertTrue(isScramble("great", "rgeat"));
//        Assert.assertTrue(isScramble("", ""));
        Assert.assertTrue(isScramble("great", "great"));


        Assert.assertFalse(isScramble("eebaacbcbcadaaedceaaacadccd","eadcaacabaddaceacbceaabeccd"));
        Assert.assertFalse(isScramble("abcde", "caebd"));
    }

    public static void main(String[] args) {
        System.out.println("123".substring(0,3));
    }
}
