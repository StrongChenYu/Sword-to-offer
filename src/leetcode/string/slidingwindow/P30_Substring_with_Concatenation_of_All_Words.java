package leetcode.string.slidingwindow;

import org.junit.Test;

import java.util.*;

public class P30_Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        //boundary
        if (s == null || s.length() == 0) return res;
        if (words == null || words.length == 0) return res;

        Map<String, Integer> need = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        int wordLength = words[0].length();

        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int match = 0;

        while (right <= s.length() - wordLength) {
            String sub = s.substring(right, right + wordLength);
            window.put(sub, window.getOrDefault(sub, 0) + 1);
            right += wordLength;

            if (!need.containsKey(sub)) {
                //不等于
                left++;
                right = left;
                match = 0;
                window.clear();
            } else {
                if (window.get(sub) > need.get(sub)) {
                    //多余
                    left++;
                    match = 0;
                    right = left;
                    window.clear();
                } else if (window.get(sub).equals(need.get(sub))){
                    //部分等于
                    match++;
                    if (match == need.size()) {
                        //完全等于
                        res.add(left);
                        left++;
                        right = left;
                        match = 0;
                        window.clear();
                    }
                }
            }

        }

        return res;
    }

    //condition3
    public boolean checkNotEqual(Map<String, Integer> window, Map<String, Integer> need) {
        Set<String> strings = window.keySet();
        for (String string : strings) {

            //不等于
            if (!need.containsKey(string)) {
                return true;
            }

            //多余
            if (window.get(string) > need.get(string)) {
                return true;
            }
        }
        return false;
    }

    //condition2
    public boolean checkNotFullEqual(Map<String, Integer> window, Map<String, Integer> need) {
        Set<String> strings = window.keySet();
        for (String string : strings) {
            if (!need.containsKey(string)) {
                return false;
            }

            if (window.get(string) > need.get(string)) {
                return false;
            }
        }
        return true;
    }

    //condition1
    public boolean checkFullEqual(Map<String, Integer> window, Map<String, Integer> need) {
        if (window.size() != need.size()) {
            return false;
        }

        Set<String> strings = need.keySet();
        for (String string : strings) {
            if (!window.containsKey(string)) {
                return false;
            }

            if (window.get(string).compareTo(need.get(string)) != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
        System.out.println(findSubstring("aaaaaaaaaaaaaa", new String[]{"aa","aa"}));
        System.out.println(findSubstring("aaaaa", new String[]{"aa","aa"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(findSubstring("aaaaaa", new String[]{"a","a","a","a","a","a"}));
    }

    public static void main(String[] args) {
        Integer a = 100000;
        Integer b = 100001;
        System.out.println(a < b);
        System.out.println("12".substring(0,5));
    }
}
