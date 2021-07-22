package leetcode.string.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P3_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstringSet(String s) {
        if (s == null || s.length() == 0) return 0;

        int cnt = 0;
        Set<Character> set = new HashSet<>();

        int r = -1;
        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }

            for (; r + 1 < s.length() && !set.contains(s.charAt(r + 1)); r++) {
                set.add(s.charAt(r + 1));
            }

            cnt = Math.max(cnt, r - i + 1);
        }

        return cnt;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int left = 0;
        for (int right = left; right < s.length(); right++) {
            Character cur = s.charAt(right);
            if (map.containsKey(cur)) {
                left = Math.max(left,map.get(cur) + 1);
            }
            map.put(cur, right);
            cnt = Math.max(cnt, right - left + 1);
        }

        return cnt;
    }

    @Test
    public void test() {
//        Assert.assertEquals(4, lengthOfLongestSubstring("abcd"));
//        Assert.assertEquals(1, lengthOfLongestSubstring("a"));
//        Assert.assertEquals(0, lengthOfLongestSubstring(""));
//        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
//        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
//        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
//        Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
//        Assert.assertEquals(5, lengthOfLongestSubstring("anviaj"));
        Assert.assertEquals(2, lengthOfLongestSubstring("abba"));
    }


}
