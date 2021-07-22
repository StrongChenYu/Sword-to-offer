package leetcode.string.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P76_Minimum_Window_Substring {

    public String minWindow(String s, String t) {

        if (t == null || t.length() == 0 || s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character cur = t.charAt(i);
            need.put(cur, need.getOrDefault(cur, 0) + 1);
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;

        int leftIdx = 0;
        int rightIdx = 0;
        int match = 0;

        for (; rightIdx < s.length(); rightIdx++) {
            Character cur = s.charAt(rightIdx);
            if (!need.containsKey(cur)) {
                continue;
            }

            window.put(cur, window.getOrDefault(cur, 0) + 1);
            //match当多余的时候也可以正确表示
            if (window.get(cur).compareTo(need.get(cur)) == 0) {
                match++;
            }

            while (match == need.size()) {
                int curLength = rightIdx - leftIdx + 1;
                if (curLength < minLength) {
                    minLength = curLength;
                    start = leftIdx;
                }

                char c = s.charAt(leftIdx);
                if (need.containsKey(c)) {
                    window.put(c, window.get(c) - 1);

                    if (window.get(c) < need.get(c)) {
                        match--;
                    }
                }

                leftIdx++;
            }
        }

        return minLength != Integer.MAX_VALUE ? s.substring(start, start + minLength) : "";
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
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
