package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author Chen Yu
 * @Date 2021/4/7 9:06
 */
public class P20_Valid_Parentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char top = stack.pop();

                if (cur == ')' && top != '(') return false;
                if (cur == ']' && top != '[') return false;
                if (cur == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void Test() {
        Assert.assertFalse(isValid("()[]{}))))))"));
        Assert.assertFalse(isValid("("));
        Assert.assertFalse(isValid("}"));
    }
}
