package leetcode.dfs;

import org.junit.Test;

import java.util.*;

public class P301_Remove_Invalid_Parentheses {


    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {

        int lRemove = 0;
        int rRemove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (lRemove > 0) {
                    lRemove--;
                } else {
                    rRemove++;
                }
            } else if (s.charAt(i) == '(') {
                lRemove++;
            }
        }
        dfs(s, 0, lRemove, rRemove);

        List<String> res = new ArrayList<>(set);
        return res;
    }

    public void dfs(String s, int start, int lRemove, int rRemove) {
        if (isValid(s)) {
            set.add(s);
            return;
        }

        if (lRemove == 0 && rRemove == 0) {
            return;
        }

        if (lRemove + rRemove > s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {

            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            String s1 = s.substring(0, i) + s.substring(i + 1);
            if (s.charAt(i) == '(' && lRemove > 0) {
                dfs(s1, i, lRemove - 1, rRemove);
            }

            if (s.charAt(i) == ')' && rRemove > 0) {
                dfs(s1, i, lRemove, rRemove - 1);
            }
        }
    }

    public boolean isValid(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (cnt > 0) {
                    cnt--;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '(') {
                cnt++;
            }
        }

        return cnt == 0;
    }

    @Test
    public void test() {
        removeInvalidParentheses("()())()");
    }

    public static void main(String[] args) {
        String a = "0123456";
        System.out.println(a.substring(0,1));
    }
}
