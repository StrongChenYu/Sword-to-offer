package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Author Chen Yu
 * @Date 2021/4/13 9:00
 */
public class P140_Word_Break_II {

    Set<String> wordSet = new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet.addAll(wordDict);
        List<String> res = wordBreak(s);
        return res;
    }

    /**
     * @param s
     * @return
     */
    public List<String> wordBreak(String s) {
        List<String> res = new ArrayList<>();
        if (wordSet.contains(s)) {
            res.add(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (wordSet.contains(word)) {
                List<String> rightRes = wordBreak(s.substring(i));

                for (String item : rightRes) {
                    res.add(word + " " + item);
                }
            }
        }

        return res;
    }

    @Test
    public void Test() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        wordBreak("leetcodecodecode", wordDict);
    }

}
