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

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);

        int n = s.length();
        //表示长度为n的字符串，是不是可以在wordBreak函数中返回true

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            //j表示的索引，[j,i)
            for (int j = i - 1; j >= 0; j--) {
                if (wordSet.contains(s.substring(j, i))) {
                    dp[i] |= dp[j];
                    //这个语句有点东西，直接战胜一大堆人
                    if(dp[i]) break;
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
