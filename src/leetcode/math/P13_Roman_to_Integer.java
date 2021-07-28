package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chen Yu
 * @Date 2021/7/28 8:51
 */
public class P13_Roman_to_Integer {
    static Map<Character, Integer> allRoman = new HashMap<>();

    static {
        allRoman.put('M', 1000);
        allRoman.put('D', 500);
        allRoman.put('C', 100);
        allRoman.put('L', 50);
        allRoman.put('X', 10);
        allRoman.put('V', 5);
        allRoman.put('I', 1);
    }

    public int romanToInt(String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();

        int max = 0;

        int idx = chars.length - 1;
        while (idx >= 0) {
            int curValue = allRoman.get(chars[idx]);

            int i = idx - 1;
            for (; i >= 0 && allRoman.get(chars[i]) < curValue; i--) {
                curValue -= allRoman.get(chars[i]);
            }

            cnt += curValue;
            idx = i;
        }

        return cnt;
    }
}
