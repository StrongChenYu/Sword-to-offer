package leetcode.string.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class P76_Minimum_Window_Substring {

    public String minWindow(String s, String t) {

        if (t == null || t.length() == 0 || s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int leftIdx = 0;
        int match = 0;

        int left = 0;
        int right = -1;
        while (right < s.length() - 1) {
            char c = s.charAt(++right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c)) {

                //部分等于
                if (need.get(c).equals(window.get(c))) {
                    match++;
                }

                //完全等于
                while (match == need.size()) {
                    int curLength = right - left + 1;
                    if (curLength < minLength) {
                        minLength = curLength;
                        leftIdx = left;
                    }

                    //滑动left让条件不成立
                    char leftChar = s.charAt(left);
                    window.put(leftChar, window.get(leftChar) - 1);
                    if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                        match--;
                    }
                    left++;
                }

            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(leftIdx, leftIdx + minLength);
    }

    @Test
    public void test() {
        //Assert.assertEquals("BANC" ,minWindow("ABECODEBANC", "ABBC"));
        Assert.assertEquals("ABC" ,minWindow("ABC", "ABC"));
        Assert.assertEquals("" ,minWindow("", "ABC"));
        Assert.assertEquals("" ,minWindow("ADOBECODEBANC", ""));
        Assert.assertEquals("ABBC" ,minWindow("ABBCNNNNNNBBA", "ABBC"));

        Assert.assertEquals("baca", minWindow("acbbaca", "aba"));
    }

    private boolean checkMoveLeft(Map<Character, Integer> need) {
        for (Integer value : need.values()) {
            if (value < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Integer i = 1;
        Integer j = 1;
        System.out.println(i .equals( j));
    }
}
