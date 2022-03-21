package leetcode.bfs;

import org.junit.Test;

import java.util.*;

public class P301_Remove_Invalid_Parentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> bfsMem = new HashSet<>();

        bfsMem.add(s);

        while (true) {
            for (String s1 : bfsMem) {
                if (isValid(s1)) {
                    res.add(s1);
                }
            }

            if (res.size() > 0) {
                break;
            }

            Set<String> newSet = new HashSet<>();
            for (String s1 : bfsMem) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == '(' || s1.charAt(i) == ')') {
                        newSet.add(s1.substring(0, i) + s1.substring(i + 1));
                    }
                }
            }

            bfsMem = newSet;
        }

        return res;
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
}
