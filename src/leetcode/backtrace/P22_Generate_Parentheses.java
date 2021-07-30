package leetcode.backtrace;

import org.junit.Test;

import java.util.*;

public class P22_Generate_Parentheses {


    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n + 1];
        dp[0] = Arrays.asList("");
        dp[1] = Arrays.asList("()");

        for (int i = 2; i <= n; i++) {
            List<String> solution = new ArrayList<>();
            for (int j = 0; j <= i - 1; j++) {

                List<String> middles = dp[j];
                List<String> rights = dp[i - 1 - j];

                for (String middle : middles) {
                    for (String right : rights) {
                        solution.add("(" + middle + ")" + right);
                    }
                }
            }
            dp[i] = solution;
        }

        return dp[n];
    }

    @Test
    public void Test() {
        System.out.println(generateParenthesis(4).size());
    }
}
