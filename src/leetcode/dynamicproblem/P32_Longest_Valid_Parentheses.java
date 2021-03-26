package leetcode.dynamicproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/3/24 8:22
 */
public class P32_Longest_Valid_Parentheses {

    /**
     * 事实证明当想的复杂的时候一般都会出问题
     * @param s
     * @return
     */
//    class Status{
//        public int max;
//        public int left;
//        public int right;
//
//        public Status(int max) {
//            this.max = max;
//            this.left = -1;
//            this.right = -1;
//        }
//        public Status(int max, int left, int right) {
//            this.left = left;
//            this.right = right;
//            this.max = max;
//        }
//    }

//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() <= 0) return 0;
//
//        int n = s.length();
//        Status[][] dp = new Status[n][n];
//
//        for (int subLen = 1; subLen <= n; subLen++) {
//            for (int i = 0; i + subLen <= n; i++) {
//                /**
//                 * i是子字符串的首端 首索引
//                 * j是字符串的末端 末索引
//                 */
//                int j = i + subLen - 1;
//
//                if (subLen == 1) {
//                    dp[i][j] = new Status(0);
//                    System.out.printf("%d - %d is %d\n", i, j, dp[i][j].max);
//                } else if (subLen == 2 && s.charAt(i) == '(' && s.charAt(j) == ')') {
//                    dp[i][j] = new Status(2, i, j);
//                    System.out.printf("%d - %d is %d\n", i, j, dp[i][j].max);
//                } else {
//                    /**
//                     * 其他情况
//                     * 1. 字符串长度为2，但是不是()这种形式
//                     * 2. 字符串长度大于2
//                     */
//
//                    //四种情况
//                    Status tempMax = new Status(0);
//
//                    /**
//                     * ( sub )
//                     */
//                    if (s.charAt(i) == '(' && s.charAt(j) == ')' && dp[i + 1][j - 1] != null) {
//                        if (validBoundary(dp[i + 1][j - 1], i + 1, j - 1)) {
//                            tempMax = max(new Status(dp[i + 1][j - 1].max + 2, i, j), tempMax);
//                        }
//                    }
//
//                    /**
//                     * sub()
//                     */
//                    if (j >= 2 && dp[i][j - 2] != null && dp[j - 1][j].max == 2) {
//                        if (validBoundary(dp[i][j - 2], i, j - 2))
//                        tempMax = max(new Status(dp[i][j - 2].max + 2,i, j), tempMax);
//                    }
//
//                    /**
//                     * ()sub
//                     */
//                    if (i + 2 < n && dp[i][i + 1] != null && dp[i][i + 1].max == 2) {
//                        if (validBoundary(dp[i + 2][j], i + 2, j))
//                            tempMax = max(new Status(dp[i + 2][j].max + 2,i, j), tempMax);
//                    }
//
//                    /**
//                     * 上述都不满足
//                     */
//                    if (dp[i][j - 1] != null) tempMax = max(tempMax, dp[i][j - 1]);
//                    if (dp[i + 1][j] != null) tempMax = max(dp[i + 1][j], tempMax);
//                    //if (dp[i + 1][j - 1] != null) tempMax = max(dp[i + 1][j - 1], tempMax);
//                    dp[i][j] = tempMax;
//                    System.out.printf("%d - %d is %d\n", i, j, dp[i][j].max);
//                }
//
//            }
//
//        }

    public int longestValidParentheses_DP(String s) {

        int n = s.length();
        int[] dp = new int[n];
        int res = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0)+ 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    //s.charAt(i - 1) = ')'
                    int preIndex = i - dp[i - 1] - 2;
                    dp[i] = dp[i - 1] + (preIndex >= 0 ? dp[preIndex] : 0) + 2;
                }
                System.out.println("0 - " + i + ": " + dp[i]);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    @Test
    public void Test() {
        Assert.assertEquals(longestValidParentheses("()()"), 4);
        Assert.assertEquals(longestValidParentheses("(()"), 2);
        Assert.assertEquals(longestValidParentheses(""), 0);
        Assert.assertEquals(longestValidParentheses("()()()()(((((()"), 8);
        Assert.assertEquals(longestValidParentheses("()()()()((((((())))))"), 12);
        Assert.assertEquals(longestValidParentheses(")(((((()())()()))()(()))("), 22);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //如果当前值是右括号')'
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(), max);
                }
            }
        }

        return max;
    }
}
