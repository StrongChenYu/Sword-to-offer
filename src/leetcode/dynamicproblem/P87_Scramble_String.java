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

    HashMap<String, Boolean> resMap = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
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
        Assert.assertTrue(isScramble("", ""));

        Assert.assertFalse(isScramble("abcde", "caebd"));
    }
}
