package leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_Letter_Combinations_of_a_Phone_Number {

    private final Map<Integer, char[]> letterMap = new HashMap<>();
    public void generatePhoneNumberMap() {
        letterMap.put(2, new char[]{'a','b','c'});
        letterMap.put(3, new char[]{'d','e','f'});
        letterMap.put(4, new char[]{'g','h','i'});
        letterMap.put(5, new char[]{'j','k','l'});
        letterMap.put(6, new char[]{'m','n','o'});
        letterMap.put(7, new char[]{'p','q','r','s'});
        letterMap.put(8, new char[]{'t','u','v'});
        letterMap.put(9, new char[]{'w','x','y','z'});
    }

    public List<String> letterCombinations(String digits) {
        generatePhoneNumberMap();
        List<String> dfs = dfs(digits, 0, digits.length());
        return dfs;
    }

    /**
     * [start,end)
     * @param digits
     * @param start
     * @param end
     */
    public List<String> dfs(String digits, int start, int end) {
        List<String> res = new ArrayList<>();
        if (start >= end) return res;

        int cur = digits.charAt(start) - '0';
        List<String> afterRes = dfs(digits, start + 1, end);

        char[] chars = letterMap.get(cur);
        for (char c : chars) {

            if (afterRes.size() == 0) res.add(String.valueOf(c));

            for (String s : afterRes) {
                StringBuilder builder = new StringBuilder();
                builder.append(c);
                builder.append(s);
                res.add(builder.toString());
            }
        }

        return res;
    }

    @Test
    public void Test() {
        letterCombinations("");
    }
}
