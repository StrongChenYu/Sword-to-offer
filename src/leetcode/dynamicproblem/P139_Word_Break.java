package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Chen Yu
 * @Date 2021/4/13 8:31
 */
public class P139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            // 表示以i结尾的单词
            for (int j = 0; j <= i; j++) {
                //[j, i)
//                System.out.println("start: " + j + " end: " + i + " len: " + len);
                String rightStr = s.substring(j, i);
                System.out.println(rightStr);
                if (wordSet.contains(rightStr)) {
                    dp[i] |= dp[j];
                }
            }
        }


        return dp[n];
    }

    @Test
    public void Test() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        Assert.assertTrue(wordBreak("leetcode", wordDict));
        Assert.assertTrue(wordBreak("leetcodecodecode", wordDict));
        Assert.assertTrue(wordBreak("leetcodeleetcode", wordDict));
        Assert.assertTrue(wordBreak("", wordDict));
        Assert.assertTrue(wordBreak("leet", wordDict));


    }
}
